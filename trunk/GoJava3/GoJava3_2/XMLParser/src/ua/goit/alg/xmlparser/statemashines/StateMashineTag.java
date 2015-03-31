package ua.goit.alg.xmlparser.statemashines;

import ua.goit.alg.xmlparser.parser.AtributData;
import ua.goit.alg.xmlparser.parser.ParserData;
import ua.goit.alg.xmlparser.parser.XMLParser;

public class StateMashineTag {

  private TagStates state = TagStates.INIT;
  
  private ParserData parserData = new ParserData();
  
  XMLParser xmlParser;

  public StateMashineTag(XMLParser xmlParser) {
    this.xmlParser = xmlParser;
  }

  public void next(char c) {
    state = state.next(c, parserData,xmlParser);
  }

  public void getResult() {
    
    xmlParser.update(parserData);
    
  }
}
