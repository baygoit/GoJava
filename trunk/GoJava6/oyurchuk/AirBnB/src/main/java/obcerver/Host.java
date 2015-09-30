package obcerver;

/**
 * Created by macmini on 20.09.15.
 */
public class Host extends User {

    private String city;
    private apartmentType apartament;

    private enum apartmentType {place, room, apartment}

    public Host(String name, String mail, String city, String surname, apartmentType apartmentType) {
        super(name, surname, mail);
        this.city = city;

    }

    public String getCity() {

        return city;
    }

    public void setCity(String city) {

        this.city = city;
    }

}




