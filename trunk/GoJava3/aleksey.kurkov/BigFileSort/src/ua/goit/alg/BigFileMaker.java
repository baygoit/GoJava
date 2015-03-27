package ua.goit.alg;

import java.io.*;
import java.util.Random;

public class BigFileMaker {

  static final int FILE_LENGTH = 1000; // ~1Mb 999999
  static Random temp = new Random();
  static DataOutputStream dosBig;
  static File file = new File("BigFile.txt");

  public static void main(String[] args) throws IOException {

    FileOutputStream fosBig = new FileOutputStream(file);
    dosBig = new DataOutputStream(fosBig);

    while (true) {
      dosBig.writeInt(temp.nextInt(20));
      if (file.length() > FILE_LENGTH){
        break;
      }
    }
    System.out.println(file.length() + " bytes");
    dosBig.close();
  }
}
