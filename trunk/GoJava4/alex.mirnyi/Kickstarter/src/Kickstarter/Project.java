package Kickstarter;

public class Project {
	private static int count = 0;
	
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
	
	
	public Project(
			 Category category, String name, 
			 String shortDescription, int totalSum, int pledged,
			 int daysLeft, String history, String videoLink, String questions) {
		this.projectId = ++count;
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
	
	public Project(
			Category category, String name, 
			String shortDescription, int totalSum, int pledged,
			int daysLeft) {
		this.projectId = ++count;
		this.category = category;
		this.name = name;
		this.shortDescription = shortDescription;
		this.totalSum = totalSum;
		this.pledged = pledged;
		this.daysLeft = daysLeft;
	}

	public String fullInfo() {
		return 	"\nProject number: " + projectId +
				"\nProject: " + name + "\nShort Description: " + shortDescription +
				   "\nTotal sum needed: " + totalSum + "$" +
				   "\nPledged: " + totalSum + "$" +
				   "\nDays to go: " + daysLeft +
				"\nHistory: " + history +
			   "\nVideolink: " + videoLink +
			   "\nAnswers and questions: " + questions;
	}
	
	@Override
	public String toString() {
		return "\nProject number: " + projectId +
			   "\nProject: " + name + "\nShort Description: " + shortDescription +
			   "\nTotal sum needed: " + totalSum + "$" +
			   "\nPledged: " + totalSum + "$" +
			   "\nDays to go: " + daysLeft;
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