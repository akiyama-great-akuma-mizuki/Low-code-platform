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
public class SealApplyCheckManagetest {
	@Mock
	public SealApplyCheckManageDAO sealapplycheckmanagedao;

	@Mock
	public SealApplyCheckManageSimpleMapper sealapplycheckmanageSimpleMapper;

	@Mock
	public SealApplyCheckManage sealapplycheckmanage;

	@Mock
	public SealApplyCheckManageFilterMapper sealapplycheckmanagefilterMapper;

	@InjectMocks
	public SealApplyCheckManageService sealapplycheckmanageService;

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
        SealApplyCheckManageDO sealapplycheckmanagedo = new SealApplyCheckManageDO();
        sealapplycheckmanagedo.setId(testid);
        Mockito.when(sealapplycheckmanagedao.selectByPrimaryKey(testid)).thenReturn(sealapplycheckmanagedo);
        Assert.assertEquals(sealapplycheckmanageService.getByPK(testid).getId(), testid, "不相等");
	}

	@Test(groups = "getGet", dependsOnMethods = "getByPKTest")
	public void getSimpleMapByPKTest()
	{
		String testid = mockParams.get("id").toString();
        Map<String, Object> res = sealapplycheckmanageSimpleMapper.buildMap(sealapplycheckmanageService.getByPK(testid));
       Assert.assertEquals(sealapplycheckmanageService.getSimpleMapByPK(testid), res, "getSimpleMapByPK不相等");
	}

	@Test(groups = "groupGet", dependsOnMethods = "getByPKTest")
	public void getDetailMapByPKTestIsNull()
	{
		String testid = "1";
        Mockito.when(sealapplycheckmanageService.getByPK(testid)).thenReturn(null);
        Assert.assertEquals(null, sealapplycheckmanageService.getDetailMapByPK(testid), "异常");
	}

	@Test(groups = "groupGet")
	public void getCountByFilterTest()
	{
		        Long count = 0L;
        Mockito.doReturn(mockParams).when(sealapplycheckmanagefilterMapper).buildMap();
        SealApplyCheckManageDOExample example = SealApplyCheckManageFilter.initDOQueryFilter(mockParams);
        Mockito.doReturn(count).when(sealapplycheckmanagedao).countByExample(example);
        Assert.assertEquals(count, sealapplycheckmanageService.getCountByFilter(sealapplycheckmanagefilterMapper), "异常");

	}

	@Test(groups = "groupGet")
	public void getListByFilterTest()
	{
		List<SealApplyCheckManage> entityList = new ArrayList<>();
        Mockito.doReturn(mockParams).when(sealapplycheckmanagefilterMapper).buildMap();
        SealApplyCheckManageDOExample example = SealApplyCheckManageFilter.initDOQueryFilter(mockParams);

        List<SealApplyCheckManage> res = Mockito.mock(List.class);
        Mockito.doReturn(res).when(sealapplycheckmanagedao).selectByExample(example);
        Iterator iteratorMock = Mockito.mock(Iterator.class);
        Mockito.when(res.iterator()).thenReturn(iteratorMock);
        Mockito.when(iteratorMock.hasNext()).thenReturn(true, false);
        Mockito.when(iteratorMock.next()).thenReturn(entityList);
        Assert.assertEquals(entityList, sealapplycheckmanageService.getListByFilter(sealapplycheckmanagefilterMapper), "异常");
	}

	@Test(groups = "groupGet", dependsOnMethods = "getListByFilterTest")
	public void getFilterMapListTest()
	{
		List<Map<String, Object>> entityMapList = new ArrayList<>();
        List<SealApplyCheckManage> t1 = Mockito.mock(ArrayList.class);
        List<SealApplyCheckManage> t2 = null;
        Mockito.when(sealapplycheckmanageService.getListByFilter(sealapplycheckmanagefilterMapper)).thenReturn(t1);
        Mockito.doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocationOnMock) throws Throwable {
                Object argument = invocationOnMock.getArgument(0);
                SealApplyCheckManage.class.getDeclaredMethod("accept", SealApplyCheckManage.class).invoke(argument, 1);
                return argument;
            }
        }).when(t1).forEach(entity -> entityMapList.add(SealApplyCheckManageSimpleMapper.buildMap(entity)));
        Assert.assertEquals(entityMapList, sealapplycheckmanageService.getFilterMapList(sealapplycheckmanagefilterMapper), "异常");
	}

	@Test(groups = "groupPost", dependsOnMethods = "getByPKTest", expectedExceptions = StatusException.class)
	public void postTestException()
	{
		StatusException e = new StatusException("POST_ENTITY_DUPLICATE");
        sealapplycheckmanage = new SealApplyCheckManage();
        Mockito.when(sealapplycheckmanagedao.insertSelective(SealApplyCheckManageData.convert(sealapplycheckmanage, new SealApplyCheckManageDO()))).thenThrow(e);
        SealApplyCheckManage res = sealapplycheckmanageService.post(sealapplycheckmanage);
        throw e;
	}

	@Test(groups = "groupPost", dependsOnMethods = "getByPKTest")
	public void postTest()
	{
		 SealApplyCheckManage test = new  SealApplyCheckManage();
 SealApplyCheckManage spySealApplyCheckManage = Mockito.spy(test);
        Mockito.when(sealapplycheckmanagedao.insertSelective(SealApplyCheckManageData.convert(test, new SealApplyCheckManageDO()))).thenReturn(1);
        SealApplyCheckManage res = sealapplycheckmanageService.post(test);
	}

	@Test(groups = "groupUpadte", dependsOnMethods = "getByPKTest", expectedExceptions = NullPointerException.class)
	public void updateTest()
	{
		int actual = 1;
        Mockito.when(sealapplycheckmanagedao.updateByPrimaryKeySelective(SealApplyCheckManageData.convert(sealapplycheckmanage, new SealApplyCheckManageDO()))).thenReturn(1);
        Assert.assertEquals(actual, sealapplycheckmanagedao.updateByPrimaryKeySelective(SealApplyCheckManageData.convert(sealapplycheckmanage, new SealApplyCheckManageDO())), "不相等");

	}

	@Test(groups = "groupPut", dependsOnMethods = "getByPKTest")
	public void putTestIsNull()
	{
		SealApplyCheckManage putEntity=new SealApplyCheckManage();
        putEntity.setId("1");
        Object actual=null;
        Mockito.when(sealapplycheckmanageService.getByPK(putEntity.getId())).thenReturn(null);
        Mockito.when(sealapplycheckmanagedao.insertSelective(SealApplyCheckManageData.convert(putEntity, new SealApplyCheckManageDO()))).thenReturn(1);
        Assert.assertEquals(actual,sealapplycheckmanageService.put(putEntity),"不相等");
	}

	@Test(groups = "groupDelete")
	public void deleteTest()
	{
		String testid = "1";
        AtomicInteger count = new AtomicInteger();
        Mockito.when(count.addAndGet(sealapplycheckmanagedao.deleteByPrimaryKey(testid))).thenReturn(1);
        int actual = sealapplycheckmanageService.delete(testid);
        Assert.assertEquals(actual, 1, "不相等");
	}

	@Test(groups = "groupGet", dependsOnMethods = "getCountByFilterTest")
	public void getRateAndCountByFilterTest()
	{
		Map<String, Map<String, Object>> res = new HashMap<>();
        List<String> groupBy = Mockito.mock(List.class);
        res = sealapplycheckmanageService.getFilterListGroup(sealapplycheckmanagefilterMapper, groupBy);
        Assert.assertEquals(res.size(), 0, "不相等");
	}

}