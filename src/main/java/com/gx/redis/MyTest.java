package com.gx.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.params.SetParams;

public class MyTest {

    private String LOCK_KEY = "redis_lock";
    private static long INTERNAL_LOCK_LEASE_TIME = 3000;
    private long timeout = 1000;
    private static SetParams setParams = SetParams.setParams().nx().px(INTERNAL_LOCK_LEASE_TIME);
    private static Jedis jedis = new JedisPool("127.0.0.1", 6379).getResource();

    public static void main(String[] args) {
        String lock = jedis.set("lock", "123", setParams);
        System.out.println("lock = " + lock);
    }
}
