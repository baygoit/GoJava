

package ua.goit.alg;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Arrays {
 
  private static final int BUFFER_SIZE = 20;
  private static BufferedWriter br = null;
  private static int fileCounter = 0;
 
  public static void main(String [] args) throws IOException{
    File file = new File("//home//svetliy//TEST//test1");
    mergeSort(file);
  }

  public static void mergeSort(File file) throws IOException {
   int [] buffer = new int[BUFFER_SIZE];
   int count = 0;
   Scanner scan = new Scanner(file);
     while (scan.hasNext())
     {
       if (count < BUFFER_SIZE){
         buffer[count] = scan.nextInt();
         count++;
       } else if (!scan.hasNext() && count < BUFFER_SIZE)
       {
         br = new BufferedWriter(new FileWriter("//home//svetliy//TEST//TEMP//temp"+fileCounter));
         int [] residue = new int [count+1];
         System.arraycopy(buffer, 0, residue, 0, count+1);
         MergeSort.mergeSort(residue);
         
           for (int i: residue)
           {
               br.write(i+" ");
               br.flush();
           }
     
         fileCounter++;
       } else {
           br = new BufferedWriter(new FileWriter("//home//svetliy//TEST//TEMP//temp"+fileCounter));
           MergeSort.mergeSort(buffer);
           
           for (int i: buffer)
           {
             br.write(i+" ");
             br.flush();
           }
       
           fileCounter++;
           count=0;
       }
     }
     br.close();
     scan.close();
   SortFiles.buildFile(fileCounter);
  }
}
