package com.gojava6.modelHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Date;

public class MainHibernate {
    public static void main(String[] args) {

        User user1 = new User();
        Apartment apartment1 = new Apartment("Milan", ApartmentType.ENTIREFLAT, "Description4", new Date(), new Date());
        Apartment apartment2 = new Apartment("Berlin", ApartmentType.PRIVATEROOM, "Description5", new Date(), new Date());
        Reservation reservation = new Reservation();
        reservation.setApartment(apartment1);
        reservation.setMoveInDate(new Date());
        reservation.setMoveOutDate(new Date());

        //user1.setUserName("Peter");
        user1.setUserName("Paul");
        user1.getApartment().add(apartment1);
        user1.getApartment().add(apartment2);

        apartment1.setUser(user1);
        apartment2.setUser(user1);

        apartment1.getReservation().add(reservation);
        reservation.setApartment(apartment1);

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.persist(user1);
        session.persist(apartment1);

        session.getTransaction().commit();
        session.close();

        session = sessionFactory.openSession();
        session.beginTransaction();

        User user2 = session.get(User.class, 2);

        session.getTransaction().commit();
        session.close();

        System.out.println(user2);

    }
}
