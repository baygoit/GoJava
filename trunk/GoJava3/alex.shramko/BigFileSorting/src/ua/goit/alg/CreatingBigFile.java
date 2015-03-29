package ua.goit.alg;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CreatingBigFile {
  public static void createFile(String filePath) {
    File file = new File(filePath);
    createFile(file);
  }
  
  public static void createFile(File file) {
    if (!file.exists()) {
      try {
        file.createNewFile();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    try {
      BufferedWriter bw = new BufferedWriter(new FileWriter(file));
      for (int i = 0; i < 100_000_000; i++) {
        if (i > 0) {
          bw.write(" ");
        }
        int rand = (int) (Math.random() * 1000);
        bw.write(Integer.toString(rand));
      }
      bw.close();
    } catch (IOException e) {
      e.printStackTrace();
    }

  }

  public static void main(String[] args) {
    createFile("/1.txt");
  }
}
