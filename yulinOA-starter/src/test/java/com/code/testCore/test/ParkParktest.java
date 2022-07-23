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
public class ParkParktest {
	@Mock
	public ParkParkDAO parkparkdao;

	@Mock
	public ParkParkSimpleMapper parkparkSimpleMapper;

	@Mock
	public ParkPark parkpark;

	@Mock
	public ParkParkFilterMapper parkparkfilterMapper;

	@InjectMocks
	public ParkParkService parkparkService;

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
        ParkParkDO parkparkdo = new ParkParkDO();
        parkparkdo.setId(testid);
        Mockito.when(parkparkdao.selectByPrimaryKey(testid)).thenReturn(parkparkdo);
        Assert.assertEquals(parkparkService.getByPK(testid).getId(), testid, "不相等");
	}

	@Test(groups = "getGet", dependsOnMethods = "getByPKTest")
	public void getSimpleMapByPKTest()
	{
		String testid = mockParams.get("id").toString();
        Map<String, Object> res = parkparkSimpleMapper.buildMap(parkparkService.getByPK(testid));
       Assert.assertEquals(parkparkService.getSimpleMapByPK(testid), res, "getSimpleMapByPK不相等");
	}

	@Test(groups = "groupGet", dependsOnMethods = "getByPKTest")
	public void getDetailMapByPKTestIsNull()
	{
		String testid = "1";
        Mockito.when(parkparkService.getByPK(testid)).thenReturn(null);
        Assert.assertEquals(null, parkparkService.getDetailMapByPK(testid), "异常");
	}

	@Test(groups = "groupGet")
	public void getCountByFilterTest()
	{
		        Long count = 0L;
        Mockito.doReturn(mockParams).when(parkparkfilterMapper).buildMap();
        ParkParkDOExample example = ParkParkFilter.initDOQueryFilter(mockParams);
        Mockito.doReturn(count).when(parkparkdao).countByExample(example);
        Assert.assertEquals(count, parkparkService.getCountByFilter(parkparkfilterMapper), "异常");

	}

	@Test(groups = "groupGet")
	public void getListByFilterTest()
	{
		List<ParkPark> entityList = new ArrayList<>();
        Mockito.doReturn(mockParams).when(parkparkfilterMapper).buildMap();
        ParkParkDOExample example = ParkParkFilter.initDOQueryFilter(mockParams);

        List<ParkPark> res = Mockito.mock(List.class);
        Mockito.doReturn(res).when(parkparkdao).selectByExample(example);
        Iterator iteratorMock = Mockito.mock(Iterator.class);
        Mockito.when(res.iterator()).thenReturn(iteratorMock);
        Mockito.when(iteratorMock.hasNext()).thenReturn(true, false);
        Mockito.when(iteratorMock.next()).thenReturn(entityList);
        Assert.assertEquals(entityList, parkparkService.getListByFilter(parkparkfilterMapper), "异常");
	}

	@Test(groups = "groupGet", dependsOnMethods = "getListByFilterTest")
	public void getFilterMapListTest()
	{
		List<Map<String, Object>> entityMapList = new ArrayList<>();
        List<ParkPark> t1 = Mockito.mock(ArrayList.class);
        List<ParkPark> t2 = null;
        Mockito.when(parkparkService.getListByFilter(parkparkfilterMapper)).thenReturn(t1);
        Mockito.doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocationOnMock) throws Throwable {
                Object argument = invocationOnMock.getArgument(0);
                ParkPark.class.getDeclaredMethod("accept", ParkPark.class).invoke(argument, 1);
                return argument;
            }
        }).when(t1).forEach(entity -> entityMapList.add(ParkParkSimpleMapper.buildMap(entity)));
        Assert.assertEquals(entityMapList, parkparkService.getFilterMapList(parkparkfilterMapper), "异常");
	}

	@Test(groups = "groupPost", dependsOnMethods = "getByPKTest", expectedExceptions = StatusException.class)
	public void postTestException()
	{
		StatusException e = new StatusException("POST_ENTITY_DUPLICATE");
        parkpark = new ParkPark();
        Mockito.when(parkparkdao.insertSelective(ParkParkData.convert(parkpark, new ParkParkDO()))).thenThrow(e);
        ParkPark res = parkparkService.post(parkpark);
        throw e;
	}

	@Test(groups = "groupPost", dependsOnMethods = "getByPKTest")
	public void postTest()
	{
		 ParkPark test = new  ParkPark();
 ParkPark spyParkPark = Mockito.spy(test);
        Mockito.when(parkparkdao.insertSelective(ParkParkData.convert(test, new ParkParkDO()))).thenReturn(1);
        ParkPark res = parkparkService.post(test);
	}

	@Test(groups = "groupUpadte", dependsOnMethods = "getByPKTest", expectedExceptions = NullPointerException.class)
	public void updateTest()
	{
		int actual = 1;
        Mockito.when(parkparkdao.updateByPrimaryKeySelective(ParkParkData.convert(parkpark, new ParkParkDO()))).thenReturn(1);
        Assert.assertEquals(actual, parkparkdao.updateByPrimaryKeySelective(ParkParkData.convert(parkpark, new ParkParkDO())), "不相等");

	}

	@Test(groups = "groupPut", dependsOnMethods = "getByPKTest")
	public void putTestIsNull()
	{
		ParkPark putEntity=new ParkPark();
        putEntity.setId("1");
        Object actual=null;
        Mockito.when(parkparkService.getByPK(putEntity.getId())).thenReturn(null);
        Mockito.when(parkparkdao.insertSelective(ParkParkData.convert(putEntity, new ParkParkDO()))).thenReturn(1);
        Assert.assertEquals(actual,parkparkService.put(putEntity),"不相等");
	}

	@Test(groups = "groupDelete")
	public void deleteTest()
	{
		String testid = "1";
        AtomicInteger count = new AtomicInteger();
        Mockito.when(count.addAndGet(parkparkdao.deleteByPrimaryKey(testid))).thenReturn(1);
        int actual = parkparkService.delete(testid);
        Assert.assertEquals(actual, 1, "不相等");
	}

	@Test(groups = "groupGet", dependsOnMethods = "getCountByFilterTest")
	public void getRateAndCountByFilterTest()
	{
		Map<String, Map<String, Object>> res = new HashMap<>();
        List<String> groupBy = Mockito.mock(List.class);
        res = parkparkService.getFilterListGroup(parkparkfilterMapper, groupBy);
        Assert.assertEquals(res.size(), 0, "不相等");
	}

}