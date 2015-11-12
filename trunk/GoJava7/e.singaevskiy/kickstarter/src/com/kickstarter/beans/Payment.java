package com.kickstarter.beans;

import java.util.Date;

public class Payment {
	private User user;
	private long cardId;
	private long sum;
	private Date date;

	public Payment(User user, long cardId, long sum, Date date) {
		this.user = user;
		this.cardId = cardId;
		this.sum = sum;
		this.date = date;
	}

	public long getCardId() {
		return cardId;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setCardId(long cardId) {
		this.cardId = cardId;
	}

	public void setSum(long sum) {
		this.sum = sum;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public long getSum() {
		return sum;
	}

	public User getUser() {
		return user;
	}

	public Date getDate() {
		return date;
	}

}
