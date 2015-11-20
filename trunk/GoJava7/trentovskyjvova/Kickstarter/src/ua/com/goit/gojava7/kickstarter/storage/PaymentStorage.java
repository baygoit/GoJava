package ua.com.goit.gojava7.kickstarter.storage;

import java.util.ArrayList;
import java.util.List;

import ua.com.goit.gojava7.kickstarter.domain.Payment;

public class PaymentStorage {
	private List<Payment> payments = new ArrayList<>();

	public List<Payment> getPayments() {
		return payments;
	}

	public void setPayments(List<Payment> payments) {
		this.payments = payments;
	}
	
	public int generateIdOfNewElement() {
		int maxId = 0;
		for (Payment payment : payments) {
			if (maxId < payment.getId()) {
				maxId = payment.getId();
			}
		}
		return maxId + 1;
	}

	public void addPayment(Payment payment) {
		payments.add(payment);		
	}
	
}
