package home_work;

import home_work.arraylist.MyList;
import home_work.oneswipetest.OneSwipeArrayTest;

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

        int[] array = new int[] {2, 3, 4, 6, 7, 5, 8, 9};
        OneSwipeArrayTest test = new OneSwipeArrayTest(array);
        boolean rezult = test.test();
        System.out.println(rezult);
        array = new int[] {2, 3, 4, 6, 7, 5, 8, 9};
        test.array = new int[] {2, 3, 4, 6, 7, 6, 8, 9};
        rezult = test.test();
        System.out.println(rezult);

        test.array = new int[] {1, 2, 4, 3, 2};
        rezult = test.test();
        System.out.println(rezult);

        test.array = new int[] {1, 2, 5, 7, 2};
        rezult = test.test();
        System.out.println(rezult);
    }
}

