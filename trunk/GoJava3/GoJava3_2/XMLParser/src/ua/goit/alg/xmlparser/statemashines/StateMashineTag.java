package ua.goit.alg.xmlparser.statemashines;

import ua.goit.alg.xmlparser.parser.ParserData;
import ua.goit.alg.xmlparser.parser.XMLParser;

public class StateMashineTag {

  private TagState state = TagState.INIT;
  private ParserData parserData = new ParserData();
  private XMLParser xmlParser;

  public StateMashineTag(XMLParser xmlParser) {
    this.xmlParser = xmlParser;
  }

  public void next(char c) {
    state = state.next(c, parserData, xmlParser);
  }
}
