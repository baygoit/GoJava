package ua.goit.rotatedarray;

public class RotatedArray {

  public static int binarySearch(int[] array, int target) {

    if (array.length <= 0) {
      return -1;
    }

    int firstElement = array[0];
    int pos = array.length / 2;
    int leftBorder = 0;
    int rightBorder = array.length - 1;
    int res = -1;

    while (leftBorder <= rightBorder) {
      pos = leftBorder + (rightBorder - leftBorder) / 2;
      firstElement = array[leftBorder];

      if (array[pos] == target) {
        res = pos;
        break;
      } else if (array[pos] < firstElement) {
        if (target > array[pos] && target < firstElement) {
          leftBorder = pos + 1;
        } else {
          rightBorder = pos - 1;
        }
      } else {
        if (target <= array[pos] && target >= firstElement) {

          rightBorder = pos - 1;
        } else {
          leftBorder = pos + 1;
        }
      }

      if (array[leftBorder] == target) {
        res = leftBorder;
      }
    }
    return res;
  }
}
