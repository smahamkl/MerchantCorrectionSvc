package com.org.gmr.util;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class WebAppPropertiesListener
    implements ServletContextListener{
	
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        String rootPath = sce.getServletContext().getRealPath("/");
        System.setProperty("webroot", rootPath);

    }
    
    @Override
    public void contextDestroyed(ServletContextEvent arg0) {
       // code
    	System.out.println("ServletContextListener started");	
    }
 }
