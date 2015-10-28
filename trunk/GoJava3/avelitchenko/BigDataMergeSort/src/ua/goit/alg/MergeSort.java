package ua.goit.alg;

public class MergeSort {

  public static void main(String[] args) {
    int[] source = { 2, 3, 2, 4, 3, 7, 2, 3, 4, 4 };
    int[] destination = new int[source.length];
    mergeSort(source, destination, 0, source.length - 1);
    for (int i = 0; i < destination.length; i++) {
      System.out.print(destination[i]);
      System.out.print(" ");
    }
  }

  public static void mergeSort(int[] source, int[] destination, int start,int finish) {

    if (start > finish) {
      return;
    }
    int length = finish - start + 1;

    if (length <= 2) {
      if (source[start] > source[finish]) {
        int localForSwap = source[start];
        source[start] = source[finish];
        source[finish] = localForSwap;
      }
      return;
    }

    int midle = start + (finish - start) / 2;
    mergeSort(source, destination, start, midle);
    mergeSort(source, destination, midle + 1, finish);

    // Merge sorted halves into destination
    int firsthalf = start;
    int secondhalf = midle + 1;
    for (int i = start; i <= finish; i++) {

      if (firsthalf == midle + 1)
        destination[i] = source[secondhalf++];
      else if (secondhalf == finish + 1)
        destination[i] = source[firsthalf++];
      else if (source[firsthalf] > source[secondhalf])
        destination[i] = source[secondhalf++];
      else
        destination[i] = source[firsthalf++];
    }
    // copy result to source
    for (int i = start; i <= finish; i++) {
      source[i] = destination[i];
    }
  }
}
