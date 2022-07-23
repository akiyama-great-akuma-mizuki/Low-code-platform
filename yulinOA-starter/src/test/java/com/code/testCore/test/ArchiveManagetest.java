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
public class ArchiveManagetest {
	@Mock
	public ArchiveManageDAO archivemanagedao;

	@Mock
	public ArchiveManageSimpleMapper archivemanageSimpleMapper;

	@Mock
	public ArchiveManage archivemanage;

	@Mock
	public ArchiveManageFilterMapper archivemanagefilterMapper;

	@InjectMocks
	public ArchiveManageService archivemanageService;

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
        ArchiveManageDO archivemanagedo = new ArchiveManageDO();
        archivemanagedo.setId(testid);
        Mockito.when(archivemanagedao.selectByPrimaryKey(testid)).thenReturn(archivemanagedo);
        Assert.assertEquals(archivemanageService.getByPK(testid).getId(), testid, "不相等");
	}

	@Test(groups = "getGet", dependsOnMethods = "getByPKTest")
	public void getSimpleMapByPKTest()
	{
		String testid = mockParams.get("id").toString();
        Map<String, Object> res = archivemanageSimpleMapper.buildMap(archivemanageService.getByPK(testid));
       Assert.assertEquals(archivemanageService.getSimpleMapByPK(testid), res, "getSimpleMapByPK不相等");
	}

	@Test(groups = "groupGet", dependsOnMethods = "getByPKTest")
	public void getDetailMapByPKTestIsNull()
	{
		String testid = "1";
        Mockito.when(archivemanageService.getByPK(testid)).thenReturn(null);
        Assert.assertEquals(null, archivemanageService.getDetailMapByPK(testid), "异常");
	}

	@Test(groups = "groupGet")
	public void getCountByFilterTest()
	{
		        Long count = 0L;
        Mockito.doReturn(mockParams).when(archivemanagefilterMapper).buildMap();
        ArchiveManageDOExample example = ArchiveManageFilter.initDOQueryFilter(mockParams);
        Mockito.doReturn(count).when(archivemanagedao).countByExample(example);
        Assert.assertEquals(count, archivemanageService.getCountByFilter(archivemanagefilterMapper), "异常");

	}

	@Test(groups = "groupGet")
	public void getListByFilterTest()
	{
		List<ArchiveManage> entityList = new ArrayList<>();
        Mockito.doReturn(mockParams).when(archivemanagefilterMapper).buildMap();
        ArchiveManageDOExample example = ArchiveManageFilter.initDOQueryFilter(mockParams);

        List<ArchiveManage> res = Mockito.mock(List.class);
        Mockito.doReturn(res).when(archivemanagedao).selectByExample(example);
        Iterator iteratorMock = Mockito.mock(Iterator.class);
        Mockito.when(res.iterator()).thenReturn(iteratorMock);
        Mockito.when(iteratorMock.hasNext()).thenReturn(true, false);
        Mockito.when(iteratorMock.next()).thenReturn(entityList);
        Assert.assertEquals(entityList, archivemanageService.getListByFilter(archivemanagefilterMapper), "异常");
	}

	@Test(groups = "groupGet", dependsOnMethods = "getListByFilterTest")
	public void getFilterMapListTest()
	{
		List<Map<String, Object>> entityMapList = new ArrayList<>();
        List<ArchiveManage> t1 = Mockito.mock(ArrayList.class);
        List<ArchiveManage> t2 = null;
        Mockito.when(archivemanageService.getListByFilter(archivemanagefilterMapper)).thenReturn(t1);
        Mockito.doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocationOnMock) throws Throwable {
                Object argument = invocationOnMock.getArgument(0);
                ArchiveManage.class.getDeclaredMethod("accept", ArchiveManage.class).invoke(argument, 1);
                return argument;
            }
        }).when(t1).forEach(entity -> entityMapList.add(ArchiveManageSimpleMapper.buildMap(entity)));
        Assert.assertEquals(entityMapList, archivemanageService.getFilterMapList(archivemanagefilterMapper), "异常");
	}

	@Test(groups = "groupPost", dependsOnMethods = "getByPKTest", expectedExceptions = StatusException.class)
	public void postTestException()
	{
		StatusException e = new StatusException("POST_ENTITY_DUPLICATE");
        archivemanage = new ArchiveManage();
        Mockito.when(archivemanagedao.insertSelective(ArchiveManageData.convert(archivemanage, new ArchiveManageDO()))).thenThrow(e);
        ArchiveManage res = archivemanageService.post(archivemanage);
        throw e;
	}

	@Test(groups = "groupPost", dependsOnMethods = "getByPKTest")
	public void postTest()
	{
		 ArchiveManage test = new  ArchiveManage();
 ArchiveManage spyArchiveManage = Mockito.spy(test);
        Mockito.when(archivemanagedao.insertSelective(ArchiveManageData.convert(test, new ArchiveManageDO()))).thenReturn(1);
        ArchiveManage res = archivemanageService.post(test);
	}

	@Test(groups = "groupUpadte", dependsOnMethods = "getByPKTest", expectedExceptions = NullPointerException.class)
	public void updateTest()
	{
		int actual = 1;
        Mockito.when(archivemanagedao.updateByPrimaryKeySelective(ArchiveManageData.convert(archivemanage, new ArchiveManageDO()))).thenReturn(1);
        Assert.assertEquals(actual, archivemanagedao.updateByPrimaryKeySelective(ArchiveManageData.convert(archivemanage, new ArchiveManageDO())), "不相等");

	}

	@Test(groups = "groupPut", dependsOnMethods = "getByPKTest")
	public void putTestIsNull()
	{
		ArchiveManage putEntity=new ArchiveManage();
        putEntity.setId("1");
        Object actual=null;
        Mockito.when(archivemanageService.getByPK(putEntity.getId())).thenReturn(null);
        Mockito.when(archivemanagedao.insertSelective(ArchiveManageData.convert(putEntity, new ArchiveManageDO()))).thenReturn(1);
        Assert.assertEquals(actual,archivemanageService.put(putEntity),"不相等");
	}

	@Test(groups = "groupDelete")
	public void deleteTest()
	{
		String testid = "1";
        AtomicInteger count = new AtomicInteger();
        Mockito.when(count.addAndGet(archivemanagedao.deleteByPrimaryKey(testid))).thenReturn(1);
        int actual = archivemanageService.delete(testid);
        Assert.assertEquals(actual, 1, "不相等");
	}

	@Test(groups = "groupGet", dependsOnMethods = "getCountByFilterTest")
	public void getRateAndCountByFilterTest()
	{
		Map<String, Map<String, Object>> res = new HashMap<>();
        List<String> groupBy = Mockito.mock(List.class);
        res = archivemanageService.getFilterListGroup(archivemanagefilterMapper, groupBy);
        Assert.assertEquals(res.size(), 0, "不相等");
	}

}