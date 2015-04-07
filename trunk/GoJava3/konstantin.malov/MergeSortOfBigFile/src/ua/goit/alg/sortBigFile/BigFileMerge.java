package ua.goit.alg.sortBigFile;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static ua.goit.alg.sortBigFile.Constants.*;

public class BigFileMerge {

  /**
   * this function receive unsorted file with int, cut them on temp file,
   * sort them, and receive join sorted file.
   */
  public static void mergeSortFile(String bigFile,
                                   String fileAfterSort,
                                   int bufferSize) throws IOException {
    CutBigFile cutBigFile = new CutBigFile(bufferSize);
    File bigFileNotSorted = new File(bigFile);
    List cutFiles = cutBigFile.cutBigFile(bigFileNotSorted);
    FileOperations.fileCopy(merge(cutFiles, 1, 0, bufferSize), fileAfterSort);
    FileOperations.dirClear(PATH_TO_TEMP_DIR_UNIX);
  }

  /**
   * this function recursion merges all temp files
   */
  private static String merge(List<String> filesList,
                              int firstCountNumber,
                              int secondCountNumber,
                              int bufferSize) throws IOException {
    int filesCount = filesList.size();
    if (filesCount == 1) {
      return filesList.get(0);
    }

    List<String> newFilesList = new ArrayList<>();
    for (int i = 0; i < filesCount; i += 2) {
      if (i == filesCount - 1) {
        newFilesList.add(filesList.get(i));
        secondCountNumber = 0;
        firstCountNumber++;
        return merge(newFilesList, firstCountNumber,
                secondCountNumber, bufferSize);
      }

      File file = new File(filesList.get(i));
      File nextFile = new File(filesList.get(i + 1));
      newFilesList.add(mergeFiles(file, nextFile,firstCountNumber,
              secondCountNumber,bufferSize));
      secondCountNumber++;
    }

    secondCountNumber = 0;
    firstCountNumber++;
    return merge(newFilesList, firstCountNumber, secondCountNumber, bufferSize);
  }

  private static class Buffer {
    private byte[] buffer;
    private int[] bufferInt;
    private DataInputStream dataFromFile;
    private int length = 0;
    private int index = 0;
    private boolean eof = false;

    public Buffer(DataInputStream dataFromFile, int bufferSize)
            throws FileNotFoundException {
      this.dataFromFile = dataFromFile;
      buffer = new byte[bufferSize];
    }

    public int readDataFromFile() throws IOException {
      length = dataFromFile.read(buffer) / 4;
      bufferInt = new int[length];
      bufferInt = Parser.parseByteArrayToIntArray(buffer);
      index = 0;
      if (length == 0) {
        eof = true;
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

    public void writeRemainsTo(DataOutputStream dataResultFile)
            throws IOException {
      int[] tempArray = new int[dataInBufferLeft()];
      System.arraycopy(getBufferInt(), index, tempArray, 0, dataInBufferLeft());
      writeBufferToFile(tempArray, tempArray.length, dataResultFile);
      index = 0;
      length = 0;
    }

    public int[] getBufferInt() {
      return bufferInt;
    }
  }

  /**
   * this function merge to file,
   * save result to new temp file and return his path
   */
  private static String mergeFiles(File firstFile, File secondFile,
                                   int firstCountNumber,
                                   int secondCountNumber,
                                   int bufferSize) throws IOException {
    DataInputStream dataFromFirsFile =
            new DataInputStream(new FileInputStream(firstFile));
    DataInputStream dataFromSecondFile =
            new DataInputStream(new FileInputStream(secondFile));
    Buffer firstFileBuffer = new Buffer(dataFromFirsFile, bufferSize);
    Buffer secondFileBuffer = new Buffer(dataFromSecondFile, bufferSize);
    int[] resultFileBuffer = new int[(bufferSize) / 4];
    String fileNameForReturn = PATH_TO_TEMP_DIR_UNIX + TEMP_FILE_NAME +
            firstCountNumber + "_" + secondCountNumber + FILE_TYPE;
    DataOutputStream dataToResultFile = new DataOutputStream(
            new FileOutputStream(new File(fileNameForReturn)));
    int count = 0;
    while (!(firstFileBuffer.eof && secondFileBuffer.eof)) {
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

      if (firstFileBuffer.hasAnyBytesLeft() && secondFileBuffer.eof) {
        firstFileBuffer.writeRemainsTo(dataToResultFile);
      }

      if (secondFileBuffer.hasAnyBytesLeft() && firstFileBuffer.eof) {
        secondFileBuffer.writeRemainsTo(dataToResultFile);
      }
    }

    return fileNameForReturn;
  }

  private static void writeBufferToFile(int[] buffer, int theLastElementWithData,
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