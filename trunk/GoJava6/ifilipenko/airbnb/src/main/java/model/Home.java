package model;

public class Home {
    private User host;
    private CityList city;
    private HomeType homeType;
    private boolean active;

    public Home(CityList city, HomeType homeType) {
        this.city = city;
        this.homeType = homeType;
        this.active = true;
    }

    public Home(User host, CityList city, HomeType homeType) {
        this.host = host;
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

    public User getHost() {
        return host;
    }

    public void setCity(CityList city) {
        this.city = city;
    }

    public void setHomeType(HomeType homeType) {
        this.homeType = homeType;
    }

    public void setHost(User host) {
        this.host = host;
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
                "host=" + host.toString() +
                ", city=" + city +
                ", homeType=" + homeType +
                ", active=" + active +
                '}';
    }


}
