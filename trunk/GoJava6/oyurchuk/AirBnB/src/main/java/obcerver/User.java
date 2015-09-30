package obcerver;
import java.util.Date;

/**
 * Created by macmini on 20.09.15.
 */
public class User implements Observer {

    protected String name;
    protected String surname;
    protected final String mail;
    private enum Status  {CLIENT, HOST};
    private Status myStatus = Status.CLIENT;

    public User(String name, String surname, String mail) {

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
        System.out.println("Hello!" + getName());

    }

    public boolean createApartment(String city, ApartmentType apartType, String address) {

        if (myStatus == Status.CLIENT){
            return false;
        }
        Apartment apartment = new Apartment(city, apartType, address);
        Validation v = new Validation();
        if (v.validateApartment(apartment)) {
            return true;
        } else {
            return false;
        }
    }

    public void reservApartment (Apartment apartment, Date start, Date end){

        apartment.makeReservation(start,end);

    }
}

// из клиента сделать хоста