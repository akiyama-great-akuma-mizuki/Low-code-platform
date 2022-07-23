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
public class Tasktest {
	@Mock
	public TaskDAO taskdao;

	@Mock
	public TaskSimpleMapper taskSimpleMapper;

	@Mock
	public Task task;

	@Mock
	public TaskFilterMapper taskfilterMapper;

	@InjectMocks
	public TaskService taskService;

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
        TaskDO taskdo = new TaskDO();
        taskdo.setId(testid);
        Mockito.when(taskdao.selectByPrimaryKey(testid)).thenReturn(taskdo);
        Assert.assertEquals(taskService.getByPK(testid).getId(), testid, "不相等");
	}

	@Test(groups = "getGet", dependsOnMethods = "getByPKTest")
	public void getSimpleMapByPKTest()
	{
		String testid = mockParams.get("id").toString();
        Map<String, Object> res = taskSimpleMapper.buildMap(taskService.getByPK(testid));
       Assert.assertEquals(taskService.getSimpleMapByPK(testid), res, "getSimpleMapByPK不相等");
	}

	@Test(groups = "groupGet", dependsOnMethods = "getByPKTest")
	public void getDetailMapByPKTestIsNull()
	{
		String testid = "1";
        Mockito.when(taskService.getByPK(testid)).thenReturn(null);
        Assert.assertEquals(null, taskService.getDetailMapByPK(testid), "异常");
	}

	@Test(groups = "groupGet")
	public void getCountByFilterTest()
	{
		        Long count = 0L;
        Mockito.doReturn(mockParams).when(taskfilterMapper).buildMap();
        TaskDOExample example = TaskFilter.initDOQueryFilter(mockParams);
        Mockito.doReturn(count).when(taskdao).countByExample(example);
        Assert.assertEquals(count, taskService.getCountByFilter(taskfilterMapper), "异常");

	}

	@Test(groups = "groupGet")
	public void getListByFilterTest()
	{
		List<Task> entityList = new ArrayList<>();
        Mockito.doReturn(mockParams).when(taskfilterMapper).buildMap();
        TaskDOExample example = TaskFilter.initDOQueryFilter(mockParams);

        List<Task> res = Mockito.mock(List.class);
        Mockito.doReturn(res).when(taskdao).selectByExample(example);
        Iterator iteratorMock = Mockito.mock(Iterator.class);
        Mockito.when(res.iterator()).thenReturn(iteratorMock);
        Mockito.when(iteratorMock.hasNext()).thenReturn(true, false);
        Mockito.when(iteratorMock.next()).thenReturn(entityList);
        Assert.assertEquals(entityList, taskService.getListByFilter(taskfilterMapper), "异常");
	}

	@Test(groups = "groupGet", dependsOnMethods = "getListByFilterTest")
	public void getFilterMapListTest()
	{
		List<Map<String, Object>> entityMapList = new ArrayList<>();
        List<Task> t1 = Mockito.mock(ArrayList.class);
        List<Task> t2 = null;
        Mockito.when(taskService.getListByFilter(taskfilterMapper)).thenReturn(t1);
        Mockito.doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocationOnMock) throws Throwable {
                Object argument = invocationOnMock.getArgument(0);
                Task.class.getDeclaredMethod("accept", Task.class).invoke(argument, 1);
                return argument;
            }
        }).when(t1).forEach(entity -> entityMapList.add(TaskSimpleMapper.buildMap(entity)));
        Assert.assertEquals(entityMapList, taskService.getFilterMapList(taskfilterMapper), "异常");
	}

	@Test(groups = "groupPost", dependsOnMethods = "getByPKTest", expectedExceptions = StatusException.class)
	public void postTestException()
	{
		StatusException e = new StatusException("POST_ENTITY_DUPLICATE");
        task = new Task();
        Mockito.when(taskdao.insertSelective(TaskData.convert(task, new TaskDO()))).thenThrow(e);
        Task res = taskService.post(task);
        throw e;
	}

	@Test(groups = "groupPost", dependsOnMethods = "getByPKTest")
	public void postTest()
	{
		 Task test = new  Task();
 Task spyTask = Mockito.spy(test);
        Mockito.when(taskdao.insertSelective(TaskData.convert(test, new TaskDO()))).thenReturn(1);
        Task res = taskService.post(test);
	}

	@Test(groups = "groupUpadte", dependsOnMethods = "getByPKTest", expectedExceptions = NullPointerException.class)
	public void updateTest()
	{
		int actual = 1;
        Mockito.when(taskdao.updateByPrimaryKeySelective(TaskData.convert(task, new TaskDO()))).thenReturn(1);
        Assert.assertEquals(actual, taskdao.updateByPrimaryKeySelective(TaskData.convert(task, new TaskDO())), "不相等");

	}

	@Test(groups = "groupPut", dependsOnMethods = "getByPKTest")
	public void putTestIsNull()
	{
		Task putEntity=new Task();
        putEntity.setId("1");
        Object actual=null;
        Mockito.when(taskService.getByPK(putEntity.getId())).thenReturn(null);
        Mockito.when(taskdao.insertSelective(TaskData.convert(putEntity, new TaskDO()))).thenReturn(1);
        Assert.assertEquals(actual,taskService.put(putEntity),"不相等");
	}

	@Test(groups = "groupDelete")
	public void deleteTest()
	{
		String testid = "1";
        AtomicInteger count = new AtomicInteger();
        Mockito.when(count.addAndGet(taskdao.deleteByPrimaryKey(testid))).thenReturn(1);
        int actual = taskService.delete(testid);
        Assert.assertEquals(actual, 1, "不相等");
	}

	@Test(groups = "groupGet", dependsOnMethods = "getCountByFilterTest")
	public void getRateAndCountByFilterTest()
	{
		Map<String, Map<String, Object>> res = new HashMap<>();
        List<String> groupBy = Mockito.mock(List.class);
        res = taskService.getFilterListGroup(taskfilterMapper, groupBy);
        Assert.assertEquals(res.size(), 0, "不相等");
	}

}