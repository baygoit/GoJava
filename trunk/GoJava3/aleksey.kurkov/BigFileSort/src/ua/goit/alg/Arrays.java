package ua.goit.alg;

import java.io.*;
import java.util.Vector;

public class Arrays {
  public static final int BUFFER_SIZE = 5;
  private static int filesCount;

  public static void mergeSort(File file) throws IOException {
    filesCount = 0;
    boolean isEvenNumberOfFiles;
    cutSortAndWrite(file, BUFFER_SIZE);
    isEvenNumberOfFiles = checkIfNumberOfFilesIsEven();

    StringBuilder firstTempFileName = new StringBuilder(),
            secondTempFileName = new StringBuilder(),
            mergedTempFileName = new StringBuilder();

    int indexOfFirstTempFile = 0;
    int indexOfSecondTempFile = 1;
    int indexOfMergedFile = 0;

    firstTempFileName.append('A');
    firstTempFileName.append(indexOfFirstTempFile);

    secondTempFileName.append('A');
    secondTempFileName.append(indexOfSecondTempFile);

    mergedTempFileName.append('B');
    mergedTempFileName.append(indexOfMergedFile);

    int filesCountForChangingIndexes = filesCount / 2;

    while (filesCount > 1) {

      if (filesCount == filesCountForChangingIndexes) {
        changeLetterIndexes(firstTempFileName, secondTempFileName,
                mergedTempFileName);

        filesCountForChangingIndexes = filesCount / 2;
        indexOfFirstTempFile = 0;
        indexOfSecondTempFile = 1;
        indexOfMergedFile = 0;

        changeNumberIndexes(firstTempFileName, secondTempFileName,
                mergedTempFileName, indexOfFirstTempFile,
                indexOfSecondTempFile, indexOfMergedFile);
      }

      if (filesCount == 2) {
        changeNameOfResultFile(mergedTempFileName);
      } else if (filesCount == 3 && !isEvenNumberOfFiles) {
        indexOfMergedFile = getNewFilenameFromLastSortedFile(firstTempFileName, secondTempFileName, mergedTempFileName, indexOfFirstTempFile, indexOfSecondTempFile, indexOfMergedFile);
        isEvenNumberOfFiles = true;
      } else {
        changeNumberIndexes(firstTempFileName, secondTempFileName,
                mergedTempFileName, indexOfFirstTempFile,
                indexOfSecondTempFile, indexOfMergedFile);
      }

      File firstFile = new File(firstTempFileName + ".txt");
      File secondFile = new File(secondTempFileName + ".txt");
      File mergedFile = new File(mergedTempFileName + ".txt");

      mergeTwoTempFiles(firstFile, secondFile, mergedFile);
      filesCount = filesCount - 1;
      indexOfFirstTempFile = indexOfFirstTempFile + 2;
      indexOfSecondTempFile = indexOfSecondTempFile + 2;
      indexOfMergedFile = indexOfMergedFile + 1;
    }
  }

  private static int getNewFilenameFromLastSortedFile(StringBuilder firstTempFileName, StringBuilder secondTempFileName, StringBuilder mergedTempFileName, int indexOfFirstTempFile, int indexOfSecondTempFile, int indexOfMergedFile) {
    firstTempFileName.delete(1, firstTempFileName.length());
    firstTempFileName.append(indexOfFirstTempFile);
    secondTempFileName.delete(1, secondTempFileName.length());
    secondTempFileName.append(indexOfSecondTempFile);

    File fileMerged = new File(mergedTempFileName + ".txt");
    File file2 = new File(secondTempFileName + ".txt");
    fileMerged.renameTo(file2);

    mergedTempFileName.delete(1, mergedTempFileName.length());
    indexOfMergedFile = indexOfMergedFile - 1;
    mergedTempFileName.append(indexOfMergedFile);
    indexOfMergedFile = indexOfMergedFile + 1;
    return indexOfMergedFile;
  }

  private static void changeNameOfResultFile(StringBuilder mergedTempFileName) {
    mergedTempFileName.delete(0, mergedTempFileName.length());
    mergedTempFileName.append("SortedBigFile");
  }

  private static void changeNumberIndexes(StringBuilder firstTempFileName,
                                          StringBuilder secondTempFileName,
                                          StringBuilder mergedTempFileName,
                                          int indexOfFirstTempFile,
                                          int indexOfSecondTempFile,
                                          int indexOfMergedFile) {
    firstTempFileName.delete(1, firstTempFileName.length());
    firstTempFileName.append(indexOfFirstTempFile);
    secondTempFileName.delete(1, secondTempFileName.length());
    secondTempFileName.append(indexOfSecondTempFile);
    mergedTempFileName.delete(1, mergedTempFileName.length());
    mergedTempFileName.append(indexOfMergedFile);
  }

  private static void changeLetterIndexes(StringBuilder firstTempFileName,
                                          StringBuilder secondTempFileName,
                                          StringBuilder mergedTempFileName) {
    if (firstTempFileName.charAt(0) == 'A') {
      firstTempFileName.setCharAt(0, 'B');
      secondTempFileName.setCharAt(0, 'B');
      mergedTempFileName.setCharAt(0, 'A');
    } else if (firstTempFileName.charAt(0) == 'B') {
      firstTempFileName.setCharAt(0, 'A');
      secondTempFileName.setCharAt(0, 'A');
      mergedTempFileName.setCharAt(0, 'B');
    }
  }

  private static boolean checkIfNumberOfFilesIsEven() {
    boolean evenNumberOfFiles;
    if (filesCount % 2 == 0) {
      evenNumberOfFiles = true;
    } else {
      evenNumberOfFiles = false;
    }
    return evenNumberOfFiles;
  }

  // TODO make method smaller
  private static void mergeTwoTempFiles(File firstFile, File secondFile,
                                        File fileMerged) {
    int intFromFirstFile = 0, intFromSecondFile = 0;
    boolean readNextIntFromFirstFileIsAllowed = true;
    boolean readNextIntFromSecondFileIsAllowed = true;
    boolean endOfFile1 = false;
    boolean endOfFile2 = false;

    DataInputStream inputStreamOfFirstFile = null;
    try {
      inputStreamOfFirstFile = new DataInputStream(
              new FileInputStream(firstFile));
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }

    DataInputStream inputStreamOfSecondFile = null;
    try {
      inputStreamOfSecondFile = new DataInputStream(
              new FileInputStream(secondFile));
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }

    DataOutputStream outputStreamOfMergedFile = null;
    try {
      outputStreamOfMergedFile = new DataOutputStream(new
              FileOutputStream(fileMerged));
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }

    while (true) {

      if (!endOfFile1 || !endOfFile2) {

        if (endOfFile1) {
          writeNextIntToOutputStream(intFromSecondFile, outputStreamOfMergedFile);
          readNextIntFromSecondFileIsAllowed = true;
        }

        if (endOfFile2) {
          writeNextIntToOutputStream(intFromFirstFile, outputStreamOfMergedFile);
          readNextIntFromFirstFileIsAllowed = true;
        }

        if (readNextIntFromFirstFileIsAllowed && !endOfFile1) {
          try {
            intFromFirstFile = inputStreamOfFirstFile.readInt();
          } catch (EOFException e) {
            endOfFile1 = true;
            readNextIntFromFirstFileIsAllowed = false;
          } catch (IOException e) {
            e.printStackTrace();
          }
        }
        if (readNextIntFromSecondFileIsAllowed && !endOfFile2) {
          try {
            intFromSecondFile = inputStreamOfSecondFile.readInt();
          } catch (EOFException e) {
            endOfFile2 = true;
            readNextIntFromSecondFileIsAllowed = false;
          } catch (IOException e) {
            e.printStackTrace();
          }
        }

        if (intFromFirstFile == intFromSecondFile && !endOfFile1 && !endOfFile2) {
          try {
            outputStreamOfMergedFile.writeInt(intFromFirstFile);
          } catch (EOFException e) {
            endOfFile1 = true;
          } catch (IOException e) {
            e.printStackTrace();//todo
          }
          try {
            outputStreamOfMergedFile.writeInt(intFromSecondFile);
          } catch (EOFException e) {
            endOfFile2 = true;
          } catch (IOException e) {
            e.printStackTrace(); //todo
          }
          readNextIntFromFirstFileIsAllowed = true;
          readNextIntFromSecondFileIsAllowed = true;
        } else if (intFromFirstFile < intFromSecondFile && !endOfFile1 && !endOfFile2) {
          try {
            outputStreamOfMergedFile.writeInt(intFromFirstFile);
          } catch (EOFException e) {
            endOfFile1 = true;
          } catch (IOException e) {
            e.printStackTrace();
          }
          readNextIntFromFirstFileIsAllowed = true;
          readNextIntFromSecondFileIsAllowed = false;
        } else if (intFromSecondFile < intFromFirstFile && !endOfFile1 && !endOfFile2) {
          try {
            outputStreamOfMergedFile.writeInt(intFromSecondFile);
          } catch (EOFException e) {
            endOfFile2 = true;
          } catch (IOException e) {
            e.printStackTrace();
          }
          readNextIntFromFirstFileIsAllowed = false;
          readNextIntFromSecondFileIsAllowed = true;
        }
      } else if (endOfFile1 && !endOfFile2) {
        try {
          outputStreamOfMergedFile.writeInt(intFromSecondFile);
        } catch (EOFException e) {
          endOfFile2 = true;
        } catch (IOException e) {
          e.printStackTrace();
        }
        readNextIntFromFirstFileIsAllowed = false;
        readNextIntFromSecondFileIsAllowed = true;
      } else if (!endOfFile1 && endOfFile2) {
        try {
          outputStreamOfMergedFile.writeInt(intFromFirstFile);
        } catch (EOFException e) {
          endOfFile1 = true;
        } catch (IOException e) {
          e.printStackTrace();
        }
        readNextIntFromFirstFileIsAllowed = true;
        readNextIntFromSecondFileIsAllowed = false;
      } else if (endOfFile1 && endOfFile2) {
        break;
      }
    }
    closeStreams(inputStreamOfFirstFile, inputStreamOfSecondFile,
            outputStreamOfMergedFile);
    deleteTempFiles(firstFile, secondFile);
  }

  private static void writeNextIntToOutputStream(int intFromSecondFile, DataOutputStream outputStreamOfMergedFile) {
    try {
      outputStreamOfMergedFile.writeInt(intFromSecondFile);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private static void deleteTempFiles(File... file) {
    for (int i = 0; i < file.length; i++) {
      file[i].delete();
    }
  }

  private static void closeStreams(Closeable... closable) {
    for (int i = 0; i < closable.length; i++) {
      try {
        closable[i].close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
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

  public static void writeArrayToFile(int[] array, File file) {
    DataOutputStream outputStream = null;
    try {
      outputStream = new DataOutputStream(new FileOutputStream(file));
      for (int i = 0; i < array.length; i++) {
        outputStream.writeInt(array[i]);
      }
    } catch (FileNotFoundException e) {
      System.out.println("File " + file + " not found");
    } catch (IOException e) {
      System.out.println("\nCan't close the file " + file);
    } finally {
      try {
        if (outputStream != null) {
          outputStream.close();
        }
      } catch (IOException e) {
        System.out.println("\nCan't close the file " + file);
      }
    }
  }

  public static int[] readArrayFromFile(File file) {
    Vector<Integer> vector = new Vector<>();
    DataInputStream inputStream = null;
    try {
      inputStream = new DataInputStream(new FileInputStream(file));
      int i = 0;
      boolean inputStreamIsAvailable = inputStream.available() > 0;
      while (inputStreamIsAvailable) {
        vector.add(i, inputStream.readInt());
        i++;
      }
    } catch (FileNotFoundException e) {
      System.out.println("File " + file + " not found");
    } catch (EOFException e) {
      System.out.println("\nEnd of file " + file);
    } catch (IOException e) {
      System.out.println("\nCan't close the file " + file);
    } finally {
      try {
        if (inputStream != null) {
          inputStream.close();
        }
      } catch (IOException e) {
        System.out.println("\nCan't close the file " + file);
      }
    }
    int[] array = new int[vector.size()];

    for (int i = 0; i < array.length; i++) {
      array[i] = vector.get(i);
    }
    return array;
  }
}