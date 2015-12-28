package ua.com.goit.gojava7.kickstarter.dao;

import java.util.List;
import java.util.Map;

import ua.com.goit.gojava7.kickstarter.domain.Payment;

public interface PaymentDao extends Dao{
	List<Payment> getPayments(int projectId);
	
	void addPayment(Payment payment);

	int getPledged(int projectId);
	
	List<Map<String, Object>> getPledged(Integer[] projectsId);
}
