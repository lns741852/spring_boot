package com.example.springboot.service;


import com.example.springboot.bean.Department;

import java.util.List;


public interface DepartmentService {

    public Department getDeptById(Integer id);

    public int deleteDeptById(Integer id);

    public int insertDept(Department department);

    public int updateDept(Department department);

    public List<Department> list();
}
