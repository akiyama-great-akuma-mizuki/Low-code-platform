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
public class EventTasktest {
	@Mock
	public EventTaskDAO eventtaskdao;

	@Mock
	public EventTaskSimpleMapper eventtaskSimpleMapper;

	@Mock
	public EventTask eventtask;

	@Mock
	public EventTaskFilterMapper eventtaskfilterMapper;

	@InjectMocks
	public EventTaskService eventtaskService;

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
        EventTaskDO eventtaskdo = new EventTaskDO();
        eventtaskdo.setId(testid);
        Mockito.when(eventtaskdao.selectByPrimaryKey(testid)).thenReturn(eventtaskdo);
        Assert.assertEquals(eventtaskService.getByPK(testid).getId(), testid, "不相等");
	}

	@Test(groups = "getGet", dependsOnMethods = "getByPKTest")
	public void getSimpleMapByPKTest()
	{
		String testid = mockParams.get("id").toString();
        Map<String, Object> res = eventtaskSimpleMapper.buildMap(eventtaskService.getByPK(testid));
       Assert.assertEquals(eventtaskService.getSimpleMapByPK(testid), res, "getSimpleMapByPK不相等");
	}

	@Test(groups = "groupGet", dependsOnMethods = "getByPKTest")
	public void getDetailMapByPKTestIsNull()
	{
		String testid = "1";
        Mockito.when(eventtaskService.getByPK(testid)).thenReturn(null);
        Assert.assertEquals(null, eventtaskService.getDetailMapByPK(testid), "异常");
	}

	@Test(groups = "groupGet")
	public void getCountByFilterTest()
	{
		        Long count = 0L;
        Mockito.doReturn(mockParams).when(eventtaskfilterMapper).buildMap();
        EventTaskDOExample example = EventTaskFilter.initDOQueryFilter(mockParams);
        Mockito.doReturn(count).when(eventtaskdao).countByExample(example);
        Assert.assertEquals(count, eventtaskService.getCountByFilter(eventtaskfilterMapper), "异常");

	}

	@Test(groups = "groupGet")
	public void getListByFilterTest()
	{
		List<EventTask> entityList = new ArrayList<>();
        Mockito.doReturn(mockParams).when(eventtaskfilterMapper).buildMap();
        EventTaskDOExample example = EventTaskFilter.initDOQueryFilter(mockParams);

        List<EventTask> res = Mockito.mock(List.class);
        Mockito.doReturn(res).when(eventtaskdao).selectByExample(example);
        Iterator iteratorMock = Mockito.mock(Iterator.class);
        Mockito.when(res.iterator()).thenReturn(iteratorMock);
        Mockito.when(iteratorMock.hasNext()).thenReturn(true, false);
        Mockito.when(iteratorMock.next()).thenReturn(entityList);
        Assert.assertEquals(entityList, eventtaskService.getListByFilter(eventtaskfilterMapper), "异常");
	}

	@Test(groups = "groupGet", dependsOnMethods = "getListByFilterTest")
	public void getFilterMapListTest()
	{
		List<Map<String, Object>> entityMapList = new ArrayList<>();
        List<EventTask> t1 = Mockito.mock(ArrayList.class);
        List<EventTask> t2 = null;
        Mockito.when(eventtaskService.getListByFilter(eventtaskfilterMapper)).thenReturn(t1);
        Mockito.doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocationOnMock) throws Throwable {
                Object argument = invocationOnMock.getArgument(0);
                EventTask.class.getDeclaredMethod("accept", EventTask.class).invoke(argument, 1);
                return argument;
            }
        }).when(t1).forEach(entity -> entityMapList.add(EventTaskSimpleMapper.buildMap(entity)));
        Assert.assertEquals(entityMapList, eventtaskService.getFilterMapList(eventtaskfilterMapper), "异常");
	}

	@Test(groups = "groupPost", dependsOnMethods = "getByPKTest", expectedExceptions = StatusException.class)
	public void postTestException()
	{
		StatusException e = new StatusException("POST_ENTITY_DUPLICATE");
        eventtask = new EventTask();
        Mockito.when(eventtaskdao.insertSelective(EventTaskData.convert(eventtask, new EventTaskDO()))).thenThrow(e);
        EventTask res = eventtaskService.post(eventtask);
        throw e;
	}

	@Test(groups = "groupPost", dependsOnMethods = "getByPKTest")
	public void postTest()
	{
		 EventTask test = new  EventTask();
 EventTask spyEventTask = Mockito.spy(test);
        Mockito.when(eventtaskdao.insertSelective(EventTaskData.convert(test, new EventTaskDO()))).thenReturn(1);
        EventTask res = eventtaskService.post(test);
	}

	@Test(groups = "groupUpadte", dependsOnMethods = "getByPKTest", expectedExceptions = NullPointerException.class)
	public void updateTest()
	{
		int actual = 1;
        Mockito.when(eventtaskdao.updateByPrimaryKeySelective(EventTaskData.convert(eventtask, new EventTaskDO()))).thenReturn(1);
        Assert.assertEquals(actual, eventtaskdao.updateByPrimaryKeySelective(EventTaskData.convert(eventtask, new EventTaskDO())), "不相等");

	}

	@Test(groups = "groupPut", dependsOnMethods = "getByPKTest")
	public void putTestIsNull()
	{
		EventTask putEntity=new EventTask();
        putEntity.setId("1");
        Object actual=null;
        Mockito.when(eventtaskService.getByPK(putEntity.getId())).thenReturn(null);
        Mockito.when(eventtaskdao.insertSelective(EventTaskData.convert(putEntity, new EventTaskDO()))).thenReturn(1);
        Assert.assertEquals(actual,eventtaskService.put(putEntity),"不相等");
	}

	@Test(groups = "groupDelete")
	public void deleteTest()
	{
		String testid = "1";
        AtomicInteger count = new AtomicInteger();
        Mockito.when(count.addAndGet(eventtaskdao.deleteByPrimaryKey(testid))).thenReturn(1);
        int actual = eventtaskService.delete(testid);
        Assert.assertEquals(actual, 1, "不相等");
	}

	@Test(groups = "groupGet", dependsOnMethods = "getCountByFilterTest")
	public void getRateAndCountByFilterTest()
	{
		Map<String, Map<String, Object>> res = new HashMap<>();
        List<String> groupBy = Mockito.mock(List.class);
        res = eventtaskService.getFilterListGroup(eventtaskfilterMapper, groupBy);
        Assert.assertEquals(res.size(), 0, "不相等");
	}

}