package ua.com.goit.gojava7.kickstarter;

public class Payment {
	private String cardOwner;
	private long cardNumber;
	private int rechargeAmount;

	public Payment(String cardOwner, long cardNumber, int rechargeAmount) {
		this.cardOwner = cardOwner;
		this.cardNumber = cardNumber;
		this.rechargeAmount = rechargeAmount;
		
	}
	public int getRechargeAmount(){
		return this.rechargeAmount;
	}
	public long getCardNumber(){
		return this.cardNumber;
	}
	public String getCardOwner(){
		return this.cardOwner;
	}

}
