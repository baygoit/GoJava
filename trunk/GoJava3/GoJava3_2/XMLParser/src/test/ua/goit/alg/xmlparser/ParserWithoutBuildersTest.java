package test.ua.goit.alg.xmlparser;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import ua.goit.alg.xmlparser.parser.Handler;
import ua.goit.alg.xmlparser.parser.ParserData;
import ua.goit.alg.xmlparser.parser.XMLParser;

public class ParserWithoutBuildersTest {
  @Test
  public void openTagHandlerTest() throws IOException {
    final StringBuilder result = new StringBuilder();
    XMLParser parser = new XMLParser.Builder().setOpenTagHandler(new Handler() {
      @Override
      public void handle(ParserData parserData) {
        result.append("<").append(parserData.getTag()).append(">");
      }
    }).build();
    
    parser.parse("<s><t t=\"<1\"></t></s>");
    String expectedResult = "<s><t>";
    assertEquals(expectedResult, result.toString());
  }
  
  @Test
  public void closeTagHandlerTest() throws IOException {
    final StringBuilder result = new StringBuilder();
    XMLParser parser = new XMLParser.Builder().setCloseTagHandler(new Handler() {
      @Override
      public void handle(ParserData parserData) {
        result.append("</").append(parserData.getTag()).append(">");
      }
    }).build();
    
    parser.parse("<s><t t=\"<1\"></t></s>");
    String expectedResult = "</t></s>";
    assertEquals(expectedResult, result.toString());
  }
  
    @Test
    public void textValueHandlerTest() throws IOException {
      final StringBuilder result = new StringBuilder();
      XMLParser parser = new XMLParser.Builder().setTextValueHandler(new Handler() {
        @Override
        public void handle(ParserData parserData) {
          result.append("").append(parserData.getText()).append(" ");
        }
      }).build();
      
      parser.parse("<start atr1=\"3\"><tag>text1</tag><tag2>text</tag2></start>");
      String expectedResult = "text1 text ";
      assertEquals(expectedResult, result.toString());
  }
    
    
    @Test
    public void startHandlerTest() throws IOException {
      final StringBuilder result = new StringBuilder();
      XMLParser parser = new XMLParser.Builder().setStartHandler(new Handler() {
        @Override
        public void handle(ParserData parserData) {
          result.append("<?").append(parserData.getTag()).append("?>");
        }
      }).build();
      
      parser.parse("<?xml doctype=\"1\"?><start atr1=\"3\"><tag></tag><tag2></tag2></start>");
      String expectedResult = "<?xml?>";
      assertEquals(expectedResult, result.toString());
  }
  
    
    @Test
    public void endHandlerTest() throws IOException {
      
      final StringBuilder result = new StringBuilder();
      XMLParser parser = new XMLParser.Builder().setEndHandler(new Handler() {
        @Override
        public void handle(ParserData parserData) {
          result.append("").append(parserData.getText()).append("");
        }
      }).build();
      
      parser.parse("<start atr1=\"3\"><tag></tag><tag2></tag2></start>");
      String expectedResult = "";
      assertEquals(expectedResult, result.toString());
  }
    
    
    @Test
    public void errHandlerTest() throws IOException {
      final StringBuilder result = new StringBuilder();
      XMLParser parser = new XMLParser.Builder().setErrHandler(new Handler() {
        @Override
        public void handle(ParserData parserData) {
          result.append("").append(parserData.getText()).append("");
        }
      }).build();
      parser.parse("<start 3atr1=\"3\"><tag></tag><tag2></tag2></start>");
      String expectedResult = "";
      assertEquals(expectedResult, result.toString());
  }
}
