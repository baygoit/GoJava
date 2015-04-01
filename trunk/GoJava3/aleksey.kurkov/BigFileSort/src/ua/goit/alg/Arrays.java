package ua.goit.alg;

import java.io.*;
import java.util.Vector;

public class Arrays {
  public static final int BUFFER_SIZE = 5;
  private static int filesCount;

  public static void mergeSort(File file) throws IOException {
    filesCount = 0;
    boolean evenNumberOfFiles;
    cutSortAndWrite(file, BUFFER_SIZE);
    if (filesCount % 2 == 0) {
      evenNumberOfFiles = true;
    } else {
      evenNumberOfFiles = false;
    }
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
        tmpFileName1.delete(1, tmpFileName1.length());
        tmpFileName1.append(indexTmpFile1);
        tmpFileName2.delete(1, tmpFileName2.length());
        tmpFileName2.append(indexTmpFile2);
        tmpFileNameMergedFile.delete(1, tmpFileNameMergedFile.length());
        tmpFileNameMergedFile.append(indexOfMergedFile);
      }

      if (filesCount == 2) {
        tmpFileNameMergedFile.delete(0, tmpFileNameMergedFile.length());
        tmpFileNameMergedFile.append("SortedBigFile");
      } else if (filesCount == 3 && !evenNumberOfFiles) {
        tmpFileName1.delete(1, tmpFileName1.length());
        tmpFileName1.append(indexTmpFile1);
        tmpFileName2.delete(1, tmpFileName2.length());
        tmpFileName2.append(indexTmpFile2);

        File fileMerged = new File(tmpFileNameMergedFile + ".txt");
        File file2 = new File(tmpFileName2 + ".txt");
        fileMerged.renameTo(file2);

        tmpFileNameMergedFile.delete(1, tmpFileNameMergedFile.length());
        indexOfMergedFile = indexOfMergedFile - 1;
        tmpFileNameMergedFile.append(indexOfMergedFile);
        indexOfMergedFile = indexOfMergedFile + 1;
        evenNumberOfFiles = true;
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

  private static void mergeTwoTempFiles(File file1, File file2, File fileMerged) {
    int value1 = 0, value2 = 0;
    boolean readNextValue1 = true;
    boolean readNextValue2 = true;
    boolean endOfFile1 = false;
    boolean endOfFile2 = false;

    DataInputStream disFile1 = null;
    try {
      disFile1 = new DataInputStream(new FileInputStream(file1));
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }

    DataInputStream disFile2 = null;
    try {
      disFile2 = new DataInputStream(new FileInputStream(file2));
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }

    DataOutputStream dosMergedFile = null;
    try {
      dosMergedFile = new DataOutputStream(new
              FileOutputStream(fileMerged));
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }

    while (true) {

      if (!endOfFile1 || !endOfFile2) {

        if (endOfFile1) {
          try {
            dosMergedFile.writeInt(value2);
          } catch (IOException e) {
            e.printStackTrace();
          }
          readNextValue2 = true;
        }

        if (endOfFile2) {
          try {
            dosMergedFile.writeInt(value1);
          } catch (IOException e) {
            e.printStackTrace();
          }
          readNextValue1 = true;
        }

        if (readNextValue1 != false && !endOfFile1) {
          try {
            value1 = disFile1.readInt();
          } catch (EOFException e) {
            endOfFile1 = true;
            readNextValue1 = false;
          } catch (IOException e) {
            e.printStackTrace();
          }
        }
        if (readNextValue2 != false && !endOfFile2) {
          try {
            value2 = disFile2.readInt();
          } catch (EOFException e) {
            endOfFile2 = true;
            readNextValue2 = false;
          } catch (IOException e) {
            e.printStackTrace();
          }
        }

        if (value1 == value2 && !endOfFile1 && !endOfFile2) {
          try {
            dosMergedFile.writeInt(value1);
          } catch (EOFException e) {
            endOfFile1 = true;
          } catch (IOException e) {
            e.printStackTrace();
          }
          try {
            dosMergedFile.writeInt(value2);
          } catch (EOFException e) {
            endOfFile2 = true;
          } catch (IOException e) {
            e.printStackTrace();
          }
          readNextValue1 = true;
          readNextValue2 = true;
        } else if (value1 < value2 && !endOfFile1 && !endOfFile2) {
          try {
            dosMergedFile.writeInt(value1);
          } catch (EOFException e) {
            endOfFile1 = true;
          } catch (IOException e) {
            e.printStackTrace();
          }
          readNextValue1 = true;
          readNextValue2 = false;
        } else if (value2 < value1 && !endOfFile1 && !endOfFile2) {
          try {
            dosMergedFile.writeInt(value2);
          } catch (EOFException e) {
            endOfFile2 = true;
          } catch (IOException e) {
            e.printStackTrace();
          }
          readNextValue1 = false;
          readNextValue2 = true;
        }
      } else if (endOfFile1 && !endOfFile2) {
        try {
          dosMergedFile.writeInt(value2);
        } catch (EOFException e) {
          endOfFile2 = true;
        } catch (IOException e) {
          e.printStackTrace();
        }
        readNextValue1 = false;
        readNextValue2 = true;
      } else if (!endOfFile1 && endOfFile2) {
        try {
          dosMergedFile.writeInt(value1);
        } catch (EOFException e) {
          endOfFile1 = true;
        } catch (IOException e) {
          e.printStackTrace();
        }
        readNextValue1 = true;
        readNextValue2 = false;
      } else if (endOfFile1 && endOfFile2) {
        break;
      }
    }

    try {
      disFile1.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
    try {
      disFile2.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
    try {
      dosMergedFile.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
    file1.delete();
    file2.delete();
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