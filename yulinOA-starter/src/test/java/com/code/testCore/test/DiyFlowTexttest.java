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
public class DiyFlowTexttest {
	@Mock
	public DiyFlowTextDAO diyflowtextdao;

	@Mock
	public DiyFlowTextSimpleMapper diyflowtextSimpleMapper;

	@Mock
	public DiyFlowText diyflowtext;

	@Mock
	public DiyFlowTextFilterMapper diyflowtextfilterMapper;

	@InjectMocks
	public DiyFlowTextService diyflowtextService;

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
        DiyFlowTextDO diyflowtextdo = new DiyFlowTextDO();
        diyflowtextdo.setId(testid);
        Mockito.when(diyflowtextdao.selectByPrimaryKey(testid)).thenReturn(diyflowtextdo);
        Assert.assertEquals(diyflowtextService.getByPK(testid).getId(), testid, "不相等");
	}

	@Test(groups = "getGet", dependsOnMethods = "getByPKTest")
	public void getSimpleMapByPKTest()
	{
		String testid = mockParams.get("id").toString();
        Map<String, Object> res = diyflowtextSimpleMapper.buildMap(diyflowtextService.getByPK(testid));
       Assert.assertEquals(diyflowtextService.getSimpleMapByPK(testid), res, "getSimpleMapByPK不相等");
	}

	@Test(groups = "groupGet", dependsOnMethods = "getByPKTest")
	public void getDetailMapByPKTestIsNull()
	{
		String testid = "1";
        Mockito.when(diyflowtextService.getByPK(testid)).thenReturn(null);
        Assert.assertEquals(null, diyflowtextService.getDetailMapByPK(testid), "异常");
	}

	@Test(groups = "groupGet")
	public void getCountByFilterTest()
	{
		        Long count = 0L;
        Mockito.doReturn(mockParams).when(diyflowtextfilterMapper).buildMap();
        DiyFlowTextDOExample example = DiyFlowTextFilter.initDOQueryFilter(mockParams);
        Mockito.doReturn(count).when(diyflowtextdao).countByExample(example);
        Assert.assertEquals(count, diyflowtextService.getCountByFilter(diyflowtextfilterMapper), "异常");

	}

	@Test(groups = "groupGet")
	public void getListByFilterTest()
	{
		List<DiyFlowText> entityList = new ArrayList<>();
        Mockito.doReturn(mockParams).when(diyflowtextfilterMapper).buildMap();
        DiyFlowTextDOExample example = DiyFlowTextFilter.initDOQueryFilter(mockParams);

        List<DiyFlowText> res = Mockito.mock(List.class);
        Mockito.doReturn(res).when(diyflowtextdao).selectByExample(example);
        Iterator iteratorMock = Mockito.mock(Iterator.class);
        Mockito.when(res.iterator()).thenReturn(iteratorMock);
        Mockito.when(iteratorMock.hasNext()).thenReturn(true, false);
        Mockito.when(iteratorMock.next()).thenReturn(entityList);
        Assert.assertEquals(entityList, diyflowtextService.getListByFilter(diyflowtextfilterMapper), "异常");
	}

	@Test(groups = "groupGet", dependsOnMethods = "getListByFilterTest")
	public void getFilterMapListTest()
	{
		List<Map<String, Object>> entityMapList = new ArrayList<>();
        List<DiyFlowText> t1 = Mockito.mock(ArrayList.class);
        List<DiyFlowText> t2 = null;
        Mockito.when(diyflowtextService.getListByFilter(diyflowtextfilterMapper)).thenReturn(t1);
        Mockito.doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocationOnMock) throws Throwable {
                Object argument = invocationOnMock.getArgument(0);
                DiyFlowText.class.getDeclaredMethod("accept", DiyFlowText.class).invoke(argument, 1);
                return argument;
            }
        }).when(t1).forEach(entity -> entityMapList.add(DiyFlowTextSimpleMapper.buildMap(entity)));
        Assert.assertEquals(entityMapList, diyflowtextService.getFilterMapList(diyflowtextfilterMapper), "异常");
	}

	@Test(groups = "groupPost", dependsOnMethods = "getByPKTest", expectedExceptions = StatusException.class)
	public void postTestException()
	{
		StatusException e = new StatusException("POST_ENTITY_DUPLICATE");
        diyflowtext = new DiyFlowText();
        Mockito.when(diyflowtextdao.insertSelective(DiyFlowTextData.convert(diyflowtext, new DiyFlowTextDO()))).thenThrow(e);
        DiyFlowText res = diyflowtextService.post(diyflowtext);
        throw e;
	}

	@Test(groups = "groupPost", dependsOnMethods = "getByPKTest")
	public void postTest()
	{
		 DiyFlowText test = new  DiyFlowText();
 DiyFlowText spyDiyFlowText = Mockito.spy(test);
        Mockito.when(diyflowtextdao.insertSelective(DiyFlowTextData.convert(test, new DiyFlowTextDO()))).thenReturn(1);
        DiyFlowText res = diyflowtextService.post(test);
	}

	@Test(groups = "groupUpadte", dependsOnMethods = "getByPKTest", expectedExceptions = NullPointerException.class)
	public void updateTest()
	{
		int actual = 1;
        Mockito.when(diyflowtextdao.updateByPrimaryKeySelective(DiyFlowTextData.convert(diyflowtext, new DiyFlowTextDO()))).thenReturn(1);
        Assert.assertEquals(actual, diyflowtextdao.updateByPrimaryKeySelective(DiyFlowTextData.convert(diyflowtext, new DiyFlowTextDO())), "不相等");

	}

	@Test(groups = "groupPut", dependsOnMethods = "getByPKTest")
	public void putTestIsNull()
	{
		DiyFlowText putEntity=new DiyFlowText();
        putEntity.setId("1");
        Object actual=null;
        Mockito.when(diyflowtextService.getByPK(putEntity.getId())).thenReturn(null);
        Mockito.when(diyflowtextdao.insertSelective(DiyFlowTextData.convert(putEntity, new DiyFlowTextDO()))).thenReturn(1);
        Assert.assertEquals(actual,diyflowtextService.put(putEntity),"不相等");
	}

	@Test(groups = "groupDelete")
	public void deleteTest()
	{
		String testid = "1";
        AtomicInteger count = new AtomicInteger();
        Mockito.when(count.addAndGet(diyflowtextdao.deleteByPrimaryKey(testid))).thenReturn(1);
        int actual = diyflowtextService.delete(testid);
        Assert.assertEquals(actual, 1, "不相等");
	}

	@Test(groups = "groupGet", dependsOnMethods = "getCountByFilterTest")
	public void getRateAndCountByFilterTest()
	{
		Map<String, Map<String, Object>> res = new HashMap<>();
        List<String> groupBy = Mockito.mock(List.class);
        res = diyflowtextService.getFilterListGroup(diyflowtextfilterMapper, groupBy);
        Assert.assertEquals(res.size(), 0, "不相等");
	}

}