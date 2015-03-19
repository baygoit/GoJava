package ua.goit.alg;

import junit.framework.TestCase;
import java.util.Arrays;

public class RotatedArraysTest extends TestCase {

    public void test() {
        int[] array = new int[10];
        for (int j = 0; j < 10; j++) {
            for (int i = 0; i < 10; i++) {
                array[i] = (i + j) % 10;
            }
            for (int i = 0; i < 10; i++) {
                int test = RotatedArrays.binarySearch(array, i);
                int expected = (i + j * 9) % 10;
                if (test != expected) {
                    System.out.println(Arrays.toString(array));
                    System.out.println("Value searched: " + i + ". Expected value: " + expected + ", search provided the following result: " + test);
                }
                assertEquals(expected, test);
            }
        }
    }
}