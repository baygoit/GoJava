package com.gojava6.airbnb.user;

import com.gojava6.airbnb.apartment.ApartType;
import com.gojava6.airbnb.apartment.Apartment;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by shata on 04.10.2015.
 */
public class UserTest {
    User user;

    @Before
    public void setUp() throws Exception {
        user = new User("Denis", "Shatalin", "shatalinden@gmail.com", UserType.CLIENT);
    }

    @Test
    public void testBecomeHost() throws Exception {
        user.becomeHost();
        assertEquals(UserType.HOST, user.getUserType());
    }

    @Test
    public void testGetUserType() throws Exception {
        assertEquals(UserType.CLIENT, user.getUserType());
    }

    @Test
    public void testGetName() throws Exception {
        assertEquals("Denis", user.getName());
    }

    @Test
    public void testGetSurname() throws Exception {
        assertEquals("Shatalin", user.getSurname());
    }

    @Test
    public void testGetEmail() throws Exception {
        assertEquals("shatalinden@gmail.com", user.getEmail());
    }

    @Test
    public void testAddApartments() throws Exception {
        user.becomeHost();
        Apartment apartment = new Apartment(ApartType.ROOM, "Kiev");
        assertEquals("Kiev", user.addApartments(apartment));
    }

    @Test
    public void testGetApartmentByID() throws Exception {
        user.becomeHost();
        Apartment apartment = new Apartment(ApartType.ROOM, "Kiev");
        user.addApartments(apartment);
        assertEquals(apartment, user.getApartmentByID(1));
    }

    @Test
    public void testGetApartments() throws Exception {
        user.becomeHost();
        user.addApartments(new Apartment(ApartType.ROOM, "Kiev"));
        List<Apartment> apartments = new ArrayList<>();
        apartments.add(new Apartment(ApartType.ROOM, "Kiev"));
        assertEquals(apartments, user.getApartments());

    }
}