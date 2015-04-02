package ua.goit.alg;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Using for sorting numbres in text files MAX_ARRAY_SIZE - buffer size: size of
 * the sub-array which the file will divided at executional method:
 * Arrays.mergesort(File file); this method rewrite our file with new sorted
 * data
 * 
 * data format of the file: "1 2 3 .. n-1 n"
 */
public class Arrays {

  public static final int MAX_ARRAY_SIZE = 1_000_000;
  public static final int[] array = new int[MAX_ARRAY_SIZE];
  public static int currentIndex;

  public static void mergeSort(File file) {
    FileProcessor.resetTemporaryFileIndex();
    FileProcessor.createTemporaryDirectory();
    try {
      separateFile(file);
      FileProcessor.mergeFiles(file);
      FileProcessor.clearTemporaryDirectory();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private static void separateFile(File file) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader(file));
    StringBuilder currentString = new StringBuilder();
    int cursor = 0;
    while ((cursor = br.read()) != -1) {
      char currentChar = (char) cursor;
      if (Character.isDigit(currentChar)) {
        currentString.append(currentChar);
      } else {
        if (currentString.length() != 0) {
          processString(currentString.toString());
          currentString = new StringBuilder();
        }
      }
    }
    br.close();
    processStringFinally(currentString.toString());
  }

  private static void processStringFinally(String string) {
    array[currentIndex] = Integer.parseInt(string.toString());
    int[] currentArray = java.util.Arrays.copyOf(array, currentIndex + 1);
    processArray(currentArray);
  }

  private static void processString(String string) {
    array[currentIndex] = Integer.parseInt(string.toString());
    if (currentIndex == MAX_ARRAY_SIZE - 1) {
      processArray(array);
      currentIndex = 0;
    } else {
      currentIndex++;
    }
  }

  private static void processArray(int[] array) {
    int[] sortedArray = MergeSort.mergeSort(array);
    FileProcessor.writeTemporaryFile(arrayToString(sortedArray));
  }

  private static String arrayToString(int[] array) {
    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < array.length; i++) {
      if (builder.length() > 0) {
        builder.append(" ");
      }
      builder.append(array[i]);
    }
    return builder.toString();
  }

  public static void main(String[] args) {
    File file = new File("/1.txt");
    Arrays.mergeSort(file);
  }

}
