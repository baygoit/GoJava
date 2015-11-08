import static org.junit.Assert.*;

import org.junit.Test;

public class RotatedArraysTest {

    private void testCase(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int expected = i;
            int actual = new RotatedArrays().binarySearch(array, array[i]);
            assertEquals(expected, actual);
        }
        int expected = -1;
        int actual = new RotatedArrays().binarySearch(array, 99);
        assertEquals(expected, actual);
    }
    
    @Test
    public void test() {

        testCase(new int[] {4, 5, 6, 7, 8, 1, 2, 3});
        
        testCase(new int[] {4, 5, 7, 8, 2, 3});
        
        testCase(new int[] {6, 7, 8, 1, 2, 3, 4, 5});
        
        testCase(new int[] {4, 5, 6, 7, 8, 9, 10, 1, 2, 3});

        testCase(new int[] {10, 1, 2, 3, 4, 5, 6, 7, 8, 9});

        testCase(new int[] {2, 3, 4, 5, 6, 7, 8, 9, 10, 1});

    }


}
