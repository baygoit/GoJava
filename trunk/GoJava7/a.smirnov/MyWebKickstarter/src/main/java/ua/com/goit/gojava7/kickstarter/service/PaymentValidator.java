package ua.com.goit.gojava7.kickstarter.service;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import ua.com.goit.gojava7.kickstarter.beans.Payment;

@Component
public class PaymentValidator implements Validator {
	@Override
	public boolean supports(Class<?> clazz) {
		return Payment.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO
	}
}
