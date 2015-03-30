package ua.goit.xmlparser;

public enum State {
  START {
    public State next(String str) {
      State result = INVALID_END;
      TagParser tagParser = new TagParser();
      Tag tag = tagParser.parse(str);
      if (tag.getType() == TagType.OPEN) {
        result = HEADER_TAG;
      }
      return result;
    }
  },
  HEADER_TAG {
    public State next(String str) {
      State result = INVALID_END;

      return result;
    }
  },
  OPEN_TAG {
    public State next(String str) {
      State result = INVALID_END;

      return result;
    }
  },
  SINGLE_TAG {
    public State next(String str) {
      State result = INVALID_END;

      return result;
    }
  },
  TEXT_VALUE {
    public State next(String str) {
      State result = INVALID_END;

      return result;
    }
  },
  CLOSE_TAG {
    public State next(String str) {
      State result = INVALID_END;

      return result;
    }
  },
  VALID_END {
    public State next(String str) {
      State result = INVALID_END;

      return result;
    }
  },
  INVALID_END {
    public State next(String str) {
      return INVALID_END;
    }
  }
}
