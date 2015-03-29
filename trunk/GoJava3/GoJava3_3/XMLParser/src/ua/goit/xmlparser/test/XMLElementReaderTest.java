package ua.goit.xmlparser.test;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import org.junit.Test;

import ua.goit.xmlparser.XMLElementsReader;

public class XMLElementReaderTest {

  @Test
  public void testSplitting() throws IOException {
    
    final String testCase = "<?xml 10><br param=\"par_value\"><aa>val1</aa><bb>val2<cc></cc></bb>"; 
    final XMLElementsReader xmlReader = new XMLElementsReader (new ByteArrayInputStream(testCase.getBytes()));
    
    
    String actual ="";
    String expected ="";
    
   
    try {
      
      expected ="<?xml 10>";
      actual =  xmlReader.getElement();
      assertEquals(expected,actual);
      
      expected ="<br param=\"par_value\">";
      actual =  xmlReader.getElement();
      assertEquals(expected,actual);
      
      expected ="<aa>";
      actual =  xmlReader.getElement();
      assertEquals(expected,actual);
      
      expected =">val1<";
      actual =  xmlReader.getElement();
      assertEquals(expected,actual);

      expected ="</aa>";
      actual =  xmlReader.getElement();
      assertEquals(expected,actual);
            
      expected ="<bb>";
      actual =  xmlReader.getElement();
      assertEquals(expected,actual);
      
      expected =">val2<";
      actual =  xmlReader.getElement();
      assertEquals(expected,actual);

      expected ="<cc>";
      actual =  xmlReader.getElement();
      assertEquals(expected,actual);
      
      expected ="</cc>";
      actual =  xmlReader.getElement();
      assertEquals(expected,actual);
      
      expected ="</bb>";
      actual =  xmlReader.getElement();
      assertEquals(expected,actual);
      

      
      
    } catch (IOException e) {
      e.printStackTrace();
    }
    finally{
      xmlReader.close(); 
    }
    
    
    
  }

}
