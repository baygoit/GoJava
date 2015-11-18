package com.azuiev.model;

import com.azuiev.dao.HibernateUtil;
import org.hibernate.Session;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


/**
 * Created by Masta on 17.11.2015.
 */
public class GetUserTest {

    Session session = null;

    @Before
    public void connect() {
        session = HibernateUtil.getSessionFactory().openSession();

    }
    @Test
    public void getUser() {
        User user = session.get(User.class,1L);
        System.out.println(user);
        Apartment apartment = session.get(Apartment.class,1L);
        System.out.println(apartment);

        assertEquals("Ivanov", user.getName());
        assertEquals("Shevchenko 32/12",apartment.getAddress());
        assertEquals("Kiev",apartment.getCity().getName());
    }


}