package ua.goit.alg;

import java.io.*;

/**
 * Created by Aleksey Kurkov on 3/25/15.
 */
public class Arrays {
  
  private static final int MAX_BUFFER_SIZE = 10;
  public static int[] array = new int[MAX_BUFFER_SIZE];
  static File outputFile = new File("Output.txt");
  static DataInputStream disBig;
  static DataOutputStream dosTemp;
  
  public static void main(String[] args) throws FileNotFoundException {
    disBig = new DataInputStream(new FileInputStream("BigFile.txt"));
    dosTemp = new DataOutputStream(new FileOutputStream("temp.txt"));

    boolean eof = false;

    while (!eof) {
      try {
        for (int i = 0; i < MAX_BUFFER_SIZE; i++) {
          array[i] = disBig.readInt();
        }
        System.out.println("\nArray:");

        printArray(array);
        sortArray();
        System.out.println("\nSorted Array:");
        printArray(array);

        System.out.println();

        writeBufferToTempFile();

      } catch (IOException e) {
        eof = true;
      }
    }
    try {
      disBig.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
    try {
      dosTemp.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void writeArrayToFile(int[] intArray, File fileName) {
    try {
      DataOutputStream dos = new DataOutputStream(new FileOutputStream(fileName));
      for (int i = 0; i < intArray.length; i++) {
        try {
          dos.write(intArray[i]);
        } catch (IOException e) {
          e.printStackTrace();
        }
        System.out.print(intArray[i] + " ");
      }
      try {
        dos.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }

  public static int[] readArrayFromFile(File fileName) throws IOException {
    int[] intArray = new int[0];
      DataInputStream dis = new DataInputStream(new FileInputStream(fileName));
      for (int i = 0; i < intArray.length; i++) {
          intArray[i] = dis.readInt();
        }
        dis.close();
    for (int i = 0; i < intArray.length; i++) {
      System.out.print(intArray[i] + " ");
    }
    return intArray;
  }

  public static void readBufferFromFile(File file) throws IOException {
    DataInputStream dataInputStream1 = new DataInputStream(new FileInputStream(file));

    for (int i = 0; i < MAX_BUFFER_SIZE; i++) {
      System.out.println(dataInputStream1.readInt());
    }
    System.out.println();

    dataInputStream1.close();
  }

  public static void writeBufferToTempFile() throws IOException {

    for (int i = 0; i < MAX_BUFFER_SIZE; i++) {
      dosTemp.writeInt(array[i]);
    }
  }


  public static void printArray(int[] intArray) {
    for (int i = 0; i < MAX_BUFFER_SIZE; i++) {
      System.out.println(intArray[i]);
    }
  }

  public static void getArray(String[] stringArray) {
    array = new int[stringArray.length];
    for (int i = 0; i < stringArray.length; i++) {
      array[i] = Integer.parseInt(stringArray[i]);
    }
  }

  public static void sortArray() {
    int[] tempArray = new int[array.length];
    sort(tempArray, 0, array.length - 1);
  }

  public static void sort(int[] tempArray, int start, int end) {
    if (end == start) {
      return;
    } else {
      int middle = safeFindMiddle(start, end);
      int middlePlusOne = middle + 1;
      sort(tempArray, start, middle);
      sort(tempArray, middlePlusOne, end);
      merge(tempArray, start, middlePlusOne, end);
    }
  }

  public static final int safeFindMiddle(int a, int b) {
    if (b > 0 ? a > Integer.MAX_VALUE - b
            : a < Integer.MIN_VALUE - b) {
      return a + b >>> 1;
    }
    return (a + b) / 2;
  }

  public static void merge(int[] tempArray, int cursor, int middlePlusOne, int end) {
    int index = 0;
    int start = cursor;
    int middle = middlePlusOne - 1;
    int countArrayElements = end - start + 1;
    while (start <= middle && middlePlusOne <= end) {
      if (array[start] < array[middlePlusOne]) {
        tempArray[index++] = array[start++];
      } else {
        tempArray[index++] = array[middlePlusOne++];
      }
    }
    while (start <= middle) {
      tempArray[index++] = array[start++];
    }
    while (middlePlusOne <= end) {
      tempArray[index++] = array[middlePlusOne++];
    }
    for (int i = 0; i < countArrayElements; i++) {
      array[cursor + i] = tempArray[i];
    }
  }

  public static void mergeSort(File file) {

  }
}
