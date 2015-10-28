package ua.goit.alg;

public class RotatedArrays {

  public static int binarySearch(int[] array, int target) {
    if (array.length == 0) return -1;
    return startBinarySearch(array, target, 0, array.length - 1);
  }

  private static int startBinarySearch(int[] array, int target, int left, int right) {
    while (left <= right) {
      int middle = (right + left) >>> 1;
      int rightValue = array[right];
      int leftValue = array[left];
      int middleValue = array[middle];

      if (target == middleValue) return middle;
      if (target == leftValue) return left;
      if (target == rightValue) return right;

      boolean leftStateOne   = target < middleValue && middleValue > leftValue && middleValue < rightValue && target > leftValue && target  < rightValue;
      boolean leftStateTwo   = target > middleValue && middleValue < leftValue && middleValue < rightValue && target > rightValue && target > leftValue;
      boolean leftStateThree = target < middleValue && middleValue < leftValue && middleValue < rightValue && target < rightValue && target < leftValue;
      boolean leftStateFour  = target < middleValue && middleValue > leftValue && middleValue > rightValue && target > leftValue && target  > rightValue;

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

}
