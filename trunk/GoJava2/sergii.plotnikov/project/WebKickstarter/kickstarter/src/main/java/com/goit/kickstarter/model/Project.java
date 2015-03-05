package com.goit.kickstarter.model;

public class Project {
	private int id;
	private String title;
	private String description;
	private String story;
	private String link;
	private int projectPrice;
	private int collected;
	private int days;

	public Project(int id, String title, String description, String story,
			String link, int projectPrice, int collected, int days) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.story = story;
		this.link=link;
		this.projectPrice = projectPrice;
		this.collected = collected;
		this.days = days;
	}

	public Project(String projectName, String descr, int price) {
		title = projectName;
		description = descr;
		projectPrice = price;
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public int getProjectPrice() {
		return projectPrice;
	}

	public int getCollected() {
		return collected;
	}

	public void setCollected(int collected) {
		this.collected = collected;
	}

	public int getId() {
		return id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
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

	public int getDays() {
		return days;
	}

	public void setDays(int days) {
		this.days = days;
	}
}