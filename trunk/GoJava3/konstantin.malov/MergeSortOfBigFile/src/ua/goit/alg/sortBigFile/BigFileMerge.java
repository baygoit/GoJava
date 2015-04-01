package ua.goit.alg.sortBigFile;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static ua.goit.alg.sortBigFile.Constants.*;

public class BigFileMerge {
  private byte[] firstFileBuffer = new byte[BYTE_BUFFER_SIZE];
  private byte[] secondFileBuffer = new byte[BYTE_BUFFER_SIZE];
  private int[] resultFileBuffer = new int[(BYTE_BUFFER_SIZE) / 4];
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
    String fileNameForReturn = PATH_TO_TEMP_DIR_UNIX + TEMP_FILE_NAME +
            firstCountNumber + "_" + secondCountNumber + FILE_TYPE;
    DataInputStream dataFromFirstFile = new DataInputStream(new FileInputStream(firstFile));
    DataInputStream dataFromSecondFile = new DataInputStream(new FileInputStream(secondFile));
    DataOutputStream dataToResultFile = new DataOutputStream(new FileOutputStream(
            new File(fileNameForReturn)));
    int firstFileBufferLength = 0;
    int secondFileBufferLength = 0;
    int count = 0;
    while ((firstFileBufferLength = dataFromFirstFile.read(firstFileBuffer)) > 0
            || (secondFileBufferLength = dataFromSecondFile.read(secondFileBuffer)) > 0) {
      firstFileBufferLength /= 4;
      secondFileBufferLength /= 4;
      int firstBufferCount;
      int secondBufferCount;
      int[] firstFileBufferInt = Parser.parseByteArrayToIntArray(
              firstFileBuffer);
      int[] secondFileBufferInt = Parser.parseByteArrayToIntArray(
              secondFileBuffer);
      for (firstBufferCount = 0, secondBufferCount = 0;
           firstBufferCount < firstFileBufferLength &&
                   secondBufferCount < secondFileBufferLength; count++) {
        if (firstFileBufferInt[firstBufferCount] <
                secondFileBufferInt[secondBufferCount]) {
          resultFileBuffer[count] = firstFileBufferInt[firstBufferCount];
          firstBufferCount++;
        } else {
          resultFileBuffer[count] = secondFileBufferInt[secondBufferCount];
          secondBufferCount++;
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

      if (firstBufferCount < firstFileBufferLength) {
        int tempArrLength = firstFileBufferLength - firstBufferCount;
        int[] tempArray = new int[tempArrLength];
        System.arraycopy(firstFileBufferInt, 0, tempArray, 0, tempArrLength);
        writeBufferToFile(tempArray, tempArrLength, dataToResultFile);
      }

      if (secondBufferCount < secondFileBufferLength) {
        int tempArrLength = secondFileBufferLength - secondBufferCount;
        int[] tempArray = new int[tempArrLength];
        System.arraycopy(secondFileBufferInt, 0, tempArray, 0, tempArrLength);
        writeBufferToFile(tempArray, tempArrLength, dataToResultFile);
      }
    }

    return fileNameForReturn;
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

