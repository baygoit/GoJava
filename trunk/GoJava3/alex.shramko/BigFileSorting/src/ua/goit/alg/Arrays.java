package ua.goit.alg;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Arrays {

  public static final int MAX_ARRAY_SIZE = 3;

  public static void mergeSort(File file) {
    TemporaryFileProcessor.resetTemporaryFileIndex();
    TemporaryFileProcessor.createTemporaryDirectory();
    separateFile(file);
    TemporaryFileProcessor.mergeFiles();
    TemporaryFileProcessor.clearTemporaryDirectory();
  }

  public static void separateFile(File file) {
    try {
      FileInputStream fis = new FileInputStream(file);
      char currentChar;
      int[] array = new int[MAX_ARRAY_SIZE];
      int currentIndex = 0;
      StringBuilder currentString = new StringBuilder();
      while (fis.available() > 0) {
        currentChar = (char) fis.read();
        if (currentChar != ' ') {
          currentString.append(currentChar);
        } else {
          if (currentString.length() != 0) {
            int currentInt = Integer.parseInt(currentString.toString());
            currentString = new StringBuilder();
            array[currentIndex] = currentInt;
            if (currentIndex == MAX_ARRAY_SIZE - 1) {
              processArray(array);
              currentIndex = 0;
            } else {
              currentIndex++;
            }
          }
        }
      }
      fis.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void processArray(int[] array) {
    int[] sortedArray = ArrayHandler.sortArray(array);
    TemporaryFileProcessor.writeArrayIntoTemporaryFile(sortedArray);
  }

  public static void main(String[] args) {
    mergeSort(new File("/1.txt"));
  }

}
