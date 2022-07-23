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
public class PropertyRecordtest {
	@Mock
	public PropertyRecordDAO propertyrecorddao;

	@Mock
	public PropertyRecordSimpleMapper propertyrecordSimpleMapper;

	@Mock
	public PropertyRecord propertyrecord;

	@Mock
	public PropertyRecordFilterMapper propertyrecordfilterMapper;

	@InjectMocks
	public PropertyRecordService propertyrecordService;

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
        PropertyRecordDO propertyrecorddo = new PropertyRecordDO();
        propertyrecorddo.setId(testid);
        Mockito.when(propertyrecorddao.selectByPrimaryKey(testid)).thenReturn(propertyrecorddo);
        Assert.assertEquals(propertyrecordService.getByPK(testid).getId(), testid, "不相等");
	}

	@Test(groups = "getGet", dependsOnMethods = "getByPKTest")
	public void getSimpleMapByPKTest()
	{
		String testid = mockParams.get("id").toString();
        Map<String, Object> res = propertyrecordSimpleMapper.buildMap(propertyrecordService.getByPK(testid));
       Assert.assertEquals(propertyrecordService.getSimpleMapByPK(testid), res, "getSimpleMapByPK不相等");
	}

	@Test(groups = "groupGet", dependsOnMethods = "getByPKTest")
	public void getDetailMapByPKTestIsNull()
	{
		String testid = "1";
        Mockito.when(propertyrecordService.getByPK(testid)).thenReturn(null);
        Assert.assertEquals(null, propertyrecordService.getDetailMapByPK(testid), "异常");
	}

	@Test(groups = "groupGet")
	public void getCountByFilterTest()
	{
		        Long count = 0L;
        Mockito.doReturn(mockParams).when(propertyrecordfilterMapper).buildMap();
        PropertyRecordDOExample example = PropertyRecordFilter.initDOQueryFilter(mockParams);
        Mockito.doReturn(count).when(propertyrecorddao).countByExample(example);
        Assert.assertEquals(count, propertyrecordService.getCountByFilter(propertyrecordfilterMapper), "异常");

	}

	@Test(groups = "groupGet")
	public void getListByFilterTest()
	{
		List<PropertyRecord> entityList = new ArrayList<>();
        Mockito.doReturn(mockParams).when(propertyrecordfilterMapper).buildMap();
        PropertyRecordDOExample example = PropertyRecordFilter.initDOQueryFilter(mockParams);

        List<PropertyRecord> res = Mockito.mock(List.class);
        Mockito.doReturn(res).when(propertyrecorddao).selectByExample(example);
        Iterator iteratorMock = Mockito.mock(Iterator.class);
        Mockito.when(res.iterator()).thenReturn(iteratorMock);
        Mockito.when(iteratorMock.hasNext()).thenReturn(true, false);
        Mockito.when(iteratorMock.next()).thenReturn(entityList);
        Assert.assertEquals(entityList, propertyrecordService.getListByFilter(propertyrecordfilterMapper), "异常");
	}

	@Test(groups = "groupGet", dependsOnMethods = "getListByFilterTest")
	public void getFilterMapListTest()
	{
		List<Map<String, Object>> entityMapList = new ArrayList<>();
        List<PropertyRecord> t1 = Mockito.mock(ArrayList.class);
        List<PropertyRecord> t2 = null;
        Mockito.when(propertyrecordService.getListByFilter(propertyrecordfilterMapper)).thenReturn(t1);
        Mockito.doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocationOnMock) throws Throwable {
                Object argument = invocationOnMock.getArgument(0);
                PropertyRecord.class.getDeclaredMethod("accept", PropertyRecord.class).invoke(argument, 1);
                return argument;
            }
        }).when(t1).forEach(entity -> entityMapList.add(PropertyRecordSimpleMapper.buildMap(entity)));
        Assert.assertEquals(entityMapList, propertyrecordService.getFilterMapList(propertyrecordfilterMapper), "异常");
	}

	@Test(groups = "groupPost", dependsOnMethods = "getByPKTest", expectedExceptions = StatusException.class)
	public void postTestException()
	{
		StatusException e = new StatusException("POST_ENTITY_DUPLICATE");
        propertyrecord = new PropertyRecord();
        Mockito.when(propertyrecorddao.insertSelective(PropertyRecordData.convert(propertyrecord, new PropertyRecordDO()))).thenThrow(e);
        PropertyRecord res = propertyrecordService.post(propertyrecord);
        throw e;
	}

	@Test(groups = "groupPost", dependsOnMethods = "getByPKTest")
	public void postTest()
	{
		 PropertyRecord test = new  PropertyRecord();
 PropertyRecord spyPropertyRecord = Mockito.spy(test);
        Mockito.when(propertyrecorddao.insertSelective(PropertyRecordData.convert(test, new PropertyRecordDO()))).thenReturn(1);
        PropertyRecord res = propertyrecordService.post(test);
	}

	@Test(groups = "groupUpadte", dependsOnMethods = "getByPKTest", expectedExceptions = NullPointerException.class)
	public void updateTest()
	{
		int actual = 1;
        Mockito.when(propertyrecorddao.updateByPrimaryKeySelective(PropertyRecordData.convert(propertyrecord, new PropertyRecordDO()))).thenReturn(1);
        Assert.assertEquals(actual, propertyrecorddao.updateByPrimaryKeySelective(PropertyRecordData.convert(propertyrecord, new PropertyRecordDO())), "不相等");

	}

	@Test(groups = "groupPut", dependsOnMethods = "getByPKTest")
	public void putTestIsNull()
	{
		PropertyRecord putEntity=new PropertyRecord();
        putEntity.setId("1");
        Object actual=null;
        Mockito.when(propertyrecordService.getByPK(putEntity.getId())).thenReturn(null);
        Mockito.when(propertyrecorddao.insertSelective(PropertyRecordData.convert(putEntity, new PropertyRecordDO()))).thenReturn(1);
        Assert.assertEquals(actual,propertyrecordService.put(putEntity),"不相等");
	}

	@Test(groups = "groupDelete")
	public void deleteTest()
	{
		String testid = "1";
        AtomicInteger count = new AtomicInteger();
        Mockito.when(count.addAndGet(propertyrecorddao.deleteByPrimaryKey(testid))).thenReturn(1);
        int actual = propertyrecordService.delete(testid);
        Assert.assertEquals(actual, 1, "不相等");
	}

	@Test(groups = "groupGet", dependsOnMethods = "getCountByFilterTest")
	public void getRateAndCountByFilterTest()
	{
		Map<String, Map<String, Object>> res = new HashMap<>();
        List<String> groupBy = Mockito.mock(List.class);
        res = propertyrecordService.getFilterListGroup(propertyrecordfilterMapper, groupBy);
        Assert.assertEquals(res.size(), 0, "不相等");
	}

}