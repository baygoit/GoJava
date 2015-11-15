package ua.com.goit.gojava7.kickstarter.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class Payment implements Comparable<Payment>, Serializable{

	private static final long serialVersionUID = 1L;
	private String userName;
	private long donatingSum;
	private int cardId;
	private Calendar paymentDate;
	
	public Payment(String userName, long donateSum, int cardId) {
		this.userName = userName;
		this.donatingSum = donateSum;
		this.cardId = cardId;
		
		TimeZone timeZone = TimeZone.getTimeZone("Europe/Kiev");
		paymentDate = Calendar.getInstance();
		Date date = new Date();
		paymentDate.setTimeZone(timeZone);
		paymentDate.setTime(date);
	}
	
	public long getContribution() {
		return donatingSum;
	}
	
	public void setContribution(long contribution) {
		this.donatingSum = contribution;
	}
	
	public int getCardId() {
		return cardId;
	}
	
	public void setCardId(int cardId) {
		this.cardId = cardId;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public Calendar getPaymentDate() {
		return paymentDate;
	}

	@Override
	public int compareTo(Payment that) {
		return  this.userName.compareTo(that.getUserName());
	}
}
