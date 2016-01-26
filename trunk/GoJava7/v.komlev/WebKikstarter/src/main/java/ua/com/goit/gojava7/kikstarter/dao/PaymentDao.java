package ua.com.goit.gojava7.kikstarter.dao;

import ua.com.goit.gojava7.kikstarter.domain.Payment;

public interface PaymentDao {
	
	void add(Payment payment);

	void remove(Payment payment);
	
	Integer getSumOfProject(int projectId);
	
}
