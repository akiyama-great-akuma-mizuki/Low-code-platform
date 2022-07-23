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
public class OfficialHistorytest {
	@Mock
	public OfficialHistoryDAO officialhistorydao;

	@Mock
	public OfficialHistorySimpleMapper officialhistorySimpleMapper;

	@Mock
	public OfficialHistory officialhistory;

	@Mock
	public OfficialHistoryFilterMapper officialhistoryfilterMapper;

	@InjectMocks
	public OfficialHistoryService officialhistoryService;

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
        OfficialHistoryDO officialhistorydo = new OfficialHistoryDO();
        officialhistorydo.setId(testid);
        Mockito.when(officialhistorydao.selectByPrimaryKey(testid)).thenReturn(officialhistorydo);
        Assert.assertEquals(officialhistoryService.getByPK(testid).getId(), testid, "不相等");
	}

	@Test(groups = "getGet", dependsOnMethods = "getByPKTest")
	public void getSimpleMapByPKTest()
	{
		String testid = mockParams.get("id").toString();
        Map<String, Object> res = officialhistorySimpleMapper.buildMap(officialhistoryService.getByPK(testid));
       Assert.assertEquals(officialhistoryService.getSimpleMapByPK(testid), res, "getSimpleMapByPK不相等");
	}

	@Test(groups = "groupGet", dependsOnMethods = "getByPKTest")
	public void getDetailMapByPKTestIsNull()
	{
		String testid = "1";
        Mockito.when(officialhistoryService.getByPK(testid)).thenReturn(null);
        Assert.assertEquals(null, officialhistoryService.getDetailMapByPK(testid), "异常");
	}

	@Test(groups = "groupGet")
	public void getCountByFilterTest()
	{
		        Long count = 0L;
        Mockito.doReturn(mockParams).when(officialhistoryfilterMapper).buildMap();
        OfficialHistoryDOExample example = OfficialHistoryFilter.initDOQueryFilter(mockParams);
        Mockito.doReturn(count).when(officialhistorydao).countByExample(example);
        Assert.assertEquals(count, officialhistoryService.getCountByFilter(officialhistoryfilterMapper), "异常");

	}

	@Test(groups = "groupGet")
	public void getListByFilterTest()
	{
		List<OfficialHistory> entityList = new ArrayList<>();
        Mockito.doReturn(mockParams).when(officialhistoryfilterMapper).buildMap();
        OfficialHistoryDOExample example = OfficialHistoryFilter.initDOQueryFilter(mockParams);

        List<OfficialHistory> res = Mockito.mock(List.class);
        Mockito.doReturn(res).when(officialhistorydao).selectByExample(example);
        Iterator iteratorMock = Mockito.mock(Iterator.class);
        Mockito.when(res.iterator()).thenReturn(iteratorMock);
        Mockito.when(iteratorMock.hasNext()).thenReturn(true, false);
        Mockito.when(iteratorMock.next()).thenReturn(entityList);
        Assert.assertEquals(entityList, officialhistoryService.getListByFilter(officialhistoryfilterMapper), "异常");
	}

	@Test(groups = "groupGet", dependsOnMethods = "getListByFilterTest")
	public void getFilterMapListTest()
	{
		List<Map<String, Object>> entityMapList = new ArrayList<>();
        List<OfficialHistory> t1 = Mockito.mock(ArrayList.class);
        List<OfficialHistory> t2 = null;
        Mockito.when(officialhistoryService.getListByFilter(officialhistoryfilterMapper)).thenReturn(t1);
        Mockito.doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocationOnMock) throws Throwable {
                Object argument = invocationOnMock.getArgument(0);
                OfficialHistory.class.getDeclaredMethod("accept", OfficialHistory.class).invoke(argument, 1);
                return argument;
            }
        }).when(t1).forEach(entity -> entityMapList.add(OfficialHistorySimpleMapper.buildMap(entity)));
        Assert.assertEquals(entityMapList, officialhistoryService.getFilterMapList(officialhistoryfilterMapper), "异常");
	}

	@Test(groups = "groupPost", dependsOnMethods = "getByPKTest", expectedExceptions = StatusException.class)
	public void postTestException()
	{
		StatusException e = new StatusException("POST_ENTITY_DUPLICATE");
        officialhistory = new OfficialHistory();
        Mockito.when(officialhistorydao.insertSelective(OfficialHistoryData.convert(officialhistory, new OfficialHistoryDO()))).thenThrow(e);
        OfficialHistory res = officialhistoryService.post(officialhistory);
        throw e;
	}

	@Test(groups = "groupPost", dependsOnMethods = "getByPKTest")
	public void postTest()
	{
		 OfficialHistory test = new  OfficialHistory();
 OfficialHistory spyOfficialHistory = Mockito.spy(test);
        Mockito.when(officialhistorydao.insertSelective(OfficialHistoryData.convert(test, new OfficialHistoryDO()))).thenReturn(1);
        OfficialHistory res = officialhistoryService.post(test);
	}

	@Test(groups = "groupUpadte", dependsOnMethods = "getByPKTest", expectedExceptions = NullPointerException.class)
	public void updateTest()
	{
		int actual = 1;
        Mockito.when(officialhistorydao.updateByPrimaryKeySelective(OfficialHistoryData.convert(officialhistory, new OfficialHistoryDO()))).thenReturn(1);
        Assert.assertEquals(actual, officialhistorydao.updateByPrimaryKeySelective(OfficialHistoryData.convert(officialhistory, new OfficialHistoryDO())), "不相等");

	}

	@Test(groups = "groupPut", dependsOnMethods = "getByPKTest")
	public void putTestIsNull()
	{
		OfficialHistory putEntity=new OfficialHistory();
        putEntity.setId("1");
        Object actual=null;
        Mockito.when(officialhistoryService.getByPK(putEntity.getId())).thenReturn(null);
        Mockito.when(officialhistorydao.insertSelective(OfficialHistoryData.convert(putEntity, new OfficialHistoryDO()))).thenReturn(1);
        Assert.assertEquals(actual,officialhistoryService.put(putEntity),"不相等");
	}

	@Test(groups = "groupDelete")
	public void deleteTest()
	{
		String testid = "1";
        AtomicInteger count = new AtomicInteger();
        Mockito.when(count.addAndGet(officialhistorydao.deleteByPrimaryKey(testid))).thenReturn(1);
        int actual = officialhistoryService.delete(testid);
        Assert.assertEquals(actual, 1, "不相等");
	}

	@Test(groups = "groupGet", dependsOnMethods = "getCountByFilterTest")
	public void getRateAndCountByFilterTest()
	{
		Map<String, Map<String, Object>> res = new HashMap<>();
        List<String> groupBy = Mockito.mock(List.class);
        res = officialhistoryService.getFilterListGroup(officialhistoryfilterMapper, groupBy);
        Assert.assertEquals(res.size(), 0, "不相等");
	}

}