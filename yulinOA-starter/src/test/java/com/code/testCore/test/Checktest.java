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
public class Checktest {
	@Mock
	public CheckDAO checkdao;

	@Mock
	public CheckSimpleMapper checkSimpleMapper;

	@Mock
	public Check check;

	@Mock
	public CheckFilterMapper checkfilterMapper;

	@InjectMocks
	public CheckService checkService;

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
        CheckDO checkdo = new CheckDO();
        checkdo.setId(testid);
        Mockito.when(checkdao.selectByPrimaryKey(testid)).thenReturn(checkdo);
        Assert.assertEquals(checkService.getByPK(testid).getId(), testid, "不相等");
	}

	@Test(groups = "getGet", dependsOnMethods = "getByPKTest")
	public void getSimpleMapByPKTest()
	{
		String testid = mockParams.get("id").toString();
        Map<String, Object> res = checkSimpleMapper.buildMap(checkService.getByPK(testid));
       Assert.assertEquals(checkService.getSimpleMapByPK(testid), res, "getSimpleMapByPK不相等");
	}

	@Test(groups = "groupGet", dependsOnMethods = "getByPKTest")
	public void getDetailMapByPKTestIsNull()
	{
		String testid = "1";
        Mockito.when(checkService.getByPK(testid)).thenReturn(null);
        Assert.assertEquals(null, checkService.getDetailMapByPK(testid), "异常");
	}

	@Test(groups = "groupGet")
	public void getCountByFilterTest()
	{
		        Long count = 0L;
        Mockito.doReturn(mockParams).when(checkfilterMapper).buildMap();
        CheckDOExample example = CheckFilter.initDOQueryFilter(mockParams);
        Mockito.doReturn(count).when(checkdao).countByExample(example);
        Assert.assertEquals(count, checkService.getCountByFilter(checkfilterMapper), "异常");

	}

	@Test(groups = "groupGet")
	public void getListByFilterTest()
	{
		List<Check> entityList = new ArrayList<>();
        Mockito.doReturn(mockParams).when(checkfilterMapper).buildMap();
        CheckDOExample example = CheckFilter.initDOQueryFilter(mockParams);

        List<Check> res = Mockito.mock(List.class);
        Mockito.doReturn(res).when(checkdao).selectByExample(example);
        Iterator iteratorMock = Mockito.mock(Iterator.class);
        Mockito.when(res.iterator()).thenReturn(iteratorMock);
        Mockito.when(iteratorMock.hasNext()).thenReturn(true, false);
        Mockito.when(iteratorMock.next()).thenReturn(entityList);
        Assert.assertEquals(entityList, checkService.getListByFilter(checkfilterMapper), "异常");
	}

	@Test(groups = "groupGet", dependsOnMethods = "getListByFilterTest")
	public void getFilterMapListTest()
	{
		List<Map<String, Object>> entityMapList = new ArrayList<>();
        List<Check> t1 = Mockito.mock(ArrayList.class);
        List<Check> t2 = null;
        Mockito.when(checkService.getListByFilter(checkfilterMapper)).thenReturn(t1);
        Mockito.doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocationOnMock) throws Throwable {
                Object argument = invocationOnMock.getArgument(0);
                Check.class.getDeclaredMethod("accept", Check.class).invoke(argument, 1);
                return argument;
            }
        }).when(t1).forEach(entity -> entityMapList.add(CheckSimpleMapper.buildMap(entity)));
        Assert.assertEquals(entityMapList, checkService.getFilterMapList(checkfilterMapper), "异常");
	}

	@Test(groups = "groupPost", dependsOnMethods = "getByPKTest", expectedExceptions = StatusException.class)
	public void postTestException()
	{
		StatusException e = new StatusException("POST_ENTITY_DUPLICATE");
        check = new Check();
        Mockito.when(checkdao.insertSelective(CheckData.convert(check, new CheckDO()))).thenThrow(e);
        Check res = checkService.post(check);
        throw e;
	}

	@Test(groups = "groupPost", dependsOnMethods = "getByPKTest")
	public void postTest()
	{
		 Check test = new  Check();
 Check spyCheck = Mockito.spy(test);
        Mockito.when(checkdao.insertSelective(CheckData.convert(test, new CheckDO()))).thenReturn(1);
        Check res = checkService.post(test);
	}

	@Test(groups = "groupUpadte", dependsOnMethods = "getByPKTest", expectedExceptions = NullPointerException.class)
	public void updateTest()
	{
		int actual = 1;
        Mockito.when(checkdao.updateByPrimaryKeySelective(CheckData.convert(check, new CheckDO()))).thenReturn(1);
        Assert.assertEquals(actual, checkdao.updateByPrimaryKeySelective(CheckData.convert(check, new CheckDO())), "不相等");

	}

	@Test(groups = "groupPut", dependsOnMethods = "getByPKTest")
	public void putTestIsNull()
	{
		Check putEntity=new Check();
        putEntity.setId("1");
        Object actual=null;
        Mockito.when(checkService.getByPK(putEntity.getId())).thenReturn(null);
        Mockito.when(checkdao.insertSelective(CheckData.convert(putEntity, new CheckDO()))).thenReturn(1);
        Assert.assertEquals(actual,checkService.put(putEntity),"不相等");
	}

	@Test(groups = "groupDelete")
	public void deleteTest()
	{
		String testid = "1";
        AtomicInteger count = new AtomicInteger();
        Mockito.when(count.addAndGet(checkdao.deleteByPrimaryKey(testid))).thenReturn(1);
        int actual = checkService.delete(testid);
        Assert.assertEquals(actual, 1, "不相等");
	}

	@Test(groups = "groupGet", dependsOnMethods = "getCountByFilterTest")
	public void getRateAndCountByFilterTest()
	{
		Map<String, Map<String, Object>> res = new HashMap<>();
        List<String> groupBy = Mockito.mock(List.class);
        res = checkService.getFilterListGroup(checkfilterMapper, groupBy);
        Assert.assertEquals(res.size(), 0, "不相等");
	}

}