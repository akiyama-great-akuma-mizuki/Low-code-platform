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
public class MeetingParticipanttest {
	@Mock
	public MeetingParticipantDAO meetingparticipantdao;

	@Mock
	public MeetingParticipantSimpleMapper meetingparticipantSimpleMapper;

	@Mock
	public MeetingParticipant meetingparticipant;

	@Mock
	public MeetingParticipantFilterMapper meetingparticipantfilterMapper;

	@InjectMocks
	public MeetingParticipantService meetingparticipantService;

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
        MeetingParticipantDO meetingparticipantdo = new MeetingParticipantDO();
        meetingparticipantdo.setId(testid);
        Mockito.when(meetingparticipantdao.selectByPrimaryKey(testid)).thenReturn(meetingparticipantdo);
        Assert.assertEquals(meetingparticipantService.getByPK(testid).getId(), testid, "不相等");
	}

	@Test(groups = "getGet", dependsOnMethods = "getByPKTest")
	public void getSimpleMapByPKTest()
	{
		String testid = mockParams.get("id").toString();
        Map<String, Object> res = meetingparticipantSimpleMapper.buildMap(meetingparticipantService.getByPK(testid));
       Assert.assertEquals(meetingparticipantService.getSimpleMapByPK(testid), res, "getSimpleMapByPK不相等");
	}

	@Test(groups = "groupGet", dependsOnMethods = "getByPKTest")
	public void getDetailMapByPKTestIsNull()
	{
		String testid = "1";
        Mockito.when(meetingparticipantService.getByPK(testid)).thenReturn(null);
        Assert.assertEquals(null, meetingparticipantService.getDetailMapByPK(testid), "异常");
	}

	@Test(groups = "groupGet")
	public void getCountByFilterTest()
	{
		        Long count = 0L;
        Mockito.doReturn(mockParams).when(meetingparticipantfilterMapper).buildMap();
        MeetingParticipantDOExample example = MeetingParticipantFilter.initDOQueryFilter(mockParams);
        Mockito.doReturn(count).when(meetingparticipantdao).countByExample(example);
        Assert.assertEquals(count, meetingparticipantService.getCountByFilter(meetingparticipantfilterMapper), "异常");

	}

	@Test(groups = "groupGet")
	public void getListByFilterTest()
	{
		List<MeetingParticipant> entityList = new ArrayList<>();
        Mockito.doReturn(mockParams).when(meetingparticipantfilterMapper).buildMap();
        MeetingParticipantDOExample example = MeetingParticipantFilter.initDOQueryFilter(mockParams);

        List<MeetingParticipant> res = Mockito.mock(List.class);
        Mockito.doReturn(res).when(meetingparticipantdao).selectByExample(example);
        Iterator iteratorMock = Mockito.mock(Iterator.class);
        Mockito.when(res.iterator()).thenReturn(iteratorMock);
        Mockito.when(iteratorMock.hasNext()).thenReturn(true, false);
        Mockito.when(iteratorMock.next()).thenReturn(entityList);
        Assert.assertEquals(entityList, meetingparticipantService.getListByFilter(meetingparticipantfilterMapper), "异常");
	}

	@Test(groups = "groupGet", dependsOnMethods = "getListByFilterTest")
	public void getFilterMapListTest()
	{
		List<Map<String, Object>> entityMapList = new ArrayList<>();
        List<MeetingParticipant> t1 = Mockito.mock(ArrayList.class);
        List<MeetingParticipant> t2 = null;
        Mockito.when(meetingparticipantService.getListByFilter(meetingparticipantfilterMapper)).thenReturn(t1);
        Mockito.doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocationOnMock) throws Throwable {
                Object argument = invocationOnMock.getArgument(0);
                MeetingParticipant.class.getDeclaredMethod("accept", MeetingParticipant.class).invoke(argument, 1);
                return argument;
            }
        }).when(t1).forEach(entity -> entityMapList.add(MeetingParticipantSimpleMapper.buildMap(entity)));
        Assert.assertEquals(entityMapList, meetingparticipantService.getFilterMapList(meetingparticipantfilterMapper), "异常");
	}

	@Test(groups = "groupPost", dependsOnMethods = "getByPKTest", expectedExceptions = StatusException.class)
	public void postTestException()
	{
		StatusException e = new StatusException("POST_ENTITY_DUPLICATE");
        meetingparticipant = new MeetingParticipant();
        Mockito.when(meetingparticipantdao.insertSelective(MeetingParticipantData.convert(meetingparticipant, new MeetingParticipantDO()))).thenThrow(e);
        MeetingParticipant res = meetingparticipantService.post(meetingparticipant);
        throw e;
	}

	@Test(groups = "groupPost", dependsOnMethods = "getByPKTest")
	public void postTest()
	{
		 MeetingParticipant test = new  MeetingParticipant();
 MeetingParticipant spyMeetingParticipant = Mockito.spy(test);
        Mockito.when(meetingparticipantdao.insertSelective(MeetingParticipantData.convert(test, new MeetingParticipantDO()))).thenReturn(1);
        MeetingParticipant res = meetingparticipantService.post(test);
	}

	@Test(groups = "groupUpadte", dependsOnMethods = "getByPKTest", expectedExceptions = NullPointerException.class)
	public void updateTest()
	{
		int actual = 1;
        Mockito.when(meetingparticipantdao.updateByPrimaryKeySelective(MeetingParticipantData.convert(meetingparticipant, new MeetingParticipantDO()))).thenReturn(1);
        Assert.assertEquals(actual, meetingparticipantdao.updateByPrimaryKeySelective(MeetingParticipantData.convert(meetingparticipant, new MeetingParticipantDO())), "不相等");

	}

	@Test(groups = "groupPut", dependsOnMethods = "getByPKTest")
	public void putTestIsNull()
	{
		MeetingParticipant putEntity=new MeetingParticipant();
        putEntity.setId("1");
        Object actual=null;
        Mockito.when(meetingparticipantService.getByPK(putEntity.getId())).thenReturn(null);
        Mockito.when(meetingparticipantdao.insertSelective(MeetingParticipantData.convert(putEntity, new MeetingParticipantDO()))).thenReturn(1);
        Assert.assertEquals(actual,meetingparticipantService.put(putEntity),"不相等");
	}

	@Test(groups = "groupDelete")
	public void deleteTest()
	{
		String testid = "1";
        AtomicInteger count = new AtomicInteger();
        Mockito.when(count.addAndGet(meetingparticipantdao.deleteByPrimaryKey(testid))).thenReturn(1);
        int actual = meetingparticipantService.delete(testid);
        Assert.assertEquals(actual, 1, "不相等");
	}

	@Test(groups = "groupGet", dependsOnMethods = "getCountByFilterTest")
	public void getRateAndCountByFilterTest()
	{
		Map<String, Map<String, Object>> res = new HashMap<>();
        List<String> groupBy = Mockito.mock(List.class);
        res = meetingparticipantService.getFilterListGroup(meetingparticipantfilterMapper, groupBy);
        Assert.assertEquals(res.size(), 0, "不相等");
	}

}