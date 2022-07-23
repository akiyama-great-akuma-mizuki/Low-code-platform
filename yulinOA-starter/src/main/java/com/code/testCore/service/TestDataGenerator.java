package com.code.testCore.service;

import com.code.testCore.utils.JedisFactory;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.*;
/**
 * @ClassName TestDataService
 * @Description
 * @Date 2022/7/09 15:08
 * @Autor mjw
 * @Version 1.0
 */
@Component
public class TestDataGenerator {

    private static int groups = 7;


    /**
     * 生成测试数据
     * @param candidateComponent
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static void generateTestData(BeanDefinition candidateComponent)
            throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        //反射拿到类名和字段
        Class modelClass = null;
        modelClass = Class.forName(candidateComponent.getBeanClassName());
        String SimpleName = modelClass.getSimpleName();
        String fullyName = modelClass.getName();
        Field[] fields = modelClass.getDeclaredFields();
        Jedis jedis = JedisFactory.getJedis();
        if (jedis.exists(fullyName)){
            jedis.del(fullyName);
        }
        for(int i = 0; i < groups; i++){
            //生成对象
            Constructor constructor = modelClass.getConstructor();
            constructor.setAccessible(true);
            Object obj = constructor.newInstance();
            modelClass.newInstance();
            for(Field field : fields){
                //生成数据
                field.setAccessible(true);
                Class attrClass = field.getType();
                Object value = null;
                //System.out.println(attrClass.getSimpleName());
                if(attrClass.getSimpleName().equals("int") || attrClass.getSimpleName().equals("Integer")){
                    value = getInt();
                }
                if(attrClass.getSimpleName().equals("long") || attrClass.getSimpleName().equals("Long")){
                    value = getLong();
                }
                if(attrClass.getSimpleName().equals("double") || attrClass.isInstance("Double")){
                    value = getDouble();
                }
                if(attrClass.getSimpleName().equals("string") || attrClass.getSimpleName().equals("String")){
                    value = getString();
                }
                if(attrClass.getSimpleName().equals("Date")){
                    value = getDate();
                }
                if(attrClass.getSimpleName().equals("boolean") || attrClass.getSimpleName().equals("Boolean")){
                    value = getBoolean();
                }
                field.set(obj,value);
            }
            dumpData(fullyName,obj);

        }
        System.out.println(fullyName);
        //loadData(fullyName).forEach(System.out::println);
    }

    /**
     * 生成int
     */
    private static int getInt(){
        Random ran = new Random();
        return ran.nextInt(Integer.MAX_VALUE);
    }
    /**
     * 生成long
     */
    private static long getLong(){
        return ((long)getInt() << 31) | (long)getInt();
    }
    /**
     * 生成String
     */
    private static String getString(){
        Random ran = new Random();
        int len = 20;
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i< len; i++){
            char ch = (char) ran.nextInt(128);
            stringBuilder.append(ch);
        }
        Base64.Encoder encoder = Base64.getEncoder();
        return encoder.encodeToString(stringBuilder.toString().getBytes());
    }
    /**
     * 生成Double
     */
    public static double getDouble(){
        Random ran = new Random();
        return ran.nextDouble();
    }
    /**
     * 生成Date
     */
    public static Date getDate(){
        Date date = new Date();
        date.setTime(getLong());
        return date;
    }
    /**
     * 生成boolean
     */
    public static boolean getBoolean(){
        return (new Date().getTime() & 1L) == 0L;
    }
    /**
     *
     * 保存在缓存中
     * @param key
     * @param target
     */
    public static void dumpData(String key,Object target) {
        Jedis jedis = JedisFactory.getJedis();
        ObjectMapper objectMapper = new ObjectMapper();
        //将对象的所有字段全部列入
        objectMapper.setSerializationInclusion(JsonInclude.Include.ALWAYS);
        objectMapper.configure(JsonParser.Feature.ALLOW_MISSING_VALUES, true);
        try {
            String json = objectMapper.writeValueAsString(target);
            //System.out.println("target " + json);
            jedis.lpush(key,json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        finally {
            jedis.close();
        }
    }

    /**
     * 加载测试数据
     * @param key
     * @return
     */
    public static List<Map<String,Object>> loadData(String key){
        Jedis jedis = JedisFactory.getJedis();
        ObjectMapper objectMapper = new ObjectMapper();
        long len = jedis.llen(key);
        List<Map<String,Object>> Objs = new ArrayList<>();
        try {
            while (len -- >0){
                String json = jedis.lpop(key);
                //System.out.println("result " + json);
                Map map = objectMapper.readValue(json,Map.class);
                Objs.add(map);
            }
        }
        catch (JsonProcessingException e){
                e.printStackTrace();
        }finally {
            jedis.close();
            return Objs;
        }

    }

}
