package ua.goit.alg;

import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.util.LinkedList;
import java.util.Random;

public class ArraysTest {

  @Before
  public void addResource() throws IOException {

//    try {
//      createTestFile();
//    } catch (IOException e) {
//      e.printStackTrace();
//    }

    int NUM_INTS = 10000;
    int[] ints = new int[NUM_INTS];
    Random r = new Random();
    for (int i = 0; i < NUM_INTS; i++) {
      ints[i] = i;
    }

    storeFC(ints);

  }

  public void createTestFile() throws IOException {
    String filePath = System.getProperty("user.dir") + "\\hw4\\ua\\goit\\alg\\test\\testResource.txt";
    File testResource = new File(filePath);
    testResource.createNewFile();
    FileWriter fileWriter = new FileWriter(testResource);
    Random random = new Random();
    int count = Integer.MAX_VALUE / 5;
    for (int i = 0; i < count; i++) {
      fileWriter.write(random.nextInt(count) + "\n");
    }
    fileWriter.close();
  }

  @Test
  public void testMergeSort() throws Exception {
//    String filePath = System.getProperty("user.dir") + "\\hw4\\ua\\goit\\alg\\test\\testResource.txt";
//    File file = new File(filePath);
//    Arrays.mergeSort(file);
//    String filePath = System.getProperty("user.dir") + "\\hw4\\ua\\goit\\alg\\test\\testResource.txt";
//    File testResource = new File(filePath);
//    testResource.createNewFile();
//    try (FileOutputStream out = new FileOutputStream(testResource)) {
//      FileChannel file = out.getChannel();
//      ByteBuffer byteBuffer = ByteBuffer.allocate(4);
//      for (int i = 0; i < 10; i++) {
//
//        byteBuffer.putInt(i);
//        byteBuffer.order();
//        file.write(byteBuffer);
//        byteBuffer.order();
//        byteBuffer.clear();
//      }
//      out.close();
//      file.close();
//    }
  }

  private void storeFC(int[] ints) throws IOException {
    FileOutputStream out = null;
    try {
      out = new FileOutputStream("fc.txt");
      FileChannel file = out.getChannel();
//      ByteBuffer buf = file.map(FileChannel.MapMode.READ_WRITE, 0, 4 * ints.length);
      ByteBuffer buf = ByteBuffer.allocate(4 * ints.length);
      for (int i : ints) {
        buf.putInt(i);
      }
      buf.rewind();
      file.write(buf);
      file.close();
    } catch (IOException e) {
      throw new RuntimeException(e);
    } finally {
      safeClose(out);
    }


    FileInputStream reader = new FileInputStream("fc.txt");
    FileChannel fileChannel = reader.getChannel();
    ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

    fileChannel.read(byteBuffer);
    byteBuffer.flip();
    int limit = byteBuffer.limit();
    while(limit>0)
    {
      System.out.println(byteBuffer.getInt());
      limit-=4;
    }

    fileChannel.close();


  }

  private void safeClose(OutputStream out) {
    try {
      if (out != null) {
        out.close();
      }
    } catch (IOException e) {
      // do nothing
    }
  }

}