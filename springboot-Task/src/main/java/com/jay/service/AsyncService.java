package com.jay.service;


import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class AsyncService {

    /*  springboot啟動後每5秒執行一次*/
    //@Scheduled(fixedDelay = 5000)
    @Async
    public void  hello(){
        try{
            Thread.sleep(5000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.print("等待...");
    }
}
