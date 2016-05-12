package ua.nenya.dao.db;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import ua.nenya.dao.QuoteDao;
import ua.nenya.domain.Quote;

@Transactional
@ContextConfiguration(locations={ "classpath:aplicationContextTest.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class QuoteDaoDbImplTest{

	@Autowired
	private QuoteDao quoteDao;
	
	@PersistenceContext
	private EntityManager em;
	
	@Before
	public void setUp() {
		Quote quote = new Quote();
		quote.setName("Quote1");
		em.persist(quote);
	}
	
	@After
	public void tearDown() {
		em.createQuery("DELETE FROM Quote").executeUpdate();
	}
	
	@Test
	public void testGetRandomQuote(){
		assertNotNull(quoteDao.getRandomQuote());
	}

}
