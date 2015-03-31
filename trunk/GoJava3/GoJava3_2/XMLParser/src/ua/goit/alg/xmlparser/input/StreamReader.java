package ua.goit.alg.xmlparser.input;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class StreamReader {
  private BufferedReader inputStreamFile = null;
  private String inputStreamString = null;
  private boolean isString = true;
  private int index = 0;

  public StreamReader(String inputData) throws FileNotFoundException{
    inputStreamString = inputData;
    isString = true;
  }

  public StreamReader(File inputData) throws FileNotFoundException{
    inputStreamFile = new BufferedReader(new FileReader(inputData));
    isString = false;
  }

  public int read() throws IOException{
    if (isString){
    return readString();
    } else {
      int i = inputStreamFile.read();
      if (i==-1) {
        close();
      }
      return i;
    }
  }
  
  public void close() throws IOException{
    inputStreamFile.close();
  }
  
  private int readString(){
    if (index < inputStreamString.length()){
      int result = inputStreamString.charAt(index); //toCharArray()[index];
      index++;
      return result;
    } else {
      index = 0;
      return -1;
    }
  }
}
