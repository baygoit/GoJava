package MyAirBnB.Interfaces;

import MyAirBnB.Interfaces.Observer;

/**
 * Created by macmini on 21.09.15.
 */
public interface Organization {
    boolean register(Observer j);
    public boolean removeObserver(Observer j);
    public void notifyObservers();
}
