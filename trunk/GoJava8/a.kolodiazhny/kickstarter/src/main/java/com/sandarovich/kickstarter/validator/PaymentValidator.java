package com.sandarovich.kickstarter.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.sandarovich.kickstarter.dto.PaymentForm;

public class PaymentValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return PaymentForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		PaymentForm paymentForm = (PaymentForm) target;

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "cardHolder", "required-card-holder", "Enter card holder name");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "cardNumber", "required-card-number", "Enter card number");

		if (paymentForm.getAmount() <= 0) {
			errors.rejectValue("amount", "required-positive-amount", "Enter positive amount");
		}
	}

}
