package Practice.iterator;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;

/**
 * Created by sergiigetman on 10/7/15.
 */
public class DequeIteratorTest {
    private Deque<Integer> deque;

    @Before
    public void setUp() {
        deque = new Deque<>();
    }


    @Test
    public void testIterator() {
        deque.addFirst(new Integer(1));
        deque.addFirst(new Integer(2));

        Iterator integerIterator = deque.iterator();
        assertEquals(new Integer(2), integerIterator.next());
        assertEquals(new Integer(1), integerIterator.next());
    }

    @Test(expected = NoSuchElementException.class)
    public void testIteratorException() {
        Iterator integerIterator = deque.iterator();
        integerIterator.next();
    }


}