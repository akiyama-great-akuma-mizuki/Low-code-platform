package com.code.testCore.test;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.horsecoder.common.status.StatusException;
import com.AppStarter;
import com.horsecoder.yulinOA.sys.datafilter.*;
import com.horsecoder.yulinOA.sys.datainterface.*;
import com.horsecoder.yulinOA.sys.dataobject.*;
import com.horsecoder.yulinOA.sys.model.*;
import com.horsecoder.yulinOA.sys.service.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import redis.clients.jedis.Jedis;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
@SpringBootTest(classes = AppStarter.class)
public class CustomScheduletest {
	@Mock
	public CustomScheduleDAO customscheduledao;

	@Mock
	public CustomScheduleSimpleMapper customscheduleSimpleMapper;

	@Mock
	public CustomSchedule customschedule;

	@Mock
	public CustomScheduleFilterMapper customschedulefilterMapper;

	@InjectMocks
	public CustomScheduleService customscheduleService;

	public List<Map<String, Object>> carList;

	public Map<String, Object> mockParams;


	@BeforeTest(alwaysRun = true)
	public void beforeTest()
	{
		MockitoAnnotations.initMocks(this);
        String test =this.getClass().getName();
        String id=prepareData(test);
	}

	
	public String prepareData(String key)
	{
		System.out.println(key);
        return key;
	}

	
	public static List<Map<String, Object>> loadData(String key)
	{
		        Jedis jedis = new Jedis("127.0.0.1", 6379);
        ObjectMapper objectMapper = new ObjectMapper();
        long len = jedis.llen(key);
        List<Map<String, Object>> Objs = new ArrayList<>();
        try {
            while (len-- > 0) {
                Map map = objectMapper.readValue(jedis.lpop(key), Map.class);
                Objs.add(map);
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } finally {
            jedis.close();
            return Objs;
        }
	}

	@Test(groups = "groupGet")
	public void getByPKTest()
	{
		String testid = "1";
        CustomScheduleDO customscheduledo = new CustomScheduleDO();
        customscheduledo.setId(testid);
        Mockito.when(customscheduledao.selectByPrimaryKey(testid)).thenReturn(customscheduledo);
        Assert.assertEquals(customscheduleService.getByPK(testid).getId(), testid, "不相等");
	}

	@Test(groups = "getGet", dependsOnMethods = "getByPKTest")
	public void getSimpleMapByPKTest()
	{
		String testid = mockParams.get("id").toString();
        Map<String, Object> res = customscheduleSimpleMapper.buildMap(customscheduleService.getByPK(testid));
       Assert.assertEquals(customscheduleService.getSimpleMapByPK(testid), res, "getSimpleMapByPK不相等");
	}

	@Test(groups = "groupGet", dependsOnMethods = "getByPKTest")
	public void getDetailMapByPKTestIsNull()
	{
		String testid = "1";
        Mockito.when(customscheduleService.getByPK(testid)).thenReturn(null);
        Assert.assertEquals(null, customscheduleService.getDetailMapByPK(testid), "异常");
	}

	@Test(groups = "groupGet")
	public void getCountByFilterTest()
	{
		        Long count = 0L;
        Mockito.doReturn(mockParams).when(customschedulefilterMapper).buildMap();
        CustomScheduleDOExample example = CustomScheduleFilter.initDOQueryFilter(mockParams);
        Mockito.doReturn(count).when(customscheduledao).countByExample(example);
        Assert.assertEquals(count, customscheduleService.getCountByFilter(customschedulefilterMapper), "异常");

	}

	@Test(groups = "groupGet")
	public void getListByFilterTest()
	{
		List<CustomSchedule> entityList = new ArrayList<>();
        Mockito.doReturn(mockParams).when(customschedulefilterMapper).buildMap();
        CustomScheduleDOExample example = CustomScheduleFilter.initDOQueryFilter(mockParams);

        List<CustomSchedule> res = Mockito.mock(List.class);
        Mockito.doReturn(res).when(customscheduledao).selectByExample(example);
        Iterator iteratorMock = Mockito.mock(Iterator.class);
        Mockito.when(res.iterator()).thenReturn(iteratorMock);
        Mockito.when(iteratorMock.hasNext()).thenReturn(true, false);
        Mockito.when(iteratorMock.next()).thenReturn(entityList);
        Assert.assertEquals(entityList, customscheduleService.getListByFilter(customschedulefilterMapper), "异常");
	}

	@Test(groups = "groupGet", dependsOnMethods = "getListByFilterTest")
	public void getFilterMapListTest()
	{
		List<Map<String, Object>> entityMapList = new ArrayList<>();
        List<CustomSchedule> t1 = Mockito.mock(ArrayList.class);
        List<CustomSchedule> t2 = null;
        Mockito.when(customscheduleService.getListByFilter(customschedulefilterMapper)).thenReturn(t1);
        Mockito.doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocationOnMock) throws Throwable {
                Object argument = invocationOnMock.getArgument(0);
                CustomSchedule.class.getDeclaredMethod("accept", CustomSchedule.class).invoke(argument, 1);
                return argument;
            }
        }).when(t1).forEach(entity -> entityMapList.add(CustomScheduleSimpleMapper.buildMap(entity)));
        Assert.assertEquals(entityMapList, customscheduleService.getFilterMapList(customschedulefilterMapper), "异常");
	}

	@Test(groups = "groupPost", dependsOnMethods = "getByPKTest", expectedExceptions = StatusException.class)
	public void postTestException()
	{
		StatusException e = new StatusException("POST_ENTITY_DUPLICATE");
        customschedule = new CustomSchedule();
        Mockito.when(customscheduledao.insertSelective(CustomScheduleData.convert(customschedule, new CustomScheduleDO()))).thenThrow(e);
        CustomSchedule res = customscheduleService.post(customschedule);
        throw e;
	}

	@Test(groups = "groupPost", dependsOnMethods = "getByPKTest")
	public void postTest()
	{
		 CustomSchedule test = new  CustomSchedule();
 CustomSchedule spyCustomSchedule = Mockito.spy(test);
        Mockito.when(customscheduledao.insertSelective(CustomScheduleData.convert(test, new CustomScheduleDO()))).thenReturn(1);
        CustomSchedule res = customscheduleService.post(test);
	}

	@Test(groups = "groupUpadte", dependsOnMethods = "getByPKTest", expectedExceptions = NullPointerException.class)
	public void updateTest()
	{
		int actual = 1;
        Mockito.when(customscheduledao.updateByPrimaryKeySelective(CustomScheduleData.convert(customschedule, new CustomScheduleDO()))).thenReturn(1);
        Assert.assertEquals(actual, customscheduledao.updateByPrimaryKeySelective(CustomScheduleData.convert(customschedule, new CustomScheduleDO())), "不相等");

	}

	@Test(groups = "groupPut", dependsOnMethods = "getByPKTest")
	public void putTestIsNull()
	{
		CustomSchedule putEntity=new CustomSchedule();
        putEntity.setId("1");
        Object actual=null;
        Mockito.when(customscheduleService.getByPK(putEntity.getId())).thenReturn(null);
        Mockito.when(customscheduledao.insertSelective(CustomScheduleData.convert(putEntity, new CustomScheduleDO()))).thenReturn(1);
        Assert.assertEquals(actual,customscheduleService.put(putEntity),"不相等");
	}

	@Test(groups = "groupDelete")
	public void deleteTest()
	{
		String testid = "1";
        AtomicInteger count = new AtomicInteger();
        Mockito.when(count.addAndGet(customscheduledao.deleteByPrimaryKey(testid))).thenReturn(1);
        int actual = customscheduleService.delete(testid);
        Assert.assertEquals(actual, 1, "不相等");
	}

	@Test(groups = "groupGet", dependsOnMethods = "getCountByFilterTest")
	public void getRateAndCountByFilterTest()
	{
		Map<String, Map<String, Object>> res = new HashMap<>();
        List<String> groupBy = Mockito.mock(List.class);
        res = customscheduleService.getFilterListGroup(customschedulefilterMapper, groupBy);
        Assert.assertEquals(res.size(), 0, "不相等");
	}

}