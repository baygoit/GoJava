package com.airbnb.listeners;

import com.airbnb.dao.jpa.PersistenceManager;

import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by Игорь on 19.11.2015.
 */
public class PersistenceAppListener implements ServletContextListener{
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {}

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        PersistenceManager.getInstance().closeEntityManagerFactory();
    }
}
