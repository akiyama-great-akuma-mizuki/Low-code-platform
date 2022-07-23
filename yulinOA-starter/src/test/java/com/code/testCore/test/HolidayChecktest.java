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
public class HolidayChecktest {
	@Mock
	public HolidayCheckDAO holidaycheckdao;

	@Mock
	public HolidayCheckSimpleMapper holidaycheckSimpleMapper;

	@Mock
	public HolidayCheck holidaycheck;

	@Mock
	public HolidayCheckFilterMapper holidaycheckfilterMapper;

	@InjectMocks
	public HolidayCheckService holidaycheckService;

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
        HolidayCheckDO holidaycheckdo = new HolidayCheckDO();
        holidaycheckdo.setId(testid);
        Mockito.when(holidaycheckdao.selectByPrimaryKey(testid)).thenReturn(holidaycheckdo);
        Assert.assertEquals(holidaycheckService.getByPK(testid).getId(), testid, "不相等");
	}

	@Test(groups = "getGet", dependsOnMethods = "getByPKTest")
	public void getSimpleMapByPKTest()
	{
		String testid = mockParams.get("id").toString();
        Map<String, Object> res = holidaycheckSimpleMapper.buildMap(holidaycheckService.getByPK(testid));
       Assert.assertEquals(holidaycheckService.getSimpleMapByPK(testid), res, "getSimpleMapByPK不相等");
	}

	@Test(groups = "groupGet", dependsOnMethods = "getByPKTest")
	public void getDetailMapByPKTestIsNull()
	{
		String testid = "1";
        Mockito.when(holidaycheckService.getByPK(testid)).thenReturn(null);
        Assert.assertEquals(null, holidaycheckService.getDetailMapByPK(testid), "异常");
	}

	@Test(groups = "groupGet")
	public void getCountByFilterTest()
	{
		        Long count = 0L;
        Mockito.doReturn(mockParams).when(holidaycheckfilterMapper).buildMap();
        HolidayCheckDOExample example = HolidayCheckFilter.initDOQueryFilter(mockParams);
        Mockito.doReturn(count).when(holidaycheckdao).countByExample(example);
        Assert.assertEquals(count, holidaycheckService.getCountByFilter(holidaycheckfilterMapper), "异常");

	}

	@Test(groups = "groupGet")
	public void getListByFilterTest()
	{
		List<HolidayCheck> entityList = new ArrayList<>();
        Mockito.doReturn(mockParams).when(holidaycheckfilterMapper).buildMap();
        HolidayCheckDOExample example = HolidayCheckFilter.initDOQueryFilter(mockParams);

        List<HolidayCheck> res = Mockito.mock(List.class);
        Mockito.doReturn(res).when(holidaycheckdao).selectByExample(example);
        Iterator iteratorMock = Mockito.mock(Iterator.class);
        Mockito.when(res.iterator()).thenReturn(iteratorMock);
        Mockito.when(iteratorMock.hasNext()).thenReturn(true, false);
        Mockito.when(iteratorMock.next()).thenReturn(entityList);
        Assert.assertEquals(entityList, holidaycheckService.getListByFilter(holidaycheckfilterMapper), "异常");
	}

	@Test(groups = "groupGet", dependsOnMethods = "getListByFilterTest")
	public void getFilterMapListTest()
	{
		List<Map<String, Object>> entityMapList = new ArrayList<>();
        List<HolidayCheck> t1 = Mockito.mock(ArrayList.class);
        List<HolidayCheck> t2 = null;
        Mockito.when(holidaycheckService.getListByFilter(holidaycheckfilterMapper)).thenReturn(t1);
        Mockito.doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocationOnMock) throws Throwable {
                Object argument = invocationOnMock.getArgument(0);
                HolidayCheck.class.getDeclaredMethod("accept", HolidayCheck.class).invoke(argument, 1);
                return argument;
            }
        }).when(t1).forEach(entity -> entityMapList.add(HolidayCheckSimpleMapper.buildMap(entity)));
        Assert.assertEquals(entityMapList, holidaycheckService.getFilterMapList(holidaycheckfilterMapper), "异常");
	}

	@Test(groups = "groupPost", dependsOnMethods = "getByPKTest", expectedExceptions = StatusException.class)
	public void postTestException()
	{
		StatusException e = new StatusException("POST_ENTITY_DUPLICATE");
        holidaycheck = new HolidayCheck();
        Mockito.when(holidaycheckdao.insertSelective(HolidayCheckData.convert(holidaycheck, new HolidayCheckDO()))).thenThrow(e);
        HolidayCheck res = holidaycheckService.post(holidaycheck);
        throw e;
	}

	@Test(groups = "groupPost", dependsOnMethods = "getByPKTest")
	public void postTest()
	{
		 HolidayCheck test = new  HolidayCheck();
 HolidayCheck spyHolidayCheck = Mockito.spy(test);
        Mockito.when(holidaycheckdao.insertSelective(HolidayCheckData.convert(test, new HolidayCheckDO()))).thenReturn(1);
        HolidayCheck res = holidaycheckService.post(test);
	}

	@Test(groups = "groupUpadte", dependsOnMethods = "getByPKTest", expectedExceptions = NullPointerException.class)
	public void updateTest()
	{
		int actual = 1;
        Mockito.when(holidaycheckdao.updateByPrimaryKeySelective(HolidayCheckData.convert(holidaycheck, new HolidayCheckDO()))).thenReturn(1);
        Assert.assertEquals(actual, holidaycheckdao.updateByPrimaryKeySelective(HolidayCheckData.convert(holidaycheck, new HolidayCheckDO())), "不相等");

	}

	@Test(groups = "groupPut", dependsOnMethods = "getByPKTest")
	public void putTestIsNull()
	{
		HolidayCheck putEntity=new HolidayCheck();
        putEntity.setId("1");
        Object actual=null;
        Mockito.when(holidaycheckService.getByPK(putEntity.getId())).thenReturn(null);
        Mockito.when(holidaycheckdao.insertSelective(HolidayCheckData.convert(putEntity, new HolidayCheckDO()))).thenReturn(1);
        Assert.assertEquals(actual,holidaycheckService.put(putEntity),"不相等");
	}

	@Test(groups = "groupDelete")
	public void deleteTest()
	{
		String testid = "1";
        AtomicInteger count = new AtomicInteger();
        Mockito.when(count.addAndGet(holidaycheckdao.deleteByPrimaryKey(testid))).thenReturn(1);
        int actual = holidaycheckService.delete(testid);
        Assert.assertEquals(actual, 1, "不相等");
	}

	@Test(groups = "groupGet", dependsOnMethods = "getCountByFilterTest")
	public void getRateAndCountByFilterTest()
	{
		Map<String, Map<String, Object>> res = new HashMap<>();
        List<String> groupBy = Mockito.mock(List.class);
        res = holidaycheckService.getFilterListGroup(holidaycheckfilterMapper, groupBy);
        Assert.assertEquals(res.size(), 0, "不相等");
	}

}