package ua.goit.alg;

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
    // continue while array search range has more than 1 item
    while (start < end) {
      // calculate the midpoint for roughly equal partition
      middle = midpoint(end, start);
      if (array[middle] == target) {
        // target was found at index middle
        result = middle;
        break;
      } else if (array[start] == target) {
        // target was found at index start
        result = start;
        break;
      } else if (array[end] == target) {
        // target was found at index end
        result = end;
        break;
      }
      // determine if array search range is sorted
      else if (array[start] < array[middle]) {
        if ((array[start] < target) && (target < array[middle])) {
          end = middle - 1;
        } else {
          start = middle + 1;
        }
      } else {
        if ((array[middle] < target) && (target < array[end])) {
          start = middle + 1;
        } else {
          end = middle - 1;
        }
      }
    }
    return result;
  }

  private static int midpoint(int start, int end) {
    return (start + (end - start) / 2);
  }
}