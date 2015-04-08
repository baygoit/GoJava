

public enum XMLState {
  INIT {
    @Override
      public XMLState next(char symb, XMLTagListener xmlListener){
      XMLState result = INVALID_END;
      if (CharUtil.isEmptyChar(symb)) {
        result = INIT;
      } else if (symb == '<') {
        result = ANGLE_BRACKET_OPENED;
      }
      return result;
    }
  },

  ANGLE_BRACKET_OPENED {
    @Override
      public XMLState next(char symb, XMLTagListener xmlListener){
      XMLState result = INVALID_END;

      if (CharUtil.isEmptyChar(symb)) {
        result = ANGLE_BRACKET_OPENED;
      } else if (CharUtil.isNameStartChar(symb)) {
        TagBuilder.addCharToCurrent(symb);
        TagBuilder.setTagType(TagType.OPEN);
        result = TAG_NAME;
      } else if (symb == '?') {
        result = HEADER_TAG;
      } else if (symb == '/') {
        TagBuilder.setTagType(TagType.CLOSE);
        result = CLOSE_TAG;
      }else if (symb == '!') {
        result = COMMENT_START;
      }
      return result;
    }
  },
 
  
  COMMENT_START {
    @Override
      public XMLState next(char symb, XMLTagListener xmlListener){
      XMLState result = INVALID_END;

      if (symb == '-') {
        result = OPEN_COMMENT_DASH;
      }

      return result;
    }
  },

  HEADER_TAG {
    @Override
      public XMLState next(char symb, XMLTagListener xmlListener){
      XMLState result = INVALID_END;

      if (CharUtil.isEmptyChar(symb)) {
        result = HEADER_TAG;
      } else if (CharUtil.isNameStartChar(symb)) {
        TagBuilder.addCharToCurrent(symb);
        TagBuilder.setTagType(TagType.HEADER);
        result = HEADER_TAG_NAME;
      } 

      return result;
    }
  },

  OPEN_COMMENT_DASH {
    @Override
      public XMLState next(char symb, XMLTagListener xmlListener){
      XMLState result = INVALID_END;

      if (symb == '-') {
        result = COMMENT_BODY;
      }

      return result;
    }
  },

 
  COMMENT_BODY {
    @Override
      public XMLState next(char symb, XMLTagListener xmlListener){
      XMLState result = INVALID_END;

      TagBuilder.addCharToCurrentComment(symb);

      if (symb == '-') {
        result = CLOSE_COMMENT_DASH;
      } else {
        result = COMMENT_BODY;
      }

      return result;
    }
  },
 
  CLOSE_COMMENT_DASH {
    @Override
      public XMLState next(char symb, XMLTagListener xmlListener){
      XMLState result = INVALID_END;
      
      TagBuilder.addCharToCurrentComment(symb);
      if (symb == '-') {
        result = COMMENT_END;
      } else {
        result = COMMENT_BODY;
      }
      return result;
    }
  },

  COMMENT_END {
    @Override
    public XMLState next(char symb, XMLTagListener xmlListener){
      XMLState result = INVALID_END;

      if (symb == '>') {
        Tag tag = TagBuilder.makeCommentTag();
        xmlListener.newTag(tag);
        TagBuilder.setTagType(TagType.TEXT_VALUE);
        result = TEXT_VALUE;
      } else  if (symb == '-') {
        TagBuilder.addCharToCurrentComment(symb);
        result = CLOSE_COMMENT_DASH;
      }else {
        TagBuilder.addCharToCurrentComment(symb);
        result = COMMENT_BODY;
      }
      return result;
    }
  },

  HEADER_TAG_NAME {
    @Override
    public XMLState next(char symb, XMLTagListener xmlListener){
      XMLState result = INVALID_END;
      if (CharUtil.isEmptyChar(symb)) {
        TagBuilder.makeName();
        result = END_HEADER_TAG_NAME;
      } else if (CharUtil.isNameChar(symb)) {
        TagBuilder.addCharToCurrent(symb);
        result = HEADER_TAG_NAME;
      }

      return result;
    }
  },

  END_HEADER_TAG_NAME {
    @Override
    public XMLState next(char symb, XMLTagListener xmlListener){
      XMLState result = INVALID_END;

      if (CharUtil.isEmptyChar(symb)) {
        result = END_HEADER_TAG_NAME;
      } else if (CharUtil.isNameStartChar(symb)) {
        TagBuilder.addCharToCurrent(symb);
        result = HEADER_PARAM_NAME;
      } else if (symb == '?') {
        result = HEADER_TAG_CLOSED;
      }
      return result;

    }
  },

  HEADER_TAG_CLOSED {
    @Override
    public XMLState next(char symb, XMLTagListener xmlListener){

      XMLState result = VALID_END;
      if (CharUtil.isEmptyChar(symb)) {
        result = HEADER_TAG_CLOSED;
      } else if (symb == '>') {
        Tag tag = TagBuilder.makeTag();
        xmlListener.newTag(tag);
        
        result = ANGLE_BRACKET_CLOSED;
      }
      return result;
    }
  },

  HEADER_PARAM_NAME {
    @Override
      public XMLState next(char symb, XMLTagListener xmlListener){
      XMLState result = INVALID_END;

      if (CharUtil.isEmptyChar(symb)) {
        TagBuilder.makeParamName();
        result = END_HEADER_PARAM_NAME;
      } else if (CharUtil.isNameChar(symb)) {
        TagBuilder.addCharToCurrent(symb);
        result = HEADER_PARAM_NAME;
      } else if (symb == '=') {
        TagBuilder.makeParamName();
        result = HEADER_PARAM_EQUAL;
      }
      return result;
    }
  },
  PARAM_NAME {
    @Override
      public XMLState next(char symb, XMLTagListener xmlListener){
      XMLState result = INVALID_END;

      if (CharUtil.isEmptyChar(symb)) {
        TagBuilder.makeParamName();
        result = END_PARAM_NAME;
      } else if (CharUtil.isNameChar(symb)) {
        TagBuilder.addCharToCurrent(symb);
        result = PARAM_NAME;
      } else if (symb == '=') {
        TagBuilder.makeParamName();
        result = PARAM_EQUAL;
      }
      return result;
    }
  },
  END_PARAM_NAME {
    @Override
      public XMLState next(char symb, XMLTagListener xmlListener){

      XMLState result = INVALID_END;
      if (CharUtil.isEmptyChar(symb)) {
        result = END_PARAM_NAME;
      } else if (symb == '=') {
        result = PARAM_EQUAL;
      }
      return result;
    }
  },
  END_HEADER_PARAM_NAME {
    @Override
      public XMLState next(char symb, XMLTagListener xmlListener){

      XMLState result = INVALID_END;
      if (CharUtil.isEmptyChar(symb)) {
        result = END_HEADER_PARAM_NAME;
      } else if (symb == '=') {
        result = HEADER_PARAM_EQUAL;
      }
      return result;
    }
  },
  PARAM_EQUAL {
    @Override
      public XMLState next(char symb, XMLTagListener xmlListener){

      XMLState result = INVALID_END;
      if (CharUtil.isEmptyChar(symb)) {
        result = PARAM_EQUAL;
      } else if (symb == '\'') {
        result = PARAM_SINGLEQUOTE_VALUE_START;
      } else if (symb == '"') {
        result = PARAM_QUOTE_VALUE_START;
      }
      return result;
    }
  },
  HEADER_PARAM_EQUAL {
    @Override
      public XMLState next(char symb, XMLTagListener xmlListener){

      XMLState result = INVALID_END;

      if (CharUtil.isEmptyChar(symb)) {
        result = HEADER_PARAM_EQUAL;
      } else if (symb == '\'') {
        result = HEADER_PARAM_SINGLEQUOTE_VALUE_START;
      } else if (symb == '"') {
        result = HEADER_PARAM_QUOTE_VALUE_START;
      }
      return result;
    }
  },

  PARAM_SINGLEQUOTE_VALUE_START {
    @Override
      public XMLState next(char symb, XMLTagListener xmlListener){

      XMLState result = INVALID_END;

      if (symb == '\'') {
        TagBuilder.makeParamValue();
        result = PARAM_SINGLEQUOTE_VALUE_END;
      } else {
        TagBuilder.addCharToCurrent(symb);;
        result = PARAM_SINGLEQUOTE_VALUE_START;
      }
      return result;
    }
  },

  HEADER_PARAM_SINGLEQUOTE_VALUE_START {
    @Override
      public XMLState next(char symb, XMLTagListener xmlListener){

      XMLState result = INVALID_END;

      if (symb == '\'') {
        TagBuilder.makeParamValue();
        result = END_HEADER_TAG_NAME;
      } else {
        TagBuilder.addCharToCurrent(symb);
        result = HEADER_PARAM_SINGLEQUOTE_VALUE_START;
      }
      return result;
    } 
  },
  PARAM_SINGLEQUOTE_VALUE_END {
    @Override
      public XMLState next(char symb, XMLTagListener xmlListener){

      XMLState result = INVALID_END;

      if (CharUtil.isEmptyChar(symb)) {
        result = PARAM_SINGLEQUOTE_VALUE_END;
      } else if (CharUtil.isNameStartChar(symb)) {
        result = PARAM_NAME;
      } else if (symb == '/') {
        TagBuilder.setTagType(TagType.SINGLE);
        result = SINGLE_TAG;
      } else if (symb == '>') {
        Tag tag = TagBuilder.makeTag();
        xmlListener.newTag(tag);
        result = ANGLE_BRACKET_CLOSED;
      }

      return result;
    }
  },

 
  HEADER_PARAM_QUOTE_VALUE_START {
    @Override
      public XMLState next(char symb, XMLTagListener xmlListener){
      XMLState result = INVALID_END;
      if (symb == '\"') {
        TagBuilder.makeParamValue();
        result = END_HEADER_TAG_NAME;
      } else {
        TagBuilder.addCharToCurrent(symb);
        result = HEADER_PARAM_QUOTE_VALUE_START;
      }
      return result;
    }

  },

  PARAM_QUOTE_VALUE_START {
    @Override
    public XMLState next(char symb, XMLTagListener xmlListener){
      XMLState result = INVALID_END;
      if (symb == '"') {
        TagBuilder.makeParamValue();
        result = END_TAG_NAME;
      } else {
        TagBuilder.addCharToCurrent(symb);;
        result = PARAM_QUOTE_VALUE_START;
      }
      return result;
    }
  },

  

  CLOSE_TAG {

    @Override
    public XMLState next(char symb, XMLTagListener xmlListener){
      XMLState result = INVALID_END;
      if (CharUtil.isEmptyChar(symb)) {
        result = CLOSE_TAG;
      } else if (CharUtil.isNameStartChar(symb)) {
        TagBuilder.addCharToCurrent(symb);
        result = CLOSE_TAG_NAME;

      }
      return result;
    }
  },
  CLOSE_TAG_NAME {
    @Override
    public XMLState next(char symb, XMLTagListener xmlListener){
      XMLState result = INVALID_END;

      if (CharUtil.isEmptyChar(symb)) {
        TagBuilder.makeName();
        result = END_TAG_NAME;
      } else if (symb == '>') {
        TagBuilder.makeName();
        Tag tag = TagBuilder.makeTag();
        xmlListener.newTag(tag);
        result = ANGLE_BRACKET_CLOSED;
      } else if (CharUtil.isNameChar(symb)) {
        TagBuilder.addCharToCurrent(symb);
        result = CLOSE_TAG_NAME;
      }
      return result;
    }
  },

  TAG_NAME {
    @Override
    public XMLState next(char symb, XMLTagListener xmlListener){
      XMLState result = INVALID_END;

      if (CharUtil.isEmptyChar(symb)) {
        TagBuilder.makeName();
        result = END_TAG_NAME;
      } else if (symb == '>') {
        TagBuilder.makeName();
        Tag tag = TagBuilder.makeTag();
        xmlListener.newTag(tag);
        result = ANGLE_BRACKET_CLOSED;
      } else if (CharUtil.isNameChar(symb)) {
        TagBuilder.addCharToCurrent(symb);
        result = TAG_NAME;
      }else if (symb == '/') {
        TagBuilder.makeName();
        TagBuilder.setTagType(TagType.SINGLE);;
        result = SINGLE_TAG;
      }
      return result;
    }
  },

  END_TAG_NAME {
    @Override
    public XMLState next(char symb, XMLTagListener xmlListener){
      XMLState result = INVALID_END;


      if (CharUtil.isEmptyChar(symb)) {
        result = END_TAG_NAME;
      } else if (symb == '>') {
        Tag tag = TagBuilder.makeTag();
        xmlListener.newTag(tag);
        result = ANGLE_BRACKET_CLOSED;
      } else if (symb == '/') {
        TagBuilder.setTagType(TagType.SINGLE);
        result = SINGLE_TAG;
      } else if (CharUtil.isNameStartChar(symb)) {
        TagBuilder.addCharToCurrent(symb);
        result = PARAM_NAME;
      }

      return result;
    }
 
  },

  SINGLE_TAG {
    @Override
      public XMLState next(char symb, XMLTagListener xmlListener){
      XMLState result = INVALID_END;

      if (CharUtil.isEmptyChar(symb)) {
        result = SINGLE_TAG;
      } else if (symb == '>') {
        Tag tag = TagBuilder.makeTag();
        xmlListener.newTag(tag);
        result = ANGLE_BRACKET_CLOSED;
      }
      return result;
    }

  },
  ANGLE_BRACKET_CLOSED {
    @Override
    public XMLState next(char symb, XMLTagListener xmlListener){
      XMLState result = INVALID_END;

      if (CharUtil.isEmptyChar(symb)) {
        TagBuilder.addCharToCurrent(symb);
        result = ANGLE_BRACKET_CLOSED;
      } else if (symb == '<') {
        TagBuilder.reset();
        result = ANGLE_BRACKET_OPENED;
      } else {
        TagBuilder.setTagType(TagType.TEXT_VALUE);
        TagBuilder.addCharToCurrent(symb);
        result = TEXT_VALUE;
      }

      return result;
    }
  },
  TEXT_VALUE {
    @Override
    public XMLState next(char symb, XMLTagListener xmlListener){
      XMLState result = INVALID_END;
      if (symb == '<') {
        TagBuilder.makeName();
        Tag tag = TagBuilder.makeTag();
        xmlListener.newTag(tag);
        result = ANGLE_BRACKET_OPENED;
      } else {
        TagBuilder.addCharToCurrent(symb);
        result = TEXT_VALUE;
      }

      return result;
    }
  },
  INVALID_END {
    @Override
    public XMLState next(char symb, XMLTagListener xmlListener){
      return INVALID_END;
    }
  },
  VALID_END {
    @Override
    public XMLState next(char symb, XMLTagListener xmlListener){
      XMLState result = INVALID_END;
      return result;
    }
  };

  abstract public XMLState next(char symb, XMLTagListener xmlListener);

}
