import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by root on 19.09.15.
 */
public class AirBnBSystem implements SystemInterface {

    private Set<Observer> listOfObservers = new HashSet<Observer>();    // hashset of ALL types Users
    private Set<String> listofCities = new HashSet<String>();    //list of cities

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
        System.out.println("//Observer registered");
    }

    public void removeObserver(Observer o) {
        listOfObservers.remove(o);
        System.out.println("//Observer removed");
    }

    public void notifyAllObservers(String cityName) {
        for(Observer observer : listOfObservers) {
            observer.update(cityName);
        }
    }

    // we call this method when regiser host
    public void registerHost(Host host) {

        if(validateName(host.getName()) && validateName(host.getSurname()) && validateEmail(host.getEmail())
                && validateName(host.getCity()) && validateApartmentType(host.getApartmentType())) {

            listOfObservers.add(host);
            listofCities.add(host.getCity());
            System.out.println(host.getName() + " was sucsessfully registered as HOST.");
            if (!listofCities.contains(host.getCity())) {
                System.out.println("NOT CONTAIN " + host.getCity());
                notifyAllObservers(host.getCity());
            }
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

    /*  TO DO:
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

    // TO DO : Add InternetAdress class to validate email better
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

    // method to check if there's such a value in the set
    private boolean isCity(Set<String> listofCities, String targetValue) {

        for(String s: listofCities){
            if(s.equals(targetValue))
                return true;
        }
        return false;
    }
}