package com.gojava6;

import com.gojava6.airbnb.dao.ApartmentDAO;
import com.gojava6.airbnb.dao.UserDAO;
import com.gojava6.airbnb.model.User;

import java.text.SimpleDateFormat;

public class AirbnbApplication {

    public static void main(String[] args) {
        User user1 = new User("Marlene", "Dietrich", "marlene@dietrich.com", "Berlin");
        //System.out.println("User is host: " + user1.isHostUser());

        UserDAO userDAO = new UserDAO();
        ApartmentDAO aptDAO = new ApartmentDAO();
        //userDAO.addNewUser(user1);

        SimpleDateFormat format = new SimpleDateFormat("MM-dd-yyyy");

        //aptDAO.addNewApartment(5, "London", "Flat", sqlStartDate, sqlEndDate);

        //userDAO.findUserIdByEmail("yoko@ono.com");
        //userDAO.findUserById(56);

        //userDAO.deleteUserByNameSurname("Marlene", "Dietrich");

        //userDAO.getAllUsers();

        System.out.println(aptDAO.getAllAptCities());

        System.out.println(aptDAO.getAllApartments());

    }
}
