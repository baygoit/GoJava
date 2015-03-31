import java.util.Arrays;

public class RotatedArrays {

  public int binarySearch(int[] array, int elem) {
    int index = -1;
    int low;
    int high;
    int middle;
    low = 0;
    high = array.length - 1;
    if (array[low] == elem) {
      index = low;
    } else if (array[high] == elem) {
      index = high;
    }
    while (low < high) {
      middle = (low + high) >>> 1;
      if (array[middle] == elem) {
        index = middle;
        break;
      }
      if (elem < array[middle]) {
        if (elem < array[low]) {
          if (array[middle] < array[low]) {
            high = middle;
          } else {
            low = middle + 1;
          }
        } else {
          high = middle;
        }
      } else {
        if (elem < array[low]) {
          low = middle + 1;
        } else {
          if (array[low] < array[middle]) {
            low = middle + 1;
          } else {
            high = middle;
          }
        }
      }
    }
    return index;
  }

  public static void main(String[] args) {

    int[] array = new int[10];
    for (int j = 0; j < 10; j++) {
      for (int i = 0; i < 10; i++) {
        array[i] = (i + j) % 10;
      }
      for (int i = 0; i < 10; i++) {
        int test = new RotatedArrays().binarySearch(array, i);
        int expected = (i + j * 9) % 10;
        if (test != expected) {
          System.out.println(Arrays.toString(array));
          System.out.println("Value searched: " + i + ". Expected value: "
              + expected + ", search provided the following result: " + test);
        }
      }
    }

  }
}
