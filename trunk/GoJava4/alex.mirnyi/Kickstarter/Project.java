package Kickstarter;

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
	
	
	public Project(
			 int projectId, Category category, String name, 
			 String shortDescription, int totalSum, int pledged,
			 int daysLeft, String history, String videoLink, String questions) {
		this.projectId = projectId;
		this.setCategory(category);
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

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public int getTotalSum() {
		return totalSum;
	}

	public void setTotalSum(int totalSum) {
		this.totalSum = totalSum;
	}

	public int getPledged() {
		return pledged;
	}

	public void setPledged(int pledged) {
		this.pledged = pledged;
	}

	public int getDaysLeft() {
		return daysLeft;
	}

	public void setDaysLeft(int daysLeft) {
		this.daysLeft = daysLeft;
	}

	public String getHistory() {
		return history;
	}

	public void setHistory(String history) {
		this.history = history;
	}

	public String getVideoLink() {
		return videoLink;
	}

	public void setVideoLink(String videoLink) {
		this.videoLink = videoLink;
	}

	public String getQuestions() {
		return questions;
	}

	public void setQuestions(String questions) {
		this.questions = questions;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
}