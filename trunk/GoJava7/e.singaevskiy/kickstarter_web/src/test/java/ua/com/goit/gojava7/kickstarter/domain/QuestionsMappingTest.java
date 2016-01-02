package ua.com.goit.gojava7.kickstarter.domain;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class QuestionsMappingTest {
	
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
		
		Category category1 = new Category(1, "Cat1");
		Category category2 = new Category(2, "Cat2");
		
		Project project1 = new Project();
		project1.setName("Proj 1");
		project1.setAuthor("Aut 1");
		project1.setCategory(category1);
		
		Project project2 = new Project();
		project2.setName("Proj 2");
		project2.setAuthor("Aut 2");
		project2.setCategory(category2);
		
		session.save(category1);
		session.save(category2);
		session.save(project1);
		session.save(project2);

		Question element1 = new Question();
		element1.setQuestion("Q 1");
		element1.setAnswer("A 1");
		element1.setProject(project1);

		Question element2 = new Question();
		element2.setQuestion("Q 2");
		element2.setProject(project2);
		
		Question element3 = new Question();
		element3.setQuestion("Q 3");
		element3.setAnswer("A 3");
		element3.setProject(project1);

		session.save(element1);
		session.save(element2);
		session.save(element3);
		closeSession(session);
		
		session = getSession();
		List<Question> list = session.createQuery("from Question").list();
		list.forEach(System.out::println);
		closeSession(session);
		
		session = getSession();
		List<Question> list2 = session.createQuery("from Question where projectId = :projectId")
				.setParameter("projectId", 1).list();
		list2.forEach(System.out::println);
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
