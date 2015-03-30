package ua.goit.alg;

import org.junit.Assert;
import org.junit.Test;

public class RotatedArraysTest {

    @Test
    public void testBinarySearchZero() throws Exception {
            int[] array = {4, 5, 6, 7, 8, 9, 10, 1, 2, 3};
            int actualResult = RotatedArrays.binarySearch(array, 4);
            int expectedResult = 0;

            Assert.assertEquals(actualResult, expectedResult);
    }
    @Test
    public void testBinarySearchPositive() throws Exception {
        int[] array = {4, 5, 6, 7, 8, 9, 10, 1, 2, 3};
        int actualResult = RotatedArrays.binarySearch(array, 5);
        int expectedResult = 1;

        Assert.assertEquals(actualResult, expectedResult);
    }
    @Test
    public void testBinarySearchNegative() throws Exception {
        int[] array = {4, 5, 6, 7, 8 , 9, 10, -1, 2, 3};
        int actualResult = RotatedArrays.binarySearch(array, -1);
        int expectedResult = 7;

        Assert.assertEquals(actualResult, expectedResult);
    }
    @Test
    public void testBinarySearchFirst() throws Exception {
        int[] array = {4, 5, 6, 7, 8, 9, 10, 0, 2, 3};
        int actualResult = RotatedArrays.binarySearch(array, 4);
        int expectedResult = 0;

        Assert.assertEquals(actualResult, expectedResult);
    }
    @Test
    public void testBinarySearchLast() throws Exception {
        int[] array = {4, 5, 6, 7, 8, 9, 10, 0, 2, 3};
        int actualResult = RotatedArrays.binarySearch(array, 3);
        int expectedResult = 9;

        Assert.assertEquals(actualResult, expectedResult);
    }
    @Test
    public void testBinarySearchMissing() throws Exception {
        int[] array = {4, 5, 6, 7, 8, 9, 10, 0, 2, 3};
        int actualResult = RotatedArrays.binarySearch(array, 11);
        int expectedResult = -1;

        Assert.assertEquals(actualResult, expectedResult);
    }
}