package main;

/**
 * Created by user on 19.09.2015.
 */
public interface Subject {
    public void registerObserver (Observer O);
    public void removeObserver (Observer O);
    public void notifyObservers();
    //public String toString();
}
