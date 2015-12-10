package ua.com.goit.gojava7.kickstarter.beans;

public class Reward {
	
	private int projectID;
	private int donatingSum;
	private String description;
	
	public int getProjectID() {
		return projectID;
	}
	
	public void setProjectID(int projectID) {
		this.projectID = projectID;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public int getDonatingSum() {
		return donatingSum;
	}
	
	public void setDonatingSum(int donatingSum) {
		this.donatingSum = donatingSum;
	}
}
