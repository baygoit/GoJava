package ua.goit.alg;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MergeFiles {
    
public static void mergeFiles(File first, File second, File target) throws IOException {

 BufferedWriter writer = new BufferedWriter(new FileWriter(target));
 Scanner file1 = new Scanner(first);
 Scanner file2 = new Scanner(second);
 int left = file1.nextInt();
 int right = file2.nextInt();
 boolean endLastSmallIndex = false;
   while (file1.hasNext() || file2.hasNext())
    {
     if (left < right || (left >= right && endLastSmallIndex)){
          writer.write(left+" ");
          writer.flush();
          left = file1.nextInt(); 
      } else if (!endLastSmallIndex) {
          writer.write(right+" ");
          writer.flush();
           if(file2.hasNext())
           {
            right = file2.nextInt();
           } else {
              writer.write(left+" ");
              left = file1.nextInt();
              endLastSmallIndex = true;
           }   
       } 
    }
  //Append numbers
   
  if(left < right){
   writer.write(left+" "+right+" ");
   } else if (!endLastSmallIndex) {
     writer.write(right+" "+left+" ");
   } else {
      writer.write(left+" ");
   }
    file1.close();
    file2.close();
    writer.close();
 }
}
