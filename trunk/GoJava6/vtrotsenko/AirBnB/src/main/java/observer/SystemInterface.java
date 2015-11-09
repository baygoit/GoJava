package observer;

/**
 * Created by root on 04.11.15.
 */
public interface SystemInterface {
    void registerObserver(Observer o);
    void removeObserver(Observer o);
    void notifyAllObservers(String s);
}
