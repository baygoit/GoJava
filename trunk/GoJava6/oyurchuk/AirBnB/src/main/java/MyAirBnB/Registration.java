package MyAirBnB;

import MyAirBnB.Interfaces.Observer;
import MyAirBnB.Interfaces.Organization;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by macmini on 05.10.15.
 */
public class Registration implements Organization {

    List<Observer> list = new ArrayList<Observer>();

    @Override
    public boolean register(Observer obs) {

        return list.add(obs);

    }

    @Override
    public boolean removeObserver(Observer obs) {

        return list.remove(obs);

    }

    @Override
    public void notifyObservers() {

        for (Observer observer :list) {
            observer.update("New City");

        }


    }
}
