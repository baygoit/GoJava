package ua.goit.alg.xmlparser.input;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class InputStream {
  private BufferedReader inputStream = null;

  public InputStream(String inputData) throws FileNotFoundException{
    inputStream = new BufferedReader(new FileReader(inputData));
  }

  public InputStream(File inputData) throws FileNotFoundException{
    inputStream = new BufferedReader(new FileReader(inputData));
  }

  public int read() throws IOException{
    return inputStream.read();
  }
  
  public void close() throws IOException{
    inputStream.close();
  }
 
}
