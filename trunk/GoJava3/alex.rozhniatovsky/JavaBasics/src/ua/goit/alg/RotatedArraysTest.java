package ua.goit.alg;

import org.junit.Assert;
import org.junit.Test;

public class RotatedArraysTest {

    @Test
    public void testBinarySearch() throws Exception {
            int [] array = {4, 5, 6, 7, 8 ,9, 10, 1, 2, 3};
            int actualResult = RotatedArrays.binarySearch(array, 4, 0, 9);
            int expectedResult = 0;

            Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void testBinarySearch2() throws Exception {
        int [] array = {4, 5, 6, 7, 8 ,9, 10, 1, 2, 3};
        int actualResult = RotatedArrays.binarySearch(array, 5, 0, 9);
        int expectedResult = 1;

        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void testBinarySearch3() throws Exception {
        int [] array = {4, 5, 6, 7, 8 ,9, 10, -1, 2, 3};
        int actualResult = RotatedArrays.binarySearch(array, -1, 0, 9);
        int expectedResult = 7;

        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void testBinarySearch4() throws Exception {
        int [] array = {4, 5, 6, 7, 8 ,9, 10, 0, 2, 3};
        int actualResult = RotatedArrays.binarySearch(array, 4, 0, 9);
        int expectedResult = 0;

        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void testBinarySearch5() throws Exception {
        int [] array = {4, 5, 6, 7, 8 ,9, 10, 0, 2, 3};
        int actualResult = RotatedArrays.binarySearch(array, 3, 0, 9);
        int expectedResult = 9;

        Assert.assertEquals(actualResult, expectedResult);
    }
}