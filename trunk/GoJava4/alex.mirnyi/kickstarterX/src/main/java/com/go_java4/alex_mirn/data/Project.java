package com.go_java4.alex_mirn.data;

public class Project {

	private int projectId;
	private Category category;
	private String name;
	private String shortDescription;
	private int totalSum;
	private int pledged;
	private int daysLeft;
	private String history;
	private String videoLink;
	private String questions;

	public Project(int id, Category category, String name, String shortDescription,
			int totalSum, int pledged, int daysLeft) {
		this.projectId = id;
		this.category = category;
		this.name = name;
		this.shortDescription = shortDescription;
		this.totalSum = totalSum;
		this.pledged = pledged;
		this.daysLeft = daysLeft;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public Project(int id, Category category, String name, String shortDescription,
			int totalSum, int pledged, int daysLeft, String history,
			String videoLink, String questions) {
		this.projectId = id;
		this.category = category;
		this.name = name;
		this.shortDescription = shortDescription;
		this.totalSum = totalSum;
		this.pledged = pledged;
		this.daysLeft = daysLeft;
		this.history = history;
		this.videoLink = videoLink;
		this.questions = questions;
	}

	public String getHistory() {
		return history;
	}

	public String getVideoLink() {
		return videoLink;
	}

	public String getQuestions() {
		return questions;
	}

	public String fullInfo() {
		return  toString()
				+ "History: " + history + "\n" + "Videolink: " + videoLink
				+ "\n" + "Answers and questions: " + questions;
	}

	@Override
	public String toString() {
		return "Project number: " + projectId + "\n" + "Project name: " + name
				+ "\n" + "Short Description: " + shortDescription + "\n"
				+ "Total sum needed: " + totalSum + "$" + "\n" + "Pledged: "
				+ totalSum + "$" + "\n" + "Days to go: " + daysLeft + "\n";
	}

	public int getProjectId() {
		return projectId;
	}

	public Category getCategory() {
		return category;
	}

	public void setHistory(String history) {
		this.history = history;
	}

	public void setVideoLink(String videoLink) {
		this.videoLink = videoLink;
	}

	public void setQuestions(String questions) {
		this.questions = questions;
	}

}