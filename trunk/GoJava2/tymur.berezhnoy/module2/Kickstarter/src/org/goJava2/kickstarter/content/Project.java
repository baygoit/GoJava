package org.goJava2.kickstarter.content;

public class Project {
	
	private final char symbolDollar = 36;
	private String name;
	private String description;
	private int requiredAmount;
	private int total;
	private int days;
	
	public Project(String name, String description, int requiredAmount, int total, int days) {
		this.name = name;
		this.description = description;
		this.requiredAmount = requiredAmount;
		this.total = total;
		this.days = days;
	}
	
	public String getName() {
		return name;
	}

	public void setNewName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setNewDescription(String desription) {
		this.description = desription;
	}

	public int getRequiredAmount() {
		return requiredAmount;
	}

	public int getTotal() {
		return total;
	}

	public void setNewTotal(int total) {
		this.total = total;
	}
	
	public int getDays() {
		return days;
	}
	
	@Override
	public String toString() {
		return new String("Description: " + description + " \nRequired amount: " + requiredAmount + symbolDollar
						  + "\nTotal: " + total + symbolDollar + " \nDays left: " + days);
	}
}