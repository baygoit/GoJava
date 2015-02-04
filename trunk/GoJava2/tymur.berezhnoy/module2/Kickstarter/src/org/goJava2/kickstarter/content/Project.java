package org.goJava2.kickstarter.content;

public class Project {
	
	private final char symbolDollar = 36;
	private String name;
	private String description;
	private String story;
	private String link;
	private int requiredAmount;
	private int total;
	private int days;
	
	public Project(String name, String description, int requiredAmount, int total, int days, String story, String link) {
		this.name = name;
		this.description = description;
		this.requiredAmount = requiredAmount;
		this.total = total;
		this.days = days;
		this.story = story;
		this.link = link;
	}
	
	public String getName() {
		return name;
	}
	
	public String getShortInfo() {
		return new String("Description: " + description + " \nRequired amount: " + requiredAmount + symbolDollar
						  + "\nTotal: " + total + symbolDollar + " \nDays left: " + days);
	}
	
	public String getFullInfo() {
		return new String("Description: " + description + " \nRequired amount: " + requiredAmount + symbolDollar
				  + "\nTotal: " + total + symbolDollar + " \nDays left: " + days + "\nHistory: " + story + "\nLink to video: " + link);
	}
}