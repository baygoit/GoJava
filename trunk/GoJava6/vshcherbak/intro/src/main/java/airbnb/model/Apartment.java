package airbnb.model;

public class Apartment {
    private static int totalApartmentID = 0;
    private int apartmentID;
    private int hostID;
    private RentType rent;
    private String city;

    public Apartment(int hostID, RentType rent ,String city) {
        this.city = city;
        this.rent = rent;
        this.hostID = hostID;
        apartmentID = totalApartmentID++;
    }

    public static int getTotalApartmentID() {
        return totalApartmentID;
    }

    public int getApartmentID() {
        return apartmentID;
    }

    public int getHostID() {
        return hostID;
    }

    public RentType getRent() {
        return rent;
    }

    public String getCity() {
        return city;
    }

    public void setApartmentID(int apartmentID) {
        this.apartmentID = apartmentID;
    }

    public void setHostID(int hostID) {
        this.hostID = hostID;
    }

    public void setRent(RentType rent) {
        this.rent = rent;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Apartment{" +
                "apartmentID=" + apartmentID +
                ", hostID=" + hostID +
                ", rent=" + rent +
                ", city='" + city + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Apartment)) return false;
        Apartment apartment = (Apartment) o;
        if (apartmentID != apartment.apartmentID) return false;
        if (hostID != apartment.hostID) return false;
        if (rent != apartment.rent) return false;
        return city.equals(apartment.city);
    }

    @Override
    public int hashCode() {
        int result = apartmentID;
        result = 31 * result + hostID;
        result = 31 * result + rent.hashCode();
        result = 31 * result + city.hashCode();
        return result;
    }
}