package ua.com.goit.gojava7.kickstarter.storage;

import java.util.HashMap;
import java.util.Map;

import ua.com.goit.gojava7.kickstarter.model.Payer;




public class PayersDataBase {

	private static Map<Integer, Payer> payersList = new HashMap<>();

	public Map<Integer, Payer> getPayersList() {
		return payersList;
	}

	public void setPayersList(Map<Integer, Payer> payersList) {
		this.payersList = payersList;
	}

	
}
