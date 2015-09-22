package registration;


import java.util.Collection;
import java.util.LinkedList;

public class Validation implements Subject {
    private String message;

    private boolean available;

    private Collection<Observer> listOfObservers = new LinkedList<Observer>();

    public void setMessage(String message) {
        this.message = message;
    }


    public void setAvailable(boolean available) {
        this.available = available;
        if (available == true) {
            notifyObservers();
        }
    }

    @Override
    public void register(Observer o) {
        if (o == null) {
            System.out.println("Sorr, but you don't register");
        }
        listOfObservers.add(o);
    }

    @Override
    public void remove(Observer o) {
        listOfObservers.remove(o);

    }

    @Override
    public void notifyObservers() {
        System.out.println("Notifying all registered clients");
    for (Observer observer : listOfObservers){
        observer.update(message);
    }
    }
}
