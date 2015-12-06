package model;

import enums.UserType;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by root on 04.11.15.
 */
@Entity
@Table(name = "User")
public class User extends AbstractEntity {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name="id", nullable = false, unique = true)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "email")
    private String email;

    @Transient
    private String city;

    @Column(name = "password")
    private String password;

    @Transient
    private UserType userType;
    @Transient
    private boolean isRegisteredAsClient;

    @Column(name = "isHost")
    private boolean isRegisteredAsHost;

    //TODO: Implement logic
    @Transient
    private Set<Apartment> listOfApartments = new HashSet<Apartment>();

    //  constructor for CLIENT
    public User() {}
    public User(String name, String password, String lastname, String email) {
        this.name = name;
        this.password = password;
        this.lastname = lastname;
        this.email = email;
        this.isRegisteredAsHost = false;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
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
