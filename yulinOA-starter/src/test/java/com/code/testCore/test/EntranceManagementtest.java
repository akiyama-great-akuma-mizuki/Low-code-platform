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
public class EntranceManagementtest {
	@Mock
	public EntranceManagementDAO entrancemanagementdao;

	@Mock
	public EntranceManagementSimpleMapper entrancemanagementSimpleMapper;

	@Mock
	public EntranceManagement entrancemanagement;

	@Mock
	public EntranceManagementFilterMapper entrancemanagementfilterMapper;

	@InjectMocks
	public EntranceManagementService entrancemanagementService;

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
        EntranceManagementDO entrancemanagementdo = new EntranceManagementDO();
        entrancemanagementdo.setId(testid);
        Mockito.when(entrancemanagementdao.selectByPrimaryKey(testid)).thenReturn(entrancemanagementdo);
        Assert.assertEquals(entrancemanagementService.getByPK(testid).getId(), testid, "不相等");
	}

	@Test(groups = "getGet", dependsOnMethods = "getByPKTest")
	public void getSimpleMapByPKTest()
	{
		String testid = mockParams.get("id").toString();
        Map<String, Object> res = entrancemanagementSimpleMapper.buildMap(entrancemanagementService.getByPK(testid));
       Assert.assertEquals(entrancemanagementService.getSimpleMapByPK(testid), res, "getSimpleMapByPK不相等");
	}

	@Test(groups = "groupGet", dependsOnMethods = "getByPKTest")
	public void getDetailMapByPKTestIsNull()
	{
		String testid = "1";
        Mockito.when(entrancemanagementService.getByPK(testid)).thenReturn(null);
        Assert.assertEquals(null, entrancemanagementService.getDetailMapByPK(testid), "异常");
	}

	@Test(groups = "groupGet")
	public void getCountByFilterTest()
	{
		        Long count = 0L;
        Mockito.doReturn(mockParams).when(entrancemanagementfilterMapper).buildMap();
        EntranceManagementDOExample example = EntranceManagementFilter.initDOQueryFilter(mockParams);
        Mockito.doReturn(count).when(entrancemanagementdao).countByExample(example);
        Assert.assertEquals(count, entrancemanagementService.getCountByFilter(entrancemanagementfilterMapper), "异常");

	}

	@Test(groups = "groupGet")
	public void getListByFilterTest()
	{
		List<EntranceManagement> entityList = new ArrayList<>();
        Mockito.doReturn(mockParams).when(entrancemanagementfilterMapper).buildMap();
        EntranceManagementDOExample example = EntranceManagementFilter.initDOQueryFilter(mockParams);

        List<EntranceManagement> res = Mockito.mock(List.class);
        Mockito.doReturn(res).when(entrancemanagementdao).selectByExample(example);
        Iterator iteratorMock = Mockito.mock(Iterator.class);
        Mockito.when(res.iterator()).thenReturn(iteratorMock);
        Mockito.when(iteratorMock.hasNext()).thenReturn(true, false);
        Mockito.when(iteratorMock.next()).thenReturn(entityList);
        Assert.assertEquals(entityList, entrancemanagementService.getListByFilter(entrancemanagementfilterMapper), "异常");
	}

	@Test(groups = "groupGet", dependsOnMethods = "getListByFilterTest")
	public void getFilterMapListTest()
	{
		List<Map<String, Object>> entityMapList = new ArrayList<>();
        List<EntranceManagement> t1 = Mockito.mock(ArrayList.class);
        List<EntranceManagement> t2 = null;
        Mockito.when(entrancemanagementService.getListByFilter(entrancemanagementfilterMapper)).thenReturn(t1);
        Mockito.doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocationOnMock) throws Throwable {
                Object argument = invocationOnMock.getArgument(0);
                EntranceManagement.class.getDeclaredMethod("accept", EntranceManagement.class).invoke(argument, 1);
                return argument;
            }
        }).when(t1).forEach(entity -> entityMapList.add(EntranceManagementSimpleMapper.buildMap(entity)));
        Assert.assertEquals(entityMapList, entrancemanagementService.getFilterMapList(entrancemanagementfilterMapper), "异常");
	}

	@Test(groups = "groupPost", dependsOnMethods = "getByPKTest", expectedExceptions = StatusException.class)
	public void postTestException()
	{
		StatusException e = new StatusException("POST_ENTITY_DUPLICATE");
        entrancemanagement = new EntranceManagement();
        Mockito.when(entrancemanagementdao.insertSelective(EntranceManagementData.convert(entrancemanagement, new EntranceManagementDO()))).thenThrow(e);
        EntranceManagement res = entrancemanagementService.post(entrancemanagement);
        throw e;
	}

	@Test(groups = "groupPost", dependsOnMethods = "getByPKTest")
	public void postTest()
	{
		 EntranceManagement test = new  EntranceManagement();
 EntranceManagement spyEntranceManagement = Mockito.spy(test);
        Mockito.when(entrancemanagementdao.insertSelective(EntranceManagementData.convert(test, new EntranceManagementDO()))).thenReturn(1);
        EntranceManagement res = entrancemanagementService.post(test);
	}

	@Test(groups = "groupUpadte", dependsOnMethods = "getByPKTest", expectedExceptions = NullPointerException.class)
	public void updateTest()
	{
		int actual = 1;
        Mockito.when(entrancemanagementdao.updateByPrimaryKeySelective(EntranceManagementData.convert(entrancemanagement, new EntranceManagementDO()))).thenReturn(1);
        Assert.assertEquals(actual, entrancemanagementdao.updateByPrimaryKeySelective(EntranceManagementData.convert(entrancemanagement, new EntranceManagementDO())), "不相等");

	}

	@Test(groups = "groupPut", dependsOnMethods = "getByPKTest")
	public void putTestIsNull()
	{
		EntranceManagement putEntity=new EntranceManagement();
        putEntity.setId("1");
        Object actual=null;
        Mockito.when(entrancemanagementService.getByPK(putEntity.getId())).thenReturn(null);
        Mockito.when(entrancemanagementdao.insertSelective(EntranceManagementData.convert(putEntity, new EntranceManagementDO()))).thenReturn(1);
        Assert.assertEquals(actual,entrancemanagementService.put(putEntity),"不相等");
	}

	@Test(groups = "groupDelete")
	public void deleteTest()
	{
		String testid = "1";
        AtomicInteger count = new AtomicInteger();
        Mockito.when(count.addAndGet(entrancemanagementdao.deleteByPrimaryKey(testid))).thenReturn(1);
        int actual = entrancemanagementService.delete(testid);
        Assert.assertEquals(actual, 1, "不相等");
	}

	@Test(groups = "groupGet", dependsOnMethods = "getCountByFilterTest")
	public void getRateAndCountByFilterTest()
	{
		Map<String, Map<String, Object>> res = new HashMap<>();
        List<String> groupBy = Mockito.mock(List.class);
        res = entrancemanagementService.getFilterListGroup(entrancemanagementfilterMapper, groupBy);
        Assert.assertEquals(res.size(), 0, "不相等");
	}

}