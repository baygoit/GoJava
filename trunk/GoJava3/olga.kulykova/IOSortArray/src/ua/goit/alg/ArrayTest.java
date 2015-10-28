package ua.goit.alg;

import org.junit.Test;

import java.io.*;

import static org.junit.Assert.assertArrayEquals;


public class ArrayTest{

  @Test
  public void inputTest() throws IOException {
    File file = new File("D:/Dir/3.txt");
    DataInputStream dis = new DataInputStream(new FileInputStream(file));
    int[] expected = {2, 1};
    int[] actual = Array.readIntArray(dis);
    assertArrayEquals(expected, actual);
  }

  @Test
  public void InputOutputTest() throws IOException {
    File file = new File("D:/Dir/3.txt");
    DataInputStream dis = new DataInputStream(new FileInputStream(file));
    int[] writtenArray = {2, 1};
    Array.writeIntArray(file, writtenArray);
    int[] readArray = Array.readIntArray(dis);
    assertArrayEquals(writtenArray, readArray);
  }

  @Test
  public void mergeSortTest() {
    int[] array = {2, 1};
    int[] expected = {1, 2};
    Array.mergeSort(array);
    assertArrayEquals(expected, array);
  }

  @Test
  public void mergeTwoFilesTest() throws IOException {
    File file1 = new File("D:/Dir/2.txt");
    File file2 = new File("D:/Dir/3.txt");
    File file3 = new File("D:/Dir/4.txt");
    int[] array1 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    int[] array2 = {4};
    Array.writeIntArray(file1, array1);
    Array.writeIntArray(file2, array2);
    Array.mergeTwoFiles(file1, file2, file3);

    DataInputStream dis = new DataInputStream(new FileInputStream(file3));
    int[] result = new int[11];
    int count = 0;
    while (dis.available() > 0) {
      result[count] = dis.readInt();
      count++;
    }

    int[] expected = {0, 1, 2, 3, 4, 4, 5, 6, 7, 8, 9};
    assertArrayEquals(expected, result);
  }

  @Test
  public void mergeSortFileTest() throws IOException {
    File originFile = new File("D:/Dir/oldFile.txt");
    int[] arrayNotSorted = {8, 2, 5, 4, 6, 1, 7, 9, 0, 3, 4};
    Array.writeIntArray(originFile, arrayNotSorted);
    Array.mergeSort(originFile, "D:/Dir");
    DataInputStream dis = new DataInputStream(new FileInputStream(originFile));
    int[] arraySorted = Array.readIntArray(dis);
    int[] expected = {0, 1, 2, 3, 4, 4, 5, 6, 7, 8, 9};
    assertArrayEquals(expected, arraySorted);
  }
}