package ua.nenya.dao.impl;

import java.util.Random;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

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
		long count = getCountOfQuotes();
		int index = new Random().nextInt((int) count);
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		CriteriaQuery<Quote> criteriaQuery = criteriaBuilder.createQuery(Quote.class);
		Root<Quote> root = criteriaQuery.from(Quote.class);
		criteriaQuery.select(root);
		Query selectQuery = em.createQuery(criteriaQuery);
		selectQuery.setFirstResult(index);
		selectQuery.setMaxResults(1);
		return (Quote) selectQuery.getSingleResult();
	}

	private long getCountOfQuotes() {
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		CriteriaQuery<Long> criteriaQuery = criteriaBuilder.createQuery(Long.class);
		Root<Quote> root = criteriaQuery.from(Quote.class);
		criteriaQuery.select(criteriaBuilder.count(root));
		return em.createQuery(criteriaQuery).getSingleResult();
	}

}
