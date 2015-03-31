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
        result = ATTRIBUTE_NAME;
      } else if (c == '>'){
        xmlParser.onOpenTag(parserData);
        result = NODE;
      } else if (c == '/'){
        String tag = parserData.getTag();
        parserData = new ParserData();
        parserData.setTag(tag);
        xmlParser.onOpenTag(parserData);
        result = CLOSETAG;
      } else {
        result = ELEMENT;
        parserData.setTag(parserData.getTag() + c);
      }
      return result;
    }
  },
  ATTRIBUTE_NAME {
    @Override
    public TagStates next(char c, ParserData parserData, XMLParser xmlParser) {
      TagStates result;
      if (c == ' ') {
        result = ATTRIBUTE_NAME;
      } else if (c == '>') {
        xmlParser.onOpenTag(parserData);
        result = NODE;
      } else if (c == '/') {
        xmlParser.onOpenTag(parserData);
        String tag = parserData.getTag();
        parserData = new ParserData();
        parserData.setTag(tag);
        result = CLOSETAG;
      } else if (c == '=') {
        result = ATTRIBUTE_VALUE;
      } else {
        result = ATTRIBUTE_NAME;
        parserData.setAttributeName(parserData.getAttributeName() + c);
      }
      return result;
    }
  },
  ATTRIBUTE_VALUE {
    @Override
    public TagStates next(char c, ParserData parserData, XMLParser xmlParser) {
      TagStates result;
      if (c == ' ') {
        result = ATTRIBUTE_VALUE;
      } else if (c == '>') {
        parserData.addAttribute(parserData.getAttributeName(), parserData.getAttributeValue());
        xmlParser.onOpenTag(parserData);
        result = NODE;
      } else if (c == '/') {
        parserData.addAttribute(parserData.getAttributeName(), parserData.getAttributeValue());
        xmlParser.onOpenTag(parserData);
        String tag = parserData.getTag();
        parserData = new ParserData();
        parserData.setTag(tag);
        result = CLOSETAG;
      }
      else {
        result = ATTRIBUTE_VALUE;
        parserData.setAttributeValue(parserData.getAttributeValue() + c);
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
