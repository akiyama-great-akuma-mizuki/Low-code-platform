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
public class SealManagetest {
	@Mock
	public SealManageDAO sealmanagedao;

	@Mock
	public SealManageSimpleMapper sealmanageSimpleMapper;

	@Mock
	public SealManage sealmanage;

	@Mock
	public SealManageFilterMapper sealmanagefilterMapper;

	@InjectMocks
	public SealManageService sealmanageService;

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
        SealManageDO sealmanagedo = new SealManageDO();
        sealmanagedo.setId(testid);
        Mockito.when(sealmanagedao.selectByPrimaryKey(testid)).thenReturn(sealmanagedo);
        Assert.assertEquals(sealmanageService.getByPK(testid).getId(), testid, "不相等");
	}

	@Test(groups = "getGet", dependsOnMethods = "getByPKTest")
	public void getSimpleMapByPKTest()
	{
		String testid = mockParams.get("id").toString();
        Map<String, Object> res = sealmanageSimpleMapper.buildMap(sealmanageService.getByPK(testid));
       Assert.assertEquals(sealmanageService.getSimpleMapByPK(testid), res, "getSimpleMapByPK不相等");
	}

	@Test(groups = "groupGet", dependsOnMethods = "getByPKTest")
	public void getDetailMapByPKTestIsNull()
	{
		String testid = "1";
        Mockito.when(sealmanageService.getByPK(testid)).thenReturn(null);
        Assert.assertEquals(null, sealmanageService.getDetailMapByPK(testid), "异常");
	}

	@Test(groups = "groupGet")
	public void getCountByFilterTest()
	{
		        Long count = 0L;
        Mockito.doReturn(mockParams).when(sealmanagefilterMapper).buildMap();
        SealManageDOExample example = SealManageFilter.initDOQueryFilter(mockParams);
        Mockito.doReturn(count).when(sealmanagedao).countByExample(example);
        Assert.assertEquals(count, sealmanageService.getCountByFilter(sealmanagefilterMapper), "异常");

	}

	@Test(groups = "groupGet")
	public void getListByFilterTest()
	{
		List<SealManage> entityList = new ArrayList<>();
        Mockito.doReturn(mockParams).when(sealmanagefilterMapper).buildMap();
        SealManageDOExample example = SealManageFilter.initDOQueryFilter(mockParams);

        List<SealManage> res = Mockito.mock(List.class);
        Mockito.doReturn(res).when(sealmanagedao).selectByExample(example);
        Iterator iteratorMock = Mockito.mock(Iterator.class);
        Mockito.when(res.iterator()).thenReturn(iteratorMock);
        Mockito.when(iteratorMock.hasNext()).thenReturn(true, false);
        Mockito.when(iteratorMock.next()).thenReturn(entityList);
        Assert.assertEquals(entityList, sealmanageService.getListByFilter(sealmanagefilterMapper), "异常");
	}

	@Test(groups = "groupGet", dependsOnMethods = "getListByFilterTest")
	public void getFilterMapListTest()
	{
		List<Map<String, Object>> entityMapList = new ArrayList<>();
        List<SealManage> t1 = Mockito.mock(ArrayList.class);
        List<SealManage> t2 = null;
        Mockito.when(sealmanageService.getListByFilter(sealmanagefilterMapper)).thenReturn(t1);
        Mockito.doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocationOnMock) throws Throwable {
                Object argument = invocationOnMock.getArgument(0);
                SealManage.class.getDeclaredMethod("accept", SealManage.class).invoke(argument, 1);
                return argument;
            }
        }).when(t1).forEach(entity -> entityMapList.add(SealManageSimpleMapper.buildMap(entity)));
        Assert.assertEquals(entityMapList, sealmanageService.getFilterMapList(sealmanagefilterMapper), "异常");
	}

	@Test(groups = "groupPost", dependsOnMethods = "getByPKTest", expectedExceptions = StatusException.class)
	public void postTestException()
	{
		StatusException e = new StatusException("POST_ENTITY_DUPLICATE");
        sealmanage = new SealManage();
        Mockito.when(sealmanagedao.insertSelective(SealManageData.convert(sealmanage, new SealManageDO()))).thenThrow(e);
        SealManage res = sealmanageService.post(sealmanage);
        throw e;
	}

	@Test(groups = "groupPost", dependsOnMethods = "getByPKTest")
	public void postTest()
	{
		 SealManage test = new  SealManage();
 SealManage spySealManage = Mockito.spy(test);
        Mockito.when(sealmanagedao.insertSelective(SealManageData.convert(test, new SealManageDO()))).thenReturn(1);
        SealManage res = sealmanageService.post(test);
	}

	@Test(groups = "groupUpadte", dependsOnMethods = "getByPKTest", expectedExceptions = NullPointerException.class)
	public void updateTest()
	{
		int actual = 1;
        Mockito.when(sealmanagedao.updateByPrimaryKeySelective(SealManageData.convert(sealmanage, new SealManageDO()))).thenReturn(1);
        Assert.assertEquals(actual, sealmanagedao.updateByPrimaryKeySelective(SealManageData.convert(sealmanage, new SealManageDO())), "不相等");

	}

	@Test(groups = "groupPut", dependsOnMethods = "getByPKTest")
	public void putTestIsNull()
	{
		SealManage putEntity=new SealManage();
        putEntity.setId("1");
        Object actual=null;
        Mockito.when(sealmanageService.getByPK(putEntity.getId())).thenReturn(null);
        Mockito.when(sealmanagedao.insertSelective(SealManageData.convert(putEntity, new SealManageDO()))).thenReturn(1);
        Assert.assertEquals(actual,sealmanageService.put(putEntity),"不相等");
	}

	@Test(groups = "groupDelete")
	public void deleteTest()
	{
		String testid = "1";
        AtomicInteger count = new AtomicInteger();
        Mockito.when(count.addAndGet(sealmanagedao.deleteByPrimaryKey(testid))).thenReturn(1);
        int actual = sealmanageService.delete(testid);
        Assert.assertEquals(actual, 1, "不相等");
	}

	@Test(groups = "groupGet", dependsOnMethods = "getCountByFilterTest")
	public void getRateAndCountByFilterTest()
	{
		Map<String, Map<String, Object>> res = new HashMap<>();
        List<String> groupBy = Mockito.mock(List.class);
        res = sealmanageService.getFilterListGroup(sealmanagefilterMapper, groupBy);
        Assert.assertEquals(res.size(), 0, "不相等");
	}

}