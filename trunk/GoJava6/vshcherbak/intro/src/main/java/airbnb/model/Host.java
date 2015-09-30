package airbnb.model;

public class Host extends User {
    private String city;
    private RentType rent;
    public Host(String name, String surname, String email, String city, RentType rent ) {
        super(name, surname, email);
        this.city = city;
        this.rent = rent;
    }

    public String getCity() {
        return city;
    }
    public RentType getRent() { return rent; }
    public void setCity(String data) { city = data; }
    public void setRent(RentType data) { rent = data; }

    @Override
    public String toString() {
        return super.toString() + "city" + city + "rent" + rent;
    }

    @Override
    public boolean validate() {
        return super.validate() &&
                Validation.validateCity(city);
    }
}