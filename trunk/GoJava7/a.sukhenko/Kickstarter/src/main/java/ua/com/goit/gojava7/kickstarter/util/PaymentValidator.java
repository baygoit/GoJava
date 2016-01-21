package ua.com.goit.gojava7.kickstarter.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

import ua.com.goit.gojava7.kickstarter.model.vo.PaymentVO;
@Component
public class PaymentValidator implements org.springframework.validation.Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		 return PaymentVO.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "amount", "error.amount","Amount cannot be empty.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "cardName", "error.cardName","Card name cannot be empty.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "cardNumber", "error.cardNumber","Card number cannot be empty.");
		validatePayment(target, errors);
		
	}
	
	public void validatePayment(Object target, Errors errors) {
		PaymentVO paymentVO = (PaymentVO) target;
        if(!validateName(paymentVO.getCardOwner())){
        	errors.rejectValue("cardOwner", "error.cardOwner", "Invalid card owner name.");
        }
        if(!validateCard(paymentVO.getCardNumber())){
        	errors.rejectValue("cardNumber", "error.cardNumber", "Invalid card number.");
        }
        if(!validateAmountOfPledge(paymentVO.getAmount())){
        	errors.rejectValue("amount", "error.amount", "Invalid amount.");
        }
    }

    public boolean validateName(String name) {
        Pattern p = Pattern.compile("^[\\p{L} .'-]+$");
        Matcher m = p.matcher(name);
        return m.matches();
    }
    
    public boolean validateAmountOfPledge(long amount) {
    	String stringAmount = String.valueOf(amount);
        Pattern p = Pattern.compile("^[1-9]{1,10}$");
        Matcher m = p.matcher(stringAmount);
        return m.matches();
    }
    
    public boolean validateCard(String card) {
        Pattern p = Pattern.compile("^[0-9]{16}$");
        Matcher m = p.matcher(card);
        return m.matches();
    }
	
}
