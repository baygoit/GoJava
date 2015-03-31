package ua.goit.sortfile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class App {

  static int FILE_BUFFER_SIZE = 100_000;
  public static final String DIR_NAME = "d:\\";
  public static final String FILE_NAME = "testint.txt";
  public static final int VALUE_QUANTITY = 1_000_000;

  public static void main(String[] arg) {

    List<String> strValues = new LinkedList<String>();
    List<Integer> intValues = new LinkedList<Integer>();
    FileManager fileManager = new FileManager();

    try (BufferedReader bfr = new BufferedReader(new FileReader(DIR_NAME + "\\"
        + FILE_NAME))) {
      while (bfr.ready()) {
        int i = 0;
        strValues.clear();
        while (i++ < FILE_BUFFER_SIZE && bfr.ready()) {
          strValues.add(bfr.readLine());
        }
        intValues = convertStrListToIntList(strValues);
        intValues = MergSort.SortArray(intValues);
        fileManager.writeToFile(intValues);
      }
      fileManager.margeAllFiles();

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static List<Integer> convertStrListToIntList(List<String> argList) {

    String strValue = "";
    List<Integer> res = new LinkedList<Integer>();

    for (Iterator<String> iterator = argList.iterator(); iterator.hasNext();) {
      strValue = (String) iterator.next();
      res.add(Integer.parseInt(strValue));
    }

    return res;
  }

}
