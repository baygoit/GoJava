package ua.goit.alg;

import junit.framework.TestCase;

import java.util.Arrays;

public class RotatedArraysTest extends TestCase {
  public void test1() {
    int[] array = {4, 5, 6, 7, 8, 9, 10, 1, 2, 3};
    int expectedResult = 0;
    int actualResult = RotatedArrays.binarySearch(array, 4);
    assertEquals(expectedResult, actualResult);
  }

  public void test2() {
    int[] array = {4, 5, 6, 7, 8, 9, 10, 1, 2, 3};
    int expectedResult = 6;
    int actualResult = RotatedArrays.binarySearch(array, 10);
    assertEquals(expectedResult, actualResult);
  }

  public void test3() {
    int[] array = {4, 5, 6, 7, 8, 9, 10, 1, 2, 3};
    int expectedResult = 7;
    int actualResult = RotatedArrays.binarySearch(array, 1);
    assertEquals(expectedResult, actualResult);
  }

  public void test4() {
    int[] array = {4, 5, 6, 7, 8, 9, 10, 1, 2, 3};
    int expectedResult = 9;
    int actualResult = RotatedArrays.binarySearch(array, 3);
    assertEquals(expectedResult, actualResult);
  }

  public void test5() {
    int[] array = {10, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    int expectedResult = 1;
    int actualResult = RotatedArrays.binarySearch(array, 1);
    assertEquals(expectedResult, actualResult);
  }

  public void test6() {
    int[] array = {6, 7, 8, 1, 2, 3, 4, 5};
    int expectedResult = 2;
    int actualResult = RotatedArrays.binarySearch(array, 8);
    assertEquals(expectedResult, actualResult);
  }

  public void test7() {
    int[] array = {6, 7, 8, 9, 0, 1, 2, 3, 4, 5};
    int expectedResult = 1;
    int actualResult = RotatedArrays.binarySearch(array, 7);
    assertEquals(expectedResult, actualResult);
  }


  public void testSimpleTest() {
    int target = 5;
    int expected = 4;
    int[] array = {1, 2, 3, 4, 5, 6};
    int actual = RotatedArrays.binarySearch(array, target);
    assertEquals(expected, actual);
  }

  public void testArrayIsEmpty() {
    int target = 5;
    int expected = -1;
    int[] array = new int[0];
    int actual = RotatedArrays.binarySearch(array, target);
    assertEquals(expected, actual);
  }

  public void testArrayOf2Elements_1() {
    int target = 2;
    int expected = 1;
    int[] array = {1, 2};
    int actual = RotatedArrays.binarySearch(array, target);
    assertEquals(expected, actual);
  }

  public void testArrayOf2Elements_2() {
    int target = 1;
    int expected = 0;
    int[] array = {1, 2};
    int actual = RotatedArrays.binarySearch(array, target);
    assertEquals(expected, actual);
  }

  public void testSimple_2() {
    int target = 2;
    int expected = 1;
    int[] array = {1, 2, 3};
    int actual = RotatedArrays.binarySearch(array, target);
    assertEquals(expected, actual);
  }

  public void testSimple_3() {
    int target = 3;
    int expected = 2;
    int[] array = {1, 2, 3};
    int actual = RotatedArrays.binarySearch(array, target);
    assertEquals(expected, actual);
  }

  public void testSimple_4() {
    int target = 1;
    int expected = 0;
    int[] array = {1, 2, 3};
    int actual = RotatedArrays.binarySearch(array, target);
    assertEquals(expected, actual);
  }

  public void testRotatedArraysSimple() {
    int target = 1;
    int expected = 7;
    int[] array = {4, 5, 6, 7, 8, 9, 10, 1, 2, 3};
    int actual = RotatedArrays.binarySearch(array, target);
    assertEquals(expected, actual);
  }

  public void testRotatedArraysSimple_1() {
    int target = 1;
    int expected = 1;
    int[] array = {10, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    int actual = RotatedArrays.binarySearch(array, target);
    assertEquals(expected, actual);
  }

  public void testRotatedArraysSimple_2() {
    int target = 1;
    int expected = 9;
    int[] array = {2, 3, 4, 5, 6, 7, 8, 9, 10, 1};
    int actual = RotatedArrays.binarySearch(array, target);
    assertEquals(expected, actual);
  }

  public void testRotatedArraysSimple_3() {
    int target = 3;
    int expected = 9;
    int[] array = {4, 5, 6, 7, 8, 9, 10, 1, 2, 3};
    int actual = RotatedArrays.binarySearch(array, target);
    assertEquals(expected, actual);
  }

  public void testRotatedArraysSimple_4() {
    int target = 5;
    int expected = 1;
    int[] array = {4, 5, 6, 7, 8, 9, 10, 1, 2, 3};
    int actual = RotatedArrays.binarySearch(array, target);
    assertEquals(expected, actual);
  }

  public void testNoneFoundTarget() {
    int target = 11;
    int expected = -1;
    int[] array = {4, 5, 6, 7, 8, 9, 10, 1, 2, 3};
    int actual = RotatedArrays.binarySearch(array, target);
    assertEquals(expected, actual);
  }

  public void testNoneFoundTarget_1() {
    int target = 0;
    int expected = -1;
    int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    int actual = RotatedArrays.binarySearch(array, target);
    assertEquals(expected, actual);
  }

  //-------------------- Other tests -------------------
  public void test() {
    int expected;
    int actual;
    expected = 1;
    actual = RotatedArrays.binarySearch(
            new int[]{4, 5, 6, 7, 8, 1, 2, 3}, 5);
    assertEquals(expected, actual);
    expected = 4;
    actual = RotatedArrays.binarySearch(
            new int[]{4, 5, 6, 7, 8, 1, 2, 3}, 8);
    assertEquals(expected, actual);
    expected = 0;
    actual = RotatedArrays.binarySearch(
            new int[]{4, 5, 6, 7, 8, 1, 2, 3}, 4);
    assertEquals(expected, actual);
    expected = 5;
    actual = RotatedArrays.binarySearch(
            new int[]{4, 5, 6, 7, 8, 1, 2, 3}, 1);
    assertEquals(expected, actual);
    expected = 6;
    actual = RotatedArrays.binarySearch(
            new int[]{4, 5, 6, 7, 8, 1, 2, 3}, 2);
    assertEquals(expected, actual);
    expected = -1;
    actual = RotatedArrays.binarySearch(new int[]{4, 5, 6, 7, 1, 2, 3},
            8);
    assertEquals(expected, actual);
    expected = 4;
    actual = RotatedArrays.binarySearch(new int[]{4, 5, 7, 8, 2, 3}, 2);
    assertEquals(expected, actual);
    expected = 1;
    actual = RotatedArrays.binarySearch(
            new int[]{4, 5, 6, 7, 8, 9, 10, 1, 2, 3}, 5);
    assertEquals(expected, actual);
    expected = 5;
    actual = RotatedArrays.binarySearch(
            new int[]{4, 5, 6, 7, 8, 9, 10, 1, 2, 3}, 9);
    assertEquals(expected, actual);
    expected = 3;
    actual = RotatedArrays.binarySearch(
            new int[]{4, 5, 6, 7, 8, 9, 10, 1, 2, 3}, 7);
    assertEquals(expected, actual);
    expected = 7;
    actual = RotatedArrays.binarySearch(
            new int[]{4, 5, 6, 7, 8, 9, 10, 1, 2, 3}, 1);
    assertEquals(expected, actual);
  }

  // --------- Super Test for All variants ---------
  public void testForAllVariants() {
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
          System.out.println("Value searched: " +
                  i +
                  ". Expected value: " + expected +
                  ", search provided the following result: " +
                  test);
        }
        assertEquals(expected, test);
      }
    }
  }

  public void testArrayWithOneElement() {
    int target = 1;
    int expected = 0;
    int[] array = {1};
    int actual = RotatedArrays.binarySearch(array, target);
    assertEquals(expected, actual);
  }
}