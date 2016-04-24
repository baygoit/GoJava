package com.anmertrix.dao;

import com.anmertrix.domain.Payment;

public interface PaymentDao {
	
	long getGatheredBudgetByProjectId(long projectId);

	void insertPayment(Payment payment);

}
