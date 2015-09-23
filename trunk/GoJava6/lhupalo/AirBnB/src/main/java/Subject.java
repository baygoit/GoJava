/**
 * Created by  L Hupalo on 23.09.2015.
 */
public interface Subject {
    void register(Observer o);
    void remove(Observer o);
    void notifyAllObservers();
}