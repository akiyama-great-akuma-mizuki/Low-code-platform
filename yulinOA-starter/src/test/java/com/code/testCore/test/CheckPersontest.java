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
public class CheckPersontest {
	@Mock
	public CheckPersonDAO checkpersondao;

	@Mock
	public CheckPersonSimpleMapper checkpersonSimpleMapper;

	@Mock
	public CheckPerson checkperson;

	@Mock
	public CheckPersonFilterMapper checkpersonfilterMapper;

	@InjectMocks
	public CheckPersonService checkpersonService;

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
        CheckPersonDO checkpersondo = new CheckPersonDO();
        checkpersondo.setId(testid);
        Mockito.when(checkpersondao.selectByPrimaryKey(testid)).thenReturn(checkpersondo);
        Assert.assertEquals(checkpersonService.getByPK(testid).getId(), testid, "不相等");
	}

	@Test(groups = "getGet", dependsOnMethods = "getByPKTest")
	public void getSimpleMapByPKTest()
	{
		String testid = mockParams.get("id").toString();
        Map<String, Object> res = checkpersonSimpleMapper.buildMap(checkpersonService.getByPK(testid));
       Assert.assertEquals(checkpersonService.getSimpleMapByPK(testid), res, "getSimpleMapByPK不相等");
	}

	@Test(groups = "groupGet", dependsOnMethods = "getByPKTest")
	public void getDetailMapByPKTestIsNull()
	{
		String testid = "1";
        Mockito.when(checkpersonService.getByPK(testid)).thenReturn(null);
        Assert.assertEquals(null, checkpersonService.getDetailMapByPK(testid), "异常");
	}

	@Test(groups = "groupGet")
	public void getCountByFilterTest()
	{
		        Long count = 0L;
        Mockito.doReturn(mockParams).when(checkpersonfilterMapper).buildMap();
        CheckPersonDOExample example = CheckPersonFilter.initDOQueryFilter(mockParams);
        Mockito.doReturn(count).when(checkpersondao).countByExample(example);
        Assert.assertEquals(count, checkpersonService.getCountByFilter(checkpersonfilterMapper), "异常");

	}

	@Test(groups = "groupGet")
	public void getListByFilterTest()
	{
		List<CheckPerson> entityList = new ArrayList<>();
        Mockito.doReturn(mockParams).when(checkpersonfilterMapper).buildMap();
        CheckPersonDOExample example = CheckPersonFilter.initDOQueryFilter(mockParams);

        List<CheckPerson> res = Mockito.mock(List.class);
        Mockito.doReturn(res).when(checkpersondao).selectByExample(example);
        Iterator iteratorMock = Mockito.mock(Iterator.class);
        Mockito.when(res.iterator()).thenReturn(iteratorMock);
        Mockito.when(iteratorMock.hasNext()).thenReturn(true, false);
        Mockito.when(iteratorMock.next()).thenReturn(entityList);
        Assert.assertEquals(entityList, checkpersonService.getListByFilter(checkpersonfilterMapper), "异常");
	}

	@Test(groups = "groupGet", dependsOnMethods = "getListByFilterTest")
	public void getFilterMapListTest()
	{
		List<Map<String, Object>> entityMapList = new ArrayList<>();
        List<CheckPerson> t1 = Mockito.mock(ArrayList.class);
        List<CheckPerson> t2 = null;
        Mockito.when(checkpersonService.getListByFilter(checkpersonfilterMapper)).thenReturn(t1);
        Mockito.doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocationOnMock) throws Throwable {
                Object argument = invocationOnMock.getArgument(0);
                CheckPerson.class.getDeclaredMethod("accept", CheckPerson.class).invoke(argument, 1);
                return argument;
            }
        }).when(t1).forEach(entity -> entityMapList.add(CheckPersonSimpleMapper.buildMap(entity)));
        Assert.assertEquals(entityMapList, checkpersonService.getFilterMapList(checkpersonfilterMapper), "异常");
	}

	@Test(groups = "groupPost", dependsOnMethods = "getByPKTest", expectedExceptions = StatusException.class)
	public void postTestException()
	{
		StatusException e = new StatusException("POST_ENTITY_DUPLICATE");
        checkperson = new CheckPerson();
        Mockito.when(checkpersondao.insertSelective(CheckPersonData.convert(checkperson, new CheckPersonDO()))).thenThrow(e);
        CheckPerson res = checkpersonService.post(checkperson);
        throw e;
	}

	@Test(groups = "groupPost", dependsOnMethods = "getByPKTest")
	public void postTest()
	{
		 CheckPerson test = new  CheckPerson();
 CheckPerson spyCheckPerson = Mockito.spy(test);
        Mockito.when(checkpersondao.insertSelective(CheckPersonData.convert(test, new CheckPersonDO()))).thenReturn(1);
        CheckPerson res = checkpersonService.post(test);
	}

	@Test(groups = "groupUpadte", dependsOnMethods = "getByPKTest", expectedExceptions = NullPointerException.class)
	public void updateTest()
	{
		int actual = 1;
        Mockito.when(checkpersondao.updateByPrimaryKeySelective(CheckPersonData.convert(checkperson, new CheckPersonDO()))).thenReturn(1);
        Assert.assertEquals(actual, checkpersondao.updateByPrimaryKeySelective(CheckPersonData.convert(checkperson, new CheckPersonDO())), "不相等");

	}

	@Test(groups = "groupPut", dependsOnMethods = "getByPKTest")
	public void putTestIsNull()
	{
		CheckPerson putEntity=new CheckPerson();
        putEntity.setId("1");
        Object actual=null;
        Mockito.when(checkpersonService.getByPK(putEntity.getId())).thenReturn(null);
        Mockito.when(checkpersondao.insertSelective(CheckPersonData.convert(putEntity, new CheckPersonDO()))).thenReturn(1);
        Assert.assertEquals(actual,checkpersonService.put(putEntity),"不相等");
	}

	@Test(groups = "groupDelete")
	public void deleteTest()
	{
		String testid = "1";
        AtomicInteger count = new AtomicInteger();
        Mockito.when(count.addAndGet(checkpersondao.deleteByPrimaryKey(testid))).thenReturn(1);
        int actual = checkpersonService.delete(testid);
        Assert.assertEquals(actual, 1, "不相等");
	}

	@Test(groups = "groupGet", dependsOnMethods = "getCountByFilterTest")
	public void getRateAndCountByFilterTest()
	{
		Map<String, Map<String, Object>> res = new HashMap<>();
        List<String> groupBy = Mockito.mock(List.class);
        res = checkpersonService.getFilterListGroup(checkpersonfilterMapper, groupBy);
        Assert.assertEquals(res.size(), 0, "不相等");
	}

}