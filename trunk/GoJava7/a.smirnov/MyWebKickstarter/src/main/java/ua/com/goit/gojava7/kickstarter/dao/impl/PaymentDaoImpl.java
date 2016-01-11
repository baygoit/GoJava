package ua.com.goit.gojava7.kickstarter.dao.impl;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ua.com.goit.gojava7.kickstarter.beans.Payment;
import ua.com.goit.gojava7.kickstarter.dao.PaymentDao;

@Repository
public class PaymentDaoImpl implements PaymentDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	public void add(Payment payment) {
		Session session = sessionFactory.getCurrentSession();
		session.save(payment);
	}

	@Transactional
	public long getSumProjectPayments(int projectId) {
		Session session = sessionFactory.getCurrentSession();

		Criteria criteria = session.createCriteria(Payment.class);
		criteria.add(Restrictions.eq("project.id", projectId));
		criteria.setProjection(Projections.sum("pledge"));
		Long result = (Long) criteria.uniqueResult();

		if (result == null) {
			return 0;
		} else {
			return result;
		}
	}

	public void remove(Payment payment) {
		// TODO
	}
}
