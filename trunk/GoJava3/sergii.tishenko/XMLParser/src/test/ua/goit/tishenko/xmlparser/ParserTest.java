package ua.goit.tishenko.xmlparser;

import java.io.File;

import org.junit.Test;
 
public class ParserTest {

  @Test
  public void parseString() {
    XMLParser parser = new XMLParser();
    parser.parse("<aaa>");
    
  }

 // @Test (expected = RuntimeException.class)
  @Test
  public void parseFile() {
    File file = new File("c:\\1.xml");
    XMLParser parser = new XMLParser();
    parser.parse(file);
  }
  
  
 

}
