package com.anmertrix.domain;

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
		// A SessionFactory is set up once for an application!
		// configures settings from hibernate.cfg.xml
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
				.configure().build();
		try {
			sessionFactory = new MetadataSources(registry).buildMetadata()
					.buildSessionFactory();
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
	public void testGetRandomQuote() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Quote quote1 = new Quote();
		quote1.setText("Quote 1");
		quote1.setAuthor("Author 1");

		Quote quote2 = new Quote();
		quote2.setText("Quote 2");
		quote2.setAuthor("Author 2");

		session.save(quote1);
		session.save(quote2);
		session.getTransaction().commit();
		session.close();

		// now lets pull events from the database and list them
		session = sessionFactory.openSession();
		session.beginTransaction();

		System.out.println("Get by id");
		Quote quote = session.get(Quote.class, 1l);
		System.out.println(quote.getText());

		session.close();
		session = sessionFactory.openSession();
		session.beginTransaction();

		@SuppressWarnings("unchecked")
		List<Quote> result1 = (List<Quote>) session.createQuery("from Quote q").list();
		for (Quote aQuote : result1) {
			System.out.println(aQuote.getText());
		}

		session.close();
		session = sessionFactory.openSession();
		session.beginTransaction();

		System.out.println("Get by id");
		quote = session.get(Quote.class, 1l);
		System.out.println(quote.getText());

		quote.setText("Changed");

		session.getTransaction().commit();
		session.close();
		session = sessionFactory.openSession();
		session.beginTransaction();

		System.out.println("Get by id");
		quote = session.get(Quote.class, 1l);
		System.out.println(quote.getText());

		session.getTransaction().commit();
		session.close();

	}
}
