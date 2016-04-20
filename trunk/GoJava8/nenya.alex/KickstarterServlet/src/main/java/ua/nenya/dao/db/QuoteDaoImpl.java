package ua.nenya.dao.db;

import java.util.Random;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.springframework.stereotype.Repository;

import ua.nenya.dao.QuoteDao;
import ua.nenya.domain.Quote;
import ua.nenya.util.HibernateUtil;

@Repository
public class QuoteDaoImpl implements QuoteDao {
	
	
	@Override
	public Quote getRandomQuote() {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Quote quote = null;
		Transaction transaction = null;
		try (Session session = sessionFactory.openSession()) {
			transaction = session.beginTransaction();
			long count = (long) session.createCriteria(Quote.class).setProjection(Projections.rowCount())
					.uniqueResult();
			Random random = new Random();
			int randomNumber = random.nextInt((int) count);
			quote = session.get(Quote.class, randomNumber + 1);
			transaction.commit();
		} catch (HibernateException e) {
			if (transaction != null)
				transaction.rollback();
			e.printStackTrace();
		}
		return quote;
	}

}
