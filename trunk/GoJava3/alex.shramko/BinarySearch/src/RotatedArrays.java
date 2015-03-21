import java.util.Arrays;

public class RotatedArrays {
  int low;
  int high;
  int middle;

  void moveUp() {
    low = middle+1;
  }

  void moveDown() {
    high = middle;
  }

  public int binarySearch(int[] array, int elem) {
    int index = -1;
    low = 0;
    high = array.length-1;
    if (array[low] == elem) {
      index = low;
    } else if (array[high] == elem) {
      index = high;
    }
    while (index != -1 && low < high) {
      middle = (low + high) >>> 1;
      if (array[middle] == elem) {
        index = middle;
        break;
      }
      if (array[middle] > elem) {
        if (array[low] >= elem) {
          if (array[middle] < array[low]) {
            moveDown();
          } else {
            moveUp();
          }
        } else {
          moveDown();
        }
      } else {
        if (array[low] >= elem) {
          moveUp();
        } else {
          if (array[middle] > array[low]) {
            moveUp();
          } else {
            moveDown();
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
