package ua.goit.alg;

import java.io.*;
import java.util.Vector;

public class Arrays {

  public static void mergeSort(File file) {

  }

  public static void cutSortAndWrite(File file, int buffer) throws IOException {
    DataInputStream disFile = new DataInputStream(new FileInputStream(file));
    int[] array = new int[buffer];
    int tmpFileIndex = 0;
    String tmpFileName;

    while (disFile.available() > 0){

      for (int i = 0; i < array.length; i++) {
        array[i]=disFile.readInt();
      }
      new MergeSort(array);
      array = MergeSort.array;
      tmpFileName = "A" + tmpFileIndex + ".txt";
      File tmpFile = new File(String.valueOf(tmpFileName));
      writeArrayToFile(array, tmpFile);
      tmpFileIndex++;
    }
    disFile.close();
  }

  public static void writeArrayToFile(int[] array, File fileName) {
    DataOutputStream dos = null;
    try {
      dos = new DataOutputStream(new FileOutputStream(fileName));

      for (int i = 0; i < array.length; i++) {
        dos.writeInt(array[i]);
        //System.out.print(array[i] + " ");
      }
      dos.close();
    } catch (FileNotFoundException e) {
      System.out.println("File " + fileName + " not found");
    } catch (IOException e) {
      System.out.println("\nCan't close the file " + fileName);
    } finally {
      try {
        if (dos != null) {
          dos.close();
        }
      } catch (IOException e) {
        System.out.println("\nCan't close the file " + fileName);
      }
    }
  }

  public static int[] readArrayFromFile(File fileName) {
    Vector<Integer> vector = new Vector<>();
    DataInputStream dis = null;
    try {
      dis = new DataInputStream(new FileInputStream(fileName));
      int i = 0;

      while (dis.available() > 0) {
        vector.add(i, dis.readInt());
        //System.out.print(vector.get(i) + " ");
        i++;
      }
      //System.out.println();
    } catch (FileNotFoundException e) {
      System.out.println("File " + fileName + " not found");
    } catch (EOFException e) {
      System.out.println("\nEnd of file " + fileName);
    } catch (IOException e) {
      System.out.println("\nCan't close the file " + fileName);
    } finally {
      try {
        if (dis != null) {
          dis.close();
        }
      } catch (IOException e) {
        System.out.println("\nCan't close the file " + fileName);
      }
    }
    int[] array = new int[vector.size()];

    for (int i = 0; i < array.length; i++) {
      array[i] = vector.get(i);
    }
    return array;
  }
}
