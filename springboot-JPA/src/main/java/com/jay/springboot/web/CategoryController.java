package com.jay.springboot.web;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jay.springboot.dao.CategoryDAO;
import com.jay.springboot.pojo.Category;
 
@Controller
public class CategoryController {
	@Autowired CategoryDAO categoryDAO;
	
    @RequestMapping("/listCategory")
    public String listCategory(Model m) throws Exception {
    	List<Category> cs=categoryDAO.findAll();
    	
    	
    	m.addAttribute("cs", cs);

        return "listCategory";
    }
    

    
    
}
