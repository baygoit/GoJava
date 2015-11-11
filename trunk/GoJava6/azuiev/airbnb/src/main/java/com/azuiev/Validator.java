package com.azuiev;

import com.azuiev.enums.ApartType;
import com.azuiev.model.Apartment;
import com.azuiev.model.User;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Lera on 21.09.2015.
 */
public class Validator {
    private static Validator validator;
    private Validator(){
    }

    public static Validator getInstance(){

        if (validator==null) {
            validator = new Validator();
        }

        return validator;
    }

    public boolean validateUser(User user) {
        Boolean result;
        result = validate(user);
        return result;
    }

    public boolean validateApartment(Apartment apartment) {
        return validateCity(apartment.getCity().getName())&&validateApartType(apartment.getApartType());
    }

    private boolean validate(User user) {
        return validateName(user.getName())&&validateSurname(user.getSurName())&&validateEmail(user.getEmail());
    }

    private boolean validateName(String name) {
        return validateString(name,"[a-zA-Z]{2}[a-zA-Z]*");
    }

    private boolean validateSurname(String surName) {
        return validateString(surName,"[a-zA-Z]{2}[a-zA-Z]*");
    }

    private boolean validateEmail(String email) {
        return validateString(email,"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
    }

    private boolean validateCity(String city) {
        return validateString(city,"[a-zA-Z]{1}[a-zA-Z]*");
    }

    private boolean validateApartType(ApartType apartmentType) {
        return (apartmentType instanceof ApartType);
    }

    private boolean validateString(String string, String pattern) {
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(string);
        return m.matches();
    }


}
