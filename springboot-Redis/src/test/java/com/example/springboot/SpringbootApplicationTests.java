package com.example.springboot;

import com.example.springboot.bean.Department;
import com.example.springboot.bean.Employee;
import com.example.springboot.mapper.DepartmentMapper;
import com.example.springboot.mapper.EmployeeMapper;
import com.example.springboot.service.EmployeeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;




@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootApplication.class)			//啟動器名稱

public class SpringbootApplicationTests{

	@Autowired
	EmployeeService employeeService;

	@Autowired
	StringRedisTemplate stringRedisTemplate;

	@Autowired
	RedisTemplate redisTemplate;


	@Test
	public void test01() {
		redisTemplate.opsForValue().append("test","ddddd");
	}


}
