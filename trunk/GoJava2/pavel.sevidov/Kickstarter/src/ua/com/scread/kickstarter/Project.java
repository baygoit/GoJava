package ua.com.scread.kickstarter;

public class Project {
	private String name;
	private String description;
	private double collected;
	private double amount;
	private int days;
	private Category category;

	public Project(String name, String description, double amount, int days) {
		this.name = name;
		this.description = description;
		this.amount = amount;
		this.days = days;
		collected = 0;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public double getCollected() {
		return collected;
	}

	public double getAmount() {
		return amount;
	}

	public int getDays() {
		return days;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	

}
