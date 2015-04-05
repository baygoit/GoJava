package ua.goit.alg.xmlparser.statemashines;

import ua.goit.alg.xmlparser.parser.ParserData;
import ua.goit.alg.xmlparser.parser.XMLParser;

public enum TagState {
  INIT {
    @Override
    public TagState next(char c, ParserData parserData, XMLParser xmlParser) {
      TagState result = INVALID;
      if (c == ' ') {
        result = INIT;
      } else if (c == '<') {
        result = OPENTAG;
      }
      return result;
    }
  },
  OPENTAG{
    @Override
    public TagState next(char c, ParserData parserData, XMLParser xmlParser) {
      TagState result;
      if (c == '?') {
        result = START;
      } else if (c == '/') {
        result = CLOSETAG;
      } else {
        result = TAG_NAME;
        parserData.appendTag(c);
      }
      return result;
    }
  },
  CLOSETAG{
    @Override
    public TagState next(char c, ParserData parserData, XMLParser xmlParser) {
      TagState result = CLOSETAG;
      if (c == '>') {
        xmlParser.onCloseTag(parserData);
        result = INIT;
      } else {
        parserData.appendTag(c);
      }
      return result;
    }
  },
  START {
    @Override
    public TagState next(char c, ParserData parserData, XMLParser xmlParser) {
                              // mistake - to be corrected!!!
      TagState result = INVALID;
      if (Character.isLetter(c)) {
        parserData.appendTag(c);
        result = TAG_NAME;
      }
      return result;
    }
  },
  TAG_NAME {
    @Override
    public TagState next(char c, ParserData parserData, XMLParser xmlParser) {
      TagState result = INVALID;
      if (c == ' ') {
        result = ATTRIBUTE_NAME;
      } else if (c == '>' || c == '/') {
        result = handleClosingTags(c, parserData, xmlParser, result);
      } else {
        result = TAG_NAME;
        parserData.appendTag(c);
      }
      return result;
    }
  },
  ATTRIBUTE_NAME {
    @Override
    public TagState next(char c, ParserData parserData, XMLParser xmlParser) {
      TagState result = INVALID;
      if (c == ' ') {
        result = ATTRIBUTE_NAME;
      } else if (c == '=') {
        if (parserData.getAttributeName().isEmpty()) {
          result = INVALID;
        } else {
          result = ATTRIBUTE_VALUE;
        }
      } else if (c == '>' || c == '/') {
        result = handleClosingTags(c, parserData, xmlParser, result);
      } else {
        result = ATTRIBUTE_NAME;
        parserData.appendAttributeName(c);
      }
      return result;
    }
  },
  ATTRIBUTE_VALUE {
    @Override
    public TagState next(char c, ParserData parserData, XMLParser xmlParser) {
      TagState result = ATTRIBUTE_VALUE;
      if (c == '\"') {
        parserData.appendAttributeValue(c);
        result = VALUE_STARTED;
      } else if (c == '>' || c == '/') {
        result = handleClosingTags(c, parserData, xmlParser, result);
      } else {
        parserData.appendAttributeValue(c);
      }
      return result;
    }
  },
  VALUE_STARTED {
    @Override
    public TagState next(char c, ParserData parserData, XMLParser xmlParser) {
      TagState result = VALUE_STARTED;
      parserData.appendAttributeValue(c);
      if (c == '\"') {
        result = VALUE_END;
      }
      return result;
    }
  },
  VALUE_END {
    @Override
    public TagState next(char c, ParserData parserData, XMLParser xmlParser) {
      TagState result = INVALID;
      if (c == ' ') {
        result = ATTRIBUTE_VALUE;
      } else if (c == '>' || c == '/') {
        result = handleClosingTags(c, parserData, xmlParser, result);
      }
      return result;
    }
  },
  TEXT {
    @Override
    public TagState next(char c, ParserData parserData, XMLParser xmlParser) {
      TagState result;
      if (c == '<') {
        result = OPENTAG;
        xmlParser.onTextValue(parserData);
      } else {
        parserData.appendText(c);
        result = TEXT;
      }
      return result;
    }
  },
  INVALID {
    @Override
    public TagState next(char c, ParserData parserData, XMLParser xmlParser) {
      xmlParser.onError(parserData);
      return INVALID;
    }
  };

  public abstract TagState next(char c, ParserData parserData, XMLParser xmlParser);

  private static TagState handleClosingTags(char c, ParserData parserData, XMLParser xmlParser, TagState result) {
    if (result == ATTRIBUTE_VALUE) {
      parserData.addAttribute(parserData.getAttributeName(), parserData.getAttributeValue());
    }
    if (c == '>') {
      xmlParser.onOpenTag(parserData);
      result = TEXT;
    } else if (c == '/') {
      String tag = parserData.getTag();
      xmlParser.onOpenTag(parserData);
      parserData.clear();
      parserData.setTag(tag);
      result = CLOSETAG;
    }
    return result;
  }
}
