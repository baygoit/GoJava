import junit.framework.TestCase;

public class RotatedArraysTest extends TestCase {

    public void test1() {
        int[] array = {4, 5, 6, 7, 8, 9, 10, 1, 2, 3};
        int expectedResult = 0;
        int actualResult = RotatedArrays.binaryModifiedSearch(array, 4);
        assertEquals(expectedResult, actualResult);
    }
    public void test2() {
        int[] array = {4, 5, 6, 7, 8, 9, 10, 1, 2, 3};
        int expectedResult = 6;
        int actualResult = RotatedArrays.binaryModifiedSearch(array, 10);
        assertEquals(expectedResult, actualResult);
    }
    public void test3() {
        int[] array = {4, 5, 6, 7, 8, 9, 10, 1, 2, 3};
        int expectedResult = 7;
        int actualResult = RotatedArrays.binaryModifiedSearch(array, 1);
        assertEquals(expectedResult, actualResult);
    }
    public void test4() {
        int[] array = {4, 5, 6, 7, 8, 9, 10, 1, 2, 3};
        int expectedResult = 9;
        int actualResult = RotatedArrays.binaryModifiedSearch(array, 3);
        assertEquals(expectedResult, actualResult);
    }
}