package ua.com.goit.gojava7.kickstarter.model;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class Payment {
	private String userName;
	private long donatingSum;
	private int cardId;
	private Calendar paymentDate;
	
	public Payment(String user, long donateSum, int cardId) {
		this.userName = user;
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
	
	public String getUser() {
		return userName;
	}
	
	public void setUser(String userName) {
		this.userName = userName;
	}
	
	public Calendar getPaymentDate() {
		return paymentDate;
	}
}
