package com.anmertrix.dao.sql;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.anmertrix.dao.PaymentDao;
import com.anmertrix.domain.Payment;

@Repository
public class PaymentDaoSql implements PaymentDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
 	@Transactional(isolation = Isolation.SERIALIZABLE, rollbackFor = Exception.class)
	public void insertPayment(Payment payment) {
		Session session = sessionFactory.getCurrentSession();
		session.save(payment);
	}
}
