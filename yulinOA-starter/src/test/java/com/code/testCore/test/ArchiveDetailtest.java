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
public class ArchiveDetailtest {
	@Mock
	public ArchiveDetailDAO archivedetaildao;

	@Mock
	public ArchiveDetailSimpleMapper archivedetailSimpleMapper;

	@Mock
	public ArchiveDetail archivedetail;

	@Mock
	public ArchiveDetailFilterMapper archivedetailfilterMapper;

	@InjectMocks
	public ArchiveDetailService archivedetailService;

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
        ArchiveDetailDO archivedetaildo = new ArchiveDetailDO();
        archivedetaildo.setId(testid);
        Mockito.when(archivedetaildao.selectByPrimaryKey(testid)).thenReturn(archivedetaildo);
        Assert.assertEquals(archivedetailService.getByPK(testid).getId(), testid, "不相等");
	}

	@Test(groups = "getGet", dependsOnMethods = "getByPKTest")
	public void getSimpleMapByPKTest()
	{
		String testid = mockParams.get("id").toString();
        Map<String, Object> res = archivedetailSimpleMapper.buildMap(archivedetailService.getByPK(testid));
       Assert.assertEquals(archivedetailService.getSimpleMapByPK(testid), res, "getSimpleMapByPK不相等");
	}

	@Test(groups = "groupGet", dependsOnMethods = "getByPKTest")
	public void getDetailMapByPKTestIsNull()
	{
		String testid = "1";
        Mockito.when(archivedetailService.getByPK(testid)).thenReturn(null);
        Assert.assertEquals(null, archivedetailService.getDetailMapByPK(testid), "异常");
	}

	@Test(groups = "groupGet")
	public void getCountByFilterTest()
	{
		        Long count = 0L;
        Mockito.doReturn(mockParams).when(archivedetailfilterMapper).buildMap();
        ArchiveDetailDOExample example = ArchiveDetailFilter.initDOQueryFilter(mockParams);
        Mockito.doReturn(count).when(archivedetaildao).countByExample(example);
        Assert.assertEquals(count, archivedetailService.getCountByFilter(archivedetailfilterMapper), "异常");

	}

	@Test(groups = "groupGet")
	public void getListByFilterTest()
	{
		List<ArchiveDetail> entityList = new ArrayList<>();
        Mockito.doReturn(mockParams).when(archivedetailfilterMapper).buildMap();
        ArchiveDetailDOExample example = ArchiveDetailFilter.initDOQueryFilter(mockParams);

        List<ArchiveDetail> res = Mockito.mock(List.class);
        Mockito.doReturn(res).when(archivedetaildao).selectByExample(example);
        Iterator iteratorMock = Mockito.mock(Iterator.class);
        Mockito.when(res.iterator()).thenReturn(iteratorMock);
        Mockito.when(iteratorMock.hasNext()).thenReturn(true, false);
        Mockito.when(iteratorMock.next()).thenReturn(entityList);
        Assert.assertEquals(entityList, archivedetailService.getListByFilter(archivedetailfilterMapper), "异常");
	}

	@Test(groups = "groupGet", dependsOnMethods = "getListByFilterTest")
	public void getFilterMapListTest()
	{
		List<Map<String, Object>> entityMapList = new ArrayList<>();
        List<ArchiveDetail> t1 = Mockito.mock(ArrayList.class);
        List<ArchiveDetail> t2 = null;
        Mockito.when(archivedetailService.getListByFilter(archivedetailfilterMapper)).thenReturn(t1);
        Mockito.doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocationOnMock) throws Throwable {
                Object argument = invocationOnMock.getArgument(0);
                ArchiveDetail.class.getDeclaredMethod("accept", ArchiveDetail.class).invoke(argument, 1);
                return argument;
            }
        }).when(t1).forEach(entity -> entityMapList.add(ArchiveDetailSimpleMapper.buildMap(entity)));
        Assert.assertEquals(entityMapList, archivedetailService.getFilterMapList(archivedetailfilterMapper), "异常");
	}

	@Test(groups = "groupPost", dependsOnMethods = "getByPKTest", expectedExceptions = StatusException.class)
	public void postTestException()
	{
		StatusException e = new StatusException("POST_ENTITY_DUPLICATE");
        archivedetail = new ArchiveDetail();
        Mockito.when(archivedetaildao.insertSelective(ArchiveDetailData.convert(archivedetail, new ArchiveDetailDO()))).thenThrow(e);
        ArchiveDetail res = archivedetailService.post(archivedetail);
        throw e;
	}

	@Test(groups = "groupPost", dependsOnMethods = "getByPKTest")
	public void postTest()
	{
		 ArchiveDetail test = new  ArchiveDetail();
 ArchiveDetail spyArchiveDetail = Mockito.spy(test);
        Mockito.when(archivedetaildao.insertSelective(ArchiveDetailData.convert(test, new ArchiveDetailDO()))).thenReturn(1);
        ArchiveDetail res = archivedetailService.post(test);
	}

	@Test(groups = "groupUpadte", dependsOnMethods = "getByPKTest", expectedExceptions = NullPointerException.class)
	public void updateTest()
	{
		int actual = 1;
        Mockito.when(archivedetaildao.updateByPrimaryKeySelective(ArchiveDetailData.convert(archivedetail, new ArchiveDetailDO()))).thenReturn(1);
        Assert.assertEquals(actual, archivedetaildao.updateByPrimaryKeySelective(ArchiveDetailData.convert(archivedetail, new ArchiveDetailDO())), "不相等");

	}

	@Test(groups = "groupPut", dependsOnMethods = "getByPKTest")
	public void putTestIsNull()
	{
		ArchiveDetail putEntity=new ArchiveDetail();
        putEntity.setId("1");
        Object actual=null;
        Mockito.when(archivedetailService.getByPK(putEntity.getId())).thenReturn(null);
        Mockito.when(archivedetaildao.insertSelective(ArchiveDetailData.convert(putEntity, new ArchiveDetailDO()))).thenReturn(1);
        Assert.assertEquals(actual,archivedetailService.put(putEntity),"不相等");
	}

	@Test(groups = "groupDelete")
	public void deleteTest()
	{
		String testid = "1";
        AtomicInteger count = new AtomicInteger();
        Mockito.when(count.addAndGet(archivedetaildao.deleteByPrimaryKey(testid))).thenReturn(1);
        int actual = archivedetailService.delete(testid);
        Assert.assertEquals(actual, 1, "不相等");
	}

	@Test(groups = "groupGet", dependsOnMethods = "getCountByFilterTest")
	public void getRateAndCountByFilterTest()
	{
		Map<String, Map<String, Object>> res = new HashMap<>();
        List<String> groupBy = Mockito.mock(List.class);
        res = archivedetailService.getFilterListGroup(archivedetailfilterMapper, groupBy);
        Assert.assertEquals(res.size(), 0, "不相等");
	}

}