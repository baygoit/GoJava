package ua.com.goit.gojava7.kickstarter.controller.servlet;

import javax.servlet.ServletContextEvent;

import ua.com.goit.gojava7.kickstarter.dao.jdbc.util.HibernateUtil;

public class ServletContextListener implements javax.servlet.ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		HibernateUtil.getSessionFactory();
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		HibernateUtil.getSessionFactory().close();
	}

}
