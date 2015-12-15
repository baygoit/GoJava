package db;

import dao.hibernate.HomeDao;
import dbutils.HibernateUtil;
import entity.Home;
import entity.User;
import entity.enums.CityList;
import entity.enums.GenderType;
import entity.enums.HomeType;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
@TestExecutionListeners( { DependencyInjectionTestExecutionListener.class })
@ContextConfiguration(locations = { "classpath:application-context.xml" })
public class HomeDaoTest {
    private SessionFactory mockedSessionFactory;
    private Session mockedSession;
    //private Transaction mockedTransaction;

    @Before
    public void setUp() {
        mockedSessionFactory = mock(SessionFactory.class);
        mockedSession = mock(Session.class);
        //mockedTransaction = mock(Transaction.class);
        when(mockedSessionFactory.openSession()).thenReturn(mockedSession);
        //when(mockedSession.beginTransaction()).thenReturn(mockedTransaction);
    }

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
        Session session = HibernateUtil.getSessionFactory().openSession();
        Home expHome = session.get(Home.class, 1);
        session.close();

        Assert.assertEquals(home.getHomeType(), expHome.getHomeType());
    }

    @Test
    public void read_Success() {
        //------------arrange------------
        User user = new User();
        user.setId(3);
        when(mockedSession.get(Home.class, 1)).thenReturn(new Home(1, user, CityList.BERLIN, HomeType.APARTMENT));
        HomeDao homeDao = new HomeDao();

        //------------act------------
        Home home = homeDao.readById(1);

        //------------assert------------
        Assert.assertEquals(home.getId(), 1);
    }
}
