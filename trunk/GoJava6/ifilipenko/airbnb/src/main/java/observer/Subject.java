package observer;

public interface Subject {
    void register(Observer o);
    void remove(Observer o);
    void notifyAllObservers(String message);
}
