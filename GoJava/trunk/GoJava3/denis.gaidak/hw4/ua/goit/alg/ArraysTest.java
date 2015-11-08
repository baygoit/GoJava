package ua.goit.alg;

import org.junit.Before;
import org.junit.Test;
import java.io.*;
import java.util.Random;


public class ArraysTest {

  private File testFile;

  @Before
  public void createTestFile() throws IOException {
    int[] array = new int[10000];
    Random random = new Random();
    for (int i = 0; i < array.length; i++) {
      array[i] = random.nextInt(10000);
    }
    String filePath = System.getProperty("user.dir") + "\\hw4\\ua\\goit\\alg\\test\\";
    testFile = Arrays.createTempFile(array, filePath);
  }


  @Test
  public void testMergeSort() throws Exception {
    Arrays.mergeSort(testFile);
  }



}