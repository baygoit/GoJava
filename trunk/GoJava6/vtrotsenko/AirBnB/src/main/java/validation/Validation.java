package validation;

import enums.ApartmentType;
import enums.UserType;
import model.Apartment;

import java.time.LocalDate;

/**
 * Created by root on 04.11.15.
 */
public class Validation {

    public static boolean isValidUserType(UserType userType) {

        UserType[] userTypes = UserType.values();
        for (UserType userType1 : userTypes) {
            if (userType.equals(userType1))
                return true;
        }
        return false;
    }

    public static boolean isValidName(String name) {

        if(name != null && !consistDigits(name)) {
            return true;
        }

        return false;
    }

    // TODO : Add InternetAdress class to validate email better
    public static boolean isValidEmail(String email) {

        if(email != null && email.contains("@gmail.com"))
            return true;

        else {
            return false;
        }
    }

    public static boolean isValidApartmentType(ApartmentType apartmentType) {

        ApartmentType[] apartmentTypes = ApartmentType.values();
        for (ApartmentType apartmentType1 : apartmentTypes) {
            if (apartmentType.equals(apartmentType1))
                return true;
        }
        return false;
    }

    public static boolean isValidDate(LocalDate startDate, LocalDate endDate) {

        if (startDate.compareTo(endDate) > 0) {
            return false;
        }
        return true;
    }

    public static boolean isValidReservationDate(Apartment apartment, LocalDate startDate, LocalDate endDate) {

        if ((startDate.compareTo(apartment.getFirstDayAvailable()) < 0) ||
                (endDate.compareTo(apartment.getLastDayAvailable()) > 0)) {
            return false;
        }
        return true;
    }

    // method to check whether some string consist Numbers or not
    private static boolean consistDigits(String str) {

        if(str.matches(".*\\d.*")){
            return true;
        } else{
            return false;
        }
    }
}