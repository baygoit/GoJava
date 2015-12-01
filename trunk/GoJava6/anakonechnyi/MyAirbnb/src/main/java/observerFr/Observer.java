package observerFr;

/**
 * Created by user on 19.09.2015.
 */
public interface Observer {
    public void update(Object obj);
    public void loyalty(int discountPercent, Subject s);
}
