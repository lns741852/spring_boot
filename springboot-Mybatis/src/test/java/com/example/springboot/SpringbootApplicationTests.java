package com.example.springboot;

import com.example.springboot.bean.Department;
import com.example.springboot.bean.Employee;
import com.example.springboot.service.EmployeeService;
import io.searchbox.client.JestClient;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootApplication.class)			//啟動器名稱
public class SpringbootApplicationTests{




}

