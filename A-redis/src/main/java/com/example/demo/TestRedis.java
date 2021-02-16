package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

/**
 * @author hx
 * @createTime 2021/2/16 16:45
 * @option
 * @description
 */
@Component
public class TestRedis {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    public void testRedis(){
        //高阶api
        /*stringRedisTemplate.opsForValue().set("hello","china");
        stringRedisTemplate.opsForValue().set("k1","hello");
        System.out.println(stringRedisTemplate.opsForValue().get("hello"));
        System.out.println(stringRedisTemplate.opsForValue().get("k1"));*/


//        低阶api
        RedisConnection connection = redisTemplate.getConnectionFactory().getConnection();
        connection.set("hell0".getBytes(),"nini".getBytes());

        System.out.println(new String(connection.get("hell0".getBytes())));

    }
}
