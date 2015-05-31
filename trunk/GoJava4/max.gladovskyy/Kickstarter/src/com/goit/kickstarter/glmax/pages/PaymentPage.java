package com.goit.kickstarter.glmax.pages;

import java.util.ArrayList;
import java.util.Map;

import com.goit.kickstarter.glmax.controller.Runner;
import com.goit.kickstarter.glmax.enteties.PaymentVariants;
import com.goit.kickstarter.glmax.enteties.Project;

public class PaymentPage implements Page {

	private ArrayList<String> page = new ArrayList<String>();
	private PaymentVariants paymentVariants;
	
	public PaymentPage(Runner runner) {
		this.paymentVariants = runner.getpaymentVariants();
		page.add("You have multiple variants of payment:");
		int index = 1;
		for (Map.Entry<String, Integer> payment : paymentVariants.getPayments().entrySet()) {
			page.add(index+++") "+payment.getKey()+" for "+payment.getValue()+" UAH");
		}
		page.add("");
		page.add(index+++") Your variant");
		page.add("0) Exit");
		page.add("");
	}

	@Override
	public ArrayList<String> getPage() {
		return page;
	}

}
