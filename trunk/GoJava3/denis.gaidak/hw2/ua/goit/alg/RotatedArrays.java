package ua.goit.alg;

public class RotatedArrays {

  public static int binarySearch(int[] array, int target) {
    if (array.length == 0) return -1;
    return startBinarySearch(array, target, 0, array.length - 1);
  }

  private static int startBinarySearch(int[] array, int target, int left, int right) {
    while (left <= right) {

      int middle = (right + left) >> 1;
      int rightValue = array[right];
      int leftValue = array[left];
      int middleValue = array[middle];

      if (target == middleValue) return middle;
      if (target == leftValue) return left;
      if (target == rightValue) return right;

      boolean leftStateOne   = target < middleValue && middleValue > leftValue && middleValue < rightValue && target > leftValue && target < rightValue;
      boolean leftStateFour  = target < middleValue && middleValue > leftValue && middleValue > rightValue && target > leftValue && target > rightValue;
      boolean leftStateThree = target < middleValue && middleValue < leftValue && middleValue < rightValue && target < rightValue && target < leftValue;
      boolean leftStateTwo   = target > middleValue && middleValue < leftValue && middleValue < rightValue && target > rightValue && target > leftValue;

      if (leftStateOne || leftStateTwo || leftStateThree || leftStateFour) {
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
