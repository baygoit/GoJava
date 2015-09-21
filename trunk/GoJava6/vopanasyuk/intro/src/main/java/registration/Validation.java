package registration;


import java.util.Collection;
import java.util.LinkedList;

public class Validation implements Subject {
    private Collection<Observer> observers = new LinkedList<Observer>();

    @Override
    public void register(Observer o) {
        if (o == null) {
            System.out.println("Sorr, but you don't register");
        }
        observers.add(o);
    }

    @Override
    public void remove(Observer o) {
        observers.remove(o);

    }

    @Override
    public void notifyObservers() {
    for (Observer observer : observers){
        observer.update("Registered");
    }
    }
}
