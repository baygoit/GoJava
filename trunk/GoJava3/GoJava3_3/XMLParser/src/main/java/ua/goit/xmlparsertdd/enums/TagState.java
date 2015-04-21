package ua.goit.xmlparsertdd.enums;

import ua.goit.xmlparsertdd.utils.CharUtil;
import ua.goit.xmlparsertdd.elements.TagElement;

public enum TagState {
  INIT {
    @Override
    public TagState next(char c, TagElement.Builder builder) {
      TagState result = INVALID_TAG_END;
      if (c == '<') {
        result = OPEN;
      } else if (CharUtil.isEmptyChar(c)) {
        result = INIT;
      }
      return result;
    }
  },
  OPEN {
    @Override
    public TagState next(char c, TagElement.Builder builder) {
      builder.setType(TagElementType.OPEN);
      TagState result = INVALID_TAG_END;
      if (CharUtil.isEmptyChar(c)) {
        result = OPEN;
      } else if (c == '?') {
        result = HEADER;
        builder.setType(TagElementType.HEADER);
      } else if (CharUtil.isNameStartChar(c)) {
        result = TAG_NAME;
        builder.buildName(c);
      } else if (c == '/') {
        result = CLOSE;
        builder.setType(TagElementType.CLOSE);
      } else if (c == '!') {
        result = EXCLAM_MARK;
      }
      return result;
    }
  },
  HEADER {
    @Override
    public TagState next(char c, TagElement.Builder builder) {
      TagState result = INVALID_TAG_END;
      if (CharUtil.isEmptyChar(c)) {
        result = HEADER;
      } else if (CharUtil.isNameStartChar(c)) {
        result = HEADER_NAME;
        builder.buildName(c);
      }
      return result;
    }
  },
  HEADER_NAME {
    @Override
    public TagState next(char c, TagElement.Builder builder) {
      TagState result = INVALID_TAG_END;
      if (CharUtil.isNameChar(c)) {
        result = HEADER_NAME;
        builder.buildName(c);
      } else if (CharUtil.isEmptyChar(c)) {
        result = END_HEADER_NAME;
      }
      return result;
    }
  },
  END_HEADER_NAME {
    @Override
    public TagState next(char c, TagElement.Builder builder) {
      TagState result = INVALID_TAG_END;
      if (CharUtil.isNameStartChar(c)) {
        result = HEADER_PARAM_NAME;
        builder.buildParamName(c);
      } else if (CharUtil.isEmptyChar(c)) {
        result = END_HEADER_NAME;
      } else if (c == '?'){
        result = END_HEADER;
      }
      return result;
    }
  },
  HEADER_PARAM_NAME {
    @Override
    public TagState next(char c, TagElement.Builder builder) {
      TagState result = INVALID_TAG_END;
      if (CharUtil.isNameChar(c)) {
        result = HEADER_PARAM_NAME;
        builder.buildParamName(c);
      } else if (CharUtil.isEmptyChar(c)) {
        result = END_HEADER_PARAM_NAME;
      } else if (c == '=') {
        result = START_HEADER_PARAM_VALUE;
      }
      return result;
    }
  },
  END_HEADER_PARAM_NAME {
    @Override
    public TagState next(char c, TagElement.Builder builder) {
      TagState result = INVALID_TAG_END;
      if (c == '=') {
        result = START_HEADER_PARAM_VALUE;
      } else if (CharUtil.isEmptyChar(c)) {
        result = END_HEADER_PARAM_NAME;
      }
      return result;
    }
  },
  START_HEADER_PARAM_VALUE {
    @Override
    public TagState next(char c, TagElement.Builder builder) {
      TagState result = INVALID_TAG_END;
      if (c == '\'') {
        result = HEADER_PARAM_VALUE_SINGLE_QUOTE;
      } else if (c == '\"') {
        result = HEADER_PARAM_VALUE_DOUBLE_QUOTE;
      } else if (CharUtil.isEmptyChar(c)) {
        result = START_HEADER_PARAM_VALUE;
      }
      return result;
    }
  },
  HEADER_PARAM_VALUE_SINGLE_QUOTE {
    @Override
    public TagState next(char c, TagElement.Builder builder) {
      TagState result = HEADER_PARAM_VALUE_SINGLE_QUOTE;
      if (c == '\'') {
        result = END_HEADER_PARAM_VALUE;
        builder.addParams();
      } else {
        builder.buildParamValue(c);
      }
      return result;
    }
  },
  HEADER_PARAM_VALUE_DOUBLE_QUOTE {
    @Override
    public TagState next(char c, TagElement.Builder builder) {
      TagState result = HEADER_PARAM_VALUE_DOUBLE_QUOTE;
      if (c == '\"') {
        result = END_HEADER_PARAM_VALUE;
        builder.addParams();
      } else {
        builder.buildParamValue(c);
      }
      return result;
    }
  },
  END_HEADER_PARAM_VALUE {
    @Override
    public TagState next(char c, TagElement.Builder builder) {
      TagState result = INVALID_TAG_END;
      if (CharUtil.isEmptyChar(c)) {
        result = END_HEADER_PARAM_VALUE;
      } else if (CharUtil.isNameStartChar(c)) {
        result = HEADER_PARAM_NAME;
        builder.buildParamName(c);
      } else if (c == '?') {
        result = END_HEADER;
      }
      return result;
    }
  },
  END_HEADER {
    @Override
    public TagState next(char c, TagElement.Builder builder) {
      TagState result = INVALID_TAG_END;
      if (CharUtil.isEmptyChar(c)) {
        result = END_HEADER;
      } else if (c == '>') {
        result = VALID_HEADER_END;
      }
      return result;
    }
  },
  VALID_HEADER_END {
    @Override
    public TagState next(char c, TagElement.Builder builder) {
      TagState result = INVALID_TAG_END;
      
      if (c == '<') {
        result = OPEN;
      }else if (CharUtil.isEmptyChar(c)) {
        result = VALID_HEADER_END;
      }
      return result;
    }
  },
  TAG_NAME {
    @Override
    public TagState next(char c, TagElement.Builder builder) {
      TagState result = INVALID_TAG_END;
      if (c == '>') {
        result = VALID_TAG_END;
      } else if (CharUtil.isNameChar(c)) {
        result = TAG_NAME;
        builder.buildName(c);
      } else if(CharUtil.isEmptyChar(c)) {
        result = END_TAG_NAME;
      } else if (c == '/') {
        result = SINGLE;
      }
      return result;
    }
  },
  END_TAG_NAME {
    @Override
    public TagState next(char c, TagElement.Builder builder) {
      TagState result = INVALID_TAG_END;
      if (CharUtil.isNameStartChar(c)) {
        result = PARAM_NAME;
        builder.buildParamName(c);
      } else if (CharUtil.isEmptyChar(c)) {
        result = END_TAG_NAME;
      } else if (c == '>') {
        result = VALID_TAG_END;
      } else if (c == '/') {
        result = SINGLE;
      }
      return result;
    }
  },
  PARAM_NAME {
    @Override
    public TagState next(char c, TagElement.Builder builder) {
      TagState result = INVALID_TAG_END;
      if (CharUtil.isNameChar(c)) {
        result = PARAM_NAME;
        builder.buildParamName(c);
      } else if (CharUtil.isEmptyChar(c)) {
        result = END_PARAM_NAME;
      } else if (c == '=') {
        result = START_PARAM_VALUE;
      }
      return result;
    }
  },
  END_PARAM_NAME {
    @Override
    public TagState next(char c, TagElement.Builder builder) {
      TagState result = INVALID_TAG_END;
      if (c == '=') {
        result = START_PARAM_VALUE;
      } else if (CharUtil.isEmptyChar(c)) {
        result = END_PARAM_NAME;
      }
      return result;
    }
  },
  START_PARAM_VALUE {
    @Override
    public TagState next(char c, TagElement.Builder builder) {
      TagState result = INVALID_TAG_END;
      if (c == '\'') {
        result = PARAM_VALUE_SINGLE_QUOTE;
      } else if (c == '\"') {
        result = PARAM_VALUE_DOUBLE_QUOTE;
      } else if (CharUtil.isEmptyChar(c)) {
        result = START_PARAM_VALUE;
      }
      return result;
    }
  },
  PARAM_VALUE_SINGLE_QUOTE {
    @Override
    public TagState next(char c, TagElement.Builder builder) {
      TagState result = PARAM_VALUE_SINGLE_QUOTE;
      if (c == '\'') {
        result = END_PARAM_VALUE;
        builder.addParams();
      } else {
        builder.buildParamValue(c);
      }
      return result;
    }
  },
  PARAM_VALUE_DOUBLE_QUOTE {
    @Override
    public TagState next(char c, TagElement.Builder builder) {
      TagState result = PARAM_VALUE_DOUBLE_QUOTE;
      if (c == '\"') {
        result = END_PARAM_VALUE;
        builder.addParams();
      } else {
        builder.buildParamValue(c);
      }
      return result;
    }
  },
  END_PARAM_VALUE {
    @Override
    public TagState next(char c, TagElement.Builder builder) {
      TagState result = INVALID_TAG_END;
      if (CharUtil.isEmptyChar(c)) {
        result = END_PARAM_VALUE;
      } else if (CharUtil.isNameStartChar(c)) {
        result = PARAM_NAME;
        builder.buildParamName(c);
      } else if (c == '>') {
        result = VALID_TAG_END;
      } else if (c == '/') {
        result = SINGLE;
      }
      return result;
    }
  },
  SINGLE {
    @Override
    public TagState next(char c, TagElement.Builder builder) {
      builder.setType(TagElementType.SINGLE);
      TagState result = INVALID_TAG_END;
      if (CharUtil.isEmptyChar(c)) {
        result = SINGLE;
      } else if (c == '>') {
        result = VALID_TAG_END;
      }
      return result;
    }
  },
  VALID_TAG_END {
    @Override
    public TagState next(char c, TagElement.Builder builder) {
      TagState result = TEXT_VALUE;
      if (c == '<') {
        result = OPEN;
      }
      return result;
    }
  },
  VALID_COMMENT_END {
    @Override
    public TagState next(char c, TagElement.Builder builder) {
      TagState result = TEXT_VALUE;
      if (c == '<') {
        result = OPEN;
      }
      return result;
    }
  },
  TEXT_VALUE {
    @Override
    public TagState next(char c, TagElement.Builder builder) {
      TagState result = TEXT_VALUE;
      if (c == '<') {
        result = OPEN;
      }
      return result;
    }
  },
  INVALID_TAG_END {
    @Override
    public TagState next(char c, TagElement.Builder builder) {
      return INVALID_TAG_END;
    }
  },
  CLOSE {
    @Override
    public TagState next(char c, TagElement.Builder builder) {
      TagState result = INVALID_TAG_END;
      if (CharUtil.isEmptyChar(c)) {
        result = CLOSE;
      } else if (CharUtil.isNameStartChar(c)) {
        result = CLOSE_NAME;
        builder.buildName(c);
      }
      return result;
    }
  },
  CLOSE_NAME {
    @Override
    public TagState next(char c, TagElement.Builder builder) {
      TagState result = INVALID_TAG_END;
      if (CharUtil.isNameChar(c)) {
        result = CLOSE_NAME;
        builder.buildName(c);
      } else if (CharUtil.isEmptyChar(c)) {
        result = END_CLOSE_NAME;
      } else if (c == '>') {
        result = VALID_TAG_END;
      }
      return result;
    }
  },
  END_CLOSE_NAME {
    @Override
    public TagState next(char c, TagElement.Builder builder) {
      TagState result = INVALID_TAG_END;
      if (CharUtil.isEmptyChar(c)) {
        result = END_CLOSE_NAME;
      } else if (c == '>') {
        result = VALID_TAG_END;
      }
      return result;
    }
  },
  EXCLAM_MARK {
    @Override
    public TagState next(char c, TagElement.Builder builder) {
      TagState result = INVALID_TAG_END;
      if (c == '-') {
        result = HYPHEN_BEFORE;
      }
      return result;
    }
  },
  HYPHEN_BEFORE {
    @Override
    public TagState next(char c, TagElement.Builder builder) {
      TagState result = INVALID_TAG_END;
      if (c == '-') {
        result = COMMENT;
      }
      return result;
    }
  },
  COMMENT {
    @Override
    public TagState next(char c, TagElement.Builder builder) {
      TagState result = COMMENT;
      if (c == '-') {
        result = FIRST_HYPHEN_AFTER;
      }
      return result;
    }
  },
  FIRST_HYPHEN_AFTER {
    @Override
    public TagState next(char c, TagElement.Builder builder) {
      TagState result = COMMENT;
      if (c == '-') {
        result = SECOND_HYPHEN_AFTER;
      }
      return result;
    }
  },
  SECOND_HYPHEN_AFTER {
    @Override
    public TagState next(char c, TagElement.Builder builder) {
      TagState result = COMMENT;
      if (c == '>') {
        result = VALID_COMMENT_END;
      }else if (c == '-') {
        result = SECOND_HYPHEN_AFTER;
      }
      
      return result;
    }
  };

  public abstract TagState next(char c, TagElement.Builder builder);
}
