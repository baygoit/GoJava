package ua.goit.alg.test;

import ua.goit.alg.sortBigFile.BigFileWithIntCreation;
import org.junit.Before;
import org.junit.Test;
import java.io.File;
import java.io.IOException;
import static ua.goit.alg.sortBigFile.Constants.*;
import static org.junit.Assert.*;

public class TestBigFile {
  @Before
  private void init() {
    BigFileWithIntCreation bigFileWithIntCreation = new BigFileWithIntCreation();
    try {
      bigFileWithIntCreation.createBigFileWithInt(BIG_FILE_UNIX);
    } catch (IOException e) {
      throw new RuntimeException("aaaaaa file error");
    }

  }

  @Test
  public void testBigFileExist() {
    File bigFile = new File(BIG_FILE_UNIX);;
    assertTrue(bigFile.isFile());
  }

  @Test
  public void testIsBigFileMoreThan10MB() {
    File bigFile = new File(BIG_FILE_UNIX);
    assertTrue(bigFileSizeInMb(bigFile) > 10);
  }

  private long bigFileSizeInMb(File bigFile) {
    return bigFile.length() / (1024 * 1024);
  }

}
