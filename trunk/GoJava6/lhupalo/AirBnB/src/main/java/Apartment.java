/**
 * Created by Ыўср on 05.10.2015.
 */
import java.util.ArrayList;
import java.util.List;

public class Apartment  {
    private Host host;
    private String city;
    private ApartmentType apartmentType;
    private List<ReservationDate> reservationDateList;

    public Apartment() {

    }

    public Apartment(String city, ApartmentType apartmentType, Host host) {
        this.host = host;
        this.city = city;
        this.apartmentType = apartmentType;
        this.reservationDateList = new ArrayList<ReservationDate>();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public ApartmentType getApartmentType() {
        return apartmentType;
    }

    public void setApartmentType(ApartmentType apartmentType) {
        this.apartmentType = apartmentType;
    }

    @Override
    public String toString() {
        String string = apartmentType + " in " + city + " owned " + host;
        return string;
    }







}
