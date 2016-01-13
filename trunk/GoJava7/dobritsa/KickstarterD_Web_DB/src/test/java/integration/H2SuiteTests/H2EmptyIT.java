package integration.H2SuiteTests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ua.com.goit.gojava7.kickstarter.dao.*;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext*.xml")
public class H2EmptyIT {

    @Autowired
    private QuoteDao quoteDao;
    @Autowired
    private CategoryDao categoryDao;
    @Autowired
    private ProjectDao projectDao;
    @Autowired
    private QuestionDao questionDao;
    @Autowired
    private PaymentDao paymentDao;
    @Autowired
    private RewardDao rewardDao;

    @Test
    public void testGetRandomQuote() {
        assertNull(quoteDao.getRandomQuote());
    }

    @Test
    public void testGetCategory() {
        assertNull(categoryDao.get(1L));
    }

    @Test
    public void testGetAllCategories() {
        assertThat(categoryDao.getAll().size(), is(0));
    }

    @Test
    public void testGetProject() {
        assertNull(projectDao.get(1L));
    }

    @Test
    public void testGetProjectsByCategory() {
        assertThat(projectDao.getByCategory(1L).size(), is(0));
    }

    @Test
    public void testGetQuestionsByProject() {
        assertThat(questionDao.getByProject(1L).size(), is(0));
    }

    @Test
    public void testGetRewardsByProject() {
        assertThat(rewardDao.getByProject(1L).size(), is(0));
    }

    @Test
    public void testGetReward() {
        assertNull(rewardDao.get(1L));
    }

    @Test
    public void testCalculatePledgedForProject() {
        assertThat(paymentDao.calculatePledgedForProject(1L), is(0L));
    }
}
