package ua.com.goit.gojava7.kickstarter.models;

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
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
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

		Question question1 = new Question();
		question1.setTime("TestTime1");
		question1.setQuestion("TestQuestion1");
		question1.setAnswer("TestAnswer1");
		question1.setProjectId(44l);

		Question question2 = new Question();
		question2.setTime("TestTime2");
		question2.setQuestion("TestQuestion2");
		question2.setAnswer("TestAnswer2");
		question2.setProjectId(44l);

		session.save(question1);
		session.save(question2);
		session.getTransaction().commit();
		session.close();

		session = sessionFactory.openSession();
		session.beginTransaction();
		System.out.println("\n-----Get by id = 1-----");
		Question question = session.get(Question.class, 1l);
		System.out.println(question);
		session.close();

		session = sessionFactory.openSession();
		session.beginTransaction();
		System.out.println("\n-----Get list of quotes-----");
		List<Question> questions = (List<Question>) session.createQuery("from Question q").list();
		for (Question resultQuestion : questions) {
			System.out.println(resultQuestion);
		}
		session.close();
	}
}
