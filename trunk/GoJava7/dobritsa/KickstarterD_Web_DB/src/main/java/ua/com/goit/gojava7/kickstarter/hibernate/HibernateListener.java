package ua.com.goit.gojava7.kickstarter.hibernate;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class HibernateListener implements ServletContextListener {

	private static final Logger log = LoggerFactory.getLogger(HibernateListener.class);

	public void contextInitialized(ServletContextEvent event) {
		log.info("HibernateListener contextInitialized()...");
		HibernateUtil.getSessionFactory();
	}

	public void contextDestroyed(ServletContextEvent event) {
		log.info("HibernateListener destroyed()...");
		HibernateUtil.getSessionFactory().close();
	}
}
