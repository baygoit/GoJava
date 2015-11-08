package ua.goit.alg;

import junit.framework.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class RotatedArraysTest {

  @Test
  public void testSimpleTest() {
    int target = 5;
    int expected = 4;
    int[] array = {1, 2, 3, 4, 5, 6};
    int actual = RotatedArrays.binarySearch(array, target);
    Assert.assertEquals(expected, actual);
  }

  @Test
  public void testArrayIsEmpty() {
    int target = 5;
    int expected = -1;
    int[] array = new int[0];
    int actual = RotatedArrays.binarySearch(array, target);
    Assert.assertEquals(expected, actual);
  }

  @Test
  public void testArrayOf2Elements_1() {
    int target = 2;
    int expected = 1;
    int[] array = {1, 2};
    int actual = RotatedArrays.binarySearch(array, target);
    Assert.assertEquals(expected, actual);
  }

  @Test
  public void testArrayOf2Elements_2() {
    int target = 1;
    int expected = 0;
    int[] array = {1, 2};
    int actual = RotatedArrays.binarySearch(array, target);
    Assert.assertEquals(expected, actual);
  }

  @Test
  public void testSimple_2() {
    int target = 2;
    int expected = 1;
    int[] array = {1, 2, 3};
    int actual = RotatedArrays.binarySearch(array, target);
    Assert.assertEquals(expected, actual);
  }

  @Test
  public void testSimple_3() {
    int target = 3;
    int expected = 2;
    int[] array = {1, 2, 3};
    int actual = RotatedArrays.binarySearch(array, target);
    Assert.assertEquals(expected, actual);
  }

  @Test
  public void testSimple_4() {
    int target = 1;
    int expected = 0;
    int[] array = {1, 2, 3};
    int actual = RotatedArrays.binarySearch(array, target);
    Assert.assertEquals(expected, actual);
  }

  @Test
  public void testRotatedArraysSimple() {
    int target = 1;
    int expected = 7;
    int[] array = {4, 5, 6, 7, 8, 9, 10, 1, 2, 3};
    int actual = RotatedArrays.binarySearch(array, target);
    Assert.assertEquals(expected, actual);
  }

  @Test
  public void testRotatedArraysSimple_1() {
    int target = 7;
    int expected = 1;
    int[] array = {6, 7, 8, 9, 0, 1, 2, 3, 4, 5};
    int actual = RotatedArrays.binarySearch(array, target);
    assertEquals(expected, actual);
  }

  @Test
  public void testRotatedArraysSimple_2() {
    int target = 1;
    int expected = 9;
    int[] array = {2, 3, 4, 5, 6, 7, 8, 9, 10, 1};
    int actual = RotatedArrays.binarySearch(array, target);
    Assert.assertEquals(expected, actual);
  }

  @Test
  public void testRotatedArraysSimple_3() {
    int target = 3;
    int expected = 9;
    int[] array = {4, 5, 6, 7, 8, 9, 10, 1, 2, 3};
    int actual = RotatedArrays.binarySearch(array, target);
    Assert.assertEquals(expected, actual);
  }

  @Test
  public void testRotatedArraysSimple_4() {
    int target = 5;
    int expected = 1;
    int[] array = {4, 5, 6, 7, 8, 9, 10, 1, 2, 3};
    int actual = RotatedArrays.binarySearch(array, target);
    Assert.assertEquals(expected, actual);
  }

  @Test
  public void testRotatedArraysSimple_5() {
    int target = 10;
    int expected = 0;
    int[] array = {10, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    int actual = RotatedArrays.binarySearch(array, target);
    Assert.assertEquals(expected, actual);
  }

  @Test
  public void testRotatedArraysNoneFoundTarget() {
    int target1 = 11;
    int target2 = 0;

    int expected = -1;
    int[] array = {4, 5, 6, 7, 8, 9, 10, 1, 2, 3};

    int actual1 = RotatedArrays.binarySearch(array, target1);
    Assert.assertEquals(expected, actual1);
    int actual2 = RotatedArrays.binarySearch(array, target2);
    Assert.assertEquals(expected, actual2);

  }

  @Test
  public void testNoneFoundTarget() {
    int target1 = 11;
    int target2 = 0;

    int expected = -1;
    int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    int actual1 = RotatedArrays.binarySearch(array, target1);
    Assert.assertEquals(expected, actual1);
    int actual2 = RotatedArrays.binarySearch(array, target2);
    Assert.assertEquals(expected, actual2);
  }

  @Test
  public void testAllPossible10Arrays() {
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


}