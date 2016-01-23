package com.sandarovich.module1.mindistance;

import org.junit.Test;

import com.sandarovich.module1.findistance.MyArray;

import static org.junit.Assert.assertEquals;

/**
 * Unit test for simple App.
 */
public class AppTest {

    @Test
    public void testDifferentMinElements() {
        int[] array = {23, 45, 34, 12, 45, 4, 38, 56, 2, 49, 100}; 
        MyArray arr = new MyArray(array);
        assertEquals("3", arr.getDistance());
    }
    
    @Test
    public void testManyMinElements() {
        int[] array = {1, 2, 1, 2, 1}; 
        MyArray arr = new MyArray(array);
        assertEquals("2, 4, 2", arr.getDistance());
    }

}
