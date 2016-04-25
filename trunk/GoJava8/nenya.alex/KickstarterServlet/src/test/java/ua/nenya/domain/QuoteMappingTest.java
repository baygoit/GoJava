package ua.nenya.domain;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={ "classpath:aplicationContextTest.xml"})
public class QuoteMappingTest {

	private EmbeddedDatabase db;
	@Autowired
	private SessionFactory sessionFactory;
	
	@Before
	public void setUp() throws Exception {
//		db = new EmbeddedDatabaseBuilder()
//	    		.setType(EmbeddedDatabaseType.H2)
//	    		.addScript("/createQuote.sql")
//	    		.build();
		
	}

	@After
	public void tearDown() throws Exception {
//		db = new EmbeddedDatabaseBuilder()
//	    		.setType(EmbeddedDatabaseType.H2)
//	    		.addScript("/deleteQuote.sql")
//	    		.build();
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
		quote1.setName("Quote1");
		Quote quote2 = new Quote();
		quote2.setName("Quote2");

		session.save(quote1);
		session.save(quote2);
		session.getTransaction().commit();
		session.close();

		// now lets pull events from the database and list them
		session = sessionFactory.openSession();
		session.beginTransaction();
		
		List<Quote> quotes = session.createQuery("FROM Quote").list();
		assertThat(quotes.get(0).getName(), is("Quote1"));
		assertThat(quotes.get(1).getName(), is("Quote2"));
		
		Quote quote = session.get(Quote.class, 1);
		assertThat(quote.getName(), is("Quote1"));

		session.close();
		session = sessionFactory.openSession();
		session.beginTransaction();

		List<Quote> quotes1 = session.createCriteria(Quote.class).list();
		assertThat(quotes.get(0).getName(), is("Quote1"));
		assertThat(quotes.get(1).getName(), is("Quote2"));

		session.close();
		session = sessionFactory.openSession();
		session.beginTransaction();

		quote = session.get(Quote.class, 1);

		quote.setName("Changed");

		session.getTransaction().commit();
		session.close();
		
		session = sessionFactory.openSession();
		session.beginTransaction();

		quote = session.get(Quote.class, 1);
		assertThat(quote.getName(), is("Changed"));
		session.getTransaction().commit();
		session.close();
	}
}
