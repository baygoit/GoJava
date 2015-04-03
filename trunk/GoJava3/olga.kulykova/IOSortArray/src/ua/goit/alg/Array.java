package ua.goit.alg;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Array {
  public static final int MAX_SIZE_ARRAY = 11;
  private static List<File> allTempFiles = new ArrayList<>();

  public static void mergeSort(File file, String dirPath) {
    DataInputStream input = null;
    DataOutputStream output = null;
    List<File> topList = new ArrayList<>();
    try {
      input = new DataInputStream(new FileInputStream(file));
      oneFileToMany(dirPath, input, topList);
      input.close();

      File result = manyFilesToOne(topList, dirPath);
      input = new DataInputStream(new FileInputStream(result));
      output = new DataOutputStream(new FileOutputStream (file));
      writeResultToOriginalFile(input, output);
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      try {
        if (input != null) {
          input.close();
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
      try {
        if (output != null) {
          output.close();
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

    for (File tempFile : allTempFiles) {
      tempFile.delete();
    }
  }

  private static void writeResultToOriginalFile
          (DataInputStream input, DataOutputStream output) throws IOException {
    int num;
    while (input.available() > 0) {
      num = input.readInt();
      output.writeInt(num);
    }
  }

  private static void oneFileToMany(String dirPath, DataInputStream input,
                                    List<File> topList) throws IOException {
    while (input.available() > 0) {
      int[] buff = readIntArray(input);
      mergeSort(buff);
      File tempFile = File.createTempFile("file", ".txt", new File(dirPath));
      topList.add(tempFile);
      allTempFiles.add(tempFile);
      writeIntArray(tempFile, buff);
    }
  }

  static File manyFilesToOne(List<File> higherList, String dirPath)
          throws IOException {
    List<File> lowerList = new ArrayList<>();
    if (higherList.size() % 2 == 0) {
      for (int i = 0; i < higherList.size(); i += 2) {
        File tempFile = File.createTempFile("file", ".txt", new File(dirPath));
        lowerList.add(tempFile);
        allTempFiles.add(tempFile);
        mergeTwoFiles(higherList.get(i), higherList.get(i + 1), tempFile);
      }
    } else {
      for (int i = 0; i < higherList.size() - 1; i += 2) {
        File tempFile = File.createTempFile("file", ".txt", new File(dirPath));
        lowerList.add(tempFile);
        allTempFiles.add(tempFile);
        mergeTwoFiles(higherList.get(i), higherList.get(i + 1), tempFile);
      }
      lowerList.add(higherList.get(higherList.size() - 1));
    }

    if (lowerList.size() > 1) {
      manyFilesToOne(lowerList, dirPath);
    }

    return lowerList.get(0);
  }

  static void mergeTwoFiles(File firstFile, File secondFile, File tempFile)
          throws IOException {
    DataInputStream firstInput = new DataInputStream(new FileInputStream(firstFile));
    DataInputStream secondInput = new DataInputStream(new FileInputStream(secondFile));
    DataOutputStream output = new DataOutputStream(new FileOutputStream(tempFile));

    boolean twoInputsAvailable = firstInput.available() > 0
            && secondInput.available() > 0;
    if (twoInputsAvailable) {
      int num1 = firstInput.readInt();
      int num2 = secondInput.readInt();
      while (firstInput.available() > 0 && secondInput.available() > 0) {
        if (num1 < num2 ) {
          output.writeInt(num1);
          num1 = firstInput.readInt();
        } else if (num2 < num1) {
          output.writeInt(num2);
          num2 = secondInput.readInt();
        } else {
          output.writeInt(num1);
          output.writeInt(num2);
          num1 = firstInput.readInt();
          num2 = secondInput.readInt();
        }
      }
      int lastNum1 = 1;
      int lastNum2 = 1;
      if (firstInput.available() > 0) {
        while (lastNum2 > 0) {
          if (num1 <= num2) {
            output.writeInt(num1);
            num1 = firstInput.readInt();
          } else {
            output.writeInt(num2);
            lastNum2--;
          }
        }
      }
      if (secondInput.available() > 0) {
        while (lastNum1 > 0) {
          if (num2 <= num1) {
            output.writeInt(num2);
            num2 = secondInput.readInt();
          } else {
            output.writeInt(num1);
            lastNum1--;
          }
        }
      }
      if (firstInput.available() > 0) {
        while (firstInput.available() > 0) {
          output.writeInt(num1);
          num1 = firstInput.readInt();
        }
        output.writeInt(num1);
      }
      if (secondInput.available() > 0) {
        while (secondInput.available() > 0) {
          output.writeInt(num2);
          num2 = secondInput.readInt();
        }
        output.writeInt(num2);
      }
    }
  }

  static int[] readIntArray(DataInputStream dis) throws IOException {
    int[] buff = new int[MAX_SIZE_ARRAY];
    int num;
    int index = 0;

    while (index < buff.length && dis.available() > 0) {
      num = dis.readInt();
      buff[index] = num;
      index++;
    }
    if (index < buff.length - 1) {
      int[] newBuff = new int[index];
      System.arraycopy(buff, 0, newBuff, 0, newBuff.length);
      return newBuff;
    }
    return buff;
  }

  static void writeIntArray(File file, int[] buff) throws IOException {
    try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(file))){
      for (int i : buff) {
        dos.writeInt(i);
      }
    }
  }

  static void mergeSort(int[] array) {
    int[] subArray = new int[array.length];
    sort(array, subArray, 0, array.length - 1);

  }

  private static void sort(int[] array, int[] subArray, int first, int last) {
    if (first < last) {
      int middle = (first + last) / 2;
      sort(array, subArray, first, middle);
      sort(array, subArray, middle + 1, last);
      merge(array, subArray, first, middle + 1, last);
    }
  }

  private static void merge (int[] array, int[] subArray, int first, int middle, int last) {
    int j = middle - 1;
    int k = first;
    int len = last - first + 1;

    while (first <= j && middle <= last) {
      if (array[first] <= array[middle]) {
        subArray[k++] = array[first++];
      } else {
        subArray[k++] = array[middle++];
      }
    }

    while (first <= j) {
      subArray[k++] = array[first++];
    }

    while (middle <= last) {
      subArray[k++] = array[middle++];
    }

    for (int i = 0; i < len; i++, last--) {
      array[last] = subArray[last];
    }
  }
}
