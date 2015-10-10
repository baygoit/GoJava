package com.gojava6.iterator;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;

/**
 * Created by sergiigetman on 10/7/15.
 */
public class ResizingArrayQueueTest {
    private ResizingArrayQueue<Integer> deque;

    @Before
    public void setUp() {
        deque = new ResizingArrayQueue<Integer>();
    }


    @Test
    public void testIterator() {
        deque.enqueue(new Integer(1));
        deque.enqueue(new Integer(2));

        Iterator integerIterator = deque.iterator();
        assertEquals(new Integer(1), integerIterator.next());
        assertEquals(new Integer(2), integerIterator.next());
    }

    @Test(expected = NoSuchElementException.class)
    public void testIteratorException() {
        Iterator integerIterator = deque.iterator();
        integerIterator.next();
    }


}