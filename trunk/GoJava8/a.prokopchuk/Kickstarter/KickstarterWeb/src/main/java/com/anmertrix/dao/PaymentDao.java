package com.anmertrix.dao;

import java.util.List;

import com.anmertrix.domain.Payment;

public interface PaymentDao {
	
	List<Payment> getPaymentsByProjectId(int project_id);

	void insertPayment(Payment payment);

	List<Long> getGatheredBudgets();

}
