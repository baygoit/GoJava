package com.Airbnb.app;
import com.Airbnb.app.DAO.ApartmentDAOimpl;
import com.Airbnb.app.DAO.UserDAOimpl;
import com.Airbnb.app.model.Apartment;
import com.Airbnb.app.common.Observer;
import com.Airbnb.app.common.Subject;
import com.Airbnb.app.model.*;
import com.Airbnb.app.Maps;
import com.Airbnb.app.DAO.UserDAO;
import com.Airbnb.app.DAO.ApartmentDAO;

import java.util.*;
import java.util.List;

/**
 * Created by romanroma on 26.09.15.
 */
public class AirbnbController implements Subject {

    private UserDAO userDAO = new UserDAOimpl();
    private ApartmentDAO apartmentDAO = new ApartmentDAOimpl();

    public void registerClient (String name, String surname, String email){
        User client = new User(name, surname, email);
        if (client.validation()) {
            userDAO.registerClient(client);
        }
        else System.out.println("Please enter valid data");
    }

    public void registerHost (String name, String surname, String email){
        User host = new User(name, surname, email);
        if (host.validation()) {
            userDAO.registerHost(host);
        }
        else System.out.println("Please enter valid data");
    }



    public void removeClient (int id){

        userDAO.deleteClient(id);
    }

    public void removeHost (int id){

        userDAO.deleteHost(id);
    }

    public void notifyAll (String message){
        List<User> list = userDAO.getAllClients();
        for (User user: list){
            user.update(message);
        }
    }

    public int createApartment (int hostId, String city, ApartType apartType, boolean reserved){
        if (hostId<1) {
            return -1;
        }

        User host = Maps.hosts.get(hostId);
        if (host == null){
            return -1;
        }

        Apartment apartment = new Apartment(host,city,apartType,reserved);
        if (apartment.validation()){
            apartmentDAO.saveApartment(apartment);
            return apartment.getId();
        }
        return -1;
    }

    public static void main( String[] args ) {

        AirbnbController airbnbController = new AirbnbController();

        airbnbController.registerClient("Max", "Mad", "email@gmail.com");
        airbnbController.registerClient("Roman","Iovenko","email2@gmail.com");
        airbnbController.registerHost("Vova", "New", "email3@gmail.com");
        airbnbController.registerHost("Sasha", "Prime", "email4@gmail.com");
        airbnbController.createApartment(1, "Kyiv", ApartType.ROOM, false);
        airbnbController.notifyAll("Done");
        airbnbController.removeClient(1);

    }


}
