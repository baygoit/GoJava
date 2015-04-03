package ua.goit.sort;

import ua.goit.alg.MergeSort;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Program works with a file that contains Integers - every integer on a new line
 */

public class BigFileSort {
  private int tempFileCounter = 0;
  private ArrayList<BufferedReader> readerList = new ArrayList<BufferedReader>();
  private ArrayList<File> tempFiles = new ArrayList<File>();

  public static void main(String[] args) {
    new BigFileSort().sortBigFile("D:\\JavaProjects\\GoIT\\Other Projects\\test.txt");
    //test file: http://edx.prometheus.org.ua/c4x/KPI/Algorithms101/asset/input__10000.txt
  }

  public void sortBigFile(String filename) {
    try {
      readFromFile(filename);
    } catch (FileNotFoundException e) {
      System.out.println("File does not exist");
      e.printStackTrace();
      System.exit(1);
    } catch (IOException e) {
      System.out.println("IO Exception");
      e.printStackTrace();
      System.exit(1);
    }
  }

    private void readFromFile(String filename) throws IOException {
      File file = new File(filename);
      File directory = file.getParentFile();
      BufferedReader reader = null;
      try {
        reader = new BufferedReader(new FileReader(file));
        int[] buffer = new int[1024];
        int countValuesInBuffer;
        while (reader.ready()) {
          countValuesInBuffer = 0;
          for (int i = 0; i < buffer.length; i++) {
            if (reader.ready()) {
              buffer[i] = Integer.parseInt(reader.readLine());
              countValuesInBuffer++;
            } else {
              break;
            }
          }
          MergeSort.mergeSort(buffer, 0, countValuesInBuffer - 1);
          tempFileCounter += 1;
          File newTempFile = new File(directory, "tempFile_" + (tempFileCounter) + ".txt");
          newTempFile.createNewFile();
          tempFiles.add(newTempFile);
          writeToFile(newTempFile, buffer, countValuesInBuffer);
        }
        File resultFile = new File(directory, "Sorted_" + file.getName());
        resultFile.createNewFile();
        mergeToResultFile(resultFile);
      } finally {
        reader.close();
        for (BufferedReader br : readerList) {
          br.close();
        }
        for (File f : tempFiles) {
          f.delete();
        }
      }
  }

  private void writeToFile(File file, int[] intArray, int numberToWrite) throws IOException {
    BufferedWriter fileWriter = null;
    try {
      fileWriter = new BufferedWriter(new FileWriter(file));
      for (int i = 0; i < numberToWrite; i++) {
        fileWriter.write(String.valueOf(intArray[i]));
        fileWriter.newLine();
      }
    } finally {
      fileWriter.close();
    }
  }

  private void mergeToResultFile(File resultFile) throws IOException {
    BufferedWriter writer = null;
    try {
      writer = new BufferedWriter(new FileWriter(resultFile));
      ArrayList<Integer> valuesList = new ArrayList<Integer>();
      for (File f : tempFiles) {
        BufferedReader reader = new BufferedReader(new FileReader(f));
        readerList.add(reader);
        valuesList.add(Integer.parseInt(reader.readLine()));
      }
      while (!readerList.isEmpty()) {
        int minIndex = getIndexOfMinimumValue(valuesList);
        writer.write(String.valueOf(valuesList.get(minIndex)));
        writer.newLine();
        valuesList.remove(minIndex);
        if (readerList.get(minIndex).ready()) {
          int nextValue = Integer.parseInt(readerList.get(minIndex).readLine());
          valuesList.add(minIndex, nextValue);
        } else {
          readerList.get(minIndex).close();
          readerList.remove(minIndex);
        }
      }
    } finally {
      writer.close();
    }
  }

  private int getIndexOfMinimumValue(List<Integer> list) {
    int minIndex = 0;
    int minValue = list.get(0);
    for (int i=0;i<list.size();i++) {
      if (list.get(i)<minValue) {
        minValue = list.get(i);
        minIndex = i;
      }
    }
    return minIndex;
  }
}
