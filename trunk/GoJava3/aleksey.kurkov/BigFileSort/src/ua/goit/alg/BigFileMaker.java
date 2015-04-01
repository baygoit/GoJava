package ua.goit.alg;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

public class BigFileMaker {
  static final int FILE_LENGTH = 1000; // ~1Mb 999999
  static Random temp = new Random();
  static DataOutputStream dosBig;
  static File file = new File("BigFile.txt");

  public BigFileMaker(int[] array, File fileName) throws IOException {
    FileOutputStream fosBig = new FileOutputStream(fileName);
    dosBig = new DataOutputStream(fosBig);

    for (int i = 0; i < array.length; i++) {
      dosBig.writeInt(array[i]);
    }
    dosBig.close();
  }
  public static void main(String[] args) throws IOException {
    FileOutputStream fosBig = new FileOutputStream(file);
    dosBig = new DataOutputStream(fosBig);

    while (true) {
      dosBig.writeInt(temp.nextInt(20));

      if (file.length() > FILE_LENGTH) {
        break;
      }
    }
    System.out.println(file.length() + " bytes");
    dosBig.close();
  }

  public BigFileMaker(int count, File file) throws
          IOException {
    FileOutputStream fosBig = new FileOutputStream(file);
    dosBig = new DataOutputStream(fosBig);

    for (int i = count; i > 0 ; i--) {
      dosBig.writeInt(i);
    }
    System.out.println("Created " + file + " " + file.length() + " bytes");
    dosBig.close();
  }
}