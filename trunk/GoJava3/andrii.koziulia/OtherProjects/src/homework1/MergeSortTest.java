package homework1;

import org.junit.Test;
import java.util.Arrays;
import static org.junit.Assert.assertEquals;

public class MergeSortTest {

  @Test
  public void testSimpleArray() {
    int[] testArray = {1, 15, 2, 8, 3, 4, 19, 11, 6, 7, 4, 9, 3, 9, 2, 8};
    String expectedResult = "[1, 2, 2, 3, 3, 4, 4, 6, 7, 8, 8, 9, 9, 11, 15, 19]";
    MergeSort.mergeSort(testArray);
    assertEquals(expectedResult, Arrays.toString(testArray));
  }

  @Test
  public void testOneValueArray() {
    int[] testArray = {1};
    String expectedResult = "[1]";
    MergeSort.mergeSort(testArray);
    assertEquals(expectedResult, Arrays.toString(testArray));
  }

  @Test
  public void testTwoValuesArray() {
    int[] testArray = {2, 1};
    String expectedResult = "[1, 2]";
    MergeSort.mergeSort(testArray);
    assertEquals(expectedResult, Arrays.toString(testArray));
  }

  @Test
  public void testSimilarValuesArray() {
    int[] testArray = {2, 2, 2, 2, 2};
    String expectedResult = "[2, 2, 2, 2, 2]";
    MergeSort.mergeSort(testArray);
    assertEquals(expectedResult, Arrays.toString(testArray));
  }
}