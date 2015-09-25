package airbnb;
/**
 * Created by slavik on 21.09.2015.
 */
import airbnb.common.Observer;
import airbnb.common.Subject;
import java.util.ArrayList;
import java.util.List;

public class Base implements Subject {

    private List<Observer> users = new ArrayList<Observer>();
    private List<Observer> clients = new ArrayList<Observer>();

    public void add(Observer user) {
        users.add(user);
    }

    public void remove(Observer user) {
        users.remove(user);
    }

    public void notifyAll(String data) {
        for (Observer user: users) user.update(data);
    }
}
