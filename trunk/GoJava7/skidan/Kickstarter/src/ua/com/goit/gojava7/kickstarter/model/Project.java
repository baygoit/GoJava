package ua.com.goit.gojava7.kickstarter.model;

public class Project {

	private String title;;
	private String discription;
	private int daysLeft;
	private int requiredSum;
	private int gainedSum;
	private String projectHistory;
	private String videoLink;
	private String questionSection;

	public Project(String title, String discription, int daysLeft, int requiredSum, int gainedSum,
			String projectHistory, String videoLink, String questionSection) {
		this.title = title;
		this.discription = discription;
		this.daysLeft = daysLeft;
		this.requiredSum = requiredSum;
		this.gainedSum = gainedSum;
		this.projectHistory = projectHistory;
		this.videoLink = videoLink;
		this.questionSection = questionSection;
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

	public String getQuestionSection() {
		return questionSection;
	}

	public void setQuestionSection(String questionSection) {
		this.questionSection = questionSection;
	}

	@Override
	public String toString() {
		return title + " \n " + discription + " daysLeft=" + daysLeft + " \n " + " requiredSum=" + requiredSum + " \n "
				+ " gainedSum=" + gainedSum + " \n ";
	}

}