package ua.goit.alg;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertArrayEquals;
import static ua.goit.alg.Arrays.cutSortAndWrite;
import static ua.goit.alg.Arrays.readArrayFromFile;
import static ua.goit.alg.Arrays.writeArrayToFile;

public class ArraysTest {

  @Test
  public void testWriteRead() {
    int[] expectedArray = new int[]{5, 4, 3, 2, 1, 10, 8};
    int[] actualArray;
    File fileName = new File("testWriteRead.txt");
    writeArrayToFile(expectedArray, fileName);
    actualArray = readArrayFromFile(fileName);
    assertArrayEquals(expectedArray, actualArray);
    fileName.deleteOnExit();
  }

  @Test
  public void testMergeSortArray() {
    int[] testArray = {5, 4, 3, 2, 1, 10, 8};
    int[] expectedArray = {1, 2, 3, 4, 5, 8, 10};
    new MergeSort(testArray);
    int[] actualArray = MergeSort.getArray();
    assertArrayEquals(expectedArray, actualArray);
  }

  @Test
  public void testCreateBigFile() throws IOException {
    int[] expectedArray = {5, 4, 3, 2, 1, 10, 8, 12, 13};
    File file = new File("testBigFile.txt");
    new BigFileMaker(expectedArray, file);
    int[] actualArray = readArrayFromFile(file);
    assertArrayEquals(expectedArray, actualArray);
    file.deleteOnExit();
  }

  @Test
  public void testBigFileToSortedArrays() throws IOException {
    int buffer = 5;
    int[] testArray = {5, 4, 3, 2, 1, 10, 8, 12, 13, 14};
    int[] expectedArrayA1 = {1, 2, 3, 4, 5};
    int[] expectedArrayA2 = {8, 10, 12, 13, 14};
    File file = new File("testBigFile.txt");
    new BigFileMaker(testArray, file);
    cutSortAndWrite(file, buffer);
    File fileA1 = new File ("A0.txt");
    int[] actualA1 = readArrayFromFile(fileA1);
    assertArrayEquals(expectedArrayA1, actualA1);
    File fileA2 = new File ("A1.txt");
    int[] actualA2 = readArrayFromFile(fileA2);
    assertArrayEquals(expectedArrayA2, actualA2);
    file.deleteOnExit();
    fileA1.deleteOnExit();
    fileA2.deleteOnExit();
  }
}
