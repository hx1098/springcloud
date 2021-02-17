package com.example.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

/**
 * @author hx
 * @createTime 2021/2/17 14:52
 * @option  redis 自定义的template
 * @description  未来干预的是数据.
 */

@Configuration
public class Mytemplate {

    @Bean
    public StringRedisTemplate ooxx(RedisConnectionFactory fc, ObjectMapper mapper){
        StringRedisTemplate tp = new StringRedisTemplate(fc);
        tp.setHashValueSerializer(new Jackson2JsonRedisSerializer<Object>(Object.class));

        return tp;
    }

}
