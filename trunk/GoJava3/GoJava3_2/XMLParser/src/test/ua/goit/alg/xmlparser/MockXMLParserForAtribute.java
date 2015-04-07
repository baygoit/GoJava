package test.ua.goit.alg.xmlparser;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import ua.goit.alg.xmlparser.parser.Handler;
import ua.goit.alg.xmlparser.parser.ParserData;
import ua.goit.alg.xmlparser.parser.XMLParser;
import ua.goit.alg.xmlparser.parser.Parser;

public class MockXMLParserForAtribute implements Parser{
  
   private StringBuilder result = new StringBuilder("");
   
   XMLParser parser = new XMLParser.Builder().setOpenTagHandler(new Handler() {
      @Override
      public void handle(ParserData parserData) {
        result.append("<" + parserData.getTag());
        Map<String, String> attributes = parserData.getAttributes();
        if (!attributes.isEmpty()){
          for (Map.Entry pair:attributes.entrySet()) {
            result.append(" " + pair.getKey() + "=" + pair.getValue());
          }
        }
        result.append(">");
      }
    }).build();

    @Override
    public String parse(String string) throws IOException {
      result.setLength(0);
      parser.parse(string);
      return result.toString();
    }

    @Override
    public String parse(File file) throws IOException {
      result.setLength(0);
      parser.parse(file);
      return result.toString();
    }

  @Override
  public String parse(InputStream inputStream) throws IOException {
    result.setLength(0);
    parser.parse(inputStream);
    return result.toString();
  }

}
