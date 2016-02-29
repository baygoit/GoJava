package ua.dborisenko.arraysort;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ApplicationTest {

    private static PrintStream realOutContent;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private Application application = new Application();

    @Before public void setUpStreams() {
        realOutContent = System.out;
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(realOutContent);
    }

    @Test
    public void getRandomArrayTest() {
        int testLength = 200000;
        int[] testArray1 = new int[testLength];
        int[] testArray2 = new int[testLength];
        testArray1 = this.application.getRandomArray(20);
        Boolean arraysEqualFlag = true;
        for (int i = 0; i < testLength; i++) {
            if (testArray1[i] != testArray2[i]) {
                arraysEqualFlag = false;
                break;
            }
        }
        assertFalse(arraysEqualFlag);
     }

    @Test
    public void mergeSortedArraysTest() {
        int[] arrayA = { 1, 2, 5, 8, 10 };
        int[] arrayB = { 4, 4, 6, 8, 13 };
        int[] expectedArray = { 1, 2, 4, 4, 5, 6, 8, 8, 10, 13 };
        int[] resultArray = this.application.mergeSortedArrays(arrayA, arrayB);
        assertTrue(Arrays.equals(resultArray, expectedArray));
    }

    @Test
    public void sortArrayByMergingTest() {
        int[] testArray = { 4, 1, 13, 2, 5, 4, 6, 8, 10, 8 };
        int[] expectedArray = { 1, 2, 4, 4, 5, 6, 8, 8, 10, 13 };
        int[] resultArray = this.application.sortArrayByMerging(testArray);
        assertTrue(Arrays.equals(resultArray, expectedArray));
    }

    @Test
    public void startTest() {
        int[] testArray = { 4, 1, 13, 2, 5, 4, 6, 8, 10, 8 };
        Application mockApplication = spy(Application.class);
        when(mockApplication.getRandomArray(anyInt())).thenReturn(testArray);
        mockApplication.start();
        assertEquals(
                "Given array:\r\n[4, 1, 13, 2, 5, 4, 6, 8, 10, 8]\r\nSorted array:\r\n[1, 2, 4, 4, 5, 6, 8, 8, 10, 13]\r\n",
                outContent.toString());
    }
}
