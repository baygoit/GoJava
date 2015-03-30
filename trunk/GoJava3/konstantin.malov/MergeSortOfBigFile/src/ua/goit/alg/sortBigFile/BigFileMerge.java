package ua.goit.alg.sortBigFile;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BigFileMerge {
  private byte[] firstFileBuffer = new byte[Property.BYTE_BUFFER_SIZE];
  private byte[] secondFileBuffer = new byte[Property.BYTE_BUFFER_SIZE];
  private int[] resultFileBuffer = new int[(Property.BYTE_BUFFER_SIZE) / 4];
  private DataInputStream dataFromFirstFile;
  private DataInputStream dataFromSecondFile;
  private DataOutputStream dataToResultFile;
  private int firstCountNumber = 1;
  private int secondCountNumber = 0;

  public String mergeSortFile(String bigfile, String fileAfterSort) throws IOException {
    CutBigFile cutBigFile = new CutBigFile();
    OperationWithFiles.fileCopy(merge(cutBigFile.cutBigFile(
            new File(bigfile))), fileAfterSort);
    OperationWithFiles.dirClear(Property.PATH_TO_TEMP_DIR_UNIX);
    return fileAfterSort;
  }
 //this function recursion merge all temp files
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
  // this function merge to file, save result to new temp file and return his path.
  public String mergeFiles(File firstFile, File secondFile) throws IOException {

    String fileNameForReturn = Property.PATH_TO_TEMP_DIR_UNIX + Property.TEMP_FILE_NAME +
            firstCountNumber + "_" + secondCountNumber + Property.FILE_TYPE;
    dataFromFirstFile = new DataInputStream(new FileInputStream(firstFile));
    dataFromSecondFile = new DataInputStream(new FileInputStream(secondFile));
    dataToResultFile = new DataOutputStream(new FileOutputStream(
            new File(fileNameForReturn)));
    int firstFileBufferLength = 0;
    int secondFileBufferLength = 0;
    int count = 0;

    while ((firstFileBufferLength = readFromFirstFileToBuffer()) > 0 ||
            (secondFileBufferLength = readFromFirstSecondFileToBuffer()) > 0) {
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

        if (count == (Property.BYTE_BUFFER_SIZE) / 4 - 1) {
          writeBufferToFile(resultFileBuffer, count);
          count = 0;
        }

      }
      if (count > 0) {
        writeBufferToFile(resultFileBuffer, count);
        count = 0;
      }

      if (firstBufferCount < firstFileBufferLength) {
        int tempArrLength = firstFileBufferLength - firstBufferCount;
        int[] tempArray = new int[tempArrLength];
        System.arraycopy(firstFileBufferInt, 0, tempArray, 0, tempArrLength);
        writeBufferToFile(tempArray, tempArrLength);
      }

      if (secondBufferCount < secondFileBufferLength) {
        int tempArrLength = secondFileBufferLength - secondBufferCount;
        int[] tempArray = new int[tempArrLength];
        System.arraycopy(secondFileBufferInt, 0, tempArray, 0, tempArrLength);
        writeBufferToFile(tempArray, tempArrLength);
      }

    }

    return fileNameForReturn;
  }

  private void resetCondition() {
    secondCountNumber = 0;
    firstCountNumber++;
  }

  private int readFromFirstSecondFileToBuffer() throws IOException {
    return dataFromSecondFile.read(secondFileBuffer);
  }

  private int readFromFirstFileToBuffer() throws IOException {
    return dataFromFirstFile.read(firstFileBuffer);
  }

  private void writeBufferToFile(int[] buffer, int theLastElementWithData) throws IOException {
    if (buffer.length != theLastElementWithData) {
      int[] tempArray = new int[theLastElementWithData];
      System.arraycopy(buffer, 0, tempArray, 0, theLastElementWithData);
      dataToResultFile.write(Parser.parseIntArrayToByteArray(tempArray));
    } else {
      dataToResultFile.write(Parser.parseIntArrayToByteArray(buffer));
    }

  }
}

