import junit.framework.TestCase;

public class BinarySearchTest extends TestCase {
    public void test1() {
        int expectedResult = 1;
        int[] array = {4, 5, 6, 7, 8, 9, 10, 1, 2, 3};
        int actualResult = new BinarySearch().findIndex(array, 5, 0, array.length - 1);
        assertEquals(expectedResult, actualResult);
    }

    public void test2() {
        int expectedResult = 7;
        int[] array = {4, 5, 6, 7, 8, 9, 10, 1, 2, 3};
        int actualResult = new BinarySearch().findIndex(array, 1, 0, array.length - 1);
        assertEquals(expectedResult, actualResult);
    }

    public void test3() {
        int expectedResult = 5;
        int[] array = {4, 5, 6, 7, 8, 9, 10, 1, 2, 3};
        int actualResult = new BinarySearch().findIndex(array, 9, 3, array.length - 2);
        assertEquals(expectedResult, actualResult);
    }

    public void test4() {
        int expectedResult = -1;
        int[] array = {};
        int actualResult = new BinarySearch().findIndex(array, 0, 0, array.length - 1);
        assertEquals(expectedResult, actualResult);
    }

    public void test5() {
        int expectedResult = -1;
        int[] array = {4, 5, 6, 7, 8, 9, 10, 1, 2, 3};
        int actualResult = new BinarySearch().findIndex(array, 11, 0, array.length - 1);
        assertEquals(expectedResult, actualResult);
    }
}