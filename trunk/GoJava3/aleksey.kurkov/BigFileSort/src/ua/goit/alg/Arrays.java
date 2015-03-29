package ua.goit.alg;

import java.io.*;
import java.util.Vector;

public class Arrays {

  public static final int BUFFER_SIZE = 5;
  private static int filesCount;

  public static void mergeSort(File file) throws IOException {
    filesCount = 0;
    cutSortAndWrite(file, BUFFER_SIZE);
    StringBuilder tmpFileName1 = new StringBuilder(), tmpFileName2 = new StringBuilder(),
            tmpFileNameMergedFile = new StringBuilder();

    int indexTmpFile1 = 0;
    int indexTmpFile2 = 1;
    int indexOfMergedFile = 0;

    tmpFileName1.append('A');
    tmpFileName1.append(indexTmpFile1);

    tmpFileName2.append('A');
    tmpFileName2.append(indexTmpFile2);

    tmpFileNameMergedFile.append('B');
    tmpFileNameMergedFile.append(indexOfMergedFile);

    int nextNameLevel = filesCount / 2;

    while (filesCount > 1) {

      if (filesCount == nextNameLevel) {

        if (tmpFileName1.charAt(0) == 'A') {
          tmpFileName1.setCharAt(0, 'B');
          tmpFileName2.setCharAt(0, 'B');
          tmpFileNameMergedFile.setCharAt(0, 'A');
        } else if (tmpFileName1.charAt(0) == 'B') {
          tmpFileName1.setCharAt(0, 'A');
          tmpFileName2.setCharAt(0, 'A');
          tmpFileNameMergedFile.setCharAt(0, 'B');
        }
        nextNameLevel = filesCount / 2;
        indexTmpFile1 = 0;
        indexTmpFile2 = 1;
        indexOfMergedFile = 0;
      }
      if (filesCount == 2) {
        tmpFileNameMergedFile.delete(0, tmpFileNameMergedFile.length());
        tmpFileNameMergedFile.append("SortedBigFile");
      } else {
        tmpFileName1.delete(1, tmpFileName1.length());
        tmpFileName1.append(indexTmpFile1);
        tmpFileName2.delete(1, tmpFileName2.length());
        tmpFileName2.append(indexTmpFile2);
        tmpFileNameMergedFile.delete(1, tmpFileNameMergedFile.length());
        tmpFileNameMergedFile.append(indexOfMergedFile);
      }

      File file1 = new File(tmpFileName1 + ".txt");
      File file2 = new File(tmpFileName2 + ".txt");
      File fileMerged = new File(tmpFileNameMergedFile + ".txt");

      mergeTwoTempFiles(file1, file2, fileMerged);
      filesCount = filesCount - 1;
      indexTmpFile1 = indexTmpFile1 + 2;
      indexTmpFile2 = indexTmpFile2 + 2;
      indexOfMergedFile = indexOfMergedFile + 1;
    }
  }

  private static void mergeTwoTempFiles(File file1, File file2, File fileMerged) throws IOException {
    Vector<Integer> vector1 = new Vector<>();
    Vector<Integer> vector2 = new Vector<>();

    DataInputStream disFile1 = new DataInputStream(new FileInputStream(file1));
    DataInputStream disFile2 = new DataInputStream(new FileInputStream(file2));

    DataOutputStream dosMergedFile = new DataOutputStream(new
            FileOutputStream(fileMerged));

    while (disFile1.available() > 0) {
      
      for (int i = 0; i < BUFFER_SIZE && disFile1.available() > 0; i++) {
        vector1.add(disFile1.readInt());
      }

      for (int i = 0; i < BUFFER_SIZE && disFile2.available() > 0; i++) {
        vector2.add(disFile2.readInt());
      }

      while (true) {
        if (vector1.size() == 0) {
          for (int i = 0; i < vector2.size(); i++) {
            dosMergedFile.writeInt(vector2.get(i));
          }
          break;
        } else if (vector2.size() == 0) {
          for (int i = 0; i < vector1.size(); i++) {
            dosMergedFile.writeInt(vector1.get(i));
          }
          break;
        } else {

          if (vector1.get(0) == vector2.get(0)) {
            dosMergedFile.writeInt(vector1.get(0));
            dosMergedFile.writeInt(vector2.get(0));
            vector1.remove(0);
            vector2.remove(0);
          } else if (vector1.get(0) < vector2.get(0)) {
            dosMergedFile.writeInt(vector1.get(0));
            vector1.remove(0);
          } else if (vector2.get(0) < vector1.get(0)) {
            dosMergedFile.writeInt(vector2.get(0));
            vector2.remove(0);
          }
        }
      }
    }
    disFile1.close();
    disFile2.close();
    dosMergedFile.close();
  }

  public static void cutSortAndWrite(File file, int buffer) throws IOException {
    DataInputStream disFile = new DataInputStream(new FileInputStream(file));
    int[] array;
    Vector<Integer> vector = new Vector<>();
    int tmpFileIndex = 0;
    String tmpFileName;

    while (disFile.available() > 0) {

      for (int i = 0; i < buffer && disFile.available() > 0; i++) {
        vector.add(i, disFile.readInt());
      }
      array = new int[vector.size()];

      for (int i = 0; i < array.length; i++) {
        array[i] = vector.get(i);
      }
      new MergeSort(array);
      array = MergeSort.array;
      tmpFileName = "A" + tmpFileIndex + ".txt";
      File tmpFile = new File(String.valueOf(tmpFileName));
      writeArrayToFile(array, tmpFile);
      filesCount++;
      tmpFileIndex++;
      vector.clear();
    }
    disFile.close();
  }

  public static void writeArrayToFile(int[] array, File fileName) {
    DataOutputStream dos = null;
    try {
      dos = new DataOutputStream(new FileOutputStream(fileName));

      for (int i = 0; i < array.length; i++) {
        dos.writeInt(array[i]);
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
        i++;
      }
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
