package entity;

import common.Observer;
import common.Subject;
import entity.enums.CityList;
import entity.enums.HomeType;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "homes")
public class Home implements Serializable, Subject {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id")
    private int id;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "host_id")
    private User host;

    @Enumerated(EnumType.STRING)
    @Column(name = "city")
    private CityList city;

    @Enumerated(EnumType.STRING)
    @Column(name = "hometype")
    private HomeType homeType;

    @Transient
    private String hostEmail;

    public Home(){}

    public Home(CityList city, HomeType homeType) {
        this.city = city;
        this.homeType = homeType;
    }

    public Home(int id, User user, CityList city, HomeType homeType) {
        this.id = id;
        this.host = user;
        this.city = city;
        this.homeType = homeType;
    }

    //===============getters======================

    public int getId() {
        return id;
    }

    public CityList getCity() {
        return city;
    }

    public HomeType getHomeType() {
        return homeType;
    }

    public User getHost() {
        return host;
    }

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
