package com.donishchenko.airbnb.model;

import com.google.common.base.Joiner;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "apartment")
public class Apartment {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "hostId")
    private User host;

    @ManyToOne
    @JoinColumn(name = "cityId")
    private City city;

    @Column(name = "type")
    private ApartmentType apartmentType;

    @Column(name = "active")
    private boolean active;

    public Apartment() {}

    public Apartment(User host, City city, ApartmentType apartmentType, boolean active) {
        this.host = host;
        this.city = city;
        this.apartmentType = apartmentType;
        this.active = active;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getHost() {
        return host;
    }

    public void setHost(User host) {
        this.host = host;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public ApartmentType getApartmentType() {
        return apartmentType;
    }

    public void setApartmentType(ApartmentType apartmentType) {
        this.apartmentType = apartmentType;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null) return false;
        if (!(obj instanceof Apartment)) return false;

        Apartment other = (Apartment) obj;

        return id.equals(other.id) &&
                host.equals(other.host) &&
                city.equals(other.city) &&
                apartmentType.equals(other.apartmentType) &&
                active == other.active;
    }

    @Override
    public String toString() {
        return Joiner.on("").join("Apartment{id='", id, "', host='", host, "', city='", city,
                "', type='", apartmentType, "', active='", active, "'}");
    }
}
