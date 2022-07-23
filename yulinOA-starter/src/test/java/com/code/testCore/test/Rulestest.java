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
public class Rulestest {
	@Mock
	public RulesDAO rulesdao;

	@Mock
	public RulesSimpleMapper rulesSimpleMapper;

	@Mock
	public Rules rules;

	@Mock
	public RulesFilterMapper rulesfilterMapper;

	@InjectMocks
	public RulesService rulesService;

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
        RulesDO rulesdo = new RulesDO();
        rulesdo.setId(testid);
        Mockito.when(rulesdao.selectByPrimaryKey(testid)).thenReturn(rulesdo);
        Assert.assertEquals(rulesService.getByPK(testid).getId(), testid, "不相等");
	}

	@Test(groups = "getGet", dependsOnMethods = "getByPKTest")
	public void getSimpleMapByPKTest()
	{
		String testid = mockParams.get("id").toString();
        Map<String, Object> res = rulesSimpleMapper.buildMap(rulesService.getByPK(testid));
       Assert.assertEquals(rulesService.getSimpleMapByPK(testid), res, "getSimpleMapByPK不相等");
	}

	@Test(groups = "groupGet", dependsOnMethods = "getByPKTest")
	public void getDetailMapByPKTestIsNull()
	{
		String testid = "1";
        Mockito.when(rulesService.getByPK(testid)).thenReturn(null);
        Assert.assertEquals(null, rulesService.getDetailMapByPK(testid), "异常");
	}

	@Test(groups = "groupGet")
	public void getCountByFilterTest()
	{
		        Long count = 0L;
        Mockito.doReturn(mockParams).when(rulesfilterMapper).buildMap();
        RulesDOExample example = RulesFilter.initDOQueryFilter(mockParams);
        Mockito.doReturn(count).when(rulesdao).countByExample(example);
        Assert.assertEquals(count, rulesService.getCountByFilter(rulesfilterMapper), "异常");

	}

	@Test(groups = "groupGet")
	public void getListByFilterTest()
	{
		List<Rules> entityList = new ArrayList<>();
        Mockito.doReturn(mockParams).when(rulesfilterMapper).buildMap();
        RulesDOExample example = RulesFilter.initDOQueryFilter(mockParams);

        List<Rules> res = Mockito.mock(List.class);
        Mockito.doReturn(res).when(rulesdao).selectByExample(example);
        Iterator iteratorMock = Mockito.mock(Iterator.class);
        Mockito.when(res.iterator()).thenReturn(iteratorMock);
        Mockito.when(iteratorMock.hasNext()).thenReturn(true, false);
        Mockito.when(iteratorMock.next()).thenReturn(entityList);
        Assert.assertEquals(entityList, rulesService.getListByFilter(rulesfilterMapper), "异常");
	}

	@Test(groups = "groupGet", dependsOnMethods = "getListByFilterTest")
	public void getFilterMapListTest()
	{
		List<Map<String, Object>> entityMapList = new ArrayList<>();
        List<Rules> t1 = Mockito.mock(ArrayList.class);
        List<Rules> t2 = null;
        Mockito.when(rulesService.getListByFilter(rulesfilterMapper)).thenReturn(t1);
        Mockito.doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocationOnMock) throws Throwable {
                Object argument = invocationOnMock.getArgument(0);
                Rules.class.getDeclaredMethod("accept", Rules.class).invoke(argument, 1);
                return argument;
            }
        }).when(t1).forEach(entity -> entityMapList.add(RulesSimpleMapper.buildMap(entity)));
        Assert.assertEquals(entityMapList, rulesService.getFilterMapList(rulesfilterMapper), "异常");
	}

	@Test(groups = "groupPost", dependsOnMethods = "getByPKTest", expectedExceptions = StatusException.class)
	public void postTestException()
	{
		StatusException e = new StatusException("POST_ENTITY_DUPLICATE");
        rules = new Rules();
        Mockito.when(rulesdao.insertSelective(RulesData.convert(rules, new RulesDO()))).thenThrow(e);
        Rules res = rulesService.post(rules);
        throw e;
	}

	@Test(groups = "groupPost", dependsOnMethods = "getByPKTest")
	public void postTest()
	{
		 Rules test = new  Rules();
 Rules spyRules = Mockito.spy(test);
        Mockito.when(rulesdao.insertSelective(RulesData.convert(test, new RulesDO()))).thenReturn(1);
        Rules res = rulesService.post(test);
	}

	@Test(groups = "groupUpadte", dependsOnMethods = "getByPKTest", expectedExceptions = NullPointerException.class)
	public void updateTest()
	{
		int actual = 1;
        Mockito.when(rulesdao.updateByPrimaryKeySelective(RulesData.convert(rules, new RulesDO()))).thenReturn(1);
        Assert.assertEquals(actual, rulesdao.updateByPrimaryKeySelective(RulesData.convert(rules, new RulesDO())), "不相等");

	}

	@Test(groups = "groupPut", dependsOnMethods = "getByPKTest")
	public void putTestIsNull()
	{
		Rules putEntity=new Rules();
        putEntity.setId("1");
        Object actual=null;
        Mockito.when(rulesService.getByPK(putEntity.getId())).thenReturn(null);
        Mockito.when(rulesdao.insertSelective(RulesData.convert(putEntity, new RulesDO()))).thenReturn(1);
        Assert.assertEquals(actual,rulesService.put(putEntity),"不相等");
	}

	@Test(groups = "groupDelete")
	public void deleteTest()
	{
		String testid = "1";
        AtomicInteger count = new AtomicInteger();
        Mockito.when(count.addAndGet(rulesdao.deleteByPrimaryKey(testid))).thenReturn(1);
        int actual = rulesService.delete(testid);
        Assert.assertEquals(actual, 1, "不相等");
	}

	@Test(groups = "groupGet", dependsOnMethods = "getCountByFilterTest")
	public void getRateAndCountByFilterTest()
	{
		Map<String, Map<String, Object>> res = new HashMap<>();
        List<String> groupBy = Mockito.mock(List.class);
        res = rulesService.getFilterListGroup(rulesfilterMapper, groupBy);
        Assert.assertEquals(res.size(), 0, "不相等");
	}

}