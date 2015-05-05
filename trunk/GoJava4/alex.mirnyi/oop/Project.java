package oop;

public class Project {
	private int projectId;
	private int categoryId;
	private String name;
	private String shortDescription;
	private int totalSum;
	private int pledged;
	private int daysLeft;
	private String history;
	private String videoLink;
	private String questions;
	
	
	public Project(
			 int projectId, int categoryId, String name, String shortDescription,
			 int totalSum, int pledged,
			 int daysLeft, String history,
			 String videoLink, String questions) {
		this.setProjectId(projectId);
		this.setCategoryId(categoryId);
		this.name = name;
		this.shortDescription = shortDescription;
		this.totalSum = totalSum;
		this.pledged = pledged;
		this.daysLeft = daysLeft;
		this.history = history;
		this.videoLink = videoLink;
		this.questions = questions;
	}

	public String fullInfo() {
		return 	"\nProject number: " + getProjectId() +
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
		return "\nProject number: " + getProjectId() +
			   "\nProject: " + name + "\nShort Description: " + shortDescription +
			   "\nTotal sum needed: " + totalSum + "$" +
			   "\nPledged: " + totalSum + "$" +
			   "\nDays to go: " + daysLeft;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
}
