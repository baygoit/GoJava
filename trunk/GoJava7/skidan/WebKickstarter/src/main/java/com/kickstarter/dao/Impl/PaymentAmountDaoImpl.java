package com.kickstarter.dao.Impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.kickstarter.model.PaymentAmount;

@Repository
public class PaymentAmountDaoImpl {

	@PersistenceContext
	EntityManager entityManager;

	@Transactional(readOnly = true)
	public PaymentAmount getPaymentAmount(int paymentAmountId) {
		return entityManager.find(PaymentAmount.class, paymentAmountId);

	}

}
