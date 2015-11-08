package model;

import observer.Observer;
import observer.Subject;

public class Home implements Subject {
    private String hostEmail;
    private CityList city;
    private HomeType homeType;
    private boolean active;

    public Home(){};

    public Home(CityList city, HomeType homeType) {
        this.city = city;
        this.homeType = homeType;
        this.active = true;
    }

    public CityList getCity() {
        return city;
    }

    public HomeType getHomeType() {
        return homeType;
    }

    public String getHost() {
        return hostEmail;
    }

    public void setCity(CityList city) {
        this.city = city;
    }

    public void setHomeType(HomeType homeType) {
        this.homeType = homeType;
    }

    public void setHost(String hostEmail) {
        this.hostEmail = hostEmail;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
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
