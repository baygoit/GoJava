package ua.goit.alg;

import junit.framework.TestCase;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertArrayEquals;

/**
 * Created by Aleksey Kurkov on 3/26/15.
 */
public class ArraysTest extends TestCase {

  public void testCreateFile() {
    int[] expectedArray = new int[]{5, 4, 3, 2, 1};
    int[] actualArray = new int[0];
    File fileName = new File("testCreate.txt");
    Arrays.writeArrayToFile(expectedArray, fileName);
    try {
      expectedArray = Arrays.readArrayFromFile(fileName);
    } catch (IOException e) {
      e.printStackTrace();
    }
    assertArrayEquals(expectedArray, actualArray);
  }
}
