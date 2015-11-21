package ua.com.goit.gojava7.kickstarter.payment;

public class CreditCardSystem extends PaymentSystem {
	private String holderName;
	private int cardNumber;

	public CreditCardSystem() {
		paymentSystemID = 1;
		paymentSystemName = "Credit Card";
	}

	public void setHolderName(String name) {
		holderName = name;

	}

	public Object getHolderName() {
		return holderName;
	}

	public void setCardNumber(int cardnumber) {
		this.cardNumber = cardnumber;

	}

	public int getCreditCardNumber() {
		return cardNumber;
	}

}
