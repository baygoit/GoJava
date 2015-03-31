package ua.goit.alg.xmlparser.statemashines;

import ua.goit.alg.xmlparser.parser.Handler;
import ua.goit.alg.xmlparser.parser.ParserData;
import ua.goit.alg.xmlparser.parser.XMLParser;

public enum TagStates {
  INIT {
    @Override
    public TagStates next(char c, ParserData parserData, XMLParser xmlParser) {
      TagStates result = INVALID;
      if (c == ' ') {
        result = INIT;
      }
      if (c == '<') {
        result = OPENTAG;
      }
      return result;
    }
  },
  OPENTAG{
    @Override
    public TagStates next(char c, ParserData parserData, XMLParser xmlParser) {
      TagStates result = INVALID;
      if (c == '?') {
        result = START;
      }
      if (c == '/') {
        result = CLOSETAG;
      } else {
        parserData.setTag(parserData.getTag() + c);
        result = ELEMENT;
      }
      return result;
    }
  },
  CLOSETAG{
    @Override
    public TagStates next(char c, ParserData parserData, XMLParser xmlParser) {
      TagStates result = CLOSETAG;
      if (c == '>') {
        xmlParser.onCloseTag(parserData);
        result = INIT;
      } else {
        parserData.setTag(parserData.getTag() + c);
      }
      return result;
    }
  },
  START {
    @Override
    public TagStates next(char c, ParserData parserData, XMLParser xmlParser) {
      TagStates result = INVALID;
      if (c == '?') {
        result = INIT;
      }
      if (c == '<') {
        result = START;
      }
      return result;
    }
  },
  ELEMENT {
    @Override
    public TagStates next(char c, ParserData parserData, XMLParser xmlParser) {
      TagStates result = INVALID;
      if (c == ' ') {
        result = ATTRIBUTE;
      } else if (c == '>'){
        xmlParser.onOpenTag(parserData);
        result = NODE;
      } else if (c == '/'){
        xmlParser.onOpenTag(parserData);
        String tag = parserData.getTag();
        parserData = new ParserData();
        parserData.setTag(tag);
        result = CLOSETAG;
      } else {
        result = ELEMENT;
        parserData.setTag(parserData.getTag() + c);
      }
      return result;
    }
  },
  ATTRIBUTE {
    @Override
    public TagStates next(char c, ParserData parserData, XMLParser xmlParser) {
      TagStates result = INVALID;
      if (c == ' ') {
        result = ATTRIBUTE;
      } else if (c == '/') {
        xmlParser.onOpenTag(parserData);
        String tag = parserData.getTag();
        parserData = new ParserData();
        parserData.setTag(tag);
        result = CLOSETAG;
      }
      return result;
    }
  },
  NODE {
    @Override
    public TagStates next(char c, ParserData parserData, XMLParser xmlParser) {
      TagStates result = INVALID;
      if (c == '<') {
        result = OPENTAG;
      } else {
        parserData.setText(parserData.getText() + c);
      }
      return result;
    }
  },
  INVALID {
    @Override
    public TagStates next(char c, ParserData parserData, XMLParser xmlParser) {
      TagStates result = INVALID;
      return result;
    }
  };

  public abstract TagStates next(char c,  ParserData parserData, XMLParser xmlParser);
}
