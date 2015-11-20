package com.kickstarter.db;

import java.util.HashMap;
import java.util.Map;

import com.kickstarter.model.Payer;

public class PayersDB {

	private static Map<Integer, Payer> payersList = new HashMap<>();

	public Map<Integer, Payer> getPayersList() {
		return payersList;
	}

	public void setPayersList(Map<Integer, Payer> payersList) {
		this.payersList = payersList;
	}

}
