package ua.goit.alg;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

public class Arrays {

  public static void mergeSort(File file) {

    String dir = file.getParent();
    String[] tempFiles = createTempFile(dir, 2);

    try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
      String line;
      while ((line = bufferedReader.readLine()) != null) {

      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }

    deleteTempFile(tempFiles);

  }

  public static String[] createTempFile(String dir, int amount) {
    String tempName = "temp";
    String[] tempFiles = new String[amount];
    for (int i = 0; i < amount; i++) {
      try {
        String newTempFileName = dir + "\\" + tempName + i;
        File testResource = new File(newTempFileName);
        testResource.createNewFile();
        tempFiles[i] = newTempFileName;
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

    return tempFiles;
  }

  public static void deleteTempFile(String[] tempFiles) {


    for (String file : tempFiles) {
      try {
        Files.delete(FileSystems.getDefault().getPath(file));
      } catch (IOException e) {
        e.printStackTrace();
      }

    }

  }

}
