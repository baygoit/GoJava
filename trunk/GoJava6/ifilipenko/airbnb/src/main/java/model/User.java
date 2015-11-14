package model;

import common.Observer;
import model.enums.CityList;
import model.enums.GenderType;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "users")
public class User implements Observer, Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String name;
    private String lastName;
    private GenderType gender;
    private Date birthDate;
    private String email;
    private CityList cityEnum;

    public User() {
    }

    public User(String name, String lastName, GenderType gender, Date birthDate, String email, CityList city) {
        this.name = name;
        this.lastName = lastName;
        this.gender = gender;
        this.birthDate = birthDate;
        this.email = email;
        this.cityEnum = city;
    }

    //===============getters======================
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id")
    public int getId() {
        return id;
    }

    @Column(name = "firstname")
    public String getName() {
        return name;
    }

    @Column(name = "lastname")
    public String getLastName() {
        return lastName;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    public GenderType getGender() {
        return gender;
    }


    @Type(type="timestamp")
    @Column(name = "birthdate")
    public Date getBirthDate() {
        return birthDate;
    }

    @Column(name = "emailaddress")
    public String getEmail() {
        return email;
    }

    @Column(name = "city")
    public CityList getCityEnum() {
        return cityEnum;
    }

    //===============setters======================
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setGender(GenderType gender) {
        this.gender = gender;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCityEnum(CityList city) {
        this.cityEnum = city;
    }


    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    @Override
    public void notifyObserver(String s) {

    }
}
