package ua.goit.alg;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CreatingBigFile {
  public static boolean createFile(String filePath) throws IOException {
    File file = new File(filePath);
      createFile(file);
    if (file.exists()) {
      return true;
    } else {
      return false;
    }
  }

  public static void createFile(File file) throws IOException {
    if (!file.exists()) {
      try {
        file.createNewFile();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

    BufferedWriter bw = new BufferedWriter(new FileWriter(file));
    for (int i = 0; i < 100_000_000; i++) {
      if (i > 0) {
        bw.write(" ");
      }
      int rand = (int) (Math.random() * 1000);
      bw.write(Integer.toString(rand));
    }
    bw.close();

  }

  public static void main(String[] args) {
    try {
      createFile("/1.txt");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
