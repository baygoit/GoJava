package goit.nz.kickstarter.domain;

public class RewardOption {
	private int amount;
	private String description;
	
	public RewardOption(int amount, String description) {
		this.amount = amount;
		this.description = description;
	}
	
	public int getAmount() {
		return amount;
	}
	
	public String getDescription() {
		return description;
	}
}
