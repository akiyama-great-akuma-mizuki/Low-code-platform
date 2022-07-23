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
public class Knowledgetest {
	@Mock
	public KnowledgeDAO knowledgedao;

	@Mock
	public KnowledgeSimpleMapper knowledgeSimpleMapper;

	@Mock
	public Knowledge knowledge;

	@Mock
	public KnowledgeFilterMapper knowledgefilterMapper;

	@InjectMocks
	public KnowledgeService knowledgeService;

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
        KnowledgeDO knowledgedo = new KnowledgeDO();
        knowledgedo.setId(testid);
        Mockito.when(knowledgedao.selectByPrimaryKey(testid)).thenReturn(knowledgedo);
        Assert.assertEquals(knowledgeService.getByPK(testid).getId(), testid, "不相等");
	}

	@Test(groups = "getGet", dependsOnMethods = "getByPKTest")
	public void getSimpleMapByPKTest()
	{
		String testid = mockParams.get("id").toString();
        Map<String, Object> res = knowledgeSimpleMapper.buildMap(knowledgeService.getByPK(testid));
       Assert.assertEquals(knowledgeService.getSimpleMapByPK(testid), res, "getSimpleMapByPK不相等");
	}

	@Test(groups = "groupGet", dependsOnMethods = "getByPKTest")
	public void getDetailMapByPKTestIsNull()
	{
		String testid = "1";
        Mockito.when(knowledgeService.getByPK(testid)).thenReturn(null);
        Assert.assertEquals(null, knowledgeService.getDetailMapByPK(testid), "异常");
	}

	@Test(groups = "groupGet")
	public void getCountByFilterTest()
	{
		        Long count = 0L;
        Mockito.doReturn(mockParams).when(knowledgefilterMapper).buildMap();
        KnowledgeDOExample example = KnowledgeFilter.initDOQueryFilter(mockParams);
        Mockito.doReturn(count).when(knowledgedao).countByExample(example);
        Assert.assertEquals(count, knowledgeService.getCountByFilter(knowledgefilterMapper), "异常");

	}

	@Test(groups = "groupGet")
	public void getListByFilterTest()
	{
		List<Knowledge> entityList = new ArrayList<>();
        Mockito.doReturn(mockParams).when(knowledgefilterMapper).buildMap();
        KnowledgeDOExample example = KnowledgeFilter.initDOQueryFilter(mockParams);

        List<Knowledge> res = Mockito.mock(List.class);
        Mockito.doReturn(res).when(knowledgedao).selectByExample(example);
        Iterator iteratorMock = Mockito.mock(Iterator.class);
        Mockito.when(res.iterator()).thenReturn(iteratorMock);
        Mockito.when(iteratorMock.hasNext()).thenReturn(true, false);
        Mockito.when(iteratorMock.next()).thenReturn(entityList);
        Assert.assertEquals(entityList, knowledgeService.getListByFilter(knowledgefilterMapper), "异常");
	}

	@Test(groups = "groupGet", dependsOnMethods = "getListByFilterTest")
	public void getFilterMapListTest()
	{
		List<Map<String, Object>> entityMapList = new ArrayList<>();
        List<Knowledge> t1 = Mockito.mock(ArrayList.class);
        List<Knowledge> t2 = null;
        Mockito.when(knowledgeService.getListByFilter(knowledgefilterMapper)).thenReturn(t1);
        Mockito.doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocationOnMock) throws Throwable {
                Object argument = invocationOnMock.getArgument(0);
                Knowledge.class.getDeclaredMethod("accept", Knowledge.class).invoke(argument, 1);
                return argument;
            }
        }).when(t1).forEach(entity -> entityMapList.add(KnowledgeSimpleMapper.buildMap(entity)));
        Assert.assertEquals(entityMapList, knowledgeService.getFilterMapList(knowledgefilterMapper), "异常");
	}

	@Test(groups = "groupPost", dependsOnMethods = "getByPKTest", expectedExceptions = StatusException.class)
	public void postTestException()
	{
		StatusException e = new StatusException("POST_ENTITY_DUPLICATE");
        knowledge = new Knowledge();
        Mockito.when(knowledgedao.insertSelective(KnowledgeData.convert(knowledge, new KnowledgeDO()))).thenThrow(e);
        Knowledge res = knowledgeService.post(knowledge);
        throw e;
	}

	@Test(groups = "groupPost", dependsOnMethods = "getByPKTest")
	public void postTest()
	{
		 Knowledge test = new  Knowledge();
 Knowledge spyKnowledge = Mockito.spy(test);
        Mockito.when(knowledgedao.insertSelective(KnowledgeData.convert(test, new KnowledgeDO()))).thenReturn(1);
        Knowledge res = knowledgeService.post(test);
	}

	@Test(groups = "groupUpadte", dependsOnMethods = "getByPKTest", expectedExceptions = NullPointerException.class)
	public void updateTest()
	{
		int actual = 1;
        Mockito.when(knowledgedao.updateByPrimaryKeySelective(KnowledgeData.convert(knowledge, new KnowledgeDO()))).thenReturn(1);
        Assert.assertEquals(actual, knowledgedao.updateByPrimaryKeySelective(KnowledgeData.convert(knowledge, new KnowledgeDO())), "不相等");

	}

	@Test(groups = "groupPut", dependsOnMethods = "getByPKTest")
	public void putTestIsNull()
	{
		Knowledge putEntity=new Knowledge();
        putEntity.setId("1");
        Object actual=null;
        Mockito.when(knowledgeService.getByPK(putEntity.getId())).thenReturn(null);
        Mockito.when(knowledgedao.insertSelective(KnowledgeData.convert(putEntity, new KnowledgeDO()))).thenReturn(1);
        Assert.assertEquals(actual,knowledgeService.put(putEntity),"不相等");
	}

	@Test(groups = "groupDelete")
	public void deleteTest()
	{
		String testid = "1";
        AtomicInteger count = new AtomicInteger();
        Mockito.when(count.addAndGet(knowledgedao.deleteByPrimaryKey(testid))).thenReturn(1);
        int actual = knowledgeService.delete(testid);
        Assert.assertEquals(actual, 1, "不相等");
	}

	@Test(groups = "groupGet", dependsOnMethods = "getCountByFilterTest")
	public void getRateAndCountByFilterTest()
	{
		Map<String, Map<String, Object>> res = new HashMap<>();
        List<String> groupBy = Mockito.mock(List.class);
        res = knowledgeService.getFilterListGroup(knowledgefilterMapper, groupBy);
        Assert.assertEquals(res.size(), 0, "不相等");
	}

}