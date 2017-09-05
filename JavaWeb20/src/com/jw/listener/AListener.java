package com.jw.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class AListener implements ServletContextListener {

   
    public void contextDestroyed(ServletContextEvent sce)  { 
         
    	System.out.println("我去也");
    }

    public void contextInitialized(ServletContextEvent sce)  { 
         
    	System.out.println("我来也");
    }
}
