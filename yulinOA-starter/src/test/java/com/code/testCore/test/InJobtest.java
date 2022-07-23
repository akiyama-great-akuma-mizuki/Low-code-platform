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
public class InJobtest {
	@Mock
	public InJobDAO injobdao;

	@Mock
	public InJobSimpleMapper injobSimpleMapper;

	@Mock
	public InJob injob;

	@Mock
	public InJobFilterMapper injobfilterMapper;

	@InjectMocks
	public InJobService injobService;

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
        InJobDO injobdo = new InJobDO();
        injobdo.setId(testid);
        Mockito.when(injobdao.selectByPrimaryKey(testid)).thenReturn(injobdo);
        Assert.assertEquals(injobService.getByPK(testid).getId(), testid, "不相等");
	}

	@Test(groups = "getGet", dependsOnMethods = "getByPKTest")
	public void getSimpleMapByPKTest()
	{
		String testid = mockParams.get("id").toString();
        Map<String, Object> res = injobSimpleMapper.buildMap(injobService.getByPK(testid));
       Assert.assertEquals(injobService.getSimpleMapByPK(testid), res, "getSimpleMapByPK不相等");
	}

	@Test(groups = "groupGet", dependsOnMethods = "getByPKTest")
	public void getDetailMapByPKTestIsNull()
	{
		String testid = "1";
        Mockito.when(injobService.getByPK(testid)).thenReturn(null);
        Assert.assertEquals(null, injobService.getDetailMapByPK(testid), "异常");
	}

	@Test(groups = "groupGet")
	public void getCountByFilterTest()
	{
		        Long count = 0L;
        Mockito.doReturn(mockParams).when(injobfilterMapper).buildMap();
        InJobDOExample example = InJobFilter.initDOQueryFilter(mockParams);
        Mockito.doReturn(count).when(injobdao).countByExample(example);
        Assert.assertEquals(count, injobService.getCountByFilter(injobfilterMapper), "异常");

	}

	@Test(groups = "groupGet")
	public void getListByFilterTest()
	{
		List<InJob> entityList = new ArrayList<>();
        Mockito.doReturn(mockParams).when(injobfilterMapper).buildMap();
        InJobDOExample example = InJobFilter.initDOQueryFilter(mockParams);

        List<InJob> res = Mockito.mock(List.class);
        Mockito.doReturn(res).when(injobdao).selectByExample(example);
        Iterator iteratorMock = Mockito.mock(Iterator.class);
        Mockito.when(res.iterator()).thenReturn(iteratorMock);
        Mockito.when(iteratorMock.hasNext()).thenReturn(true, false);
        Mockito.when(iteratorMock.next()).thenReturn(entityList);
        Assert.assertEquals(entityList, injobService.getListByFilter(injobfilterMapper), "异常");
	}

	@Test(groups = "groupGet", dependsOnMethods = "getListByFilterTest")
	public void getFilterMapListTest()
	{
		List<Map<String, Object>> entityMapList = new ArrayList<>();
        List<InJob> t1 = Mockito.mock(ArrayList.class);
        List<InJob> t2 = null;
        Mockito.when(injobService.getListByFilter(injobfilterMapper)).thenReturn(t1);
        Mockito.doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocationOnMock) throws Throwable {
                Object argument = invocationOnMock.getArgument(0);
                InJob.class.getDeclaredMethod("accept", InJob.class).invoke(argument, 1);
                return argument;
            }
        }).when(t1).forEach(entity -> entityMapList.add(InJobSimpleMapper.buildMap(entity)));
        Assert.assertEquals(entityMapList, injobService.getFilterMapList(injobfilterMapper), "异常");
	}

	@Test(groups = "groupPost", dependsOnMethods = "getByPKTest", expectedExceptions = StatusException.class)
	public void postTestException()
	{
		StatusException e = new StatusException("POST_ENTITY_DUPLICATE");
        injob = new InJob();
        Mockito.when(injobdao.insertSelective(InJobData.convert(injob, new InJobDO()))).thenThrow(e);
        InJob res = injobService.post(injob);
        throw e;
	}

	@Test(groups = "groupPost", dependsOnMethods = "getByPKTest")
	public void postTest()
	{
		 InJob test = new  InJob();
 InJob spyInJob = Mockito.spy(test);
        Mockito.when(injobdao.insertSelective(InJobData.convert(test, new InJobDO()))).thenReturn(1);
        InJob res = injobService.post(test);
	}

	@Test(groups = "groupUpadte", dependsOnMethods = "getByPKTest", expectedExceptions = NullPointerException.class)
	public void updateTest()
	{
		int actual = 1;
        Mockito.when(injobdao.updateByPrimaryKeySelective(InJobData.convert(injob, new InJobDO()))).thenReturn(1);
        Assert.assertEquals(actual, injobdao.updateByPrimaryKeySelective(InJobData.convert(injob, new InJobDO())), "不相等");

	}

	@Test(groups = "groupPut", dependsOnMethods = "getByPKTest")
	public void putTestIsNull()
	{
		InJob putEntity=new InJob();
        putEntity.setId("1");
        Object actual=null;
        Mockito.when(injobService.getByPK(putEntity.getId())).thenReturn(null);
        Mockito.when(injobdao.insertSelective(InJobData.convert(putEntity, new InJobDO()))).thenReturn(1);
        Assert.assertEquals(actual,injobService.put(putEntity),"不相等");
	}

	@Test(groups = "groupDelete")
	public void deleteTest()
	{
		String testid = "1";
        AtomicInteger count = new AtomicInteger();
        Mockito.when(count.addAndGet(injobdao.deleteByPrimaryKey(testid))).thenReturn(1);
        int actual = injobService.delete(testid);
        Assert.assertEquals(actual, 1, "不相等");
	}

	@Test(groups = "groupGet", dependsOnMethods = "getCountByFilterTest")
	public void getRateAndCountByFilterTest()
	{
		Map<String, Map<String, Object>> res = new HashMap<>();
        List<String> groupBy = Mockito.mock(List.class);
        res = injobService.getFilterListGroup(injobfilterMapper, groupBy);
        Assert.assertEquals(res.size(), 0, "不相等");
	}

}