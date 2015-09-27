package airbnb;
/**
 * Created by slavik on 21.09.2015.
 */
//import airbnb.common.Observer;
import airbnb.common.Subject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import airbnb.model.Client;
import airbnb.model.Host;
//import airbnb.model.RentType;
import airbnb.model.User;

public class Base implements Subject {

    private List<User> hosts = new ArrayList<User>();
    private List<User> clients = new ArrayList<User>();

    public void register(User user) {
        if (user.getClass() == Client.class) {
            if (user.validate()) {
                clients.add(user);
            } else {
                System.out.println("Please enter valid data");
            }
        } else if (user.getClass() == Host.class) {
            if (user.validate()) {
                hosts.add(user);
            } else {
                System.out.println("Please enter valid data");
            }
        } else {
            System.out.println("Something wrong");
        }
    }

    public void remove(String surname) {
        Iterator<User> it = hosts.iterator();
        while (it.hasNext()) {
            User u = it.next();
            if(u.getSurname() == surname) {
                it.remove();
            }
        }
        it = clients.iterator();
        while (it.hasNext()) {
            User u = it.next();
            if(u.getSurname() == surname) {
                it.remove();
            }
        }
    }

    public void notifyAll(String data) {
        for (User user: hosts) user.update(data);
        for (User user: clients) user.update(data);
    }
}
