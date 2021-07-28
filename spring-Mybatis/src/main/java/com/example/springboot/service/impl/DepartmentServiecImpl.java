package com.example.springboot.service.impl;


import com.example.springboot.bean.Department;
import com.example.springboot.mapper.DepartmentMapper;
import com.example.springboot.service.DepartmentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiecImpl implements DepartmentService{

   @Autowired
    DepartmentMapper departmentMapper;

    @Override
    public Department getDeptById(Integer id) {
        return departmentMapper.getDeptById(id);
    }

    @Override
    public int deleteDeptById(Integer id) {
        return departmentMapper.deleteDeptById(id);
    }

    @Override
    public int insertDept(Department department) {
        return departmentMapper.insertDept(department);
    }

    @Override
    public int updateDept(Department department) {
        return departmentMapper.updateDept(department);
    }

    @Override
    public List<Department> list(){ return  departmentMapper.list(); }
}
