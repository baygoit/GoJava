package ua.com.goit.gojava7.kickstarter.dao.sql;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import ua.com.goit.gojava7.kickstarter.dao.QuoteDao;
import ua.com.goit.gojava7.kickstarter.domain.Quote;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:H2/H2ApplicationContext*.xml")
@Transactional
public class QuoteDaoSqlImplTest {

	@PersistenceContext
	private EntityManager em;

	@Autowired
	private QuoteDao quoteDao;

	@Test
	public void testGetRandomQuote() {
       
		Quote quote = new Quote();
        quote.setText("Test Quote 1");

        em.persist(quote);
        
		assertThat(quoteDao.getRandomQuote().getText(), is(quote.getText()));

	}

}
