package com.anmertrix.domain;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.READ_COMMITTED)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:testApplicationContext.xml" })
public class QuoteMappingTest {

	@PersistenceContext
	private EntityManager em;
	private Quote q;
	
	@Before
	public void setUp() {
		Quote quote1 = new Quote();
		quote1.setText("Quote1");
		quote1.setAuthor("Author1");
		Quote quote2 = new Quote();
		quote2.setText("Quote2");
		quote2.setAuthor("Author2");
		Quote quote3 = new Quote();
		quote3.setText("Quote3");
		quote3.setAuthor("Author3");

		em.merge(quote1);
		q = em.merge(quote2);
		em.merge(quote3);
	}
	
	@After
	public void tearDown() {
		em.createQuery("DELETE FROM Quote").executeUpdate();
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testQuoteUsage() {
		List<Quote> quotes = em.createQuery("FROM Quote").getResultList();
		assertThat(quotes.get(0).getText(), is("Quote1"));
		assertThat(quotes.get(0).getAuthor(), is("Author1"));
		assertThat(quotes.get(0).getId(), is(1L));
		assertThat(quotes.get(1).getText(), is("Quote2"));
		assertThat(quotes.get(1).getAuthor(), is("Author2"));
		assertThat(quotes.get(1).getId(), is(2L));

		Quote quote = em.find(Quote.class, q.getId());
		assertThat(quote.getText(), is("Quote2"));
		assertThat(quote.getAuthor(), is("Author2"));
		assertThat(quote.getId(), is(2L));
	}
}