package ua.goit.rotatedarray;

public class RotatedArray {

  public static void main(String[] args) {
    int i = RotatedArray.binarySearch(new int[] { 4, 6, 8, 3 }, 3);

    System.out.println("Res=" + i);

  }

  public static int binarySearch(int[] array, int target) {

    int firstElement = array[0];
    int pos = array.length / 2;
    int leftBorder = 0;
    int rightBorder = array.length - 1;
    int res = -1;

    while (rightBorder - leftBorder > 0) {
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
