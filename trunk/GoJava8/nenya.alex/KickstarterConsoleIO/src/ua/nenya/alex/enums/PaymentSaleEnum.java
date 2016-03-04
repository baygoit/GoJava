package ua.nenya.alex.enums;

import ua.nenya.alex.project.GetNameInterface;

public enum PaymentSaleEnum implements GetNameInterface{
	ONE(100, "One hundreds of dollars"), 
	TWO(200), 
	FIVE(500), 
	ANY_AMOUNT;

	public String getDescriptionOfAmount() {
		return descriptionOfAmount;
	}

	public void setDescriptionOfAmount(String descriptionOfAmount) {
		this.descriptionOfAmount = descriptionOfAmount;
	}

	private int amount;
	public String descriptionOfAmount;

	
	
	private PaymentSaleEnum(int amount, String descriptionOfAmount) {
		this.amount = amount;
		this.descriptionOfAmount = descriptionOfAmount;
	}

	PaymentSaleEnum(int amount) {
	    this.amount = amount;
	  }

	
	PaymentSaleEnum() {
	  }
	
	public int getAmount() {
		return amount;
	}

	@Override
	public String getName() {
		return this.name();
	}

}
