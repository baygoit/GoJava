package com.kickstarter.beanVO;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class PayerVO {
	@NotNull
	@Min(value=0, message = "only positive values !" )
	@Digits(fraction = 0, integer = 6, message ="Max size is 6 digits")
	private int paymentAmount;
	@Size(min = 3, max = 20 )
	@NotNull
	private String CardHolderName;
	@NotNull
	@Min(value=0, message = "only positive values !" )
	@Digits(fraction = 0, integer = 12, message ="Max size is 12 digits")
	private int cardNumber;

	public int getPaymentAmount() {
		return paymentAmount;
	}

	public void setPaymentAmount(int paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

	public String getCardHolderName() {
		return CardHolderName;
	}

	public void setCardHolderName(String cardHolderName) {
		CardHolderName = cardHolderName;
	}

	public int getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(int cardNumber) {
		this.cardNumber = cardNumber;
	}

}
