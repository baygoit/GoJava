package com.goit.logic;

public class CreditCard {
	private String nameHolder;
	private String numberCard; // 1234 5678 1234 5678
	private String validThru; // 05/17 month/year
	private int cvvCode; // 123 - 3 digits

	public String getNameHolder() {
		return nameHolder;
	}

	public void setNameHolder(String nameHolder) {
		this.nameHolder = nameHolder;
	}

	public String getNumberCard() {
		return numberCard;
	}

	public void setNumberCard(String numberCard) {
		this.numberCard = numberCard;
	}

	public String getValidThru() {
		return validThru;
	}

	public void setValidThru(String validThru) {
		this.validThru = validThru;
	}

	public int getCvvCode() {
		return cvvCode;
	}

	public void setCvvCode(int cvvCode) {
		this.cvvCode = cvvCode;
	}
}
