package ua.goit.alg.sortBigFile;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static ua.goit.alg.sortBigFile.Constants.*;

public class BigFileMerge {
  private int firstCountNumber = 1;
  private int secondCountNumber = 0;
  private static BigFileMerge bigFileMerge;
  private int bufferSize;

  public static BigFileMerge getInstance() {
    if (bigFileMerge == null) {
      bigFileMerge = new BigFileMerge();
    }

    return bigFileMerge;
  }

  /**
   * this function receive unsorted file with int, cut them on temp file,
   * sort them, and receive join sorted file.
   */
  public String mergeSortFile(String bigfile, String fileAfterSort,int bufferSize)
          throws IOException {
    this.bufferSize = bufferSize;
    firstCountNumber = 1;
    secondCountNumber = 0;
    CutBigFile cutBigFile = new CutBigFile(bufferSize);
    FileOperations.fileCopy(merge(cutBigFile.cutBigFile(
            new File(bigfile))), fileAfterSort);
    FileOperations.dirClear(PATH_TO_TEMP_DIR_UNIX);
    return fileAfterSort;
  }

  /**
   * this function recursion merge all temp files
   */
  private String merge(List<String> filesList) throws IOException {
    int filesCount = filesList.size();
    if (filesCount == 1) {
      return filesList.get(0);
    }

    List<String> newFilesList = new ArrayList<>();
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

  private static class Buffer {
    private byte[] buffer;
    private int[] bufferInt;
    private DataInputStream dataFromFile;
    private int length = 0;
    private int index = 0;
    private boolean EOF = false;

    public Buffer(DataInputStream dataFromFile, int bufferSize) throws FileNotFoundException {
      this.dataFromFile = dataFromFile;
      buffer = new byte[bufferSize];
    }

    public int readDataFromFile() throws IOException {
      length = dataFromFile.read(buffer) / 4;
      bufferInt = new int[length];
      bufferInt = Parser.parseByteArrayToIntArray(buffer);
      index = 0;
      if (length == 0) {
        EOF = true;
      }
      return length;
    }

    public boolean hasAnyBytesLeft() {
      return (length > index);
    }

    public int getCurrentValue() {
      return bufferInt[index];
    }

    public void next() {
      index++;
    }

    public int dataInBufferLeft() {
      return length - index;
    }

    public void writeRemainsTo(DataOutputStream dataResultFile, BigFileMerge bigFile) throws IOException {
      int[] tempArray = new int[dataInBufferLeft()];
      System.arraycopy(getBufferInt(), index, tempArray, 0, dataInBufferLeft());
      bigFile.writeBufferToFile(tempArray, tempArray.length, dataResultFile);
      index = 0;
      length = 0;
    }

    public int[] getBufferInt() {
      return bufferInt;
    }
  }

  /**
   * this function merge to file, save result to new temp file and return his path
   */
  private String mergeFiles(File firstFile, File secondFile) throws IOException {
    DataInputStream dataFromFirsFile = new DataInputStream(new FileInputStream(firstFile));
    DataInputStream dataFromSecondFile = new DataInputStream(new FileInputStream(secondFile));
    Buffer firstFileBuffer = new Buffer(dataFromFirsFile, bufferSize);
    Buffer secondFileBuffer = new Buffer(dataFromSecondFile, bufferSize);
    int[] resultFileBuffer = new int[(bufferSize) / 4];
    String fileNameForReturn = PATH_TO_TEMP_DIR_UNIX + TEMP_FILE_NAME +
            firstCountNumber + "_" + secondCountNumber + FILE_TYPE;
    DataOutputStream dataToResultFile = new DataOutputStream(
            new FileOutputStream(new File(fileNameForReturn)));
    int count = 0;
    while (!(firstFileBuffer.EOF && secondFileBuffer.EOF)) {
      if (!firstFileBuffer.hasAnyBytesLeft()) {
        firstFileBuffer.readDataFromFile();
      }

      if (!secondFileBuffer.hasAnyBytesLeft()) {
        secondFileBuffer.readDataFromFile();
      }

      while (firstFileBuffer.hasAnyBytesLeft() &&
              secondFileBuffer.hasAnyBytesLeft()) {
        int firstFileValue = firstFileBuffer.getCurrentValue();
        int secondFileValue = secondFileBuffer.getCurrentValue();
        if (firstFileValue < secondFileValue) {
          resultFileBuffer[count++] = firstFileValue;
          firstFileBuffer.next();
        } else {
          resultFileBuffer[count++] = secondFileValue;
          secondFileBuffer.next();
        }

        if (count == resultFileBuffer.length) {
          writeBufferToFile(resultFileBuffer, count, dataToResultFile);
          count = 0;
        }
      }

      if (count > 0) {
        writeBufferToFile(resultFileBuffer, count, dataToResultFile);
        count = 0;
      }

      if (firstFileBuffer.hasAnyBytesLeft() && secondFileBuffer.EOF) {
        firstFileBuffer.writeRemainsTo(dataToResultFile, this);
      }

      if (secondFileBuffer.hasAnyBytesLeft() && firstFileBuffer.EOF) {
        secondFileBuffer.writeRemainsTo(dataToResultFile, this);
      }
    }

    return fileNameForReturn;
  }

  private void resetCondition() {
    secondCountNumber = 0;
    firstCountNumber++;
  }

  private void writeBufferToFile(int[] buffer, int theLastElementWithData,
                                 DataOutputStream dataToResultFile)
          throws IOException {
    if (buffer.length != theLastElementWithData) {
      int[] tempArray = Arrays.copyOf(buffer, theLastElementWithData);
      dataToResultFile.write(Parser.parseIntArrayToByteArray(tempArray));
    } else {
      dataToResultFile.write(Parser.parseIntArrayToByteArray(buffer));
    }
  }
}