import static org.junit.Assert.*;

import org.junit.Test;


public class BinarySearchTest {
    
    @Test
    public void noElementTest() {
	int actualResult = BinarySearch.returnIndex(new int[]{13,6,1,2,3}, 7);
	int expectedResult = -1;
	assertEquals(expectedResult, actualResult);
    }
    
    @Test
    public void sortedArrayTest() {
	int actualResult = BinarySearch.returnIndex(new int[]{1,2,3}, 3);
	int expectedResult = 2;
	assertEquals(expectedResult, actualResult);
    }

    @Test
    public void oneElement() {
	int actualResult = BinarySearch.returnIndex(new int[]{15}, 15);
	int expectedResult = 0;
	assertEquals(expectedResult, actualResult);
    }

    @Test
    public void shouldFindElementIfMinElementLessThanMiddleTest() {	
	int[] testMass = {26, 27, 29, 8, 10, 15, 16, 17, 25}; 
	for (int i = 0; i < testMass.length; i++) {
	    int actualResult = BinarySearch.returnIndex(testMass, testMass[i]);
	    int expectedResult = i;
	    assertEquals(expectedResult, actualResult);
	}
    }

    @Test
    public void shouldFindElementIfMinElementGreaterThanMiddleTest() {
	int[] testMass = {5, 7, 8, 9, 11, 12, 15, 1, 2}; 
	for (int i = 0; i < testMass.length; i++) {
	    int actualResult = BinarySearch.returnIndex(testMass, testMass[i]);
	    int expectedResult = i;
	    assertEquals(expectedResult, actualResult);
	}
    }

    @Test
    public void shouldFindElementIfMiddleShiftArrayTest() {                      
	int[] testMass = {6, 7, 8, 9, 1, 2, 3, 4, 5}; 
	for (int i = 0; i < testMass.length; i++) {
	    int actualResult = BinarySearch.returnIndex(testMass, testMass[i]);
	    int expectedResult = i;
	    assertEquals(expectedResult, actualResult);
	}

    }

}
