package test.ua.goit.alg.xmlparser;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import org.junit.Assert;
import org.junit.Test;
import ua.goit.alg.xmlparser.parser.Parser;

public class TestParser {

  @Test
  public void when2Open2Close() throws IOException {
    Parser parser = new MockXMLParser();
    String result = parser.parse("<s><t></t></s>");
    String expectedResult = "<s><t></t></s>";
    Assert.assertEquals(expectedResult, result);
  }

  @Test
  public void whenAttr() throws IOException {
    Parser parser = new MockXMLParser();
    String result = parser.parse("<start atr1=\"3\"><tag></tag><tag2></tag2></start>");
    String expectedResult = "<start><tag></tag><tag2></tag2></start>";
    Assert.assertEquals(expectedResult, result);
  }

  @Test
  public void whenClosableTag() throws IOException {
    Parser parser = new MockXMLParser();
    String result = parser.parse("<start atr1=\"3\"><tag></tag><tag2/></start>");
    String expectedResult = "<start><tag></tag><tag2></tag2></start>";
    Assert.assertEquals(expectedResult, result);
  }

  @Test
  public void whenText() throws IOException {
    Parser parser = new MockXMLParser();
    String result = parser.parse("<start atr1=\"3\"><tag>text</tag><tag2/></start>");
    String expectedResult = "<start><tag>text</tag><tag2></tag2></start>";
    Assert.assertEquals(expectedResult, result);
  }

  @Test
  public void whenFull() throws IOException {
    Parser parser = new MockXMLParser();
    String result = parser.parse("<?xml doctype=\"1\"?><start atr1=\"3\" atr2 = \"4\"><tag>text</tag><tag2/></start>");
    String expectedResult = "<?xml?><start><tag>text</tag><tag2></tag2></start>";
    Assert.assertEquals(expectedResult, result);
  }

  @Test
  public void whenDoubleStartTag() throws IOException {
      Parser parser = new MockXMLParser();
      String result = parser.parse("<?xml doctype=\"1\"><start atr1=\"3\" atr2 = \"4\"><?xml doctype=\"1\"><start atr1=\"3\" atr2 = \"4\"><tag>text</tag><tag2/></start>");
      String expectedResult = "<?xml?><start>";
      assertEquals(expectedResult, result);
  }

}
  
