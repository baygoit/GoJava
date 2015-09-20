/**
 * 
 */
package alexkholmov.organizer.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 * @author SASH
 *
 */
public class HibernateUtil {

    private static SessionFactory sessionFactory;
    
    static {
        try {
            sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }
    
    public static Session getSession() {
        return sessionFactory.openSession();
    }
}
