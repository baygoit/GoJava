package ua.goit.alg;

import java.io.*;
import java.util.Vector;

class Arrays {
  private static final int BUFFER_SIZE = 5;
  private static int filesCount;
  private static final StringBuilder firstTempFileName = new StringBuilder();
  private static final StringBuilder secondTempFileName = new StringBuilder();
  private static final StringBuilder mergedTempFileName = new StringBuilder();
  private static int indexOfFirstTempFile, indexOfSecondTempFile,
          indexOfMergedFile;

  public static void mergeSort(File file) throws IOException {
    filesCount = 0;
    getSortedFiles(file, BUFFER_SIZE);
    boolean isEvenNumberOfFiles;
    isEvenNumberOfFiles = checkIfNumberOfFilesIsEven();
    setTempFileNames();
    int filesCountForChangingIndexes = filesCount / 2;

    while (filesCount > 1) {

      if (filesCount == filesCountForChangingIndexes) {
        changeLetterIndexes();
        filesCountForChangingIndexes = filesCount / 2;
        indexOfFirstTempFile = 0;
        indexOfSecondTempFile = 1;
        indexOfMergedFile = 0;
        changeNumberIndexes();
      }

      if (filesCount == 2) {
        changeNameOfResultFile();
      } else if (filesCount == 3 && !isEvenNumberOfFiles) {
        indexOfMergedFile = getNewFilenameFromLastSortedFile();
        isEvenNumberOfFiles = true;
      } else {
        changeNumberIndexes();
      }

      File firstFile = new File(firstTempFileName + ".txt");
      File secondFile = new File(secondTempFileName + ".txt");
      File mergedFile = new File(mergedTempFileName + ".txt");

      mergeTwoTempFiles(firstFile, secondFile, mergedFile);
      filesCount = filesCount - 1;
      if (filesCount > 2) {
        getNextFileIndexes();
      }
    }
  }

  private static void getNextFileIndexes() {
    indexOfFirstTempFile = indexOfFirstTempFile + 2;
    indexOfSecondTempFile = indexOfSecondTempFile + 2;
    indexOfMergedFile = indexOfMergedFile + 1;
  }

  private static void setTempFileNames() {
    indexOfFirstTempFile = 0;
    indexOfSecondTempFile = 1;
    indexOfMergedFile = 0;

    if (firstTempFileName.length() != 0) {
      firstTempFileName.delete(0, firstTempFileName.length());
    }
    firstTempFileName.append('A');
    firstTempFileName.append(indexOfFirstTempFile);

    if (secondTempFileName.length() != 0) {
      secondTempFileName.delete(0, secondTempFileName.length());
    }
    secondTempFileName.append('A');
    secondTempFileName.append(indexOfSecondTempFile);

    if (mergedTempFileName.length() != 0) {
      mergedTempFileName.delete(0, mergedTempFileName.length());
    }
    mergedTempFileName.append('B');
    mergedTempFileName.append(indexOfMergedFile);
  }

  private static int getNewFilenameFromLastSortedFile() {

    firstTempFileName.delete(1, firstTempFileName.length());
    firstTempFileName.append(indexOfFirstTempFile);
    secondTempFileName.delete(1, secondTempFileName.length());
    secondTempFileName.append(indexOfSecondTempFile);

    File fileMerged = new File(mergedTempFileName + ".txt");
    File secondTempFile = new File(secondTempFileName + ".txt");
    //noinspection ResultOfMethodCallIgnored
    fileMerged.renameTo(secondTempFile);

    mergedTempFileName.delete(1, mergedTempFileName.length());
    indexOfMergedFile = indexOfMergedFile - 1;
    mergedTempFileName.append(indexOfMergedFile);
    indexOfMergedFile = indexOfMergedFile + 1;
    return indexOfMergedFile;
  }

  private static void changeNameOfResultFile() {
    mergedTempFileName.delete(0, mergedTempFileName.length());
    mergedTempFileName.append("SortedBigFile");
  }

  private static void changeNumberIndexes() {
    firstTempFileName.delete(1, firstTempFileName.length());
    firstTempFileName.append(indexOfFirstTempFile);
    secondTempFileName.delete(1, secondTempFileName.length());
    secondTempFileName.append(indexOfSecondTempFile);
    mergedTempFileName.delete(1, mergedTempFileName.length());
    mergedTempFileName.append(indexOfMergedFile);
  }

  private static void changeLetterIndexes() {
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
    evenNumberOfFiles = filesCount % 2 == 0;
    return evenNumberOfFiles;
  }

  private static void mergeTwoTempFiles(File firstFile, File secondFile,
                                        File fileMerged) throws IOException {
    int nextValueFromFirstFile = 0, nextValueFromSecondFile = 0;
    // flags
    boolean readFromFirstFileIsAllowed = true;
    boolean readFromSecondFileIsAllowed = true;
    boolean endOfFirstFile = false;
    boolean endOfSecondFile = false;

    DataInputStream firstInputStream;
    DataInputStream secondInputStream;
    DataOutputStream outputStream;

    firstInputStream = getInputStream(firstFile, null);
    secondInputStream = getInputStream(secondFile, null);
    outputStream = getOutputStream(fileMerged, null);

    while (!endOfFirstFile || !endOfSecondFile) {

      if (endOfFirstFile) {
        writeNextIntToOutputStream(nextValueFromSecondFile, outputStream);
        readFromSecondFileIsAllowed = true;
      }

      if (endOfSecondFile) {
        writeNextIntToOutputStream(nextValueFromFirstFile, outputStream);
        readFromFirstFileIsAllowed = true;
      }

      if (readFromFirstFileIsAllowed && !endOfFirstFile) {
        try {
          nextValueFromFirstFile = firstInputStream.readInt();
        } catch (EOFException e) {
          endOfFirstFile = true;
          readFromFirstFileIsAllowed = false;
        }
      }

      if (readFromSecondFileIsAllowed && !endOfSecondFile) {
        try {
          nextValueFromSecondFile = secondInputStream.readInt();
        } catch (EOFException e) {
          endOfSecondFile = true;
          readFromSecondFileIsAllowed = false;
        }
      }

      if (!endOfFirstFile && !endOfSecondFile) {

        if (nextValueFromFirstFile == nextValueFromSecondFile) {
          endOfFirstFile = writeToOutputStream(nextValueFromFirstFile,
                  outputStream);
          endOfSecondFile = writeToOutputStream(nextValueFromSecondFile,
                  outputStream);
          readFromFirstFileIsAllowed = true;
          readFromSecondFileIsAllowed = true;
        } else if (nextValueFromFirstFile < nextValueFromSecondFile) {
          endOfFirstFile = writeToOutputStream(nextValueFromFirstFile,
                  outputStream);
          readFromFirstFileIsAllowed = true;
          readFromSecondFileIsAllowed = false;
        } else if (nextValueFromFirstFile > nextValueFromSecondFile) {
          endOfSecondFile = writeToOutputStream(nextValueFromSecondFile,
                  outputStream);
          readFromFirstFileIsAllowed = false;
          readFromSecondFileIsAllowed = true;
        }
      }
    }
    closeStreams(firstInputStream, secondInputStream,
            outputStream);
    deleteTempFiles(firstFile, secondFile);
  }

  private static boolean writeToOutputStream(
          int intFromFile, DataOutputStream outputStream) throws IOException {
    boolean endOfFile = false;
    try {
      outputStream.writeInt(intFromFile);
    } catch (EOFException e) {
      endOfFile = true;
    }
    return endOfFile;
  }

  private static DataOutputStream getOutputStream(File file, DataOutputStream
          outputStream) {
    try {
      outputStream = new DataOutputStream(new FileOutputStream(file));
    } catch (FileNotFoundException e) {
      System.out.println("File " + file + " not found");
    }
    return outputStream;
  }

  private static DataInputStream getInputStream(File file, DataInputStream
          inputStream) {
    try {
      inputStream = new DataInputStream(new FileInputStream(file));
    } catch (FileNotFoundException e) {
      System.out.println("File " + file + " not found");
    }
    return inputStream;
  }

  private static void writeNextIntToOutputStream(
          int intFromSecondFile, DataOutputStream outputStreamOfMergedFile) {
    try {
      outputStreamOfMergedFile.writeInt(intFromSecondFile);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private static void deleteTempFiles(File... file) {
    for (File aFile : file) {
      //noinspection ResultOfMethodCallIgnored
      aFile.delete();
    }
  }

  private static void closeStreams(Closeable... closable) {
    for (Closeable aClosable : closable) {
      try {
        aClosable.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }

  public static void getSortedFiles(File file, int buffer) throws IOException {
    int[] array;
    Vector<Integer> vector = new Vector<>();
    int tmpFileIndex = 0;
    String tmpFileName;

    try (DataInputStream inputStream = new DataInputStream(
            new FileInputStream(file))) {

      while (inputStream.available() > 0) {

        for (int i = 0; i < buffer && inputStream.available() > 0; i++) {
          vector.add(i, inputStream.readInt());
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
    }
  }

  public static void writeArrayToFile(int[] array, File file) throws
          IOException {
    try (DataOutputStream outputStream =
                 new DataOutputStream(new FileOutputStream(file))) {
      for (int anArray : array) {
        outputStream.writeInt(anArray);
      }
    }
  }

  public static int[] readArrayFromFile(File file) {
    Vector<Integer> vector = new Vector<>();
    try (DataInputStream inputStream = new DataInputStream(new FileInputStream
            (file))) {
      int i = 0;
      boolean inputStreamIsAvailable = inputStream.available() > 0;
      while (inputStreamIsAvailable) {
        vector.add(i, inputStream.readInt());
        i++;
      }
    } catch (FileNotFoundException e) {
      System.out.println("File " + file + " not found");
    } catch (IOException e) {
      //System.out.println("\nCan't close the file " + file);
    }
    int[] array = new int[vector.size()];

    for (int i = 0; i < array.length; i++) {
      array[i] = vector.get(i);
    }
    return array;
  }
}