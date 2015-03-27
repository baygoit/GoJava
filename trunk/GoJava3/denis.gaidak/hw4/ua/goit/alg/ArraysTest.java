package ua.goit.alg;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class ArraysTest {

@Before
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
    int count = 100;
    for (int i = 0; i < count; i++) {
      fileWriter.write(random.nextInt(count) + "\n");
    }
    fileWriter.close();
  }

  @Test
  public void testMergeSort() throws Exception {
    String filePath = System.getProperty("user.dir") + "\\hw4\\ua\\goit\\alg\\test\\testResource.txt";
    File file = new File(filePath);
    Arrays.mergeSort(file);
  }


}