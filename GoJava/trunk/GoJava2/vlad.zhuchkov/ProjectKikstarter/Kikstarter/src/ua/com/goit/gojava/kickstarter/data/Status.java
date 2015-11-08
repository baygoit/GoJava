package ua.com.goit.gojava.kickstarter.data;

import java.io.Serializable;
import java.util.Date;

import ua.com.goit.gojava.kickstarter.exceptions.IlligalInputException;

public class Status implements Serializable {
	private int cost;
	private int collected;
	private long daysLeft;

	public Status(int cost, int collected, Date date) {
		this.cost = cost;
		this.collected = collected;
		Date currentDate = new Date();
		// TODO Improve date operations
		// final int TRANSITION_COEFFICIENT_SECONDS_TO_DAYS = 86400;
		// daysLeft =
		// (date.getTime()-currentDate.getTime())/TRANSITION_COEFFICIENT_SECONDS_TO_DAYS;
	}

	public void setCost(int cost) {
		this.cost = cost;

	}

	public long getDays() {
		return daysLeft;
	}

	public void setAlreadyCollected(int collected) {
		this.collected = collected;

	}

	public int getCost() {
		return cost;
	}

	public int getAlreadyCollected() {
		return collected;
	}

	public void setDays(int days) {
		daysLeft = days;

	}

	public void increaseAmount(int amount) {
		if (amount > 0) {
			collected += amount;
		} else
			throw new IlligalInputException();

	}

}
