package ua.goit.alg.tests;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ua.goit.alg.Arrays;
import ua.goit.alg.FileProcessor;

/** 
 * 
 * @author Александр
 *
 */
public class ArraysTest {

  @Before
  public void fileCreating() {
      String content = "5 6 8 11 21 5 4 3 6 6 99 0 98";
      File file = new File("/1.txt");
      FileProcessor.writeStringToFile(content, file);
  }

  @Test
  public void test() {
    File file = new File("/1.txt");
    Arrays.mergeSort(file);
    String expected = "0 3 4 5 5 6 6 6 8 11 21 98 99";
    String actual = FileProcessor.readStringFromFile(file);

    assertEquals(expected, actual);
    
  }
  
  @After
  public void fileDeleting() {
    File file = new File("/1.txt");
    if (file.exists()) {
      file.delete();
    }
  }

}
