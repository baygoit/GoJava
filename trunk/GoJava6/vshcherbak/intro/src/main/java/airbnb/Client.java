package airbnb;

/**
 * Created by slavik on 21.09.2015.
 */


class Client extends User {
    private String city;
    private RentType rent;
    Client(String name, String surname, String email, String city, RentType rent ) {
        super(name, surname, email);
        this.city = city;
        this.rent = rent;
    }

    public String getCity() {
        return city;
    }
}
