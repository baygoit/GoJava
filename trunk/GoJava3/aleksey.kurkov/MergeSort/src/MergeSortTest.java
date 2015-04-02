import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;


public class MergeSortTest {

  @Test
  public void test1() {
    int[] array = {5, 4, 3, 2, 1};
    int[] expectedArray = {1, 2, 3, 4, 5};
    int[] actualArray;
    actualArray = MergeSort.sortArray(array);
    assertArrayEquals(expectedArray, actualArray);
  }

  @Test
  public void test2() {
    int[] array = {3, 5, 7, 5, 3};
    int[] expectedArray = {3, 3, 5, 5, 7};
    int[] actualArray;
    actualArray = MergeSort.sortArray(array);
    assertArrayEquals(expectedArray, actualArray);
  }

  @Test
  public void test3() {
    int[] array = {10, 8, 38, 1, 99};
    int[] expectedArray = {1, 8, 10, 38, 99};
    int[] actualArray;
    actualArray = MergeSort.sortArray(array);
    assertArrayEquals(expectedArray, actualArray);
  }
}