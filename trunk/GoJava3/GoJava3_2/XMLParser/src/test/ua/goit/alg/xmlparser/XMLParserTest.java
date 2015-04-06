package ua.goit.alg.test;

import static org.junit.Assert.*;
import java.io.IOException;
import ua.goit.alg.xmlparser.parser.*;
import org.junit.Test;


public class XMLParserTest {

  @Test
  public void doubleStartTag() throws IOException {
      Parser parser = new MockXMLParser();
      String result = parser.parse("<?xml doctype=\"1\"><start atr1=\"3\" atr2 = \"4\"><?xml doctype=\"1\"><start atr1=\"3\" atr2 = \"4\"><tag>text</tag><tag2/></start>");
      String expectedResult = "<?xml><start><tag>text</tag><tag2></tag2></start>";
      System.out.println(result);
      assertEquals(expectedResult, result);
    
   
  }

}
