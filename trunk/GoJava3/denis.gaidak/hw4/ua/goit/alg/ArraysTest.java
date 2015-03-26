package ua.goit.alg;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class ArraysTest {

//  @Before
  public void addResource() {

    try {
      createTestFile();
    } catch (IOException e) {
      e.printStackTrace();
    }

  }

  public void createTestFile() throws IOException {
    String dir = System.getProperty("user.dir") + "\\hw4\\ua\\goit\\alg\\test\\testResource.txt";
    System.out.println(dir);
    File testResource = new File(dir);
    testResource.createNewFile();
    FileWriter fileWriter = new FileWriter(testResource);
    Random random = new Random();
    for (int i = 0; i < 100; i++) {
      fileWriter.write(random.nextInt(100) + "\n");
    }

    fileWriter.close();
  }

  @Test
  public void testMergeSort() throws Exception {
    Arrays arrays = new Arrays();
    String dir = System.getProperty("user.dir") + "\\hw4\\ua\\goit\\alg\\test\\testResource.txt";
    File file = new File(dir);
    Arrays.mergeSort(file);
  }

}