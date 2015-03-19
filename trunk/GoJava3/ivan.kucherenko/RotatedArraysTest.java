import static org.junit.Assert.*;

import org.junit.Test;

/*You have a sorted array of N length which was rotated, e.g. [4, 5, 6, 7, 8, 9, 10, 1, 2, 3].
Rotated means that we move first M numbers to the end.
You need to find index of target number using binary search.
In case there is no such number in array, return -1;
All numbers in array are unique.
Use TDD approach.
*/

public class RotatedArraysTest {
	
	@Test
	public void testFirst() {
		int[] testArray = {4,5,6,7,8,9,10,1,2,3,4};
		int actualResult = RotatedArrays.binarySearch(testArray,5);
		int expectedresult = 1;
		assertEquals(actualResult, expectedresult);	;
	}
	
	@Test
	public void testLeftSide(){
		int[] testArray = {4,5,6,7,8,9,10,11,1,2,3,4};
		int actualResult = RotatedArrays.binarySearch(testArray, 9);
		int expectedresult = 5;
		assertEquals(actualResult,expectedresult);
	}
	
	@Test
	public void testRightSide(){
		int[] testArray = {4,5,6,7,8,9,10,11,1,2,3};
		int actualResult = RotatedArrays.binarySearch(testArray, 11);
		int expectedresult = 7;
		assertEquals(actualResult,expectedresult);
	}
	@Test
	public void testIsEmpty(){
		int[] testArray = {};
		int actualResult = RotatedArrays.binarySearch(testArray, 11);
		int expectedresult = -1;
		assertEquals(actualResult,expectedresult);
	}
	
	@Test
	public void testNoNumber(){
		int[] testArray = {4,5,6,7,8,9,10,11,1,2,3};
		int actualResult = RotatedArrays.binarySearch(testArray, 21);
		int expectedresult = -1;
		assertEquals(actualResult,expectedresult);
	}
	
	@Test
	public void testIfMiddle(){
		int[] testArray = {4,5,6,7,8,9,10,11,1,2,3};
		int actualResult = RotatedArrays.binarySearch(testArray, 1);
		int expectedresult = 8;
		assertEquals(actualResult,expectedresult);
	}
	
	@Test
	public void testIfMidle2(){
		int[] testArray = {4,5,6,7,8,9,10,11,1,2,3};
		int actualResult = RotatedArrays.binarySearch(testArray, 6);
		int expectedresult = 2;
		assertEquals(actualResult,expectedresult);
	}
	
	@Test
	public void testIfLast(){
		int[] testArray = {4,5,6,7,8,9,10,11,1,2,3};
		int actualResult = RotatedArrays.binarySearch(testArray, 3);
		int expectedresult = 10;
		assertEquals(actualResult,expectedresult);
	}
	
}
