package com.gojava6.airbnb.administration;

import com.gojava6.airbnb.model.user.User;
import com.gojava6.airbnb.model.apartment.Apartment;
import com.gojava6.airbnb.model.apartment.CityType;
import com.gojava6.airbnb.model.user.*;

import java.util.LinkedList;
import java.util.List;

public class AdministrativeManager implements Subject {

    //todo smth with subject

//    List<Renter> renterList = new LinkedList<Renter>();
//    List<Host> hostList = new LinkedList<Host>();
//
//    public void addUserInList(User user) {
//        if (user instanceof Renter && !renterList.contains(user)) {
//            renterList.add((Renter) user);
//        } else if (user instanceof Host && !hostList.contains(user)) {
//            hostList.add((Host) user);
//        }
//    }
//
//    public void deleteUserFromList(User user) {
//        if (user instanceof Renter) {
//            renterList.remove(user);
//        } else if (user instanceof Host) {
//            hostList.remove(user);
//        }
//    }
//
//    public void updateUser(User user) {
//        if (user instanceof Renter) {
//            for (int i = 0; i < renterList.size(); i++) {
//                if (!renterList.get(i).equals(user)) {
//                    renterList.set(i, (Renter) user);
//                }
//            }
//        } else if (user instanceof Host) {
//            for (int i = 0; i < hostList.size(); i++) {
//                if (!hostList.get(i).equals(user)) {
//                    hostList.set(i, (Host) user);
//                }
//            }
//        }
//    }
//
//    public void printRenters() {
//        for (Renter renter : renterList) {
//            System.out.println("Renter: " + renter);
//        }
//    }
//
//    public void printHosts() {
//        for (Host host : hostList) {
//            System.out.println("Host: " + host);
//        }
//    }
//
//    public void printAllUsers() {
//        for (Host host : hostList) {
//            System.out.println("Host: " + host);
//        }
//        for (Renter renter : renterList) {
//            System.out.println("Renter: " + renter);
//        }
//    }
//
//    public static User becomeHost(Renter renter, CityType city, Apartment apartment) {
//        User result = renter;
//        return result;
//    }

    public void notifyAllObservers() {

    }

    public void notifyAllRenters() {

    }

    public void notifyAllHosts() {

    }
}
