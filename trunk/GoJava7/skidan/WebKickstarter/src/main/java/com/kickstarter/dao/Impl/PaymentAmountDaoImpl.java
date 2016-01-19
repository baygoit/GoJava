package com.kickstarter.dao.Impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.kickstarter.model.PaymentAmount;

@Repository
public class PaymentAmountDaoImpl {

	@Autowired(required=false)
	private SessionFactory sessionFactory;
	
	
	@Transactional (readOnly = true)
	public PaymentAmount getPaymentAmount(int paymentAmountId) {
		Session session = sessionFactory.openSession();
		PaymentAmount paymentAmount = session.get(PaymentAmount.class, paymentAmountId );
		session.close();
		return paymentAmount;
		
	}
	
	
}
