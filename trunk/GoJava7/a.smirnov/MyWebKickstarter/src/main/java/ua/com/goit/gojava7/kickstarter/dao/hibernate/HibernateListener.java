package ua.com.goit.gojava7.kickstarter.dao.hibernate;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class HibernateListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		HibernateUtil.getSessionFactory();
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		HibernateUtil.getSessionFactory().close();
	}

}
