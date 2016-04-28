package ua.nenya.dao.db;

import java.util.Random;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ua.nenya.dao.QuoteDao;
import ua.nenya.domain.Quote;

@Repository
public class QuoteDaoImpl implements QuoteDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Transactional(readOnly = true)
	@Override
	public Quote getRandomQuote() {
		Session session = sessionFactory.getCurrentSession();
		long count = (long) session.createCriteria(Quote.class).setProjection(Projections.rowCount()).uniqueResult();
		Random random = new Random();
		int randomNumber = random.nextInt((int) count);
		return session.get(Quote.class, randomNumber + 1);
	}

}
