package ua.goit.alg;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Array {
  public static final int MAX_SIZE_ARRAY = 11;

  public static void mergeSort(File file, String dirPath) {
    List<File> topList = new ArrayList<>();
    try (DataInputStream dis = new DataInputStream(new FileInputStream(file))) {
      while (dis.available() > 0) {
        int[] buff = readIntArray(dis);
        mergeSort(buff);
        File tempFile = File.createTempFile("file", ".txt", new File(dirPath));
        topList.add(tempFile);
        writeIntArray(tempFile, buff);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }

    DataInputStream dis = null;
    DataOutputStream dos = null;
    try {
      File result = manyToOne(topList, dirPath);
      dis = new DataInputStream(new FileInputStream(result));
      dos = new DataOutputStream(new FileOutputStream (file));
      int num;
      while (dis.available() > 0) {
        num = dis.readInt();
        dos.writeInt(num);
      }
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      try {
        if (dis != null) {
          dis.close();
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
      try {
        if (dos != null) {
          dos.close();
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }

  public static File manyToOne(List<File> higherList, String dirPath)
          throws IOException {
    List<File> lowerList = new ArrayList<>();
    if (higherList.size() % 2 == 0) {
      for (int i = 0; i < higherList.size(); i += 2) {
        File tempFile = File.createTempFile("file", ".txt", new File(dirPath));
        lowerList.add(tempFile);
        mergeTwoFiles(higherList.get(i), higherList.get(i + 1), tempFile);
      }
    } else {
      for (int i = 0; i < higherList.size() - 1; i += 2) {
        File tempFile = File.createTempFile("file", ".txt", new File(dirPath));
        lowerList.add(tempFile);
        mergeTwoFiles(higherList.get(i), higherList.get(i + 1), tempFile);
      }
      lowerList.add(higherList.get(higherList.size() - 1));
    }

    if (lowerList.size() > 1) {
      manyToOne(lowerList, dirPath);
    }

    return lowerList.get(0);
  }

  public static void mergeTwoFiles(File file1, File file2, File tempFile)
          throws IOException {
    DataInputStream dis1 = new DataInputStream(new FileInputStream(file1));
    DataInputStream dis2 = new DataInputStream(new FileInputStream(file2));
    DataOutputStream dos = new DataOutputStream(new FileOutputStream(tempFile));

    if (dis1.available() > 0 && dis2.available() > 0) {
      int num1 = dis1.readInt();
      int num2 = dis2.readInt();
      while (dis1.available() > 0 && dis2.available() > 0) {
        if (num1 < num2 ) {
          dos.writeInt(num1);
          num1 = dis1.readInt();
        } else if (num2 < num1) {
          dos.writeInt(num2);
          num2 = dis2.readInt();
        } else {
          dos.writeInt(num1);
          dos.writeInt(num2);
          num1 = dis1.readInt();
          num2 = dis2.readInt();
        }
      }
      int lastNum1 = 1;
      int lastNum2 = 1;
      if (dis1.available() > 0) {
        while (lastNum2 > 0) {
          if (num1 <= num2) {
            dos.writeInt(num1);
            num1 = dis1.readInt();
          } else {
            dos.writeInt(num2);
            lastNum2--;
          }
        }
      }
      if (dis2.available() > 0) {
        while (lastNum1 > 0) {
          if (num2 <= num1) {
            dos.writeInt(num2);
            num2 = dis2.readInt();
          } else {
            dos.writeInt(num1);
            lastNum1--;
          }
        }
      }
      if (dis1.available() > 0) {
        while (dis1.available() > 0) {
          dos.writeInt(num1);
          num1 = dis1.readInt();
        }
        dos.writeInt(num1);
      }
      if (dis2.available() > 0) {
        while (dis2.available() > 0) {
          dos.writeInt(num2);
          num2 = dis2.readInt();
        }
        dos.writeInt(num2);
      }
    }
  }

  public static int[] readIntArray(DataInputStream dis) throws IOException {
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

  public static void writeIntArray(File file, int[] buff) throws IOException {
    try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(file))){
      for (int i : buff) {
        dos.writeInt(i);
      }
    }
  }

  public static void mergeSort(int[] array) {
    int[] subArray = new int[array.length];
    sort(array, subArray, 0, array.length - 1);

  }

  public static void sort(int[] array, int[] subArray, int first, int last) {
    if (first < last) {
      int middle = (first + last) / 2;
      sort(array, subArray, first, middle);
      sort(array, subArray, middle + 1, last);
      merge(array, subArray, first, middle + 1, last);
    }
  }

  public static void merge (int[] array, int[] subArray, int first, int middle, int last) {
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
