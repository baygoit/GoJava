package ua.goit.alg;

import java.io.File;

public class Main {
  public static void main(String[] args) {
    File originFile = new File("D:/Dir/1.txt");
    String dirPath = "D:/Dir";

    Array.mergeSort(originFile, dirPath);
  }
}
