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
public class LeaveJobtest {
	@Mock
	public LeaveJobDAO leavejobdao;

	@Mock
	public LeaveJobSimpleMapper leavejobSimpleMapper;

	@Mock
	public LeaveJob leavejob;

	@Mock
	public LeaveJobFilterMapper leavejobfilterMapper;

	@InjectMocks
	public LeaveJobService leavejobService;

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
        LeaveJobDO leavejobdo = new LeaveJobDO();
        leavejobdo.setId(testid);
        Mockito.when(leavejobdao.selectByPrimaryKey(testid)).thenReturn(leavejobdo);
        Assert.assertEquals(leavejobService.getByPK(testid).getId(), testid, "不相等");
	}

	@Test(groups = "getGet", dependsOnMethods = "getByPKTest")
	public void getSimpleMapByPKTest()
	{
		String testid = mockParams.get("id").toString();
        Map<String, Object> res = leavejobSimpleMapper.buildMap(leavejobService.getByPK(testid));
       Assert.assertEquals(leavejobService.getSimpleMapByPK(testid), res, "getSimpleMapByPK不相等");
	}

	@Test(groups = "groupGet", dependsOnMethods = "getByPKTest")
	public void getDetailMapByPKTestIsNull()
	{
		String testid = "1";
        Mockito.when(leavejobService.getByPK(testid)).thenReturn(null);
        Assert.assertEquals(null, leavejobService.getDetailMapByPK(testid), "异常");
	}

	@Test(groups = "groupGet")
	public void getCountByFilterTest()
	{
		        Long count = 0L;
        Mockito.doReturn(mockParams).when(leavejobfilterMapper).buildMap();
        LeaveJobDOExample example = LeaveJobFilter.initDOQueryFilter(mockParams);
        Mockito.doReturn(count).when(leavejobdao).countByExample(example);
        Assert.assertEquals(count, leavejobService.getCountByFilter(leavejobfilterMapper), "异常");

	}

	@Test(groups = "groupGet")
	public void getListByFilterTest()
	{
		List<LeaveJob> entityList = new ArrayList<>();
        Mockito.doReturn(mockParams).when(leavejobfilterMapper).buildMap();
        LeaveJobDOExample example = LeaveJobFilter.initDOQueryFilter(mockParams);

        List<LeaveJob> res = Mockito.mock(List.class);
        Mockito.doReturn(res).when(leavejobdao).selectByExample(example);
        Iterator iteratorMock = Mockito.mock(Iterator.class);
        Mockito.when(res.iterator()).thenReturn(iteratorMock);
        Mockito.when(iteratorMock.hasNext()).thenReturn(true, false);
        Mockito.when(iteratorMock.next()).thenReturn(entityList);
        Assert.assertEquals(entityList, leavejobService.getListByFilter(leavejobfilterMapper), "异常");
	}

	@Test(groups = "groupGet", dependsOnMethods = "getListByFilterTest")
	public void getFilterMapListTest()
	{
		List<Map<String, Object>> entityMapList = new ArrayList<>();
        List<LeaveJob> t1 = Mockito.mock(ArrayList.class);
        List<LeaveJob> t2 = null;
        Mockito.when(leavejobService.getListByFilter(leavejobfilterMapper)).thenReturn(t1);
        Mockito.doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocationOnMock) throws Throwable {
                Object argument = invocationOnMock.getArgument(0);
                LeaveJob.class.getDeclaredMethod("accept", LeaveJob.class).invoke(argument, 1);
                return argument;
            }
        }).when(t1).forEach(entity -> entityMapList.add(LeaveJobSimpleMapper.buildMap(entity)));
        Assert.assertEquals(entityMapList, leavejobService.getFilterMapList(leavejobfilterMapper), "异常");
	}

	@Test(groups = "groupPost", dependsOnMethods = "getByPKTest", expectedExceptions = StatusException.class)
	public void postTestException()
	{
		StatusException e = new StatusException("POST_ENTITY_DUPLICATE");
        leavejob = new LeaveJob();
        Mockito.when(leavejobdao.insertSelective(LeaveJobData.convert(leavejob, new LeaveJobDO()))).thenThrow(e);
        LeaveJob res = leavejobService.post(leavejob);
        throw e;
	}

	@Test(groups = "groupPost", dependsOnMethods = "getByPKTest")
	public void postTest()
	{
		 LeaveJob test = new  LeaveJob();
 LeaveJob spyLeaveJob = Mockito.spy(test);
        Mockito.when(leavejobdao.insertSelective(LeaveJobData.convert(test, new LeaveJobDO()))).thenReturn(1);
        LeaveJob res = leavejobService.post(test);
	}

	@Test(groups = "groupUpadte", dependsOnMethods = "getByPKTest", expectedExceptions = NullPointerException.class)
	public void updateTest()
	{
		int actual = 1;
        Mockito.when(leavejobdao.updateByPrimaryKeySelective(LeaveJobData.convert(leavejob, new LeaveJobDO()))).thenReturn(1);
        Assert.assertEquals(actual, leavejobdao.updateByPrimaryKeySelective(LeaveJobData.convert(leavejob, new LeaveJobDO())), "不相等");

	}

	@Test(groups = "groupPut", dependsOnMethods = "getByPKTest")
	public void putTestIsNull()
	{
		LeaveJob putEntity=new LeaveJob();
        putEntity.setId("1");
        Object actual=null;
        Mockito.when(leavejobService.getByPK(putEntity.getId())).thenReturn(null);
        Mockito.when(leavejobdao.insertSelective(LeaveJobData.convert(putEntity, new LeaveJobDO()))).thenReturn(1);
        Assert.assertEquals(actual,leavejobService.put(putEntity),"不相等");
	}

	@Test(groups = "groupDelete")
	public void deleteTest()
	{
		String testid = "1";
        AtomicInteger count = new AtomicInteger();
        Mockito.when(count.addAndGet(leavejobdao.deleteByPrimaryKey(testid))).thenReturn(1);
        int actual = leavejobService.delete(testid);
        Assert.assertEquals(actual, 1, "不相等");
	}

	@Test(groups = "groupGet", dependsOnMethods = "getCountByFilterTest")
	public void getRateAndCountByFilterTest()
	{
		Map<String, Map<String, Object>> res = new HashMap<>();
        List<String> groupBy = Mockito.mock(List.class);
        res = leavejobService.getFilterListGroup(leavejobfilterMapper, groupBy);
        Assert.assertEquals(res.size(), 0, "不相等");
	}

}