package com.donishchenko.airbnb.dbutils;

import com.donishchenko.airbnb.model.Apartment;
import com.donishchenko.airbnb.model.Reservation;
import com.donishchenko.airbnb.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateDbUtils {
    private static SessionFactory sessionFactory;

    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure("hibernate.cfg.xml");
            configuration
                    .addAnnotatedClass(User.class)
                    .addAnnotatedClass(Apartment.class)
                    .addAnnotatedClass(Reservation.class);


            StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties());

            sessionFactory = configuration.buildSessionFactory(builder.build());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
