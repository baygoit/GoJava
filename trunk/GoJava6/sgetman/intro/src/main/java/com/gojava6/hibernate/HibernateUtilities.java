package com.gojava6.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtilities {

    private static SessionFactory sessionFactory;
    private static ServiceRegistry serviceRegistry;
    private static HibernateUtilities hibernateUtilities  = new HibernateUtilities();



    private HibernateUtilities() {
        try {
            Configuration configuration = new Configuration().configure();
            StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().
                    applySettings(configuration.getProperties());
            sessionFactory = configuration.buildSessionFactory(builder.build());
        } catch (HibernateException exception) {
            System.out.println("Problem creating session factory!");
        }
    }

    public static SessionFactory getSessionFactory() {
        return hibernateUtilities.sessionFactory;
    }
}
