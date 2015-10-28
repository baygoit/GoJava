package ua.com.goit.gojava.POM.persistence.hibernate;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	
	private static final SessionFactory sessionFactory = buildSessionFactory();
	private static final Logger LOG = Logger.getLogger(HibernateUtil.class);

	private static SessionFactory buildSessionFactory() {

	    try {
	    	
	    	@SuppressWarnings("deprecation")
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			return sessionFactory;
		} catch (HibernateException e) {
			LOG.error("Something went wrong with buildSessionFactory ", e);
        }
		return null;
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static void shutdown() {
		getSessionFactory().close();
	}
	
}
