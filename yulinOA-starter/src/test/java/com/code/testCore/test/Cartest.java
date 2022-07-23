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
public class Cartest {
	@Mock
	public CarDAO cardao;

	@Mock
	public CarSimpleMapper carSimpleMapper;

	@Mock
	public Car car;

	@Mock
	public CarFilterMapper carfilterMapper;

	@InjectMocks
	public CarService carService;

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
        CarDO cardo = new CarDO();
        cardo.setId(testid);
        Mockito.when(cardao.selectByPrimaryKey(testid)).thenReturn(cardo);
        Assert.assertEquals(carService.getByPK(testid).getId(), testid, "不相等");
	}

	@Test(groups = "getGet", dependsOnMethods = "getByPKTest")
	public void getSimpleMapByPKTest()
	{
		String testid = mockParams.get("id").toString();
        Map<String, Object> res = carSimpleMapper.buildMap(carService.getByPK(testid));
       Assert.assertEquals(carService.getSimpleMapByPK(testid), res, "getSimpleMapByPK不相等");
	}

	@Test(groups = "groupGet", dependsOnMethods = "getByPKTest")
	public void getDetailMapByPKTestIsNull()
	{
		String testid = "1";
        Mockito.when(carService.getByPK(testid)).thenReturn(null);
        Assert.assertEquals(null, carService.getDetailMapByPK(testid), "异常");
	}

	@Test(groups = "groupGet")
	public void getCountByFilterTest()
	{
		        Long count = 0L;
        Mockito.doReturn(mockParams).when(carfilterMapper).buildMap();
        CarDOExample example = CarFilter.initDOQueryFilter(mockParams);
        Mockito.doReturn(count).when(cardao).countByExample(example);
        Assert.assertEquals(count, carService.getCountByFilter(carfilterMapper), "异常");

	}

	@Test(groups = "groupGet")
	public void getListByFilterTest()
	{
		List<Car> entityList = new ArrayList<>();
        Mockito.doReturn(mockParams).when(carfilterMapper).buildMap();
        CarDOExample example = CarFilter.initDOQueryFilter(mockParams);

        List<Car> res = Mockito.mock(List.class);
        Mockito.doReturn(res).when(cardao).selectByExample(example);
        Iterator iteratorMock = Mockito.mock(Iterator.class);
        Mockito.when(res.iterator()).thenReturn(iteratorMock);
        Mockito.when(iteratorMock.hasNext()).thenReturn(true, false);
        Mockito.when(iteratorMock.next()).thenReturn(entityList);
        Assert.assertEquals(entityList, carService.getListByFilter(carfilterMapper), "异常");
	}

	@Test(groups = "groupGet", dependsOnMethods = "getListByFilterTest")
	public void getFilterMapListTest()
	{
		List<Map<String, Object>> entityMapList = new ArrayList<>();
        List<Car> t1 = Mockito.mock(ArrayList.class);
        List<Car> t2 = null;
        Mockito.when(carService.getListByFilter(carfilterMapper)).thenReturn(t1);
        Mockito.doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocationOnMock) throws Throwable {
                Object argument = invocationOnMock.getArgument(0);
                Car.class.getDeclaredMethod("accept", Car.class).invoke(argument, 1);
                return argument;
            }
        }).when(t1).forEach(entity -> entityMapList.add(CarSimpleMapper.buildMap(entity)));
        Assert.assertEquals(entityMapList, carService.getFilterMapList(carfilterMapper), "异常");
	}

	@Test(groups = "groupPost", dependsOnMethods = "getByPKTest", expectedExceptions = StatusException.class)
	public void postTestException()
	{
		StatusException e = new StatusException("POST_ENTITY_DUPLICATE");
        car = new Car();
        Mockito.when(cardao.insertSelective(CarData.convert(car, new CarDO()))).thenThrow(e);
        Car res = carService.post(car);
        throw e;
	}

	@Test(groups = "groupPost", dependsOnMethods = "getByPKTest")
	public void postTest()
	{
		 Car test = new  Car();
 Car spyCar = Mockito.spy(test);
        Mockito.when(cardao.insertSelective(CarData.convert(test, new CarDO()))).thenReturn(1);
        Car res = carService.post(test);
	}

	@Test(groups = "groupUpadte", dependsOnMethods = "getByPKTest", expectedExceptions = NullPointerException.class)
	public void updateTest()
	{
		int actual = 1;
        Mockito.when(cardao.updateByPrimaryKeySelective(CarData.convert(car, new CarDO()))).thenReturn(1);
        Assert.assertEquals(actual, cardao.updateByPrimaryKeySelective(CarData.convert(car, new CarDO())), "不相等");

	}

	@Test(groups = "groupPut", dependsOnMethods = "getByPKTest")
	public void putTestIsNull()
	{
		Car putEntity=new Car();
        putEntity.setId("1");
        Object actual=null;
        Mockito.when(carService.getByPK(putEntity.getId())).thenReturn(null);
        Mockito.when(cardao.insertSelective(CarData.convert(putEntity, new CarDO()))).thenReturn(1);
        Assert.assertEquals(actual,carService.put(putEntity),"不相等");
	}

	@Test(groups = "groupDelete")
	public void deleteTest()
	{
		String testid = "1";
        AtomicInteger count = new AtomicInteger();
        Mockito.when(count.addAndGet(cardao.deleteByPrimaryKey(testid))).thenReturn(1);
        int actual = carService.delete(testid);
        Assert.assertEquals(actual, 1, "不相等");
	}

	@Test(groups = "groupGet", dependsOnMethods = "getCountByFilterTest")
	public void getRateAndCountByFilterTest()
	{
		Map<String, Map<String, Object>> res = new HashMap<>();
        List<String> groupBy = Mockito.mock(List.class);
        res = carService.getFilterListGroup(carfilterMapper, groupBy);
        Assert.assertEquals(res.size(), 0, "不相等");
	}

}