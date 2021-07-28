/*
package com.example.springboot.config;

import com.example.springboot.bean.Employee;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class MyRedisConfig {


    @Bean
    public RedisTemplate<Object, Employee> empRedisTemplate(RedisConnectionFactory factory) {
        RedisTemplate<Object, Employee> template = new RedisTemplate();
        template.setConnectionFactory(factory);
        Jackson2JsonRedisSerializer<Employee> ser = new Jackson2JsonRedisSerializer<Employee>(Employee.class);

        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        ser.setObjectMapper(om);
        //序列化设置 ，这样为了存储操作对象时正常显示的数据，也能正常存储和获取
        template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(ser);
        template.setHashKeySerializer(new StringRedisSerializer());
        template.setHashValueSerializer(ser);
        return template;
    }


    @Bean
    public StringRedisTemplate stringRedisTemplate(RedisConnectionFactory factory) {
        StringRedisTemplate stringRedisTemplate = new StringRedisTemplate();
        stringRedisTemplate.setConnectionFactory(factory);
        return stringRedisTemplate;
    }



    @Bean
    public CacheManager cacheManager(RedisConnectionFactory connectionFactory) {


    }
}
*/