package ua.goit.xmlparsertdd;

enum TagState {
  INIT {

    @Override
    public TagState next(char c, Tag.Builder builder, TagStateMachine machine) {
      TagState result = INVALID_END;
      if (c == '<') {
        result = TagState.OPEN;
        builder.setType(TagType.OPEN);
      }
      return result;
    }
  },
  OPEN {

    @Override
    public TagState next(char c, Tag.Builder builder, TagStateMachine machine) {
      TagState result = INVALID_END;
      if (c == ' ') {
        result = TagState.OPEN;
      } else if (CharUtil.isNameStartChar(c)) {
        result = TagState.NAME_FOR_TAG;
        builder.buildName(c);
      }
      return result;
    }
  },
  NAME_FOR_TAG {

    @Override
    public TagState next(char c, Tag.Builder builder, TagStateMachine machine) {
      TagState result = INVALID_END;
      if (c == '>') {
        result = TagState.VALID_TAG_END;
      }else if (CharUtil.isNameChar(c)) {
        result = TagState.NAME_FOR_TAG;
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
  };

  abstract TagState next(char c, Tag.Builder builder, TagStateMachine machine);
}
