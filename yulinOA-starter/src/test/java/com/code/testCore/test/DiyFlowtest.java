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
public class DiyFlowtest {
	@Mock
	public DiyFlowDAO diyflowdao;

	@Mock
	public DiyFlowSimpleMapper diyflowSimpleMapper;

	@Mock
	public DiyFlow diyflow;

	@Mock
	public DiyFlowFilterMapper diyflowfilterMapper;

	@InjectMocks
	public DiyFlowService diyflowService;

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
        DiyFlowDO diyflowdo = new DiyFlowDO();
        diyflowdo.setId(testid);
        Mockito.when(diyflowdao.selectByPrimaryKey(testid)).thenReturn(diyflowdo);
        Assert.assertEquals(diyflowService.getByPK(testid).getId(), testid, "不相等");
	}

	@Test(groups = "getGet", dependsOnMethods = "getByPKTest")
	public void getSimpleMapByPKTest()
	{
		String testid = mockParams.get("id").toString();
        Map<String, Object> res = diyflowSimpleMapper.buildMap(diyflowService.getByPK(testid));
       Assert.assertEquals(diyflowService.getSimpleMapByPK(testid), res, "getSimpleMapByPK不相等");
	}

	@Test(groups = "groupGet", dependsOnMethods = "getByPKTest")
	public void getDetailMapByPKTestIsNull()
	{
		String testid = "1";
        Mockito.when(diyflowService.getByPK(testid)).thenReturn(null);
        Assert.assertEquals(null, diyflowService.getDetailMapByPK(testid), "异常");
	}

	@Test(groups = "groupGet")
	public void getCountByFilterTest()
	{
		        Long count = 0L;
        Mockito.doReturn(mockParams).when(diyflowfilterMapper).buildMap();
        DiyFlowDOExample example = DiyFlowFilter.initDOQueryFilter(mockParams);
        Mockito.doReturn(count).when(diyflowdao).countByExample(example);
        Assert.assertEquals(count, diyflowService.getCountByFilter(diyflowfilterMapper), "异常");

	}

	@Test(groups = "groupGet")
	public void getListByFilterTest()
	{
		List<DiyFlow> entityList = new ArrayList<>();
        Mockito.doReturn(mockParams).when(diyflowfilterMapper).buildMap();
        DiyFlowDOExample example = DiyFlowFilter.initDOQueryFilter(mockParams);

        List<DiyFlow> res = Mockito.mock(List.class);
        Mockito.doReturn(res).when(diyflowdao).selectByExample(example);
        Iterator iteratorMock = Mockito.mock(Iterator.class);
        Mockito.when(res.iterator()).thenReturn(iteratorMock);
        Mockito.when(iteratorMock.hasNext()).thenReturn(true, false);
        Mockito.when(iteratorMock.next()).thenReturn(entityList);
        Assert.assertEquals(entityList, diyflowService.getListByFilter(diyflowfilterMapper), "异常");
	}

	@Test(groups = "groupGet", dependsOnMethods = "getListByFilterTest")
	public void getFilterMapListTest()
	{
		List<Map<String, Object>> entityMapList = new ArrayList<>();
        List<DiyFlow> t1 = Mockito.mock(ArrayList.class);
        List<DiyFlow> t2 = null;
        Mockito.when(diyflowService.getListByFilter(diyflowfilterMapper)).thenReturn(t1);
        Mockito.doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocationOnMock) throws Throwable {
                Object argument = invocationOnMock.getArgument(0);
                DiyFlow.class.getDeclaredMethod("accept", DiyFlow.class).invoke(argument, 1);
                return argument;
            }
        }).when(t1).forEach(entity -> entityMapList.add(DiyFlowSimpleMapper.buildMap(entity)));
        Assert.assertEquals(entityMapList, diyflowService.getFilterMapList(diyflowfilterMapper), "异常");
	}

	@Test(groups = "groupPost", dependsOnMethods = "getByPKTest", expectedExceptions = StatusException.class)
	public void postTestException()
	{
		StatusException e = new StatusException("POST_ENTITY_DUPLICATE");
        diyflow = new DiyFlow();
        Mockito.when(diyflowdao.insertSelective(DiyFlowData.convert(diyflow, new DiyFlowDO()))).thenThrow(e);
        DiyFlow res = diyflowService.post(diyflow);
        throw e;
	}

	@Test(groups = "groupPost", dependsOnMethods = "getByPKTest")
	public void postTest()
	{
		 DiyFlow test = new  DiyFlow();
 DiyFlow spyDiyFlow = Mockito.spy(test);
        Mockito.when(diyflowdao.insertSelective(DiyFlowData.convert(test, new DiyFlowDO()))).thenReturn(1);
        DiyFlow res = diyflowService.post(test);
	}

	@Test(groups = "groupUpadte", dependsOnMethods = "getByPKTest", expectedExceptions = NullPointerException.class)
	public void updateTest()
	{
		int actual = 1;
        Mockito.when(diyflowdao.updateByPrimaryKeySelective(DiyFlowData.convert(diyflow, new DiyFlowDO()))).thenReturn(1);
        Assert.assertEquals(actual, diyflowdao.updateByPrimaryKeySelective(DiyFlowData.convert(diyflow, new DiyFlowDO())), "不相等");

	}

	@Test(groups = "groupPut", dependsOnMethods = "getByPKTest")
	public void putTestIsNull()
	{
		DiyFlow putEntity=new DiyFlow();
        putEntity.setId("1");
        Object actual=null;
        Mockito.when(diyflowService.getByPK(putEntity.getId())).thenReturn(null);
        Mockito.when(diyflowdao.insertSelective(DiyFlowData.convert(putEntity, new DiyFlowDO()))).thenReturn(1);
        Assert.assertEquals(actual,diyflowService.put(putEntity),"不相等");
	}

	@Test(groups = "groupDelete")
	public void deleteTest()
	{
		String testid = "1";
        AtomicInteger count = new AtomicInteger();
        Mockito.when(count.addAndGet(diyflowdao.deleteByPrimaryKey(testid))).thenReturn(1);
        int actual = diyflowService.delete(testid);
        Assert.assertEquals(actual, 1, "不相等");
	}

	@Test(groups = "groupGet", dependsOnMethods = "getCountByFilterTest")
	public void getRateAndCountByFilterTest()
	{
		Map<String, Map<String, Object>> res = new HashMap<>();
        List<String> groupBy = Mockito.mock(List.class);
        res = diyflowService.getFilterListGroup(diyflowfilterMapper, groupBy);
        Assert.assertEquals(res.size(), 0, "不相等");
	}

}