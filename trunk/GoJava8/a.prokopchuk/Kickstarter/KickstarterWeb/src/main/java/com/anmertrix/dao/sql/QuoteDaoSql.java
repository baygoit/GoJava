package com.anmertrix.dao.sql;

import java.util.Random;

import org.hibernate.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.anmertrix.dao.QuoteDao;
import com.anmertrix.domain.Quote;

@Repository
public class QuoteDaoSql implements QuoteDao {

	public Quote getRandomQuote() {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		
        Transaction transaction = session.beginTransaction();
		
		Long count = ((Long) session.createQuery("select count(*) from Quote").uniqueResult());
		Integer totalCount = count.intValue();
		
 		Random random = new Random();
		int number = random.nextInt(totalCount);
		
		Quote quote = session.get(Quote.class, number + 1);
		
		transaction.commit();
        session.close();
		
		return quote;
	}

}
