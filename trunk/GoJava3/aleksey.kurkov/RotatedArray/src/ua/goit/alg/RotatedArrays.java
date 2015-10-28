package ua.goit.alg;

public class RotatedArrays {

  public static int binarySearch(int[] array, int target) {

    int result = -1;
    int middle;
    int start = 0;
    int end = array.length - 1;

    while (start <= end) {
      middle = midpoint(end, start);

      if (array[middle] == target) {
        result = middle;
        break;
      } else if (array[start] == target) {
        result = start;
        break;
      } else if (array[end] == target) {
        result = end;
        break;
      } else if (array[start] < array[middle]) {

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