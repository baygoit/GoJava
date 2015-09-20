package java.com.gojava6.airbnb;

import java.util.ArrayList;
import java.util.List;

public class LoyaltyProgram implements Subject {

    private String loyaltyProgramName;
    private boolean available;
    private List<Observer> listOfObservers = new ArrayList<Observer>();

    public void setAvailable(boolean available) {
        this.available = available;
        if (available == true) {
            notifyObservers();
        }
    }

    public void setLoyaltyProgramName(String loyaltyProgramName) {
        this.loyaltyProgramName = loyaltyProgramName;
    }

    @Override
    public void registerObserver(Observer observer) {
        listOfObservers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        listOfObservers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        System.out.println();
        System.out.println("Notifying all registered clients about new loyalty programs");

        for (Observer observer : listOfObservers) {
            observer.update(loyaltyProgramName);
        }
    }
}
