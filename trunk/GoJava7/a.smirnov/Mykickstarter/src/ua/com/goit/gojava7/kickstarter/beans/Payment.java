package ua.com.goit.gojava7.kickstarter.beans;

import java.io.Serializable;

public class Payment implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int projectID;
	private String userName;
	private long creditCardNumber;
	private int donatingSum;
	
	public Payment(String userName, long creditCardNumber, int donatingSum) {
		this.userName = userName;
		this.creditCardNumber = creditCardNumber;
		this.donatingSum = donatingSum;
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
	
	public int getProjectID() {
		return projectID;
	}
	
	public void setProjectID(int projectID) {
		this.projectID = projectID;
	}
}
