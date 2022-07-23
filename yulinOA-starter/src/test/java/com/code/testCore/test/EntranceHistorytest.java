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
public class EntranceHistorytest {
	@Mock
	public EntranceHistoryDAO entrancehistorydao;

	@Mock
	public EntranceHistorySimpleMapper entrancehistorySimpleMapper;

	@Mock
	public EntranceHistory entrancehistory;

	@Mock
	public EntranceHistoryFilterMapper entrancehistoryfilterMapper;

	@InjectMocks
	public EntranceHistoryService entrancehistoryService;

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
        EntranceHistoryDO entrancehistorydo = new EntranceHistoryDO();
        entrancehistorydo.setId(testid);
        Mockito.when(entrancehistorydao.selectByPrimaryKey(testid)).thenReturn(entrancehistorydo);
        Assert.assertEquals(entrancehistoryService.getByPK(testid).getId(), testid, "不相等");
	}

	@Test(groups = "getGet", dependsOnMethods = "getByPKTest")
	public void getSimpleMapByPKTest()
	{
		String testid = mockParams.get("id").toString();
        Map<String, Object> res = entrancehistorySimpleMapper.buildMap(entrancehistoryService.getByPK(testid));
       Assert.assertEquals(entrancehistoryService.getSimpleMapByPK(testid), res, "getSimpleMapByPK不相等");
	}

	@Test(groups = "groupGet", dependsOnMethods = "getByPKTest")
	public void getDetailMapByPKTestIsNull()
	{
		String testid = "1";
        Mockito.when(entrancehistoryService.getByPK(testid)).thenReturn(null);
        Assert.assertEquals(null, entrancehistoryService.getDetailMapByPK(testid), "异常");
	}

	@Test(groups = "groupGet")
	public void getCountByFilterTest()
	{
		        Long count = 0L;
        Mockito.doReturn(mockParams).when(entrancehistoryfilterMapper).buildMap();
        EntranceHistoryDOExample example = EntranceHistoryFilter.initDOQueryFilter(mockParams);
        Mockito.doReturn(count).when(entrancehistorydao).countByExample(example);
        Assert.assertEquals(count, entrancehistoryService.getCountByFilter(entrancehistoryfilterMapper), "异常");

	}

	@Test(groups = "groupGet")
	public void getListByFilterTest()
	{
		List<EntranceHistory> entityList = new ArrayList<>();
        Mockito.doReturn(mockParams).when(entrancehistoryfilterMapper).buildMap();
        EntranceHistoryDOExample example = EntranceHistoryFilter.initDOQueryFilter(mockParams);

        List<EntranceHistory> res = Mockito.mock(List.class);
        Mockito.doReturn(res).when(entrancehistorydao).selectByExample(example);
        Iterator iteratorMock = Mockito.mock(Iterator.class);
        Mockito.when(res.iterator()).thenReturn(iteratorMock);
        Mockito.when(iteratorMock.hasNext()).thenReturn(true, false);
        Mockito.when(iteratorMock.next()).thenReturn(entityList);
        Assert.assertEquals(entityList, entrancehistoryService.getListByFilter(entrancehistoryfilterMapper), "异常");
	}

	@Test(groups = "groupGet", dependsOnMethods = "getListByFilterTest")
	public void getFilterMapListTest()
	{
		List<Map<String, Object>> entityMapList = new ArrayList<>();
        List<EntranceHistory> t1 = Mockito.mock(ArrayList.class);
        List<EntranceHistory> t2 = null;
        Mockito.when(entrancehistoryService.getListByFilter(entrancehistoryfilterMapper)).thenReturn(t1);
        Mockito.doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocationOnMock) throws Throwable {
                Object argument = invocationOnMock.getArgument(0);
                EntranceHistory.class.getDeclaredMethod("accept", EntranceHistory.class).invoke(argument, 1);
                return argument;
            }
        }).when(t1).forEach(entity -> entityMapList.add(EntranceHistorySimpleMapper.buildMap(entity)));
        Assert.assertEquals(entityMapList, entrancehistoryService.getFilterMapList(entrancehistoryfilterMapper), "异常");
	}

	@Test(groups = "groupPost", dependsOnMethods = "getByPKTest", expectedExceptions = StatusException.class)
	public void postTestException()
	{
		StatusException e = new StatusException("POST_ENTITY_DUPLICATE");
        entrancehistory = new EntranceHistory();
        Mockito.when(entrancehistorydao.insertSelective(EntranceHistoryData.convert(entrancehistory, new EntranceHistoryDO()))).thenThrow(e);
        EntranceHistory res = entrancehistoryService.post(entrancehistory);
        throw e;
	}

	@Test(groups = "groupPost", dependsOnMethods = "getByPKTest")
	public void postTest()
	{
		 EntranceHistory test = new  EntranceHistory();
 EntranceHistory spyEntranceHistory = Mockito.spy(test);
        Mockito.when(entrancehistorydao.insertSelective(EntranceHistoryData.convert(test, new EntranceHistoryDO()))).thenReturn(1);
        EntranceHistory res = entrancehistoryService.post(test);
	}

	@Test(groups = "groupUpadte", dependsOnMethods = "getByPKTest", expectedExceptions = NullPointerException.class)
	public void updateTest()
	{
		int actual = 1;
        Mockito.when(entrancehistorydao.updateByPrimaryKeySelective(EntranceHistoryData.convert(entrancehistory, new EntranceHistoryDO()))).thenReturn(1);
        Assert.assertEquals(actual, entrancehistorydao.updateByPrimaryKeySelective(EntranceHistoryData.convert(entrancehistory, new EntranceHistoryDO())), "不相等");

	}

	@Test(groups = "groupPut", dependsOnMethods = "getByPKTest")
	public void putTestIsNull()
	{
		EntranceHistory putEntity=new EntranceHistory();
        putEntity.setId("1");
        Object actual=null;
        Mockito.when(entrancehistoryService.getByPK(putEntity.getId())).thenReturn(null);
        Mockito.when(entrancehistorydao.insertSelective(EntranceHistoryData.convert(putEntity, new EntranceHistoryDO()))).thenReturn(1);
        Assert.assertEquals(actual,entrancehistoryService.put(putEntity),"不相等");
	}

	@Test(groups = "groupDelete")
	public void deleteTest()
	{
		String testid = "1";
        AtomicInteger count = new AtomicInteger();
        Mockito.when(count.addAndGet(entrancehistorydao.deleteByPrimaryKey(testid))).thenReturn(1);
        int actual = entrancehistoryService.delete(testid);
        Assert.assertEquals(actual, 1, "不相等");
	}

	@Test(groups = "groupGet", dependsOnMethods = "getCountByFilterTest")
	public void getRateAndCountByFilterTest()
	{
		Map<String, Map<String, Object>> res = new HashMap<>();
        List<String> groupBy = Mockito.mock(List.class);
        res = entrancehistoryService.getFilterListGroup(entrancehistoryfilterMapper, groupBy);
        Assert.assertEquals(res.size(), 0, "不相等");
	}

}