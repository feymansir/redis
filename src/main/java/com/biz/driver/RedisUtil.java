
package com.biz.driver;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisUtil {
	//服务器IP地址
    private static String ADDR = "112.74.41.61";

    //端口
    private static int PORT = 6379;
    
    //jedis密码配置
    private static String PASSWORD = "yt123";

    //连接实例的最大连接数
    private static int MAX_ACTIVE = 1024;

    //控制�?个pool�?多有多少个状态为idle(空闲�?)的jedis实例，默认�?�也�?8�?
    private static int MAX_IDLE = 200;

    //等待可用连接的最大时间，单位毫秒，默认�?�为-1，表示永不超时�?�如果超过等待时间，则直接抛出JedisConnectionException
    private static int MAX_WAIT = 10000;

    //连接超时的时间�??�?
    private static int TIMEOUT = 10000;

    // 在borrow�?个jedis实例时，是否提前进行validate操作；如果为true，则得到的jedis实例均是可用的；
    private static boolean TEST_ON_BORROW = true;

    private static JedisPool jedisPool = null;

    /**
     * 初始化Redis连接�?
     */

    static {

        try {

            JedisPoolConfig config = new JedisPoolConfig();
            config.setMaxTotal(MAX_ACTIVE);
            config.setMaxWaitMillis(MAX_WAIT);
            //config.setTestOnBorrow(TEST_ON_BORROW);
            jedisPool = new JedisPool(config, ADDR, PORT, TIMEOUT,PASSWORD);

        } catch (Exception e) {

            e.printStackTrace();
        }

    }

    /**
     * 获取Jedis实例
     */

    public synchronized static Jedis getJedis() {

        try {

            if (jedisPool != null) {
                Jedis resource = jedisPool.getResource();
                return resource;
            } else {
                return null;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    /***
     * 
     * 释放资源
     */
    
    public static void returnResource(final Jedis jedis) {
            if(jedis != null) {
                jedisPool.returnResource(jedis);
            }
        
    }


}
