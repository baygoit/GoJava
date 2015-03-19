package ua.goit.alg;

import junit.framework.TestCase;

public class RotatedArrayTest extends TestCase {
    public void test1() {
        int expectedResult = 1;
        int[] array = {4, 5, 6, 7, 8, 9, 10, 1, 2, 3};
        int actualResult = RotatedArray.binarySearch(array, 5);
        assertEquals(expectedResult, actualResult);
    }

    public void test2() {
        int expectedResult = 7;
        int[] array = {4, 5, 6, 7, 8, 9, 10, 1, 2, 3};
        int actualResult = RotatedArray.binarySearch(array, 1);
        assertEquals(expectedResult, actualResult);
    }

    public void test3() {
        int expectedResult = 5;
        int[] array = {4, 5, 6, 7, 8, 9, 10, 1, 2, 3};
        int actualResult = RotatedArray.binarySearch(array, 9);
        assertEquals(expectedResult, actualResult);
    }

    public void test4() {
        int expectedResult = -1;
        int[] array = {};
        int actualResult = RotatedArray.binarySearch(array, 0);
        assertEquals(expectedResult, actualResult);
    }

    public void test5() {
        int expectedResult = -1;
        int[] array = {4, 5, 6, 7, 8, 9, 10, 1, 2, 3};
        int actualResult = RotatedArray.binarySearch(array, 11);
        assertEquals(expectedResult, actualResult);
    }

    public void test6() {
        int expectedResult = 1;
        int[] array = {2, 1};
        int actualResult = RotatedArray.binarySearch(array, 1);
        assertEquals(expectedResult, actualResult);
    }

    public void test7() {
        int expectedResult = 2;
        int[] array = {3, 1, 2};
        int actualResult = RotatedArray.binarySearch(array, 2);
        assertEquals(expectedResult, actualResult);
    }

    public void test8() {
        int expectedResult = 2;
        int[] array = {2, 3, 1};
        int actualResult = RotatedArray.binarySearch(array, 1);
        assertEquals(expectedResult, actualResult);
    }

    public void test9() {
        int expectedResult = 0;
        int[] array = {1, 2, 3};
        int actualResult = RotatedArray.binarySearch(array, 1);
        assertEquals(expectedResult, actualResult);
    }
}