package obcerver;

/**
 * Created by macmini on 21.09.15.
 */
public interface Organisation {
   boolean register(Observer j);
    public void removeObserver(Observer j);
    public void notifyObservers();
}
