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
      result = TagStateMachine.handleFirstLetterForName(c, result);
      result = TagStateMachine.handleSpace(c, result);
      return result;
    }
  },

  NAME2 {
    @Override
    public TagState next(char c, TagParser parser) {
      TagState result = INVALID_END;
      result = TagStateMachine.handleCloseBracket(c, result);
      result = TagStateMachine.handleLetterForName(c, result);
      return  result;
    }
  },

  VALID_END {
    @Override
    public TagState next(char c, TagParser parser) {
      return VALID_END;
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

