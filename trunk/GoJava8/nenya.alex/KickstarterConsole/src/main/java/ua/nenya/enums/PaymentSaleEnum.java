package ua.nenya.enums;

import ua.nenya.project.GettingNameInterface;

public enum PaymentSaleEnum implements GettingNameInterface{
	ONE("100$", 100, "Invest one hundred dollars and get bottle of water!!!"), 
	TWO("200$", 200, "Invest two hundreds dollars and get tickets to the movie!!!"), 
	FIVE("500$", 500, "Invest five hundreds dollars and get a lunch in the restaurant!!!"), 
	ANY_AMOUNT("Any amount", "investition");
	
	private String name;
	private int amount;
	private String descriptionOfAmount;

	public String getDescriptionOfAmount() {
		return descriptionOfAmount;
	}

	public void setDescriptionOfAmount(String descriptionOfAmount) {
		this.descriptionOfAmount = descriptionOfAmount;
	}

	
	PaymentSaleEnum(String name, int amount, String descriptionOfAmount) {
		this.name = name;
		this.amount = amount;
		this.descriptionOfAmount = descriptionOfAmount;
	}

	PaymentSaleEnum(String name, String descriptionOfAmount) {
		this.name = name;
		this.descriptionOfAmount = descriptionOfAmount;
	}

	
	PaymentSaleEnum() {
	  }
	
	public int getAmount() {
		return amount;
	}

	@Override
	public String getName() {
		return this.name;
	}

}
