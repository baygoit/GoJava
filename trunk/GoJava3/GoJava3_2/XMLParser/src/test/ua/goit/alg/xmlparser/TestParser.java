package test.ua.goit.alg.xmlparser;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import java.io.IOException;
import org.junit.Assert;
import org.junit.Test;
import ua.goit.alg.xmlparser.parser.Parser;

public class TestParser {

  @Test
  public void whenCompareInside() throws IOException {
    Parser parser = new MockXMLParser();
    String result = parser.parse("<s><t t=\"<1\"></t></s>");
    String expectedResult = "<s><t></t></s>";
    Assert.assertEquals(expectedResult, result);
  }

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
    try {
      String result = parser.parse("<?xml doctype=\"1\"><start atr1=\"3\" atr2 = \"4\"><?xml doctype=\"1\"><tag>text</tag><tag2/></start>");
      fail();
    } catch (RuntimeException e) {
      String errorMessage = "Invalid format error";
      assertEquals(e.getMessage(), errorMessage);
    } catch (Exception e) {
      fail();
    }
  }

  @Test
  public void whenCloseTag_notEquals_OpenTag() throws IOException {
    Parser parser = new MockXMLParser();
    try {
      String result = parser.parse("<s><t></o></r>");
      fail();
    } catch (RuntimeException e) {
      String errorMessage = "Invalid format error";
      assertEquals(e.getMessage(), errorMessage);
    } catch (Exception e) {
      fail();
    }
  }

  @Test
  public void attributeWithoutValue() throws IOException {
    Parser parser = new MockXMLParser();
    try {
      String result = parser.parse("<start atr1 atr2=\"4\"></start>");
      fail();
    } catch (RuntimeException e) {
      String errorMessage = "Invalid format error";
      assertEquals(e.getMessage(), errorMessage);
    } catch (Exception e) {
      fail();
    }
  }

  @Test
  public void parsingTwoStringsWithOneParser() throws IOException {
    Parser parser = new MockXMLParser();
    String result1 = parser.parse("<?xml doctype=\"1\"?><start atr1=\"3\" atr2 = \"4\"><tag>text</tag><tag2/></start>");
    String expectedResult = "<?xml?><start><tag>text</tag><tag2></tag2></start>";
    Assert.assertEquals(expectedResult, result1);

    String result2 = parser.parse("<?xml doctype=\"1\"?><start atr1=\"3\" atr2 = \"4\"><tag>text</tag><tag2/></start>");
    Assert.assertEquals(expectedResult, result2);
  }

  @Test
  public void invalidCloseTag() throws IOException {
    Parser parser = new MockXMLParser();
    try {
      String result = parser.parse("<s/s>");
      fail();
    } catch (RuntimeException e) {
      String errorMessage = "Invalid format error";
      assertEquals(e.getMessage(), errorMessage);
    } catch (Exception e) {
      fail();
    }
  }

  @Test
  public void invalidTagName() throws IOException {
    Parser parser = new MockXMLParser();
    try {
      String result = parser.parse("<C++></C++>");
      fail();
    } catch (RuntimeException e) {
      String errorMessage = "Invalid format error";
      assertEquals(e.getMessage(), errorMessage);
    } catch (Exception e) {
      fail();
    }
  }

  @Test
  public void tagNameWithInvalidSpace() throws IOException {
    Parser parser = new MockXMLParser();
    try {
      String result = parser.parse("<star t></start>");
      fail();
    } catch (RuntimeException e) {
      String errorMessage = "Invalid format error";
      assertEquals(e.getMessage(), errorMessage);
    } catch (Exception e) {
      fail();
    }
  }

  @Test
  public void atributesAndValues() throws IOException {
    Parser parser = new MockXMLParserForAtribute();
    String result1 = parser.parse("<start atr1=\"3\" atr2 = \"4\"><tag>text</tag><tag2/></start>");
    String expectedResult = "<start atr1=\"3\" atr2=\"4\"><tag><tag2>";
    assertEquals(result1, expectedResult);
  }
}
  
