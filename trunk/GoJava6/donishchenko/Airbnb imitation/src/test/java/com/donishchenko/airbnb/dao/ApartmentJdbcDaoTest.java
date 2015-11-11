package com.donishchenko.airbnb.dao;

import com.donishchenko.airbnb.dao.old.ApartmentJdbcDao;
import com.donishchenko.airbnb.dao.old.UserJdbcDao;
import com.donishchenko.airbnb.model.Apartment;
import com.donishchenko.airbnb.model.ApartmentType;
import com.donishchenko.airbnb.model.User;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

public class ApartmentJdbcDaoTest {

    private ApartmentDao apartmentDao = new ApartmentJdbcDao();
    private static UserDao userDao = new UserJdbcDao();
    private static User user = new User("Dmitry", "Onishchenko", "sacr8tum@gmail.com", true);
    private static Apartment apartment;

    @BeforeClass
    public static void setUp() throws SQLException {
        int userId = userDao.save(user);
        user.setId(userId);

        apartment = new Apartment(0, "Kiev", ApartmentType.APARTMENT, true);
        apartment.setHostId(userId);
    }

    @AfterClass
    public static void tearDown() throws SQLException {
        userDao.delete(user.getId());
    }

    @Test
    public void testSave() throws SQLException {
        int apartmentId = apartmentDao.save(apartment);
        apartment.setId(apartmentId);

        // clear
        apartmentDao.delete(apartmentId);
    }

    @Test
    public void testDelete() throws SQLException {
        int apartmentId = apartmentDao.save(apartment);
        apartment.setId(apartmentId);

        assertTrue(apartmentDao.delete(apartmentId));
        assertFalse(apartmentDao.delete(-1));
    }

    @Test
    public void testUpdate() throws SQLException {
        int apartmentId = apartmentDao.save(apartment);
        apartment.setId(apartmentId);

        apartment.setCity("Kharkov");
        assertTrue(apartmentDao.update(apartmentId, apartment));

        // clear
        apartmentDao.delete(apartmentId);
    }

    @Test
    public void testGet() throws SQLException {
        int apartmentId = apartmentDao.save(apartment);
        apartment.setId(apartmentId);

        Apartment other = apartmentDao.get(apartmentId);

        assertEquals(apartment, other);

        apartmentDao.delete(apartmentId);
    }

    @Test
    public void testGetAll() throws SQLException {
        int apartmentId = apartmentDao.save(apartment);
        apartment.setId(apartmentId);

        List<Apartment> list = apartmentDao.getAll();
        assertNotEquals(0, list.size());

        apartmentDao.delete(apartmentId);
    }

    @Test
    public void testGetAllByCity() throws SQLException {
        int apartmentId = apartmentDao.save(apartment);
        apartment.setId(apartmentId);

        List<Apartment> list = apartmentDao.getAllByCity(apartment.getCity());
        assertNotEquals(0, list.size());

        apartmentDao.delete(apartmentId);
    }

    @Test
    public void testGetAllByUser() throws SQLException {
        int apartmentId = apartmentDao.save(apartment);
        apartment.setId(apartmentId);

        List<Apartment> list = apartmentDao.getAllByUser(user.getId());
        assertNotEquals(0, list.size());

        apartmentDao.delete(apartmentId);
    }
}