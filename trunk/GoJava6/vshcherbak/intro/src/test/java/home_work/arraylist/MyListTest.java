package home_work.arraylist;

/**
 * Created by slavik on 24.09.15.
 */

import org.junit.Before;
import org.junit.Test;
import static junit.framework.Assert.assertEquals;


public class MyListTest {
    private MyList list;
    private String array;
    private int size, capacity;

    @Before
    public void setUp() {
        list = new MyList();
        for ( int i = 2; i < 7; i++) {
            list.add(i);
        }
        array = "2 3 4 5 6 ";
        size = 5;
        capacity = 10;
    }

    @Test
    public void testMyList() {
        assertEquals(array, list.toString());
        assertEquals(size, list.getSize());
        assertEquals(capacity, list.getCapacity());
    }
    @Test
    public void testMyList1() {
        for ( int i = 2; i < 9; i++) {
            list.add(i);
        }
        array = "2 3 4 5 6 2 3 4 5 6 7 8 ";
        size = 12;
        capacity = 20;
        assertEquals(array, list.toString());
        assertEquals(size, list.getSize());
        assertEquals(capacity, list.getCapacity());
    }
    @Test
    public void testMyList2() {
        list.remove(3);
        array = "2 3 4 6 ";
        size = 4;
        capacity = 10;
        assertEquals(array, list.toString());
        assertEquals(size, list.getSize());
        assertEquals(capacity, list.getCapacity());
    }
}
