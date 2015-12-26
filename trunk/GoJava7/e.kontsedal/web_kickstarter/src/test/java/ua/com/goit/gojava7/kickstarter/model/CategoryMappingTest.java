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

public class CategoryMappingTest {
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
		
		Category category1 = new Category();
		category1.setCategoryName("Category 1");

		Category category2 = new Category();
		category2.setCategoryName("Category 2");
		
		session.save(category1);
		session.save(category2);
		
		closeSession(session);
		
		session = getSession();
		
		List<Category> list = session.createQuery("from Category").list();
		for (Category category : list) {
			System.out.println(category);
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
