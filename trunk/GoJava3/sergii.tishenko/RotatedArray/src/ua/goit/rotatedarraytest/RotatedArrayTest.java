package ua.goit.rotatedarraytest;


 

import static org.junit.Assert.*;

import org.junit.Test;

import ua.goit.rotatedarray.RotatedArray;


public class RotatedArrayTest {

	@Test
	public void testCase1() {
		int actual = RotatedArray.binarySearch(new int[]{4, 5, 6, 7, 8 ,9, 10, 11,12, 34,57,1, 2, 3}, 8);
		int expected = 4;
		assertEquals(expected, actual);
		;
	}
	@Test
	public void testAbsentElement() {
		int actual = RotatedArray.binarySearch(new int[]{9, 1, 2, 3, 5 ,7,8}, 18);
		int expected = -1;
		assertEquals(expected, actual);
		;
	}
	
	@Test
	public void testCase2() {
		int actual = RotatedArray.binarySearch(new int[]{41, 1, 2, 3,5, 7, 8,  23}, 1);
		int expected = 1;
		assertEquals(expected, actual);
		;
	}
	
	@Test
	public void testCase3() {
		int actual = RotatedArray.binarySearch(new int[]{21, 1, 2, 3,5,7,9,11,14,7}, 21);
		int expected = 0;
		assertEquals(expected, actual);
		;
	}
	@Test
	public void testCase4() {
		int actual = RotatedArray.binarySearch(new int[]{4, 6, 8, 3}, 3);
		int expected = 3;
		assertEquals(expected, actual);
		;
	}
	@Test
	public void testCase5() {
		int actual = RotatedArray.binarySearch(new int[]{4, 6, 8, 3}, 4);
		int expected = 0;
		assertEquals(expected, actual);
		;
	}

}
