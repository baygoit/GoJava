package ua.goit.alg;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileProcessor {
  public static String TEMPORARY_DIRECTORY_PATH = "/goit_temp/";
  public static String TEMPORARY_FILE_PREFIX = "temp_";
  public static int temporaryFilesCounter;
  public static FileInputStream[] fisArray;
  public static int[] currentIntegers;
  public static boolean[] isValues;
  public static boolean havingValues;

  public static void createTemporaryDirectory() {
    File dir = new File(TEMPORARY_DIRECTORY_PATH);
    dir.mkdir();
    dir = null;
  }

  public static void writeTemporaryFile(String str) {

    String temporaryFilePath = TEMPORARY_DIRECTORY_PATH + TEMPORARY_FILE_PREFIX
        + temporaryFilesCounter++ + ".txt";
    File file = new File(temporaryFilePath);
    try {
      FileOutputStream fop = new FileOutputStream(file);
      if (!file.exists()) {
        file.createNewFile();
      }
      byte[] contentInBytes = str.getBytes();
      fop.write(contentInBytes);
      fop.flush();
      fop.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
    file = null;
  }

  public static void writeArrayIntoTemporaryFile(int[] array) {
    String str = ArrayHandler.arrayToString(array);
    writeTemporaryFile(str);
  }

  public static void mergeFiles(File file) {
    havingValues = true;
    fisArray = initializeFisArrays();
    currentIntegers = new int[temporaryFilesCounter];
    isValues = new boolean[temporaryFilesCounter];
    for (int i = 0; i < temporaryFilesCounter; i++) {
      getNextInteger(i);
    }

    try {
      FileOutputStream fop = new FileOutputStream(file);
      if (!file.exists()) {
        file.createNewFile();
      }
      boolean needSpaceSeparator = false;
      while (true) {
        int nextMinInteger = getNextMinInteger();
        if (!havingValues) {
          break;
        }
        String str = "";
        if (needSpaceSeparator) {
          str += " ";
        }
        str += String.valueOf(nextMinInteger);
        fop.write(str.getBytes());
        fop.flush();
        needSpaceSeparator = true;
      }
      fop.close();
    } catch (IOException e) {
      e.printStackTrace();
    }

  }

  public static int getNextMinInteger() {
    int minInteger = Integer.MAX_VALUE;
    int minIntegerPosition = -1;
    for (int i = 0; i < temporaryFilesCounter; i++) {
      if (currentIntegers[i] <= minInteger && isValues[i] == true) {
        minInteger = currentIntegers[i];
        minIntegerPosition = i;
      }
    }
    if (minIntegerPosition == -1) {
      havingValues = false;
    } else {
      getNextInteger(minIntegerPosition);
    }
    return minInteger;
  }

  public static void getNextInteger(int i) {
    try {
      FileInputStream fis = fisArray[i];
      StringBuilder currentString = new StringBuilder();
      while (true) {
        int c = fis.read();
        if (c != -1) {
          char currentChar = (char) c;
          if (Character.isDigit(currentChar)) {
            currentString.append(currentChar);
          } else {
            if (currentString.length() != 0) {
              currentIntegers[i] = Integer.parseInt(currentString.toString());
              isValues[i] = true;
              break;
            }
          }
        } else {
          if (currentString.length() != 0) {
            currentIntegers[i] = Integer.parseInt(currentString.toString());
            isValues[i] = true;
          } else {
            isValues[i] = false;
          }
          break;
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }

  }

  public static FileInputStream[] initializeFisArrays() {
    FileInputStream[] fisArray = new FileInputStream[temporaryFilesCounter];
    for (int i = 0; i < fisArray.length; i++) {
      String temporaryFilePath = TEMPORARY_DIRECTORY_PATH
          + TEMPORARY_FILE_PREFIX + i + ".txt";
      try {
        fisArray[i] = new FileInputStream(new File(temporaryFilePath));
      } catch (FileNotFoundException e) {
        e.printStackTrace();
      }
    }
    return fisArray;
  }

  public static void clearTemporaryDirectory() {
    closeFisArray();

    File directory = new File(TEMPORARY_DIRECTORY_PATH);
    if (!directory.exists()) {
      return;
    } else {
      try {
        delete(directory);
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }

  private static void closeFisArray() {
    for (int i = 0; i < currentIntegers.length; i++) {
      try {
        fisArray[i].close();
      } catch (IOException e) {
        e.printStackTrace();
      }
      fisArray[i] = null;
    }
  }

  public static void delete(File file) throws IOException {
    if (file.isDirectory()) {
      if (file.list().length == 0) {
        if (!file.delete()) {
          System.out.println(file.getAbsolutePath());
        }
      } else {
        String files[] = file.list();
        for (String temp : files) {
          File fileDelete = new File(file, temp);
          delete(fileDelete);
        }
        if (file.list().length == 0) {
          if (!file.delete()) {
            System.out.println(file.getAbsolutePath());
          }

        }
      }
    } else {
      if (!file.delete()) {
        System.out.println(file.getAbsolutePath());
      }
    }
  }

  public static void resetTemporaryFileIndex() {
    FileProcessor.temporaryFilesCounter = 0;
  }
}
