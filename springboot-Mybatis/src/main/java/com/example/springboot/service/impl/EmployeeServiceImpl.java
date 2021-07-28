package com.example.springboot.service.impl;

import com.example.springboot.bean.Department;
import com.example.springboot.bean.Employee;
import com.example.springboot.mapper.DepartmentMapper;
import com.example.springboot.mapper.EmployeeMapper;
import com.example.springboot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.*;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.crypto.KeyGenerator;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    EmployeeMapper employeeMapper;


    @Override
    public List<Employee> list() { return employeeMapper.list(); }

    @Override
    public Employee getEmpById(Integer id) {
        System.out.print(id);
        return employeeMapper.getEmpById(id);
    }

    @Override
    public Integer deleteEmpById(Integer id) {
        return employeeMapper.deleteEmpById(id);
    }

    @Override
    public Employee insertEmp(Employee employee) {
        employeeMapper.insertEmp(employee);
        return employee;
    }


    @Override
    public Employee updateEmp(Employee employee) {
        employeeMapper.updateEmp(employee);
        return employee;
    }
}
