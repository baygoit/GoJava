package MyAirBnB.Model;
import MyAirBnB.Enum.ApartmentType;
import MyAirBnB.Interfaces.Observer;
import MyAirBnB.Validation.Validation;

import java.util.Date;

/**
 * Created by macmini on 20.09.15.
 */
public class User implements Observer {

    protected String name;
    protected String surname;
    protected final String mail;

    @Override
    public String toString() {

        return "i am user" + " " + name;
    }

    private enum Status {CLIENT, HOST};

    private Status myStatus = Status.CLIENT;

    public User(String mail, String surname, String name) {

        this.mail = mail;
        this.surname = surname;
        this.name = name;
    }


    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getSurname() {

        return surname;
    }

    public void setSurname(String surname) {

        this.surname = surname;
    }

    public String getMail() {

        return mail;
    }

    @Override
    public void update(String message) {
        System.out.println("Hello!" + getName()+" "+ message);

    }

    // Host
    public boolean createApartment(String city, ApartmentType apartType, String address) {

        if (myStatus == Status.CLIENT) {
            return false; // не регистрировать
        }
        Apartment apartment = new Apartment(city, apartType, address);
        Validation v = new Validation();
        if (v.validateApartment(apartment)) {
            return true;
        } else {
            return false;
        }
    }


    //Client
    public boolean reserveApartment(Apartment apartment, Date start, Date end) {

        if (myStatus == Status.HOST){
            return false;
        }
        apartment.makeReservation(start, end);
        return true;
    }
}
// из клиента сделать хоста