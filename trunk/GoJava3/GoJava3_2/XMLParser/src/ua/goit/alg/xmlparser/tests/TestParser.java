package ua.goit.alg.xmlparser.tests;


import java.io.IOException;
import org.junit.Assert;
import org.junit.Test;
import ua.goit.alg.xmlparser.parser.XMLParser;

public class TestParser {

  @Test
  public void testSimple() throws IOException{
    XMLParser parser = new XMLParser();
    String result = parser.parse("<s><t></t></s>");
    String expectedResult = "<s><t></t></s>";
    Assert.assertEquals(expectedResult, result);
  }

  @Test
  public void testAttr() throws IOException{
    XMLParser parser = new XMLParser();
    String result = parser.parse("<start atr1=3><tag></tag><tag2></tag2></start>");
    String expectedResult = "<start><tag></tag><tag2></tag2></start>";
    Assert.assertEquals(expectedResult, result);
  }

  @Test
  public void testInnterClosingTag() throws IOException{
    XMLParser parser = new XMLParser();
    String result = parser.parse("<start atr1=3><tag></tag><tag2/></start>");
    String expectedResult = "<start><tag></tag><tag2></tag2></start>";
    Assert.assertEquals(expectedResult, result);
  }

  @Test
  public void testText() throws IOException{
    XMLParser parser = new XMLParser();
    String result = parser.parse("<start atr1=3><tag>text</tag><tag2/></start>");
    String expectedResult = "<start><tag>text</tag><tag2></tag2></start>";
    Assert.assertEquals(expectedResult, result);
  }

  @Test
  public void testFull() throws IOException{
    XMLParser parser = new XMLParser();
    String result = parser.parse("<?xml doctype=1><start atr1=3 atr2 = 4><tag>text</tag><tag2/></start>");
    String expectedResult = "<start><tag></tag>text<tag2></tag2></start>";
    Assert.assertEquals(expectedResult, result);
  }

}
  
