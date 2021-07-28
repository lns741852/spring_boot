package com.jay.controller;

import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jay.dao.DepartmentDao;
import com.jay.dao.EmployeeDao;
import com.jay.entities.Department;
import com.jay.entities.Employee;

//經由spring容器管理
@Controller
public class EmployeeController {
	
	//引入其他容器
	@Autowired
	EmployeeDao employeeDao;
	
	@Autowired
	DepartmentDao departmentDao;
	
	//查詢只要將dao資料取出傳入頁面
	@GetMapping("/emps")
	public String list(Model model){
		//用Collection是List的接口
		Collection<Employee> employees =employeeDao.getAll();		
		model.addAttribute("emps", employees);
		return "emp/list";
	}
	
	//到增加頁面
	@GetMapping("/emp")
	public String toAddPage(Model model){
		
		//下拉選單會用到
		Collection<Department> departments = departmentDao.getDepartments();
		model.addAttribute("depts", departments);
		return "emp/add";
	}
	
	
	   @PostMapping("/emp")
	    public String addEmp(Employee employee){
	        employeeDao.save(employee);
	        // redirect: 重定向 ，訪問方法時使用
	        // forward: 轉發
	        return "redirect:/emps";
	    }

	    //修改跟添加同一個頁面，但URL不同
	    @GetMapping("/emp/{id}")
	    public String toEditPage(@PathVariable("id") Integer id,Model model){
	        Employee employee = employeeDao.get(id);
	        model.addAttribute("emp",employee);
	        Collection<Department> departments = departmentDao.getDepartments();
	        model.addAttribute("depts",departments);
	        return "emp/add";
	    }

	    //员工修改；需要提交员工id；
	    @PutMapping("/emp")
	    public String updateEmployee(Employee employee){
	        System.out.println("修改的员工数据："+employee);
	        employeeDao.save(employee);
	        return "redirect:/emps";
	    }

	    //员工删除
	    @DeleteMapping("/emp/{id}")
	    public String deleteEmployee(@PathVariable("id") Integer id){
	        employeeDao.delete(id);
	        return "redirect:/emps";
	    }
	
	

}
