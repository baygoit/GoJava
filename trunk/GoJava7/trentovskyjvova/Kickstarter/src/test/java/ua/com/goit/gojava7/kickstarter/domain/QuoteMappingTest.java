package ua.com.goit.gojava7.kickstarter.domain;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

@Category(IntegrationTest.class)
public class QuoteMappingTest {
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
		//System.out.println("Get by id");
		Quote quoteAnswer = session.get(Quote.class, 1);
		//System.out.println(quoteAnswer);	
		session.close();
		
		assertThat(quoteAnswer.getText(), is(quote1.getText()));
		
		session = sessionFactory.openSession();
		//session.beginTransaction();
		List<Quote> result1 = (List<Quote>) session.createQuery("from Quote q").list();
		for (Quote aQuote : result1) {
			System.out.println(aQuote);
		}
		session.close();
	
		session = sessionFactory.openSession();
		session.beginTransaction();
		//System.out.println("Get by id");
		Quote quote = session.get(Quote.class, 1);
		//System.out.println(quote);
		quote.setText("Changed");
		session.getTransaction().commit();
		session.close();
		
		session = sessionFactory.openSession();
		//session.beginTransaction();
		//System.out.println("Get by id");
		quote = session.get(Quote.class, 1);
		//System.out.println(quote);
		//session.getTransaction().commit();
		session.close();
		
		assertThat(quote.getText(), is("Changed"));
	}

}
