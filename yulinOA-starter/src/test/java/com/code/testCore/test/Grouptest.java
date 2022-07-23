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
public class Grouptest {
	@Mock
	public GroupDAO groupdao;

	@Mock
	public GroupSimpleMapper groupSimpleMapper;

	@Mock
	public Group group;

	@Mock
	public GroupFilterMapper groupfilterMapper;

	@InjectMocks
	public GroupService groupService;

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
        GroupDO groupdo = new GroupDO();
        groupdo.setId(testid);
        Mockito.when(groupdao.selectByPrimaryKey(testid)).thenReturn(groupdo);
        Assert.assertEquals(groupService.getByPK(testid).getId(), testid, "不相等");
	}

	@Test(groups = "getGet", dependsOnMethods = "getByPKTest")
	public void getSimpleMapByPKTest()
	{
		String testid = mockParams.get("id").toString();
        Map<String, Object> res = groupSimpleMapper.buildMap(groupService.getByPK(testid));
       Assert.assertEquals(groupService.getSimpleMapByPK(testid), res, "getSimpleMapByPK不相等");
	}

	@Test(groups = "groupGet", dependsOnMethods = "getByPKTest")
	public void getDetailMapByPKTestIsNull()
	{
		String testid = "1";
        Mockito.when(groupService.getByPK(testid)).thenReturn(null);
        Assert.assertEquals(null, groupService.getDetailMapByPK(testid), "异常");
	}

	@Test(groups = "groupGet")
	public void getCountByFilterTest()
	{
		        Long count = 0L;
        Mockito.doReturn(mockParams).when(groupfilterMapper).buildMap();
        GroupDOExample example = GroupFilter.initDOQueryFilter(mockParams);
        Mockito.doReturn(count).when(groupdao).countByExample(example);
        Assert.assertEquals(count, groupService.getCountByFilter(groupfilterMapper), "异常");

	}

	@Test(groups = "groupGet")
	public void getListByFilterTest()
	{
		List<Group> entityList = new ArrayList<>();
        Mockito.doReturn(mockParams).when(groupfilterMapper).buildMap();
        GroupDOExample example = GroupFilter.initDOQueryFilter(mockParams);

        List<Group> res = Mockito.mock(List.class);
        Mockito.doReturn(res).when(groupdao).selectByExample(example);
        Iterator iteratorMock = Mockito.mock(Iterator.class);
        Mockito.when(res.iterator()).thenReturn(iteratorMock);
        Mockito.when(iteratorMock.hasNext()).thenReturn(true, false);
        Mockito.when(iteratorMock.next()).thenReturn(entityList);
        Assert.assertEquals(entityList, groupService.getListByFilter(groupfilterMapper), "异常");
	}

	@Test(groups = "groupGet", dependsOnMethods = "getListByFilterTest")
	public void getFilterMapListTest()
	{
		List<Map<String, Object>> entityMapList = new ArrayList<>();
        List<Group> t1 = Mockito.mock(ArrayList.class);
        List<Group> t2 = null;
        Mockito.when(groupService.getListByFilter(groupfilterMapper)).thenReturn(t1);
        Mockito.doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocationOnMock) throws Throwable {
                Object argument = invocationOnMock.getArgument(0);
                Group.class.getDeclaredMethod("accept", Group.class).invoke(argument, 1);
                return argument;
            }
        }).when(t1).forEach(entity -> entityMapList.add(GroupSimpleMapper.buildMap(entity)));
        Assert.assertEquals(entityMapList, groupService.getFilterMapList(groupfilterMapper), "异常");
	}

	@Test(groups = "groupPost", dependsOnMethods = "getByPKTest", expectedExceptions = StatusException.class)
	public void postTestException()
	{
		StatusException e = new StatusException("POST_ENTITY_DUPLICATE");
        group = new Group();
        Mockito.when(groupdao.insertSelective(GroupData.convert(group, new GroupDO()))).thenThrow(e);
        Group res = groupService.post(group);
        throw e;
	}

	@Test(groups = "groupPost", dependsOnMethods = "getByPKTest")
	public void postTest()
	{
		 Group test = new  Group();
 Group spyGroup = Mockito.spy(test);
        Mockito.when(groupdao.insertSelective(GroupData.convert(test, new GroupDO()))).thenReturn(1);
        Group res = groupService.post(test);
	}

	@Test(groups = "groupUpadte", dependsOnMethods = "getByPKTest", expectedExceptions = NullPointerException.class)
	public void updateTest()
	{
		int actual = 1;
        Mockito.when(groupdao.updateByPrimaryKeySelective(GroupData.convert(group, new GroupDO()))).thenReturn(1);
        Assert.assertEquals(actual, groupdao.updateByPrimaryKeySelective(GroupData.convert(group, new GroupDO())), "不相等");

	}

	@Test(groups = "groupPut", dependsOnMethods = "getByPKTest")
	public void putTestIsNull()
	{
		Group putEntity=new Group();
        putEntity.setId("1");
        Object actual=null;
        Mockito.when(groupService.getByPK(putEntity.getId())).thenReturn(null);
        Mockito.when(groupdao.insertSelective(GroupData.convert(putEntity, new GroupDO()))).thenReturn(1);
        Assert.assertEquals(actual,groupService.put(putEntity),"不相等");
	}

	@Test(groups = "groupDelete")
	public void deleteTest()
	{
		String testid = "1";
        AtomicInteger count = new AtomicInteger();
        Mockito.when(count.addAndGet(groupdao.deleteByPrimaryKey(testid))).thenReturn(1);
        int actual = groupService.delete(testid);
        Assert.assertEquals(actual, 1, "不相等");
	}

	@Test(groups = "groupGet", dependsOnMethods = "getCountByFilterTest")
	public void getRateAndCountByFilterTest()
	{
		Map<String, Map<String, Object>> res = new HashMap<>();
        List<String> groupBy = Mockito.mock(List.class);
        res = groupService.getFilterListGroup(groupfilterMapper, groupBy);
        Assert.assertEquals(res.size(), 0, "不相等");
	}

}