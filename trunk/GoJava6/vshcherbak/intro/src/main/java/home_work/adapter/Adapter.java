package home_work.adapter;

import java.util.Comparator;

/**
 * Created by Slavik on 08.12.2015.
 */
public class Adapter {
    private Marker marker;

    public Adapter(Marker marker) {
        this.marker = marker;
    }

    public String getName() {
        if ( marker instanceof CarImpl ) {
            return ((CarImpl) marker).getCarName();
        } else if ( marker instanceof TreeImpl ) {
            return ((TreeImpl) marker).getTreeName();
        }
        return null;
    }

    public String getColor() {
        if ( marker instanceof CarImpl ) {
            return ((CarImpl) marker).getCarColor();
        } else if ( marker instanceof TreeImpl ) {
            return ((TreeImpl) marker).getTreeColor();
        }
        return null;
    }

    public static Comparator<Adapter> comp = new Comparator<Adapter>() {

        public int compare(Adapter a1, Adapter a2) {

            String str1 = a1.getName();
            String str2 = a2.getName();

            return str1.compareTo(str2);

        }
    };
}
