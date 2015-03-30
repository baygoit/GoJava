package ua.goit.alg.sortBigFile;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static java.nio.file.StandardCopyOption.*;

public class FileOperations {
  public static void fileCopy(String from, String to) {
    try {
      Files.copy( Paths.get(from) , Paths.get(to) , REPLACE_EXISTING);
    } catch (IOException e) {
      throw new RuntimeException("some error with file copy");
    }
  }
  public static void dirClear(String dir) {
    File dirForDel = new File(dir);
    if (dirForDel.isDirectory()) {
      for (File fileName : dirForDel.listFiles()) {
        fileName.delete();
      }
    }
  }
}
