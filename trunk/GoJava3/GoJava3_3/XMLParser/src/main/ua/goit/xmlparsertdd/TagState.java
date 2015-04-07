package ua.goit.xmlparsertdd;

enum TagState {
  INIT {

    @Override
    public TagState next(char c, Tag.Builder builder, TagStateMachine machine) {
      TagState result = INVALID_END;
      result = machine.handleOpenBracket(c, result);
      if (result == OPEN) {
        builder.setType(TagType.OPEN);
      }
      return result;
    }
  },
  OPEN {

    @Override
    public TagState next(char c, Tag.Builder builder, TagStateMachine machine) {
      TagState result = INVALID_END;
      result = machine.handleFirstLetterForName(c, result);
      result = machine.handleSpace(c, result);
      return result;
    }
  },
  NAME_FOR_TAG {

    @Override
    public TagState next(char c, Tag.Builder builder, TagStateMachine machine) {
      TagState result = INVALID_END;
      result = machine.handleCloseBracket(c, result);
      result = machine.handleLetterForName(c, result);
      return  result;
    }
  },
  UNCHEKED_TAG_END {
    @Override
    public TagState next(char c, Tag.Builder builder, TagStateMachine machine) {
      //TODO: make checking in stack
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

