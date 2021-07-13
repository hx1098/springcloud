package com.example.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.org.apache.xpath.internal.functions.FuncFalse;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.hash.Jackson2HashMapper;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.stereotype.Component;

import java.util.Map;

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
    @Qualifier("ooxx")//干预存放的值
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    public void testRedis(){
        //高阶api
        /*stringRedisTemplate.opsForValue().set("hello","china");
        stringRedisTemplate.opsForValue().set("k1","hello");
        System.out.println(stringRedisTemplate.opsForValue().get("hello"));
        System.out.println(stringRedisTemplate.opsForValue().get("k1"));*/


//        低阶api
        RedisConnection connection = redisTemplate.getConnectionFactory().getConnection();
        connection.set("hell0".getBytes(),"nini".getBytes());

//        System.out.println(new String(connection.get("hell0".getBytes())));

/*
        HashOperations<String, Object, Object> hash = stringRedisTemplate.opsForHash();
        hash.put("sean", "name", "jinxihexi");
        hash.put("sean", "age", "25");
        System.out.println(hash.entries("sean"));*/


        /*
        * hgetall sean
        * redis-cli -p 6379
        * HGETALL sean
        * HINCRBY sean age 1
        */




        Person person = new Person();
        person.setAge(14);
        person.setName("zhangsan");

        Jackson2HashMapper jm = new Jackson2HashMapper(objectMapper, false);


        //使用StringredisTemplate在设置int值的时候会报类型转换的错误.
//        stringRedisTemplate.setHashValueSerializer(new Jackson2JsonRedisSerializer<Object>(Object.class));

        stringRedisTemplate.opsForHash().putAll("sean01", jm.toHash(person));

        Map sean01 = stringRedisTemplate.opsForHash().entries("sean01");
        Person person1 = objectMapper.convertValue(sean01, Person.class);
        System.out.println(person);


        //如果每次都折磨写, 有点累人啊
        //创建一个mytemplate,注入干预数据



        //发布
        stringRedisTemplate.convertAndSend("ooxx","hello");




        //接受
        //需要redis先发送,  publish channel hellowrold
        RedisConnection cc = stringRedisTemplate.getConnectionFactory().getConnection();
        cc.subscribe(new MessageListener() {
            @Override
            public void onMessage(Message message, byte[] pattern) {
                byte[] body = message.getBody();
                System.out.println(new String(body));
            }
        }, "ooxx".getBytes());

        while (true){
            stringRedisTemplate.convertAndSend("ooxx","hello from wo zi ji");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }
}
