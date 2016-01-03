package ua.com.goit.gojava7.kickstarter.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.springframework.stereotype.Repository;

import ua.com.goit.gojava7.kickstarter.beans.Payment;
import ua.com.goit.gojava7.kickstarter.dao.PaymentDao;
import ua.com.goit.gojava7.kickstarter.dao.hibernate.HibernateUtil;

@Repository
public class PaymentDaoMysqlImpl implements PaymentDao {

	@Override
	public void add(Payment payment) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		session.save(payment);
		transaction.commit();
		session.close();
	}

	@Override
	public long getSumProjectPayments(int projectId) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		Criteria criteria = session.createCriteria(Payment.class);
		criteria.setProjection(Projections.sum("pledge"));
		Long result = (Long) criteria.uniqueResult();

		session.close();
		if (result == null) {
			return 0;
		} else {
			return result;
		}
	}

	@Override
	public void remove(Payment payment) {
		// TODO
	}
}
