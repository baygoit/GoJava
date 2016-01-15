package com.gojava6.modelHibernate;

import com.gojava6.observer.Validation;
import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "User")
public class User {
    @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "idUser")
    private int idUser;
    @Column
    /*NEAR FIELD OR GETTER*/
    private String userName;
    @Column
    private String userSurname;
    @Column
    private String email;
    @Column
    private String userCity;
    @Column
    private boolean hostUser;

    //@Column
    //VALUE-OBJECT INSIDE ENTITY
    /*@Column
    @ElementCollection (fetch = FetchType.EAGER)
    @JoinTable(name = "User_apartments",
            joinColumns = @JoinColumn(name = "User_ID"))
    @GenericGenerator(name = "increment-generator", strategy = "increment")
    @CollectionId(columns = @Column(name = "apartment_id"),
            generator = "increment-generator",
            type = @Type(type = "long"))*/
    @OneToMany(mappedBy = "user", cascade = CascadeType.PERSIST)
    private List<Apartment> apartment = new ArrayList<>();
    /*@Transient *//*Transient will IGNORE this field*//*
    @Temporal(TemporalType.TIMESTAMP)
    private Date dayOfRegistration;*/

    public User() {
    }

    public User(String userName, String userSurname, String email, String userCity) {
        this.userName = userName;
        this.userSurname = userSurname;
        this.email = email;
        this.userCity = userCity;
        this.hostUser = false;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public boolean isHostUser() {
        return hostUser;
    }

    public void setHostUser(boolean hostUser) {
        this.hostUser = hostUser;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        if (Validation.getValidation().validUserName(userName)) {
            this.userName = userName;
        }
    }

    public String getUserSurname() {
        return userSurname;
    }

    public void setUserSurname(String userSurname) {
        if (Validation.getValidation().validUserSurname(userSurname)) {
            this.userSurname = userSurname;
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (Validation.getValidation().validEmail(email)) {
            this.email = email;
        }
    }

    public String getUserCity() {
        return userCity;
    }

    public void setUserCity(String userCity) {
        if (Validation.getValidation().validCityName(userCity)) {
            this.userCity = userCity;
        }
    }

    public List<Apartment> getApartment() {
        return apartment;
    }

    public void setApartment(List<Apartment> apartment) {
        this.apartment = apartment;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + idUser +
                ", userName='" + userName + '\'' +
                ", userSurname='" + userSurname + '\'' +
                ", email='" + email + '\'' +
                ", userCity='" + userCity + '\'' +
                ", hostUser=" + hostUser +
                ", apartment=" + apartment +
                '}';
    }
}
