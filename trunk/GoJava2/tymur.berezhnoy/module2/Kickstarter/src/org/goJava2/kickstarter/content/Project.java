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
	private int backers;
	
	public Project(String name, String description, int requiredAmount, 
			int total, int days, int backers, String story, String link) {
		this.name = name;
		this.description = description;
		this.requiredAmount = requiredAmount;
		this.total = total;
		this.days = days;
		this.backers = backers;
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
		StringBuilder builder = new StringBuilder();
		builder.append("Description: ").append(description)
			.append("\nRequired amount: ").append(requiredAmount).append(symbolDollar)
			.append("\nTotal: ").append(total).append(symbolDollar)
			.append("\nDays left: ").append(days)
			.append("\nBackers: ").append(backers)
			.append("\nStory: ").append(story)
			.append("\nLink to video: ").append(link);
		return builder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + backers;
		result = prime * result + days;
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((link == null) ? 0 : link.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + requiredAmount;
		result = prime * result + ((story == null) ? 0 : story.hashCode());
		result = prime * result + symbolDollar;
		result = prime * result + total;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Project other = (Project) obj;
		if (backers != other.backers)
			return false;
		if (days != other.days)
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (link == null) {
			if (other.link != null)
				return false;
		} else if (!link.equals(other.link))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (requiredAmount != other.requiredAmount)
			return false;
		if (story == null) {
			if (other.story != null)
				return false;
		} else if (!story.equals(other.story))
			return false;
		if (symbolDollar != other.symbolDollar)
			return false;
		if (total != other.total)
			return false;
		return true;
	}
}