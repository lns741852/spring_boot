package com.jay.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Date;


@Service
public class ScheduleService {

    /*springboot啟動後立刻執行*/
    @Scheduled(cron = "0/5 * * * * MON-SAT")
    public void date(){
        System.out.print(new Date());
    }
}
