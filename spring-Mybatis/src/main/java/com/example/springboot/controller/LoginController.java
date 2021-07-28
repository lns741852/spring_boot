package com.example.springboot.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;
import java.util.Map;


@Controller
public class LoginController {

    @PostMapping(value="/user/login")
    public String login(@RequestParam("username")String username,
                        @RequestParam("password")String password,
                        Map<String,Object> map, HttpSession session) {              //將客戶端session ID傳入

        if(!StringUtils.isEmpty(username) && "123456".contentEquals(password)){
            session.setAttribute("loginUser", username);                    //在sessrion中存入username
            //防止重複提交，讓URL變成/main.html，才不會每次訪問都重新訪問/user/login
            return "redirect:/main.html";
        }else{
            map.put("msg","error");
            return "login";

        }


    }


}
