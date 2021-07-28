package com.jay.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
	
	//接收name="value"
	@PostMapping(value="/user/login")
	public String login(@RequestParam("username")String username,
						@RequestParam("password")String password,
						Map<String,Object> map, HttpSession session){		  //將客戶端session ID傳入
		
		//條件判斷
		if(!StringUtils.isEmpty(username) && "123456".equals(password)){
			session.setAttribute("loginUser", username);
			//防止重複提交，讓URL變成/main.html，才不會每次訪問都重新訪問/user/login
			return "redirect:/main.html";
		}else{
			map.put("msg", "error");
			return "login";
		}

	}
}