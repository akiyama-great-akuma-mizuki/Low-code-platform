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
public class Eventtest {
	@Mock
	public EventDAO eventdao;

	@Mock
	public EventSimpleMapper eventSimpleMapper;

	@Mock
	public Event event;

	@Mock
	public EventFilterMapper eventfilterMapper;

	@InjectMocks
	public EventService eventService;

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
        EventDO eventdo = new EventDO();
        eventdo.setId(testid);
        Mockito.when(eventdao.selectByPrimaryKey(testid)).thenReturn(eventdo);
        Assert.assertEquals(eventService.getByPK(testid).getId(), testid, "不相等");
	}

	@Test(groups = "getGet", dependsOnMethods = "getByPKTest")
	public void getSimpleMapByPKTest()
	{
		String testid = mockParams.get("id").toString();
        Map<String, Object> res = eventSimpleMapper.buildMap(eventService.getByPK(testid));
       Assert.assertEquals(eventService.getSimpleMapByPK(testid), res, "getSimpleMapByPK不相等");
	}

	@Test(groups = "groupGet", dependsOnMethods = "getByPKTest")
	public void getDetailMapByPKTestIsNull()
	{
		String testid = "1";
        Mockito.when(eventService.getByPK(testid)).thenReturn(null);
        Assert.assertEquals(null, eventService.getDetailMapByPK(testid), "异常");
	}

	@Test(groups = "groupGet")
	public void getCountByFilterTest()
	{
		        Long count = 0L;
        Mockito.doReturn(mockParams).when(eventfilterMapper).buildMap();
        EventDOExample example = EventFilter.initDOQueryFilter(mockParams);
        Mockito.doReturn(count).when(eventdao).countByExample(example);
        Assert.assertEquals(count, eventService.getCountByFilter(eventfilterMapper), "异常");

	}

	@Test(groups = "groupGet")
	public void getListByFilterTest()
	{
		List<Event> entityList = new ArrayList<>();
        Mockito.doReturn(mockParams).when(eventfilterMapper).buildMap();
        EventDOExample example = EventFilter.initDOQueryFilter(mockParams);

        List<Event> res = Mockito.mock(List.class);
        Mockito.doReturn(res).when(eventdao).selectByExample(example);
        Iterator iteratorMock = Mockito.mock(Iterator.class);
        Mockito.when(res.iterator()).thenReturn(iteratorMock);
        Mockito.when(iteratorMock.hasNext()).thenReturn(true, false);
        Mockito.when(iteratorMock.next()).thenReturn(entityList);
        Assert.assertEquals(entityList, eventService.getListByFilter(eventfilterMapper), "异常");
	}

	@Test(groups = "groupGet", dependsOnMethods = "getListByFilterTest")
	public void getFilterMapListTest()
	{
		List<Map<String, Object>> entityMapList = new ArrayList<>();
        List<Event> t1 = Mockito.mock(ArrayList.class);
        List<Event> t2 = null;
        Mockito.when(eventService.getListByFilter(eventfilterMapper)).thenReturn(t1);
        Mockito.doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocationOnMock) throws Throwable {
                Object argument = invocationOnMock.getArgument(0);
                Event.class.getDeclaredMethod("accept", Event.class).invoke(argument, 1);
                return argument;
            }
        }).when(t1).forEach(entity -> entityMapList.add(EventSimpleMapper.buildMap(entity)));
        Assert.assertEquals(entityMapList, eventService.getFilterMapList(eventfilterMapper), "异常");
	}

	@Test(groups = "groupPost", dependsOnMethods = "getByPKTest", expectedExceptions = StatusException.class)
	public void postTestException()
	{
		StatusException e = new StatusException("POST_ENTITY_DUPLICATE");
        event = new Event();
        Mockito.when(eventdao.insertSelective(EventData.convert(event, new EventDO()))).thenThrow(e);
        Event res = eventService.post(event);
        throw e;
	}

	@Test(groups = "groupPost", dependsOnMethods = "getByPKTest")
	public void postTest()
	{
		 Event test = new  Event();
 Event spyEvent = Mockito.spy(test);
        Mockito.when(eventdao.insertSelective(EventData.convert(test, new EventDO()))).thenReturn(1);
        Event res = eventService.post(test);
	}

	@Test(groups = "groupUpadte", dependsOnMethods = "getByPKTest", expectedExceptions = NullPointerException.class)
	public void updateTest()
	{
		int actual = 1;
        Mockito.when(eventdao.updateByPrimaryKeySelective(EventData.convert(event, new EventDO()))).thenReturn(1);
        Assert.assertEquals(actual, eventdao.updateByPrimaryKeySelective(EventData.convert(event, new EventDO())), "不相等");

	}

	@Test(groups = "groupPut", dependsOnMethods = "getByPKTest")
	public void putTestIsNull()
	{
		Event putEntity=new Event();
        putEntity.setId("1");
        Object actual=null;
        Mockito.when(eventService.getByPK(putEntity.getId())).thenReturn(null);
        Mockito.when(eventdao.insertSelective(EventData.convert(putEntity, new EventDO()))).thenReturn(1);
        Assert.assertEquals(actual,eventService.put(putEntity),"不相等");
	}

	@Test(groups = "groupDelete")
	public void deleteTest()
	{
		String testid = "1";
        AtomicInteger count = new AtomicInteger();
        Mockito.when(count.addAndGet(eventdao.deleteByPrimaryKey(testid))).thenReturn(1);
        int actual = eventService.delete(testid);
        Assert.assertEquals(actual, 1, "不相等");
	}

	@Test(groups = "groupGet", dependsOnMethods = "getCountByFilterTest")
	public void getRateAndCountByFilterTest()
	{
		Map<String, Map<String, Object>> res = new HashMap<>();
        List<String> groupBy = Mockito.mock(List.class);
        res = eventService.getFilterListGroup(eventfilterMapper, groupBy);
        Assert.assertEquals(res.size(), 0, "不相等");
	}

}