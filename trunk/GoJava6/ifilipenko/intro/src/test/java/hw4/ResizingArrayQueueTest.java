package hw4;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;

public class ResizingArrayQueueTest {
    private ResizingArrayQueue<Integer> queue;

    @Before
    public void setUp() {
        queue = new ResizingArrayQueue<>();
    }


    @Test
    public void testIterator() {
        queue.enqueue(new Integer(1));
        queue.enqueue(new Integer(2));

        Iterator integerIterator = queue.iterator();
        assertEquals(new Integer(2), integerIterator.next());
        assertEquals(new Integer(1), integerIterator.next());
    }

    @Test(expected = NoSuchElementException.class)
    public void testIteratorException() {
        Iterator integerIterator = queue.iterator();
        integerIterator.next();
    }


}