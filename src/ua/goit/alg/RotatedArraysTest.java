package ua.goit.alg;

import junit.framework.TestCase;

public class RotatedArraysTest extends TestCase{

    public void test1() {
        int actual = RotatedArrays.binarySearch(new int[]{4, 5, 6, 7, 8, 9, 10, 1, 2, 3}, 10);
        assertEquals(6, actual);
    }

    public void test2() {
        int actual = RotatedArrays.binarySearch(new int[] { 4, 5, 6, 7, 8, 1, 2, 3 }, 5);
        assertEquals(1, actual);
    }

    public void test3() {
        int actual = RotatedArrays.binarySearch(new int[] { 4, 5, 6, 7, 8, 1, 2, 3 }, 8);
        assertEquals(4, actual);
    }

    public void test4() {
        int actual = RotatedArrays.binarySearch(new int[] { 4, 5, 6, 7, 8, 1, 2, 3 }, 1);
        assertEquals(5, actual);
    }

    public void test5() {
        int actual = RotatedArrays.binarySearch(new int[] { 4, 5, 6, 7, 8, 9, 10, 1, 2, 3 }, 1);
        assertEquals(7, actual);
    }

    public void test6() {
        int actual = RotatedArrays.binarySearch(new int[] { 4, 5, 6, 7, 8, 1, 2, 3 }, 2);
        assertEquals(6, actual);

    }

    public void test7() {
        int actual = RotatedArrays.binarySearch(new int[] { 4, 5, 6, 7, 1, 2, 3 },8);
        assertEquals(-1, actual);
    }

    public void test8() {
        int actual = RotatedArrays.binarySearch(new int[] { 4, 5, 7, 8, 2, 3 }, 2);
        assertEquals(4, actual);
    }

    public void test9() {
        int actual = RotatedArrays.binarySearch(new int[] { 6, 7, 8, 1, 2, 3, 4, 5 }, 8);
        assertEquals(2, actual);

    }

    public void test10() {
        int actual = RotatedArrays.binarySearch(new int[] { 4, 5, 6, 7, 8, 9, 10, 1, 2, 3 }, 5);
        assertEquals(1, actual);
    }

    public void test11() {
        int actual = RotatedArrays.binarySearch(new int[] { 4, 5, 6, 7, 8, 9, 10, 1, 2, 3 }, 9);
        assertEquals(5, actual);

    }

    public void test12() {
        int actual = RotatedArrays.binarySearch(new int[] { 4, 5, 6, 7, 8, 9, 10, 1, 2, 3 }, 7);
        assertEquals(3, actual);

    }
}