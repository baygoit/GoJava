package ua.com.goit.gojava7.kickstarter.servlet;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebListener

public class ServletContext implements ServletContextListener {
	
	javax.servlet.ServletContext context;
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