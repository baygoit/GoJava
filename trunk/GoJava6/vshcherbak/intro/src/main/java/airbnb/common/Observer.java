package airbnb.common;

public interface Observer {
    void update(String message);
    void notifyAll(String data);
}
