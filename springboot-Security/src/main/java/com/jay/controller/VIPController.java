package com.jay.controller;


import com.jay.bean.Users;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class VIPController {

    private final String PREFIX ="pages/";

    @GetMapping("/")
    public String index(){
        return "welcome";
    }

    @GetMapping("/userlogin")
    public String loginPage(){
        return PREFIX+"login";
    }

    @GetMapping("/level1/{path}")

    public String level1(@PathVariable("path")String path){
        return PREFIX+"level1/"+path;
    }
    @GetMapping("/level2/{path}")
    @PreAuthorize("hasAuthority('VIP2')")                   //hasAuthority授權
    public String level2(@PathVariable("path")String path){
        return PREFIX+"level2/"+path;
    }

    @GetMapping("/level4/{path}")
    @Secured({"ROLE_VIP4"})                   //hasRole授權
    public String level4(@PathVariable("path")String path){
        return PREFIX+"level4/"+path;
    }


}
