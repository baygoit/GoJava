package gojava.services;

import gojava.dao.ApartmentDAO;
import gojava.dao.CityDAO;
import gojava.model.Apartment;
import gojava.model.City;
import gojava.model.User;

import java.sql.SQLException;

/**
 * Created by root on 17.11.15.
 */
public class ApartmentService {

    ApartmentDAO apartmentDAO = new ApartmentDAO();
    CityDAO cityDAO = new CityDAO();

    public void registerApartment(User user, Apartment apartment, City city) throws SQLException {

        /*if (cityDAO.isUnique(city) && isValidName(city.getCityName())) {
            cityDAO.create(city);
            System.out.println(city.toString() + "WAS CREATED");
        }*/

        apartment.setCityName(city.getCityName());
        apartment.setHostId(user.getId());

        /*if (apartmentDAO.create(apartment)) {
            System.out.println(apartment.toString());
            System.out.println("was successfully registered by");
            System.out.println(user.toString());


        }*/

    }

}
