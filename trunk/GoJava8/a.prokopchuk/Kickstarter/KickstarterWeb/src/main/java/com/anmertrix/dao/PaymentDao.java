package com.anmertrix.dao;

import java.util.List;

import com.anmertrix.domain.Payment;

public interface PaymentDao {
	
	void insertPayment(Payment payment);

	long getGatheredBudgetByProjectId(long projectId);

	List<Payment> getPaymentsByProjectId(long projectId);

}
