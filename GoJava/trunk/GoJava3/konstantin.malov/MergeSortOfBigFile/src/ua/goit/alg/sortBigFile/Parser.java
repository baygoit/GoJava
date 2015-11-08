package ua.goit.alg.sortBigFile;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;

public class Parser {
  private Parser() {

  }

  public static int[] parseByteArrayToIntArray(byte[] buffer) {
    ByteBuffer byteBuffer = ByteBuffer.wrap(buffer).order(ByteOrder.BIG_ENDIAN);
    IntBuffer intBuf = byteBuffer.asIntBuffer();
    int[] intArrayToReturn = new int[intBuf.remaining()];
    intBuf.get(intArrayToReturn);
    return intArrayToReturn;
  }

  public static byte[] parseIntArrayToByteArray(int[] array) {
    ByteBuffer byteBuffer = ByteBuffer.allocate(array.length * 4);
    IntBuffer intBuffer = byteBuffer.asIntBuffer();
    intBuffer.put(array);
    byte[] result = byteBuffer.array();
    return result;
  }

}
