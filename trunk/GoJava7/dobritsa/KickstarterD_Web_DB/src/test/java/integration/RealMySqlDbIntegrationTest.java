package integration;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ua.com.goit.gojava7.kickstarter.dao.*;
import ua.com.goit.gojava7.kickstarter.models.*;

import java.util.List;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext*.xml")
public class RealMySqlDbIntegrationTest {

    @Autowired
    private QuoteDao quoteDao;
    @Autowired
    private CategoryDao categoryDao;
    @Autowired
    private ProjectDao projectDao;
    @Autowired
    private PaymentDao paymentDao;
    @Autowired
    private RewardDao rewardDao;

    @Test
    public void testGetRandomQuote() {
        Quote quote = quoteDao.getRandomQuote();
        assertNotNull(quote);
    }

    @Test
    public void testGetCategory() {
        Category category = categoryDao.get(1L);
        assertNotNull(category);
    }

    @Test
    public void testGetAllCategory() {
        List<Category> categories = categoryDao.getAll();
        assertNotNull(categories);
    }

    @Test
    public void testGetProject() {
        Project project = projectDao.get(1L);
        assertNotNull(project);
    }

    @Test
    public void testGetProjectByCategory() {
        List<Project> projects = projectDao.getByCategory(1L);
        assertNotNull(projects);
    }

    @Test
    public void testCalculatePledgedForProject() {
        Long sumAmount = paymentDao.calculatePledgedForProject(1L);
        assertNotNull(sumAmount);
    }

    @Test
    public void testGetReward() {
        Reward reward = rewardDao.get(1L);
        assertNotNull(reward);
    }

    @Test
    public void testGetRewardByProject() {
        List<Reward> rewards = rewardDao.getByProject(1L);
        assertNotNull(rewards);
    }
}
