package ua.com.goit.gojava7.kickstarter.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

import ua.com.goit.gojava7.kickstarter.model.Payment;
@Repository
public class PaymentValidator implements org.springframework.validation.Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		 return Payment.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "amount", "error.amount","Amount cannot be empty.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "cardOwner", "error.cardOwner","Card owner cannot be empty.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "cardNumber", "error.cardNumber","Card number cannot be empty.");
		validatePayment(target, errors);
		
	}
	
	public void validatePayment(Object target, Errors errors) {
		Payment payment = (Payment) target;
        if(!validateName(payment.getCardOwner())){
        	errors.rejectValue("cardOwner", "error.cardOwner_invalid", "Invalid card owner name.");
        }
        if(!validateCard(payment.getCardNumber())){
        	errors.rejectValue("cardNumber", "error.cardNumber_invalid", "Invalid card number.");
        }
        if(!validateAmountOfPledge(payment.getAmount())){
        	errors.rejectValue("amount", "error.amount_invalid", "Invalid amount.");
        }
    }

    public boolean validateName(String name) {
        Pattern p = Pattern.compile("^[\\p{L} .'-]+$");
        Matcher m = p.matcher(name);
        return m.matches();
    }
    
    public boolean validateAmountOfPledge(String amount) {
    	//String stringAmount = String.valueOf(amount);
        Pattern p = Pattern.compile("^[1-9]{1,10}$");
        Matcher m = p.matcher(amount);
        return m.matches();
    }
    
    public boolean validateCard(String card) {
        Pattern p = Pattern.compile("^[0-9]{16}$");
        Matcher m = p.matcher(card);
        return m.matches();
    }
	
}
