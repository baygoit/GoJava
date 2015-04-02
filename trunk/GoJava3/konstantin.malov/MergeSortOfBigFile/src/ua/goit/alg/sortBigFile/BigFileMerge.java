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

  private class Buffer {
    private byte[] buffer = new byte[BYTE_BUFFER_SIZE];
    private DataInputStream dataFromFile;
    private int[] intBuffer = new int[BYTE_BUFFER_SIZE / 4];

    public Buffer(File file) throws FileNotFoundException {
      dataFromFile = new DataInputStream(new FileInputStream(file));
    }

    public int readDataFromFile() throws IOException {
      int length = dataFromFile.read(buffer) / 4;
      intBuffer = Parser.parseByteArrayToIntArray(buffer);
      return length;
    }

    public int[] getIntBuffer() {
      return intBuffer;
    }
  }

  /**
   * this function merge to file, save result to new temp file and return his path
   */
  public String mergeFiles(File firstFile, File secondFile) throws IOException {
    Buffer firstFileBuffer = new Buffer(firstFile);
    Buffer secondFileBuffer = new Buffer(secondFile);
    int[] resultFileBuffer = new int[(BYTE_BUFFER_SIZE) / 4];
    String fileNameForReturn = PATH_TO_TEMP_DIR_UNIX + TEMP_FILE_NAME +
            firstCountNumber + "_" + secondCountNumber + FILE_TYPE;
    DataOutputStream dataToResultFile = new DataOutputStream(
            new FileOutputStream(new File(fileNameForReturn)));
    int firstFileBufferIntLength = 0;
    int secondFileBufferIntLength = 0;
    int count = 0;
    while ((firstFileBufferIntLength = firstFileBuffer.readDataFromFile()) > 0 ||
            (secondFileBufferIntLength = secondFileBuffer.readDataFromFile()) > 0) {
      int firstBufferCount = 0;
      int secondBufferCount = 0;
      while (firstBufferCount < firstFileBufferIntLength &&
              secondBufferCount < secondFileBufferIntLength) {
        if (firstFileBuffer.getIntBuffer()[firstBufferCount] <
                secondFileBuffer.getIntBuffer()[secondBufferCount]) {
          resultFileBuffer[count++] = firstFileBuffer.getIntBuffer()[firstBufferCount++];
        } else {
          resultFileBuffer[count++] = firstFileBuffer.getIntBuffer()[secondBufferCount++];
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
        int[] tempArray = Arrays.copyOf(firstFileBuffer.getIntBuffer(), tempArrLength);
        writeBufferToFile(tempArray, tempArrLength, dataToResultFile);
      }

      if (secondBufferCount < secondFileBufferIntLength) {
        int tempArrLength = secondFileBufferIntLength - secondBufferCount;
        int[] tempArray = Arrays.copyOf(secondFileBuffer.getIntBuffer(), tempArrLength);
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