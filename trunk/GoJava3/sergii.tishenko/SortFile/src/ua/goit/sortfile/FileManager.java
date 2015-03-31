package ua.goit.sortfile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class FileManager {

  static Set<String> files = new HashSet<String>();
  static Set<String> filesHistory = new HashSet<String>();
  static int counter = 0;

  static String getNewFilename() {
    return App.DIR_NAME + "\\" + "tmp_" + Integer.toString(counter++);
  }

  void writeToFile(List<Integer> arg) {
    String fileName = getNewFilename();

    files.add(fileName);

    try (FileWriter fw = new FileWriter(fileName)) {
      for (Integer integer : arg) {
        fw.write(integer.toString());
        fw.write("\n");
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  void margeAllFiles() {

    while (files.size() > 1) {
      margeFiles();
    }

    for (String fileName : filesHistory) {
      try{
        
        File file = new File(fileName);
        if(file.delete()){
          System.out.println(file.getName() + " is deleted!");
        }else{
          System.out.println("Delete operation is failed.");
        }
      }catch(Exception e){
        e.printStackTrace();
      }
    }


    for (String file : files) {
      System.out.println("result file:" + file);
    }

  }

  private void margeFiles() {

    Set<String> oldFiles = new HashSet<String>(files);

    for (Iterator fileIterator = oldFiles.iterator(); fileIterator.hasNext();) {

      String fileIn1 = (String) fileIterator.next();
      String fileIn2 = null;
      String fileOut = null;

      int val1, val2;
      if (fileIterator.hasNext()) {
        fileIn2 = (String) fileIterator.next();
        fileOut = getNewFilename();

        try (BufferedReader fileReader1 = new BufferedReader(new FileReader(
            fileIn1));
            BufferedReader fileReader2 = new BufferedReader(new FileReader(
                fileIn2));
            FileWriter fileWriter = new FileWriter(fileOut)) {

          val1 = Integer.parseInt(fileReader1.readLine());
          val2 = Integer.parseInt(fileReader2.readLine());

          while (fileReader1.ready() && fileReader2.ready()) {
            if (val1 < val2) {
              fileWriter.write(Integer.toString(val1) + "\n");
              val1 = Integer.parseInt(fileReader1.readLine());
            } else {
              fileWriter.write(Integer.toString(val2) + "\n");
              val2 = Integer.parseInt(fileReader2.readLine());
            }
          }

          boolean writted = false;
          
          if (fileReader1.ready()) {

            while (fileReader1.ready()) {
              if (val1 < val2) {
                fileWriter.write(Integer.toString(val1) + "\n");
                val1 = Integer.parseInt(fileReader1.readLine());
              } else {
                writted = true;
                fileWriter.write(Integer.toString(val2) + "\n");
                fileWriter.write(Integer.toString(val1) + "\n");
                while (fileReader1.ready()) {
                  fileWriter.write(fileReader1.readLine() + "\n");
                }
              }
            }
          } else {
            while (fileReader2.ready()) {
              if (val1 > val2) {
                fileWriter.write(Integer.toString(val2) + "\n");
                val2 = Integer.parseInt(fileReader2.readLine());
              } else {
                fileWriter.write(Integer.toString(val1) + "\n");
                fileWriter.write(Integer.toString(val2) + "\n");
                writted = true;
                while (fileReader2.ready()) {
                  fileWriter.write(fileReader2.readLine() + "\n");
                }
              }
            }
          }

          if(!writted){
            if (val1 < val2) {
              fileWriter.write(Integer.toString(val1) + "\n");
              fileWriter.write(Integer.toString(val2) + "\n");
            } else {
              fileWriter.write(Integer.toString(val2) + "\n");
              fileWriter.write(Integer.toString(val1) + "\n");
            }
          }

          removeFile(fileIn1);
          removeFile(fileIn2);
          files.add(fileOut);

        } catch (FileNotFoundException e) {

          e.printStackTrace();
        } catch (IOException e1) {

          e1.printStackTrace();
        }
      }
    }
  }

  void removeFile(String arg) {
    if (files.remove(arg)) {
      filesHistory.add(arg);
    }
  }
}
