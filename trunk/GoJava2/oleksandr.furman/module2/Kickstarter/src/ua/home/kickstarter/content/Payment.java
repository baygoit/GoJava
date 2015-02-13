package ua.home.kickstarter.content;

public class Payment {
	private String name;
	private String cardNumber;
	private int amount;

	public Payment(String name, String cardNumber, int amount) {
		this.name = name;
		this.cardNumber = cardNumber;
		this.amount = amount;
	}
}
