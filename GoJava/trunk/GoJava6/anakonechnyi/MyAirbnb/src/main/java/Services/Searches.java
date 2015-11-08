package main.java.Services;

import main.java.Models.Apartment;
import main.java.Models.User;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by user on 26.09.2015.
 */
public class Searches {
    public static LinkedList<User> hostList;

    public List<Apartment> getAll(){
        List<Apartment> allApartmentList = new LinkedList<Apartment>();
        for (User host : hostList) {
            for (Apartment apartmentOneHost : host.apartments) {
                allApartmentList.add(apartmentOneHost);
            }
        }
        return allApartmentList;
    }

    public LinkedList<Apartment> searchAvailableAtDate(Date dateToCheck, LinkedList <Apartment> listForSearch) {
        LinkedList<Apartment> result = new LinkedList<Apartment>();
        for (Apartment toCheck : listForSearch) {
                if (toCheck.isAvailable(dateToCheck)){
                    result.add(toCheck);
                }
        }
        return result;
    }
    public LinkedList<Apartment> searchAvailableAtCity(String cityToCheck, LinkedList <Apartment> listForSearch) {
        LinkedList<Apartment> result = new LinkedList<Apartment>();
        for (Apartment toCheck : listForSearch) {
            if (toCheck.getCity().equals(cityToCheck)){
                result.add(toCheck);
            }
        }
        return result;
    }
    //TODO another searches like this
}
