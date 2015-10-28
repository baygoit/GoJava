package registration;

import java.util.*;

public class Client extends User implements Observer{

    List<Observer> listOfClient = new ArrayList<Observer>();

    @Override
    public void update(String message) {
        System.out.println("Client: " + message);
    }
}
