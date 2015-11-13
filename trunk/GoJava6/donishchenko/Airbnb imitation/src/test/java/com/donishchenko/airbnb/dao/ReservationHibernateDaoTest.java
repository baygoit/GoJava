package com.donishchenko.airbnb.dao;

import com.donishchenko.airbnb.model.Apartment;
import com.donishchenko.airbnb.model.ApartmentType;
import com.donishchenko.airbnb.model.Reservation;
import com.donishchenko.airbnb.model.User;
import org.junit.*;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import static org.junit.Assert.*;

public class ReservationHibernateDaoTest {
    private static UserDao userDao = new UserHibernateDao();
    private static User host = new User("TestHost", "secretpassword", "sacr8tum@gmail.com", true, "Dmitry", "Onishchenko");
    private static User user = new User("TestUser", "secretpassword", "sacr8tum@gmail.com", false, "Dmitry", "Onishchenko");

    private static ApartmentDao apartmentDao = new ApartmentHibernateDao();
    private static Apartment apartment = new Apartment(host, "TestCity", ApartmentType.APARTMENT, true);

    private static ReservationDao dao = new ReservationHibernateDao();
    private static Reservation reservation;

    @BeforeClass
    public static void setUp() {
        userDao.save(host);
        userDao.save(user);
        apartmentDao.save(apartment);

        Date start = new GregorianCalendar(2015, 11, 1).getTime();
        Date end = new GregorianCalendar(2015, 11, 3).getTime();
        reservation = new Reservation(user, apartment, start, end, "Test comment");
    }

    @AfterClass
    public static void tearDown() {
        userDao.delete(host.getId());
        userDao.delete(user.getId());
    }

    @Before
    @After
    public void setUpApartment() {
        reservation.setId(0);
    }

    @Test
    public void testSave() {
        dao.save(reservation);
        dao.delete(reservation.getId());
    }

    @Test
    public void testGet() {
        dao.save(reservation);

        Reservation receivedReservation = dao.get(reservation.getId());
        assertNotNull("Received reservation is not null", receivedReservation);
        assertEquals("Saved reservation equals received reservation", reservation.getId(), receivedReservation.getId());

        dao.delete(reservation.getId());
    }

    @Test
    public void testUpdate() {
        dao.save(reservation);

        String oldComment = reservation.getComment();
        reservation.setComment("New test comment");
        assertTrue("Successful update returns true", dao.update(reservation));

        Integer oldId = reservation.getId();
        reservation.setId(-1);
        assertFalse("Unsuccessful update returns false", dao.update(reservation));
        reservation.setId(oldId);

        Reservation updatedReservation = dao.get(reservation.getId());
        assertEquals("Detached reservation equals updated reservation from DB", reservation, updatedReservation);

        dao.delete(reservation.getId());
        reservation.setComment(oldComment);
    }

    @Test
    public void testDelete() {
        dao.save(reservation);
        assertTrue("Successful delete returns true", dao.delete(reservation.getId()));
        assertFalse("Unsuccessful delete returns false", dao.delete(-1));
    }

    @Test
    public void testGetAll() {
        dao.save(reservation);

        List<Reservation> list = dao.getAll();
        assertFalse("Not empty list", list.isEmpty());

        dao.delete(reservation.getId());
    }

    @Test
    public void testGetAllByApartment() {
        dao.save(reservation);

        List<Reservation> list = dao.getAllByApartment(reservation.getApartment().getId());
        assertFalse("Not empty list", list.isEmpty());

        dao.delete(reservation.getId());
    }

    @Test
    public void testGetAllByUser() {
        dao.save(reservation);

        List<Reservation> list = dao.getAllByUser(user.getId());
        assertFalse("Not empty list", list.isEmpty());

        dao.delete(reservation.getId());
    }

    @Test
    public void testGetAllBetweenDates() {
        dao.save(reservation);

        Date start = new GregorianCalendar(2015, 10, 31).getTime();
        Date end = new GregorianCalendar(2015, 11, 5).getTime();

        List<Reservation> list = dao.getAllBetweenDates(start, end);
        assertFalse("Not empty list", list.isEmpty());

        dao.delete(reservation.getId());
    }
}