package ua.com.goit.gojava7.kickstarter.model;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class Payment {
	private User user;
	private long donatingSum;
	private int cardId;
	private Calendar paymentDate;
	
	public Payment(User user, long donatingSum, int cardId) {
		this.user = user;
		this.donatingSum = donatingSum;
		this.cardId = cardId;
		
		TimeZone timeZone = TimeZone.getTimeZone("Europe/Kiev");
		paymentDate = Calendar.getInstance();
		Date date = new Date();
		
		paymentDate.setTimeZone(timeZone);
		paymentDate.setTime(date);
	}
	
	public void setContribution(long contribution) {
		this.donatingSum = contribution;
	}
	
	public long getContribution() {
		return donatingSum;
	}
	
	public void setCardId(int cardId) {
		this.cardId = cardId;
	}
	
	public int getCardId() {
		return cardId;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	public User getUser() {
		return user;
	}
	
	public Calendar getPaymentDate() {
		return paymentDate;
	}
	
	

}
