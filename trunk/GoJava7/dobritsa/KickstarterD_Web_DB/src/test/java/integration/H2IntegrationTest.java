package integration;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.*;

import ua.com.goit.gojava7.kickstarter.dao.*;
import ua.com.goit.gojava7.kickstarter.models.*;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

public class H2IntegrationTest {

    private static SessionFactory sessionFactory;
    private static Session session;

    private CategoryDao categoryDao = new CategoryDao();
    private QuoteDao quoteDao = new QuoteDao();
    private ProjectDao projectDao = new ProjectDao();
    private QuestionDao questionDao = new QuestionDao();
    private PaymentDao paymentDao = new PaymentDao();
    private RewardDao rewardDao = new RewardDao();

    @BeforeClass
    public static void setUp() throws Exception {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernateTest.cfg.xml").build();
        try {
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        } catch (Exception e) {
            System.err.println("Initial SessionFactory creation failed." + e);
            // e.printStackTrace();
            StandardServiceRegistryBuilder.destroy(registry);
        }

        session = sessionFactory.openSession();

        Quote quote1 = new Quote();
        quote1.setText("TestQuote 1");
        quote1.setAuthor("TestAuthor 1");

        Quote quote2 = new Quote();
        quote2.setText("TestQuote 2");
        quote2.setAuthor("TestAuthor 2");

        Category category1 = new Category();
        category1.setCategoryId(11L);
        category1.setName("TestCategory 1");

        Category category2 = new Category();
        category2.setCategoryId(22L);
        category2.setName("TestCategory 2");

        Project project1 = new Project();
        project1.setName("TestName1");
        project1.setDescription("TestDescription1");
        project1.setGoal(100L);
        project1.setDaysToGo(1L);
        project1.setHistory("TestHistory1");
        project1.setLink("TestLink1");
        project1.setCategory(category1);

        Project project2 = new Project();
        project2.setName("TestName2");
        project2.setDescription("TestDescription2");
        project2.setGoal(200l);
        project2.setDaysToGo(2l);
        project2.setHistory("TestHistory2");
        project2.setLink("TestLink2");
        project2.setCategory(category2);

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

        Payment payment1 = new Payment();
        payment1.setUser("Nike1");
        payment1.setCard("1111222233334444");
        payment1.setAmount(100L);
        payment1.setProject(project1);

        Payment payment2 = new Payment();
        payment2.setUser("Nike2");
        payment2.setCard("1111222233332222");
        payment2.setAmount(200L);
        payment2.setProject(project1);

        session.beginTransaction();
        session.save(quote1);
        session.save(quote2);
        session.save(category1);
        session.save(category2);
        session.save(project1);
        session.save(project2);
        session.save(question1);
        session.save(question2);
        session.save(reward1);
        session.save(reward2);
        session.save(payment1);
        session.save(payment2);

        session.getTransaction().commit();
        session.close();

    }

    @AfterClass
    public static void tearDown() throws Exception {
        if (sessionFactory != null) {
            sessionFactory.close();
        }
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
        Question question = new Question("QuestionForTestAddingQuestion", project);
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
