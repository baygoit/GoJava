package ua.goit.alg;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class FileMergeSort {
  public static File file = new File("D:\\bigdata.txt");
  public static int mergeCounter = 1;
  public static List<String> fileNames = new LinkedList<String>();
  public static DataOutputStream writer;
  public static File firstTemporaryFile;
  public static File secondTemporaryFile;

	public static void main(String[] args) throws Exception {
	  split(fileNames, file);
	  mergeSort(fileNames);
	}

  public static void split (List<String> fileNames, File file) throws Exception {
    int indexOfParts = 0;
    int[] buffer = new int[0];
    String smallSortedFilesFileName = "D:\\\\newDataPart" + indexOfParts + ".txt";

    try(DataInputStream firstReader = new DataInputStream(new FileInputStream(file))) {

      while (firstReader.available() > 0) {

        try (DataOutputStream writer = WriterForSplit(indexOfParts)) {

          if ((firstReader.available() / 4) > 3) {
            buffer = new int[3];
          } else {
            buffer = new int[firstReader.available() / 4];
          }
          int i = 0;
          while (firstReader.available() > 0 && i < buffer.length) {
            int singleInt = firstReader.readInt();
            buffer[i] = singleInt;
            i++;
          }

          int[] sorted = MergeSort.sort(buffer, 0, buffer.length);

          for (int j = 0; j < sorted.length; j++) {
  	      writer.writeInt(sorted[j]);
          }
        }
        fileNames.add(generatingFileName(indexOfParts));

        indexOfParts++;
      }
    }
    if ((fileNames.size() % 2) != 0) {
	  File extraFile = temporaryFiles(fileNames, indexOfParts - 1, smallSortedFilesFileName);
	  fileNames.add(generatingFileName(indexOfParts));
    }
  }

  public static List mergeSort(List<String> fileNames) throws Exception {
    List <String> newFileNames = new LinkedList<String>();

    do {
	  int indexOfBigParts = 0;
      int firstIndexForList = 0;
      int secondIndexForList = 1;

      while (firstIndexForList < fileNames.size()) {

        mergeParts(fileNames, firstIndexForList, secondIndexForList, indexOfBigParts);

        firstTemporaryFile = temporaryFiles(fileNames, firstIndexForList);
        secondTemporaryFile = temporaryFiles(fileNames, secondIndexForList);

        newFileNames.add(generatingFileName(indexOfBigParts, mergeCounter));

        firstIndexForList += 2;
        secondIndexForList += 2;

        indexOfBigParts++;
      }

      mergeCounter++;

      fileNames = new LinkedList<String>();
      fileNames.addAll(newFileNames);
      newFileNames.clear();

    } while (fileNames.size() > 1);
		return fileNames;
  }

  private static void mergeParts(List<String> fileNames, int firstIndex, int secondIndex, int indexOfBigParts) throws Exception {
    int firstSingleInt = 0;
    int secondSingleInt = 0;

    String firstFileNameSet = fileNames.get(firstIndex);
    String secondFileNameSet = fileNames.get(secondIndex);

    try (DataInputStream firstReader = new DataInputStream(new FileInputStream(firstFileNameSet));
         DataInputStream secondReader = new DataInputStream(new FileInputStream(secondFileNameSet));
         DataOutputStream writer = WriterForMergeSort(indexOfBigParts, mergeCounter)) {

      firstSingleInt = firstReader.readInt();

      if (secondReader.available() > 0) {
        secondSingleInt = secondReader.readInt();
      }

      while (firstReader.available() > 0 || secondReader.available() > 0) {

        if (firstReader.available() > 0 && secondReader.available() > 0) {
          if (firstSingleInt < secondSingleInt) {
            writer.writeInt(firstSingleInt);
            firstSingleInt = firstReader.readInt();
          } else {
            writer.writeInt(secondSingleInt);
            secondSingleInt = secondReader.readInt();
          }
        } else {
          if (firstReader.available() > 0 && secondReader.available() == 0) {
            writer.writeInt(firstSingleInt);
            firstSingleInt = firstReader.readInt();
          } else {
            writer.writeInt(secondSingleInt);
            secondSingleInt = secondReader.readInt();
          }
        }
      }
    }
  }

  private static DataOutputStream WriterForSplit(int indexOfParts) throws Exception {
    return writer = new DataOutputStream(new FileOutputStream("D:\\newDataPart" + indexOfParts + ".txt"));
  }

  private static DataOutputStream WriterForMergeSort(int indexOfParts, int mergeCounter) throws Exception {
    return writer = new DataOutputStream(new FileOutputStream("D:\\" + mergeCounter + "thNewDataPart" + indexOfParts + ".txt"));
  }

  private static String generatingFileName(int indexOfParts, int ... mergeCounter) {
    String fileName;
    if (mergeCounter.length == 0) {
      fileName = "D:\\\\newDataPart" + indexOfParts + ".txt";
    } else {
  	  fileName = "D:\\\\" + mergeCounter[0] + "thNewDataPart" + indexOfParts + ".txt";
    }
  	return fileName;
  }

  private static File temporaryFiles(List<String> fileNames, int index, String ... extraFileFileNames) throws Exception {
    File temporaryFile;
    if (extraFileFileNames.length == 0) {
      temporaryFile = new File(fileNames.get(index));
      temporaryFile.deleteOnExit();
    } else {
      temporaryFile = new File(fileNames.get(index));
      temporaryFile.createNewFile();
      temporaryFile.deleteOnExit();
    }
    return temporaryFile;
  }
}
