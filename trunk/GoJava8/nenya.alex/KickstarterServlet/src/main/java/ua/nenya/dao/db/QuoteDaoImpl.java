package ua.nenya.dao.db;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ua.nenya.dao.QuoteDao;
import ua.nenya.domain.Quote;

@Repository
public class QuoteDaoImpl implements QuoteDao {

	@PersistenceContext
	private EntityManager em;

	@Transactional(readOnly = true)
	@Override
	public Quote getRandomQuote() {
		return em.createNamedQuery("Quote.Random", Quote.class).setMaxResults(1).getSingleResult();
	}

}
