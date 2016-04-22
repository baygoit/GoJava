package ua.nenya.dao.db;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import ua.nenya.dao.PaymentDao;
import ua.nenya.domain.Payment;
import ua.nenya.util.HibernateUtil;

@Repository
public class PaymentDaoImpl implements PaymentDao {

	@Override
	public int writePaymentInProject(int projectId, int amount) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Transaction transaction = null;

		Payment payment = new Payment();
		payment.setProjectId(projectId);
		payment.setAmount(amount);
		int id = 0;

		try (Session session = sessionFactory.openSession()) {
			transaction = session.beginTransaction();
			id = (int) session.save(payment);
			transaction.commit();
		} catch (HibernateException e) {
			if (transaction != null)
				transaction.rollback();
			e.printStackTrace();
		}
		return id;
	}

	@Override
	public long getPaymentSum(int projectId) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Transaction transaction = null;
		long sum = 0;
		try (Session session = sessionFactory.openSession()) {
			transaction = session.beginTransaction();
			Criteria criteria = session.createCriteria(Payment.class);
			criteria.add(Restrictions.eq("projectId", projectId));
			sum = (long) criteria.setProjection(Projections.sum("amount")).uniqueResult();
			transaction.commit();
		} catch (HibernateException e) {
			if (transaction != null)
				transaction.rollback();
			e.printStackTrace();
		}
		return sum;
	}

}
