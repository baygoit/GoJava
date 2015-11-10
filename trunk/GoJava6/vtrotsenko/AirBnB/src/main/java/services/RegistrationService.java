package services;

import dao.ApartmentDAO;
import dao.UserDAO;
import enums.ApartmentType;
import enums.UserType;
import model.Apartment;
import model.User;

import java.time.LocalDate;

import static validation.Validation.*;

/**
 * Created by root on 04.11.15.
 */
public class RegistrationService {

    public void registerUser(UserDAO userDao, User user) {

        if (user.getUserType().equals(UserType.CLIENT) &&
                isValidId(user.getId()) &&
                isValidName(user.getName()) &&
                isValidName(user.getLastname()) &&
                isValidEmail(user.getEmail())) {

            //registerObserver(user);
            user.setIsRegisteredAsClient(true);
            userDao.create(user);
        }

        else {}
    }


    /*public void becomeHost(User user, String city, Integer idApartment, ApartmentType apartmentType,
                           LocalDate start, LocalDate end) {

        if (isRegisteredAsClient() &&
                isValidName(city) &&
                isValidApartmentType(apartmentType) &&
                isValidDate(start, end)) {
            setUserType(UserType.HOST);
            setIsRegisteredAsHost(true);
            setCity(city);
            Apartment apartment = new Apartment(idApartment, apartmentType, start, end);
            //addApartment(apartment);
            //aS.addCity(this);
            Log.logger.info(" -- " + getName() + " " + getLastname() + " became HOST!");
        }

        else {
            Log.logger.info(" -- " + getName() + " " + getLastname() + " FAILED becoming HOST :(");
        }
    }*/


    public void registerApartment(ApartmentDAO apartmentDao, User user, Integer idApartment,
                                  ApartmentType apartmentType, LocalDate start, LocalDate end) {

        Apartment apartment = new Apartment(idApartment, apartmentType, start, end, user.getId());
        //addApartment(apartment);4
        apartmentDao.create(apartment);

    }

}
