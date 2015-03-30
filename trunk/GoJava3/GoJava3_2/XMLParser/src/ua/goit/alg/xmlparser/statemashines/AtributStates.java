package ua.goit.alg.xmlparser.statemashines;

import ua.goit.alg.xmlparser.parser.ParserData;

public enum AtributStates {
  INIT {
    @Override
    public AtributStates next(char c, ParserData parserData) {
      AtributStates result = INVALID;
      if (c == ' ') {
        result = INIT;
      }
      if (c != '=') {
        result = KEY;
      }
      return result;
    }
  },
  KEY{
    @Override
    public AtributStates next(char c, ParserData parserData) {
      AtributStates result = KEY;
      if (c == '=') {
        result = VALUE;
      }
      return result;
    }
  },
  EQUAL {
    @Override
    public AtributStates next(char c, ParserData parserData) {
      AtributStates result = VALUE;
      return result;
    }
  },
  VALUE {
    @Override
    public AtributStates next(char c, ParserData parserData) {
      AtributStates result = VALUE;
      if (c == '>') {
        result = VALID;
      }
      return result;
    }
  },
  VALID {
    @Override
    public AtributStates next(char c, ParserData parserData) {
      AtributStates result = VALID;
      return result;
    }
  },
  INVALID {
    @Override
    public AtributStates next(char c, ParserData parserData) {
      AtributStates result = INVALID;
      return result;
    }
  };

  public abstract AtributStates next(char c,  ParserData parserData);
}
