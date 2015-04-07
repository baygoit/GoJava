package ua.goit.alg.test;

import ua.goit.alg.sortBigFile.BigFileMerge;
import ua.goit.alg.sortBigFile.Parser;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.*;
import java.util.Arrays;

import static ua.goit.alg.sortBigFile.Constants.*;

import static org.junit.Assert.assertArrayEquals;

public class TestMainFunction {
  private static long duration = 0;
  private static final String TEST_FILE = "testFile.txt";
  private static final String PATH_TO_TEST_FILE = "src/ua/goit/alg/test/testFiles/";
  private static final String RESULT_FILE = "result.txt";
  private int[] expected = {12, 4, 13, 1, 2, 5, 12, 3, 4, 5, 453, 2, 423, 42, 34, 324, 234,
          32, 432, 4, 23, 424, 2342, 4, 24, 222, 24, 24, 23, 4};

  @BeforeClass
  public static void mergeSort() {
    try {
      long startTime = System.nanoTime();
      BigFileMerge.mergeSortFile(BIG_FILE_UNIX, PATH_TO_BIG_FILE + RESULT_FILE_NAME,
              BYTE_BUFFER_SIZE);
      long endTime = System.nanoTime();
      duration = (((endTime - startTime) / 1000000) / 1000);
      // ((endTime - startTime) / 1000000(in ms)) / 1000 (in sec)
    } catch (IOException e) {
      throw new RuntimeException(e.getMessage());
    }
  }

  @Test
  public void testFileSizeBeforeAndAfterSort() {
    Assert.assertTrue(
            (new File(BIG_FILE_UNIX).length()) ==
                    new File(PATH_TO_BIG_FILE + RESULT_FILE_NAME).length());
  }

  @Test
  public void testSortFileExist() {
    Assert.assertTrue(new File(PATH_TO_BIG_FILE + RESULT_FILE_NAME).exists());
  }

  @Test
  public void testIfFileRealSort() throws IOException {
    String pathToTempFile = PATH_TO_TEST_FILE + TEST_FILE;
    writeToFile(expected, pathToTempFile);
    BigFileMerge.mergeSortFile(pathToTempFile, RESULT_FILE, 4);
    Arrays.sort(expected);
    assertArrayEquals(expected, readFromFile(RESULT_FILE));
  }

  @Test
  public void testIntToByteByteToIntConverse() {
    assertArrayEquals(expected, Parser.parseByteArrayToIntArray(Parser.parseIntArrayToByteArray(expected)));
  }

  private int[] readFromFile(String filePath) throws IOException {
    byte[] actual = new byte[expected.length * 4];
    DataInputStream dataFromFile = new DataInputStream(new FileInputStream(filePath));
    dataFromFile.read(actual);
    return Parser.parseByteArrayToIntArray(actual);
  }

  private void writeToFile(int[] intArray, String filePath) throws IOException {
    DataOutputStream dataToFile = new DataOutputStream(new FileOutputStream(new File(filePath)));
    dataToFile.write(Parser.parseIntArrayToByteArray(intArray));
    dataToFile.close();
  }

}
