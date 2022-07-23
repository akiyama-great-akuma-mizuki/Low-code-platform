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
public class ParkPlacetest {
	@Mock
	public ParkPlaceDAO parkplacedao;

	@Mock
	public ParkPlaceSimpleMapper parkplaceSimpleMapper;

	@Mock
	public ParkPlace parkplace;

	@Mock
	public ParkPlaceFilterMapper parkplacefilterMapper;

	@InjectMocks
	public ParkPlaceService parkplaceService;

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
        ParkPlaceDO parkplacedo = new ParkPlaceDO();
        parkplacedo.setId(testid);
        Mockito.when(parkplacedao.selectByPrimaryKey(testid)).thenReturn(parkplacedo);
        Assert.assertEquals(parkplaceService.getByPK(testid).getId(), testid, "不相等");
	}

	@Test(groups = "getGet", dependsOnMethods = "getByPKTest")
	public void getSimpleMapByPKTest()
	{
		String testid = mockParams.get("id").toString();
        Map<String, Object> res = parkplaceSimpleMapper.buildMap(parkplaceService.getByPK(testid));
       Assert.assertEquals(parkplaceService.getSimpleMapByPK(testid), res, "getSimpleMapByPK不相等");
	}

	@Test(groups = "groupGet", dependsOnMethods = "getByPKTest")
	public void getDetailMapByPKTestIsNull()
	{
		String testid = "1";
        Mockito.when(parkplaceService.getByPK(testid)).thenReturn(null);
        Assert.assertEquals(null, parkplaceService.getDetailMapByPK(testid), "异常");
	}

	@Test(groups = "groupGet")
	public void getCountByFilterTest()
	{
		        Long count = 0L;
        Mockito.doReturn(mockParams).when(parkplacefilterMapper).buildMap();
        ParkPlaceDOExample example = ParkPlaceFilter.initDOQueryFilter(mockParams);
        Mockito.doReturn(count).when(parkplacedao).countByExample(example);
        Assert.assertEquals(count, parkplaceService.getCountByFilter(parkplacefilterMapper), "异常");

	}

	@Test(groups = "groupGet")
	public void getListByFilterTest()
	{
		List<ParkPlace> entityList = new ArrayList<>();
        Mockito.doReturn(mockParams).when(parkplacefilterMapper).buildMap();
        ParkPlaceDOExample example = ParkPlaceFilter.initDOQueryFilter(mockParams);

        List<ParkPlace> res = Mockito.mock(List.class);
        Mockito.doReturn(res).when(parkplacedao).selectByExample(example);
        Iterator iteratorMock = Mockito.mock(Iterator.class);
        Mockito.when(res.iterator()).thenReturn(iteratorMock);
        Mockito.when(iteratorMock.hasNext()).thenReturn(true, false);
        Mockito.when(iteratorMock.next()).thenReturn(entityList);
        Assert.assertEquals(entityList, parkplaceService.getListByFilter(parkplacefilterMapper), "异常");
	}

	@Test(groups = "groupGet", dependsOnMethods = "getListByFilterTest")
	public void getFilterMapListTest()
	{
		List<Map<String, Object>> entityMapList = new ArrayList<>();
        List<ParkPlace> t1 = Mockito.mock(ArrayList.class);
        List<ParkPlace> t2 = null;
        Mockito.when(parkplaceService.getListByFilter(parkplacefilterMapper)).thenReturn(t1);
        Mockito.doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocationOnMock) throws Throwable {
                Object argument = invocationOnMock.getArgument(0);
                ParkPlace.class.getDeclaredMethod("accept", ParkPlace.class).invoke(argument, 1);
                return argument;
            }
        }).when(t1).forEach(entity -> entityMapList.add(ParkPlaceSimpleMapper.buildMap(entity)));
        Assert.assertEquals(entityMapList, parkplaceService.getFilterMapList(parkplacefilterMapper), "异常");
	}

	@Test(groups = "groupPost", dependsOnMethods = "getByPKTest", expectedExceptions = StatusException.class)
	public void postTestException()
	{
		StatusException e = new StatusException("POST_ENTITY_DUPLICATE");
        parkplace = new ParkPlace();
        Mockito.when(parkplacedao.insertSelective(ParkPlaceData.convert(parkplace, new ParkPlaceDO()))).thenThrow(e);
        ParkPlace res = parkplaceService.post(parkplace);
        throw e;
	}

	@Test(groups = "groupPost", dependsOnMethods = "getByPKTest")
	public void postTest()
	{
		 ParkPlace test = new  ParkPlace();
 ParkPlace spyParkPlace = Mockito.spy(test);
        Mockito.when(parkplacedao.insertSelective(ParkPlaceData.convert(test, new ParkPlaceDO()))).thenReturn(1);
        ParkPlace res = parkplaceService.post(test);
	}

	@Test(groups = "groupUpadte", dependsOnMethods = "getByPKTest", expectedExceptions = NullPointerException.class)
	public void updateTest()
	{
		int actual = 1;
        Mockito.when(parkplacedao.updateByPrimaryKeySelective(ParkPlaceData.convert(parkplace, new ParkPlaceDO()))).thenReturn(1);
        Assert.assertEquals(actual, parkplacedao.updateByPrimaryKeySelective(ParkPlaceData.convert(parkplace, new ParkPlaceDO())), "不相等");

	}

	@Test(groups = "groupPut", dependsOnMethods = "getByPKTest")
	public void putTestIsNull()
	{
		ParkPlace putEntity=new ParkPlace();
        putEntity.setId("1");
        Object actual=null;
        Mockito.when(parkplaceService.getByPK(putEntity.getId())).thenReturn(null);
        Mockito.when(parkplacedao.insertSelective(ParkPlaceData.convert(putEntity, new ParkPlaceDO()))).thenReturn(1);
        Assert.assertEquals(actual,parkplaceService.put(putEntity),"不相等");
	}

	@Test(groups = "groupDelete")
	public void deleteTest()
	{
		String testid = "1";
        AtomicInteger count = new AtomicInteger();
        Mockito.when(count.addAndGet(parkplacedao.deleteByPrimaryKey(testid))).thenReturn(1);
        int actual = parkplaceService.delete(testid);
        Assert.assertEquals(actual, 1, "不相等");
	}

	@Test(groups = "groupGet", dependsOnMethods = "getCountByFilterTest")
	public void getRateAndCountByFilterTest()
	{
		Map<String, Map<String, Object>> res = new HashMap<>();
        List<String> groupBy = Mockito.mock(List.class);
        res = parkplaceService.getFilterListGroup(parkplacefilterMapper, groupBy);
        Assert.assertEquals(res.size(), 0, "不相等");
	}

}