package model;

import common.Observer;
import common.Subject;
import model.enums.CityList;
import model.enums.HomeType;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "homes")
public class Home implements Serializable, Subject {
    private int id;
    private User host;
    private CityList city;
    private HomeType homeType;
    private String hostEmail;

    public Home(){}

    public Home(CityList city, HomeType homeType) {
        this.city = city;
        this.homeType = homeType;
    }

    //===============getters======================
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "city")
    public CityList getCity() {
        return city;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "hometype")
    public HomeType getHomeType() {
        return homeType;
    }

    @ManyToOne(cascade=CascadeType.ALL)
    @Column(name = "user_id")
    public User getHost() {
        return host;
    }

    @Transient
    public String getHostByEmail() {
        return hostEmail;
    }

    //===============setters======================

    public void setId(int id) {
        this.id = id;
    }

    public void setHost(User host) {
        this.host = host;
    }

    public void setCity(CityList city) {
        this.city = city;
    }

    public void setHomeType(HomeType homeType) {
        this.homeType = homeType;
    }

    public void setHostByEmail(String hostEmail) {
        this.hostEmail = hostEmail;
    }


    @Override
    public String toString() {
        return "Home{" +
                "hostEmail=" + hostEmail +
                ", city=" + city +
                ", homeType=" + homeType +
                '}';
    }


    @Override
    public void register(Observer observer) {

    }

    @Override
    public void remove(Observer observer) {

    }

    @Override
    public void notifyAllObservers(String message) {

    }
}
