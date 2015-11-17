package common;

public interface Subject {
    void register(Observer observer);
    void remove(Observer observer);
    void notifyAllObservers(String message);
}
