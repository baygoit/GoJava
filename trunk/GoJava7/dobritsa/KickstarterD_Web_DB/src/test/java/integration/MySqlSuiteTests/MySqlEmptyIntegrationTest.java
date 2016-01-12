package integration.MySqlSuiteTests;

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
public class MySqlEmptyIntegrationTest {

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
    public void testGetRandomQuoteFromEmptyTableIsNull() {
        assertNull(quoteDao.getRandomQuote());
    }

    @Test
    public void testGetNonexistentCategoryIsNull() {
        assertNull(categoryDao.get(1L));
    }

    @Test
    public void testGetAllCategoriesFromEmptyTableIsNotNull() {
        assertThat(categoryDao.getAll().isEmpty(),is(true));
    }

    @Test
    public void testGetNonexistentProjectIsNull() {
        assertNull(projectDao.get(1L));
    }

    @Test
    public void testGetProjectsByNonexistentCategoryIsNotNull() {
        assertThat(projectDao.getByCategory(1L).size(), is(0));
    }

    @Test
    public void testGetQuestionsByNonexistentProjectIsNotNull() {
        assertThat(questionDao.getByProject(1L).size(), is(0));
    }

    @Test
    public void testGetRewardsByNonexistentProjectIsNotNull() {
        assertThat(rewardDao.getByProject(1L).size(), is(0));
    }

    @Test
    public void testGetNonexistentRewardIsNull() {
        assertNull(rewardDao.get(1L));
    }

    @Test
    public void testCalculatePledgedForNonexistentProjectIs0() {
        assertThat(paymentDao.calculatePledgedForProject(1L), is(0L));
    }
}
