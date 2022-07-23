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
public class BusinessTriptest {
	@Mock
	public BusinessTripDAO businesstripdao;

	@Mock
	public BusinessTripSimpleMapper businesstripSimpleMapper;

	@Mock
	public BusinessTrip businesstrip;

	@Mock
	public BusinessTripFilterMapper businesstripfilterMapper;

	@InjectMocks
	public BusinessTripService businesstripService;

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
        BusinessTripDO businesstripdo = new BusinessTripDO();
        businesstripdo.setId(testid);
        Mockito.when(businesstripdao.selectByPrimaryKey(testid)).thenReturn(businesstripdo);
        Assert.assertEquals(businesstripService.getByPK(testid).getId(), testid, "不相等");
	}

	@Test(groups = "getGet", dependsOnMethods = "getByPKTest")
	public void getSimpleMapByPKTest()
	{
		String testid = mockParams.get("id").toString();
        Map<String, Object> res = businesstripSimpleMapper.buildMap(businesstripService.getByPK(testid));
       Assert.assertEquals(businesstripService.getSimpleMapByPK(testid), res, "getSimpleMapByPK不相等");
	}

	@Test(groups = "groupGet", dependsOnMethods = "getByPKTest")
	public void getDetailMapByPKTestIsNull()
	{
		String testid = "1";
        Mockito.when(businesstripService.getByPK(testid)).thenReturn(null);
        Assert.assertEquals(null, businesstripService.getDetailMapByPK(testid), "异常");
	}

	@Test(groups = "groupGet")
	public void getCountByFilterTest()
	{
		        Long count = 0L;
        Mockito.doReturn(mockParams).when(businesstripfilterMapper).buildMap();
        BusinessTripDOExample example = BusinessTripFilter.initDOQueryFilter(mockParams);
        Mockito.doReturn(count).when(businesstripdao).countByExample(example);
        Assert.assertEquals(count, businesstripService.getCountByFilter(businesstripfilterMapper), "异常");

	}

	@Test(groups = "groupGet")
	public void getListByFilterTest()
	{
		List<BusinessTrip> entityList = new ArrayList<>();
        Mockito.doReturn(mockParams).when(businesstripfilterMapper).buildMap();
        BusinessTripDOExample example = BusinessTripFilter.initDOQueryFilter(mockParams);

        List<BusinessTrip> res = Mockito.mock(List.class);
        Mockito.doReturn(res).when(businesstripdao).selectByExample(example);
        Iterator iteratorMock = Mockito.mock(Iterator.class);
        Mockito.when(res.iterator()).thenReturn(iteratorMock);
        Mockito.when(iteratorMock.hasNext()).thenReturn(true, false);
        Mockito.when(iteratorMock.next()).thenReturn(entityList);
        Assert.assertEquals(entityList, businesstripService.getListByFilter(businesstripfilterMapper), "异常");
	}

	@Test(groups = "groupGet", dependsOnMethods = "getListByFilterTest")
	public void getFilterMapListTest()
	{
		List<Map<String, Object>> entityMapList = new ArrayList<>();
        List<BusinessTrip> t1 = Mockito.mock(ArrayList.class);
        List<BusinessTrip> t2 = null;
        Mockito.when(businesstripService.getListByFilter(businesstripfilterMapper)).thenReturn(t1);
        Mockito.doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocationOnMock) throws Throwable {
                Object argument = invocationOnMock.getArgument(0);
                BusinessTrip.class.getDeclaredMethod("accept", BusinessTrip.class).invoke(argument, 1);
                return argument;
            }
        }).when(t1).forEach(entity -> entityMapList.add(BusinessTripSimpleMapper.buildMap(entity)));
        Assert.assertEquals(entityMapList, businesstripService.getFilterMapList(businesstripfilterMapper), "异常");
	}

	@Test(groups = "groupPost", dependsOnMethods = "getByPKTest", expectedExceptions = StatusException.class)
	public void postTestException()
	{
		StatusException e = new StatusException("POST_ENTITY_DUPLICATE");
        businesstrip = new BusinessTrip();
        Mockito.when(businesstripdao.insertSelective(BusinessTripData.convert(businesstrip, new BusinessTripDO()))).thenThrow(e);
        BusinessTrip res = businesstripService.post(businesstrip);
        throw e;
	}

	@Test(groups = "groupPost", dependsOnMethods = "getByPKTest")
	public void postTest()
	{
		 BusinessTrip test = new  BusinessTrip();
 BusinessTrip spyBusinessTrip = Mockito.spy(test);
        Mockito.when(businesstripdao.insertSelective(BusinessTripData.convert(test, new BusinessTripDO()))).thenReturn(1);
        BusinessTrip res = businesstripService.post(test);
	}

	@Test(groups = "groupUpadte", dependsOnMethods = "getByPKTest", expectedExceptions = NullPointerException.class)
	public void updateTest()
	{
		int actual = 1;
        Mockito.when(businesstripdao.updateByPrimaryKeySelective(BusinessTripData.convert(businesstrip, new BusinessTripDO()))).thenReturn(1);
        Assert.assertEquals(actual, businesstripdao.updateByPrimaryKeySelective(BusinessTripData.convert(businesstrip, new BusinessTripDO())), "不相等");

	}

	@Test(groups = "groupPut", dependsOnMethods = "getByPKTest")
	public void putTestIsNull()
	{
		BusinessTrip putEntity=new BusinessTrip();
        putEntity.setId("1");
        Object actual=null;
        Mockito.when(businesstripService.getByPK(putEntity.getId())).thenReturn(null);
        Mockito.when(businesstripdao.insertSelective(BusinessTripData.convert(putEntity, new BusinessTripDO()))).thenReturn(1);
        Assert.assertEquals(actual,businesstripService.put(putEntity),"不相等");
	}

	@Test(groups = "groupDelete")
	public void deleteTest()
	{
		String testid = "1";
        AtomicInteger count = new AtomicInteger();
        Mockito.when(count.addAndGet(businesstripdao.deleteByPrimaryKey(testid))).thenReturn(1);
        int actual = businesstripService.delete(testid);
        Assert.assertEquals(actual, 1, "不相等");
	}

	@Test(groups = "groupGet", dependsOnMethods = "getCountByFilterTest")
	public void getRateAndCountByFilterTest()
	{
		Map<String, Map<String, Object>> res = new HashMap<>();
        List<String> groupBy = Mockito.mock(List.class);
        res = businesstripService.getFilterListGroup(businesstripfilterMapper, groupBy);
        Assert.assertEquals(res.size(), 0, "不相等");
	}

}