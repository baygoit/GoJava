package test.ua.goit.alg.xmlparser;

import ua.goit.alg.xmlparser.parser.Handler;
import ua.goit.alg.xmlparser.parser.ParserData;
import ua.goit.alg.xmlparser.parser.XMLParser;

public abstract class HandlerConstructor {
  
  public static XMLParser initParser(){
    XMLParser parser = new XMLParser.Builder().setOpenTagHandler(new Handler() {
      @Override
      public void handle(ParserData parserData) {
        System.out.println(parserData.getTag());
      }
    }).setCloseTagHandler(new Handler() {
      @Override
      public void handle(ParserData parserData) {
      }
    }).build();
    
    return parser;
 }


}
