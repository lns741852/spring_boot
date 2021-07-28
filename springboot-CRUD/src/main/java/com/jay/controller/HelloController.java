package com.jay.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jay.exception.UserNotExistException;

@Controller
public class HelloController {
	
	//返回字串到hello頁面，不須配置html
    @ResponseBody
    //訪問127.0.0.1:8080/hello?user=aaa，會拋出異常，其他值會返回Hello!!
    @RequestMapping("/hello")
    public String hello(@RequestParam("user")String user) {
    	if(user.equals("aaa")){
    		throw new UserNotExistException();
    	}
       return "Hello!!";
    }
       
}
