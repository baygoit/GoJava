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
	
	public String getName(){
		return name;
	}
	
	public String getCard(){
		return cardNumber;
	}
	
	public int getAmount(){
		return amount;
	}
}
