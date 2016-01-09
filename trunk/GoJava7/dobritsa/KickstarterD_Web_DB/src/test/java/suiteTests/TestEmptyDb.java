package suiteTests;

import org.hibernate.SessionFactory;
import org.junit.BeforeClass;
import org.junit.Test;
import ua.com.goit.gojava7.kickstarter.dao.*;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

public class TestEmptyDb {
    private static SessionFactory sessionFactory;

    private CategoryDao categoryDao = new CategoryDao();
    private QuoteDao quoteDao = new QuoteDao();
    private ProjectDao projectDao = new ProjectDao();
    private QuestionDao questionDao = new QuestionDao();
    private PaymentDao paymentDao = new PaymentDao();
    private RewardDao rewardDao = new RewardDao();


    @BeforeClass
    public static void setUp() throws Exception {
        sessionFactory = TestSuite.getSessionFactory();
    }

    @Test
    public void testGetRandomQuote() {
        quoteDao.setSessionFactory(sessionFactory);
        assertNull(quoteDao.getRandomQuote());
    }

    @Test
    public void testGetCategory() {
        categoryDao.setSessionFactory(sessionFactory);
        assertNull(categoryDao.get(1L));
    }

    @Test
    public void testGetAllCategories() {
        categoryDao.setSessionFactory(sessionFactory);
        assertNull(categoryDao.getAll());
    }

    @Test
    public void testGetProject() {
        projectDao.setSessionFactory(sessionFactory);
        assertNull(projectDao.get(1L));
    }

    @Test
    public void testGetProjectsByCategory() {
        projectDao.setSessionFactory(sessionFactory);
        assertNull(projectDao.getByCategory(1L));
    }

    @Test
    public void testGetQuestionsByProject() {
        questionDao.setSessionFactory(sessionFactory);
        assertNull(questionDao.getByProject(1L));
    }

    @Test
    public void testGetRewardsByProject() {
        rewardDao.setSessionFactory(sessionFactory);
        assertNull(rewardDao.getByProject(1L));
    }

    @Test
    public void testGetReward() {
        rewardDao.setSessionFactory(sessionFactory);
        assertNull(rewardDao.get(1L));
    }

    @Test
    public void testCalculatePledgedForProject() {
        paymentDao.setSessionFactory(sessionFactory);
        assertThat(paymentDao.calculatePledgedForProject(1L), is(0L));
    }
}
