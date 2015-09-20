import java.util.Scanner;

/*  array[0]...array[array.length-1]
*   tempArray[start]...tempArray[middle] & tempArray[middlePlusOne]...tempArray[end]
*   */

/*    Test cases
1) Input: 5 4 3 2 1     Output: 1 2 3 4 5
2) Input: 3 5 7 5 3     Output: 3 3 5 5 7
3) Input: 10 8 38 1 99  Output: 1 8 10 38 99 */

public class MergeSort {

  public static int[] getArray() {
    int[] array;
    System.out.println("Input array: ");
    Scanner scanner = new Scanner(System.in);
    String string = scanner.nextLine();
    scanner.close();
    String[] stringArray = string.split(" ");
    array = new int[stringArray.length];
    for (int i = 0; i < stringArray.length; i++) {
      array[i] = Integer.parseInt(stringArray[i]);
    }
    return array;
  }

  public static int[] sortArray(int[] array) {
    int[] tempArray = new int[array.length];
    sort(array, tempArray, 0, array.length - 1);
    return array;
  }

  public static void sort(int[] array, int[] tempArray, int start, int end) {
    if (end == start) {
      return;
    } else {
      int middle = safeFindMiddle(start, end);
      int middlePlusOne = middle + 1;
      sort(array, tempArray, start, middle);
      sort(array, tempArray, middlePlusOne, end);
      merge(array, tempArray, start, middlePlusOne, end);
    }
  }

  public static int safeFindMiddle(int a, int b) {
    return a + b >>> 1;
  }

  public static int[] merge(int[] array, int[] tempArray, int cursor, int
          middlePlusOne, int end) {
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
    for (int i = 0; i < countArrayElements; i++) {
      array[cursor + i] = tempArray[i];
    }
    return array;
  }

  public static void printSortedArray(int[] array) {
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

  public static void main(String[] args) {
    int array[] = getArray();
    sortArray(array);
    printSortedArray(array);
  }
}