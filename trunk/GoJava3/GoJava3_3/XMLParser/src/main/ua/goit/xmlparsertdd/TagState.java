package ua.goit.xmlparsertdd;

enum TagState {

  INIT {
    @Override
    public TagState next(char c, TagParser parser) {
      TagState result = INVALID_END;
      result = TagStateMachine.handleOpenBracket(c, result);
      if (result == OPEN) {
        parser.setType(TagType.OPEN);
      }
      return result;
    }
  },

  OPEN {
    @Override
    public TagState next(char c, TagParser parser) {
      TagState result = INVALID_END;
      result = TagStateMachine.handleOpenSpace(c, result);

      return result;
    }
  },

  INVALID_END {
    @Override
    public TagState next(char c, TagParser parser) {
      return INVALID_END;
    }
  };

  abstract TagState next(char c, TagParser parser);
}

