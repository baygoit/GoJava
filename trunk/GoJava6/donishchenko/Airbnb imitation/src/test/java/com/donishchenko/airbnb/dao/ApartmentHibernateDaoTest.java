package com.donishchenko.airbnb.dao;

import com.donishchenko.airbnb.model.Apartment;
import com.donishchenko.airbnb.model.ApartmentType;
import com.donishchenko.airbnb.model.City;
import com.donishchenko.airbnb.model.User;
import org.junit.*;

import java.util.List;

import static org.junit.Assert.*;

public class ApartmentHibernateDaoTest {

    private static UserDao userDao = new UserHibernateDao();
    private static User user = new User("testuser", "secretpassword", "sacr8tum@gmail.com", true, "Dmitry", "Onishchenko");

    private static CityDao cityDao = new CityHibernateDao();
    private static City city = new City("TestCity");

    private static ApartmentDao dao = new ApartmentHibernateDao();
    private static Apartment apartment = new Apartment(user, city, ApartmentType.APARTMENT, true);

    @BeforeClass
    public static void setUp() {
        userDao.save(user);
        cityDao.save(city);
    }

    @AfterClass
    public static void tearDown() {
        userDao.delete(user.getId());
        cityDao.delete(city.getId());
    }

    @Before
    @After
    public void setUpApartment() {
        apartment.setId(0);
    }

    @Test
    public void testSave() {
        dao.save(apartment);
        dao.delete(apartment.getId());
    }

    @Test
    public void testGet() {
        dao.save(apartment);

        Apartment receivedApartment = dao.get(apartment.getId());
        assertNotNull("Received apartment is not null", receivedApartment);
        assertEquals("Saved apartment equals received apartment", apartment.getId(), receivedApartment.getId());

        dao.delete(apartment.getId());
    }

    @Test
    public void testUpdate() {
        dao.save(apartment);

        City oldCity = apartment.getCity();
        City newCity = new City("NewTestCity");
        cityDao.save(newCity);
        apartment.setCity(newCity);
        assertTrue("Successful update returns true", dao.update(apartment));

        Integer oldId = apartment.getId();
        apartment.setId(-1);
        assertFalse("Unsuccessful update returns false", dao.update(apartment));
        apartment.setId(oldId);

        Apartment updatedApartment = dao.get(apartment.getId());
        assertEquals("Detached apartment equals updated apartment from DB", apartment, updatedApartment);

        dao.delete(apartment.getId());
        apartment.setCity(oldCity);
        cityDao.delete(newCity.getId());
    }

    @Test
    public void testDelete() {
        dao.save(apartment);
        assertTrue("Successful delete returns true", dao.delete(apartment.getId()));
        assertFalse("Unsuccessful delete returns false", dao.delete(-1));
    }

    @Test
    public void testGetAll() {
        dao.save(apartment);

        List<Apartment> list = dao.getAll();
        assertFalse("Not empty list", list.isEmpty());

        dao.delete(apartment.getId());
    }

    @Test
    public void testGetAllByCity() {
        dao.save(apartment);

        List<Apartment> list = dao.getAllByCity(apartment.getCity().getName());
        assertFalse("Not empty list", list.isEmpty());

        dao.delete(apartment.getId());
    }

    @Test
    public void testGetAllByUser() {
        dao.save(apartment);

        List<Apartment> list = dao.getAllByUser(user.getId());
        assertFalse("Not empty list", list.isEmpty());

        dao.delete(apartment.getId());
    }
}