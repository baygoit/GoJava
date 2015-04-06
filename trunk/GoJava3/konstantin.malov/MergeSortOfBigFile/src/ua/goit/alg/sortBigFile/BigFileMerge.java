package ua.goit.alg.sortBigFile;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static ua.goit.alg.sortBigFile.Constants.*;

public class BigFileMerge {
  private int firstCountNumber = 1;
  private int secondCountNumber = 0;

  public String mergeSortFile(String bigfile, String fileAfterSort)
          throws IOException {
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

  private static class Buffer {
    private byte[] buffer = new byte[BYTE_BUFFER_SIZE];
    private int[] bufferInt = new int[BYTE_BUFFER_SIZE / 4];
    private DataInputStream dataFromFile;
    private int length;
    private int index = 0;

    public Buffer(DataInputStream dataFromFile) throws FileNotFoundException {
      this.dataFromFile = dataFromFile;
    }

    public int readDataFromFile() throws IOException {
      length = dataFromFile.read(buffer) / 4;
      bufferInt = Parser.parseByteArrayToIntArray(buffer);
      index = 0;
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
      int[] tempArray = Arrays.copyOf(getBufferInt(), dataInBufferLeft());
      bigFile.writeBufferToFile(tempArray, tempArray.length, dataResultFile);
    }

    public int[] getBufferInt() {
      return bufferInt;
    }
  }

  /**
   * this function merge to file, save result to new temp file and return his path
   */
  public String mergeFiles(File firstFile, File secondFile) throws IOException {
    DataInputStream dataFromFirsFile = new DataInputStream(new FileInputStream(firstFile));
    DataInputStream dataFromSecondFile = new DataInputStream(new FileInputStream(secondFile));
    Buffer firstFileBuffer = new Buffer(dataFromFirsFile);
    Buffer secondFileBuffer = new Buffer(dataFromSecondFile);
    int[] resultFileBuffer = new int[(BYTE_BUFFER_SIZE) / 4];
    String fileNameForReturn = PATH_TO_TEMP_DIR_UNIX + TEMP_FILE_NAME +
            firstCountNumber + "_" + secondCountNumber + FILE_TYPE;
    DataOutputStream dataToResultFile = new DataOutputStream(
            new FileOutputStream(new File(fileNameForReturn)));
    int count = 0;
    while (firstFileBuffer.readDataFromFile() > 0 ||
            (secondFileBuffer.readDataFromFile()) > 0) {
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

        if (count == resultFileBuffer.length - 1) {
          writeBufferToFile(resultFileBuffer, count, dataToResultFile);
          count = 0;
        }
      }

      if (count > 0) {
        writeBufferToFile(resultFileBuffer, count, dataToResultFile);
        count = 0;
      }

      if (firstFileBuffer.hasAnyBytesLeft()) {
        firstFileBuffer.writeRemainsTo(dataToResultFile, this);
      }

      if (secondFileBuffer.hasAnyBytesLeft()) {
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
      int[] tempArray = new int[theLastElementWithData];
      System.arraycopy(buffer, 0, tempArray, 0, theLastElementWithData);
      dataToResultFile.write(Parser.parseIntArrayToByteArray(tempArray));
    } else {
      dataToResultFile.write(Parser.parseIntArrayToByteArray(buffer));
    }
  }
}