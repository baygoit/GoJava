package com.gojava2.kickstarter.content;

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

	public void setNewName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setNewDescription(String description) {
		this.description = description;
	}

	public String getStory() {
		return story;
	}

	public void setNewStory(String story) {
		this.story = story;
	}

	public String getLink() {
		return link;
	}

	public void setNewLink(String link) {
		this.link = link;
	}

	public int getRequiredAmount() {
		return requiredAmount;
	}

	public void setNewRequiredAmount(int requiredAmount) {
		this.requiredAmount = requiredAmount;
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

	public void setNewDays(int days) {
		this.days = days;
	}

	public int getBackers() {
		return backers;
	}

	public void setNewBackers(int backers) {
		this.backers = backers;
	}

	public char getSymbolDollar() {
		return symbolDollar;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((link == null) ? 0 : link.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((story == null) ? 0 : story.hashCode());
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
		if (story == null) {
			if (other.story != null)
				return false;
		} else if (!story.equals(other.story))
			return false;
		return true;
	}
}