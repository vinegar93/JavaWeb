package com.jw.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class AListener implements ServletContextListener {

   
    public void contextDestroyed(ServletContextEvent sce)  { 
         
    	System.out.println("��ȥҲ");
    }

    public void contextInitialized(ServletContextEvent sce)  { 
         
    	System.out.println("����Ҳ");
    }
}
