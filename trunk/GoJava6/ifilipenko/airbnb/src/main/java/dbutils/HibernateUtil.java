package dbutils;

import model.Home;
import model.Reservation;
import model.User;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static SessionFactory sessionFactory;
    private static HibernateUtil hibernateUtil = new HibernateUtil();

    private HibernateUtil() {
        try {
            Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
            configuration.addAnnotatedClass(User.class)
                         .addAnnotatedClass(Home.class)
                         .addAnnotatedClass(Reservation.class);
            System.out.println("Hibernate Configuration loaded");

            StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().
                    applySettings(configuration.getProperties());
            System.out.println("Hibernate serviceRegistry created");

            sessionFactory = configuration.buildSessionFactory(builder.build());


        } catch (HibernateException exception) {
            System.out.println("Problem creating session factory!");
            exception.printStackTrace();
        }

    }

    public static SessionFactory getSessionFactory() {
        return hibernateUtil.sessionFactory;
    }
}
