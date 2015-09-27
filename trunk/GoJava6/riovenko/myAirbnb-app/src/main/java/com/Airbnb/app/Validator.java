package com.Airbnb.app;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * Created by romanroma on 26.09.15.
 */
public class Validator {

    private static Pattern userNamePtrn = Pattern.compile("([A-Z][a-z]{1,39})(-([A-Z][a-z]{1,39}))*");
    private static Pattern userCityPtrn = Pattern.compile("([A-Z][a-z]{1,39})(-?([A-Z][a-z]{1,39}))*");
    private static Pattern userEmailPtrn = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

    public static boolean validateUserName (String userName) {
        return validate(userNamePtrn, userName);
    }

    public static boolean validateUserSurname (String userSurname) {
        return validate(userNamePtrn, userSurname);
    }

    public static boolean validateUserCity (String userCity) {
        return validate(userCityPtrn, userCity);
    }

    public static boolean validateUserEmail (String userEmail) {
        return validate(userEmailPtrn, userEmail);
    }

    public static boolean validate (Pattern stringPattern,String value){
        Matcher mtch = stringPattern.matcher(value);
        if (mtch.matches()){
            return true;
        }
        return false;
       // return true;
    }

}
