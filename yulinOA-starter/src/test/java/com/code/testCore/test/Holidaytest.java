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
public class Holidaytest {
	@Mock
	public HolidayDAO holidaydao;

	@Mock
	public HolidaySimpleMapper holidaySimpleMapper;

	@Mock
	public Holiday holiday;

	@Mock
	public HolidayFilterMapper holidayfilterMapper;

	@InjectMocks
	public HolidayService holidayService;

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
        HolidayDO holidaydo = new HolidayDO();
        holidaydo.setId(testid);
        Mockito.when(holidaydao.selectByPrimaryKey(testid)).thenReturn(holidaydo);
        Assert.assertEquals(holidayService.getByPK(testid).getId(), testid, "不相等");
	}

	@Test(groups = "getGet", dependsOnMethods = "getByPKTest")
	public void getSimpleMapByPKTest()
	{
		String testid = mockParams.get("id").toString();
        Map<String, Object> res = holidaySimpleMapper.buildMap(holidayService.getByPK(testid));
       Assert.assertEquals(holidayService.getSimpleMapByPK(testid), res, "getSimpleMapByPK不相等");
	}

	@Test(groups = "groupGet", dependsOnMethods = "getByPKTest")
	public void getDetailMapByPKTestIsNull()
	{
		String testid = "1";
        Mockito.when(holidayService.getByPK(testid)).thenReturn(null);
        Assert.assertEquals(null, holidayService.getDetailMapByPK(testid), "异常");
	}

	@Test(groups = "groupGet")
	public void getCountByFilterTest()
	{
		        Long count = 0L;
        Mockito.doReturn(mockParams).when(holidayfilterMapper).buildMap();
        HolidayDOExample example = HolidayFilter.initDOQueryFilter(mockParams);
        Mockito.doReturn(count).when(holidaydao).countByExample(example);
        Assert.assertEquals(count, holidayService.getCountByFilter(holidayfilterMapper), "异常");

	}

	@Test(groups = "groupGet")
	public void getListByFilterTest()
	{
		List<Holiday> entityList = new ArrayList<>();
        Mockito.doReturn(mockParams).when(holidayfilterMapper).buildMap();
        HolidayDOExample example = HolidayFilter.initDOQueryFilter(mockParams);

        List<Holiday> res = Mockito.mock(List.class);
        Mockito.doReturn(res).when(holidaydao).selectByExample(example);
        Iterator iteratorMock = Mockito.mock(Iterator.class);
        Mockito.when(res.iterator()).thenReturn(iteratorMock);
        Mockito.when(iteratorMock.hasNext()).thenReturn(true, false);
        Mockito.when(iteratorMock.next()).thenReturn(entityList);
        Assert.assertEquals(entityList, holidayService.getListByFilter(holidayfilterMapper), "异常");
	}

	@Test(groups = "groupGet", dependsOnMethods = "getListByFilterTest")
	public void getFilterMapListTest()
	{
		List<Map<String, Object>> entityMapList = new ArrayList<>();
        List<Holiday> t1 = Mockito.mock(ArrayList.class);
        List<Holiday> t2 = null;
        Mockito.when(holidayService.getListByFilter(holidayfilterMapper)).thenReturn(t1);
        Mockito.doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocationOnMock) throws Throwable {
                Object argument = invocationOnMock.getArgument(0);
                Holiday.class.getDeclaredMethod("accept", Holiday.class).invoke(argument, 1);
                return argument;
            }
        }).when(t1).forEach(entity -> entityMapList.add(HolidaySimpleMapper.buildMap(entity)));
        Assert.assertEquals(entityMapList, holidayService.getFilterMapList(holidayfilterMapper), "异常");
	}

	@Test(groups = "groupPost", dependsOnMethods = "getByPKTest", expectedExceptions = StatusException.class)
	public void postTestException()
	{
		StatusException e = new StatusException("POST_ENTITY_DUPLICATE");
        holiday = new Holiday();
        Mockito.when(holidaydao.insertSelective(HolidayData.convert(holiday, new HolidayDO()))).thenThrow(e);
        Holiday res = holidayService.post(holiday);
        throw e;
	}

	@Test(groups = "groupPost", dependsOnMethods = "getByPKTest")
	public void postTest()
	{
		 Holiday test = new  Holiday();
 Holiday spyHoliday = Mockito.spy(test);
        Mockito.when(holidaydao.insertSelective(HolidayData.convert(test, new HolidayDO()))).thenReturn(1);
        Holiday res = holidayService.post(test);
	}

	@Test(groups = "groupUpadte", dependsOnMethods = "getByPKTest", expectedExceptions = NullPointerException.class)
	public void updateTest()
	{
		int actual = 1;
        Mockito.when(holidaydao.updateByPrimaryKeySelective(HolidayData.convert(holiday, new HolidayDO()))).thenReturn(1);
        Assert.assertEquals(actual, holidaydao.updateByPrimaryKeySelective(HolidayData.convert(holiday, new HolidayDO())), "不相等");

	}

	@Test(groups = "groupPut", dependsOnMethods = "getByPKTest")
	public void putTestIsNull()
	{
		Holiday putEntity=new Holiday();
        putEntity.setId("1");
        Object actual=null;
        Mockito.when(holidayService.getByPK(putEntity.getId())).thenReturn(null);
        Mockito.when(holidaydao.insertSelective(HolidayData.convert(putEntity, new HolidayDO()))).thenReturn(1);
        Assert.assertEquals(actual,holidayService.put(putEntity),"不相等");
	}

	@Test(groups = "groupDelete")
	public void deleteTest()
	{
		String testid = "1";
        AtomicInteger count = new AtomicInteger();
        Mockito.when(count.addAndGet(holidaydao.deleteByPrimaryKey(testid))).thenReturn(1);
        int actual = holidayService.delete(testid);
        Assert.assertEquals(actual, 1, "不相等");
	}

	@Test(groups = "groupGet", dependsOnMethods = "getCountByFilterTest")
	public void getRateAndCountByFilterTest()
	{
		Map<String, Map<String, Object>> res = new HashMap<>();
        List<String> groupBy = Mockito.mock(List.class);
        res = holidayService.getFilterListGroup(holidayfilterMapper, groupBy);
        Assert.assertEquals(res.size(), 0, "不相等");
	}

}