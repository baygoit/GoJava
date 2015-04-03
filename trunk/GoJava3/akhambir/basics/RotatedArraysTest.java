package ua.goit.alg;

import org.junit.Test;

import static org.junit.Assert.*;

public class RotatedArraysTest {

    @Test
     public void commonArrayWithKeyInRightSide() {
        int actualResult = RotatedArrays.binarySearch(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 4);
        int expectedResult = 3;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void commonArrayWithKeyInLeftSide() {
        int actualResult = RotatedArrays.binarySearch(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 9);
        int expectedResult = 8;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void dividedArrayWithKeyInRightSide() {
        int actualResult = RotatedArrays.binarySearch(new int[] {7, 8, 9, 10, 1, 2, 3, 4, 5, 6}, 8);
        int expectedResult = 1;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void dividedArrayWithKeyInLeftSide() {
        int actualResult = RotatedArrays.binarySearch(new int[] {7, 8, 9, 10, 1, 2, 3, 4, 5, 6}, 5);
        int expectedResult = 8;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public  void cycleTestWithLowerMiddlePoint() {
        int[] array = {6, 7, 8, 9, 1, 2, 3, 4, 5};
        for (int i = 0; i < array.length; i++) {
            int actualResult = RotatedArrays.binarySearch(array, array[i]);
            int expectedResult = i;
            assertEquals(expectedResult, actualResult);
        }
    }

    @Test
    public void arraysCycleTest1() {
        int[] array = {26, 27, 29, 8, 10, 15, 16, 17, 25};
        for (int i = 0; i < array.length; i++) {
            int actualResult = RotatedArrays.binarySearch(array, array[i]);
            int expectedResult = i;
            assertEquals(expectedResult, actualResult);
        }
    }

    @Test
    public void arraysCycleTest2() {
        int[] array = {5, 7, 8, 9, 11, 12, 15, 1, 2};
        for (int i = 0; i < array.length; i++) {
            int actualResult = RotatedArrays.binarySearch(array, array[i]);
            int expectedResult = i;
            assertEquals(expectedResult, actualResult);
        }
    }


}