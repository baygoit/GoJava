package com.goit.logic;

public class User {
	private String name;
	private String cardNumber;
	private String email;
	int investmentAmount;

	public int getInvestmentAmount() {
		return investmentAmount;
	}

	public void setInvestmentAmount(int money) {
		this.investmentAmount = investmentAmount;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCard() {

		return cardNumber;
	}

	public void setCreditCard(String creditCard) {

		this.cardNumber = creditCard;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
