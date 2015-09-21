package registration;

import java.util.*;

public class Host extends User implements Observer {

    private String city;
    private ApartmentType apartmentType;

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

    private List<Observer> listOfHost = new ArrayList<Observer>();

    @Override
    public void update(String message) {
        System.out.println(getUserName() + ", " + message + "is available");
    }
}
