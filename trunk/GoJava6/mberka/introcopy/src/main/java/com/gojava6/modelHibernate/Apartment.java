package com.gojava6.modelHibernate;

import com.gojava6.observer.Validation;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table (name = "Apartments")
//@Embeddable
public class Apartment {
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column
    private int idApartment;
    @Column
    private String city;
    @Column
    private Enum ApartmentType;
    @Column
    @Lob //Large Object>255symbols, CLOB/BLOB(Char/Byte Large Object)
    private String description;
    @Column
    private Date startDate;
    @Column
    private Date endDate;
    @OneToMany (mappedBy = "apartment", cascade = CascadeType.PERSIST)
    private List<Reservation> reservation  = new ArrayList<>();

    public Apartment() {
    }

    public Apartment(String city, Enum apartmentType,
                     String description, Date startDate, Date endDate) {
        this.city = city;
        ApartmentType = apartmentType;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public int getIdApartment() {
        return idApartment;
    }

    public void setIdApartment(int idApartment) {
        this.idApartment = idApartment;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        if (Validation.getValidation().validCityName(city)) {
            this.city = city;
        }
    }

    public Enum getApartmentType() {
        return ApartmentType;
    }

    public void setApartmentType(Enum apartmentType) {
        ApartmentType = apartmentType;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public List<Reservation> getReservation() {
        return reservation;
    }

    public void setReservation(List<Reservation> reservation) {
        this.reservation = reservation;
    }

    @Override
    public String toString() {
        return "Apartment{" +
                /*"user=" + user +*/
                ", city='" + city + '\'' +
                ", ApartmentType=" + ApartmentType +
                ", description='" + description + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                /*", reservation=" + reservation +*/
                '}';
    }
}
