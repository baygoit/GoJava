package com.gojava6.iterator;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

/**
 * Created by user on 07.10.2015.
 */
public class ResizingArrayQueueTest {
    ResizingArrayQueue arrayQueue;
    @Before
    public void setUp() {
        arrayQueue = new ResizingArrayQueue();
    }
    @Test
    public void testIterator() throws Exception {
        arrayQueue.add(new Integer(1));
        arrayQueue.add(new Integer(2));
        Iterator iterator = arrayQueue.iterator();
        assertEquals(new Integer(1),iterator.next());
        assertEquals(new Integer(2),iterator.next());

    }
}