package ua.com.goit.gojava7.kickstarter.database.implementation;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import ua.com.goit.gojava7.kickstarter.beans.Quote;
import ua.com.goit.gojava7.kickstarter.database.contract.QuoteDao;

@Repository
public class QuoteDaoImpl implements QuoteDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Quote getRandomQuote() {
		return entityManager.createNamedQuery("Quote.getRandom", Quote.class).setMaxResults(1).getSingleResult();
	}

	@Override
	@Transactional
	public void add(Quote quote) {
		entityManager.persist(quote);
	}

	@Override
	@Transactional
	public void remove(Quote quote) {
		entityManager.remove(quote);
	}
}
