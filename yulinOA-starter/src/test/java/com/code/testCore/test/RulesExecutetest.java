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
public class RulesExecutetest {
	@Mock
	public RulesExecuteDAO rulesexecutedao;

	@Mock
	public RulesExecuteSimpleMapper rulesexecuteSimpleMapper;

	@Mock
	public RulesExecute rulesexecute;

	@Mock
	public RulesExecuteFilterMapper rulesexecutefilterMapper;

	@InjectMocks
	public RulesExecuteService rulesexecuteService;

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
        RulesExecuteDO rulesexecutedo = new RulesExecuteDO();
        rulesexecutedo.setId(testid);
        Mockito.when(rulesexecutedao.selectByPrimaryKey(testid)).thenReturn(rulesexecutedo);
        Assert.assertEquals(rulesexecuteService.getByPK(testid).getId(), testid, "不相等");
	}

	@Test(groups = "getGet", dependsOnMethods = "getByPKTest")
	public void getSimpleMapByPKTest()
	{
		String testid = mockParams.get("id").toString();
        Map<String, Object> res = rulesexecuteSimpleMapper.buildMap(rulesexecuteService.getByPK(testid));
       Assert.assertEquals(rulesexecuteService.getSimpleMapByPK(testid), res, "getSimpleMapByPK不相等");
	}

	@Test(groups = "groupGet", dependsOnMethods = "getByPKTest")
	public void getDetailMapByPKTestIsNull()
	{
		String testid = "1";
        Mockito.when(rulesexecuteService.getByPK(testid)).thenReturn(null);
        Assert.assertEquals(null, rulesexecuteService.getDetailMapByPK(testid), "异常");
	}

	@Test(groups = "groupGet")
	public void getCountByFilterTest()
	{
		        Long count = 0L;
        Mockito.doReturn(mockParams).when(rulesexecutefilterMapper).buildMap();
        RulesExecuteDOExample example = RulesExecuteFilter.initDOQueryFilter(mockParams);
        Mockito.doReturn(count).when(rulesexecutedao).countByExample(example);
        Assert.assertEquals(count, rulesexecuteService.getCountByFilter(rulesexecutefilterMapper), "异常");

	}

	@Test(groups = "groupGet")
	public void getListByFilterTest()
	{
		List<RulesExecute> entityList = new ArrayList<>();
        Mockito.doReturn(mockParams).when(rulesexecutefilterMapper).buildMap();
        RulesExecuteDOExample example = RulesExecuteFilter.initDOQueryFilter(mockParams);

        List<RulesExecute> res = Mockito.mock(List.class);
        Mockito.doReturn(res).when(rulesexecutedao).selectByExample(example);
        Iterator iteratorMock = Mockito.mock(Iterator.class);
        Mockito.when(res.iterator()).thenReturn(iteratorMock);
        Mockito.when(iteratorMock.hasNext()).thenReturn(true, false);
        Mockito.when(iteratorMock.next()).thenReturn(entityList);
        Assert.assertEquals(entityList, rulesexecuteService.getListByFilter(rulesexecutefilterMapper), "异常");
	}

	@Test(groups = "groupGet", dependsOnMethods = "getListByFilterTest")
	public void getFilterMapListTest()
	{
		List<Map<String, Object>> entityMapList = new ArrayList<>();
        List<RulesExecute> t1 = Mockito.mock(ArrayList.class);
        List<RulesExecute> t2 = null;
        Mockito.when(rulesexecuteService.getListByFilter(rulesexecutefilterMapper)).thenReturn(t1);
        Mockito.doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocationOnMock) throws Throwable {
                Object argument = invocationOnMock.getArgument(0);
                RulesExecute.class.getDeclaredMethod("accept", RulesExecute.class).invoke(argument, 1);
                return argument;
            }
        }).when(t1).forEach(entity -> entityMapList.add(RulesExecuteSimpleMapper.buildMap(entity)));
        Assert.assertEquals(entityMapList, rulesexecuteService.getFilterMapList(rulesexecutefilterMapper), "异常");
	}

	@Test(groups = "groupPost", dependsOnMethods = "getByPKTest", expectedExceptions = StatusException.class)
	public void postTestException()
	{
		StatusException e = new StatusException("POST_ENTITY_DUPLICATE");
        rulesexecute = new RulesExecute();
        Mockito.when(rulesexecutedao.insertSelective(RulesExecuteData.convert(rulesexecute, new RulesExecuteDO()))).thenThrow(e);
        RulesExecute res = rulesexecuteService.post(rulesexecute);
        throw e;
	}

	@Test(groups = "groupPost", dependsOnMethods = "getByPKTest")
	public void postTest()
	{
		 RulesExecute test = new  RulesExecute();
 RulesExecute spyRulesExecute = Mockito.spy(test);
        Mockito.when(rulesexecutedao.insertSelective(RulesExecuteData.convert(test, new RulesExecuteDO()))).thenReturn(1);
        RulesExecute res = rulesexecuteService.post(test);
	}

	@Test(groups = "groupUpadte", dependsOnMethods = "getByPKTest", expectedExceptions = NullPointerException.class)
	public void updateTest()
	{
		int actual = 1;
        Mockito.when(rulesexecutedao.updateByPrimaryKeySelective(RulesExecuteData.convert(rulesexecute, new RulesExecuteDO()))).thenReturn(1);
        Assert.assertEquals(actual, rulesexecutedao.updateByPrimaryKeySelective(RulesExecuteData.convert(rulesexecute, new RulesExecuteDO())), "不相等");

	}

	@Test(groups = "groupPut", dependsOnMethods = "getByPKTest")
	public void putTestIsNull()
	{
		RulesExecute putEntity=new RulesExecute();
        putEntity.setId("1");
        Object actual=null;
        Mockito.when(rulesexecuteService.getByPK(putEntity.getId())).thenReturn(null);
        Mockito.when(rulesexecutedao.insertSelective(RulesExecuteData.convert(putEntity, new RulesExecuteDO()))).thenReturn(1);
        Assert.assertEquals(actual,rulesexecuteService.put(putEntity),"不相等");
	}

	@Test(groups = "groupDelete")
	public void deleteTest()
	{
		String testid = "1";
        AtomicInteger count = new AtomicInteger();
        Mockito.when(count.addAndGet(rulesexecutedao.deleteByPrimaryKey(testid))).thenReturn(1);
        int actual = rulesexecuteService.delete(testid);
        Assert.assertEquals(actual, 1, "不相等");
	}

	@Test(groups = "groupGet", dependsOnMethods = "getCountByFilterTest")
	public void getRateAndCountByFilterTest()
	{
		Map<String, Map<String, Object>> res = new HashMap<>();
        List<String> groupBy = Mockito.mock(List.class);
        res = rulesexecuteService.getFilterListGroup(rulesexecutefilterMapper, groupBy);
        Assert.assertEquals(res.size(), 0, "不相等");
	}

}