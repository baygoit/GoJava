package observer;

/**
 * Created by root on 04.11.15.
 */
public interface Observer {
    void update(String s);
    String getName();
    String getLastname();
    String getEmail();
}
