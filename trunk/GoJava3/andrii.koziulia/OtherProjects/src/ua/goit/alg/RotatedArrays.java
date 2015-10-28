package ua.goit.alg;

public class RotatedArrays {

  public static int binarySearch(int[] array, int target) {
    if (array.length == 0) {
      return -1;
    }
    return startBinarySearch(array, target, 0, array.length - 1);
  }

  private static int startBinarySearch(int[] array, int target, int startIndex, int endIndex) {
    int partitionIndex = startIndex + (endIndex - startIndex) / 2;
    while (startIndex != endIndex && array[partitionIndex] != target) {
      if (isInLeftArray(array, target, startIndex, endIndex, partitionIndex)) {
        endIndex = partitionIndex - 1;
      } else {
        startIndex = partitionIndex + 1;
      }
      partitionIndex = startIndex + (endIndex - startIndex) / 2;
    }
    if (array[partitionIndex] == target) {
      return partitionIndex;
    } else {
      return -1;
    }
  }

  private static boolean isInLeftArray(int[] array, int target, int startIndex, int endIndex, int partitionIndex) {
    boolean inLeftArray1 = array[startIndex] <= target && target < array[partitionIndex];
    boolean inLeftArray2 = array[startIndex] <= target && array[partitionIndex] < array[startIndex];

    boolean condition1 = target < array[partitionIndex];
    boolean condition2 = array[partitionIndex] < array[startIndex];
    boolean condition3 = array[partitionIndex] < array[endIndex];
    boolean inLeftArray3 = condition1 && condition2 && condition3;

    return inLeftArray1 || inLeftArray2 || inLeftArray3;
  }
}
