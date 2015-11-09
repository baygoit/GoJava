package com.kickstarter.storages;

import java.util.HashMap;
import java.util.Map;


import com.kickstarter.models.Payer;

public class PayersDataBase {

	private Map<Integer, Payer> payersList = new HashMap<>();

	public Map<Integer, Payer> getPayersList() {
		return payersList;
	}

	public void setPayersList(Map<Integer, Payer> payersList) {
		this.payersList = payersList;
	}

	
}
