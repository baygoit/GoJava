package modelTest;

import static org.junit.Assert.assertTrue;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.kickstarter.dao.Interfaces.QuoteDao;
import com.kickstarter.model.Quote;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContextForTest.xml")
public class QuoteMappingTest {

	@Autowired
	QuoteDao quoteDao;

	@PersistenceContext
	EntityManager entityManager;

	@Before
	@Transactional
	public void setUp() throws Exception {

		Quote quote1 = new Quote();
		quote1.setQuote("Quote 1");
		quote1.setAuthor("Author 1");
		Quote quote2 = new Quote();
		quote2.setQuote("Quote 2");
		quote2.setAuthor("Author 2");
		entityManager.persist(quote1);
		entityManager.persist(quote2);

	}

	@Test
	@Transactional
	public void testBasicUsage() {
		assertTrue(quoteDao.get().getAuthor().equals("Author 1") || quoteDao.get().getAuthor().equals("Author 2"));
	}
}
