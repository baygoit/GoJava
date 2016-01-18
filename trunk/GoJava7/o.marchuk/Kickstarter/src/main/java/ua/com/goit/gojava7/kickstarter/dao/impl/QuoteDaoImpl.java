package ua.com.goit.gojava7.kickstarter.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ua.com.goit.gojava7.kickstarter.dao.QuoteDao;
import ua.com.goit.gojava7.kickstarter.domain.Quote;

@Repository
@Transactional
public class QuoteDaoImpl implements QuoteDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Quote getRandomQuote() {
		// TODO get random

		Quote quote = em.find(Quote.class, 1l);

		return quote;
	}

}
