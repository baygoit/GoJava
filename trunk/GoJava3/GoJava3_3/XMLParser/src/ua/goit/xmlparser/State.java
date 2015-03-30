package ua.goit.xmlparser;

public enum State {
  START {
    public State next(Tag tag) {
      State result = INVALID_END;
      if (tag.getType() == TagType.OPEN) {
        result = OPEN_TAG;
      } else if (tag.getType() == TagType.HEADER) {
        result = HEADER_TAG;
      }
      return result;
    }
    public State next(String str) {
      return next(new TagParser().parse(str));
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
