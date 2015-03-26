package ua.goit.alg;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

public class Arrays {

  public static final int MAX_ARRAY_SIZE = 3;
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
      char currentChar = ' ';
      currentIndex = 0;
      StringBuilder currentString = new StringBuilder();
      int c;
      while ((c = fis.read()) != -1) {
        currentChar = (char) c;
        if (Character.isDigit(currentChar)) {
          currentString.append(currentChar);
        } else {
          if (currentString.length() != 0) {
            processString(currentString.toString());
            currentString = new StringBuilder();
          }
        }
      }
      processFinallyString(currentString.toString());
      fis.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private static void processFinallyString(String string) {
    int currentInt = Integer.parseInt(string.toString());
    array[currentIndex] = currentInt;
    int[] currentArray;
    currentArray = java.util.Arrays.copyOf(array, currentIndex + 1);
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
    int[] sortedArray = ArrayHandler.sortArray(array);
    FileProcessor.writeArrayIntoTemporaryFile(sortedArray);
  }

  public static void main(String[] args) {
    try {
      String content = "5 6 8 11 21 5 4 3 6 6 99 0 98";
      File file = new File("/1.txt");
      if (!file.exists()) {
        file.createNewFile();
      }
      FileWriter fw = new FileWriter(file.getAbsoluteFile());
      BufferedWriter bw = new BufferedWriter(fw);
      bw.write(content);
      bw.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
    mergeSort(new File("/1.txt"));
  }

}
