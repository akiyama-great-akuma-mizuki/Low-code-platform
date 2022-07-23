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
public class ScheduleItemtest {
	@Mock
	public ScheduleItemDAO scheduleitemdao;

	@Mock
	public ScheduleItemSimpleMapper scheduleitemSimpleMapper;

	@Mock
	public ScheduleItem scheduleitem;

	@Mock
	public ScheduleItemFilterMapper scheduleitemfilterMapper;

	@InjectMocks
	public ScheduleItemService scheduleitemService;

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
        ScheduleItemDO scheduleitemdo = new ScheduleItemDO();
        scheduleitemdo.setId(testid);
        Mockito.when(scheduleitemdao.selectByPrimaryKey(testid)).thenReturn(scheduleitemdo);
        Assert.assertEquals(scheduleitemService.getByPK(testid).getId(), testid, "不相等");
	}

	@Test(groups = "getGet", dependsOnMethods = "getByPKTest")
	public void getSimpleMapByPKTest()
	{
		String testid = mockParams.get("id").toString();
        Map<String, Object> res = scheduleitemSimpleMapper.buildMap(scheduleitemService.getByPK(testid));
       Assert.assertEquals(scheduleitemService.getSimpleMapByPK(testid), res, "getSimpleMapByPK不相等");
	}

	@Test(groups = "groupGet", dependsOnMethods = "getByPKTest")
	public void getDetailMapByPKTestIsNull()
	{
		String testid = "1";
        Mockito.when(scheduleitemService.getByPK(testid)).thenReturn(null);
        Assert.assertEquals(null, scheduleitemService.getDetailMapByPK(testid), "异常");
	}

	@Test(groups = "groupGet")
	public void getCountByFilterTest()
	{
		        Long count = 0L;
        Mockito.doReturn(mockParams).when(scheduleitemfilterMapper).buildMap();
        ScheduleItemDOExample example = ScheduleItemFilter.initDOQueryFilter(mockParams);
        Mockito.doReturn(count).when(scheduleitemdao).countByExample(example);
        Assert.assertEquals(count, scheduleitemService.getCountByFilter(scheduleitemfilterMapper), "异常");

	}

	@Test(groups = "groupGet")
	public void getListByFilterTest()
	{
		List<ScheduleItem> entityList = new ArrayList<>();
        Mockito.doReturn(mockParams).when(scheduleitemfilterMapper).buildMap();
        ScheduleItemDOExample example = ScheduleItemFilter.initDOQueryFilter(mockParams);

        List<ScheduleItem> res = Mockito.mock(List.class);
        Mockito.doReturn(res).when(scheduleitemdao).selectByExample(example);
        Iterator iteratorMock = Mockito.mock(Iterator.class);
        Mockito.when(res.iterator()).thenReturn(iteratorMock);
        Mockito.when(iteratorMock.hasNext()).thenReturn(true, false);
        Mockito.when(iteratorMock.next()).thenReturn(entityList);
        Assert.assertEquals(entityList, scheduleitemService.getListByFilter(scheduleitemfilterMapper), "异常");
	}

	@Test(groups = "groupGet", dependsOnMethods = "getListByFilterTest")
	public void getFilterMapListTest()
	{
		List<Map<String, Object>> entityMapList = new ArrayList<>();
        List<ScheduleItem> t1 = Mockito.mock(ArrayList.class);
        List<ScheduleItem> t2 = null;
        Mockito.when(scheduleitemService.getListByFilter(scheduleitemfilterMapper)).thenReturn(t1);
        Mockito.doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocationOnMock) throws Throwable {
                Object argument = invocationOnMock.getArgument(0);
                ScheduleItem.class.getDeclaredMethod("accept", ScheduleItem.class).invoke(argument, 1);
                return argument;
            }
        }).when(t1).forEach(entity -> entityMapList.add(ScheduleItemSimpleMapper.buildMap(entity)));
        Assert.assertEquals(entityMapList, scheduleitemService.getFilterMapList(scheduleitemfilterMapper), "异常");
	}

	@Test(groups = "groupPost", dependsOnMethods = "getByPKTest", expectedExceptions = StatusException.class)
	public void postTestException()
	{
		StatusException e = new StatusException("POST_ENTITY_DUPLICATE");
        scheduleitem = new ScheduleItem();
        Mockito.when(scheduleitemdao.insertSelective(ScheduleItemData.convert(scheduleitem, new ScheduleItemDO()))).thenThrow(e);
        ScheduleItem res = scheduleitemService.post(scheduleitem);
        throw e;
	}

	@Test(groups = "groupPost", dependsOnMethods = "getByPKTest")
	public void postTest()
	{
		 ScheduleItem test = new  ScheduleItem();
 ScheduleItem spyScheduleItem = Mockito.spy(test);
        Mockito.when(scheduleitemdao.insertSelective(ScheduleItemData.convert(test, new ScheduleItemDO()))).thenReturn(1);
        ScheduleItem res = scheduleitemService.post(test);
	}

	@Test(groups = "groupUpadte", dependsOnMethods = "getByPKTest", expectedExceptions = NullPointerException.class)
	public void updateTest()
	{
		int actual = 1;
        Mockito.when(scheduleitemdao.updateByPrimaryKeySelective(ScheduleItemData.convert(scheduleitem, new ScheduleItemDO()))).thenReturn(1);
        Assert.assertEquals(actual, scheduleitemdao.updateByPrimaryKeySelective(ScheduleItemData.convert(scheduleitem, new ScheduleItemDO())), "不相等");

	}

	@Test(groups = "groupPut", dependsOnMethods = "getByPKTest")
	public void putTestIsNull()
	{
		ScheduleItem putEntity=new ScheduleItem();
        putEntity.setId("1");
        Object actual=null;
        Mockito.when(scheduleitemService.getByPK(putEntity.getId())).thenReturn(null);
        Mockito.when(scheduleitemdao.insertSelective(ScheduleItemData.convert(putEntity, new ScheduleItemDO()))).thenReturn(1);
        Assert.assertEquals(actual,scheduleitemService.put(putEntity),"不相等");
	}

	@Test(groups = "groupDelete")
	public void deleteTest()
	{
		String testid = "1";
        AtomicInteger count = new AtomicInteger();
        Mockito.when(count.addAndGet(scheduleitemdao.deleteByPrimaryKey(testid))).thenReturn(1);
        int actual = scheduleitemService.delete(testid);
        Assert.assertEquals(actual, 1, "不相等");
	}

	@Test(groups = "groupGet", dependsOnMethods = "getCountByFilterTest")
	public void getRateAndCountByFilterTest()
	{
		Map<String, Map<String, Object>> res = new HashMap<>();
        List<String> groupBy = Mockito.mock(List.class);
        res = scheduleitemService.getFilterListGroup(scheduleitemfilterMapper, groupBy);
        Assert.assertEquals(res.size(), 0, "不相等");
	}

}