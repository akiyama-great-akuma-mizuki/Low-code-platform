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
public class Meetingtest {
	@Mock
	public MeetingDAO meetingdao;

	@Mock
	public MeetingSimpleMapper meetingSimpleMapper;

	@Mock
	public Meeting meeting;

	@Mock
	public MeetingFilterMapper meetingfilterMapper;

	@InjectMocks
	public MeetingService meetingService;

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
        MeetingDO meetingdo = new MeetingDO();
        meetingdo.setId(testid);
        Mockito.when(meetingdao.selectByPrimaryKey(testid)).thenReturn(meetingdo);
        Assert.assertEquals(meetingService.getByPK(testid).getId(), testid, "不相等");
	}

	@Test(groups = "getGet", dependsOnMethods = "getByPKTest")
	public void getSimpleMapByPKTest()
	{
		String testid = mockParams.get("id").toString();
        Map<String, Object> res = meetingSimpleMapper.buildMap(meetingService.getByPK(testid));
       Assert.assertEquals(meetingService.getSimpleMapByPK(testid), res, "getSimpleMapByPK不相等");
	}

	@Test(groups = "groupGet", dependsOnMethods = "getByPKTest")
	public void getDetailMapByPKTestIsNull()
	{
		String testid = "1";
        Mockito.when(meetingService.getByPK(testid)).thenReturn(null);
        Assert.assertEquals(null, meetingService.getDetailMapByPK(testid), "异常");
	}

	@Test(groups = "groupGet")
	public void getCountByFilterTest()
	{
		        Long count = 0L;
        Mockito.doReturn(mockParams).when(meetingfilterMapper).buildMap();
        MeetingDOExample example = MeetingFilter.initDOQueryFilter(mockParams);
        Mockito.doReturn(count).when(meetingdao).countByExample(example);
        Assert.assertEquals(count, meetingService.getCountByFilter(meetingfilterMapper), "异常");

	}

	@Test(groups = "groupGet")
	public void getListByFilterTest()
	{
		List<Meeting> entityList = new ArrayList<>();
        Mockito.doReturn(mockParams).when(meetingfilterMapper).buildMap();
        MeetingDOExample example = MeetingFilter.initDOQueryFilter(mockParams);

        List<Meeting> res = Mockito.mock(List.class);
        Mockito.doReturn(res).when(meetingdao).selectByExample(example);
        Iterator iteratorMock = Mockito.mock(Iterator.class);
        Mockito.when(res.iterator()).thenReturn(iteratorMock);
        Mockito.when(iteratorMock.hasNext()).thenReturn(true, false);
        Mockito.when(iteratorMock.next()).thenReturn(entityList);
        Assert.assertEquals(entityList, meetingService.getListByFilter(meetingfilterMapper), "异常");
	}

	@Test(groups = "groupGet", dependsOnMethods = "getListByFilterTest")
	public void getFilterMapListTest()
	{
		List<Map<String, Object>> entityMapList = new ArrayList<>();
        List<Meeting> t1 = Mockito.mock(ArrayList.class);
        List<Meeting> t2 = null;
        Mockito.when(meetingService.getListByFilter(meetingfilterMapper)).thenReturn(t1);
        Mockito.doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocationOnMock) throws Throwable {
                Object argument = invocationOnMock.getArgument(0);
                Meeting.class.getDeclaredMethod("accept", Meeting.class).invoke(argument, 1);
                return argument;
            }
        }).when(t1).forEach(entity -> entityMapList.add(MeetingSimpleMapper.buildMap(entity)));
        Assert.assertEquals(entityMapList, meetingService.getFilterMapList(meetingfilterMapper), "异常");
	}

	@Test(groups = "groupPost", dependsOnMethods = "getByPKTest", expectedExceptions = StatusException.class)
	public void postTestException()
	{
		StatusException e = new StatusException("POST_ENTITY_DUPLICATE");
        meeting = new Meeting();
        Mockito.when(meetingdao.insertSelective(MeetingData.convert(meeting, new MeetingDO()))).thenThrow(e);
        Meeting res = meetingService.post(meeting);
        throw e;
	}

	@Test(groups = "groupPost", dependsOnMethods = "getByPKTest")
	public void postTest()
	{
		 Meeting test = new  Meeting();
 Meeting spyMeeting = Mockito.spy(test);
        Mockito.when(meetingdao.insertSelective(MeetingData.convert(test, new MeetingDO()))).thenReturn(1);
        Meeting res = meetingService.post(test);
	}

	@Test(groups = "groupUpadte", dependsOnMethods = "getByPKTest", expectedExceptions = NullPointerException.class)
	public void updateTest()
	{
		int actual = 1;
        Mockito.when(meetingdao.updateByPrimaryKeySelective(MeetingData.convert(meeting, new MeetingDO()))).thenReturn(1);
        Assert.assertEquals(actual, meetingdao.updateByPrimaryKeySelective(MeetingData.convert(meeting, new MeetingDO())), "不相等");

	}

	@Test(groups = "groupPut", dependsOnMethods = "getByPKTest")
	public void putTestIsNull()
	{
		Meeting putEntity=new Meeting();
        putEntity.setId("1");
        Object actual=null;
        Mockito.when(meetingService.getByPK(putEntity.getId())).thenReturn(null);
        Mockito.when(meetingdao.insertSelective(MeetingData.convert(putEntity, new MeetingDO()))).thenReturn(1);
        Assert.assertEquals(actual,meetingService.put(putEntity),"不相等");
	}

	@Test(groups = "groupDelete")
	public void deleteTest()
	{
		String testid = "1";
        AtomicInteger count = new AtomicInteger();
        Mockito.when(count.addAndGet(meetingdao.deleteByPrimaryKey(testid))).thenReturn(1);
        int actual = meetingService.delete(testid);
        Assert.assertEquals(actual, 1, "不相等");
	}

	@Test(groups = "groupGet", dependsOnMethods = "getCountByFilterTest")
	public void getRateAndCountByFilterTest()
	{
		Map<String, Map<String, Object>> res = new HashMap<>();
        List<String> groupBy = Mockito.mock(List.class);
        res = meetingService.getFilterListGroup(meetingfilterMapper, groupBy);
        Assert.assertEquals(res.size(), 0, "不相等");
	}

}