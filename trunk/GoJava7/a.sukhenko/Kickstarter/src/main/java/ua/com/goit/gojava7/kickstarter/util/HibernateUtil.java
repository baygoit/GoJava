package ua.com.goit.gojava7.kickstarter.util;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static final Logger log = LogManager.getLogger(HibernateUtil.class);
    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            // Create the SessionFactory from hibernate.cfg.xml
            return new Configuration()
                .configure()
                    .buildSessionFactory();
        } catch (Throwable ex) {
           log.error("Initial SessionFactory creation failed.",ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    
    public static <T> List<T> listAndCast(Query query) {
        @SuppressWarnings("unchecked")
        List<T> list = query.list();
        return list;
    }
}
