package com.anmertrix.dao;

import java.util.List;

import com.anmertrix.domain.Payment;

public interface PaymentDao {
	
	void insertPayment(Payment payment);

	long getGatheredBudget(long projectId);

	List<Payment> getPayments(long projectId);

}
