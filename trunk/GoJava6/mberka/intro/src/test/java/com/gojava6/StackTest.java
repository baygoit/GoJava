package com.gojava6;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.gojava6.additionalTasks.stack.Stack;

import static junit.framework.Assert.*;

public class StackTest {
    private Stack stack;

    @Before
    public void stackTestOnlyOnce() {
        stack = new Stack();
    }

    @Test
    public void testIsEmpty() {
        stack.push("The Beatles");
        stack.get();

        Assert.assertTrue(stack.isEmpty());
    }

    @Test
    public void testSize() {
        stack.push("Red Hot Chili Peppers");
        stack.push("Nirvana");
        stack.push("Foo Fighters");

        assertEquals(3, stack.size());
    }

    @Test
    public void testPush() {
        stack.push("Depeche Mode");
        stack.push("Red Hot Chili Peppers");

        assertEquals("Red Hot Chili Peppers, Depeche Mode, ", stack.toString());
    }

    @Test
    public void testGet() {
        stack.push("Led Zeppelin");
        stack.push("The Rolling Stones");
        stack.push("The Cure");

        stack.get();

        assertEquals("The Rolling Stones, Led Zeppelin, ", stack.toString());
    }

    @Test
    public void testPeek() {
        stack.push("Radiohead");
        stack.push("U2");

        Assert.assertSame("U2", stack.peek());
    }

}