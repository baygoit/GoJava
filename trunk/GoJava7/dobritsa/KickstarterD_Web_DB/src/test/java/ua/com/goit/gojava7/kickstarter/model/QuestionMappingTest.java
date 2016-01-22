package ua.com.goit.gojava7.kickstarter.model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class QuestionMappingTest {

	private SessionFactory sessionFactory;

	@Before
	public void setUp() throws Exception {
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate/hibernateTest.cfg.xml").build();
		try {
			sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
		} catch (Exception e) {
			System.err.println("Initial SessionFactory creation failed." + e);
			// e.printStackTrace();
			StandardServiceRegistryBuilder.destroy(registry);
		}
	}

	@After
	public void tearDown() throws Exception {
		if (sessionFactory != null) {
			sessionFactory.close();
		}
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testBasicUsage() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Category category1 = new Category();
		category1.setName("TestCategory 1");

		Project project1 = new Project();
		project1.setName("TestName1");
		project1.setDescription("TestDescription1");
		project1.setGoal(100L);
		project1.setDaysToGo(1L);
		project1.setHistory("TestHistory1");
		project1.setLink("TestLink1");
		project1.setCategory(category1);

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

		session.save(question1);
		session.save(question2);
		session.getTransaction().commit();
		session.close();

		session = sessionFactory.openSession();
		session.beginTransaction();
		
		System.out.println("\n-----Get Question by id = 1-----");
		Question question = session.get(Question.class, 1L);
		System.out.println("Question: " + question);
		
		System.out.println("\n-----Get Project by id = 1-----");
		Project project = session.get(Project.class, 1L);
		System.out.println("Project: " + project);
		
		System.out.println("\n-----Get Category by id = 1-----");
		Category category = session.get(Category.class, 1L);
		System.out.println("Category: " + category);		
		
		System.out.println("\n-----Get list of questions-----");
		List<Question> questions = (List<Question>) session.createQuery("from Question q").list();
		for (Question resultQuestion : questions) {
			System.out.println(resultQuestion);
		}
		session.close();
	}
}
