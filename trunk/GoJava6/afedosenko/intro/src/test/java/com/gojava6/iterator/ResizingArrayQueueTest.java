package com.gojava6.iterator;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

/**
 * Created by sergiigetman on 10/7/15.
 */
public class ResizingArrayQueueTest {

    ResizingArrayQueue<Integer> resizingArrayQueue;

    @Before
    public void setUp() {
        resizingArrayQueue = new ResizingArrayQueue<>();
    }

    @Test
    public void testIterator() throws Exception {
        resizingArrayQueue.enqueue(1);
        Iterator<Integer> iterator = resizingArrayQueue.iterator();
        assertTrue(iterator.hasNext());
        assertEquals(new Integer(1), iterator.next());
    }
}