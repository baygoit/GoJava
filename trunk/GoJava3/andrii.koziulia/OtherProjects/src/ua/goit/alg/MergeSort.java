package ua.goit.alg;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Alex on 16.03.2015.
 */
public class MergeSort {
  private static final int BYTES_IN_TEN_KILOBYTES = 1048576;

  public static void mergeSort(int[] array) {
    mergeSort(array, 0, array.length - 1);
  }

  public static void mergeSort(int[] array, int firstElement, int lastElement) {
    if (firstElement < lastElement) {
      int partitionElement = firstElement + (lastElement - firstElement) / 2;
      mergeSort(array, firstElement, partitionElement);
      mergeSort(array, partitionElement + 1, lastElement);
      mergeArrays(array, firstElement, partitionElement, lastElement);
    }
  }

  private static void mergeArrays(int[] array, int firstElement, int partitionElement, int lastElement) {
    int elementsInLeftArray = partitionElement - firstElement + 1;
    int elementsInRightArray = lastElement - partitionElement;
    int[] leftArray = new int[elementsInLeftArray + 1];
    int[] rightArray = new int[elementsInRightArray + 1];
    for (int i = 0; i < leftArray.length - 1; i++) {
      leftArray[i] = array[firstElement + i];
    }
    for (int i = 0; i < rightArray.length - 1; i++) {
      rightArray[i] = array[partitionElement + i + 1];
    }
    leftArray[leftArray.length - 1] = Integer.MAX_VALUE;
    rightArray[rightArray.length - 1] = Integer.MAX_VALUE;
    int leftPosition = 0;
    int rightPosition = 0;
    for (int i = firstElement; i <= lastElement; i++) {
      if (leftArray[leftPosition] <= rightArray[rightPosition]) {
        array[i] = leftArray[leftPosition];
        leftPosition++;
      } else {
        array[i] = rightArray[rightPosition];
        rightPosition++;
      }
    }
  }

  /**
   * Function is used for sorting big files by the way of dividing them into smaller portions 10 KB each. Function
   * requires inputting a file with Integers written using DataInputStream. It returns sorted file with Integers
   * written using DataOutputStream.
   *
   * @param file
   * @return sorted file located in the same directory with the source file
   */
  public static File mergeSort(File file) {
    File sortedBigFile = null;
    try {
      sortedBigFile = sortBigFile(file);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    return sortedBigFile;
  }

  private static File sortBigFile(File file) throws IOException {
    ArrayList<File> tempFiles = new ArrayList<File>();
    splitToTempFiles(file, tempFiles);
    File resultFile = createTempFile();
    mergeTempFiles(tempFiles);
    if (tempFiles.size() > 1) {
      combineTwoFiles(tempFiles.get(0), tempFiles.get(1), resultFile);
    } else if (tempFiles.size() == 1) {
      combineTwoFiles(tempFiles.get(0), resultFile, resultFile);
    }
    return resultFile;
  }

  private static void splitToTempFiles(File file, ArrayList<File> tempFiles) throws IOException {
    DataInputStream dataInputStream = null;
    try {
      dataInputStream = new DataInputStream(new BufferedInputStream(new FileInputStream(file)));
      byte[] buffer = new byte[BYTES_IN_TEN_KILOBYTES];
      int[] tempValues = new int[BYTES_IN_TEN_KILOBYTES / 4];
      int valuesInBuffer = 0;
      while (dataInputStream.available() > 0) {
        valuesInBuffer = dataInputStream.read(buffer);
        for (int i = 0; i < valuesInBuffer; i += 4) {
          int intValue = getIntegerFromFourBytes(buffer, i);
          tempValues[i / 4] = intValue;
        }
        mergeSort(tempValues, 0, valuesInBuffer / 4 - 1);
        File tempFile = createTempFile(tempFiles);
        writeToFile(tempFile, tempValues, valuesInBuffer / 4);
      }
    } finally {
      dataInputStream.close();
    }
  }

  private static int getIntegerFromFourBytes(byte[] byteArray, int startIndex) {
    int value = ((0xFF & byteArray[startIndex]) << 24) | ((0xFF & byteArray[startIndex + 1]) << 16) |
            ((0xFF & byteArray[startIndex + 2]) << 8) | (0xFF & byteArray[startIndex + 3]);
    return value;
  }

  private static File createTempFile() {
    File tempFile = null;
    try {
      tempFile = File.createTempFile("MergeSort_tempFile", ".tmp");
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    tempFile.deleteOnExit();
    return tempFile;
  }

  private static File createTempFile(ArrayList<File> tempFiles) {
    File file = createTempFile();
    tempFiles.add(file);
    return file;
  }

  private static void writeToFile(File file, int[] intArray, int numberToWrite) throws IOException {
    DataOutputStream outputStream = null;
    try {
      outputStream = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
      for (int i = 0; i < numberToWrite; i++) {
        outputStream.writeInt(intArray[i]);
      }
    } finally {
      outputStream.close();
    }
  }

  private static void mergeTempFiles(ArrayList<File> tempFiles) throws IOException {
    while (tempFiles.size() > 2) {
      File newTempFile = createTempFile();
      combineTwoFiles(tempFiles.get(0), tempFiles.get(1), newTempFile);
      tempFiles.remove(1);
      tempFiles.remove(0);
      tempFiles.add(newTempFile);
    }
  }

  private static void combineTwoFiles(File firstFile, File secondFile, File resultFile) throws IOException {
    DataOutputStream outputStream = null;
    DataInputStream firstFileInputStream = null;
    DataInputStream secondFileInputStream = null;
    try {
      firstFileInputStream = new DataInputStream(new BufferedInputStream(new FileInputStream(firstFile)));
      secondFileInputStream = new DataInputStream(new BufferedInputStream(new FileInputStream(secondFile)));
      outputStream = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(resultFile)));
      byte[] firstBuffer = new byte[BYTES_IN_TEN_KILOBYTES];
      byte[] secondBuffer = new byte[BYTES_IN_TEN_KILOBYTES];
      int elementsInFirst = 0;
      int firstPointer = 0;
      int value1 = 0;
      if (firstFileInputStream.available() > 0) {
        elementsInFirst = firstFileInputStream.read(firstBuffer);
      }
      int elementsInSecond = 0;
      int secondPointer = 0;
      int value2 = 0;
      if (secondFileInputStream.available() > 0) {
        elementsInSecond = secondFileInputStream.read(secondBuffer);
      }
      while (firstPointer < elementsInFirst || secondPointer < elementsInSecond) {
        if (firstPointer < elementsInFirst) {
          value1 = getIntegerFromFourBytes(firstBuffer, firstPointer);
        } else if (firstFileInputStream.available() == 0) {
          value1 = Integer.MAX_VALUE;
        }
        if (secondPointer < elementsInSecond) {
          value2 = getIntegerFromFourBytes(secondBuffer, secondPointer);
        } else if (secondFileInputStream.available() == 0) {
          value2 = Integer.MAX_VALUE;
        }
        if (value1 <= value2) {
          outputStream.writeInt(value1);
          firstPointer += 4;
        } else {
          outputStream.writeInt(value2);
          secondPointer += 4;
        }
        if (firstPointer == elementsInFirst && firstFileInputStream.available() > 0) {
          elementsInFirst = firstFileInputStream.read(firstBuffer);
          firstPointer = 0;
        }
        if (secondPointer == elementsInSecond && secondFileInputStream.available() > 0) {
          elementsInSecond = secondFileInputStream.read(secondBuffer);
          secondPointer = 0;
        }
      }
    } finally {
      outputStream.close();
      firstFileInputStream.close();
      secondFileInputStream.close();
    }
  }
}