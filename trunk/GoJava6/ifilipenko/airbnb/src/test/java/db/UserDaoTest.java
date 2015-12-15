package db;

import dao.hibernate.UserDao;
import dbutils.HibernateUtil;
import entity.User;
import entity.enums.CityList;
import entity.enums.GenderType;
import org.hibernate.Session;
import org.junit.Assert;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class UserDaoTest {
    Session session;

    @Test
    public void create_Success() throws ParseException {
        //------------arrange------------
         User user = new User("Barack", "Obama", GenderType.MALE, new SimpleDateFormat("dd/MM/yyyy").parse("01/02/2015"), "barack@gmail.com", CityList.BERLIN);

        //------------act------------
        UserDao userDao = new UserDao();
        userDao.create(user);

        //------------assert------------
        session = HibernateUtil.getSessionFactory().openSession();
        User actUser = session.get(User.class, 1);
        session.close();

        Assert.assertEquals(user.getName(), actUser.getName());
    }


    @Test
    public void readById_Success(){
        //------------arrange------------
        User user = null;
        try {
            user = new User("Laura", "Marino", GenderType.FEMALE, new SimpleDateFormat("dd/MM/yyyy").parse("01/02/2015"), "lmarino@gmail.com", CityList.DONETSK);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        UserDao userDao = new UserDao();
        userDao.create(user);

        //------------act------------
        User actUser = userDao.readById(user.getId());

        //------------assert------------
        Assert.assertEquals(user.getName(), actUser.getName());
        Assert.assertEquals(user.getLastName(), actUser.getLastName());
        Assert.assertEquals(user.getGender(), actUser.getGender());
        Assert.assertEquals(user.getBirthDate(), actUser.getBirthDate());
        Assert.assertEquals(user.getEmail(), actUser.getEmail());
        Assert.assertEquals(user.getCityEnum(), actUser.getCityEnum());
    }

    public void readAll(){}




}
