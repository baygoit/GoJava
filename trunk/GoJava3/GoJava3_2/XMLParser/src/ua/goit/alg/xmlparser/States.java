package ua.goit.alg.xmlparser;

import ua.goit.alg.xmlparser.ParserData;

public enum States {
  INIT {
    @Override
    public States next(char c, ParserData parserData) {
      States result = INVALID;
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
    public States next(char c, ParserData parserData) {
      States result = INVALID;
      if (c == '?') {
        result = START;
      }
      if (c == '<') {
        result = START;
      }
      return result;
    }
  },
  START {
    @Override
    public States next(char c, ParserData parserData) {
      States result = INVALID;
      if (c == '?') {
        result = INIT;
      }
      if (c == '<') {
        result = START;
      }
      return result;
    }
  },
  INVALID {
    @Override
    public States next(char c, ParserData parserData) {
      States result = INVALID;
      return result;
    }
  };

  public abstract States next(char c,  ParserData parserData);
}
