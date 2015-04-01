package ua.goit.alg;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertArrayEquals;
import static ua.goit.alg.Arrays.*;

public class ArraysTest {

  @Test
  public void testWriteRead() {
    int[] expectedArray = new int[]{5, 4, 3, 2, 1, 10, 8};
    int[] actualArray;
    File fileName = new File("testWriteRead.txt");
    writeArrayToFile(expectedArray, fileName);
    actualArray = readArrayFromFile(fileName);
    assertArrayEquals(expectedArray, actualArray);
    fileName.delete();
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
    file.delete();
  }

  @Test
  // cut array to equal parts
  public void testBigFileToSortedArrays() throws IOException {
    int buffer = 5;
    int[] testArray = {5, 4, 3, 2, 1, 10, 8, 12, 13, 14};
    int[] expectedArrayA1 = {1, 2, 3, 4, 5};
    int[] expectedArrayA2 = {8, 10, 12, 13, 14};
    File file = new File("testBigFile.txt");
    new BigFileMaker(testArray, file);
    cutSortAndWrite(file, buffer);
    File fileA1 = new File("A0.txt");
    int[] actualA1 = readArrayFromFile(fileA1);
    assertArrayEquals(expectedArrayA1, actualA1);
    File fileA2 = new File("A1.txt");
    int[] actualA2 = readArrayFromFile(fileA2);
    assertArrayEquals(expectedArrayA2, actualA2);
    file.delete();
    fileA1.delete();
    fileA2.delete();
  }

  @Test
  // cut array to equal parts + last part that is smaller than others
  public void testBigFileToSortedArrays2() throws IOException {
    int buffer = 4;
    int[] testArray = {5, 4, 3, 2, 1, 10, 8, 12, 13, 14};
    int[] expectedArrayA0 = {2, 3, 4, 5};
    int[] expectedArrayA1 = {1, 8, 10, 12};
    int[] expectedArrayA2 = {13, 14};
    File file = new File("testBigFile.txt");
    new BigFileMaker(testArray, file);
    cutSortAndWrite(file, buffer);
    File fileA0 = new File("A0.txt");
    int[] actualA0 = readArrayFromFile(fileA0);
    assertArrayEquals(expectedArrayA0, actualA0);
    File fileA1 = new File("A1.txt");
    int[] actualA1 = readArrayFromFile(fileA1);
    assertArrayEquals(expectedArrayA1, actualA1);
    File fileA2 = new File("A2.txt");
    int[] actualA2 = readArrayFromFile(fileA2);
    assertArrayEquals(expectedArrayA2, actualA2);
    file.delete();
    fileA0.delete();
    fileA1.delete();
    fileA2.delete();
  }

  @Test
  public void testMerge2tmpFiles() throws IOException {
    //create BigFile
    int[] expectedArray = {5, 4, 3, 2, 1, 10, 8, 12, 13};
    File file = new File("BigFile.txt");
    new BigFileMaker(expectedArray, file);
    int[] actualArray = readArrayFromFile(file);
    assertArrayEquals(expectedArray, actualArray);
    // Merge 2 temp files
    mergeSort(file);
    expectedArray = new int[]{1, 2, 3, 4, 5, 8, 10, 12, 13};
    File mergedTmpFile = new File("SortedBigFile.txt");
    actualArray = readArrayFromFile(mergedTmpFile);
    assertArrayEquals(expectedArray, actualArray);
  }

  @Test
  public void testMergeFiles() throws IOException {
    //create BigFile
    File file = new File("BigFile.txt");
    File fileSorted = new File("SortedBigFile.txt");
    new BigFileMaker(20, file);
    //mergeSort
    mergeSort(file);
    int[] expectedArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
    int[] actualArray = readArrayFromFile(fileSorted);
    assertArrayEquals(expectedArray, actualArray);
  }

  @Test
  public void testMergeFiles2() throws IOException {
    //create BigFile
    File file = new File("BigFile.txt");
    File fileSorted = new File("SortedBigFile.txt");
    new BigFileMaker(21, file);
    //mergeSort
    mergeSort(file);
    int[] expectedArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19,
            20, 21};
    int[] actualArray = readArrayFromFile(fileSorted);
    assertArrayEquals(expectedArray, actualArray);
  }

}