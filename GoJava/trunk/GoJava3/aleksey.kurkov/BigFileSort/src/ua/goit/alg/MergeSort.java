package ua.goit.alg;

/*  array[0]...array[array.length-1]
*   tempArray[start]...tempArray[middle] & tempArray[middlePlusOne]...tempArray[end]
*   */

/*    Test cases
1) Input: 5 4 3 2 1     Output: 1 2 3 4 5
2) Input: 3 5 7 5 3     Output: 3 3 5 5 7
3) Input: 10 8 38 1 99  Output: 1 8 10 38 99 */

class MergeSort {
  public static int[] array;

  public MergeSort(int[] expectedArray) {
    array = expectedArray;
    sortArray();
  }

  public static int[] getArray() {
    return array;
  }

  private static void sortArray() {
    int[] tempArray = new int[array.length];
    sort(tempArray, 0, array.length - 1);
  }

  private static void sort(int[] tempArray, int start, int end) {
    if (end == start) {
      //noinspection UnnecessaryReturnStatement
      return;
    } else {
      int middle = safeFindMiddle(start, end);
      int middlePlusOne = middle + 1;
      sort(tempArray, start, middle);
      sort(tempArray, middlePlusOne, end);
      merge(tempArray, start, middlePlusOne, end);
    }
  }

  private static int safeFindMiddle(int a, int b) {
      return a + b >>> 1;
  }

  private static void merge(int[] tempArray, int cursor, int middlePlusOne,
                            int end) {
    int index = 0;
    int start = cursor;
    int middle = middlePlusOne - 1;
    int countArrayElements = end - start + 1;
    while (start <= middle && middlePlusOne <= end) {
      if (array[start] < array[middlePlusOne]) {
        tempArray[index++] = array[start++];
      } else {
        tempArray[index++] = array[middlePlusOne++];
      }
    }
    while (start <= middle) {
      tempArray[index++] = array[start++];
    }
    while (middlePlusOne <= end) {
      tempArray[index++] = array[middlePlusOne++];
    }
    System.arraycopy(tempArray, 0, array, cursor, countArrayElements);
  }

  public static void printSortedArray() {
    System.out.println("Sorted array: ");
    for (int i = 0; i < array.length; i++) {
      System.out.print(array[i]);
      if (i != array.length - 1) {
        System.out.print(" ");
      } else {
        System.out.println();
      }
    }
  }
}