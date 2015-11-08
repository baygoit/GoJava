package ua.goit.tishenko.xmlparser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

import javax.management.RuntimeErrorException;

public class XMLParser {

  public void parse(String string) {
    parse(new StringReader(string));
  }

  public void parse(File file) {
    try {
      parse(new FileReader(file));
    } catch (FileNotFoundException e) {
      e.printStackTrace();
      throw new RuntimeException(e.getMessage());
    }
     
  }
  
  public void parse(Reader inStream) {
    BufferedReader inReader = new BufferedReader(inStream);
    
  }
}
