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
public class SchedulePersontest {
	@Mock
	public SchedulePersonDAO schedulepersondao;

	@Mock
	public SchedulePersonSimpleMapper schedulepersonSimpleMapper;

	@Mock
	public SchedulePerson scheduleperson;

	@Mock
	public SchedulePersonFilterMapper schedulepersonfilterMapper;

	@InjectMocks
	public SchedulePersonService schedulepersonService;

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
        SchedulePersonDO schedulepersondo = new SchedulePersonDO();
        schedulepersondo.setId(testid);
        Mockito.when(schedulepersondao.selectByPrimaryKey(testid)).thenReturn(schedulepersondo);
        Assert.assertEquals(schedulepersonService.getByPK(testid).getId(), testid, "不相等");
	}

	@Test(groups = "getGet", dependsOnMethods = "getByPKTest")
	public void getSimpleMapByPKTest()
	{
		String testid = mockParams.get("id").toString();
        Map<String, Object> res = schedulepersonSimpleMapper.buildMap(schedulepersonService.getByPK(testid));
       Assert.assertEquals(schedulepersonService.getSimpleMapByPK(testid), res, "getSimpleMapByPK不相等");
	}

	@Test(groups = "groupGet", dependsOnMethods = "getByPKTest")
	public void getDetailMapByPKTestIsNull()
	{
		String testid = "1";
        Mockito.when(schedulepersonService.getByPK(testid)).thenReturn(null);
        Assert.assertEquals(null, schedulepersonService.getDetailMapByPK(testid), "异常");
	}

	@Test(groups = "groupGet")
	public void getCountByFilterTest()
	{
		        Long count = 0L;
        Mockito.doReturn(mockParams).when(schedulepersonfilterMapper).buildMap();
        SchedulePersonDOExample example = SchedulePersonFilter.initDOQueryFilter(mockParams);
        Mockito.doReturn(count).when(schedulepersondao).countByExample(example);
        Assert.assertEquals(count, schedulepersonService.getCountByFilter(schedulepersonfilterMapper), "异常");

	}

	@Test(groups = "groupGet")
	public void getListByFilterTest()
	{
		List<SchedulePerson> entityList = new ArrayList<>();
        Mockito.doReturn(mockParams).when(schedulepersonfilterMapper).buildMap();
        SchedulePersonDOExample example = SchedulePersonFilter.initDOQueryFilter(mockParams);

        List<SchedulePerson> res = Mockito.mock(List.class);
        Mockito.doReturn(res).when(schedulepersondao).selectByExample(example);
        Iterator iteratorMock = Mockito.mock(Iterator.class);
        Mockito.when(res.iterator()).thenReturn(iteratorMock);
        Mockito.when(iteratorMock.hasNext()).thenReturn(true, false);
        Mockito.when(iteratorMock.next()).thenReturn(entityList);
        Assert.assertEquals(entityList, schedulepersonService.getListByFilter(schedulepersonfilterMapper), "异常");
	}

	@Test(groups = "groupGet", dependsOnMethods = "getListByFilterTest")
	public void getFilterMapListTest()
	{
		List<Map<String, Object>> entityMapList = new ArrayList<>();
        List<SchedulePerson> t1 = Mockito.mock(ArrayList.class);
        List<SchedulePerson> t2 = null;
        Mockito.when(schedulepersonService.getListByFilter(schedulepersonfilterMapper)).thenReturn(t1);
        Mockito.doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocationOnMock) throws Throwable {
                Object argument = invocationOnMock.getArgument(0);
                SchedulePerson.class.getDeclaredMethod("accept", SchedulePerson.class).invoke(argument, 1);
                return argument;
            }
        }).when(t1).forEach(entity -> entityMapList.add(SchedulePersonSimpleMapper.buildMap(entity)));
        Assert.assertEquals(entityMapList, schedulepersonService.getFilterMapList(schedulepersonfilterMapper), "异常");
	}

	@Test(groups = "groupPost", dependsOnMethods = "getByPKTest", expectedExceptions = StatusException.class)
	public void postTestException()
	{
		StatusException e = new StatusException("POST_ENTITY_DUPLICATE");
        scheduleperson = new SchedulePerson();
        Mockito.when(schedulepersondao.insertSelective(SchedulePersonData.convert(scheduleperson, new SchedulePersonDO()))).thenThrow(e);
        SchedulePerson res = schedulepersonService.post(scheduleperson);
        throw e;
	}

	@Test(groups = "groupPost", dependsOnMethods = "getByPKTest")
	public void postTest()
	{
		 SchedulePerson test = new  SchedulePerson();
 SchedulePerson spySchedulePerson = Mockito.spy(test);
        Mockito.when(schedulepersondao.insertSelective(SchedulePersonData.convert(test, new SchedulePersonDO()))).thenReturn(1);
        SchedulePerson res = schedulepersonService.post(test);
	}

	@Test(groups = "groupUpadte", dependsOnMethods = "getByPKTest", expectedExceptions = NullPointerException.class)
	public void updateTest()
	{
		int actual = 1;
        Mockito.when(schedulepersondao.updateByPrimaryKeySelective(SchedulePersonData.convert(scheduleperson, new SchedulePersonDO()))).thenReturn(1);
        Assert.assertEquals(actual, schedulepersondao.updateByPrimaryKeySelective(SchedulePersonData.convert(scheduleperson, new SchedulePersonDO())), "不相等");

	}

	@Test(groups = "groupPut", dependsOnMethods = "getByPKTest")
	public void putTestIsNull()
	{
		SchedulePerson putEntity=new SchedulePerson();
        putEntity.setId("1");
        Object actual=null;
        Mockito.when(schedulepersonService.getByPK(putEntity.getId())).thenReturn(null);
        Mockito.when(schedulepersondao.insertSelective(SchedulePersonData.convert(putEntity, new SchedulePersonDO()))).thenReturn(1);
        Assert.assertEquals(actual,schedulepersonService.put(putEntity),"不相等");
	}

	@Test(groups = "groupDelete")
	public void deleteTest()
	{
		String testid = "1";
        AtomicInteger count = new AtomicInteger();
        Mockito.when(count.addAndGet(schedulepersondao.deleteByPrimaryKey(testid))).thenReturn(1);
        int actual = schedulepersonService.delete(testid);
        Assert.assertEquals(actual, 1, "不相等");
	}

	@Test(groups = "groupGet", dependsOnMethods = "getCountByFilterTest")
	public void getRateAndCountByFilterTest()
	{
		Map<String, Map<String, Object>> res = new HashMap<>();
        List<String> groupBy = Mockito.mock(List.class);
        res = schedulepersonService.getFilterListGroup(schedulepersonfilterMapper, groupBy);
        Assert.assertEquals(res.size(), 0, "不相等");
	}

}