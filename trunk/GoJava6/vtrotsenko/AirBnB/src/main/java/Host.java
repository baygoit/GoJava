/**
 * Created by root on 19.09.15.
 */
public class Host extends User {

    private String city;
    private ApartmentType apartmentType;
    public Host(String name, String surname, String email, String city, ApartmentType apartmentType) {
        super(name, surname, email);
        this.city = city;
        this.apartmentType = apartmentType;
    }

    // getters and setters
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
}
