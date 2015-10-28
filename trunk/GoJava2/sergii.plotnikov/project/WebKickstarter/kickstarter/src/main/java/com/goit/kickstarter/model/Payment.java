package com.goit.kickstarter.model;

public class Payment {
	private String name;
	private String cardNumber;
	private int amount;
	private int projId;

	public Payment(String name, String cardNumber, int amount) {
		this.name = name;
		this.cardNumber = cardNumber;
		this.amount = amount;
	}

	public Payment(String name, String cardNumber, int amount, int projId) {
		this.name = name;
		this.cardNumber = cardNumber;
		this.amount = amount;
		this.projId = projId;
	}

	public String getName() {
		return name;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public int getAmount() {
		return amount;
	}

	public int getProjId() {
		return projId;
	}
}