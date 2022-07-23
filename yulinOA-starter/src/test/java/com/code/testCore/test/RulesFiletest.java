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
public class RulesFiletest {
	@Mock
	public RulesFileDAO rulesfiledao;

	@Mock
	public RulesFileSimpleMapper rulesfileSimpleMapper;

	@Mock
	public RulesFile rulesfile;

	@Mock
	public RulesFileFilterMapper rulesfilefilterMapper;

	@InjectMocks
	public RulesFileService rulesfileService;

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
        RulesFileDO rulesfiledo = new RulesFileDO();
        rulesfiledo.setId(testid);
        Mockito.when(rulesfiledao.selectByPrimaryKey(testid)).thenReturn(rulesfiledo);
        Assert.assertEquals(rulesfileService.getByPK(testid).getId(), testid, "不相等");
	}

	@Test(groups = "getGet", dependsOnMethods = "getByPKTest")
	public void getSimpleMapByPKTest()
	{
		String testid = mockParams.get("id").toString();
        Map<String, Object> res = rulesfileSimpleMapper.buildMap(rulesfileService.getByPK(testid));
       Assert.assertEquals(rulesfileService.getSimpleMapByPK(testid), res, "getSimpleMapByPK不相等");
	}

	@Test(groups = "groupGet", dependsOnMethods = "getByPKTest")
	public void getDetailMapByPKTestIsNull()
	{
		String testid = "1";
        Mockito.when(rulesfileService.getByPK(testid)).thenReturn(null);
        Assert.assertEquals(null, rulesfileService.getDetailMapByPK(testid), "异常");
	}

	@Test(groups = "groupGet")
	public void getCountByFilterTest()
	{
		        Long count = 0L;
        Mockito.doReturn(mockParams).when(rulesfilefilterMapper).buildMap();
        RulesFileDOExample example = RulesFileFilter.initDOQueryFilter(mockParams);
        Mockito.doReturn(count).when(rulesfiledao).countByExample(example);
        Assert.assertEquals(count, rulesfileService.getCountByFilter(rulesfilefilterMapper), "异常");

	}

	@Test(groups = "groupGet")
	public void getListByFilterTest()
	{
		List<RulesFile> entityList = new ArrayList<>();
        Mockito.doReturn(mockParams).when(rulesfilefilterMapper).buildMap();
        RulesFileDOExample example = RulesFileFilter.initDOQueryFilter(mockParams);

        List<RulesFile> res = Mockito.mock(List.class);
        Mockito.doReturn(res).when(rulesfiledao).selectByExample(example);
        Iterator iteratorMock = Mockito.mock(Iterator.class);
        Mockito.when(res.iterator()).thenReturn(iteratorMock);
        Mockito.when(iteratorMock.hasNext()).thenReturn(true, false);
        Mockito.when(iteratorMock.next()).thenReturn(entityList);
        Assert.assertEquals(entityList, rulesfileService.getListByFilter(rulesfilefilterMapper), "异常");
	}

	@Test(groups = "groupGet", dependsOnMethods = "getListByFilterTest")
	public void getFilterMapListTest()
	{
		List<Map<String, Object>> entityMapList = new ArrayList<>();
        List<RulesFile> t1 = Mockito.mock(ArrayList.class);
        List<RulesFile> t2 = null;
        Mockito.when(rulesfileService.getListByFilter(rulesfilefilterMapper)).thenReturn(t1);
        Mockito.doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocationOnMock) throws Throwable {
                Object argument = invocationOnMock.getArgument(0);
                RulesFile.class.getDeclaredMethod("accept", RulesFile.class).invoke(argument, 1);
                return argument;
            }
        }).when(t1).forEach(entity -> entityMapList.add(RulesFileSimpleMapper.buildMap(entity)));
        Assert.assertEquals(entityMapList, rulesfileService.getFilterMapList(rulesfilefilterMapper), "异常");
	}

	@Test(groups = "groupPost", dependsOnMethods = "getByPKTest", expectedExceptions = StatusException.class)
	public void postTestException()
	{
		StatusException e = new StatusException("POST_ENTITY_DUPLICATE");
        rulesfile = new RulesFile();
        Mockito.when(rulesfiledao.insertSelective(RulesFileData.convert(rulesfile, new RulesFileDO()))).thenThrow(e);
        RulesFile res = rulesfileService.post(rulesfile);
        throw e;
	}

	@Test(groups = "groupPost", dependsOnMethods = "getByPKTest")
	public void postTest()
	{
		 RulesFile test = new  RulesFile();
 RulesFile spyRulesFile = Mockito.spy(test);
        Mockito.when(rulesfiledao.insertSelective(RulesFileData.convert(test, new RulesFileDO()))).thenReturn(1);
        RulesFile res = rulesfileService.post(test);
	}

	@Test(groups = "groupUpadte", dependsOnMethods = "getByPKTest", expectedExceptions = NullPointerException.class)
	public void updateTest()
	{
		int actual = 1;
        Mockito.when(rulesfiledao.updateByPrimaryKeySelective(RulesFileData.convert(rulesfile, new RulesFileDO()))).thenReturn(1);
        Assert.assertEquals(actual, rulesfiledao.updateByPrimaryKeySelective(RulesFileData.convert(rulesfile, new RulesFileDO())), "不相等");

	}

	@Test(groups = "groupPut", dependsOnMethods = "getByPKTest")
	public void putTestIsNull()
	{
		RulesFile putEntity=new RulesFile();
        putEntity.setId("1");
        Object actual=null;
        Mockito.when(rulesfileService.getByPK(putEntity.getId())).thenReturn(null);
        Mockito.when(rulesfiledao.insertSelective(RulesFileData.convert(putEntity, new RulesFileDO()))).thenReturn(1);
        Assert.assertEquals(actual,rulesfileService.put(putEntity),"不相等");
	}

	@Test(groups = "groupDelete")
	public void deleteTest()
	{
		String testid = "1";
        AtomicInteger count = new AtomicInteger();
        Mockito.when(count.addAndGet(rulesfiledao.deleteByPrimaryKey(testid))).thenReturn(1);
        int actual = rulesfileService.delete(testid);
        Assert.assertEquals(actual, 1, "不相等");
	}

	@Test(groups = "groupGet", dependsOnMethods = "getCountByFilterTest")
	public void getRateAndCountByFilterTest()
	{
		Map<String, Map<String, Object>> res = new HashMap<>();
        List<String> groupBy = Mockito.mock(List.class);
        res = rulesfileService.getFilterListGroup(rulesfilefilterMapper, groupBy);
        Assert.assertEquals(res.size(), 0, "不相等");
	}

}