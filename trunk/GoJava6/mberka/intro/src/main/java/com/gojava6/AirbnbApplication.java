package com.gojava6;

import com.gojava6.dao.AptDAO;
import com.gojava6.dao.UserDAO;
import com.gojava6.model.ApartmentType;
import com.gojava6.model.User;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;

public class AirbnbApplication {

    public static void main(String[] args) {
        User user1 = new User("Marlene", "Dietrich", "marlene@dietrich.com", "Berlin");
        //System.out.println("User is host: " + user1.isHostUser());

        UserDAO userDAO = new UserDAO();
        AptDAO aptDAO = new AptDAO();
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
