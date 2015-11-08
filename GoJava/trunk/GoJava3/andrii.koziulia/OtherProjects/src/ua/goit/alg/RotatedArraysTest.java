package ua.goit.alg;

import org.junit.Test;
import java.util.Arrays;
import static org.junit.Assert.assertEquals;

public class RotatedArraysTest {

  @Test
  public void allPossible10Arrays() {
    int[] array = new int[10];
    for (int j = 0; j < 10; j++) {
      for (int i = 0; i < 10; i++) {
        array[i] = (i + j) % 10;
      }
      for (int i = 0; i < 10; i++) {
        int actual = RotatedArrays.binarySearch(array, i);
        int expected = (i + j * 9) % 10;
        if (actual != expected) {
          System.out.println(Arrays.toString(array));
          System.out.println("Value searched: " + i + ". Expected value: " + expected + ", search provided the following result: " + actual);
        }
        assertEquals(expected, actual);
      }
    }
  }

  @Test
  public void emptyArray() {
    int[] array = new int[0];
    int actual = RotatedArrays.binarySearch(array, 1);
    int expected = -1;
    assertEquals(expected, actual);
  }

  @Test
  public void singleIntegerArray() {
    int[] array = {5};
    int actual = RotatedArrays.binarySearch(array, 5);
    int expected = 0;
    assertEquals(expected, actual);
    actual = RotatedArrays.binarySearch(array, 3);
    expected = -1;
    assertEquals(expected, actual);
  }

  @Test
  public void twoIntegerArray() {
    int[] array = {1, 2};
    int actual = RotatedArrays.binarySearch(array, 1);
    int expected = 0;
    assertEquals(expected, actual);
    actual = RotatedArrays.binarySearch(array, 2);
    expected = 1;
    assertEquals(expected, actual);
  }

  @Test
  public void reverseTwoIntegerArray() {
    int[] array = {2, 1};
    int actual = RotatedArrays.binarySearch(array, 1);
    int expected = 1;
    assertEquals(expected, actual);
    actual = RotatedArrays.binarySearch(array, 2);
    expected = 0;
    assertEquals(expected, actual);
  }

  @Test
  public void noSuchElement() {
    int[] array = {7, 8, 9, 1, 2, 3, 4, 5, 6};
    int actual = RotatedArrays.binarySearch(array, 10);
    int expected = -1;
    assertEquals(expected, actual);
    actual = RotatedArrays.binarySearch(array, -1);
    expected = -1;
    assertEquals(expected, actual);
  }
}