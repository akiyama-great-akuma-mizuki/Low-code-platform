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
public class NoticeEnterprisetest {
	@Mock
	public NoticeEnterpriseDAO noticeenterprisedao;

	@Mock
	public NoticeEnterpriseSimpleMapper noticeenterpriseSimpleMapper;

	@Mock
	public NoticeEnterprise noticeenterprise;

	@Mock
	public NoticeEnterpriseFilterMapper noticeenterprisefilterMapper;

	@InjectMocks
	public NoticeEnterpriseService noticeenterpriseService;

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
        NoticeEnterpriseDO noticeenterprisedo = new NoticeEnterpriseDO();
        noticeenterprisedo.setId(testid);
        Mockito.when(noticeenterprisedao.selectByPrimaryKey(testid)).thenReturn(noticeenterprisedo);
        Assert.assertEquals(noticeenterpriseService.getByPK(testid).getId(), testid, "不相等");
	}

	@Test(groups = "getGet", dependsOnMethods = "getByPKTest")
	public void getSimpleMapByPKTest()
	{
		String testid = mockParams.get("id").toString();
        Map<String, Object> res = noticeenterpriseSimpleMapper.buildMap(noticeenterpriseService.getByPK(testid));
       Assert.assertEquals(noticeenterpriseService.getSimpleMapByPK(testid), res, "getSimpleMapByPK不相等");
	}

	@Test(groups = "groupGet", dependsOnMethods = "getByPKTest")
	public void getDetailMapByPKTestIsNull()
	{
		String testid = "1";
        Mockito.when(noticeenterpriseService.getByPK(testid)).thenReturn(null);
        Assert.assertEquals(null, noticeenterpriseService.getDetailMapByPK(testid), "异常");
	}

	@Test(groups = "groupGet")
	public void getCountByFilterTest()
	{
		        Long count = 0L;
        Mockito.doReturn(mockParams).when(noticeenterprisefilterMapper).buildMap();
        NoticeEnterpriseDOExample example = NoticeEnterpriseFilter.initDOQueryFilter(mockParams);
        Mockito.doReturn(count).when(noticeenterprisedao).countByExample(example);
        Assert.assertEquals(count, noticeenterpriseService.getCountByFilter(noticeenterprisefilterMapper), "异常");

	}

	@Test(groups = "groupGet")
	public void getListByFilterTest()
	{
		List<NoticeEnterprise> entityList = new ArrayList<>();
        Mockito.doReturn(mockParams).when(noticeenterprisefilterMapper).buildMap();
        NoticeEnterpriseDOExample example = NoticeEnterpriseFilter.initDOQueryFilter(mockParams);

        List<NoticeEnterprise> res = Mockito.mock(List.class);
        Mockito.doReturn(res).when(noticeenterprisedao).selectByExample(example);
        Iterator iteratorMock = Mockito.mock(Iterator.class);
        Mockito.when(res.iterator()).thenReturn(iteratorMock);
        Mockito.when(iteratorMock.hasNext()).thenReturn(true, false);
        Mockito.when(iteratorMock.next()).thenReturn(entityList);
        Assert.assertEquals(entityList, noticeenterpriseService.getListByFilter(noticeenterprisefilterMapper), "异常");
	}

	@Test(groups = "groupGet", dependsOnMethods = "getListByFilterTest")
	public void getFilterMapListTest()
	{
		List<Map<String, Object>> entityMapList = new ArrayList<>();
        List<NoticeEnterprise> t1 = Mockito.mock(ArrayList.class);
        List<NoticeEnterprise> t2 = null;
        Mockito.when(noticeenterpriseService.getListByFilter(noticeenterprisefilterMapper)).thenReturn(t1);
        Mockito.doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocationOnMock) throws Throwable {
                Object argument = invocationOnMock.getArgument(0);
                NoticeEnterprise.class.getDeclaredMethod("accept", NoticeEnterprise.class).invoke(argument, 1);
                return argument;
            }
        }).when(t1).forEach(entity -> entityMapList.add(NoticeEnterpriseSimpleMapper.buildMap(entity)));
        Assert.assertEquals(entityMapList, noticeenterpriseService.getFilterMapList(noticeenterprisefilterMapper), "异常");
	}

	@Test(groups = "groupPost", dependsOnMethods = "getByPKTest", expectedExceptions = StatusException.class)
	public void postTestException()
	{
		StatusException e = new StatusException("POST_ENTITY_DUPLICATE");
        noticeenterprise = new NoticeEnterprise();
        Mockito.when(noticeenterprisedao.insertSelective(NoticeEnterpriseData.convert(noticeenterprise, new NoticeEnterpriseDO()))).thenThrow(e);
        NoticeEnterprise res = noticeenterpriseService.post(noticeenterprise);
        throw e;
	}

	@Test(groups = "groupPost", dependsOnMethods = "getByPKTest")
	public void postTest()
	{
		 NoticeEnterprise test = new  NoticeEnterprise();
 NoticeEnterprise spyNoticeEnterprise = Mockito.spy(test);
        Mockito.when(noticeenterprisedao.insertSelective(NoticeEnterpriseData.convert(test, new NoticeEnterpriseDO()))).thenReturn(1);
        NoticeEnterprise res = noticeenterpriseService.post(test);
	}

	@Test(groups = "groupUpadte", dependsOnMethods = "getByPKTest", expectedExceptions = NullPointerException.class)
	public void updateTest()
	{
		int actual = 1;
        Mockito.when(noticeenterprisedao.updateByPrimaryKeySelective(NoticeEnterpriseData.convert(noticeenterprise, new NoticeEnterpriseDO()))).thenReturn(1);
        Assert.assertEquals(actual, noticeenterprisedao.updateByPrimaryKeySelective(NoticeEnterpriseData.convert(noticeenterprise, new NoticeEnterpriseDO())), "不相等");

	}

	@Test(groups = "groupPut", dependsOnMethods = "getByPKTest")
	public void putTestIsNull()
	{
		NoticeEnterprise putEntity=new NoticeEnterprise();
        putEntity.setId("1");
        Object actual=null;
        Mockito.when(noticeenterpriseService.getByPK(putEntity.getId())).thenReturn(null);
        Mockito.when(noticeenterprisedao.insertSelective(NoticeEnterpriseData.convert(putEntity, new NoticeEnterpriseDO()))).thenReturn(1);
        Assert.assertEquals(actual,noticeenterpriseService.put(putEntity),"不相等");
	}

	@Test(groups = "groupDelete")
	public void deleteTest()
	{
		String testid = "1";
        AtomicInteger count = new AtomicInteger();
        Mockito.when(count.addAndGet(noticeenterprisedao.deleteByPrimaryKey(testid))).thenReturn(1);
        int actual = noticeenterpriseService.delete(testid);
        Assert.assertEquals(actual, 1, "不相等");
	}

	@Test(groups = "groupGet", dependsOnMethods = "getCountByFilterTest")
	public void getRateAndCountByFilterTest()
	{
		Map<String, Map<String, Object>> res = new HashMap<>();
        List<String> groupBy = Mockito.mock(List.class);
        res = noticeenterpriseService.getFilterListGroup(noticeenterprisefilterMapper, groupBy);
        Assert.assertEquals(res.size(), 0, "不相等");
	}

}