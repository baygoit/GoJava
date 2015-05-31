package com.goit.kickstarter.glmax.enteties;

import java.util.HashMap;

public class PaymentVariants {
	private int id;
	private HashMap<String, Integer> payments;
	
	public PaymentVariants(int id, HashMap<String, Integer> payments) {
		super();
		this.id = id;
		this.payments = payments;
	}

	public HashMap<String, Integer> getPayments() {
		return payments;
	}
	
	public Integer getCost(String paymentVariant) {
		return payments.get(paymentVariant);
	}

}
