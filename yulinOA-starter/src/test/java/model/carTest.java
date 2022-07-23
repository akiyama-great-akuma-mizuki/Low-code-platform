package model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.horsecoder.common.status.StatusException;
import com.AppStarter;
import com.horsecoder.yulinOA.sys.datafilter.CarFilter;
import com.horsecoder.yulinOA.sys.datainterface.CarDAO;
import com.horsecoder.yulinOA.sys.dataobject.CarDO;
import com.horsecoder.yulinOA.sys.dataobject.CarDOExample;
import com.horsecoder.yulinOA.sys.model.*;
import com.horsecoder.yulinOA.sys.service.CarService;
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

import static org.mockito.Mockito.*;

/**
 * Abstract controller tier base test class for TestNG.
 *
 * @author zzl
 * @version 2022-7-6
 */
//@SpringBootTest(classes = AppStarter.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@ContextConfiguration(classes = AppStarter.class)
@SpringBootTest(classes = AppStarter.class)
public class carTest {

    @InjectMocks
    private CarService carService;
    @Mock
    private CarDAO cardao;
    @Mock
    private CarSimpleMapper carSimpleMapper;
    @Mock
    private Car car;
    @Mock
    CarFilterMapper filterMapper;
    @Mock
    CarFilter carFilter;
    @Mock
    private List<Map<String, Object>> carList;

    private Map<String, Object> mockParams = new HashMap<String, Object>();

//    @Autowired
//    private JedisPool jedisPool;


    @BeforeTest(alwaysRun = true)
    public void beforeTest() {
        MockitoAnnotations.initMocks(this);
        String test =this.getClass().getName();
        String id=prepareData(test);
        //carList = loadData("com.code.testCore.entity.Car");
    }

    public String prepareData(String key) {
        System.out.println(key);
        return key;
    }

    public static List<Map<String, Object>> loadData(String key) {
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

//    @Test(groups = "groupGet", enabled = false)
//    public void contextLoads() {
//        Jedis jedis = jedisPool.getResource();
//        String value = jedis.get("bookname");
//        System.out.println(value);
//        jedis.close();
//    }


    @Test(groups = "groupGet")
    public void getByPKTest() {

        String testid = "1";
        CarDO cardo = new CarDO();
        cardo.setCarID(testid);
        Mockito.when(cardao.selectByPrimaryKey(testid)).thenReturn(cardo);
        Assert.assertEquals(carService.getByPK(testid).getCarID(), testid, "不相等");

    }

    @Test(groups = "getGet", dependsOnMethods = "getByPKTest",enabled = false)
    public void getSimpleMapByPKTest() {
        String testid = mockParams.get("id").toString();
        Map<String, Object> res = carSimpleMapper.buildMap(carService.getByPK(testid));
        //Mockito.when(carSimpleMapper.buildMap(carService.getByPK(testid))).thenReturn(res);
        Assert.assertEquals(carService.getSimpleMapByPK(testid), res, "getSimpleMapByPK不相等");
    }

    @Test(groups = "groupGet", dependsOnMethods = "getByPKTest")
    public void getDetailMapByPKTestIsNull() {
        String testid = "1";
        when(carService.getByPK(testid)).thenReturn(null);
        Assert.assertEquals(null, carService.getDetailMapByPK(testid), "异常");

    }

    //跨服务
    @Test(groups = "groupGet1", dependsOnMethods = "getByPKTest",enabled = false)
    public void getDetailMapByPKTest() {
        String testid = mockParams.get("id").toString();
        CarDO cardo = new CarDO();
        cardo.setCarID(testid);
        Mockito.when(cardao.selectByPrimaryKey(testid)).thenReturn(cardo);
    }

    @Test(groups = "groupGet")
    public void getCountByFilterTest() {
        Long count = 0L;
        Mockito.doReturn(mockParams).when(filterMapper).buildMap();
        CarDOExample example = CarFilter.initDOQueryFilter(mockParams);
        Mockito.doReturn(count).when(cardao).countByExample(example);
        Assert.assertEquals(count, carService.getCountByFilter(filterMapper), "异常");


    }

    @Test(groups = "groupGet")
    public void getListByFilterTest() {
        List<Car> entityList = new ArrayList<>();
        Mockito.doReturn(mockParams).when(filterMapper).buildMap();
        CarDOExample example = CarFilter.initDOQueryFilter(mockParams);

        List<Car> res = mock(List.class);
        Mockito.doReturn(res).when(cardao).selectByExample(example);
        Iterator iteratorMock = mock(Iterator.class);
        Mockito.when(res.iterator()).thenReturn(iteratorMock);
        Mockito.when(iteratorMock.hasNext()).thenReturn(true, false);
        Mockito.when(iteratorMock.next()).thenReturn(entityList);
        Assert.assertEquals(entityList, carService.getListByFilter(filterMapper), "异常");
    }

    @Test(groups = "groupGet")
    public void getListByRelatedIdTestIsZero() {
        List<String> idList = new ArrayList<>();
        List<Car> entityList = new ArrayList<>();
        Assert.assertEquals(entityList, carService.getListByRelatedId(idList), "failure");
    }

    @Test(groups = "groupGet")
    public void getListByRelatedIdTest() {
        List<String> idList = new ArrayList<>();
        idList.add("1");
        List<Car> entityList = new ArrayList<>();
        Mockito.doReturn(mockParams).when(filterMapper).buildMap();
        CarDOExample example = CarFilter.initIdQueryFilter(idList);
        List<Car> res = mock(List.class);
        Mockito.doReturn(res).when(cardao).selectByExample(example);
        Iterator iteratorMock = mock(Iterator.class);
        Mockito.when(res.iterator()).thenReturn(iteratorMock);
        Mockito.when(iteratorMock.hasNext()).thenReturn(true, false);
        Mockito.when(iteratorMock.next()).thenReturn(entityList);

        //Assert.assertEquals(entityList);
    }

    @Test(groups = "groupGet", dependsOnMethods = "getListByFilterTest")
    public void getFilterMapListTest() {
        List<Map<String, Object>> entityMapList = new ArrayList<>();
        List<Car> t1 = mock(ArrayList.class);
        t1.add(new Car("1", "zzl", "1", "3", "5", "5", new Date(), "8", new Date(), new Date()));
        t1.add(new Car("2", "mjw", "1", "3", "5", "5", new Date(), "8", new Date(), new Date()));
        List<Car> t2 = null;
        when(carService.getListByFilter(filterMapper)).thenReturn(t1);
        Mockito.doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocationOnMock) throws Throwable {
                Object argument = invocationOnMock.getArgument(0);
                Car.class.getDeclaredMethod("accept", Object.class).invoke(argument, 1);
                return argument;
            }
        }).when(t1).forEach(entity -> entityMapList.add(CarSimpleMapper.buildMap(entity)));
        Assert.assertEquals(entityMapList, carService.getFilterMapList(filterMapper), "异常");


    }

    //跨服务
    @Test
    public void getFilterDetailMapListTest() {

    }

    @Test(groups = "groupPost", dependsOnMethods = "getByPKTest", expectedExceptions = StatusException.class)
    public void postTestException() {
        StatusException e = new StatusException("POST_ENTITY_DUPLICATE");
        car = new Car("1", "zzl", "1", "3", "5", "5", new Date(), "8", new Date(), new Date());
        when(cardao.insertSelective(CarData.convert(car, new CarDO()))).thenThrow(e);
        Car res = carService.post(car);
        throw e;
    }

    @Test(groups = "groupPost", dependsOnMethods = "getByPKTest")
    public void postTest() {
        Car test = new Car("1", "zzl", "1", "3", "5", "5", new Date(), "8", new Date(), new Date());
        Car spyCar = Mockito.spy(test);
        when(cardao.insertSelective(CarData.convert(test, new CarDO()))).thenReturn(1);
        Car res = carService.post(car);
        // Assert.assertEquals(test.getId(),res.getId(),"不相等");

    }

    @Test(groups = "groupPost", dependsOnMethods = {"postTest", "postTestException"})
    public void postMappingTest() {

    }

    @Test(groups = "groupPost", dependsOnMethods = {"postTest", "postTestException"})
    public void postListTest() {

    }

    @Test(groups = "groupPost", dependsOnMethods = "postMappingTest")
    public void postMappingListTest() {

    }

    @Test(groups = "groupUpadte", dependsOnMethods = "getByPKTest", expectedExceptions = NullPointerException.class)
    public void updateTestIsNull() {
        Car testCar = null;
        Assert.assertNull(carService.update(testCar));
    }

    @Test(groups = "groupUpadte", dependsOnMethods = "getByPKTest")
    public void updateTest() {
        int actual = 1;
        when(cardao.updateByPrimaryKeySelective(CarData.convert(car, new CarDO()))).thenReturn(1);
        Assert.assertEquals(actual, cardao.updateByPrimaryKeySelective(CarData.convert(car, new CarDO())), "不相等");


    }

    @Test(groups = "groupUpadte", dependsOnMethods = "updateTest")
    public void updateMappingTest() {


    }

    @Test(groups = "groupUpadte", dependsOnMethods = "updateTest")
    public void updateListTest() {

    }

    @Test(groups = "groupUpadte", dependsOnMethods = "updateMappingTest")
    public void updateMappingListTest() {
        CarUpdateMapper updateMapper = mock(CarUpdateMapper.class);


    }

    @Test(groups = "groupPut", dependsOnMethods = "getByPKTest")
    public void putTestIsNull() {
        Car putEntity=new Car();
        putEntity.setId("1");
        Object actual=null;
        when(carService.getByPK(putEntity.getId())).thenReturn(null);
        when(cardao.insertSelective(CarData.convert(putEntity, new CarDO()))).thenReturn(1);
        Assert.assertEquals(actual,carService.put(putEntity),"不相等");
    }

    @Test(groups = "groupPut", dependsOnMethods = "getByPKTest")
    public void putTest() {
        Car putEntity=car;
        when(cardao.updateByPrimaryKeySelective(CarData.convert(putEntity,new CarDO()))).thenReturn(1);
        when(carService.getByPK(putEntity.getId())).thenReturn(car);
        //Assert.assertEquals(car,carService.put(car),"不相等");
    }

    @Test(groups = "groupPut", dependsOnMethods = {"putTestIsNull", "putTest"})
    public void putMappingTest() {

    }

    @Test(groups = "groupPut", dependsOnMethods = {"putTestIsNull", "putTest"})
    public void putListTest() {

    }

    @Test(groups = "groupPut", dependsOnMethods = "putMappingTest")
    public void putMappingListTest() {

    }

    @Test(groups = "groupDelete")
    public void deleteTest() {
        String testid = "1";
        AtomicInteger count = new AtomicInteger();
        when(count.addAndGet(cardao.deleteByPrimaryKey(testid))).thenReturn(1);
        int actual = carService.delete(testid);
        Assert.assertEquals(actual, 1, "不相等");
    }

    @Test(groups = "groupDelete", dependsOnMethods = "deleteTest")
    public void deleteListTest() {
        List<String> testkeys = mock(List.class);
        testkeys.add("1");
        int actual = 0;
        int expect = 1;
        AtomicInteger count = new AtomicInteger();
        Iterator iteratorMock = mock(Iterator.class);
        when(testkeys.iterator()).thenReturn(iteratorMock);
        Mockito.when(iteratorMock.hasNext()).thenReturn(true, false);
        Mockito.when(iteratorMock.next()).thenReturn(actual++);
        Mockito.when(count.addAndGet(carService.delete(iteratorMock.toString()))).thenReturn(count.addAndGet(actual));
        Assert.assertEquals(actual, expect, "不相等");
    }

    @Test(groups = "groupGet", dependsOnMethods = "getCountByFilterTest")
    public void getRateAndCountByFilterTest() {
        Map<String, Map<String, Object>> res = new HashMap<>();
        List<String> groupBy = mock(List.class);
        res = carService.getFilterListGroup(filterMapper, groupBy);
        Assert.assertEquals(res.size(), 0, "不相等");
    }

    @Test(groups = "groupGet", dependsOnMethods = "getRateAndCountByFilterTest")
    public void getRateAndCountListByFilterTest() {
        Map<String, Map<String, Object>> res = new HashMap<>();
        List<String> groupBy = mock(List.class);
        res = carService.getFilterListGroup(filterMapper, groupBy);
        Assert.assertEquals(res.size(), 0, "不相等");
    }

    @Test(groups = "groupGet", dependsOnMethods = "getFilterMapListTest")
    public void getFilterListGroupTestIsZero() {
        Map<String, Map<String, Object>> res = new HashMap<>();
        List<String> groupBy = mock(List.class);
        res = carService.getFilterListGroup(filterMapper, groupBy);
        Assert.assertEquals(res.size(), 0, "不相等");
    }

    @Test(groups = "groupGet", dependsOnMethods = "getFilterMapListTest",enabled = false)
    public void getFilterListGroupTest() {
        Map<String, Map<String, Object>> res;
        List<String> groupBy = new ArrayList<>();
        List<Map<String, Object>> entityMapList = new ArrayList<>();
        groupBy.add("1");
        groupBy.add("2");
        when(carService.getFilterDetailMapList(filterMapper)).thenReturn(entityMapList);
        res = carService.getFilterDetailListGroup(filterMapper, groupBy);
        Assert.assertEquals(null, res, "异常");
    }

    @Test(groups = "groupGet", dependsOnMethods = "getFilterDetailMapListTest")
    public void getFilterDetailListGroupTestIsZero() {
        Map<String, Map<String, Object>> res = new HashMap<>();
        List<String> groupBy = mock(List.class);
        res = carService.getFilterDetailListGroup(filterMapper, groupBy);
        Assert.assertEquals(res.size(), 0, "不相等");

    }

    //跨服务
    @Test(groups = "groupGet", dependsOnMethods = "getFilterDetailMapListTest",enabled = false)
    public void getFilterDetailListGroupTest() {
        Map<String, Map<String, Object>> res;
        List<String> groupBy = new ArrayList<>();
        List<Map<String, Object>> entityMapList = new ArrayList<>();
        groupBy.add("1");
        groupBy.add("2");
        when(carService.getFilterDetailMapList(filterMapper)).thenReturn(entityMapList);
        res = carService.getFilterDetailListGroup(filterMapper, groupBy);
        Assert.assertEquals(null, res, "异常");


    }
}
