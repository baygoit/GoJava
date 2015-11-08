package com.gojava6.iterator;

import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

/**
 * Created by Electdead on 07.10.2015.
 */
public class ResizingArrayQueueTest {
    @Test
    public void testHasNext() {
        ResizingArrayQueue<String> q = new ResizingArrayQueue<>();
        Iterator<String> iter = q.iterator();
        assertFalse(iter.hasNext());

        q.enqueue("one");
        assertTrue(iter.hasNext());

        iter.next();
        assertFalse(iter.hasNext());
    }

    @Test
    public void testNext() {
        ResizingArrayQueue<String> q = new ResizingArrayQueue<>();
        q.enqueue("one");

        Iterator<String> iter = q.iterator();
        assertEquals("one", iter.next());
    }
}
