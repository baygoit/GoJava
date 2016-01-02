package com.kickstarter.model;

public class Project {
	private int id;
	private String title;
	private String discription;
	private int daysLeft;
	private int requiredSum;
	private int gainedSum;
	private String projectHistory;
	private String videoLink;
	private Category category;

	

	public Project() {
	}

	public Project(int id, String title, String discription, int daysLeft, int requiredSum, int gainedSum,
			String projectHistory, String videoLink, Category category) {
		this.id = id;
		this.title = title;
		this.discription = discription;
		this.daysLeft = daysLeft;
		this.requiredSum = requiredSum;
		this.gainedSum = gainedSum;
		this.projectHistory = projectHistory;
		this.videoLink = videoLink;
		this.category = category;
	}
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDiscription() {
		return discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}

	public int getDaysLeft() {
		return daysLeft;
	}

	public void setDaysLeft(int daysLeft) {
		this.daysLeft = daysLeft;
	}

	public int getRequiredSum() {
		return requiredSum;
	}

	public void setRequiredSum(int requiredSum) {
		this.requiredSum = requiredSum;
	}

	public int getGainedSum() {
		return gainedSum;
	}

	public void setGainedSum(int gainedSum) {
		this.gainedSum = gainedSum;
	}

	public String getProjectHistory() {
		return projectHistory;
	}

	public void setProjectHistory(String projectHistory) {
		this.projectHistory = projectHistory;
	}

	public String getVideoLink() {
		return videoLink;
	}

	public void setVideoLink(String videoLink) {
		this.videoLink = videoLink;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

/*	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}*/

	@Override
	public String toString() {
		return ("Project Title : " + title + "\n Project Discription :" + discription + "\n Project History : "
				+ projectHistory + "\n Video Link : " + videoLink + "\n Required Sum :" + requiredSum
				+ "\n Gained Sum :" + gainedSum + "\n Days Left :" + daysLeft + "\n");
	}

}