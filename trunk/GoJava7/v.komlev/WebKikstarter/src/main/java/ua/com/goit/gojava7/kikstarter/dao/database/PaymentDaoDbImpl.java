package ua.com.goit.gojava7.kikstarter.dao.database;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ua.com.goit.gojava7.kikstarter.dao.PaymentDao;
import ua.com.goit.gojava7.kikstarter.domain.Payment;

@Repository
public class PaymentDaoDbImpl implements PaymentDao {

	private static final Logger log = Logger.getLogger(PaymentDaoDbImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void add(Payment payment) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(payment);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public void remove(Payment payment) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.delete(payment);
		session.getTransaction().commit();
		session.close();
	}

	@Transactional
	@Override
	public Integer getSumOfProject(int projectId) {
		log.info("start method getSumOfProject()");
		Session session = sessionFactory.getCurrentSession();

		Criteria criteria = session.createCriteria(Payment.class);
		criteria.add(Restrictions.eq("project.id", projectId));
		criteria.setProjection(Projections.sum("amountDonation"));
		log.info("resultSet = " + criteria.uniqueResult());
		if (criteria.uniqueResult() == null) {
			return 0;
		} else {
			Long resultSum = (Long) criteria.uniqueResult();
			return resultSum.intValue();
		}
	}

}
