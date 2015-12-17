package ua.com.goit.gojava7.kickstarter.servlet;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
//import javax.servlet.annotation.WebServlet;
@WebListener
//@WebServlet("/ServletContext")
public class ServletContext implements ServletContextListener {
	javax.servlet.ServletContext context;

	
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("ServletContextListener destroyed");
	}

        //Run this before web application is started
	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("ServletContextListener started");	
	}
	
	/*
	public void contextInitialized(ServletContextEvent contextEvent) {
		System.out.println("Context Created");
		context = contextEvent.getServletContext();
		// set variable to servlet context
		context.setAttribute("TEST", "TEST_VALUE");
	}

	public void contextDestroyed(ServletContextEvent contextEvent) {
		context = contextEvent.getServletContext();
		System.out.println("Context Destroyed");
	}*/
}