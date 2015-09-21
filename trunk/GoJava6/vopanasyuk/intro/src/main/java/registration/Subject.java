package registration;

/**
 * Created by oktopus on 21.09.15.
 */
public interface Subject {
    void register(Observer o);
    void remove(Observer o);
    void notifyObservers();
}
