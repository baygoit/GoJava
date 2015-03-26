package ua.goit.alg;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Arrays {

  public static final int MAX_ARRAY_SIZE = 4;
  public static final int[] array = new int[MAX_ARRAY_SIZE];
  public static int currentIndex;

  public static void mergeSort(File file) {
    FileProcessor.resetTemporaryFileIndex();
    FileProcessor.createTemporaryDirectory();
    separateFile(file);
    FileProcessor.mergeFiles(file);
    FileProcessor.clearTemporaryDirectory();
  }

  public static void separateFile(File file) {
    try {
      FileInputStream fis = new FileInputStream(file);
      StringBuilder currentString = new StringBuilder();
      int c;
      while ((c = fis.read()) != -1) {
        char currentChar = (char) c;
        if (Character.isDigit(currentChar)) {
          currentString.append(currentChar);
        } else {
          if (currentString.length() != 0) {
            processString(currentString.toString());
            currentString = new StringBuilder();
          }
        }
      }
      processStringFinally(currentString.toString());
      fis.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private static void processStringFinally(String string) {
    int currentInt = Integer.parseInt(string.toString());
    array[currentIndex] = currentInt;
    int[] currentArray = java.util.Arrays.copyOf(array, currentIndex + 1);
    processArray(currentArray);
  }

  private static void processString(String string) {
    int currentInt = Integer.parseInt(string.toString());
    array[currentIndex] = currentInt;
    if (currentIndex == MAX_ARRAY_SIZE - 1) {
      processArray(array);
      currentIndex = 0;
    } else {
      currentIndex++;
    }
  }

  public static void processArray(int[] array) {
    int[] sortedArray = MergeSort.mergeSort(array);
    String str = arrayToString(sortedArray);
    FileProcessor.writeTemporaryFile(str);
  }
  
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

}
