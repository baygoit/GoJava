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
    @Transient
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id")
    private int id;

    @Column(name = "firstname")
    private String name;

    @Transient
    @Column(name = "lastname")
    private String lastName;

    @Transient
    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    private GenderType gender;

    @Transient
    @Type(type="timestamp")
    @Column(name = "birthdate")
    private Date birthDate;

    @Transient
    @Column(name = "emailaddress")
    private String email;

    @Transient
    @Column(name = "city")
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

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public GenderType getGender() {
        return gender;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public String getEmail() {
        return email;
    }

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
