package ua.nenya.domain;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.READ_COMMITTED)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:aplicationContextTest.xml" })
public class QuoteMappingTest {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Test
	public void testQuoteUsage() {
		int id2;

		try (Session session = sessionFactory.openSession()) {

			Quote quote1 = new Quote();
			quote1.setName("Quote1");
			Quote quote2 = new Quote();
			quote2.setName("Quote2");

			session.save(quote1);
			id2 = (int) session.save(quote2);
			session.flush();
		}

		try (Session session = sessionFactory.openSession()) {

			List<Quote> quotes = session.createQuery("FROM Quote").list();
			session.flush();
			assertThat(quotes.get(0).getName(), is("Quote1"));
			assertThat(quotes.get(1).getName(), is("Quote2"));

			Quote quote = session.get(Quote.class, id2);
			assertThat(quote.getName(), is("Quote2"));

		}

	}
}
