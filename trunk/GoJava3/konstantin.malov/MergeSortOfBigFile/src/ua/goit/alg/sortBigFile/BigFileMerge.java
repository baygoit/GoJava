package ua.goit.alg.sortBigFile;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static ua.goit.alg.sortBigFile.Constants.*;

public class BigFileMerge {
  private int firstCountNumber = 1;
  private int secondCountNumber = 0;

  public String mergeSortFile(String bigfile, String fileAfterSort) throws IOException {
    CutBigFile cutBigFile = new CutBigFile();
    FileOperations.fileCopy(merge(cutBigFile.cutBigFile(
            new File(bigfile))), fileAfterSort);
    FileOperations.dirClear(PATH_TO_TEMP_DIR_UNIX);
    return fileAfterSort;
  }

  /**
   * this function recursion merge all temp files
   */
  public String merge(List<String> filesList) throws IOException {
    int filesCount = filesList.size();
    List<String> newFilesList = new ArrayList<String>();
    if (filesCount == 1) {
      return filesList.get(0);
    }

    for (int i = 0; i < filesCount; i += 2) {
      if (i == filesCount - 1) {
        newFilesList.add(filesList.get(i));
        resetCondition();
        return merge(newFilesList);
      }

      newFilesList.add(mergeFiles(new File(filesList.get(i)),
              new File(filesList.get(i + 1))));
      secondCountNumber++;
    }

    resetCondition();
    return merge(newFilesList);
  }

  /**
   * this function merge to file, save result to new temp file and return his path
   */
  public String mergeFiles(File firstFile, File secondFile) throws IOException {
    byte[] firstFileBuffer = new byte[BYTE_BUFFER_SIZE];
    byte[] secondFileBuffer = new byte[BYTE_BUFFER_SIZE];
    int[] resultFileBuffer = new int[(BYTE_BUFFER_SIZE) / 4];
    String fileNameForReturn = PATH_TO_TEMP_DIR_UNIX + TEMP_FILE_NAME +
            firstCountNumber + "_" + secondCountNumber + FILE_TYPE;
    DataInputStream dataFromFirstFile = new DataInputStream(
            new FileInputStream(firstFile));
    DataInputStream dataFromSecondFile = new DataInputStream(
            new FileInputStream(secondFile));
    DataOutputStream dataToResultFile = new DataOutputStream(
            new FileOutputStream(new File(fileNameForReturn)));
    int firstFileBufferIntLength = 0;
    int secondFileBufferIntLength = 0;
    int count = 0;
    while ((firstFileBufferIntLength =
            readDataFromFile(dataFromFirstFile, firstFileBuffer)) > 0 ||
            (secondFileBufferIntLength =
                    readDataFromFile(dataFromSecondFile, secondFileBuffer)) > 0) {
      int firstBufferCount = 0;
      int secondBufferCount = 0;
      int[] firstFileBufferInt = Parser.parseByteArrayToIntArray(
              firstFileBuffer);
      int[] secondFileBufferInt = Parser.parseByteArrayToIntArray(
              secondFileBuffer);
      while (firstBufferCount < firstFileBufferIntLength &&
              secondBufferCount < secondFileBufferIntLength) {
        if (firstFileBufferInt[firstBufferCount] <
                secondFileBufferInt[secondBufferCount]) {
          resultFileBuffer[count++] = firstFileBufferInt[firstBufferCount++];
        } else {
          resultFileBuffer[count++] = secondFileBufferInt[secondBufferCount++];
        }

        if (count == resultFileBuffer.length - 1) {
          writeBufferToFile(resultFileBuffer, count, dataToResultFile);
          count = 0;
        }
      }

      if (count > 0) {
        writeBufferToFile(resultFileBuffer, count, dataToResultFile);
        count = 0;
      }

      if (firstBufferCount < firstFileBufferIntLength) {
        int tempArrLength = firstFileBufferIntLength - firstBufferCount;
        int[] tempArray = Arrays.copyOf(firstFileBufferInt, tempArrLength);
        writeBufferToFile(tempArray, tempArrLength, dataToResultFile);
      }

      if (secondBufferCount < secondFileBufferIntLength) {
        int tempArrLength = secondFileBufferIntLength - secondBufferCount;
        int[] tempArray = Arrays.copyOf(secondFileBufferInt, tempArrLength);
        writeBufferToFile(tempArray, tempArrLength, dataToResultFile);
      }
    }

    return fileNameForReturn;
  }

  private int readDataFromFile(DataInputStream file, byte[] buffer) throws IOException {
    return file.read(buffer) / 4;
  }

  private void resetCondition() {
    secondCountNumber = 0;
    firstCountNumber++;
  }

  private void writeBufferToFile(int[] buffer, int theLastElementWithData, DataOutputStream dataToResultFile) throws IOException {
    if (buffer.length != theLastElementWithData) {
      int[] tempArray = new int[theLastElementWithData];
      System.arraycopy(buffer, 0, tempArray, 0, theLastElementWithData);
      dataToResultFile.write(Parser.parseIntArrayToByteArray(tempArray));
    } else {
      dataToResultFile.write(Parser.parseIntArrayToByteArray(buffer));
    }
  }
}