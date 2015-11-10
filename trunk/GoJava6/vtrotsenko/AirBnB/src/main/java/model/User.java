package model;

import enums.UserType;
import observer.Observer;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by root on 04.11.15.
 */
public class User extends Entity implements Observer {

    private String name;
    private String lastname;
    private String email;
    private String city;
    private String password;
    private UserType userType;
    private boolean isRegisteredAsClient;
    private boolean isRegisteredAsHost;

    private Set<Apartment> listOfApartments = new HashSet<Apartment>();

    //  constructor for CLIENT
    public User() {}
    public User(Integer id, String name, String password, String lastname, String email) {
        super(id);
        this.name = name;
        this.password = password;
        this.lastname = lastname;
        this.email = email;
        this.isRegisteredAsHost = false;
    }

    public boolean isRegisteredAsHost() {
        return isRegisteredAsHost;
    }

    public void setIsRegisteredAsHost(boolean isRegisteredAsHost) {
        this.isRegisteredAsHost = isRegisteredAsHost;
    }

    public boolean isRegisteredAsClient() {
        return isRegisteredAsClient;
    }

    public void setIsRegisteredAsClient(boolean isRegisteredAsClient) {
        this.isRegisteredAsClient = isRegisteredAsClient;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public Set<Apartment> getListOfApartments() {
        return listOfApartments;
    }

    public void setListOfApartments(Set<Apartment> listOfApartments) {
        this.listOfApartments = listOfApartments;
    }

    public void addApartment(Apartment apartment) {
        listOfApartments.add(apartment);
    }

    public void removeApartment(Integer idApartment) {
        listOfApartments.remove(idApartment);
    }

    public void update(String s) {
        java.lang.System.out.println(s);
    }

    public Apartment getApartment(Integer idApartment) {
        for (Apartment apartment : listOfApartments) {
            if (apartment.getId() == idApartment) {
                return apartment;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return ("User [id=" + this.getId() + ", password= " + this.getPassword() +
                ", name=" + this.name + ", lastname=" + this.lastname +
                ", email=" + this.email + "]");
    }
}
