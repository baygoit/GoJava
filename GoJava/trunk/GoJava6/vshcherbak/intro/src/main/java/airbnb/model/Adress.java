package airbnb.model;

/**
 * Created by slavik on 08.10.15.
 */
public class Adress {
    private String city;
    private String street;
    private int house;
    private int room;

    public Adress(String city, String street, int house, int room) {
        this.city = city;
        this.street = street;
        this.house = house;
        this.room = room;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getHouse() {
        return house;
    }

    public void setHouse(int house) {
        this.house = house;
    }

    public int getRoom() {
        return room;
    }

    public void setRoom(int room) {
        this.room = room;
    }

    @Override
    public String toString() {
        return "Adress{" +
                "city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", house=" + house +
                ", room=" + room +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Adress)) return false;

        Adress adress = (Adress) o;

        if (house != adress.house) return false;
        if (room != adress.room) return false;
        if (!city.equals(adress.city)) return false;
        return street.equals(adress.street);

    }

    @Override
    public int hashCode() {
        int result = city.hashCode();
        result = 31 * result + street.hashCode();
        result = 31 * result + house;
        result = 31 * result + room;
        return result;
    }
}
