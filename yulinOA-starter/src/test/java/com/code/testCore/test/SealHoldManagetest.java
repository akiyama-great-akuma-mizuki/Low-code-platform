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
public class SealHoldManagetest {
	@Mock
	public SealHoldManageDAO sealholdmanagedao;

	@Mock
	public SealHoldManageSimpleMapper sealholdmanageSimpleMapper;

	@Mock
	public SealHoldManage sealholdmanage;

	@Mock
	public SealHoldManageFilterMapper sealholdmanagefilterMapper;

	@InjectMocks
	public SealHoldManageService sealholdmanageService;

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
        SealHoldManageDO sealholdmanagedo = new SealHoldManageDO();
        sealholdmanagedo.setId(testid);
        Mockito.when(sealholdmanagedao.selectByPrimaryKey(testid)).thenReturn(sealholdmanagedo);
        Assert.assertEquals(sealholdmanageService.getByPK(testid).getId(), testid, "不相等");
	}

	@Test(groups = "getGet", dependsOnMethods = "getByPKTest")
	public void getSimpleMapByPKTest()
	{
		String testid = mockParams.get("id").toString();
        Map<String, Object> res = sealholdmanageSimpleMapper.buildMap(sealholdmanageService.getByPK(testid));
       Assert.assertEquals(sealholdmanageService.getSimpleMapByPK(testid), res, "getSimpleMapByPK不相等");
	}

	@Test(groups = "groupGet", dependsOnMethods = "getByPKTest")
	public void getDetailMapByPKTestIsNull()
	{
		String testid = "1";
        Mockito.when(sealholdmanageService.getByPK(testid)).thenReturn(null);
        Assert.assertEquals(null, sealholdmanageService.getDetailMapByPK(testid), "异常");
	}

	@Test(groups = "groupGet")
	public void getCountByFilterTest()
	{
		        Long count = 0L;
        Mockito.doReturn(mockParams).when(sealholdmanagefilterMapper).buildMap();
        SealHoldManageDOExample example = SealHoldManageFilter.initDOQueryFilter(mockParams);
        Mockito.doReturn(count).when(sealholdmanagedao).countByExample(example);
        Assert.assertEquals(count, sealholdmanageService.getCountByFilter(sealholdmanagefilterMapper), "异常");

	}

	@Test(groups = "groupGet")
	public void getListByFilterTest()
	{
		List<SealHoldManage> entityList = new ArrayList<>();
        Mockito.doReturn(mockParams).when(sealholdmanagefilterMapper).buildMap();
        SealHoldManageDOExample example = SealHoldManageFilter.initDOQueryFilter(mockParams);

        List<SealHoldManage> res = Mockito.mock(List.class);
        Mockito.doReturn(res).when(sealholdmanagedao).selectByExample(example);
        Iterator iteratorMock = Mockito.mock(Iterator.class);
        Mockito.when(res.iterator()).thenReturn(iteratorMock);
        Mockito.when(iteratorMock.hasNext()).thenReturn(true, false);
        Mockito.when(iteratorMock.next()).thenReturn(entityList);
        Assert.assertEquals(entityList, sealholdmanageService.getListByFilter(sealholdmanagefilterMapper), "异常");
	}

	@Test(groups = "groupGet", dependsOnMethods = "getListByFilterTest")
	public void getFilterMapListTest()
	{
		List<Map<String, Object>> entityMapList = new ArrayList<>();
        List<SealHoldManage> t1 = Mockito.mock(ArrayList.class);
        List<SealHoldManage> t2 = null;
        Mockito.when(sealholdmanageService.getListByFilter(sealholdmanagefilterMapper)).thenReturn(t1);
        Mockito.doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocationOnMock) throws Throwable {
                Object argument = invocationOnMock.getArgument(0);
                SealHoldManage.class.getDeclaredMethod("accept", SealHoldManage.class).invoke(argument, 1);
                return argument;
            }
        }).when(t1).forEach(entity -> entityMapList.add(SealHoldManageSimpleMapper.buildMap(entity)));
        Assert.assertEquals(entityMapList, sealholdmanageService.getFilterMapList(sealholdmanagefilterMapper), "异常");
	}

	@Test(groups = "groupPost", dependsOnMethods = "getByPKTest", expectedExceptions = StatusException.class)
	public void postTestException()
	{
		StatusException e = new StatusException("POST_ENTITY_DUPLICATE");
        sealholdmanage = new SealHoldManage();
        Mockito.when(sealholdmanagedao.insertSelective(SealHoldManageData.convert(sealholdmanage, new SealHoldManageDO()))).thenThrow(e);
        SealHoldManage res = sealholdmanageService.post(sealholdmanage);
        throw e;
	}

	@Test(groups = "groupPost", dependsOnMethods = "getByPKTest")
	public void postTest()
	{
		 SealHoldManage test = new  SealHoldManage();
 SealHoldManage spySealHoldManage = Mockito.spy(test);
        Mockito.when(sealholdmanagedao.insertSelective(SealHoldManageData.convert(test, new SealHoldManageDO()))).thenReturn(1);
        SealHoldManage res = sealholdmanageService.post(test);
	}

	@Test(groups = "groupUpadte", dependsOnMethods = "getByPKTest", expectedExceptions = NullPointerException.class)
	public void updateTest()
	{
		int actual = 1;
        Mockito.when(sealholdmanagedao.updateByPrimaryKeySelective(SealHoldManageData.convert(sealholdmanage, new SealHoldManageDO()))).thenReturn(1);
        Assert.assertEquals(actual, sealholdmanagedao.updateByPrimaryKeySelective(SealHoldManageData.convert(sealholdmanage, new SealHoldManageDO())), "不相等");

	}

	@Test(groups = "groupPut", dependsOnMethods = "getByPKTest")
	public void putTestIsNull()
	{
		SealHoldManage putEntity=new SealHoldManage();
        putEntity.setId("1");
        Object actual=null;
        Mockito.when(sealholdmanageService.getByPK(putEntity.getId())).thenReturn(null);
        Mockito.when(sealholdmanagedao.insertSelective(SealHoldManageData.convert(putEntity, new SealHoldManageDO()))).thenReturn(1);
        Assert.assertEquals(actual,sealholdmanageService.put(putEntity),"不相等");
	}

	@Test(groups = "groupDelete")
	public void deleteTest()
	{
		String testid = "1";
        AtomicInteger count = new AtomicInteger();
        Mockito.when(count.addAndGet(sealholdmanagedao.deleteByPrimaryKey(testid))).thenReturn(1);
        int actual = sealholdmanageService.delete(testid);
        Assert.assertEquals(actual, 1, "不相等");
	}

	@Test(groups = "groupGet", dependsOnMethods = "getCountByFilterTest")
	public void getRateAndCountByFilterTest()
	{
		Map<String, Map<String, Object>> res = new HashMap<>();
        List<String> groupBy = Mockito.mock(List.class);
        res = sealholdmanageService.getFilterListGroup(sealholdmanagefilterMapper, groupBy);
        Assert.assertEquals(res.size(), 0, "不相等");
	}

}