package ua.goit.alg;

import java.io.*;

public class Arrays {

  public static void mergeSort(File file) {

  }

  public static void writeArrayToFile(int[] array, File fileName) {
    DataOutputStream dos = null;
    try {
      dos = new DataOutputStream(new FileOutputStream(fileName));
      for (int i = 0; i < array.length; i++) {
        dos.writeInt(array[i]);
        System.out.print(array[i] + " ");
      }
      System.out.println();
      dos.close();
    } catch (FileNotFoundException e) {
      System.out.println("File " + fileName + " not found");
    } catch (IOException e) {
      System.out.println("\nCan't close the file " + fileName);
    } finally {
      try {
        dos.close();
      } catch (IOException e) {
        System.out.println("\nCan't close the file " + fileName);
      }
    }
  }

  public static int[] readArrayFromFile(File fileName) {
    int[] array = new int[5];
    boolean eof;
    DataInputStream dis = null;
    try {
      dis = new DataInputStream(new FileInputStream(fileName));
      int i = 0;
      eof = false;
      while (!eof) {
        array[i] = dis.readInt();
        System.out.print(array[i] + " ");
      }
      System.out.println();
    } catch (FileNotFoundException e) {
      System.out.println("File " + fileName + " not found");
    } catch (IOException e) {
      eof = true;
    } finally {
      try {
        dis.close();
      } catch (IOException e) {
        System.out.println("\nCan't close the file " + fileName);
      }
    }
    return array;
  }
}
