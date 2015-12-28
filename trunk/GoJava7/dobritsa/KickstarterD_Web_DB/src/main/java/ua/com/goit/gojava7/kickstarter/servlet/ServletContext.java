package ua.com.goit.gojava7.kickstarter.servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener

public class ServletContext implements ServletContextListener {

    private static final Logger log = LoggerFactory.getLogger(ServletContext.class);

    @Override
    public void contextDestroyed(ServletContextEvent arg0) {
        log.info("ServletContextListener destroyed");
    }

    @Override
    public void contextInitialized(ServletContextEvent arg0) {
        log.info("ServletContextListener started");
    }
}