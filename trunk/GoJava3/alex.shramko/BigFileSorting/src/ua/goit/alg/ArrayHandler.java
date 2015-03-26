package ua.goit.alg;

public class ArrayHandler {
  
  public static String arrayToString(int[] array) {
    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < array.length; i++) {
      if (builder.length() > 0) {
        builder.append(" ");
      }
      builder.append(array[i]);
    }
    return builder.toString();
  }

  public static int[] sortArray(int[] array) {
    return MergeSort.mergeSort(array);
  }
}
