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
public class EntranceGuardUsertest {
	@Mock
	public EntranceGuardUserDAO entranceguarduserdao;

	@Mock
	public EntranceGuardUserSimpleMapper entranceguarduserSimpleMapper;

	@Mock
	public EntranceGuardUser entranceguarduser;

	@Mock
	public EntranceGuardUserFilterMapper entranceguarduserfilterMapper;

	@InjectMocks
	public EntranceGuardUserService entranceguarduserService;

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
        EntranceGuardUserDO entranceguarduserdo = new EntranceGuardUserDO();
        entranceguarduserdo.setId(testid);
        Mockito.when(entranceguarduserdao.selectByPrimaryKey(testid)).thenReturn(entranceguarduserdo);
        Assert.assertEquals(entranceguarduserService.getByPK(testid).getId(), testid, "不相等");
	}

	@Test(groups = "getGet", dependsOnMethods = "getByPKTest")
	public void getSimpleMapByPKTest()
	{
		String testid = mockParams.get("id").toString();
        Map<String, Object> res = entranceguarduserSimpleMapper.buildMap(entranceguarduserService.getByPK(testid));
       Assert.assertEquals(entranceguarduserService.getSimpleMapByPK(testid), res, "getSimpleMapByPK不相等");
	}

	@Test(groups = "groupGet", dependsOnMethods = "getByPKTest")
	public void getDetailMapByPKTestIsNull()
	{
		String testid = "1";
        Mockito.when(entranceguarduserService.getByPK(testid)).thenReturn(null);
        Assert.assertEquals(null, entranceguarduserService.getDetailMapByPK(testid), "异常");
	}

	@Test(groups = "groupGet")
	public void getCountByFilterTest()
	{
		        Long count = 0L;
        Mockito.doReturn(mockParams).when(entranceguarduserfilterMapper).buildMap();
        EntranceGuardUserDOExample example = EntranceGuardUserFilter.initDOQueryFilter(mockParams);
        Mockito.doReturn(count).when(entranceguarduserdao).countByExample(example);
        Assert.assertEquals(count, entranceguarduserService.getCountByFilter(entranceguarduserfilterMapper), "异常");

	}

	@Test(groups = "groupGet")
	public void getListByFilterTest()
	{
		List<EntranceGuardUser> entityList = new ArrayList<>();
        Mockito.doReturn(mockParams).when(entranceguarduserfilterMapper).buildMap();
        EntranceGuardUserDOExample example = EntranceGuardUserFilter.initDOQueryFilter(mockParams);

        List<EntranceGuardUser> res = Mockito.mock(List.class);
        Mockito.doReturn(res).when(entranceguarduserdao).selectByExample(example);
        Iterator iteratorMock = Mockito.mock(Iterator.class);
        Mockito.when(res.iterator()).thenReturn(iteratorMock);
        Mockito.when(iteratorMock.hasNext()).thenReturn(true, false);
        Mockito.when(iteratorMock.next()).thenReturn(entityList);
        Assert.assertEquals(entityList, entranceguarduserService.getListByFilter(entranceguarduserfilterMapper), "异常");
	}

	@Test(groups = "groupGet", dependsOnMethods = "getListByFilterTest")
	public void getFilterMapListTest()
	{
		List<Map<String, Object>> entityMapList = new ArrayList<>();
        List<EntranceGuardUser> t1 = Mockito.mock(ArrayList.class);
        List<EntranceGuardUser> t2 = null;
        Mockito.when(entranceguarduserService.getListByFilter(entranceguarduserfilterMapper)).thenReturn(t1);
        Mockito.doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocationOnMock) throws Throwable {
                Object argument = invocationOnMock.getArgument(0);
                EntranceGuardUser.class.getDeclaredMethod("accept", EntranceGuardUser.class).invoke(argument, 1);
                return argument;
            }
        }).when(t1).forEach(entity -> entityMapList.add(EntranceGuardUserSimpleMapper.buildMap(entity)));
        Assert.assertEquals(entityMapList, entranceguarduserService.getFilterMapList(entranceguarduserfilterMapper), "异常");
	}

	@Test(groups = "groupPost", dependsOnMethods = "getByPKTest", expectedExceptions = StatusException.class)
	public void postTestException()
	{
		StatusException e = new StatusException("POST_ENTITY_DUPLICATE");
        entranceguarduser = new EntranceGuardUser();
        Mockito.when(entranceguarduserdao.insertSelective(EntranceGuardUserData.convert(entranceguarduser, new EntranceGuardUserDO()))).thenThrow(e);
        EntranceGuardUser res = entranceguarduserService.post(entranceguarduser);
        throw e;
	}

	@Test(groups = "groupPost", dependsOnMethods = "getByPKTest")
	public void postTest()
	{
		 EntranceGuardUser test = new  EntranceGuardUser();
 EntranceGuardUser spyEntranceGuardUser = Mockito.spy(test);
        Mockito.when(entranceguarduserdao.insertSelective(EntranceGuardUserData.convert(test, new EntranceGuardUserDO()))).thenReturn(1);
        EntranceGuardUser res = entranceguarduserService.post(test);
	}

	@Test(groups = "groupUpadte", dependsOnMethods = "getByPKTest", expectedExceptions = NullPointerException.class)
	public void updateTest()
	{
		int actual = 1;
        Mockito.when(entranceguarduserdao.updateByPrimaryKeySelective(EntranceGuardUserData.convert(entranceguarduser, new EntranceGuardUserDO()))).thenReturn(1);
        Assert.assertEquals(actual, entranceguarduserdao.updateByPrimaryKeySelective(EntranceGuardUserData.convert(entranceguarduser, new EntranceGuardUserDO())), "不相等");

	}

	@Test(groups = "groupPut", dependsOnMethods = "getByPKTest")
	public void putTestIsNull()
	{
		EntranceGuardUser putEntity=new EntranceGuardUser();
        putEntity.setId("1");
        Object actual=null;
        Mockito.when(entranceguarduserService.getByPK(putEntity.getId())).thenReturn(null);
        Mockito.when(entranceguarduserdao.insertSelective(EntranceGuardUserData.convert(putEntity, new EntranceGuardUserDO()))).thenReturn(1);
        Assert.assertEquals(actual,entranceguarduserService.put(putEntity),"不相等");
	}

	@Test(groups = "groupDelete")
	public void deleteTest()
	{
		String testid = "1";
        AtomicInteger count = new AtomicInteger();
        Mockito.when(count.addAndGet(entranceguarduserdao.deleteByPrimaryKey(testid))).thenReturn(1);
        int actual = entranceguarduserService.delete(testid);
        Assert.assertEquals(actual, 1, "不相等");
	}

	@Test(groups = "groupGet", dependsOnMethods = "getCountByFilterTest")
	public void getRateAndCountByFilterTest()
	{
		Map<String, Map<String, Object>> res = new HashMap<>();
        List<String> groupBy = Mockito.mock(List.class);
        res = entranceguarduserService.getFilterListGroup(entranceguarduserfilterMapper, groupBy);
        Assert.assertEquals(res.size(), 0, "不相等");
	}

}