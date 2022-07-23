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
public class OrganizeArchivetest {
	@Mock
	public OrganizeArchiveDAO organizearchivedao;

	@Mock
	public OrganizeArchiveSimpleMapper organizearchiveSimpleMapper;

	@Mock
	public OrganizeArchive organizearchive;

	@Mock
	public OrganizeArchiveFilterMapper organizearchivefilterMapper;

	@InjectMocks
	public OrganizeArchiveService organizearchiveService;

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
        OrganizeArchiveDO organizearchivedo = new OrganizeArchiveDO();
        organizearchivedo.setId(testid);
        Mockito.when(organizearchivedao.selectByPrimaryKey(testid)).thenReturn(organizearchivedo);
        Assert.assertEquals(organizearchiveService.getByPK(testid).getId(), testid, "不相等");
	}

	@Test(groups = "getGet", dependsOnMethods = "getByPKTest")
	public void getSimpleMapByPKTest()
	{
		String testid = mockParams.get("id").toString();
        Map<String, Object> res = organizearchiveSimpleMapper.buildMap(organizearchiveService.getByPK(testid));
       Assert.assertEquals(organizearchiveService.getSimpleMapByPK(testid), res, "getSimpleMapByPK不相等");
	}

	@Test(groups = "groupGet", dependsOnMethods = "getByPKTest")
	public void getDetailMapByPKTestIsNull()
	{
		String testid = "1";
        Mockito.when(organizearchiveService.getByPK(testid)).thenReturn(null);
        Assert.assertEquals(null, organizearchiveService.getDetailMapByPK(testid), "异常");
	}

	@Test(groups = "groupGet")
	public void getCountByFilterTest()
	{
		        Long count = 0L;
        Mockito.doReturn(mockParams).when(organizearchivefilterMapper).buildMap();
        OrganizeArchiveDOExample example = OrganizeArchiveFilter.initDOQueryFilter(mockParams);
        Mockito.doReturn(count).when(organizearchivedao).countByExample(example);
        Assert.assertEquals(count, organizearchiveService.getCountByFilter(organizearchivefilterMapper), "异常");

	}

	@Test(groups = "groupGet")
	public void getListByFilterTest()
	{
		List<OrganizeArchive> entityList = new ArrayList<>();
        Mockito.doReturn(mockParams).when(organizearchivefilterMapper).buildMap();
        OrganizeArchiveDOExample example = OrganizeArchiveFilter.initDOQueryFilter(mockParams);

        List<OrganizeArchive> res = Mockito.mock(List.class);
        Mockito.doReturn(res).when(organizearchivedao).selectByExample(example);
        Iterator iteratorMock = Mockito.mock(Iterator.class);
        Mockito.when(res.iterator()).thenReturn(iteratorMock);
        Mockito.when(iteratorMock.hasNext()).thenReturn(true, false);
        Mockito.when(iteratorMock.next()).thenReturn(entityList);
        Assert.assertEquals(entityList, organizearchiveService.getListByFilter(organizearchivefilterMapper), "异常");
	}

	@Test(groups = "groupGet", dependsOnMethods = "getListByFilterTest")
	public void getFilterMapListTest()
	{
		List<Map<String, Object>> entityMapList = new ArrayList<>();
        List<OrganizeArchive> t1 = Mockito.mock(ArrayList.class);
        List<OrganizeArchive> t2 = null;
        Mockito.when(organizearchiveService.getListByFilter(organizearchivefilterMapper)).thenReturn(t1);
        Mockito.doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocationOnMock) throws Throwable {
                Object argument = invocationOnMock.getArgument(0);
                OrganizeArchive.class.getDeclaredMethod("accept", OrganizeArchive.class).invoke(argument, 1);
                return argument;
            }
        }).when(t1).forEach(entity -> entityMapList.add(OrganizeArchiveSimpleMapper.buildMap(entity)));
        Assert.assertEquals(entityMapList, organizearchiveService.getFilterMapList(organizearchivefilterMapper), "异常");
	}

	@Test(groups = "groupPost", dependsOnMethods = "getByPKTest", expectedExceptions = StatusException.class)
	public void postTestException()
	{
		StatusException e = new StatusException("POST_ENTITY_DUPLICATE");
        organizearchive = new OrganizeArchive();
        Mockito.when(organizearchivedao.insertSelective(OrganizeArchiveData.convert(organizearchive, new OrganizeArchiveDO()))).thenThrow(e);
        OrganizeArchive res = organizearchiveService.post(organizearchive);
        throw e;
	}

	@Test(groups = "groupPost", dependsOnMethods = "getByPKTest")
	public void postTest()
	{
		 OrganizeArchive test = new  OrganizeArchive();
 OrganizeArchive spyOrganizeArchive = Mockito.spy(test);
        Mockito.when(organizearchivedao.insertSelective(OrganizeArchiveData.convert(test, new OrganizeArchiveDO()))).thenReturn(1);
        OrganizeArchive res = organizearchiveService.post(test);
	}

	@Test(groups = "groupUpadte", dependsOnMethods = "getByPKTest", expectedExceptions = NullPointerException.class)
	public void updateTest()
	{
		int actual = 1;
        Mockito.when(organizearchivedao.updateByPrimaryKeySelective(OrganizeArchiveData.convert(organizearchive, new OrganizeArchiveDO()))).thenReturn(1);
        Assert.assertEquals(actual, organizearchivedao.updateByPrimaryKeySelective(OrganizeArchiveData.convert(organizearchive, new OrganizeArchiveDO())), "不相等");

	}

	@Test(groups = "groupPut", dependsOnMethods = "getByPKTest")
	public void putTestIsNull()
	{
		OrganizeArchive putEntity=new OrganizeArchive();
        putEntity.setId("1");
        Object actual=null;
        Mockito.when(organizearchiveService.getByPK(putEntity.getId())).thenReturn(null);
        Mockito.when(organizearchivedao.insertSelective(OrganizeArchiveData.convert(putEntity, new OrganizeArchiveDO()))).thenReturn(1);
        Assert.assertEquals(actual,organizearchiveService.put(putEntity),"不相等");
	}

	@Test(groups = "groupDelete")
	public void deleteTest()
	{
		String testid = "1";
        AtomicInteger count = new AtomicInteger();
        Mockito.when(count.addAndGet(organizearchivedao.deleteByPrimaryKey(testid))).thenReturn(1);
        int actual = organizearchiveService.delete(testid);
        Assert.assertEquals(actual, 1, "不相等");
	}

	@Test(groups = "groupGet", dependsOnMethods = "getCountByFilterTest")
	public void getRateAndCountByFilterTest()
	{
		Map<String, Map<String, Object>> res = new HashMap<>();
        List<String> groupBy = Mockito.mock(List.class);
        res = organizearchiveService.getFilterListGroup(organizearchivefilterMapper, groupBy);
        Assert.assertEquals(res.size(), 0, "不相等");
	}

}