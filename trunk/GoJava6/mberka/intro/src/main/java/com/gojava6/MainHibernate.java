package com.gojava6;

import com.gojava6.modelHibernate.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainHibernate {
    public static void main(String[] args) {

        User user1 = new User();

        user1.setUserName("Anna");

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(user1);
        session.getTransaction().commit();
        session.close();

        /*session = sessionFactory.openSession();
        session.beginTransaction();
        session.get(User.class, 2);
        session.close();*/
        /*user1 = session.get(User.class, 1);
        System.out.println("User name is " + user1.getUserName());*/

        /*User user2 = new User();
        session = sessionFactory.openSession();
        session.beginTransaction();
        user2 = session.get(User.class, 1);
        System.out.println("User name is " + user2.getUserName());*/


    }
}
