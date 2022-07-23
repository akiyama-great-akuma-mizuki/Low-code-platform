package com.code.testCore.utils;

/**
 * @ClassName JedisPoll
 * @Description
 * @Date 2022/7/15 15:55
 * @Autor mjw
 * @Version 1.0
 */
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisFactory {

    private static final JedisPool jedisPool;


    static {
        // 配置连接池
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        // 设置最大连接数
        poolConfig.setMaxTotal(8);
        // 最大空闲数
        poolConfig.setMaxIdle(8);
        // 最小空闲数
        poolConfig.setMinIdle(0);
        // 设置最长等待时间
        poolConfig.setMaxWaitMillis(1000);
        jedisPool = new JedisPool("127.0.0.1",6379);
    }

    public static Jedis getJedis(){
        return jedisPool.getResource();
    }
}