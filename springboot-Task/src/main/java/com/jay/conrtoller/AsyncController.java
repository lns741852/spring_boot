package com.jay.conrtoller;


import com.jay.service.AsyncService;
import com.jay.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AsyncController {
    @Autowired
    AsyncService asyncService;

    @Autowired
    ScheduleService scheduleService;

    @GetMapping("/hello")
    public String hello(){
        asyncService.hello();
        return "sucess";
    }
}
