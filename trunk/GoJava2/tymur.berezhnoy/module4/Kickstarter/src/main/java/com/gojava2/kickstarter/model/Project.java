package com.gojava2.kickstarter.model;

public class Project {
	
	private Category category;
	private final char symbolDollar = 36;
	
	private int id;
	
	private String name;
	private String description;
	private String story;
	private String link;
	
	private int requiredAmount;
	private int total;
	private int days;
	private int backers;
	
	public Project(int id, String name, String description, int requiredAmount, 
			int total, int days, int backers, String story, String link) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.requiredAmount = requiredAmount;
		this.total = total;
		this.days = days;
		this.backers = backers;
		this.story = story;
		this.link = link;
	}
		
	@Override
	public int hashCode() {
		final int prime = 31;
		return prime * id;
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
		if (id != other.id)
			return false;
		return true;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStory() {
		return story;
	}

	public void setStory(String story) {
		this.story = story;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public int getRequiredAmount() {
		return requiredAmount;
	}

	public void setRequiredAmount(int requiredAmount) {
		this.requiredAmount = requiredAmount;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getDays() {
		return days;
	}

	public void setDays(int days) {
		this.days = days;
	}

	public int getBackers() {
		return backers;
	}

	public void setBackers(int backers) {
		this.backers = backers;
	}

	public char getSymbolDollar() {
		return symbolDollar;
	}
	
	public void setCategory(Category category) {
		this.category = category;
	}
	
	public Category getCategory() {
		return category;
	}
}