package ua.goit.alg;

import static org.junit.Assert.*;

import org.junit.Test;


public class TestRotatedArrays {

    @Test
    public void testPresented() {
        int[] array = {4, 5, 6, 7, 8, 9, 10, 1, 2, 3};
        int result = RotatedArrays.binarySearch(array,5);
        int expectedresult = 1;
        assertEquals(result, expectedresult);
    }

    @Test
    public void testNoPresented() {
        int[] array = {4, 5, 6, 7, 8, 9, 10, 1, 2, 3};
        int result = RotatedArrays.binarySearch(array,11);
        int expectedresult = -1;
        assertEquals(result, expectedresult);
    }


    @Test
    public void testSorted() {
        int target = 5;
        int expected = 4;
        int[] array = {1, 2, 3, 4, 5, 6};
        int actual = RotatedArrays.binarySearch(array, target);
        assertEquals(expected, actual);
    }
}
