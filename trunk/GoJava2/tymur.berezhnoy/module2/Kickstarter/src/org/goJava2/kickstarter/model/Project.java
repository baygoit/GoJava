package org.goJava2.kickstarter.model;


public class Project {
	
	private final char symbolDollar = 36;
	private String name;
	private String desription;
	private int requiredAmount;
	private int total;
	private int days;
	
	public Project(String name, String description, int requiredAmount, int total, int days) {
		this.name = name;
		this.desription = description;
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

	public String getDesription() {
		return desription;
	}

	public void setNewDesription(String desription) {
		this.desription = desription;
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
		return new String("Description: " + desription + " \nRequired amount: " + requiredAmount + symbolDollar
						  + "\nTotal: " + total + symbolDollar + " \nDays left: " + days);
	}
}