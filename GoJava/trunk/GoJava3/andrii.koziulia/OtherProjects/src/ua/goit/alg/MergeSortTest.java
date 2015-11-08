package ua.goit.alg;

import org.junit.Test;

import java.io.*;
import java.util.Arrays;
import java.util.Random;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class MergeSortTest {

  @Test
  public void simpleArray() {
    int[] testArray = {1, 15, 2, 8, 3, 4, 19, 11, 6, 7, 4, 9, 3, 9, 2, 8};
    String expectedResult = "[1, 2, 2, 3, 3, 4, 4, 6, 7, 8, 8, 9, 9, 11, 15, 19]";
    MergeSort.mergeSort(testArray);
    assertEquals(expectedResult, Arrays.toString(testArray));
  }

  @Test
  public void oneValueArray() {
    int[] testArray = {1};
    String expectedResult = "[1]";
    MergeSort.mergeSort(testArray);
    assertEquals(expectedResult, Arrays.toString(testArray));
  }

  @Test
  public void twoValuesArray() {
    int[] testArray = {2, 1};
    String expectedResult = "[1, 2]";
    MergeSort.mergeSort(testArray);
    assertEquals(expectedResult, Arrays.toString(testArray));
  }

  @Test
  public void similarValuesArray() {
    int[] testArray = {2, 2, 2, 2, 2};
    String expectedResult = "[2, 2, 2, 2, 2]";
    MergeSort.mergeSort(testArray);
    assertEquals(expectedResult, Arrays.toString(testArray));
  }

  @Test
  public void sortFileContainingSmallReverseArrayFrom9To0() throws IOException {
    File tempFile = createTempFile();
    DataOutputStream outputStream = null;
    try {
      outputStream = new DataOutputStream(new FileOutputStream(tempFile));
      for (int i = 9; i >= 0; i--) {
        outputStream.writeInt(i);
      }
    } finally {
      outputStream.close();
    }
    File sortedFile = MergeSort.mergeSort(tempFile);
    int[] result = new int[10];
    int[] expected = new int[10];
    DataInputStream inputStream = new DataInputStream(new FileInputStream(sortedFile));
    for (int i = 0; i < 10; i++) {
      result[i] = inputStream.readInt();
      expected[i] = i;
    }
    assertArrayEquals(expected, result);
  }


  @Test
  public void sortFileContainingShuffledValuesFrom0to999999999() throws IOException {
    int VALUES_TO_TEST = 100000000;
    // Test with 100 million values completes in about 2 minutes
    int[] expected = new int[VALUES_TO_TEST];
    int[] testArray = new int[VALUES_TO_TEST];
    System.out.println("Creating arrays");
    for (int i = 0; i < testArray.length; i++) {
      testArray[i] = i;
      expected[i] = i;
    }
    System.out.println("Starting shuffle");
    shuffleArray(testArray);
    File tempFile = createTempFile();
    DataOutputStream outputStream = null;
    try {
      outputStream = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(tempFile)));
      System.out.println("Writing shuffled array to temp file");
      for (int i = 0; i < testArray.length; i++) {
        outputStream.writeInt(testArray[i]);
      }
    } finally {
      outputStream.close();
    }
    System.out.println("Sorting temp file");
    File sortedFile = MergeSort.mergeSort(tempFile);
    int[] result = new int[VALUES_TO_TEST];
    DataInputStream inputStream = new DataInputStream(new BufferedInputStream(new FileInputStream(sortedFile)));
    System.out.println("Reading the result");
    for (int i = 0; i < result.length; i++) {
      result[i] = inputStream.readInt();
    }
    assertArrayEquals(expected, result);
  }

  private static void shuffleArray(int[] array) {
    Random rnd = new Random();
    for (int i = array.length - 1; i > 0; i--) {
      int index = rnd.nextInt(i + 1);
      int a = array[index];
      array[index] = array[i];
      array[i] = a;
    }
  }

  @Test
  public void emptyFile() throws IOException {
    FileInputStream fileInputStream = null;
    try {
      File tempFile = createTempFile();
      File sortedFile = MergeSort.mergeSort(tempFile);
      fileInputStream = new FileInputStream(sortedFile);
      assertEquals(0, fileInputStream.available());
    } finally {
      fileInputStream.close();
    }
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
}