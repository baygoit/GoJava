import java.util.HashSet;
import java.util.Set;

/**
 * Created by root on 19.09.15.
 */
public class AirBnBSystem implements SystemInterface {

    private Set<Observer> listOfObservers = new HashSet<Observer>();    // hashset of ALL types Users
    private Set<String> listofCities = new HashSet<String>();         //list of cities

    public Set<Observer> getListOfObservers() {
        return listOfObservers;
    }

    public void setListOfObservers(Set<Observer> listOfObservers) {
        this.listOfObservers = listOfObservers;
    }

    public Set<String> getListofCities() {
        return listofCities;
    }

    public void setListofCities(Set<String> listofCities) {
        this.listofCities = listofCities;
    }

    public void registerObserver(Observer o) {
        listOfObservers.add(o);
    }

    public void removeObserver(Observer o) {
        listOfObservers.remove(o);
    }

    /* additional method for host registration
     * used to notify (I couldn't do it earlier)
     * (вынес его за пределы метода registerHost)
     */

    public void validateCity(Host host) {
        registerObserver(host);
        if (!getListofCities().contains(host.getCity())) {
            notifyAllObservers(host.getCity());
        }
    }

    public void notifyAllObservers(String cityName) {
        for(Observer observer : listOfObservers) {
            observer.update(cityName);
        }
    }

    public void registerHost(Host host) {

        if(validateName(host.getName()) && validateName(host.getSurname()) && validateEmail(host.getEmail())
                && validateName(host.getCity()) && validateApartmentType(host.getApartmentType())) {
            System.out.println(host.getName() + " was sucsessfully registered as HOST.");
            validateCity(host);
            listofCities.add(host.getCity());
        }
        else {
            System.out.println("Unfortunatly, your data is not valid. Try again!");
        }
    }

    // we call this method when register client
    public void registerClient(Client client) {

        if(validateName(client.getName()) && validateName(client.getSurname()) && validateEmail(client.getEmail())) {
            listOfObservers.add(client);
            System.out.println(client.getName() + " was sucsessfully registered as CLIENT.");
        }
        else {
            System.out.println("Unfortunatly, your data is not valid. Try again!");
        }

    }

    /*  TODO:
     * 1) change boolean result type in the next methods to String and
     *    use recursion until name or smth won't be right
     * 2) when we will use some input classes
     *    to fill user's properties
     * 3)
     * 4) change registerHost and registerClient classes
     */

    // method to check if mame valid
    private boolean validateName(String name) {

        if(name != null && !consistDigits(name))
            return true;

        else {
            System.out.println("WARNING! You've entered wrong name. It must not have any digits and " +
                    "have at least 1 symbol");
            return false;
        }
    }

    // TODO : Add InternetAdress class to validate email better
    private boolean validateEmail(String email) {

        if(email != null && email.contains("@gmail.com"))
            return true;

        else {
            System.out.println("WARNING! You've entered wrong email. To register AirBnB you must have " +
                    "gmail account");
            return false;
        }
    }

    private boolean validateApartmentType(ApartmentType apartmentType) {

        ApartmentType[] apartmentTypes = ApartmentType.values();
        for (ApartmentType apartmentType1 : apartmentTypes) {
            if (apartmentType.equals(apartmentType1))
                return true;
        }
        return false;
    }

    // method to check whether some string consist Numbers or not
    private boolean consistDigits(String str) {

        if(str.contains("[a-zA-Z]+"))
            return true;

        else
            return false;
    }
}