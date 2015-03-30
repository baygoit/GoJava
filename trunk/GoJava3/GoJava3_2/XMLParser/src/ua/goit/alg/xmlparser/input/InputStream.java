package ua.goit.alg.xmlparser.input;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class InputStream {
  private BufferedReader inputStreamFile = null;
  private String inputStreamString = null;
  private boolean isString = true;
  private static int counter = 0;

  public InputStream(String inputData) throws FileNotFoundException{
    inputStreamString = inputData;
    isString = true;
  }

  public InputStream(File inputData) throws FileNotFoundException{
    inputStreamFile = new BufferedReader(new FileReader(inputData));
    isString = false;
  }

  public int read() throws IOException{
    if (isString){
    return readString();
    } else {
      return inputStreamFile.read();
    }
  }
  
  public void close() throws IOException{
    inputStreamFile.close();
  }
  
  private int readString(){
    if (counter < inputStreamString.length()){
      int result = inputStreamString.toCharArray()[counter];
      counter++;
      return result;
    } else {
      counter = 0;
      return -1;
    }
  }
}
