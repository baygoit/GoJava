/**
 * Created by L Hupalo on 23.09.2015.
 */
public class Host extends User {


    private String city;
    private ApartmentType apartType;

    public Host() {
        super();
    }

    public Host(String name, String surname, String email, String city,
                ApartmentType apartType) {
        super(name, surname, email);
        if (ValidatorData.validateWords(city) == true) {
            this.city = city;
            this.apartType = apartType;
        }
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        if (ValidatorData.validateWords(city) == true) {
            this.city = city;
        }
    }

    public ApartmentType getApartType() {
        return apartType;
    }

    public void setApartType(ApartmentType apartType) {
        this.apartType = apartType;
    }



}
