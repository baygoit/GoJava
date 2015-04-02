package ua.goit.alg;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileProcessor {
  public static String TEMPORARY_DIRECTORY_PATH = "/goit_temp/";
  public static String TEMPORARY_FILE_PREFIX = "temp_";
  public static int temporaryFilesCounter;
  public static BufferedReader[] brArray;
  public static int[] currentIntegers;
  public static boolean[] isValues;
  public static boolean havingValues;

  static void createTemporaryDirectory() {
    File dir = new File(TEMPORARY_DIRECTORY_PATH);
    dir.mkdir();
  }

  static void writeTemporaryFile(String str) {
    String temporaryFilePath = TEMPORARY_DIRECTORY_PATH + TEMPORARY_FILE_PREFIX
        + temporaryFilesCounter++ + ".txt";
    File file = new File(temporaryFilePath);
    try {
      writeStringToFile(str, file);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void mergeFiles(File file) throws IOException {
    havingValues = true;
    brArray = initializeBrArrays();
    currentIntegers = new int[temporaryFilesCounter];
    isValues = new boolean[temporaryFilesCounter];
    initializeValues();
    BufferedWriter br = new BufferedWriter(new FileWriter(file));
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
      br.write(str);
      needSpaceSeparator = true;
    }
    br.close();
  }

  private static int getNextMinInteger() throws IOException {
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
      getNextValue(minIntegerPosition);
    }
    return minInteger;
  }

  private static void getNextValue(int i) throws IOException {
    BufferedReader br = brArray[i];
    StringBuilder currentString = new StringBuilder();
    int cursor = 0;
    while ((cursor = br.read()) != -1) {
      if (cursor != -1) {
        char currentChar = (char) cursor;
        if (Character.isDigit(currentChar)) {
          currentString.append(currentChar);
        } else if (currentString.length() != 0) {
          currentIntegers[i] = Integer.parseInt(currentString.toString());
          isValues[i] = true;
          return;
        }
      }
    }
    if (currentString.length() != 0) {
      currentIntegers[i] = Integer.parseInt(currentString.toString());
      isValues[i] = true;
    } else {
      isValues[i] = false;
    }
  }

  private static void initializeValues() {
    for (int i = 0; i < temporaryFilesCounter; i++) {
      try {
        getNextValue(i);
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }

  private static BufferedReader[] initializeBrArrays() throws IOException {
    BufferedReader[] brArray = new BufferedReader[temporaryFilesCounter];
    for (int i = 0; i < brArray.length; i++) {
      String temporaryFilePath = TEMPORARY_DIRECTORY_PATH
          + TEMPORARY_FILE_PREFIX + i + ".txt";
      brArray[i] = new BufferedReader(new FileReader(
          new File(temporaryFilePath)));
    }
    return brArray;
  }

  static void clearTemporaryDirectory() throws IOException {
    closeBrs();
    File directory = new File(TEMPORARY_DIRECTORY_PATH);
    if (!directory.exists()) {
      return;
    } else {
      delete(directory);
    }
  }

  private static void closeBrs() throws IOException {
    for (int i = 0; i < temporaryFilesCounter; i++) {
      brArray[i].close();
      brArray[i] = null;
    }
  }

  private static void delete(File file) throws IOException {
    if (file.isDirectory()) {
      if (file.list().length == 0) {
        file.delete();
      } else {
        String files[] = file.list();
        for (String temp : files) {
          File fileDelete = new File(file, temp);
          delete(fileDelete);
        }
        if (file.list().length == 0) {
          file.delete();
        }
      }
    } else {
      file.delete();
    }
  }

  static void resetTemporaryFileIndex() {
    FileProcessor.temporaryFilesCounter = 0;
  }

  public static void writeStringToFile(String content, File file)
      throws IOException {

    if (!file.exists()) {
      file.createNewFile();
    }
    BufferedWriter bw = new BufferedWriter(new FileWriter(file));
    bw.write(content);
    bw.close();

  }

  public static String readStringFromFile(File file) throws IOException {
    String str = "";
    BufferedReader br = new BufferedReader(new FileReader(file));
    str = br.readLine();
    br.close();
    return str;
  }
}
