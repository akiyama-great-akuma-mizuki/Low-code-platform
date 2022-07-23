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
public class DiyFlowFinishtest {
	@Mock
	public DiyFlowFinishDAO diyflowfinishdao;

	@Mock
	public DiyFlowFinishSimpleMapper diyflowfinishSimpleMapper;

	@Mock
	public DiyFlowFinish diyflowfinish;

	@Mock
	public DiyFlowFinishFilterMapper diyflowfinishfilterMapper;

	@InjectMocks
	public DiyFlowFinishService diyflowfinishService;

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
        DiyFlowFinishDO diyflowfinishdo = new DiyFlowFinishDO();
        diyflowfinishdo.setId(testid);
        Mockito.when(diyflowfinishdao.selectByPrimaryKey(testid)).thenReturn(diyflowfinishdo);
        Assert.assertEquals(diyflowfinishService.getByPK(testid).getId(), testid, "不相等");
	}

	@Test(groups = "getGet", dependsOnMethods = "getByPKTest")
	public void getSimpleMapByPKTest()
	{
		String testid = mockParams.get("id").toString();
        Map<String, Object> res = diyflowfinishSimpleMapper.buildMap(diyflowfinishService.getByPK(testid));
       Assert.assertEquals(diyflowfinishService.getSimpleMapByPK(testid), res, "getSimpleMapByPK不相等");
	}

	@Test(groups = "groupGet", dependsOnMethods = "getByPKTest")
	public void getDetailMapByPKTestIsNull()
	{
		String testid = "1";
        Mockito.when(diyflowfinishService.getByPK(testid)).thenReturn(null);
        Assert.assertEquals(null, diyflowfinishService.getDetailMapByPK(testid), "异常");
	}

	@Test(groups = "groupGet")
	public void getCountByFilterTest()
	{
		        Long count = 0L;
        Mockito.doReturn(mockParams).when(diyflowfinishfilterMapper).buildMap();
        DiyFlowFinishDOExample example = DiyFlowFinishFilter.initDOQueryFilter(mockParams);
        Mockito.doReturn(count).when(diyflowfinishdao).countByExample(example);
        Assert.assertEquals(count, diyflowfinishService.getCountByFilter(diyflowfinishfilterMapper), "异常");

	}

	@Test(groups = "groupGet")
	public void getListByFilterTest()
	{
		List<DiyFlowFinish> entityList = new ArrayList<>();
        Mockito.doReturn(mockParams).when(diyflowfinishfilterMapper).buildMap();
        DiyFlowFinishDOExample example = DiyFlowFinishFilter.initDOQueryFilter(mockParams);

        List<DiyFlowFinish> res = Mockito.mock(List.class);
        Mockito.doReturn(res).when(diyflowfinishdao).selectByExample(example);
        Iterator iteratorMock = Mockito.mock(Iterator.class);
        Mockito.when(res.iterator()).thenReturn(iteratorMock);
        Mockito.when(iteratorMock.hasNext()).thenReturn(true, false);
        Mockito.when(iteratorMock.next()).thenReturn(entityList);
        Assert.assertEquals(entityList, diyflowfinishService.getListByFilter(diyflowfinishfilterMapper), "异常");
	}

	@Test(groups = "groupGet", dependsOnMethods = "getListByFilterTest")
	public void getFilterMapListTest()
	{
		List<Map<String, Object>> entityMapList = new ArrayList<>();
        List<DiyFlowFinish> t1 = Mockito.mock(ArrayList.class);
        List<DiyFlowFinish> t2 = null;
        Mockito.when(diyflowfinishService.getListByFilter(diyflowfinishfilterMapper)).thenReturn(t1);
        Mockito.doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocationOnMock) throws Throwable {
                Object argument = invocationOnMock.getArgument(0);
                DiyFlowFinish.class.getDeclaredMethod("accept", DiyFlowFinish.class).invoke(argument, 1);
                return argument;
            }
        }).when(t1).forEach(entity -> entityMapList.add(DiyFlowFinishSimpleMapper.buildMap(entity)));
        Assert.assertEquals(entityMapList, diyflowfinishService.getFilterMapList(diyflowfinishfilterMapper), "异常");
	}

	@Test(groups = "groupPost", dependsOnMethods = "getByPKTest", expectedExceptions = StatusException.class)
	public void postTestException()
	{
		StatusException e = new StatusException("POST_ENTITY_DUPLICATE");
        diyflowfinish = new DiyFlowFinish();
        Mockito.when(diyflowfinishdao.insertSelective(DiyFlowFinishData.convert(diyflowfinish, new DiyFlowFinishDO()))).thenThrow(e);
        DiyFlowFinish res = diyflowfinishService.post(diyflowfinish);
        throw e;
	}

	@Test(groups = "groupPost", dependsOnMethods = "getByPKTest")
	public void postTest()
	{
		 DiyFlowFinish test = new  DiyFlowFinish();
 DiyFlowFinish spyDiyFlowFinish = Mockito.spy(test);
        Mockito.when(diyflowfinishdao.insertSelective(DiyFlowFinishData.convert(test, new DiyFlowFinishDO()))).thenReturn(1);
        DiyFlowFinish res = diyflowfinishService.post(test);
	}

	@Test(groups = "groupUpadte", dependsOnMethods = "getByPKTest", expectedExceptions = NullPointerException.class)
	public void updateTest()
	{
		int actual = 1;
        Mockito.when(diyflowfinishdao.updateByPrimaryKeySelective(DiyFlowFinishData.convert(diyflowfinish, new DiyFlowFinishDO()))).thenReturn(1);
        Assert.assertEquals(actual, diyflowfinishdao.updateByPrimaryKeySelective(DiyFlowFinishData.convert(diyflowfinish, new DiyFlowFinishDO())), "不相等");

	}

	@Test(groups = "groupPut", dependsOnMethods = "getByPKTest")
	public void putTestIsNull()
	{
		DiyFlowFinish putEntity=new DiyFlowFinish();
        putEntity.setId("1");
        Object actual=null;
        Mockito.when(diyflowfinishService.getByPK(putEntity.getId())).thenReturn(null);
        Mockito.when(diyflowfinishdao.insertSelective(DiyFlowFinishData.convert(putEntity, new DiyFlowFinishDO()))).thenReturn(1);
        Assert.assertEquals(actual,diyflowfinishService.put(putEntity),"不相等");
	}

	@Test(groups = "groupDelete")
	public void deleteTest()
	{
		String testid = "1";
        AtomicInteger count = new AtomicInteger();
        Mockito.when(count.addAndGet(diyflowfinishdao.deleteByPrimaryKey(testid))).thenReturn(1);
        int actual = diyflowfinishService.delete(testid);
        Assert.assertEquals(actual, 1, "不相等");
	}

	@Test(groups = "groupGet", dependsOnMethods = "getCountByFilterTest")
	public void getRateAndCountByFilterTest()
	{
		Map<String, Map<String, Object>> res = new HashMap<>();
        List<String> groupBy = Mockito.mock(List.class);
        res = diyflowfinishService.getFilterListGroup(diyflowfinishfilterMapper, groupBy);
        Assert.assertEquals(res.size(), 0, "不相等");
	}

}