package ua.goit.alg;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class TemporaryFileProcessor {
  public static String TEMPORARY_DIRECTORY_PATH = "/goit_temp/";
  public static String TEMPORARY_FILE_PREFIX = "temp_";
  public static int currentTemporaryFileIndex;

  public static void createTemporaryDirectory() {
    File dir = new File(TEMPORARY_DIRECTORY_PATH);
    dir.mkdir();
  }

  public static void writeTemporaryFile(String str) {
    String temporaryFilePath = TEMPORARY_DIRECTORY_PATH + TEMPORARY_FILE_PREFIX
        + currentTemporaryFileIndex + ".txt";
    currentTemporaryFileIndex++;
    File file = new File(temporaryFilePath);
    try {
      FileOutputStream fop = new FileOutputStream(file);
      if (!file.exists()) {
        file.createNewFile();
      }
      byte[] contentInBytes = str.getBytes();
      fop.write(contentInBytes);
      fop.flush();
      fop.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  
  public static void writeArrayIntoTemporaryFile(int[] array) {
    String str = ArrayHandler.arrayToString(array);
    writeTemporaryFile(str);
  }

  public static void mergeFiles() {
    // TODO Auto-generated method stub
    
  }

  public static void clearTemporaryDirectory() {
    // TODO Auto-generated method stub
    
  }

  public static void resetTemporaryFileIndex() {
    TemporaryFileProcessor.currentTemporaryFileIndex = 0;
  }
}
