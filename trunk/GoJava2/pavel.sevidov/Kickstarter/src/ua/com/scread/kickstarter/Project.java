package ua.com.scread.kickstarter;

public class Project {
	private String name;
	private String description;
	private double collected;
	private double amount;
	private int days;
	private Category category;
	private Details details;

	public Project(String name, String description, double amount, int days, Details delails) {
		this.name = name;
		this.description = description;
		this.amount = amount;
		this.days = days;
		this.details = delails;
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
	
	public Details getDetails() {
		return details;
	}
}
