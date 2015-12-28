package ua.com.goit.gojava7.kickstarter.hibernate;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	
	private static final Logger log = LogManager.getLogger(HibernateUtil.class);
	
	private static final SessionFactory sessionFactory;
	static {
		try {
			sessionFactory = new Configuration().configure().buildSessionFactory();
		} catch (Throwable ex) {
			log.error("Initial SessionFactory creation failed.",ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		log.info("getSessionFactory()...");
		return sessionFactory;
	}	
}
