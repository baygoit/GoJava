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
	
	// It's example of optimization.
	public String getShortInfo() {
		StringBuilder buffer = new StringBuilder();
		buffer.append("Description: ").append(description)
			.append("\nRequired amount: ").append(requiredAmount).append(symbolDollar)
			.append("\nTotal: ").append(total).append(symbolDollar)
			.append("\nDays left: ").append(days);
		return buffer.toString();
	}
	
	// It's example of optimization.
	public String getFullInfo() {
		StringBuilder buffer = new StringBuilder();
		buffer.append("Description: ").append(description)
			.append("\nRequired amount: ").append(requiredAmount).append(symbolDollar)
			.append("\nTotal: ").append(total).append(symbolDollar)
			.append("\nDays left: ").append(days)
			.append("\nStory: ").append(story)
			.append("\nLink to video: ").append(link);
		return buffer.toString();
	}
}