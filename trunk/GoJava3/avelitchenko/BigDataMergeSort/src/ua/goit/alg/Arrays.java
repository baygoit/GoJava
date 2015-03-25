package ua.goit.alg;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Arrays {
  //temp.tmp = 321 456 323 452 123 345 222 111 333 555 6666 999 444 4 3 2 4 66 76 43 22 44 11 345 78 45
  // we can use only 10 memory
  final static int MEMORY = 10;

  public static void main(String[] args) {
    
    try {
      File file1 = createTempFileName("1");
      file1.delete();
    } catch (Exception e) {
      e.printStackTrace();
    }
    
    mergeSort(createTempFileName(""));

    System.out.println("done");
    }

  public static void mergeSort(File file) {
    int[] fullMemoryArray = new int[MEMORY];
    int[] additionalMemoryArray = new int[MEMORY];
    try(Scanner in = new Scanner(file)) {
      int i = -1;
      while(in.hasNext()){
        i++;
        fullMemoryArray[i] = in.nextInt();
        if (i == MEMORY - 1){
          MergeSort.mergeSort(fullMemoryArray,additionalMemoryArray,0,i);
          arrayToFile(additionalMemoryArray,i);
          i = -1;
        }
      }
      MergeSort.mergeSort(fullMemoryArray,additionalMemoryArray,0,i);
      arrayToFile(fullMemoryArray,i);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (Exception e) {
      e.printStackTrace();
    }
 
 }
 
  private static void arrayToFile(int[] source,int length) {
    File file1 = createTempFileName("1");
    File file2 = createTempFileName("2");
    try (FileWriter writer = new FileWriter(file2);
        Scanner in = new Scanner(file1)){
      int localIntFromFile = 0;
      if (in.hasNext()){
        localIntFromFile = in.nextInt(); 
      }
      boolean endOfFile = !in.hasNext();
      boolean endOfArray = !(length >= 0);
      int i = 0;
      while (!endOfFile || !endOfArray) {
        if ((endOfFile) || ((localIntFromFile >= source[i]) && (!endOfArray))){
          writer.write("" + source[i++] + " ");
          endOfArray = (i > length);
        } else if ((endOfArray) || ((localIntFromFile <= source[i]) && (!endOfFile))) {
          writer.write("" + localIntFromFile + " ");
          if (in.hasNext()) {
            localIntFromFile = in.nextInt();
          } else {
            endOfFile = true;
          }  
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    
    file1.delete();
    file2.renameTo(file1);
  }

  public static File createTempFileName(String suffix) {
    File file = new File("d:\\temp" + suffix + ".tmp");
    if (!file.exists()){
      try {
        file.createNewFile();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    return file;
  }
}
