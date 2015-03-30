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
  private static final String TEST_FILE ="testFile.txt";
  private static final String PATH_TO_TEST_FILE ="src/ua/goit/alg/test/testFiles/";
  private static final String RESULT_FILE ="result.txt";
   @BeforeClass
   public static void init() {
     BigFileMerge fileMerge = new BigFileMerge();
     try {
       long startTime = System.nanoTime();
       fileMerge.mergeSortFile(BIG_FILE_UNIX, PATH_TO_BIG_FILE + RESULT_FILE_NAME);
       long endTime = System.nanoTime();

       duration = (endTime - startTime)/1000000/1000;
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
    String fileAfterSort;
    int[] expecteds = {6, 8, 1, 0, 3, 2, 5, 5, 3, 12, 32, 43, 53, 12, 23, 34, 56, 67, 2, 34 , 345,2 , 234, 236, 765};
    byte[] actuals = new byte[expecteds.length * 4];
    DataOutputStream dataToFile = new DataOutputStream(new FileOutputStream(new File(PATH_TO_TEST_FILE + TEST_FILE)));
    dataToFile.write(Parser.parseIntArrayToByteArray(expecteds));
    dataToFile.close();

    BigFileMerge fileMerge = new BigFileMerge();
    fileAfterSort = fileMerge.mergeSortFile(PATH_TO_TEST_FILE + TEST_FILE, RESULT_FILE);
    DataInputStream dataFromFile = new DataInputStream( new FileInputStream(fileAfterSort));
    Arrays.sort(expecteds);
    dataFromFile.read(actuals);
    assertArrayEquals(expecteds, Parser.parseByteArrayToIntArray(actuals));

  }

}
