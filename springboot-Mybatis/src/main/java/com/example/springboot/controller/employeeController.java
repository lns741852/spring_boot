package com.example.springboot.controller;


import com.example.springboot.bean.Department;
import com.example.springboot.bean.Employee;
import com.example.springboot.service.DepartmentService;
import com.example.springboot.service.EmployeeService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.SplittableRandom;

@Controller
public class employeeController {

    @Autowired
    EmployeeService employeeService;

    @Autowired
    DepartmentService departmentService;


    @GetMapping(value = "/list")
    public String list(Model model){
        List<Employee> emps = employeeService.list();
        model.addAttribute("emps",emps);
        return "/emp/list";
    }

    @GetMapping(value = "/emp")
    public String toAddPage(Model model){

        List<Department> depts = departmentService.list();

        model.addAttribute("depts",depts);
        return "emp/add";

    }

    @PostMapping(value = "/emp")
    public String createEmp(Employee employee){
        employeeService.insertEmp(employee);
        return "redirect:/list";

    }

    @DeleteMapping(value= "/emp/{id}")
    public String deleteEmployee(@PathVariable("id") Integer id){
        employeeService.deleteEmpById(id);
        return "redirect:/list";
    }

    @GetMapping("/emp/{id}")
    public String toEditPage(@PathVariable("id") Integer id,Model model){
        Employee employee = employeeService.getEmpById(id);
        model.addAttribute("emp",employee);
        Collection<Department> departments = departmentService.list();
        model.addAttribute("depts",departments);
        return "emp/add";
    }

    //员工修改；需要提交员工id；
    @PutMapping("/emp")
    public String updateEmployee(Employee employee){
        employeeService.updateEmp(employee);
        return "redirect:/list";
    }


}
