package ua.com.goit.gojava7.kickstarter.domain;

public class Donation {

	private int amount;
	private String reward;
	
	public Donation(int amount, String reward) {		
		this.amount = amount;
		this.reward = reward;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getReward() {
		return reward;
	}

	public void setReward(String reward) {
		this.reward = reward;
	}	
}
