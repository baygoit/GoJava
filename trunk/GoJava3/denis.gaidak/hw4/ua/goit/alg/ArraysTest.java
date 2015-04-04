package ua.goit.alg;

import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.LinkedList;
import java.util.Random;

public class ArraysTest {

//@Before
  public void addResource() {

    try {
      createTestFile();
    } catch (IOException e) {
      e.printStackTrace();
    }

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
    String filePath = System.getProperty("user.dir") + "\\hw4\\ua\\goit\\alg\\test\\testResource.txt";
    File testResource = new File(filePath);
    testResource.createNewFile();
    try(FileOutputStream out = new FileOutputStream(testResource)) {
      FileChannel file = out.getChannel();
      ByteBuffer byteBuffer = ByteBuffer.allocate(4);
      for (int i = 0; i < 10; i++) {

        byteBuffer.putInt(i);
        byteBuffer.order();
        file.write(byteBuffer);
        byteBuffer.order();
        byteBuffer.clear();
      }
      out.close();
      file.close();
    }
  }


}