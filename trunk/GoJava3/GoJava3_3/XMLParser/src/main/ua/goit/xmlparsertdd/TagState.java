package ua.goit.xmlparsertdd;

enum TagState {
  INIT {
    @Override
    public TagState next(char c, Tag.Builder builder, TagStateMachine machine) {
      TagState result = INVALID_END;
      if (c == '<') {
        result = TagState.OPEN;
        builder.setType(TagType.OPEN);
      } else if (CharUtil.isEmptyChar(c)) {
        result = TagState.INIT;
      }
      return result;
    }
  },
  OPEN {
    @Override
    public TagState next(char c, Tag.Builder builder, TagStateMachine machine) {
      TagState result = INVALID_END;
      if (CharUtil.isEmptyChar(c)) {
        result = TagState.OPEN;
      } else if (CharUtil.isNameStartChar(c)) {
        result = TagState.TAG_NAME;
        builder.buildName(c);
      } else if (c == '/') {
        result = TagState.CLOSE;
        builder.setType(TagType.CLOSE);
      }
      return result;
    }
  },
  TAG_NAME {
    @Override
    public TagState next(char c, Tag.Builder builder, TagStateMachine machine) {
      TagState result = INVALID_END;
      if (c == '>') {
        result = TagState.VALID_TAG_END;
      } else if (CharUtil.isNameChar(c)) {
        result = TagState.TAG_NAME;
        builder.buildName(c);
      }
      return result;
    }
  },
  UNCHEKED_TAG_END {
    @Override
    public TagState next(char c, Tag.Builder builder, TagStateMachine machine) {
      // TODO: make checking in stack
      return VALID_TAG_END;
    }
  },

  VALID_TAG_END {
    @Override
    public TagState next(char c, Tag.Builder builder, TagStateMachine machine) {
      return VALID_TAG_END;
    }
  },
  INVALID_END {
    @Override
    public TagState next(char c, Tag.Builder builder, TagStateMachine machine) {
      return INVALID_END;
    }
  },
  CLOSE {
    @Override
    TagState next(char c, Tag.Builder builder, TagStateMachine machine) {
      TagState result = INVALID_END;
      if (CharUtil.isEmptyChar(c)) {
        result = TagState.CLOSE;
      } else if (CharUtil.isNameStartChar(c)) {
        result = TagState.CLOSE_NAME;
        builder.buildName(c);
      }
      return result;
    }
  },
  CLOSE_NAME {
    @Override
    TagState next(char c, Tag.Builder builder, TagStateMachine machine) {
      TagState result = INVALID_END;
      if (CharUtil.isNameChar(c)) {
        result = TagState.CLOSE_NAME;
        builder.buildName(c);
      } else if (CharUtil.isEmptyChar(c)) {
        result = TagState.END_CLOSE_NAME;
      } else if (c == '>') {
        result = TagState.VALID_TAG_END;
      }
      return result;
    }
  },
  END_CLOSE_NAME {
    @Override
    TagState next(char c, Tag.Builder builder, TagStateMachine machine) {
      TagState result = INVALID_END;
      if (CharUtil.isEmptyChar(c)){
        result = TagState.END_CLOSE_NAME;
      } else if (c == '>') {
        result = TagState.VALID_TAG_END;
      }
      return result;
    }
  };

  abstract TagState next(char c, Tag.Builder builder, TagStateMachine machine);
}
