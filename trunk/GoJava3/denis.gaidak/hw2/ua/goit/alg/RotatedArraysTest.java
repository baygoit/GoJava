package ua.goit.alg;

import junit.framework.Assert;
import org.junit.Test;

public class RotatedArraysTest {

    @Test
    public void testSimpleTest() {
        int target = 5;
        int expected = 4;
        int[] array = {1, 2, 3, 4, 5, 6};
        int actual = RotatedArrays.binarySearch(array, target);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testArrayIsEmpty() {
        int target = 5;
        int expected = -1;
        int[] array = new int[0];
        int actual = RotatedArrays.binarySearch(array, target);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testArrayOf2Elements_1() {
        int target = 2;
        int expected = 1;
        int[] array = {1,2};
        int actual = RotatedArrays.binarySearch(array, target);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testArrayOf2Elements_2() {
        int target = 1;
        int expected = 0;
        int[] array = {1,2};
        int actual = RotatedArrays.binarySearch(array, target);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSimple_2() {
        int target = 2;
        int expected = 1;
        int[] array = {1,2,3};
        int actual = RotatedArrays.binarySearch(array, target);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSimple_3() {
        int target = 3;
        int expected = 2;
        int[] array = {1,2,3};
        int actual = RotatedArrays.binarySearch(array, target);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSimple_4() {
        int target = 1;
        int expected = 0;
        int[] array = {1,2,3};
        int actual = RotatedArrays.binarySearch(array, target);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testRotatedArraysSimple() {
        int target = 1;
        int expected = 0;
        int[] array = {4, 5, 6, 7, 8, 9, 10, 1, 2, 3};
        int actual = RotatedArrays.binarySearch(array, target);
        Assert.assertEquals(expected, actual);
    }


}