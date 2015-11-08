package com.gojava6.web.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by sergiigetman on 10/14/15.
 */
public class MyContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        String url = servletContextEvent.getServletContext().getInitParameter("url");
        System.out.println("connect to : "  + url );
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
