package com.jay.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyListener implements ServletContextListener {
	
	//Servlet啟動時
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("啟動網頁...");
    }

  //Servlet關閉時
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("關閉網頁...");
    }
}
