package ua.goit.alg;

public class RotatedArrays {

  public static int binarySearch(int[] array, int target) {
    if (array.length == 0) return -1;
    return startBinarySearch(array, target);
  }

  private static int startBinarySearch(int[] array, int target) {
    int left = 0;
    int right = array.length - 1;

    while (left <= right) {
      if (target == array[left]) return left;
      if (target == array[right]) return right;
      int middle = (right + left) >> 1;

      boolean normalState = array[left] < target && array[right] > target;

      if (array[middle] == target) {
        return middle;
      } else if (array[middle] > target && normalState) {
        right = middle - 1;
        left++;
      } else if (array[middle] < target && normalState) {
        right--;
        left = middle + 1;
      }

      if (array[left] > target && array[right] > target && array[middle] > target) {
        right = middle - 1;
        left++;
      } else {
        right--;
        left = middle + 1;
      }


    }
    return -1;
  }


  private static int startBinarySearch_old(int[] array, int target, int left, int right) {
//        if (array.length == 0) return -1;
//        if (target == array[left]) return left;
//        if (target == array[right]) return right;
//        if (left >= right) return -1;
//
//        int middle = (right + left) >> 1;
//        if (array[middle] > array[right] && array[right] >= target) {
//            return startBinarySearch(array, target, middle, right);
//        }
//
//        if (array[middle] == target) {
//            return middle;
//        } else if (array[middle] > target) {
//            return startBinarySearch(array, target, left + 1, middle - 1);
//        } else {
//            return startBinarySearch(array, target, middle + 1, right - 1);
//        }
    return -1;
  }

}
