package home_work.adapter;

import java.util.Comparator;

/**
 * Created by Slavik on 08.12.2015.
 */

class MyComparator implements Comparator<Adapter>{

    public int compare(Adapter object1, Adapter object2) {
        if (object1.getName().equals(object2.getName())) {
            return  object1.getColor().compareTo(object2.getColor()) ;
        } else return  ((object1.getName().compareTo(object2.getName())));
    }
}