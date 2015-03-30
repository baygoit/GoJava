package ua.goit.alg.xmlparser.statemashines;

import ua.goit.alg.xmlparser.parser.AtributData;

public enum AtributStates {
  INIT {
    @Override
    public AtributStates next(char c, AtributData atributData) {
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
    public AtributStates next(char c, AtributData atributData) {
      AtributStates result = INVALID;
      if (c == '=' || c == ' ') {
        result = EQUAL;
      } else {
        atributData.setKey(atributData.getKey() + c);
      }
      return result;
    }
  },
  EQUAL {
    @Override
    public AtributStates next(char c, AtributData atributData) {
      AtributStates result = INVALID;
      if (c == ' ') {
        result = EQUAL;
      } else if (c == '=') {
        result = VALUE;
      }
      return result;
    }
  },
  VALUE {
    @Override
    public AtributStates next(char c, AtributData atributData) {
      AtributStates result = VALUE;
      if (c == '>') {
        result = VALID;
      } else {
        atributData.setValue(atributData.getValue() + c);
      }
      return result;
    }
  },
  VALID {
    @Override
    public AtributStates next(char c, AtributData atributData) {
      AtributStates result = VALID;
      return result;
    }
  },
  INVALID {
    @Override
    public AtributStates next(char c, AtributData atributData) {
      AtributStates result = INVALID;
      return result;
    }
  };

  public abstract AtributStates next(char c,  AtributData atributData);
}
