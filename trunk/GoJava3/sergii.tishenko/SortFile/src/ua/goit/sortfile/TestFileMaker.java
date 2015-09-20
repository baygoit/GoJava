package ua.goit.sortfile;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class TestFileMaker {

  public static void main(String[] args) {

    Writer fwr = null;
    try {
      fwr = new BufferedWriter(new FileWriter(App.DIR_NAME + "\\"
          + App.FILE_NAME));
      int val;
      for (int i = 0; i < App.VALUE_QUANTITY; i++) {
        val = (int) (Math.random() * 1000000);
        fwr.write(Integer.toString(val));
        fwr.write('\n');
      }

    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e1) {
      e1.printStackTrace();
    } finally {
      try {
        fwr.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }

}
