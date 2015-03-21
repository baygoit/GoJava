/**
 * Created by Aleksey Kurkov on 20.03.15.
 */

package ua.goit.alg.v2;

public class RotatedArrays {
  public static int binarySearch(int[] array, int target) {
    int middle;
    int start = 0;
    int end = array.length - 1;
    // array contains 0 items
    if (array.length == 0) {
      return -1;
    }
    // continue searching while [start,end] is not empty
    while (start < end) {
      // calculate the midpoint for roughly equal partition
      middle = midpoint(end, start);
      if (array[middle] == target) {
        // target found at index middle
        return middle;
      } else if ((middle - 1 > 0) && (array[middle - 1] == target)) {
        // target found at index middle - 1
        return middle - 1;
      } else if ((middle + 1 < array.length - 1) && (array[middle + 1] == target)) {
        // target found at index middle + 1
        return middle + 1;
      } else if (array[start] == target) {
        // target found at index start
        return start;
      } else if (array[start + 1] == target) {
        // target found at index start + 1
        return start + 1;
      } else if (array[end] == target) {
        // target found at index end
        return end;
      } else if (array[end - 1] == target) {
        // target found at index end - 1
        return end - 1;
      }
      // determine which subarray to search
      else if (target > array[middle]) {
        if (target > array[end - 1]) {
          if (start != middle) {
            // look at the left part
            start = middle;
          } else {
            // target was not found
            return -1;
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
            return -1;
          }
        } else {
          // change end to search lower subarray
          end--;
        }
      } else {
        // target was not found
        return -1;
      }
    }
    // target was not found
    return -1;
  }

  private static int midpoint(int start, int end) {
    return (start / 2 + end / 2);
  }
}