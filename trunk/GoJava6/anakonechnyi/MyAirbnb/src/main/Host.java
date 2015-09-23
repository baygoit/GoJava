package main;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

/**
 * Created by user on 19.09.2015.
 */
public class Host extends User implements Subject {
    private String city;
    public enum ApartmentType {PLACE , ROOM, APARTMENT};
    public ApartmentType apartmentType;
    public String switchedApartType;
    private List<Observer> listOfClients = new ArrayList<Observer>();
    public Host (String name, String sername, String email) {
        if (this.setName(name)&&this.setSername(sername)&&this.setEmail(email)) {
            System.out.println("Successful Host registration");
        } else {
            throw new InputMismatchException();
        }
    }


    @Override
    public void registerObserver(Observer o) {//to check (super of host or client)
        System.out.println("Register: " + o.toString());
        listOfClients.add(o);
        o.loyalty(10, this);
    }

    @Override
    public void removeObserver(Observer o) {
        System.out.println("Remove: "+super.getName()+" "+super.getSername());
        listOfClients.remove(o);
    }

    @Override
    public void notifyObservers() {
        System.out.println("Notify Observers");
        for (Observer obs :listOfClients) {
            obs.update(this);//this host
        }

    }
    @Override
    public String toString(){
        return this.switchedApartType+" from "+this.getName()+" in "+this.getCity();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

   /* public String getApartmentType() {
        return apartmentType;
    }*/

    /*public void setApartmentType(String apartmentType) {
        this.apartmentType = apartmentType;
    }*/
}
