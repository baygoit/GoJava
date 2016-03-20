package ua.nenya.project;

public class Reward implements GettingNameInterface{
	private String name;
	private int amount;
	
	private String description;
	
	public Reward() {
	}
	
	public Reward(String name, String description) {
		this.name = name;
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}
	
	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
}
