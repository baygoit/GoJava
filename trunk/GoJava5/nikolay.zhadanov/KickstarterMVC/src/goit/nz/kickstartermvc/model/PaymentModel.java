package goit.nz.kickstartermvc.model;

import java.util.LinkedHashMap;
import java.util.Map;

public class PaymentModel {
	
	private String cardHolderName;
	private String cardNumber;
	private int amountPayed;
	
	public PaymentModel() {
		cardHolderName = "";
		cardNumber = "";
		amountPayed = 0;
	}
	
	public boolean isCardHolderNameEmpty() {
		return cardHolderName.isEmpty();
	}
	
	public boolean isCardNumberEmpty() {
		return cardNumber.isEmpty();
	}
	
	public void setCardHolderName(String name) {
		cardHolderName = name;
	}
	
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	
	public void setAmountPayed(int amount) {
		amountPayed = amount;
	}
	
	public int getAmountPayed() {
		return amountPayed;
	}
	
	public boolean isCardHolderNameValid(String name) {
		boolean result = true;
		for (char c : name.toCharArray()) {
			if (Character.isDigit(c)) {
				result = false;
				break;
			}
		}
		return result;
	}
	
	public boolean isCardNumberValid(String cardNumber) {
		boolean result = true;
		for (char c : cardNumber.toCharArray()) {
			if (!Character.isDigit(c)) {
				result = false;
				break;
			}
		}
		return result;
	}
	
	public Map<String, String> getPaymentData() {
		Map<String, String> paymentData = new LinkedHashMap<>();
		if (!isCardHolderNameEmpty()) {
			paymentData.put("Card Holder", cardHolderName);
			if (!isCardNumberEmpty()) {
				paymentData.put("Card Number", cardNumber);
			}
		}
		return paymentData;
	}
	
	public void clear() {
		cardHolderName = "";
		cardNumber = "";
		amountPayed = 0;
	}
}
