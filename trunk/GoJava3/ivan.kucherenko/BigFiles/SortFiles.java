package ua.goit.alg;

import java.io.File;
import java.io.IOException;

public class SortFiles {
  public static void buildFile(int filesCounter) throws IOException {
    System.out.println(filesCounter);
    File first = null;
    File second = null;
    File target = null;
    int countFirst = 0;
    int countSecond = 1;
    int countTarget = 1;
    first = new File("//home//svetliy//TEST//TEMP//temp"+countFirst);
    second = new File("//home//svetliy//TEST//TEMP//temp"+countSecond);
    target = new File("//home//svetliy//TEST//result0"+countTarget);
    MergeFiles.mergeFiles(first, second, target);
    
    for (int i = 1; i < filesCounter;i++){
      first = new File("//home//svetliy//TEST//result0"+i);
      second = new File("//home//svetliy//TEST//TEMP//temp"+i);
      target = new File("//home//svetliy//TEST//result0"+(i+1));
      MergeFiles.mergeFiles(first, second, target);
    }
    deleteAllTempFiles(filesCounter);
  }
  private static void deleteAllTempFiles(int filesCounter){
   for (int i = 0; i < filesCounter; i++){
     new File("//home//svetliy//TEST//TEMP//temp"+ i).delete();
     new File("//home//svetliy//TEST//result0"+i).delete();
   } new File("//home//svetliy//TEST//TEMP//temp"+ (filesCounter-1)).delete();
  }
}