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

public class CategoryMappingTest {
	private SessionFactory sessionFactory;

	@Before
	public void setUp() throws Exception {
		// A SessionFactory is set up once for an application!
		// configures settings from hibernate.cfg.xml
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
		try {
			sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
		} catch (Exception e) {
			e.printStackTrace();
			// The registry would be destroyed by the SessionFactory, but we had
			// trouble building the SessionFactory
			// so destroy it manually.
			StandardServiceRegistryBuilder.destroy(registry);
		}
	}

	@After
	public void tearDown() throws Exception {
		if (sessionFactory != null) {
			sessionFactory.close();
		}
	}

	@Test
	public void testBasicUsage() {
		// create a couple of events...
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Category category1 = new Category();
		category1.setName("Category 1");

		Category category2 = new Category();
		category2.setName("Category 2");

		session.save(category1);
		session.save(category2);
		session.getTransaction().commit();
		session.close();

		// now lets pull events from the database and list them
		session = sessionFactory.openSession();
		session.beginTransaction();

		System.out.println("Get by id");
		Category category = session.get(Category.class, 1l);
		System.out.println(category);

		session.close();
		session = sessionFactory.openSession();
		session.beginTransaction();

		List<Category> result1 = (List<Category>) session.createQuery("from Category q").list();
		for (Category aCategory : result1) {
			System.out.println(aCategory);
		}

		session.close();
		session = sessionFactory.openSession();
		session.beginTransaction();

		System.out.println("Get by id");
		category = session.get(Category.class, 1l);
		System.out.println(category);

		category.setName("Changed");

		session.getTransaction().commit();
		session.close();
		session = sessionFactory.openSession();
		session.beginTransaction();

		System.out.println("Get by id");
		category = session.get(Category.class, 1l);
		System.out.println(category);

		session.getTransaction().commit();
		session.close();
	}
}
