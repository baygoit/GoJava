package com.goit.logic;

public class Project {

	private String name;
	private String description;
	private String link;
	private int needMoney;
	private int accumulatedMoney;
	private String finalData;
	private String creditCardNumber;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getNeedMoney() {
		return needMoney;
	}

	public void setNeedMoney(int needMoney) {
		this.needMoney = needMoney;
	}

	public int getAccumulatedMoney() {
		return accumulatedMoney;
	}

	public void setAccumulatedMoney(int accumulatedMoney) {
		this.accumulatedMoney = accumulatedMoney;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getFinalDate() {
		return finalData;
	}

	public void setFinalData(String finalData) {
		this.finalData = finalData;
	}

	public String getCreditCardNumber() {
		return creditCardNumber;
	}

	public void setCreditCardNumber(String creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}

}
