package home_work;

import home_work.arraylist.MyList;

/**
 * Created by slavik on 22.09.2015.
 */
public class Main {
    public static void main(String[] args) {
        MyList list = new MyList();

        for ( int i = 1; i < 7; i++ ) {
            list.add(i);
        }
        System.out.println("capacity= " + list.getCapacity() + " size= " + list.getSize() + '\n' + list);

        for ( int i = 8; i < 16; i++ ) {
            list.add(i);
        }
        System.out.println("capacity= " + list.getCapacity() + " size= " + list.getSize() + '\n' + list);

        list.remove(3);
        System.out.println("capacity= " + list.getCapacity() + " size= " + list.getSize() + '\n' + list);
    }
}
