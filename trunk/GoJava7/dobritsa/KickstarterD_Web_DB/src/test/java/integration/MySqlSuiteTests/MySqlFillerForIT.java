package integration.MySqlSuiteTests;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ua.com.goit.gojava7.kickstarter.dao.*;
import ua.com.goit.gojava7.kickstarter.models.*;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext*.xml")
public class MySqlFillerForIT {

    @Autowired
    private SessionFactory sessionFactory;

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
    @Autowired
    private QuestionDao questionDao;

    Long categoryId1;
    Long projectId1;
    Long rewardId1;

    @Test
    public void fillDb() {
        Quote quote = new Quote();
        quote.setText("Test Quote 1");

        Category category1 = new Category();
        category1.setName("Test Category 1");

        Project project1 = new Project();
        project1.setName("Test Project 1");
        project1.setCategory(category1);

        Project project2 = new Project();
        project2.setName("Test Project 2");
        project2.setCategory(category1);

        Payment payment1 = new Payment();
        payment1.setAmount(100L);
        payment1.setCard("1234123412341234");
        payment1.setUser("Vasya");
        payment1.setProject(project1);

        Payment payment2 = new Payment();
        payment2.setUser("Nike2");
        payment2.setCard("1111222233332222");
        payment2.setAmount(200L);
        payment2.setProject(project1);

        Question question1 = new Question();
        question1.setTime("TestTime1");
        question1.setQuestion("TestQuestion1");
        question1.setAnswer("TestAnswer1");
        question1.setProject(project1);

        Question question2 = new Question();
        question2.setTime("TestTime2");
        question2.setQuestion("TestQuestion2");
        question2.setAnswer("TestAnswer2");
        question2.setProject(project1);

        Reward reward1 = new Reward();
        reward1.setAmount(10L);
        reward1.setReward("TestReward1");
        reward1.setProject(project1);

        Reward reward2 = new Reward();
        reward2.setAmount(2L);
        reward2.setReward("TestReward2");
        reward2.setProject(project1);

        Category category2 = new Category();
        category2.setName("Test Category 2");

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.save(quote);
        session.save(category2);
        session.save(project2);
        session.save(question1);
        session.save(question2);
        session.save(reward1);
        session.save(reward2);
        session.save(payment1);
        session.save(payment2);

        session.getTransaction().commit();
        session.close();

        categoryId1 = category1.getCategoryId();
        projectId1 = project1.getProjectId();
        rewardId1 = reward1.getRewardId();

        assertThat(quoteDao.getRandomQuote().getText(), is("Test Quote 1"));
        assertThat(categoryDao.get(categoryId1).getName(), is("Test Category 1"));
        assertThat(categoryDao.getAll().size(), is(2));
        assertThat(projectDao.get(projectId1).getName(), is("Test Project 1"));
        assertThat(projectDao.getByCategory(categoryId1).size(), is(2));
        assertThat(paymentDao.calculatePledgedForProject(projectId1), is(300L));
        assertThat(rewardDao.get(rewardId1).getAmount(), is(10L));
        assertThat(rewardDao.getByProject(projectId1).size(), is(2));
        assertThat(questionDao.getByProject(projectId1).size(), is(2));
    }
}
