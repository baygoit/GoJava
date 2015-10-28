package ua.goit.alg;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Created by kossovec on 18.03.2015.
 */
public class TestRotatedArrays {
    @Test
    public void testBinarySearch() {
        assertEquals(4 , RotatedArrays.binarySearch(new int[] { 4, 5, 6, 7, 8, 1, 2, 3 }, 8));
        assertEquals(0 , RotatedArrays.binarySearch(new int[] { 4, 5, 6, 7, 8, 1, 2, 3 }, 4));
        assertEquals(5 , RotatedArrays.binarySearch(new int[] { 4, 5, 6, 7, 8, 1, 2, 3 }, 1));
        assertEquals(6 , RotatedArrays.binarySearch(new int[] { 4, 5, 6, 7, 8, 1, 2, 3 }, 2));
        assertEquals(-1 , RotatedArrays.binarySearch(new int[] { 4, 5, 6, 7, 8, 1, 2, 3 }, 12));
        assertEquals(0 , RotatedArrays.binarySearch(new int[] {2, 1}, 2));
        assertEquals(1 , RotatedArrays.binarySearch(new int[] {2, 1}, 1));
        assertEquals(0 , RotatedArrays.binarySearch(new int[] {3, 1, 2}, 3));
        assertEquals(1 , RotatedArrays.binarySearch(new int[] {3, 1, 2}, 1));
        assertEquals(2 , RotatedArrays.binarySearch(new int[] {3, 1, 2}, 2));
        assertEquals(0 , RotatedArrays.binarySearch(new int[] {2, 3, 1}, 2));
        assertEquals(1 , RotatedArrays.binarySearch(new int[] {1, 2, 3}, 2));
        assertEquals(1 , RotatedArrays.binarySearch(new int[] {10, 1, 2, 3, 4, 5, 6, 7, 8, 9}, 1));
        assertEquals(5 , RotatedArrays.binarySearch(new int[] {10, 1, 2, 3, 4, 5, 6, 7, 8, 9}, 5));
    }

}


