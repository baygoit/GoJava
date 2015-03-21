/**
 * Created by Aleksey Kurkov on 20.03.15.
 */

package ua.goit.alg.v2;

public class RotatedArrays {
  public static int binarySearch(int[] array, int target) {
    int result = -1; // if result is not changed - then error
    int middle;
    int start = 0;
    int end = array.length - 1;
    // array contains 0 items
    if (array.length == 0) {
      result = -1;
    }
    // continue searching while [start,end] is not empty
    while (start < end) {
      // calculate the midpoint for roughly equal partition
      middle = midpoint(end, start);
      if (array[middle] == target) {
        // target found at index middle
        result = middle;
        break;
      } else if ((middle - 1 > 0) && (array[middle - 1] == target)) {
        // target found at index middle - 1
        result = middle - 1;
        break;
      } else if ((middle + 1 < array.length - 1) && (array[middle + 1] == target)) {
        // target found at index middle + 1
        result = middle + 1;
        break;
      } else if (array[start] == target) {
        // target found at index start
        result = start;
        break;
      } else if (array[start + 1] == target) {
        // target found at index start + 1
        result = start + 1;
        break;
      } else if (array[end] == target) {
        // target found at index end
        result = end;
        break;
      } else if (array[end - 1] == target) {
        // target found at index end - 1
        result = end - 1;
        break;
      }
      // determine which subarray to search
      else if (target > array[middle]) {
        if (target > array[end - 1]) {
          if (start != middle) {
            // look at the left part
            start = middle;
          } else {
            // target was not found
            result = -1;
            break;
          }
        } else {
          // change start to search upper subarray
          start++;
        }
      } else if (target < array[middle]) {
        if (target < array[start + 1]) {
          if (start != middle) {
            // look at the right part
            start = middle;
          } else {
            // target was not found
            result = -1;
            break;
          }
        } else {
          // change end to search lower subarray
          end--;
        }
      } else {
        // target was not found
        result = -1;
        break;
      }
    }
    return result;
  }

  private static int midpoint(int start, int end) {
    return (start / 2 + end / 2);
  }
}