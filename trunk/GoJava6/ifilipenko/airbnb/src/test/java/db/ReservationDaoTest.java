package db;

import dao.db.ReservationDao;
import dbutils.HibernateUtil;
import model.Home;
import model.Reservation;
import model.User;
import model.enums.CityList;
import model.enums.GenderType;
import model.enums.HomeType;
import org.hibernate.Session;
import org.junit.Assert;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ReservationDaoTest {
    Session session;

    @Test
    public void create() throws ParseException {
        //------------arrange------------
        User user = new User("Barack", "Obama", GenderType.MALE, new SimpleDateFormat("dd/MM/yyyy").parse("01/02/2015"), "barack@gmail.com", CityList.BERLIN);
        Home home = new Home(CityList.BERLIN, HomeType.APARTMENT);
        home.setHost(user);
        Reservation reservation = new Reservation();
        reservation.setUser(user);
        reservation.setHome(home);
        reservation.setStart(new SimpleDateFormat("dd/MM/yyyy").parse("20/02/2015"));
        reservation.setEnd(new SimpleDateFormat("dd/MM/yyyy").parse("25/02/2015"));

        //------------act------------
        ReservationDao reservationDao = new ReservationDao();
        reservationDao.create(reservation);

        //------------assert------------
        session = HibernateUtil.getSessionFactory().openSession();
        Reservation expReserv = session.get(Reservation.class, 1);
        session.close();

        Assert.assertEquals(reservation.getUser().getName(), expReserv.getUser().getName());

    }



}
