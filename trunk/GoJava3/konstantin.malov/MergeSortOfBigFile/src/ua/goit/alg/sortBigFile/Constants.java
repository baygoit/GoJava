package ua.goit.alg.sortBigFile;

import java.io.File;

/**
 * Created by kossovec on 30.03.15.
 */
public class Constants {
  private Constants() {

  }

  public static final int BYTE_BUFFER_SIZE = 1024 * 512; // 512 KB
  public static final String PATH_TO_TEMP_DIR_UNIX = "/home/kossovec/temp/";
  public static final String PATH_TO_BIG_FILE = "/home/kossovec/";
  public static final String BIG_FILE_UNIX = PATH_TO_BIG_FILE + "1.txt";
  public static final String TEMP_FILE_NAME = "tempFile_";
  public static final String FILE_TYPE = ".txt";
  public static final String RESULT_FILE_NAME = "2.txt";
}
