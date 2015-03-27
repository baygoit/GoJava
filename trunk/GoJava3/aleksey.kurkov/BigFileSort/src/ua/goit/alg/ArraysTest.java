package ua.goit.alg;

import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertArrayEquals;
import static ua.goit.alg.Arrays.readArrayFromFile;
import static ua.goit.alg.Arrays.writeArrayToFile;

public class ArraysTest {

  @Test
  public void testWriteRead() {
    int[] expectedArray = new int[]{5, 4, 3, 2, 1};
    int[] actualArray;
    File fileName = new File("testWriteRead.txt");
    writeArrayToFile(expectedArray, fileName);
    actualArray = readArrayFromFile(fileName);
    assertArrayEquals(expectedArray, actualArray);
  }
}
