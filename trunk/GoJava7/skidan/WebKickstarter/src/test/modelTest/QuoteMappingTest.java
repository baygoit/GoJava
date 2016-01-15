package modelTest;


import com.kickstarter.dao.interfaces.QuoteDao;
import com.kickstarter.model.Quote;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContextForTest.xml")
public class QuoteMappingTest {
    

	private SessionFactory sessionFactory;


	@Autowired
	QuoteDao quoteDao;
	
	@Before
	public void setUp() throws Exception {
//		quoteDao = new QuoteDaoImpl();
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
//       quoteDao.setSessionFactory(sessionFactory);
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Quote quote1 = new Quote();
		quote1.setQuote("Quote 1");
		quote1.setAuthor("Author 1");

		Quote quote2 = new Quote();
		quote2.setQuote("Quote 2");
		quote2.setAuthor("Author 2");

		session.save(quote1);
		session.save(quote2);
		session.getTransaction().commit();
		session.close();

		
		session = sessionFactory.openSession();
		session.beginTransaction();

		System.out.println("Get by id");
		Quote quote = session.get(Quote.class, 1);
		System.out.println(quote);

		session.close();
		session = sessionFactory.openSession();
		session.beginTransaction();

		List<Quote> result1 = (List<Quote>) session.createQuery("from Quote q").list();
		for (Quote aQuote : result1) {
			System.out.println(aQuote);
		}

		session.close();
		session = sessionFactory.openSession();
		session.beginTransaction();

		System.out.println("Get by id");
		quote = session.get(Quote.class, 1);
		System.out.println(quote);

		quote.setQuote("Changed");

		session.getTransaction().commit();
		session.close();
		session = sessionFactory.openSession();
		session.beginTransaction();

		System.out.println("Get by id");
		quote = session.get(Quote.class, 1);
		System.out.println(quote);
		session.getTransaction().commit();
		session.close();
		
		Quote quote5 =  quoteDao.get();
		
	}
}

