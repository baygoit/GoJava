package airbnb.model;

public class Apartment {
    private static int totalApartmentID = 0;
    private int apartmentID;
    private int hostID;
    private RentType rent;
    private Adress adress;

    public Apartment(int hostID, RentType rent ,Adress adress) {
        this.adress = adress;
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

    public Adress getAdress() {
        return adress;
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

    public void setAdress(Adress adress) {
        this.adress = adress;
    }

    @Override
    public String toString() {
        return "Apartment{" +
                "apartmentID=" + apartmentID +
                ", hostID=" + hostID +
                ", rent=" + rent +
                ", adress='" + adress + '\'' +
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
        return adress.equals(apartment.adress);
    }

    @Override
    public int hashCode() {
        int result = apartmentID;
        result = 31 * result + hostID;
        result = 31 * result + rent.hashCode();
        return result;
    }
}