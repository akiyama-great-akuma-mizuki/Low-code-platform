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
public class Newstest {
	@Mock
	public NewsDAO newsdao;

	@Mock
	public NewsSimpleMapper newsSimpleMapper;

	@Mock
	public News news;

	@Mock
	public NewsFilterMapper newsfilterMapper;

	@InjectMocks
	public NewsService newsService;

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
        NewsDO newsdo = new NewsDO();
        newsdo.setId(testid);
        Mockito.when(newsdao.selectByPrimaryKey(testid)).thenReturn(newsdo);
        Assert.assertEquals(newsService.getByPK(testid).getId(), testid, "不相等");
	}

	@Test(groups = "getGet", dependsOnMethods = "getByPKTest")
	public void getSimpleMapByPKTest()
	{
		String testid = mockParams.get("id").toString();
        Map<String, Object> res = newsSimpleMapper.buildMap(newsService.getByPK(testid));
       Assert.assertEquals(newsService.getSimpleMapByPK(testid), res, "getSimpleMapByPK不相等");
	}

	@Test(groups = "groupGet", dependsOnMethods = "getByPKTest")
	public void getDetailMapByPKTestIsNull()
	{
		String testid = "1";
        Mockito.when(newsService.getByPK(testid)).thenReturn(null);
        Assert.assertEquals(null, newsService.getDetailMapByPK(testid), "异常");
	}

	@Test(groups = "groupGet")
	public void getCountByFilterTest()
	{
		        Long count = 0L;
        Mockito.doReturn(mockParams).when(newsfilterMapper).buildMap();
        NewsDOExample example = NewsFilter.initDOQueryFilter(mockParams);
        Mockito.doReturn(count).when(newsdao).countByExample(example);
        Assert.assertEquals(count, newsService.getCountByFilter(newsfilterMapper), "异常");

	}

	@Test(groups = "groupGet")
	public void getListByFilterTest()
	{
		List<News> entityList = new ArrayList<>();
        Mockito.doReturn(mockParams).when(newsfilterMapper).buildMap();
        NewsDOExample example = NewsFilter.initDOQueryFilter(mockParams);

        List<News> res = Mockito.mock(List.class);
        Mockito.doReturn(res).when(newsdao).selectByExample(example);
        Iterator iteratorMock = Mockito.mock(Iterator.class);
        Mockito.when(res.iterator()).thenReturn(iteratorMock);
        Mockito.when(iteratorMock.hasNext()).thenReturn(true, false);
        Mockito.when(iteratorMock.next()).thenReturn(entityList);
        Assert.assertEquals(entityList, newsService.getListByFilter(newsfilterMapper), "异常");
	}

	@Test(groups = "groupGet", dependsOnMethods = "getListByFilterTest")
	public void getFilterMapListTest()
	{
		List<Map<String, Object>> entityMapList = new ArrayList<>();
        List<News> t1 = Mockito.mock(ArrayList.class);
        List<News> t2 = null;
        Mockito.when(newsService.getListByFilter(newsfilterMapper)).thenReturn(t1);
        Mockito.doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocationOnMock) throws Throwable {
                Object argument = invocationOnMock.getArgument(0);
                News.class.getDeclaredMethod("accept", News.class).invoke(argument, 1);
                return argument;
            }
        }).when(t1).forEach(entity -> entityMapList.add(NewsSimpleMapper.buildMap(entity)));
        Assert.assertEquals(entityMapList, newsService.getFilterMapList(newsfilterMapper), "异常");
	}

	@Test(groups = "groupPost", dependsOnMethods = "getByPKTest", expectedExceptions = StatusException.class)
	public void postTestException()
	{
		StatusException e = new StatusException("POST_ENTITY_DUPLICATE");
        news = new News();
        Mockito.when(newsdao.insertSelective(NewsData.convert(news, new NewsDO()))).thenThrow(e);
        News res = newsService.post(news);
        throw e;
	}

	@Test(groups = "groupPost", dependsOnMethods = "getByPKTest")
	public void postTest()
	{
		 News test = new  News();
 News spyNews = Mockito.spy(test);
        Mockito.when(newsdao.insertSelective(NewsData.convert(test, new NewsDO()))).thenReturn(1);
        News res = newsService.post(test);
	}

	@Test(groups = "groupUpadte", dependsOnMethods = "getByPKTest", expectedExceptions = NullPointerException.class)
	public void updateTest()
	{
		int actual = 1;
        Mockito.when(newsdao.updateByPrimaryKeySelective(NewsData.convert(news, new NewsDO()))).thenReturn(1);
        Assert.assertEquals(actual, newsdao.updateByPrimaryKeySelective(NewsData.convert(news, new NewsDO())), "不相等");

	}

	@Test(groups = "groupPut", dependsOnMethods = "getByPKTest")
	public void putTestIsNull()
	{
		News putEntity=new News();
        putEntity.setId("1");
        Object actual=null;
        Mockito.when(newsService.getByPK(putEntity.getId())).thenReturn(null);
        Mockito.when(newsdao.insertSelective(NewsData.convert(putEntity, new NewsDO()))).thenReturn(1);
        Assert.assertEquals(actual,newsService.put(putEntity),"不相等");
	}

	@Test(groups = "groupDelete")
	public void deleteTest()
	{
		String testid = "1";
        AtomicInteger count = new AtomicInteger();
        Mockito.when(count.addAndGet(newsdao.deleteByPrimaryKey(testid))).thenReturn(1);
        int actual = newsService.delete(testid);
        Assert.assertEquals(actual, 1, "不相等");
	}

	@Test(groups = "groupGet", dependsOnMethods = "getCountByFilterTest")
	public void getRateAndCountByFilterTest()
	{
		Map<String, Map<String, Object>> res = new HashMap<>();
        List<String> groupBy = Mockito.mock(List.class);
        res = newsService.getFilterListGroup(newsfilterMapper, groupBy);
        Assert.assertEquals(res.size(), 0, "不相等");
	}

}