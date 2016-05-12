package com.anmertrix.dao.sql;

import java.util.Random;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

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
		long count = getCountOfQuotes();
		int index = new Random().nextInt((int) count);
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		CriteriaQuery<Quote> criteriaQuery = criteriaBuilder.createQuery(Quote.class);
		Root<Quote> root = criteriaQuery.from(Quote.class);
		TypedQuery<Quote> query = em.createQuery(
				criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("id"), index)));
		return query.getSingleResult();
	}
	
	private long getCountOfQuotes() {
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		CriteriaQuery<Long> criteriaQuery = criteriaBuilder.createQuery(Long.class);
		Root<Quote> root = criteriaQuery.from(Quote.class);
		criteriaQuery.select(criteriaBuilder.count(root));
		return em.createQuery(criteriaQuery).getSingleResult();
	}
}
