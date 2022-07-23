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
public class Officialtest {
	@Mock
	public OfficialDAO officialdao;

	@Mock
	public OfficialSimpleMapper officialSimpleMapper;

	@Mock
	public Official official;

	@Mock
	public OfficialFilterMapper officialfilterMapper;

	@InjectMocks
	public OfficialService officialService;

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
        OfficialDO officialdo = new OfficialDO();
        officialdo.setId(testid);
        Mockito.when(officialdao.selectByPrimaryKey(testid)).thenReturn(officialdo);
        Assert.assertEquals(officialService.getByPK(testid).getId(), testid, "不相等");
	}

	@Test(groups = "getGet", dependsOnMethods = "getByPKTest")
	public void getSimpleMapByPKTest()
	{
		String testid = mockParams.get("id").toString();
        Map<String, Object> res = officialSimpleMapper.buildMap(officialService.getByPK(testid));
       Assert.assertEquals(officialService.getSimpleMapByPK(testid), res, "getSimpleMapByPK不相等");
	}

	@Test(groups = "groupGet", dependsOnMethods = "getByPKTest")
	public void getDetailMapByPKTestIsNull()
	{
		String testid = "1";
        Mockito.when(officialService.getByPK(testid)).thenReturn(null);
        Assert.assertEquals(null, officialService.getDetailMapByPK(testid), "异常");
	}

	@Test(groups = "groupGet")
	public void getCountByFilterTest()
	{
		        Long count = 0L;
        Mockito.doReturn(mockParams).when(officialfilterMapper).buildMap();
        OfficialDOExample example = OfficialFilter.initDOQueryFilter(mockParams);
        Mockito.doReturn(count).when(officialdao).countByExample(example);
        Assert.assertEquals(count, officialService.getCountByFilter(officialfilterMapper), "异常");

	}

	@Test(groups = "groupGet")
	public void getListByFilterTest()
	{
		List<Official> entityList = new ArrayList<>();
        Mockito.doReturn(mockParams).when(officialfilterMapper).buildMap();
        OfficialDOExample example = OfficialFilter.initDOQueryFilter(mockParams);

        List<Official> res = Mockito.mock(List.class);
        Mockito.doReturn(res).when(officialdao).selectByExample(example);
        Iterator iteratorMock = Mockito.mock(Iterator.class);
        Mockito.when(res.iterator()).thenReturn(iteratorMock);
        Mockito.when(iteratorMock.hasNext()).thenReturn(true, false);
        Mockito.when(iteratorMock.next()).thenReturn(entityList);
        Assert.assertEquals(entityList, officialService.getListByFilter(officialfilterMapper), "异常");
	}

	@Test(groups = "groupGet", dependsOnMethods = "getListByFilterTest")
	public void getFilterMapListTest()
	{
		List<Map<String, Object>> entityMapList = new ArrayList<>();
        List<Official> t1 = Mockito.mock(ArrayList.class);
        List<Official> t2 = null;
        Mockito.when(officialService.getListByFilter(officialfilterMapper)).thenReturn(t1);
        Mockito.doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocationOnMock) throws Throwable {
                Object argument = invocationOnMock.getArgument(0);
                Official.class.getDeclaredMethod("accept", Official.class).invoke(argument, 1);
                return argument;
            }
        }).when(t1).forEach(entity -> entityMapList.add(OfficialSimpleMapper.buildMap(entity)));
        Assert.assertEquals(entityMapList, officialService.getFilterMapList(officialfilterMapper), "异常");
	}

	@Test(groups = "groupPost", dependsOnMethods = "getByPKTest", expectedExceptions = StatusException.class)
	public void postTestException()
	{
		StatusException e = new StatusException("POST_ENTITY_DUPLICATE");
        official = new Official();
        Mockito.when(officialdao.insertSelective(OfficialData.convert(official, new OfficialDO()))).thenThrow(e);
        Official res = officialService.post(official);
        throw e;
	}

	@Test(groups = "groupPost", dependsOnMethods = "getByPKTest")
	public void postTest()
	{
		 Official test = new  Official();
 Official spyOfficial = Mockito.spy(test);
        Mockito.when(officialdao.insertSelective(OfficialData.convert(test, new OfficialDO()))).thenReturn(1);
        Official res = officialService.post(test);
	}

	@Test(groups = "groupUpadte", dependsOnMethods = "getByPKTest", expectedExceptions = NullPointerException.class)
	public void updateTest()
	{
		int actual = 1;
        Mockito.when(officialdao.updateByPrimaryKeySelective(OfficialData.convert(official, new OfficialDO()))).thenReturn(1);
        Assert.assertEquals(actual, officialdao.updateByPrimaryKeySelective(OfficialData.convert(official, new OfficialDO())), "不相等");

	}

	@Test(groups = "groupPut", dependsOnMethods = "getByPKTest")
	public void putTestIsNull()
	{
		Official putEntity=new Official();
        putEntity.setId("1");
        Object actual=null;
        Mockito.when(officialService.getByPK(putEntity.getId())).thenReturn(null);
        Mockito.when(officialdao.insertSelective(OfficialData.convert(putEntity, new OfficialDO()))).thenReturn(1);
        Assert.assertEquals(actual,officialService.put(putEntity),"不相等");
	}

	@Test(groups = "groupDelete")
	public void deleteTest()
	{
		String testid = "1";
        AtomicInteger count = new AtomicInteger();
        Mockito.when(count.addAndGet(officialdao.deleteByPrimaryKey(testid))).thenReturn(1);
        int actual = officialService.delete(testid);
        Assert.assertEquals(actual, 1, "不相等");
	}

	@Test(groups = "groupGet", dependsOnMethods = "getCountByFilterTest")
	public void getRateAndCountByFilterTest()
	{
		Map<String, Map<String, Object>> res = new HashMap<>();
        List<String> groupBy = Mockito.mock(List.class);
        res = officialService.getFilterListGroup(officialfilterMapper, groupBy);
        Assert.assertEquals(res.size(), 0, "不相等");
	}

}