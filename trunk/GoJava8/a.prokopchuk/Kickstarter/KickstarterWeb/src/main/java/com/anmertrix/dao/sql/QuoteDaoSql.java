package com.anmertrix.dao.sql;

import java.util.Random;

import javax.persistence.NoResultException;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.anmertrix.dao.QuoteDao;
import com.anmertrix.domain.Quote;

@Repository
public class QuoteDaoSql implements QuoteDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Transactional(readOnly = true, isolation = Isolation.SERIALIZABLE)
	public Quote getRandomQuote() {
		Session session = sessionFactory.getCurrentSession();
		long count = (long) session.createCriteria(Quote.class)
				.setProjection(Projections.rowCount()).uniqueResult();
		if (count < 1) {
			throw new NoResultException("Where is my quote?");
		}

		int index = new Random().nextInt((int) count);
		Criteria crit = session.createCriteria(Quote.class);
		crit.setFirstResult(index);
		crit.setMaxResults(1);
		return (Quote) crit.uniqueResult();

	}
}
