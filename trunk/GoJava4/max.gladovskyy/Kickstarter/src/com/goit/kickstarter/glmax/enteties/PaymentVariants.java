package com.goit.kickstarter.glmax.enteties;

import java.util.HashMap;

public class PaymentVariants {
	private int id;
	private HashMap<String, Integer> payVariants;
	
	public PaymentVariants(int id, HashMap<String, Integer> payments) {
		super();
		this.id = id;
		this.payVariants = payments;
	}

	public HashMap<String, Integer> getPayments() {
		return payVariants;
	}
	
	public Integer getCost(String paymentVariant) {
		return payVariants.get(paymentVariant);
	}

}
