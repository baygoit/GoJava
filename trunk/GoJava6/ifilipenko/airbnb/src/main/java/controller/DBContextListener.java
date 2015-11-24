package controller;

import dbutils.HibernateUtil;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class DBContextListener implements ServletContextListener{


    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        HibernateUtil.getSessionFactory();
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        HibernateUtil.closeSessionFactory();
    }
}
