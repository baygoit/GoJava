package ua.goit.alg.xmlparser.input;

import java.io.File;

public class InputStream {
  private InputStream inputStream;

  InputStream(String inputData){
    inputStream = new InputStream(inputData);
  }

  InputStream(File inputData) {
    inputStream = new InputStream(inputData);
  }

  public boolean hasNext(){
    return inputStream.hasNext();
  }
  public char nextChar(){
    return inputStream.nextChar();
  }
 
}
