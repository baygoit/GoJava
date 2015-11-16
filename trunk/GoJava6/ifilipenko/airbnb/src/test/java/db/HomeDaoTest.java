package db;

import dao.db.HomeDao;
import dbutils.HibernateUtil;
import model.Home;
import model.User;
import model.enums.CityList;
import model.enums.GenderType;
import model.enums.HomeType;
import org.hibernate.Session;
import org.junit.Assert;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class HomeDaoTest {
    Session session;

    @Test
    public void create() throws ParseException {
        //------------arrange------------
        User user = new User("Barack", "Obama", GenderType.MALE, new SimpleDateFormat("dd/MM/yyyy").parse("01/02/2015"), "barack@gmail.com", CityList.BERLIN);
        Home home = new Home(CityList.BERLIN, HomeType.APARTMENT);
        home.setHost(user);

        //------------act------------
        HomeDao homeDao = new HomeDao();
        homeDao.create(home);

        //------------assert------------
        session = HibernateUtil.getSessionFactory().openSession();
        Home expHome = session.get(Home.class, 1);
        session.close();

        Assert.assertEquals(home.getHomeType(), expHome.getHomeType());

    }
}
