package ua.goit.alg;
import static org.junit.Assert.*;

import org.junit.Test;
/*You have a sorted array of N length which was rotated, e.g. [4, 5, 6, 7, 8, 9, 10, 1, 2, 3].
*Rotated means that we move first M numbers to the end.
*You need to find index of target number using binary search.
*In case there is no such number in array, return -1;
*All numbers in array are unique.
*Use TDD approach.
*
*0<=N
*0<=M<=N
*/

public class RotatedArraysTest {

    @Test
    public void test1() {
        int expected;
        int actual;
        expected = 1;
        actual = RotatedArrays.binarySearch(
                new int[] { 4, 5, 6, 7, 8, 1, 2, 3 }, 5);
        assertEquals(expected, actual);
        }
    @Test
    public void test2() {
    	int expected = 4;
    	int actual = RotatedArrays.binarySearch(
            new int[] {4, 5, 6, 7, 8, 1, 2, 3 }, 8);
    	assertEquals(expected, actual);
    	}
    @Test
    public void test3() {
    	int expected = 0;
    	int actual = RotatedArrays.binarySearch(
            new int[] { 4, 5, 6, 7, 8, 1, 2, 3 }, 4);
    	assertEquals(expected, actual);
    	}
    @Test
    public void test4() {
    	int expected = 5;
    	int actual = RotatedArrays.binarySearch(
            new int[] { 4, 5, 6, 7, 8, 1, 2, 3 }, 1);
    	assertEquals(expected, actual);
    	}
    @Test
    public void test5() {
    	int expected = 6;
        int actual = RotatedArrays.binarySearch(
                new int[] { 4, 5, 6, 7, 8, 1, 2, 3 }, 2);
        assertEquals(expected, actual);
    }
    @Test
    public void test6() {
    	 int expected = -1;
         int actual = RotatedArrays.binarySearch(new int[] { 4, 5, 6, 7, 1, 2, 3 },
                 8);
         assertEquals(expected, actual);
    }
    @Test
    public void test7() {
    	int expected = 4;
    	int actual = RotatedArrays.binarySearch(new int[] { 4, 5, 7, 8, 2, 3 }, 2);
    	assertEquals(expected, actual);
    }
    @Test
    public void test8() {
    	int expected = 2;
    	int actual = RotatedArrays.binarySearch(
            new int[] { 6, 7, 8, 1, 2, 3, 4, 5 }, 8);
    	assertEquals(expected, actual);
    }
    @Test
    public void test9() {
    	int expected = 1;
    	int actual = RotatedArrays.binarySearch(
            new int[] { 4, 5, 6, 7, 8, 9, 10, 1, 2, 3 }, 5);
    	assertEquals(expected, actual);
    }
    @Test
    public void test10() {
    	int expected = 5;
    	int actual = RotatedArrays.binarySearch(
            new int[] { 4, 5, 6, 7, 8, 9, 10, 1, 2, 3 }, 9);
    	assertEquals(expected, actual);
    }
    @Test
    public void test11() { 
    	int expected = 3;
    	int actual = RotatedArrays.binarySearch(
            new int[] { 4, 5, 6, 7, 8, 9, 10, 1, 2, 3 }, 7);
    	assertEquals(expected, actual);
    }
    
    @Test
    public void test12() { 
    	int expected = 1;
    	int actual = RotatedArrays.binarySearch(
            new int[] {2,1}, 1);
    	assertEquals(expected, actual);
    }
    
    @Test
    public void test13() { 
    	int expected = 2;
    	int actual = RotatedArrays.binarySearch(
            new int[] {3, 1, 2}, 2);
    	assertEquals(expected, actual);
    }
    @Test
    public void test14() { 
    	int expected = 2;
    	int actual = RotatedArrays.binarySearch(
            new int[] {2, 3, 1}, 1);
    	assertEquals(expected, actual);
    }
    @Test
    public void test15() { 
    	int expected = 0;
    	int actual = RotatedArrays.binarySearch(
            new int[] {1, 2, 3}, 1);
    	assertEquals(expected, actual);
    }
    @Test
    public void test16() { 
    	int expected = 2;
    	int actual = RotatedArrays.binarySearch(
            new int[] { 4, 5, 6, 7, 8, 9, 10, 1, 2, 3 }, 6);
    	assertEquals(expected, actual);
    }

}
