package test.ua.goit.xmlparser;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

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
  @Test
  public void testReader2() throws IOException {
    
    final String testCase = "<?xml 10><br param=\"par_value\"><aa>val1</aa><bb>val2<cc></cc></bb>"; 
    final XMLElementsReader xmlReader = new XMLElementsReader (new ByteArrayInputStream(testCase.getBytes()));
    char lastChar,firstChar;
    
    StringBuilder actual = new StringBuilder();
    String actualTag ="";
    
   
    try {
      
      while(xmlReader.ready()){

        actualTag =  xmlReader.getElement(); 
        
        if(actualTag.length() < 2){
          fail("XMLElementsReader error");
        }
        firstChar = actualTag.charAt(0);
        lastChar  = actualTag.charAt(actualTag.length() -1);
        
        if(firstChar == '<' && lastChar == '>' ){
          //Tag
          actual.append(actualTag);
          // Value
        }else if (firstChar == '>' && (lastChar == '<'|| lastChar == '>')){
          actual.append(actualTag.substring(1,actualTag.length() -1));
        }else{
          fail("XMLElementsReader error");
        }
      }

      assertEquals(testCase,actual.toString());
      
    } catch (IOException e) {
      e.printStackTrace();
    }
    finally{
      xmlReader.close(); 
    }
 }
}
