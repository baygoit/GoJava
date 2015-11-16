package ua.com.goit.gojava7.kickstarter.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class Payment implements Comparable<Payment>, Serializable{

	private static final long serialVersionUID = 1L;
	private String userName;
	private long creditCardNumber;
	private int donatingSum;
	private Calendar paymentDate;
	
	public Payment(String userName, long creditCardNumber, int donatingSum) {
		this.userName = userName;
		this.creditCardNumber = creditCardNumber;
		this.donatingSum = donatingSum;
		setPaymentDay();
	}
	
	public long getCreditCardNumber() {
		return creditCardNumber;
	}
	
	public void setCreditCardNumber(long creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public int getDonatingSum() {
		return donatingSum;
	}
	
	public void setDonatingSum(int donatingSum) {
		this.donatingSum = donatingSum;
	}
	
	public Calendar getPaymentDate() {
		return paymentDate;
	}

	protected void setPaymentDay() {
		TimeZone timeZone = TimeZone.getTimeZone("Europe/Kiev");
		paymentDate = Calendar.getInstance();
		Date date = new Date();
		paymentDate.setTimeZone(timeZone);
		paymentDate.setTime(date);
	}
	
	@Override
	public int compareTo(Payment that) {
		return  (int) (this.paymentDate.getTimeInMillis() - that.getPaymentDate().getTimeInMillis());
	}
}
