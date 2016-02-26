package ua.dborisenko.arraysort;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ApplicationTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private static Application application;

    @BeforeClass
    public static void initialize() {
        application = new Application();
    }

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
        System.setErr(null);
    }

    @Test
    public void getRandomArrayTest() {
        int[] testArray1 = new int[20];
        int[] testArray2 = new int[20];
        assertTrue(Arrays.equals(testArray1, testArray2));
        testArray1 = application.getRandomArray(20);
        assertFalse(Arrays.equals(testArray1, testArray2));
        testArray1 = null;
        testArray2 = null;
    }

    @Test
    public void mergeSortedArraysTest() {
        int[] arrayA = { 1, 2, 5, 8, 10 };
        int[] arrayB = { 4, 4, 6, 8, 13 };
        int[] expectedArray = { 1, 2, 4, 4, 5, 6, 8, 8, 10, 13 };
        int[] resultArray = application.mergeSortedArrays(arrayA, arrayB);
        assertTrue(Arrays.equals(resultArray, expectedArray));
        arrayA = null;
        arrayB = null;
        resultArray = null;
        expectedArray = null;
    }

    @Test
    public void sortArrayByMergingTest() {

        int[] testArray = { 4, 1, 13, 2, 5, 4, 6, 8, 10, 8 };
        int[] expectedArray = { 1, 2, 4, 4, 5, 6, 8, 8, 10, 13 };
        int[] resultArray = application.sortArrayByMerging(testArray);
        assertTrue(Arrays.equals(resultArray, expectedArray));
        testArray = null;
        expectedArray = null;
        resultArray = null;
    }

    @Test
    public void startTest() {
        int[] testArray = { 4, 1, 13, 2, 5, 4, 6, 8, 10, 8 };
        Application mockApplication = spy(Application.class);
        when(mockApplication.getRandomArray(anyInt())).thenReturn(testArray);
        mockApplication.start();
        assertEquals(outContent.toString(), "Given array:\r\n[4, 1, 13, 2, 5, 4, 6, 8, 10, 8]\r\nSorted array:\r\n[1, 2, 4, 4, 5, 6, 8, 8, 10, 13]\r\n");
    }
}
