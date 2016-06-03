package com.anmertrix.dao.sql;

import java.util.Random;

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
		long count = em.createNamedQuery("Quote.count", Long.class).getSingleResult();
		long quoteId = new Random().nextInt((int) count);
		return em.createNamedQuery("Quote.getQuote", Quote.class)
		.setParameter("quoteId", quoteId + 1).getSingleResult();
	}
}
