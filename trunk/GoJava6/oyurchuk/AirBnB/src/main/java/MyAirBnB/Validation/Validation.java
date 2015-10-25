package MyAirBnB.Validation;

/**
 * Created by macmini on 20.09.15.
 */


    import MyAirBnB.Model.Apartment;

    import java.util.regex.Matcher;
    import java.util.regex.Pattern;


public class Validation {
    private static Validation validator;
    public Validation(){

    }
    public static Validation getInstance(){
        if (validator!=null) {
            return validator;
        }
        else return new Validation();
    }


        //public boolean validateApartment(Apartment apartment) {

            //return true



        //TODO город не содержит чисел и (аппартмент принимает значение одно из 3-х  использовать команду: instanceof)


        public static String nameValidationPatternString =
                "([A-Z][a-z]{1,39})(-([A-Z][a-z]{1,39}))*";
        private static String emailValidationPatternString =
                "([a-z0-9]+([-.]?[a-z0-9])*)@(([a-z](-?[a-z0-9])*){1,40}\\.[a-z]{2,6})";
        private static String cityValidationPatternString =
                "([A-Z][a-z]{1,39})(-?([A-Z][a-z]{1,39}))*";
        private static String apartmentValidationPatternString =
                "([A-Z][a-z]{1,39})(-([A-Z][a-z]{1,39}))*";



        public static boolean validateName(String name) {
            return validateString(nameValidationPatternString, name);
        }

        public static boolean validateSurname(String surname) {
            return validateString(nameValidationPatternString, surname);
        }

        public static boolean validateEmail(String email) {
            return validateString(emailValidationPatternString, email);
        }

        public static boolean validateCity(String city) {
            return validateString(cityValidationPatternString, city);
        }

        public static boolean validateApartment(Apartment apartment){
            return validateString(apartmentValidationPatternString, apartment.getApartmentType().toString());
            //return validate (Validation.apartmentValidationPatternString, apartment);
        }



    private static boolean validateString(String patternString, String value) {
            if (value == null) return false;

            Pattern pattern = Pattern.compile(patternString);
            Matcher matcher = pattern.matcher(value);

            return matcher.matches();
        }


}





