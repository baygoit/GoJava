package ua.goit.tishenko.xmlparser;

public enum SyntaxState {
  INIT {
    @Override
    SyntaxState next(char nextChar) {
      SyntaxState result = INVALID_END;
      if (CharUtil.isSkipChar(nextChar)) {
        result = INIT;
      } else if (nextChar == '<') {
        result = ANGLE_BRACKET_OPENED;
      }
      return result;

    }
  },

  ANGLE_BRACKET_OPENED {
    @Override
    SyntaxState next(char nextChar) {
      SyntaxState result = INVALID_END;

      if (CharUtil.isSkipChar(nextChar)) {
        result = ANGLE_BRACKET_OPENED;
      } else if (CharUtil.isNameStartChar(nextChar)) {
        result = TAG_NAME;
      } else if (nextChar == '?') {
        result = HEADER_TAG;
      } else if (nextChar == '/') {
        result = CLOSE_TAG;
      } else if (nextChar == '!') {
        result = COMMENT_START;
      }
      return result;
    }
  },

  COMMENT_START {
    @Override
    SyntaxState next(char nextChar) {
      SyntaxState result = INVALID_END;
      if (nextChar == '-') {
        result = OPEN_COMMENT_DASH;
      }
      return result;
    }
  },

  HEADER_TAG {
    @Override
    SyntaxState next(char nextChar) {
      SyntaxState result = INVALID_END;

      if (CharUtil.isSkipChar(nextChar)) {
        result = HEADER_TAG;
      } else if (CharUtil.isNameStartChar(nextChar)) {
        result = HEADER_TAG_NAME;
      }
      return result;
    }
  },

  OPEN_COMMENT_DASH {
    @Override
    SyntaxState next(char nextChar) {
      SyntaxState result = INVALID_END;
      if (nextChar == '-') {
        result = COMMENT_BODY;
      }
      return result;
    }
  },

  COMMENT_BODY {
    @Override
    SyntaxState next(char nextChar) {
      SyntaxState result = INVALID_END;
      if (nextChar == '-') {
        result = CLOSE_COMMENT_DASH;
      } else {
        result = COMMENT_BODY;
      }

      return result;
    }
  },

  CLOSE_COMMENT_DASH {
    @Override
    SyntaxState next(char nextChar) {
      SyntaxState result = INVALID_END;

      if (nextChar == '-') {
        result = COMMENT_END;
      } else {
        result = COMMENT_BODY;
      }
      return result;
    }
  },

  COMMENT_END {
    @Override
    SyntaxState next(char nextChar) {
      SyntaxState result = INVALID_END;

      if (nextChar == '>') {
        result = TEXT_VALUE;
      } else if (nextChar == '-') {
        result = CLOSE_COMMENT_DASH;
      } else { 
        result = COMMENT_BODY;
      }
      return result;
    }
  },

  HEADER_TAG_NAME {
    @Override
    SyntaxState next(char nextChar) {
      SyntaxState result = INVALID_END;
      if (CharUtil.isSkipChar(nextChar)) {
        result = END_HEADER_TAG_NAME;
      } else if (CharUtil.isNameChar(nextChar)) {
        result = HEADER_TAG_NAME;
      }

      return result;
    }
  },

  END_HEADER_TAG_NAME {
    @Override
    SyntaxState next(char nextChar) {
      SyntaxState result = INVALID_END;

      if (CharUtil.isSkipChar(nextChar)) {
        result = END_HEADER_TAG_NAME;
      } else if (CharUtil.isNameStartChar(nextChar)) {
        result = HEADER_PARAM_NAME;
      } else if (nextChar == '?') {
        result = HEADER_TAG_CLOSED;
      }
      return result;

    }
  },

  HEADER_TAG_CLOSED {
    @Override
    SyntaxState next(char nextChar) {

      SyntaxState result = VALID_END;
      if (CharUtil.isSkipChar(nextChar)) {
        result = HEADER_TAG_CLOSED;
      } else if (nextChar == '>') {
        result = ANGLE_BRACKET_CLOSED;
      }
      return result;
    }
  },

  HEADER_PARAM_NAME {
    @Override
    SyntaxState next(char nextChar) {
      SyntaxState result = INVALID_END;

      if (CharUtil.isSkipChar(nextChar)) {
        result = END_HEADER_PARAM_NAME;
      } else if (CharUtil.isNameChar(nextChar)) {
        result = HEADER_PARAM_NAME;
      } else if (nextChar == '=') {
        result = HEADER_PARAM_EQUAL;
      }
      return result;
    }
  },
  PARAM_NAME {
    @Override
    SyntaxState next(char nextChar) {
      SyntaxState result = INVALID_END;

      if (CharUtil.isSkipChar(nextChar)) {
        result = END_PARAM_NAME;
      } else if (CharUtil.isNameChar(nextChar)) {
        result = PARAM_NAME;
      } else if (nextChar == '=') {
        result = PARAM_EQUAL;
      }
      return result;
    }
  },
  END_PARAM_NAME {
    @Override
    SyntaxState next(char nextChar) {

      SyntaxState result = INVALID_END;
      if (CharUtil.isSkipChar(nextChar)) {
        result = END_PARAM_NAME;
      } else if (nextChar == '=') {
        result = PARAM_EQUAL;
      }
      return result;
    }
  },
  END_HEADER_PARAM_NAME {
    @Override
    SyntaxState next(char nextChar) {

      SyntaxState result = INVALID_END;
      if (CharUtil.isSkipChar(nextChar)) {
        result = END_HEADER_PARAM_NAME;
      } else if (nextChar == '=') {
        result = HEADER_PARAM_EQUAL;
      }
      return result;
    }
  },
  PARAM_EQUAL {
    @Override
    SyntaxState next(char nextChar) {

      SyntaxState result = INVALID_END;
      if (CharUtil.isSkipChar(nextChar)) {
        result = PARAM_EQUAL;
      } else if (nextChar == '\'') {
        result = PARAM_SINGLEQUOTE_VALUE;
      } else if (nextChar == '"') {
        result = PARAM_QUOTE_VALUE;
      }
      return result;
    }
  },
  HEADER_PARAM_EQUAL {
    @Override
    SyntaxState next(char nextChar) {
      SyntaxState result = INVALID_END;
      if (CharUtil.isSkipChar(nextChar)) {
        result = HEADER_PARAM_EQUAL;
      } else if (nextChar == '\'') {
        result = HEADER_PARAM_SINGLEQUOTE_VALUE;
      } else if (nextChar == '"') {
        result = HEADER_PARAM_QUOTE_VALUE;
      }
      return result;
    }
  },

  PARAM_SINGLEQUOTE_VALUE {
    @Override
    SyntaxState next(char nextChar) {
      SyntaxState result = INVALID_END;
      if (nextChar == '\'') {
        result = END_PARAM_SINGLEQUOTE_VALUE;
      } else {
        result = PARAM_SINGLEQUOTE_VALUE;
      }
      return result;
    }
  },

  HEADER_PARAM_SINGLEQUOTE_VALUE {
    @Override
    SyntaxState next(char nextChar) {
      SyntaxState result = INVALID_END;
      if (nextChar == '\'') {
        result = END_HEADER_PARAM_SINGLEQUOTE_VALUE;
      } else {
        result = HEADER_PARAM_SINGLEQUOTE_VALUE;
      }
      return result;
    }
  },
  END_PARAM_SINGLEQUOTE_VALUE {
    @Override
    SyntaxState next(char nextChar) {

      SyntaxState result = INVALID_END;
      if (CharUtil.isSkipChar(nextChar)) {
        result = END_PARAM_SINGLEQUOTE_VALUE;
      } else if (CharUtil.isNameStartChar(nextChar)) {
        result = PARAM_NAME;
      } else if (nextChar == '/') {
        result = SINGLE_TAG;
      } else if (nextChar == '>') {
        result = ANGLE_BRACKET_CLOSED;
      }

      return result;
    }
  },

  HEADER_PARAM_QUOTE_VALUE {
    @Override
    SyntaxState next(char nextChar) {
      SyntaxState result = INVALID_END;
      if (nextChar == '\"') {
        result = END_HEADER_PARAM_QUOTE_VALUE;
      } else {
        result = HEADER_PARAM_QUOTE_VALUE;
      }
      return result;
    }

  },

  PARAM_QUOTE_VALUE {
    @Override
    SyntaxState next(char nextChar) {
      SyntaxState result = INVALID_END;
      if (nextChar == '"') {
        result = END_PARAM_QUOTE_VALUE;
      } else {
        result = PARAM_QUOTE_VALUE;
      }
      return result;
    }
  },

  CLOSE_TAG {

    @Override
    SyntaxState next(char nextChar) {
      SyntaxState result = INVALID_END;
      if (CharUtil.isSkipChar(nextChar)) {
        result = CLOSE_TAG;
      } else if (CharUtil.isNameStartChar(nextChar)) {
        result = CLOSE_TAG_NAME;

      }
      return result;
    }
  },
  CLOSE_TAG_NAME {
    @Override
    SyntaxState next(char nextChar) {
      SyntaxState result = INVALID_END;

      if (CharUtil.isSkipChar(nextChar)) {
        result = END_TAG_NAME;
      } else if (nextChar == '>') {
        result = ANGLE_BRACKET_CLOSED;
      } else if (CharUtil.isNameChar(nextChar)) {
        result = CLOSE_TAG_NAME;
      }
      return result;
    }
  },

  TAG_NAME {
    @Override
    SyntaxState next(char nextChar) {
      SyntaxState result = INVALID_END;

      if (CharUtil.isSkipChar(nextChar)) {
        result = END_TAG_NAME;
      } else if (nextChar == '>') {
        result = ANGLE_BRACKET_CLOSED;
      } else if (CharUtil.isNameChar(nextChar)) {
        result = TAG_NAME;
      } else if (nextChar == '/') {
        result = SINGLE_TAG;
      }
      return result;
    }
  },

  END_TAG_NAME {
    @Override
    SyntaxState next(char nextChar) {
      SyntaxState result = INVALID_END;

      if (CharUtil.isSkipChar(nextChar)) {
        result = END_TAG_NAME;
      } else if (nextChar == '>') {
        result = ANGLE_BRACKET_CLOSED;
      } else if (nextChar == '/') {
        result = SINGLE_TAG;
      } else if (CharUtil.isNameStartChar(nextChar)) {
        result = PARAM_NAME;
      }

      return result;
    }

  },

  SINGLE_TAG {
    @Override
    SyntaxState next(char nextChar) {
      SyntaxState result = INVALID_END;

      if (CharUtil.isSkipChar(nextChar)) {
        result = SINGLE_TAG;
      } else if (nextChar == '>') {
        result = ANGLE_BRACKET_CLOSED;
      }
      return result;
    }

  },
  ANGLE_BRACKET_CLOSED {
    @Override
    SyntaxState next(char nextChar) {
      SyntaxState result = INVALID_END;

      if (CharUtil.isSkipChar(nextChar)) {
        result = ANGLE_BRACKET_CLOSED;
      } else if (nextChar == '<') {
        result = ANGLE_BRACKET_OPENED;
      } else {
        result = TEXT_VALUE;
      }

      return result;
    }
  },
  TEXT_VALUE {
    @Override
    SyntaxState next(char nextChar) {
      SyntaxState result = INVALID_END;
      if (nextChar == '<') {
        result = ANGLE_BRACKET_OPENED;
      } else {
        result = TEXT_VALUE;
      }

      return result;
    }
  },
  INVALID_END {
    @Override
    SyntaxState next(char nextChar) {
      throw new IllegalArgumentException("nextChar " + nextChar
          + " not allowed");
    }
  },
  VALID_END {
    @Override
    public SyntaxState next(char nextChar) {
      return VALID_END;
    }
  },
  END_HEADER_PARAM_SINGLEQUOTE_VALUE {
    @Override
    SyntaxState next(char nextChar) {
      SyntaxState result = INVALID_END;
      if (CharUtil.isSkipChar(nextChar)) {
        result = END_HEADER_TAG_NAME;
      } else if (CharUtil.isNameStartChar(nextChar)) {
        result = HEADER_PARAM_NAME;
      } else if (nextChar == '?') {
        result = HEADER_TAG_CLOSED;
      }
      return result;
    }
  },
  END_HEADER_PARAM_QUOTE_VALUE {
    @Override
    SyntaxState next(char nextChar) {
      SyntaxState result = INVALID_END;
      if (CharUtil.isSkipChar(nextChar)) {
        result = END_HEADER_PARAM_QUOTE_VALUE;
      } else if (CharUtil.isNameStartChar(nextChar)) {
        result = HEADER_PARAM_NAME;
      } else if (nextChar == '?') {
        result = HEADER_TAG_CLOSED;
      } 
      return result;
    }
  }, END_PARAM_QUOTE_VALUE {
    @Override
    SyntaxState next(char nextChar) {
      SyntaxState result = INVALID_END;

      if (CharUtil.isSkipChar(nextChar)) {
        result = END_TAG_NAME;
      } else if (nextChar == '>') {
        result = ANGLE_BRACKET_CLOSED;
      } else if (nextChar == '/') {
        result = SINGLE_TAG;
      } else if (CharUtil.isNameStartChar(nextChar)) {
        result = PARAM_NAME;
      }
      return result;
    }
  };
  abstract SyntaxState next(char nextChar);

}
