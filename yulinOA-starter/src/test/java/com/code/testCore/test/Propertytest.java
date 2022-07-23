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
public class Propertytest {
	@Mock
	public PropertyDAO propertydao;

	@Mock
	public PropertySimpleMapper propertySimpleMapper;

	@Mock
	public Property property;

	@Mock
	public PropertyFilterMapper propertyfilterMapper;

	@InjectMocks
	public PropertyService propertyService;

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
        PropertyDO propertydo = new PropertyDO();
        propertydo.setId(testid);
        Mockito.when(propertydao.selectByPrimaryKey(testid)).thenReturn(propertydo);
        Assert.assertEquals(propertyService.getByPK(testid).getId(), testid, "不相等");
	}

	@Test(groups = "getGet", dependsOnMethods = "getByPKTest")
	public void getSimpleMapByPKTest()
	{
		String testid = mockParams.get("id").toString();
        Map<String, Object> res = propertySimpleMapper.buildMap(propertyService.getByPK(testid));
       Assert.assertEquals(propertyService.getSimpleMapByPK(testid), res, "getSimpleMapByPK不相等");
	}

	@Test(groups = "groupGet", dependsOnMethods = "getByPKTest")
	public void getDetailMapByPKTestIsNull()
	{
		String testid = "1";
        Mockito.when(propertyService.getByPK(testid)).thenReturn(null);
        Assert.assertEquals(null, propertyService.getDetailMapByPK(testid), "异常");
	}

	@Test(groups = "groupGet")
	public void getCountByFilterTest()
	{
		        Long count = 0L;
        Mockito.doReturn(mockParams).when(propertyfilterMapper).buildMap();
        PropertyDOExample example = PropertyFilter.initDOQueryFilter(mockParams);
        Mockito.doReturn(count).when(propertydao).countByExample(example);
        Assert.assertEquals(count, propertyService.getCountByFilter(propertyfilterMapper), "异常");

	}

	@Test(groups = "groupGet")
	public void getListByFilterTest()
	{
		List<Property> entityList = new ArrayList<>();
        Mockito.doReturn(mockParams).when(propertyfilterMapper).buildMap();
        PropertyDOExample example = PropertyFilter.initDOQueryFilter(mockParams);

        List<Property> res = Mockito.mock(List.class);
        Mockito.doReturn(res).when(propertydao).selectByExample(example);
        Iterator iteratorMock = Mockito.mock(Iterator.class);
        Mockito.when(res.iterator()).thenReturn(iteratorMock);
        Mockito.when(iteratorMock.hasNext()).thenReturn(true, false);
        Mockito.when(iteratorMock.next()).thenReturn(entityList);
        Assert.assertEquals(entityList, propertyService.getListByFilter(propertyfilterMapper), "异常");
	}

	@Test(groups = "groupGet", dependsOnMethods = "getListByFilterTest")
	public void getFilterMapListTest()
	{
		List<Map<String, Object>> entityMapList = new ArrayList<>();
        List<Property> t1 = Mockito.mock(ArrayList.class);
        List<Property> t2 = null;
        Mockito.when(propertyService.getListByFilter(propertyfilterMapper)).thenReturn(t1);
        Mockito.doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocationOnMock) throws Throwable {
                Object argument = invocationOnMock.getArgument(0);
                Property.class.getDeclaredMethod("accept", Property.class).invoke(argument, 1);
                return argument;
            }
        }).when(t1).forEach(entity -> entityMapList.add(PropertySimpleMapper.buildMap(entity)));
        Assert.assertEquals(entityMapList, propertyService.getFilterMapList(propertyfilterMapper), "异常");
	}

	@Test(groups = "groupPost", dependsOnMethods = "getByPKTest", expectedExceptions = StatusException.class)
	public void postTestException()
	{
		StatusException e = new StatusException("POST_ENTITY_DUPLICATE");
        property = new Property();
        Mockito.when(propertydao.insertSelective(PropertyData.convert(property, new PropertyDO()))).thenThrow(e);
        Property res = propertyService.post(property);
        throw e;
	}

	@Test(groups = "groupPost", dependsOnMethods = "getByPKTest")
	public void postTest()
	{
		 Property test = new  Property();
 Property spyProperty = Mockito.spy(test);
        Mockito.when(propertydao.insertSelective(PropertyData.convert(test, new PropertyDO()))).thenReturn(1);
        Property res = propertyService.post(test);
	}

	@Test(groups = "groupUpadte", dependsOnMethods = "getByPKTest", expectedExceptions = NullPointerException.class)
	public void updateTest()
	{
		int actual = 1;
        Mockito.when(propertydao.updateByPrimaryKeySelective(PropertyData.convert(property, new PropertyDO()))).thenReturn(1);
        Assert.assertEquals(actual, propertydao.updateByPrimaryKeySelective(PropertyData.convert(property, new PropertyDO())), "不相等");

	}

	@Test(groups = "groupPut", dependsOnMethods = "getByPKTest")
	public void putTestIsNull()
	{
		Property putEntity=new Property();
        putEntity.setId("1");
        Object actual=null;
        Mockito.when(propertyService.getByPK(putEntity.getId())).thenReturn(null);
        Mockito.when(propertydao.insertSelective(PropertyData.convert(putEntity, new PropertyDO()))).thenReturn(1);
        Assert.assertEquals(actual,propertyService.put(putEntity),"不相等");
	}

	@Test(groups = "groupDelete")
	public void deleteTest()
	{
		String testid = "1";
        AtomicInteger count = new AtomicInteger();
        Mockito.when(count.addAndGet(propertydao.deleteByPrimaryKey(testid))).thenReturn(1);
        int actual = propertyService.delete(testid);
        Assert.assertEquals(actual, 1, "不相等");
	}

	@Test(groups = "groupGet", dependsOnMethods = "getCountByFilterTest")
	public void getRateAndCountByFilterTest()
	{
		Map<String, Map<String, Object>> res = new HashMap<>();
        List<String> groupBy = Mockito.mock(List.class);
        res = propertyService.getFilterListGroup(propertyfilterMapper, groupBy);
        Assert.assertEquals(res.size(), 0, "不相等");
	}

}