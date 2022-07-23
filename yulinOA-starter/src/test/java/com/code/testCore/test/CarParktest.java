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
public class CarParktest {
	@Mock
	public CarParkDAO carparkdao;

	@Mock
	public CarParkSimpleMapper carparkSimpleMapper;

	@Mock
	public CarPark carpark;

	@Mock
	public CarParkFilterMapper carparkfilterMapper;

	@InjectMocks
	public CarParkService carparkService;

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
        CarParkDO carparkdo = new CarParkDO();
        carparkdo.setId(testid);
        Mockito.when(carparkdao.selectByPrimaryKey(testid)).thenReturn(carparkdo);
        Assert.assertEquals(carparkService.getByPK(testid).getId(), testid, "不相等");
	}

	@Test(groups = "getGet", dependsOnMethods = "getByPKTest")
	public void getSimpleMapByPKTest()
	{
		String testid = mockParams.get("id").toString();
        Map<String, Object> res = carparkSimpleMapper.buildMap(carparkService.getByPK(testid));
       Assert.assertEquals(carparkService.getSimpleMapByPK(testid), res, "getSimpleMapByPK不相等");
	}

	@Test(groups = "groupGet", dependsOnMethods = "getByPKTest")
	public void getDetailMapByPKTestIsNull()
	{
		String testid = "1";
        Mockito.when(carparkService.getByPK(testid)).thenReturn(null);
        Assert.assertEquals(null, carparkService.getDetailMapByPK(testid), "异常");
	}

	@Test(groups = "groupGet")
	public void getCountByFilterTest()
	{
		        Long count = 0L;
        Mockito.doReturn(mockParams).when(carparkfilterMapper).buildMap();
        CarParkDOExample example = CarParkFilter.initDOQueryFilter(mockParams);
        Mockito.doReturn(count).when(carparkdao).countByExample(example);
        Assert.assertEquals(count, carparkService.getCountByFilter(carparkfilterMapper), "异常");

	}

	@Test(groups = "groupGet")
	public void getListByFilterTest()
	{
		List<CarPark> entityList = new ArrayList<>();
        Mockito.doReturn(mockParams).when(carparkfilterMapper).buildMap();
        CarParkDOExample example = CarParkFilter.initDOQueryFilter(mockParams);

        List<CarPark> res = Mockito.mock(List.class);
        Mockito.doReturn(res).when(carparkdao).selectByExample(example);
        Iterator iteratorMock = Mockito.mock(Iterator.class);
        Mockito.when(res.iterator()).thenReturn(iteratorMock);
        Mockito.when(iteratorMock.hasNext()).thenReturn(true, false);
        Mockito.when(iteratorMock.next()).thenReturn(entityList);
        Assert.assertEquals(entityList, carparkService.getListByFilter(carparkfilterMapper), "异常");
	}

	@Test(groups = "groupGet", dependsOnMethods = "getListByFilterTest")
	public void getFilterMapListTest()
	{
		List<Map<String, Object>> entityMapList = new ArrayList<>();
        List<CarPark> t1 = Mockito.mock(ArrayList.class);
        List<CarPark> t2 = null;
        Mockito.when(carparkService.getListByFilter(carparkfilterMapper)).thenReturn(t1);
        Mockito.doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocationOnMock) throws Throwable {
                Object argument = invocationOnMock.getArgument(0);
                CarPark.class.getDeclaredMethod("accept", CarPark.class).invoke(argument, 1);
                return argument;
            }
        }).when(t1).forEach(entity -> entityMapList.add(CarParkSimpleMapper.buildMap(entity)));
        Assert.assertEquals(entityMapList, carparkService.getFilterMapList(carparkfilterMapper), "异常");
	}

	@Test(groups = "groupPost", dependsOnMethods = "getByPKTest", expectedExceptions = StatusException.class)
	public void postTestException()
	{
		StatusException e = new StatusException("POST_ENTITY_DUPLICATE");
        carpark = new CarPark();
        Mockito.when(carparkdao.insertSelective(CarParkData.convert(carpark, new CarParkDO()))).thenThrow(e);
        CarPark res = carparkService.post(carpark);
        throw e;
	}

	@Test(groups = "groupPost", dependsOnMethods = "getByPKTest")
	public void postTest()
	{
		 CarPark test = new  CarPark();
 CarPark spyCarPark = Mockito.spy(test);
        Mockito.when(carparkdao.insertSelective(CarParkData.convert(test, new CarParkDO()))).thenReturn(1);
        CarPark res = carparkService.post(test);
	}

	@Test(groups = "groupUpadte", dependsOnMethods = "getByPKTest", expectedExceptions = NullPointerException.class)
	public void updateTest()
	{
		int actual = 1;
        Mockito.when(carparkdao.updateByPrimaryKeySelective(CarParkData.convert(carpark, new CarParkDO()))).thenReturn(1);
        Assert.assertEquals(actual, carparkdao.updateByPrimaryKeySelective(CarParkData.convert(carpark, new CarParkDO())), "不相等");

	}

	@Test(groups = "groupPut", dependsOnMethods = "getByPKTest")
	public void putTestIsNull()
	{
		CarPark putEntity=new CarPark();
        putEntity.setId("1");
        Object actual=null;
        Mockito.when(carparkService.getByPK(putEntity.getId())).thenReturn(null);
        Mockito.when(carparkdao.insertSelective(CarParkData.convert(putEntity, new CarParkDO()))).thenReturn(1);
        Assert.assertEquals(actual,carparkService.put(putEntity),"不相等");
	}

	@Test(groups = "groupDelete")
	public void deleteTest()
	{
		String testid = "1";
        AtomicInteger count = new AtomicInteger();
        Mockito.when(count.addAndGet(carparkdao.deleteByPrimaryKey(testid))).thenReturn(1);
        int actual = carparkService.delete(testid);
        Assert.assertEquals(actual, 1, "不相等");
	}

	@Test(groups = "groupGet", dependsOnMethods = "getCountByFilterTest")
	public void getRateAndCountByFilterTest()
	{
		Map<String, Map<String, Object>> res = new HashMap<>();
        List<String> groupBy = Mockito.mock(List.class);
        res = carparkService.getFilterListGroup(carparkfilterMapper, groupBy);
        Assert.assertEquals(res.size(), 0, "不相等");
	}

}