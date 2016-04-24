package com.anmertrix.dao.sql;

import java.util.Random;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.springframework.stereotype.Repository;

import com.anmertrix.dao.QuoteDao;
import com.anmertrix.domain.Quote;
import com.anmertrix.dao.sql.HibernateUtil;

@Repository
public class QuoteDaoSql implements QuoteDao {

	public Quote getRandomQuote() {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Quote quote = null;
		try (Session session = sessionFactory.openSession()) {
			long count = (long) session.createCriteria(Quote.class).setProjection(Projections.rowCount())
					.uniqueResult();
	        if (count != 0) {
	            int index = new Random().nextInt((int) count);
	            Criteria crit = session.createCriteria(Quote.class);
	            quote = (Quote)(crit.setFirstResult(index).setMaxResults(1).uniqueResult());
	        }
		} catch (HibernateException e) {
			e.printStackTrace();
		}
        return quote;
	}
}
