package adapter;

import java.util.Comparator;

/**
 * Created by Игорь on 12.12.2015.
 */
public class MyComparator implements Comparator<Car>{

    @Override
    public int compare(Car o1, Car o2) {
        return o1.getCarName().compareTo(o2.getCarName());
    }
}
