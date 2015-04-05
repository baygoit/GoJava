package test.ua.goit.alg.xmlparser;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import ua.goit.alg.xmlparser.parser.Handler;
import ua.goit.alg.xmlparser.parser.ParserData;
import ua.goit.alg.xmlparser.parser.XMLParser;
import ua.goit.alg.xmlparser.parser.Parser;

public class MockXMLParser implements Parser{
  
   private StringBuilder result = new StringBuilder("");

   XMLParser parser = new XMLParser.Builder().setOpenTagHandler(new Handler() {
      @Override
      public void handle(ParserData parserData) {
        result.append("<").append(parserData.getTag()).append(">");
      }
    }).setCloseTagHandler(new Handler() {
      @Override
      public void handle(ParserData parserData) {
        result.append("</").append(parserData.getTag()).append(">");
      }
    }).setTextValueHandler(new Handler(){
      @Override
      public void handle(ParserData parserData) {
        result.append("").append(parserData.getText()).append("");
     }
    }).setStartHandler(new Handler(){
      @Override
      public void handle(ParserData parserData) {
        result.append("<").append(parserData.getTag()).append(">");
     }
    }).setEndHandler(new Handler(){
      @Override
      public void handle(ParserData parserData) {
        result.append("").append(parserData.getText()).append("");
     }
    }).setErrHandler(new Handler(){
      @Override
      public void handle(ParserData parserData) {
        result.append("").append(parserData.getText()).append("");
     }
      
    }).build();

    @Override
    public String parse(String string) throws IOException {
      parser.parse(string);
      return result.toString();
    }

    @Override
    public String parse(File file) throws IOException {
      parser.parse(file);
      return result.toString();
    }

  @Override
  public String parse(InputStream inputStream) throws IOException {
    parser.parse(inputStream);
    return result.toString();
  }

}
