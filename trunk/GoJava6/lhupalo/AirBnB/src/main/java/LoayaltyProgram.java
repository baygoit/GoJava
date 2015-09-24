/**
 * Created by  L Hupalo on 23.09.2015.
 */
import java.util.ArrayList;
import java.util.List;



public class LoayaltyProgram implements Subject {

    private List<Observer> clients = new ArrayList<Observer>();

    public void register(Observer o) {
        clients.add(o);
        System.out.println("Hello! You're subscribing on news");
    }

    public void remove(Observer o) {
        clients.remove(o);
        System.out.println("Hello! You're unsubscribing on news");
    }

    public void notifyAllObservers() {
        for (Observer observer : clients) {
            observer.update("We can offer you housing in the a new city. In ");
        }

    }
}