package ua.dborisenko.kickstarter.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.dborisenko.kickstarter.domain.Question;

public class QuestionValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Question.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "request", "warning.emptyString");
    }

}