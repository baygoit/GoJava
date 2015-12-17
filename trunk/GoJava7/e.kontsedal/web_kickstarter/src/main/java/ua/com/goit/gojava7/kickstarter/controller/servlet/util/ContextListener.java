package ua.com.goit.gojava7.kickstarter.controller.servlet.util;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import ua.com.goit.gojava7.kickstarter.controller.Initializator;

@WebListener
public class ContextListener implements ServletContextListener {

	public static final String INITIALIZATOR = "initializator";
	
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
			
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		Initializator initializator = new Initializator("db");
		event.getServletContext().setAttribute(INITIALIZATOR, initializator);
	}
}