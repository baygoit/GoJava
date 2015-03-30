package ua.goit.alg.xmlparser.statemashines;

import ua.goit.alg.xmlparser.parser.AtributData;
import ua.goit.alg.xmlparser.parser.ParserData;

public class StateMashineAtribut {

  public StateMashineAtribut(ParserData parserData) {
    this.parserData = parserData;
  }

  private AtributStates state = AtributStates.INIT;
  private AtributData data = new AtributData();
  
  private ParserData parserData;

  public void next(char c) {
    state = state.next(c, data);
  }

  public void getResult() {
    
    if (state == AtributStates.VALID) {
      parserData.addAttribute(data.getKey(), data.getValue());
    }
  }
}
