package ua.goit.alg.sortBigFile;

public class MergeSort {
  public static int[] mergeSort(int[] array) {
    mergeSort(array, new int[array.length], 0, array.length);
    return array;
  }

  private static int[] mergeSort(int[] array, int[] buffer, int start, int end) {
    if (start + 1 < end) {
      int mid = (start + end) / 2;
      mergeSort(array, buffer, start, mid);
      mergeSort(array, buffer, mid, end);
      merge(array, buffer, start, mid, end);
    }

    return array;
  }

  private static int[] merge(int[] array, int[] buffer, int start, int mid, int end) {
    int right = start;
    int left = mid;
    int count = start;
    System.arraycopy(array, start, buffer, start, end - start);
    while (right < mid && left < end) {
      if (buffer[right] < buffer[left]) {
        array[count] = buffer[right];
        right++;
      } else {
        array[count] = buffer[left];
        left++;
      }
      count++;
    }

    if (right < mid) {
      System.arraycopy(buffer, right, array, count, mid - right);
    }

    if (left < end) {
      System.arraycopy(buffer, left, array, count, end - left);
    }

    return array;
  }
}
