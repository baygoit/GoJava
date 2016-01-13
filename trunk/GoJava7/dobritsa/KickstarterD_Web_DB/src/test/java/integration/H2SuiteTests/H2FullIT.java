package integration.H2SuiteTests;

import org.hibernate.SessionFactory;
import org.junit.BeforeClass;
import org.junit.Test;
import ua.com.goit.gojava7.kickstarter.dao.*;
import ua.com.goit.gojava7.kickstarter.models.*;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

public class H2FullIT {

    private static SessionFactory sessionFactory;

    private CategoryDao categoryDao = new CategoryDao();
    private QuoteDao quoteDao = new QuoteDao();
    private ProjectDao projectDao = new ProjectDao();
    private QuestionDao questionDao = new QuestionDao();
    private PaymentDao paymentDao = new PaymentDao();
    private RewardDao rewardDao = new RewardDao();

    @BeforeClass
    public static void setUp() throws Exception {
        sessionFactory = H2SuiteIT.getSessionFactory();
        sessionFactory.openSession();
    }

    @Test
    public void testGetRandomQuote() {
        quoteDao.setSessionFactory(sessionFactory);
        Quote quote = quoteDao.getRandomQuote();
        assertNotNull(quote);
    }

    @Test
    public void testGetCategory() {
        categoryDao.setSessionFactory(sessionFactory);
        Category category = categoryDao.get(1L);
        assertNotNull(category);
        assertThat(category.getName(), is("TestCategory 1"));
    }

    @Test
    public void testGetAllCategories() {
        categoryDao.setSessionFactory(sessionFactory);
        List<Category> categories = categoryDao.getAll();
        assertNotNull(categories);
        assertThat(categories.size(), is(2));
    }

    @Test
    public void testGetProject() {
        projectDao.setSessionFactory(sessionFactory);
        Project project = projectDao.get(1L);
        assertNotNull(project);
        assertThat(project.getName(), is("TestName1"));
    }

    @Test
    public void testGetProjectsByCategory() {
        projectDao.setSessionFactory(sessionFactory);
        List<Project> projects = projectDao.getByCategory(1L);
        assertNotNull(projects);
        assertThat(projects.size(), is(1));
    }

    @Test
    public void testGetQuestionsByProject() {
        questionDao.setSessionFactory(sessionFactory);
        List<Question> questions = questionDao.getByProject(1L);
        assertNotNull(questions);
        assertThat(questions.size(), is(2));
    }

    @Test
    public void testAddQuestion() {
        questionDao.setSessionFactory(sessionFactory);

        List<Question> questions = questionDao.getByProject(1L);
        assertThat(questions.size(), is(2));

        projectDao.setSessionFactory(sessionFactory);
        Project project = projectDao.get(1L);
        Question question = new Question();
        question.setQuestion("QuestionForTestAddingQuestion");
        question.setProject(project);
        questionDao.add(question);
        List<Question> questionsNew = questionDao.getByProject(1L);
        assertThat(questionsNew.size(), is(3));
    }

    @Test
    public void testGetReward() {
        rewardDao.setSessionFactory(sessionFactory);
        Reward reward = rewardDao.get(1L);
        assertNotNull(reward);
        assertThat(reward.getReward(), is("TestReward1"));
    }

    @Test
    public void testGetRewardsByProject() {
        rewardDao.setSessionFactory(sessionFactory);
        List<Reward> rewards = rewardDao.getByProject(1L);
        assertNotNull(rewards);
        assertThat(rewards.size(), is(2));
    }

    @Test
    public void testCalculatePledgedForProject() {
        paymentDao.setSessionFactory(sessionFactory);
        assertThat(paymentDao.calculatePledgedForProject(1L), is(300L));
    }

    @Test
    public void testAddPayment() {
        paymentDao.setSessionFactory(sessionFactory);

        assertThat(paymentDao.calculatePledgedForProject(1L), is(300L));

        projectDao.setSessionFactory(sessionFactory);
        Project project = projectDao.get(1L);
        Payment payment = new Payment("TestUser", "1234123412341234", 1111L, project);
        paymentDao.add(payment);
        assertThat(paymentDao.calculatePledgedForProject(1L), is(1411L));
    }
}
