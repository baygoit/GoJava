package airbnb.common;

import airbnb.model.User;

public interface Subject {
    void register(User user);
    void remove(String surname);
    void notifyAll(String data);
}
