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

public class QuoteMappingTest {

	private SessionFactory sessionFactory;

	@Before
	public void setUp() throws Exception {
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernateTest.cfg.xml")
				.build();
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

		Quote quote1 = new Quote();
		quote1.setText("TestQuote 1");
		quote1.setAuthor("TestAuthor 1");

		Quote quote2 = new Quote();
		quote2.setText("TestQuote 2");
		quote2.setAuthor("TestAuthor 2");

		session.save(quote1);
		session.save(quote2);
		session.getTransaction().commit();
		session.close();

		session = sessionFactory.openSession();
		session.beginTransaction();
		System.out.println("\n-----Get by id = 1-----");
		Quote quote = session.get(Quote.class, 1l);
		System.out.println(quote);
		session.close();

		session = sessionFactory.openSession();
		session.beginTransaction();
		System.out.println("\n-----Get list of quotes-----");
		List<Quote> quotes = (List<Quote>) session.createQuery("from Quote q").list();
		for (Quote resultQuote : quotes) {
			System.out.println(resultQuote);
		}
		session.close();

		session = sessionFactory.openSession();
		session.beginTransaction();
		System.out.println("\n-----Get by id = 1, than Set text = Changed-----");
		quote = session.get(Quote.class, 1l);
		System.out.println(quote);
		quote.setText("Changed");
		session.getTransaction().commit();
		session.close();

		session = sessionFactory.openSession();
		session.beginTransaction();
		System.out.println("\n-----Get by id = 1-----");
		quote = session.get(Quote.class, 1l);
		System.out.println(quote);
		session.getTransaction().commit();
		session.close();
	}
}
