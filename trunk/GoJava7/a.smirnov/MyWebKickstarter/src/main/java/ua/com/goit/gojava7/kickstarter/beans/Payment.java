package ua.com.goit.gojava7.kickstarter.beans;

public class Payment {
	private int projectID;
	private String userName;
	private long creditCardNumber;
	private int donatingSum;
		
	public int getProjectID() {
		return projectID;
	}
	
	public void setProjectID(int projectID) {
		this.projectID = projectID;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public long getCreditCardNumber() {
		return creditCardNumber;
	}
	
	public void setCreditCardNumber(long creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}
	
	public int getDonatingSum() {
		return donatingSum;
	}
	
	public void setDonatingSum(int donatingSum) {
		this.donatingSum = donatingSum;
	}
}
