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
public class MeetingRoomtest {
	@Mock
	public MeetingRoomDAO meetingroomdao;

	@Mock
	public MeetingRoomSimpleMapper meetingroomSimpleMapper;

	@Mock
	public MeetingRoom meetingroom;

	@Mock
	public MeetingRoomFilterMapper meetingroomfilterMapper;

	@InjectMocks
	public MeetingRoomService meetingroomService;

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
        MeetingRoomDO meetingroomdo = new MeetingRoomDO();
        meetingroomdo.setId(testid);
        Mockito.when(meetingroomdao.selectByPrimaryKey(testid)).thenReturn(meetingroomdo);
        Assert.assertEquals(meetingroomService.getByPK(testid).getId(), testid, "不相等");
	}

	@Test(groups = "getGet", dependsOnMethods = "getByPKTest")
	public void getSimpleMapByPKTest()
	{
		String testid = mockParams.get("id").toString();
        Map<String, Object> res = meetingroomSimpleMapper.buildMap(meetingroomService.getByPK(testid));
       Assert.assertEquals(meetingroomService.getSimpleMapByPK(testid), res, "getSimpleMapByPK不相等");
	}

	@Test(groups = "groupGet", dependsOnMethods = "getByPKTest")
	public void getDetailMapByPKTestIsNull()
	{
		String testid = "1";
        Mockito.when(meetingroomService.getByPK(testid)).thenReturn(null);
        Assert.assertEquals(null, meetingroomService.getDetailMapByPK(testid), "异常");
	}

	@Test(groups = "groupGet")
	public void getCountByFilterTest()
	{
		        Long count = 0L;
        Mockito.doReturn(mockParams).when(meetingroomfilterMapper).buildMap();
        MeetingRoomDOExample example = MeetingRoomFilter.initDOQueryFilter(mockParams);
        Mockito.doReturn(count).when(meetingroomdao).countByExample(example);
        Assert.assertEquals(count, meetingroomService.getCountByFilter(meetingroomfilterMapper), "异常");

	}

	@Test(groups = "groupGet")
	public void getListByFilterTest()
	{
		List<MeetingRoom> entityList = new ArrayList<>();
        Mockito.doReturn(mockParams).when(meetingroomfilterMapper).buildMap();
        MeetingRoomDOExample example = MeetingRoomFilter.initDOQueryFilter(mockParams);

        List<MeetingRoom> res = Mockito.mock(List.class);
        Mockito.doReturn(res).when(meetingroomdao).selectByExample(example);
        Iterator iteratorMock = Mockito.mock(Iterator.class);
        Mockito.when(res.iterator()).thenReturn(iteratorMock);
        Mockito.when(iteratorMock.hasNext()).thenReturn(true, false);
        Mockito.when(iteratorMock.next()).thenReturn(entityList);
        Assert.assertEquals(entityList, meetingroomService.getListByFilter(meetingroomfilterMapper), "异常");
	}

	@Test(groups = "groupGet", dependsOnMethods = "getListByFilterTest")
	public void getFilterMapListTest()
	{
		List<Map<String, Object>> entityMapList = new ArrayList<>();
        List<MeetingRoom> t1 = Mockito.mock(ArrayList.class);
        List<MeetingRoom> t2 = null;
        Mockito.when(meetingroomService.getListByFilter(meetingroomfilterMapper)).thenReturn(t1);
        Mockito.doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocationOnMock) throws Throwable {
                Object argument = invocationOnMock.getArgument(0);
                MeetingRoom.class.getDeclaredMethod("accept", MeetingRoom.class).invoke(argument, 1);
                return argument;
            }
        }).when(t1).forEach(entity -> entityMapList.add(MeetingRoomSimpleMapper.buildMap(entity)));
        Assert.assertEquals(entityMapList, meetingroomService.getFilterMapList(meetingroomfilterMapper), "异常");
	}

	@Test(groups = "groupPost", dependsOnMethods = "getByPKTest", expectedExceptions = StatusException.class)
	public void postTestException()
	{
		StatusException e = new StatusException("POST_ENTITY_DUPLICATE");
        meetingroom = new MeetingRoom();
        Mockito.when(meetingroomdao.insertSelective(MeetingRoomData.convert(meetingroom, new MeetingRoomDO()))).thenThrow(e);
        MeetingRoom res = meetingroomService.post(meetingroom);
        throw e;
	}

	@Test(groups = "groupPost", dependsOnMethods = "getByPKTest")
	public void postTest()
	{
		 MeetingRoom test = new  MeetingRoom();
 MeetingRoom spyMeetingRoom = Mockito.spy(test);
        Mockito.when(meetingroomdao.insertSelective(MeetingRoomData.convert(test, new MeetingRoomDO()))).thenReturn(1);
        MeetingRoom res = meetingroomService.post(test);
	}

	@Test(groups = "groupUpadte", dependsOnMethods = "getByPKTest", expectedExceptions = NullPointerException.class)
	public void updateTest()
	{
		int actual = 1;
        Mockito.when(meetingroomdao.updateByPrimaryKeySelective(MeetingRoomData.convert(meetingroom, new MeetingRoomDO()))).thenReturn(1);
        Assert.assertEquals(actual, meetingroomdao.updateByPrimaryKeySelective(MeetingRoomData.convert(meetingroom, new MeetingRoomDO())), "不相等");

	}

	@Test(groups = "groupPut", dependsOnMethods = "getByPKTest")
	public void putTestIsNull()
	{
		MeetingRoom putEntity=new MeetingRoom();
        putEntity.setId("1");
        Object actual=null;
        Mockito.when(meetingroomService.getByPK(putEntity.getId())).thenReturn(null);
        Mockito.when(meetingroomdao.insertSelective(MeetingRoomData.convert(putEntity, new MeetingRoomDO()))).thenReturn(1);
        Assert.assertEquals(actual,meetingroomService.put(putEntity),"不相等");
	}

	@Test(groups = "groupDelete")
	public void deleteTest()
	{
		String testid = "1";
        AtomicInteger count = new AtomicInteger();
        Mockito.when(count.addAndGet(meetingroomdao.deleteByPrimaryKey(testid))).thenReturn(1);
        int actual = meetingroomService.delete(testid);
        Assert.assertEquals(actual, 1, "不相等");
	}

	@Test(groups = "groupGet", dependsOnMethods = "getCountByFilterTest")
	public void getRateAndCountByFilterTest()
	{
		Map<String, Map<String, Object>> res = new HashMap<>();
        List<String> groupBy = Mockito.mock(List.class);
        res = meetingroomService.getFilterListGroup(meetingroomfilterMapper, groupBy);
        Assert.assertEquals(res.size(), 0, "不相等");
	}

}