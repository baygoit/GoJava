package com.gojava6.airbnb.validation;

import com.gojava6.airbnb.Exception.UserValidationException;
import com.gojava6.airbnb.model.apartment.Apartment;
import com.gojava6.airbnb.model.apartment.ApartmentType;
import com.gojava6.airbnb.model.apartment.CityType;

import java.util.regex.*;

public class UserValidation {

    private static Pattern PATTERN;
    private static Matcher MATCHER;

    public static boolean validationRenter(String name, String surname, String eMail) throws UserValidationException {
        if (validationFullName(name) && validationFullName(surname) && validationEMail(eMail)) {
            return true;
        }
        return false;
    }

    public static boolean validationFullName(String firstName) throws UserValidationException {
        if (firstName != null) {
            PATTERN = Pattern.compile("[A-Za-z]*");
            MATCHER = PATTERN.matcher(firstName);
            if (!firstName.isEmpty()) {
                if (MATCHER.matches()) {
                    return true;
                }
            }
        }
        throw new UserValidationException("Incorrect user name");
    }

    public static boolean validationEMail(String eMail) throws UserValidationException {
        if (eMail != null && !eMail.isEmpty()) {
            PATTERN = Pattern.compile("^[A-z0-9-_\\.]+@([\\w]+\\.)+[A-z]{2,4}$");
            MATCHER = PATTERN.matcher(eMail);
            if (MATCHER.matches()) {
                return true;

            }
        }
        throw new UserValidationException("Incorrect user e-Mail");
    }

    public static boolean validationCity(CityType city) throws UserValidationException {

        if (city instanceof CityType) {
            return true;
        }
        throw new UserValidationException("Incorrect city type.");
    }

    public static boolean validationApartmentType(Apartment apartment) throws UserValidationException {

        if (apartment.getApartmentType() instanceof ApartmentType) {
            return true;
        }
        throw new UserValidationException("Incorrect apartment type.");
    }
}
