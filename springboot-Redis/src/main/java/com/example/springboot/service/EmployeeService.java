package com.example.springboot.service;


import com.example.springboot.bean.Department;
import com.example.springboot.bean.Employee;


import java.util.List;


public interface EmployeeService {



    public List<Employee> list();

    public Employee getEmpById(Integer id);

    public Integer deleteEmpById(Integer id);

    public Employee insertEmp(Employee employee);

    public Employee updateEmp(Employee employee);


}
