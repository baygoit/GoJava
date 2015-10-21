package model;

import java.util.Date;

public class User {
    private static int USER_ID = 0;
    private int id;
    private int externalCode;
    private String name;
    private String lastName;
    private GenderType gender;
    private Date birthDate;
    private String email;
    private CityList city;
    private String country;
    private boolean isHost;

    public User() {
    }

    public User(int externalCode, String name, String lastName, GenderType gender, Date birthDate, String email, CityList city) {
        this.externalCode = externalCode;
        this.name = name;
        this.lastName = lastName;
        this.gender = gender;
        this.birthDate = birthDate;
        this.email = email;
        this.city = city;
        this.isHost = false;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getExternalCode() {
        return externalCode;
    }

    public void setExternalCode(int externalCode) {
        this.externalCode = externalCode;
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

    public void setCity(CityList city) {
        this.city = city;
    }

    public void setCountry(String country) {
        this.country = country;
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

    public CityList getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public boolean isHost() {
        return isHost;
    }

    public void setHost(boolean isHost) {
        this.isHost = isHost;
    }

    @Override
    public String toString() {
        return "User{" +
                "external code='" + externalCode + '\'' +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
