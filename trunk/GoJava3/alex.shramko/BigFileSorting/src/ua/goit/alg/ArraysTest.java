package ua.goit.alg;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ArraysTest {

  @Before
  public void fileCreating() {
    try {
      String content = "5 6 8 11 21 5 4 3 6 6 99 0";
      File file = new File("/1.txt");
      if (!file.exists()) {
        file.createNewFile();
      }
      FileWriter fw = new FileWriter(file.getAbsoluteFile());
      BufferedWriter bw = new BufferedWriter(fw);
      bw.write(content);
      bw.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Test
  public void test() {
    File file = new File("/1.txt");
    Arrays.mergeSort(file);
    BufferedReader br = null;
    try {
      br = new BufferedReader(new FileReader(file));
      String actual = br.readLine();
      String expected = "0 3 4 5 5 6 6 6 8 11 21 99";
      assertEquals(expected, actual);
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      try {
        if (br != null)
          br.close();
      } catch (IOException ex) {
        ex.printStackTrace();
      }
    }
  }
  
  @After
  public void fileDeleting() {
    File file = new File("/1.txt");
    if (file.exists()) {
      file.delete();
    }
  }

}
