import static org.junit.Assert.*;

import org.junit.Test;


public class BinarySearchTest {

	@Test
	public void Element0Test() {
		int actualResult = BinarySearch.returnIndex(new int[]{15, 16, 2, 5, 7, 9}, 15);
		int expectedResult = 0;
		assertEquals(expectedResult, actualResult);
	}

	@Test
	public void Element1Test() {
		int actualResult = BinarySearch.returnIndex(new int[]{15, 16, 2, 5, 7, 9}, 16);
		int expectedResult = 1;
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void Element2Test() {
		int actualResult = BinarySearch.returnIndex(new int[]{15, 16, 2, 5, 7, 9}, 2);
		int expectedResult = 2;
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void Element3Test() {
		int actualResult = BinarySearch.returnIndex(new int[]{15, 16, 2, 5, 7, 9}, 5);
		int expectedResult = 3;
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void Element4Test() {
		int actualResult = BinarySearch.returnIndex(new int[]{15, 16, 2, 5, 7, 9}, 7);
		int expectedResult = 4;
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void Element5Test() {
		int actualResult = BinarySearch.returnIndex(new int[]{15, 16, 2, 5, 7, 9}, 9);
		int expectedResult = 5;
		assertEquals(expectedResult, actualResult);
	}
	

	@Test
	public void allElementTest() {								 // min element < middle element
		int[] testMass = {26, 27, 29, 8, 10, 15, 16, 17, 25}; 
		for (int i = 0; i < testMass.length; i++) {
			int actualResult = BinarySearch.returnIndex(testMass, testMass[i]);
			int expectedResult = i;
			assertEquals(expectedResult, actualResult);
		}
	}

	@Test
	public void allElementTest1() {                              // min element > middle element
		int[] testMass = {5, 7, 8, 9, 11, 12, 15, 1, 2}; 
		for (int i = 0; i < testMass.length; i++) {
			int actualResult = BinarySearch.returnIndex(testMass, testMass[i]);
			int expectedResult = i;
			assertEquals(expectedResult, actualResult);
		}
	}

	public void allElementTest2() {                              //middle shift                      
		int[] testMass = {6, 7, 8, 9, 1, 2, 3, 4, 5}; 
		for (int i = 0; i < testMass.length; i++) {
			int actualResult = BinarySearch.returnIndex(testMass, testMass[i]);
			int expectedResult = i;
			assertEquals(expectedResult, actualResult);
		}

	}

}
