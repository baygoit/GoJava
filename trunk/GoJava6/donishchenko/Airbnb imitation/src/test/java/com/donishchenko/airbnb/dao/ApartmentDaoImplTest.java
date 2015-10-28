package com.donishchenko.airbnb.dao;

import com.donishchenko.airbnb.model.Apartment;
import com.donishchenko.airbnb.model.ApartmentType;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ApartmentDaoImplTest {

    private ApartmentDaoImpl apartmentDao = new ApartmentDaoImpl();

    @Test
    public void testSave() throws SQLException {
        Apartment apartment = new Apartment(6, "Kiev", ApartmentType.APARTMENT, true);
        apartmentDao.save(apartment);

        // clear
        apartmentDao.delete(apartment.getId());
    }

    @Test
    public void testDelete() throws SQLException {
        Apartment apartment = new Apartment(6, "Kiev", ApartmentType.APARTMENT, true);
        apartmentDao.save(apartment);

        assertTrue(apartmentDao.delete(apartment.getId()));
        assertFalse(apartmentDao.delete(-1));
    }

    @Test
    public void testUpdate() throws SQLException {
        Apartment apartment = new Apartment(6, "Kiev", ApartmentType.APARTMENT, true);
        apartmentDao.save(apartment);
    }

    @Test
    public void testGet() {

    }

    @Test
    public void testGetAll() throws SQLException {
        System.out.println("Get All");
        for (Apartment ap : apartmentDao.getAll() ) {
            System.out.println(ap);
        }
    }

    @Test
    public void testGetAllByCity() throws SQLException {
        System.out.println("Get all bu city");
        for (Apartment ap : apartmentDao.getAllByCity("Kharkov") ) {
            System.out.println(ap);
        }
    }

    @Test
    public void testGetAllByUser() throws SQLException {
        System.out.println("Get all by user");
        for (Apartment ap : apartmentDao.getAllByUser(5) ) {
            System.out.println(ap);
        }
    }
}