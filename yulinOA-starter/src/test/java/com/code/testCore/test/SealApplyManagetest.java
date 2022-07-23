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
public class SealApplyManagetest {
	@Mock
	public SealApplyManageDAO sealapplymanagedao;

	@Mock
	public SealApplyManageSimpleMapper sealapplymanageSimpleMapper;

	@Mock
	public SealApplyManage sealapplymanage;

	@Mock
	public SealApplyManageFilterMapper sealapplymanagefilterMapper;

	@InjectMocks
	public SealApplyManageService sealapplymanageService;

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
        SealApplyManageDO sealapplymanagedo = new SealApplyManageDO();
        sealapplymanagedo.setId(testid);
        Mockito.when(sealapplymanagedao.selectByPrimaryKey(testid)).thenReturn(sealapplymanagedo);
        Assert.assertEquals(sealapplymanageService.getByPK(testid).getId(), testid, "不相等");
	}

	@Test(groups = "getGet", dependsOnMethods = "getByPKTest")
	public void getSimpleMapByPKTest()
	{
		String testid = mockParams.get("id").toString();
        Map<String, Object> res = sealapplymanageSimpleMapper.buildMap(sealapplymanageService.getByPK(testid));
       Assert.assertEquals(sealapplymanageService.getSimpleMapByPK(testid), res, "getSimpleMapByPK不相等");
	}

	@Test(groups = "groupGet", dependsOnMethods = "getByPKTest")
	public void getDetailMapByPKTestIsNull()
	{
		String testid = "1";
        Mockito.when(sealapplymanageService.getByPK(testid)).thenReturn(null);
        Assert.assertEquals(null, sealapplymanageService.getDetailMapByPK(testid), "异常");
	}

	@Test(groups = "groupGet")
	public void getCountByFilterTest()
	{
		        Long count = 0L;
        Mockito.doReturn(mockParams).when(sealapplymanagefilterMapper).buildMap();
        SealApplyManageDOExample example = SealApplyManageFilter.initDOQueryFilter(mockParams);
        Mockito.doReturn(count).when(sealapplymanagedao).countByExample(example);
        Assert.assertEquals(count, sealapplymanageService.getCountByFilter(sealapplymanagefilterMapper), "异常");

	}

	@Test(groups = "groupGet")
	public void getListByFilterTest()
	{
		List<SealApplyManage> entityList = new ArrayList<>();
        Mockito.doReturn(mockParams).when(sealapplymanagefilterMapper).buildMap();
        SealApplyManageDOExample example = SealApplyManageFilter.initDOQueryFilter(mockParams);

        List<SealApplyManage> res = Mockito.mock(List.class);
        Mockito.doReturn(res).when(sealapplymanagedao).selectByExample(example);
        Iterator iteratorMock = Mockito.mock(Iterator.class);
        Mockito.when(res.iterator()).thenReturn(iteratorMock);
        Mockito.when(iteratorMock.hasNext()).thenReturn(true, false);
        Mockito.when(iteratorMock.next()).thenReturn(entityList);
        Assert.assertEquals(entityList, sealapplymanageService.getListByFilter(sealapplymanagefilterMapper), "异常");
	}

	@Test(groups = "groupGet", dependsOnMethods = "getListByFilterTest")
	public void getFilterMapListTest()
	{
		List<Map<String, Object>> entityMapList = new ArrayList<>();
        List<SealApplyManage> t1 = Mockito.mock(ArrayList.class);
        List<SealApplyManage> t2 = null;
        Mockito.when(sealapplymanageService.getListByFilter(sealapplymanagefilterMapper)).thenReturn(t1);
        Mockito.doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocationOnMock) throws Throwable {
                Object argument = invocationOnMock.getArgument(0);
                SealApplyManage.class.getDeclaredMethod("accept", SealApplyManage.class).invoke(argument, 1);
                return argument;
            }
        }).when(t1).forEach(entity -> entityMapList.add(SealApplyManageSimpleMapper.buildMap(entity)));
        Assert.assertEquals(entityMapList, sealapplymanageService.getFilterMapList(sealapplymanagefilterMapper), "异常");
	}

	@Test(groups = "groupPost", dependsOnMethods = "getByPKTest", expectedExceptions = StatusException.class)
	public void postTestException()
	{
		StatusException e = new StatusException("POST_ENTITY_DUPLICATE");
        sealapplymanage = new SealApplyManage();
        Mockito.when(sealapplymanagedao.insertSelective(SealApplyManageData.convert(sealapplymanage, new SealApplyManageDO()))).thenThrow(e);
        SealApplyManage res = sealapplymanageService.post(sealapplymanage);
        throw e;
	}

	@Test(groups = "groupPost", dependsOnMethods = "getByPKTest")
	public void postTest()
	{
		 SealApplyManage test = new  SealApplyManage();
 SealApplyManage spySealApplyManage = Mockito.spy(test);
        Mockito.when(sealapplymanagedao.insertSelective(SealApplyManageData.convert(test, new SealApplyManageDO()))).thenReturn(1);
        SealApplyManage res = sealapplymanageService.post(test);
	}

	@Test(groups = "groupUpadte", dependsOnMethods = "getByPKTest", expectedExceptions = NullPointerException.class)
	public void updateTest()
	{
		int actual = 1;
        Mockito.when(sealapplymanagedao.updateByPrimaryKeySelective(SealApplyManageData.convert(sealapplymanage, new SealApplyManageDO()))).thenReturn(1);
        Assert.assertEquals(actual, sealapplymanagedao.updateByPrimaryKeySelective(SealApplyManageData.convert(sealapplymanage, new SealApplyManageDO())), "不相等");

	}

	@Test(groups = "groupPut", dependsOnMethods = "getByPKTest")
	public void putTestIsNull()
	{
		SealApplyManage putEntity=new SealApplyManage();
        putEntity.setId("1");
        Object actual=null;
        Mockito.when(sealapplymanageService.getByPK(putEntity.getId())).thenReturn(null);
        Mockito.when(sealapplymanagedao.insertSelective(SealApplyManageData.convert(putEntity, new SealApplyManageDO()))).thenReturn(1);
        Assert.assertEquals(actual,sealapplymanageService.put(putEntity),"不相等");
	}

	@Test(groups = "groupDelete")
	public void deleteTest()
	{
		String testid = "1";
        AtomicInteger count = new AtomicInteger();
        Mockito.when(count.addAndGet(sealapplymanagedao.deleteByPrimaryKey(testid))).thenReturn(1);
        int actual = sealapplymanageService.delete(testid);
        Assert.assertEquals(actual, 1, "不相等");
	}

	@Test(groups = "groupGet", dependsOnMethods = "getCountByFilterTest")
	public void getRateAndCountByFilterTest()
	{
		Map<String, Map<String, Object>> res = new HashMap<>();
        List<String> groupBy = Mockito.mock(List.class);
        res = sealapplymanageService.getFilterListGroup(sealapplymanagefilterMapper, groupBy);
        Assert.assertEquals(res.size(), 0, "不相等");
	}

}