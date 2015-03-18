import static org.junit.Assert.*;

import org.junit.Test;


public class RotatedArraysTest {

    @Test
    public void test() {
        int expected;
        int actual;
        expected = 1;
        actual = RotatedArrays.binarySearch(new int[] {4,5,6,7,8,1,2,3}, 5);
        assertEquals(expected, actual);
        expected = -1;
        actual = RotatedArrays.binarySearch(new int[] {4,5,6,7,8,1,2,3}, 8);
        assertEquals(expected, actual);
        expected = 4;
        actual = RotatedArrays.binarySearch(new int[] {4,5,7,8,2,3}, 2);
        assertEquals(expected, actual);
        expected = 2;
        actual = RotatedArrays.binarySearch(new int[] {6,7,8,1,2,3,4,5}, 8);
        assertEquals(expected, actual);
    }

}
