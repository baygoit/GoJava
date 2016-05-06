
package ua.nenya.domain;
 
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.READ_COMMITTED)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:aplicationContextTest.xml" })
public class QuoteMappingTest {

	@PersistenceContext
	private EntityManager em;
	private Quote q;
	
	@Before
	public void setUp() {
		Quote quote1 = new Quote();
		quote1.setName("Quote1");
		Quote quote2 = new Quote();
		quote2.setName("Quote2");

		em.merge(quote1);
		q = em.merge(quote2);
	}
	
	@After
	public void tearDown() {
		em.createQuery("DELETE FROM Quote").executeUpdate();
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testQuoteUsage1() {
		List<Quote> quotes = em.createQuery("FROM Quote").getResultList();
		assertThat(quotes.get(0).getName(), is("Quote1"));
		assertThat(quotes.get(1).getName(), is("Quote2"));

		Quote quote = em.find(Quote.class, q.getId());
		assertThat(quote.getName(), is("Quote2"));
	}
	
	@Test
	public void testQuoteUsage2() {
		List<Quote> quotes = em.createNamedQuery("Quote.Random", Quote.class).getResultList();
		assertNotNull(quotes);
	}
}
