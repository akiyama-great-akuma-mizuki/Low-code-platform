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
public class Blacklisttest {
	@Mock
	public BlacklistDAO blacklistdao;

	@Mock
	public BlacklistSimpleMapper blacklistSimpleMapper;

	@Mock
	public Blacklist blacklist;

	@Mock
	public BlacklistFilterMapper blacklistfilterMapper;

	@InjectMocks
	public BlacklistService blacklistService;

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
        BlacklistDO blacklistdo = new BlacklistDO();
        blacklistdo.setId(testid);
        Mockito.when(blacklistdao.selectByPrimaryKey(testid)).thenReturn(blacklistdo);
        Assert.assertEquals(blacklistService.getByPK(testid).getId(), testid, "不相等");
	}

	@Test(groups = "getGet", dependsOnMethods = "getByPKTest")
	public void getSimpleMapByPKTest()
	{
		String testid = mockParams.get("id").toString();
        Map<String, Object> res = blacklistSimpleMapper.buildMap(blacklistService.getByPK(testid));
       Assert.assertEquals(blacklistService.getSimpleMapByPK(testid), res, "getSimpleMapByPK不相等");
	}

	@Test(groups = "groupGet", dependsOnMethods = "getByPKTest")
	public void getDetailMapByPKTestIsNull()
	{
		String testid = "1";
        Mockito.when(blacklistService.getByPK(testid)).thenReturn(null);
        Assert.assertEquals(null, blacklistService.getDetailMapByPK(testid), "异常");
	}

	@Test(groups = "groupGet")
	public void getCountByFilterTest()
	{
		        Long count = 0L;
        Mockito.doReturn(mockParams).when(blacklistfilterMapper).buildMap();
        BlacklistDOExample example = BlacklistFilter.initDOQueryFilter(mockParams);
        Mockito.doReturn(count).when(blacklistdao).countByExample(example);
        Assert.assertEquals(count, blacklistService.getCountByFilter(blacklistfilterMapper), "异常");

	}

	@Test(groups = "groupGet")
	public void getListByFilterTest()
	{
		List<Blacklist> entityList = new ArrayList<>();
        Mockito.doReturn(mockParams).when(blacklistfilterMapper).buildMap();
        BlacklistDOExample example = BlacklistFilter.initDOQueryFilter(mockParams);

        List<Blacklist> res = Mockito.mock(List.class);
        Mockito.doReturn(res).when(blacklistdao).selectByExample(example);
        Iterator iteratorMock = Mockito.mock(Iterator.class);
        Mockito.when(res.iterator()).thenReturn(iteratorMock);
        Mockito.when(iteratorMock.hasNext()).thenReturn(true, false);
        Mockito.when(iteratorMock.next()).thenReturn(entityList);
        Assert.assertEquals(entityList, blacklistService.getListByFilter(blacklistfilterMapper), "异常");
	}

	@Test(groups = "groupGet", dependsOnMethods = "getListByFilterTest")
	public void getFilterMapListTest()
	{
		List<Map<String, Object>> entityMapList = new ArrayList<>();
        List<Blacklist> t1 = Mockito.mock(ArrayList.class);
        List<Blacklist> t2 = null;
        Mockito.when(blacklistService.getListByFilter(blacklistfilterMapper)).thenReturn(t1);
        Mockito.doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocationOnMock) throws Throwable {
                Object argument = invocationOnMock.getArgument(0);
                Blacklist.class.getDeclaredMethod("accept", Blacklist.class).invoke(argument, 1);
                return argument;
            }
        }).when(t1).forEach(entity -> entityMapList.add(BlacklistSimpleMapper.buildMap(entity)));
        Assert.assertEquals(entityMapList, blacklistService.getFilterMapList(blacklistfilterMapper), "异常");
	}

	@Test(groups = "groupPost", dependsOnMethods = "getByPKTest", expectedExceptions = StatusException.class)
	public void postTestException()
	{
		StatusException e = new StatusException("POST_ENTITY_DUPLICATE");
        blacklist = new Blacklist();
        Mockito.when(blacklistdao.insertSelective(BlacklistData.convert(blacklist, new BlacklistDO()))).thenThrow(e);
        Blacklist res = blacklistService.post(blacklist);
        throw e;
	}

	@Test(groups = "groupPost", dependsOnMethods = "getByPKTest")
	public void postTest()
	{
		 Blacklist test = new  Blacklist();
 Blacklist spyBlacklist = Mockito.spy(test);
        Mockito.when(blacklistdao.insertSelective(BlacklistData.convert(test, new BlacklistDO()))).thenReturn(1);
        Blacklist res = blacklistService.post(test);
	}

	@Test(groups = "groupUpadte", dependsOnMethods = "getByPKTest", expectedExceptions = NullPointerException.class)
	public void updateTest()
	{
		int actual = 1;
        Mockito.when(blacklistdao.updateByPrimaryKeySelective(BlacklistData.convert(blacklist, new BlacklistDO()))).thenReturn(1);
        Assert.assertEquals(actual, blacklistdao.updateByPrimaryKeySelective(BlacklistData.convert(blacklist, new BlacklistDO())), "不相等");

	}

	@Test(groups = "groupPut", dependsOnMethods = "getByPKTest")
	public void putTestIsNull()
	{
		Blacklist putEntity=new Blacklist();
        putEntity.setId("1");
        Object actual=null;
        Mockito.when(blacklistService.getByPK(putEntity.getId())).thenReturn(null);
        Mockito.when(blacklistdao.insertSelective(BlacklistData.convert(putEntity, new BlacklistDO()))).thenReturn(1);
        Assert.assertEquals(actual,blacklistService.put(putEntity),"不相等");
	}

	@Test(groups = "groupDelete")
	public void deleteTest()
	{
		String testid = "1";
        AtomicInteger count = new AtomicInteger();
        Mockito.when(count.addAndGet(blacklistdao.deleteByPrimaryKey(testid))).thenReturn(1);
        int actual = blacklistService.delete(testid);
        Assert.assertEquals(actual, 1, "不相等");
	}

	@Test(groups = "groupGet", dependsOnMethods = "getCountByFilterTest")
	public void getRateAndCountByFilterTest()
	{
		Map<String, Map<String, Object>> res = new HashMap<>();
        List<String> groupBy = Mockito.mock(List.class);
        res = blacklistService.getFilterListGroup(blacklistfilterMapper, groupBy);
        Assert.assertEquals(res.size(), 0, "不相等");
	}

}