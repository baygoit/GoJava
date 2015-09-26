package airbnb.common;

/**
 * Created by slavik on 21.09.2015.
 */
public interface Subject {
    void add(Observer user);
    void remove(Observer user);
    void notifyAll(String data);
}
