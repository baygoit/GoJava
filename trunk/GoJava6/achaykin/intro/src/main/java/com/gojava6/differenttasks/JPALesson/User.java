package com.gojava6.differenttasks.JPALesson;

import javax.persistence.*;
import java.util.List;

/**
 * @Autor Andrey Chaykin
 * @Since 14.11.2015
 */
@Entity
@Table(name="user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="iduser")
    private int id;
    private String name;
    private String surname;
    private String eMail;
    @OneToMany
    @JoinColumn(name="iduser")
    private List<Apartment> apartments;


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

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public List<Apartment> getApartments() {
        return apartments;
    }

    public void setApartments(List<Apartment> apartments) {
        this.apartments = apartments;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("User{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", surname='").append(surname).append('\'');
        sb.append(", eMail='").append(eMail).append('\'');
        sb.append(", apartments=").append(apartments);
        sb.append('}');
        return sb.toString();
    }
}
