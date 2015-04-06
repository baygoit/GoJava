package ua.goit.alg.sortBigFile;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class CutBigFile {
  private MergeSort mergeSort = null;
  private DataOutputStream dataToTempFile = null;
  private byte[] buffer;
  private List<String> filesAfterCut = new ArrayList<String>();

  public CutBigFile(int bufferSize) {
    buffer = new byte[bufferSize];
  }

  /**
   * this function cut big file by smallest one (BYTE_BUFFER_SIZE)
   */
  public List<String> cutBigFile(File bigFile) throws IOException {
    int[] sortedArray;
    DataInputStream dataFromFile = new DataInputStream(
            new FileInputStream(bigFile));
    int fileCount = 0;
    int bufferLength;
    while ((bufferLength = arrayFromBigFile(dataFromFile)) > 0) {
      if (bufferLength != buffer.length) {
        byte[] realBuffer = new byte[bufferLength];
        System.arraycopy(buffer, 0, realBuffer, 0, bufferLength);
        sortedArray = sortByMergeSort(Parser.parseByteArrayToIntArray(realBuffer));
      } else {
        sortedArray = sortByMergeSort(Parser.parseByteArrayToIntArray(buffer));
      }

      filesAfterCut.add(tempFileWriter(Constants.TEMP_FILE_NAME + "0_", fileCount, sortedArray));
      fileCount++;
    }

    dataFromFile.close();
    return filesAfterCut;
  }

  /**
   * this function write temp file on temp dir
   */
  private String tempFileWriter(String fileName, int fileCount, int[] sortedArray) throws IOException {
    String tempFilePath = Constants.PATH_TO_TEMP_DIR_UNIX + fileName + fileCount + Constants.FILE_TYPE;
    File tempFile = new File(tempFilePath);
    if (tempFile.createNewFile()) {
      dataToTempFile = new DataOutputStream(new FileOutputStream(tempFile));
      dataToTempFile.write(Parser.parseIntArrayToByteArray(sortedArray));
      dataToTempFile.close();
    }

    return tempFilePath;
  }

  /**
   * run merge sort for array
   */
  private int[] sortByMergeSort(int[] notSortedArray) {
    return mergeSort.mergeSort(notSortedArray);
  }

  /**
   * get array from big file by buffer size
   */
  private int arrayFromBigFile(DataInputStream dataFromFile) throws IOException {
    int length = 0;
    if ((length = dataFromFile.read(buffer)) > 0) {
      return length;
    }

    return length;
  }

}
