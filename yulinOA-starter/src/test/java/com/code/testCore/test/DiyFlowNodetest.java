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
public class DiyFlowNodetest {
	@Mock
	public DiyFlowNodeDAO diyflownodedao;

	@Mock
	public DiyFlowNodeSimpleMapper diyflownodeSimpleMapper;

	@Mock
	public DiyFlowNode diyflownode;

	@Mock
	public DiyFlowNodeFilterMapper diyflownodefilterMapper;

	@InjectMocks
	public DiyFlowNodeService diyflownodeService;

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
        DiyFlowNodeDO diyflownodedo = new DiyFlowNodeDO();
        diyflownodedo.setId(testid);
        Mockito.when(diyflownodedao.selectByPrimaryKey(testid)).thenReturn(diyflownodedo);
        Assert.assertEquals(diyflownodeService.getByPK(testid).getId(), testid, "不相等");
	}

	@Test(groups = "getGet", dependsOnMethods = "getByPKTest")
	public void getSimpleMapByPKTest()
	{
		String testid = mockParams.get("id").toString();
        Map<String, Object> res = diyflownodeSimpleMapper.buildMap(diyflownodeService.getByPK(testid));
       Assert.assertEquals(diyflownodeService.getSimpleMapByPK(testid), res, "getSimpleMapByPK不相等");
	}

	@Test(groups = "groupGet", dependsOnMethods = "getByPKTest")
	public void getDetailMapByPKTestIsNull()
	{
		String testid = "1";
        Mockito.when(diyflownodeService.getByPK(testid)).thenReturn(null);
        Assert.assertEquals(null, diyflownodeService.getDetailMapByPK(testid), "异常");
	}

	@Test(groups = "groupGet")
	public void getCountByFilterTest()
	{
		        Long count = 0L;
        Mockito.doReturn(mockParams).when(diyflownodefilterMapper).buildMap();
        DiyFlowNodeDOExample example = DiyFlowNodeFilter.initDOQueryFilter(mockParams);
        Mockito.doReturn(count).when(diyflownodedao).countByExample(example);
        Assert.assertEquals(count, diyflownodeService.getCountByFilter(diyflownodefilterMapper), "异常");

	}

	@Test(groups = "groupGet")
	public void getListByFilterTest()
	{
		List<DiyFlowNode> entityList = new ArrayList<>();
        Mockito.doReturn(mockParams).when(diyflownodefilterMapper).buildMap();
        DiyFlowNodeDOExample example = DiyFlowNodeFilter.initDOQueryFilter(mockParams);

        List<DiyFlowNode> res = Mockito.mock(List.class);
        Mockito.doReturn(res).when(diyflownodedao).selectByExample(example);
        Iterator iteratorMock = Mockito.mock(Iterator.class);
        Mockito.when(res.iterator()).thenReturn(iteratorMock);
        Mockito.when(iteratorMock.hasNext()).thenReturn(true, false);
        Mockito.when(iteratorMock.next()).thenReturn(entityList);
        Assert.assertEquals(entityList, diyflownodeService.getListByFilter(diyflownodefilterMapper), "异常");
	}

	@Test(groups = "groupGet", dependsOnMethods = "getListByFilterTest")
	public void getFilterMapListTest()
	{
		List<Map<String, Object>> entityMapList = new ArrayList<>();
        List<DiyFlowNode> t1 = Mockito.mock(ArrayList.class);
        List<DiyFlowNode> t2 = null;
        Mockito.when(diyflownodeService.getListByFilter(diyflownodefilterMapper)).thenReturn(t1);
        Mockito.doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocationOnMock) throws Throwable {
                Object argument = invocationOnMock.getArgument(0);
                DiyFlowNode.class.getDeclaredMethod("accept", DiyFlowNode.class).invoke(argument, 1);
                return argument;
            }
        }).when(t1).forEach(entity -> entityMapList.add(DiyFlowNodeSimpleMapper.buildMap(entity)));
        Assert.assertEquals(entityMapList, diyflownodeService.getFilterMapList(diyflownodefilterMapper), "异常");
	}

	@Test(groups = "groupPost", dependsOnMethods = "getByPKTest", expectedExceptions = StatusException.class)
	public void postTestException()
	{
		StatusException e = new StatusException("POST_ENTITY_DUPLICATE");
        diyflownode = new DiyFlowNode();
        Mockito.when(diyflownodedao.insertSelective(DiyFlowNodeData.convert(diyflownode, new DiyFlowNodeDO()))).thenThrow(e);
        DiyFlowNode res = diyflownodeService.post(diyflownode);
        throw e;
	}

	@Test(groups = "groupPost", dependsOnMethods = "getByPKTest")
	public void postTest()
	{
		 DiyFlowNode test = new  DiyFlowNode();
 DiyFlowNode spyDiyFlowNode = Mockito.spy(test);
        Mockito.when(diyflownodedao.insertSelective(DiyFlowNodeData.convert(test, new DiyFlowNodeDO()))).thenReturn(1);
        DiyFlowNode res = diyflownodeService.post(test);
	}

	@Test(groups = "groupUpadte", dependsOnMethods = "getByPKTest", expectedExceptions = NullPointerException.class)
	public void updateTest()
	{
		int actual = 1;
        Mockito.when(diyflownodedao.updateByPrimaryKeySelective(DiyFlowNodeData.convert(diyflownode, new DiyFlowNodeDO()))).thenReturn(1);
        Assert.assertEquals(actual, diyflownodedao.updateByPrimaryKeySelective(DiyFlowNodeData.convert(diyflownode, new DiyFlowNodeDO())), "不相等");

	}

	@Test(groups = "groupPut", dependsOnMethods = "getByPKTest")
	public void putTestIsNull()
	{
		DiyFlowNode putEntity=new DiyFlowNode();
        putEntity.setId("1");
        Object actual=null;
        Mockito.when(diyflownodeService.getByPK(putEntity.getId())).thenReturn(null);
        Mockito.when(diyflownodedao.insertSelective(DiyFlowNodeData.convert(putEntity, new DiyFlowNodeDO()))).thenReturn(1);
        Assert.assertEquals(actual,diyflownodeService.put(putEntity),"不相等");
	}

	@Test(groups = "groupDelete")
	public void deleteTest()
	{
		String testid = "1";
        AtomicInteger count = new AtomicInteger();
        Mockito.when(count.addAndGet(diyflownodedao.deleteByPrimaryKey(testid))).thenReturn(1);
        int actual = diyflownodeService.delete(testid);
        Assert.assertEquals(actual, 1, "不相等");
	}

	@Test(groups = "groupGet", dependsOnMethods = "getCountByFilterTest")
	public void getRateAndCountByFilterTest()
	{
		Map<String, Map<String, Object>> res = new HashMap<>();
        List<String> groupBy = Mockito.mock(List.class);
        res = diyflownodeService.getFilterListGroup(diyflownodefilterMapper, groupBy);
        Assert.assertEquals(res.size(), 0, "不相等");
	}

}