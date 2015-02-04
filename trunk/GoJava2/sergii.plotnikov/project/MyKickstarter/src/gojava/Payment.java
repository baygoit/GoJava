package gojava;

public class Payment {
	private String name;
	private String cardNumber;
	private int amount;
	
	public Payment(String name, String card, int amount){
		this.name=name;
		this.cardNumber=card;
		this.amount=amount;
	}
}
