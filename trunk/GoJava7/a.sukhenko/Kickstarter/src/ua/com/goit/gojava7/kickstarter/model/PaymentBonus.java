package ua.com.goit.gojava7.kickstarter.model;

import java.util.HashMap;

public class PaymentBonus {
	private HashMap<Integer,String> bonuses = new HashMap<>();
	public PaymentBonus() {
		bonuses.put(1, "Bonus for 1");
		bonuses.put(10, "Bonus for 10");
		bonuses.put(40, "Bonus for 40");
	}
	
	
	public HashMap<Integer,String> getBonuses() {
		return bonuses;
	}

	public void setBonuses(HashMap<Integer,String> bonuses) {
		this.bonuses = bonuses;
	}
	
}
