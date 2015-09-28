package airbnb.common;

import airbnb.model.User;

/**
 * Created by slavik on 21.09.2015.
 */
public interface Subject {
    void register(User user);
    void remove(String surname);
    void notifyAll(String data);
}
