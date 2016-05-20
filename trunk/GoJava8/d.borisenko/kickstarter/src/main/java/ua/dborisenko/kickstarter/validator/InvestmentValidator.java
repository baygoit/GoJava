package ua.dborisenko.kickstarter.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.dborisenko.kickstarter.domain.Investment;

public class InvestmentValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Investment.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "cardHolderName", "warning.emptyString");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "cardNumber", "warning.emptyString");
        Investment investment = (Investment) target;
        if (investment.getAmount() <= 0) {
            errors.rejectValue("amount", "warning.nonPositive");
        }
    }

}