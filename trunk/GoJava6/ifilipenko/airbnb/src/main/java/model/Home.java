package model;

public class Home {
    private User host;
    private String city;
    private HomeType homeType;
    private boolean active;

    public Home(User host, String city, HomeType homeType) {
        this.host = host;
        this.city = city;
        this.homeType = homeType;
    }

    @Override
    public String toString() {
        return "Home{" +
                "host=" + host +
                ", city='" + city + '\'' +
                ", homeType=" + homeType +
                ", active=" + active +
                '}';
    }

    public User getHost() {
        return host;
    }

    public void setHost(User host) {
        this.host = host;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public HomeType getHomeType() {
        return homeType;
    }

    public void setHomeType(HomeType homeType) {
        this.homeType = homeType;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
