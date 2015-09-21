package registration;

import java.util.*;

public class Host extends User implements Observer {

    private String city;
    private String apartmentType;

    private List<Observer> listOfHost = new ArrayList<Observer>();

    @Override
    public void update(String message) {
        System.out.println("User: " + message);
    }
}
