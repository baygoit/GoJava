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

public class ProjectMappingTest {
	
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
		session.save(new Category(1, "Cat1"));
		session.save(new Category(2, "Cat2"));
		session.save(new Category(3, "Cat3"));
		closeSession(session);

		session = getSession();
		Project element1 = new Project();
		element1.setName("Proj 1");
		element1.setAuthor("Aut 1");
		element1.setCategoryId(1);

		Project element2 = new Project();
		element2.setName("Proj 2");
		element2.setCategoryId(1);
		
		Project element3 = new Project();
		element3.setName("Proj 3");
		element3.setAuthor("Aut 3");
		element3.setCategoryId(3);

		session.save(element1);
		session.save(element2);
		session.save(element3);
		closeSession(session);
		
		session = getSession();
		List<Project> list = session.createQuery("from Project").list();
		list.forEach(System.out::println);
		closeSession(session);
		
		session = getSession();
		List<Project> list2 = session.createQuery("from Project where categoryId = :categoryId")
				.setParameter("categoryId", 1).list();
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
