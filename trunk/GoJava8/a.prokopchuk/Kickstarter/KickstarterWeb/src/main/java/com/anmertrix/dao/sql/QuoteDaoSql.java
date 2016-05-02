package com.anmertrix.dao.sql;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.anmertrix.dao.QuoteDao;
import com.anmertrix.domain.Quote;

@Repository
public class QuoteDaoSql implements QuoteDao {

	@PersistenceContext
	private EntityManager em;

	@Transactional(readOnly = true)
	public Quote getRandomQuote() {
 		return em.createNamedQuery("Quote.getRandom", Quote.class).setMaxResults(1).getSingleResult();
	}
}
