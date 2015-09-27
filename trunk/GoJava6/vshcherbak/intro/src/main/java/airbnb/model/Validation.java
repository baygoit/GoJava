package airbnb.model;

/**
 * Created by slavik on 26.09.15.
 */
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {
    private static String nameValidation =
            "([A-Z][a-z]{1,39})(-([A-Z][a-z]{1,39}))*";
    private static String emailValidation =
            "([a-z0-9]+([-.]?[a-z0-9])*)@(([a-z](-?[a-z0-9])*){1,39}\\.[a-z]{2,6})";
    private static String cityValidation =
            "([A-Z][a-z]{1,39})(-?([A-Z][a-z]{1,39}))*";

    public static boolean validateName(String name) {
        return validateString(nameValidation, name);
    }

    public static boolean validateSurname(String surname) {
        return validateString(nameValidation, surname);
    }

    public static boolean validateEmail(String email) {
        return validateString(emailValidation, email);
    }

    public static boolean validateCity(String city) {
        return validateString(cityValidation, city);
    }

    private static boolean validateString(String patternString, String value) {
        if (value == null) return false;
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(value);
        return matcher.matches();
    }
}
