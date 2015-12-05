package ua.com.goit.gojava7.kickstarter.servlet;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import javax.servlet.annotation.WebServlet;

@WebServlet("/ServletContext")
public class ServletContext implements ServletContextListener {
	javax.servlet.ServletContext context;

	public void contextInitialized(ServletContextEvent contextEvent) {
		System.out.println("Context Created");
		context = contextEvent.getServletContext();
		// set variable to servlet context
		context.setAttribute("TEST", "TEST_VALUE");
	}

	public void contextDestroyed(ServletContextEvent contextEvent) {
		context = contextEvent.getServletContext();
		System.out.println("Context Destroyed");
	}
}