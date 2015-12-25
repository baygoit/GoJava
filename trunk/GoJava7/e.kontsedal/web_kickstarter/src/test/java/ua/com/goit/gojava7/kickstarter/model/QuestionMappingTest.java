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
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
		try {
			sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
		} catch (Exception e) {
			e.printStackTrace();
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
		Session session = getSession();
		
		Question question1 = new Question();
		question1.setIdParentProject(1);
		question1.setQuestionText("Question 1");

		Question question2 = new Question();
		question2.setIdParentProject(2);
		question2.setQuestionText("Question 2");
		
		session.save(question1);
		session.save(question2);
		closeSession(session);
		
		session = getSession();
		List<Question> list = session.createQuery("from Question").list();
		for (Question question : list) {
			System.out.println(question);
		}
		closeSession(session);
	}

	private Session getSession() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		return session;
	}

	private void closeSession(Session session) {
		session.getTransaction().commit();
		session.close();
	}
}
