package com.anmertrix.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.anmertrix.domain.Payment;

public class PaymentValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Payment.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Payment payment = (Payment) target;

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "cardholderName", "required-cardholderName", "Enter card holder name");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "cardNumber", "required-cardNumber", "Enter card number");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "amount", "required-amount", "Enter card number");

		String cardholderName = payment.getCardholderName().trim()
				.replace("&", "&amp;").replace("<", "&lt;").replace(">", "&gt;");
		if (cardholderName.length() < 2 || cardholderName.length() > 50) {
			errors.rejectValue("cardholderName", "required-cardholderName", "Enter Name length 2 - 50 chars");
		}
		
		String cardNumber = payment.getCardNumber();
		if (cardNumber.length() < 13 || cardNumber.length() > 16 || !cardNumber.matches("^-?\\d+$")) {
			errors.rejectValue("cardNumber", "required-cardNumber", "Enter Card Number length 13 - 16 numbers");
		}
		
		if (payment.getAmount() <= 0 || payment.getAmount() > 1000000) {
			errors.rejectValue("amount", "required-amount", "Enter positive amount, but not more 1000000");
		}
		
	}

}
