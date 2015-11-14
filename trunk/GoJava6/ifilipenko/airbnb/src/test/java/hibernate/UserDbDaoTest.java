package hibernate;

import dao.hibernate.HibernateUtil;
import dao.hibernate.HibernateUtilities;
import dao.hibernate.UserDbDao;
import model.User;
import model.enums.CityList;
import model.enums.GenderType;
import org.hibernate.Session;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class UserDbDaoTest {
    Session session;

    @Before
    public void init(){
        session = HibernateUtil.getSessionFactory().openSession();
    }

    @Test
    public void create() throws ParseException {
        //------------arrange------------
         User user = new User("Barack", "Obama", GenderType.MALE, new SimpleDateFormat("dd/MM/yyyy").parse("01/02/2015"), "barack@gmail.com", CityList.BERLIN);

        //------------act------------
        UserDbDao userDao = new UserDbDao();
        userDao.create(user);

        //------------assert------------
        session = HibernateUtilities.getSessionFactory().openSession();
        User extUser = session.load(User.class, 8);
        Assert.assertEquals(user.getEmail(), extUser.getEmail());
    }


    public void read(){}

    public void readAll(){}




}
