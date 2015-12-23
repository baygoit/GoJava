package com.kickstarter.model;

public class Payer {

	private String holderName;
	private int cardId;

	public Payer(String name, int cardId) {
		this.holderName = name;
		this.cardId = cardId;
	}

	public String getName() {
		return holderName;
	}

	public void setName(String name) {
		this.holderName = name;
	}

	public int getCardId() {
		return cardId;
	}

	public void setCardId(int cardId) {
		this.cardId = cardId;
	}

}
