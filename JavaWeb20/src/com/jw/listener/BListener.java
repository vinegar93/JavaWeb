package com.jw.listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;

public class BListener implements ServletContextAttributeListener {

    public void attributeAdded(ServletContextAttributeEvent scae)  { 
         
    	System.out.println("add");
    }

    public void attributeRemoved(ServletContextAttributeEvent scae)  { 
         
    	System.out.println("remove");
    }

    public void attributeReplaced(ServletContextAttributeEvent scae)  { 
         
    	System.out.println("replace");
    }
}
