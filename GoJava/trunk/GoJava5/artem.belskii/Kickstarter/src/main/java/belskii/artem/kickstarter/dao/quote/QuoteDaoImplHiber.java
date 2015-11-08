package belskii.artem.kickstarter.dao.quote;

import java.util.Random;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projections;

public class QuoteDaoImplHiber implements QuoteDao {

	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

	private int getNextId() {
		Integer maxId = -1;
		Transaction transaction = null;
		Session session = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			Criteria criteria = session.createCriteria(Quote.class).setProjection(Projections.max("id"));
			maxId = (Integer) criteria.uniqueResult();
			if (maxId == null) {
				maxId = 0;
			}
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
		return maxId + 1;
	}

	@Override
	public String getRandomQuote() {
		Quote randomquote = null;
		Transaction transaction = null;
		Session session = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			Random random = new Random();
			int randomId = random.nextInt(this.getNextId() - 1);
			if (randomId == 0) {
				randomId = 1;
			}
			randomquote = session.get(Quote.class, randomId);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
		return randomquote.getQuote();

	}

	@Override
	public void addQuote(String text) {
		Quote quote = new Quote(this.getNextId(), text);
		Transaction transaction = null;
		Session session = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.saveOrUpdate(quote);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}

	}

	@Override
	public void initDemoDB() {
		// Session session = sessionFactory.openSession();
		// session.beginTransaction();
		// session.createSQLQuery("DROP TABLE IF EXISTS QUOTE").executeUpdate();
		// session.getTransaction().commit();
		// session.close();
		//
		// this.addQuote("Demo Quote");
	}

}
