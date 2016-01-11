package ua.com.goit.gojava7.kickstarter.dao.sql;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
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
	public void addPayment(Payment payment) {

		Session session = sessionFactory.getCurrentSession();
		
		session.save(payment);

	}

}
