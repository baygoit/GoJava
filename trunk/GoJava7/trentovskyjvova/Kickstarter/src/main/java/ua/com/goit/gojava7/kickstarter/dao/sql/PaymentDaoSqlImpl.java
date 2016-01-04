package ua.com.goit.gojava7.kickstarter.dao.sql;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ua.com.goit.gojava7.kickstarter.dao.PaymentDao;
import ua.com.goit.gojava7.kickstarter.domain.Payment;

@Repository
@Transactional
public class PaymentDaoSqlImpl implements PaymentDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Payment> getPayments(int projectId) {

		Session session = sessionFactory.getCurrentSession();

		Criteria criteria = session.createCriteria(Payment.class);
		criteria.add(Restrictions.eq("projectId", projectId));
		List<Payment> payments = criteria.list();
		
		return payments;
	}

	@Override
	public void addPayment(Payment payment) {

		Session session = sessionFactory.getCurrentSession();
		
		session.save(payment);

	}

	@Override
	public int getPledged(int projectId) {

		Session session = sessionFactory.getCurrentSession();

		Criteria criteria = session.createCriteria(Payment.class);
		criteria.add(Restrictions.eq("projectId", projectId));
		criteria.setProjection(Projections.sum("pledge"));

		int pledged = (int) criteria.uniqueResult();
		
		return pledged;
	}

}
