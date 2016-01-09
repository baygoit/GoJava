package suiteTests;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.BeforeClass;
import org.junit.Test;
import ua.com.goit.gojava7.kickstarter.models.*;

import static org.junit.Assert.assertTrue;

public class FillerDbForTests {

    private static SessionFactory sessionFactory;

    @BeforeClass
    public static void setUp() throws Exception {
        sessionFactory = TestSuite.getSessionFactory();
    }

    @Test
    public void fillDb() {
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
        project2.setGoal(200L);
        project2.setDaysToGo(2L);
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

        Session session = sessionFactory.openSession();

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
}
