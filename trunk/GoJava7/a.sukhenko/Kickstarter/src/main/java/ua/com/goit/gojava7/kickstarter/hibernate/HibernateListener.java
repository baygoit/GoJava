package ua.com.goit.gojava7.kickstarter.hibernate;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import ua.com.goit.gojava7.kickstarter.util.HibernateUtil;

public class HibernateListener implements ServletContextListener {  
    
    public void contextInitialized(ServletContextEvent event) {  
        HibernateUtil.getSessionFactory(); // Just call the static initializer of that class      
    }  
  
    public void contextDestroyed(ServletContextEvent event) {  
        HibernateUtil.getSessionFactory().close(); // Free all resources  
    }  
} 