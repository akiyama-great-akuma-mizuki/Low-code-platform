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
public class Scheduletest {
	@Mock
	public ScheduleDAO scheduledao;

	@Mock
	public ScheduleSimpleMapper scheduleSimpleMapper;

	@Mock
	public Schedule schedule;

	@Mock
	public ScheduleFilterMapper schedulefilterMapper;

	@InjectMocks
	public ScheduleService scheduleService;

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
        ScheduleDO scheduledo = new ScheduleDO();
        scheduledo.setId(testid);
        Mockito.when(scheduledao.selectByPrimaryKey(testid)).thenReturn(scheduledo);
        Assert.assertEquals(scheduleService.getByPK(testid).getId(), testid, "不相等");
	}

	@Test(groups = "getGet", dependsOnMethods = "getByPKTest")
	public void getSimpleMapByPKTest()
	{
		String testid = mockParams.get("id").toString();
        Map<String, Object> res = scheduleSimpleMapper.buildMap(scheduleService.getByPK(testid));
       Assert.assertEquals(scheduleService.getSimpleMapByPK(testid), res, "getSimpleMapByPK不相等");
	}

	@Test(groups = "groupGet", dependsOnMethods = "getByPKTest")
	public void getDetailMapByPKTestIsNull()
	{
		String testid = "1";
        Mockito.when(scheduleService.getByPK(testid)).thenReturn(null);
        Assert.assertEquals(null, scheduleService.getDetailMapByPK(testid), "异常");
	}

	@Test(groups = "groupGet")
	public void getCountByFilterTest()
	{
		        Long count = 0L;
        Mockito.doReturn(mockParams).when(schedulefilterMapper).buildMap();
        ScheduleDOExample example = ScheduleFilter.initDOQueryFilter(mockParams);
        Mockito.doReturn(count).when(scheduledao).countByExample(example);
        Assert.assertEquals(count, scheduleService.getCountByFilter(schedulefilterMapper), "异常");

	}

	@Test(groups = "groupGet")
	public void getListByFilterTest()
	{
		List<Schedule> entityList = new ArrayList<>();
        Mockito.doReturn(mockParams).when(schedulefilterMapper).buildMap();
        ScheduleDOExample example = ScheduleFilter.initDOQueryFilter(mockParams);

        List<Schedule> res = Mockito.mock(List.class);
        Mockito.doReturn(res).when(scheduledao).selectByExample(example);
        Iterator iteratorMock = Mockito.mock(Iterator.class);
        Mockito.when(res.iterator()).thenReturn(iteratorMock);
        Mockito.when(iteratorMock.hasNext()).thenReturn(true, false);
        Mockito.when(iteratorMock.next()).thenReturn(entityList);
        Assert.assertEquals(entityList, scheduleService.getListByFilter(schedulefilterMapper), "异常");
	}

	@Test(groups = "groupGet", dependsOnMethods = "getListByFilterTest")
	public void getFilterMapListTest()
	{
		List<Map<String, Object>> entityMapList = new ArrayList<>();
        List<Schedule> t1 = Mockito.mock(ArrayList.class);
        List<Schedule> t2 = null;
        Mockito.when(scheduleService.getListByFilter(schedulefilterMapper)).thenReturn(t1);
        Mockito.doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocationOnMock) throws Throwable {
                Object argument = invocationOnMock.getArgument(0);
                Schedule.class.getDeclaredMethod("accept", Schedule.class).invoke(argument, 1);
                return argument;
            }
        }).when(t1).forEach(entity -> entityMapList.add(ScheduleSimpleMapper.buildMap(entity)));
        Assert.assertEquals(entityMapList, scheduleService.getFilterMapList(schedulefilterMapper), "异常");
	}

	@Test(groups = "groupPost", dependsOnMethods = "getByPKTest", expectedExceptions = StatusException.class)
	public void postTestException()
	{
		StatusException e = new StatusException("POST_ENTITY_DUPLICATE");
        schedule = new Schedule();
        Mockito.when(scheduledao.insertSelective(ScheduleData.convert(schedule, new ScheduleDO()))).thenThrow(e);
        Schedule res = scheduleService.post(schedule);
        throw e;
	}

	@Test(groups = "groupPost", dependsOnMethods = "getByPKTest")
	public void postTest()
	{
		 Schedule test = new  Schedule();
 Schedule spySchedule = Mockito.spy(test);
        Mockito.when(scheduledao.insertSelective(ScheduleData.convert(test, new ScheduleDO()))).thenReturn(1);
        Schedule res = scheduleService.post(test);
	}

	@Test(groups = "groupUpadte", dependsOnMethods = "getByPKTest", expectedExceptions = NullPointerException.class)
	public void updateTest()
	{
		int actual = 1;
        Mockito.when(scheduledao.updateByPrimaryKeySelective(ScheduleData.convert(schedule, new ScheduleDO()))).thenReturn(1);
        Assert.assertEquals(actual, scheduledao.updateByPrimaryKeySelective(ScheduleData.convert(schedule, new ScheduleDO())), "不相等");

	}

	@Test(groups = "groupPut", dependsOnMethods = "getByPKTest")
	public void putTestIsNull()
	{
		Schedule putEntity=new Schedule();
        putEntity.setId("1");
        Object actual=null;
        Mockito.when(scheduleService.getByPK(putEntity.getId())).thenReturn(null);
        Mockito.when(scheduledao.insertSelective(ScheduleData.convert(putEntity, new ScheduleDO()))).thenReturn(1);
        Assert.assertEquals(actual,scheduleService.put(putEntity),"不相等");
	}

	@Test(groups = "groupDelete")
	public void deleteTest()
	{
		String testid = "1";
        AtomicInteger count = new AtomicInteger();
        Mockito.when(count.addAndGet(scheduledao.deleteByPrimaryKey(testid))).thenReturn(1);
        int actual = scheduleService.delete(testid);
        Assert.assertEquals(actual, 1, "不相等");
	}

	@Test(groups = "groupGet", dependsOnMethods = "getCountByFilterTest")
	public void getRateAndCountByFilterTest()
	{
		Map<String, Map<String, Object>> res = new HashMap<>();
        List<String> groupBy = Mockito.mock(List.class);
        res = scheduleService.getFilterListGroup(schedulefilterMapper, groupBy);
        Assert.assertEquals(res.size(), 0, "不相等");
	}

}