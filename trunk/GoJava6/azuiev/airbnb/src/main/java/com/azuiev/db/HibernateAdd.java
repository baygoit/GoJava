package com.azuiev.db;

import com.azuiev.dao.HibernateUtil;
import com.azuiev.model.City;
import com.azuiev.model.Image;
import org.hibernate.Session;

/**
 * Created by Masta on 10.11.2015.
 */
public class HibernateAdd {
    public static void main(String[] args) {

        System.out.println("Hibernate one to many (Annotation)");
        Session session = HibernateUtil.getSessionFactory().openSession();

       session.beginTransaction();
/*
        City city = new City();
        city.setName("popka");
        session.delete(city);

        Image image = new Image();
        image.setName("1234");
        image.setCity(city);

        city.getImage().add(image);



        session.save(image);
*/
        City city = session.load(City.class, new Long(5));
        session.delete(city);
        session.getTransaction().commit();

        System.out.println("Done");
    }
}
