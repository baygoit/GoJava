package com.gojava6.airbnb.spring.serviceSpring;

import com.gojava6.airbnb.spring.modelSpring.User;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UserValidatorService implements Validator {

    private static final String USERNAME_PATTERN = "^[a-zA-Z-]$";
    private static final String USERSURNAME_PATTERN = "^[a-zA-Z-]$";
    private static final String EMAIL_PATTERN = "^[a-zA-Z@.]$";
    private static final String CITY_PATTERN = "^[a-zA-Z-]+$";

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "user.userName.isEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userSurname", "user.userSurname.isEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "user.email.isEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userCity", "user.userCity.isEmpty");

        if(!user.getUserName().matches(USERNAME_PATTERN)){
            errors.rejectValue("userName", "user.userName.inValid");
        }
        if(!user.getUserSurname().matches(USERSURNAME_PATTERN)){
            errors.rejectValue("userSurname", "user.userSurname.inValid");
        }
        if(!user.getEmail().matches(EMAIL_PATTERN)){
            errors.rejectValue("email", "user.email.inValid");
        }
        if(!user.getUserCity().matches(CITY_PATTERN)){
            errors.rejectValue("userCity", "user.userCity.inValid");
        }
    }
}
