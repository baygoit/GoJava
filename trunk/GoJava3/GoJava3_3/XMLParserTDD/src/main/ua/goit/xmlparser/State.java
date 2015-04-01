package main.ua.goit.xmlparser;

public enum State {
  START {
    public State next(Tag tag) {
      State result = INVALID_END;
      if (tag.getType() == TagType.OPEN) {
        result = OPEN_TAG;
      } else if (tag.getType() == TagType.HEADER) {
        result = HEADER_TAG;
      } else if (tag.getType() == TagType.SINGLE) {
        result = SINGLE_TAG;
      } 
      return result;
    }
    public State next(String str) {
      return INVALID_END;
    }
  },
  HEADER_TAG {
    public State next(Tag tag) {
      State result = INVALID_END;
      if (tag.getType() == TagType.OPEN) {
        result = OPEN_TAG;
      } else if (tag.getType() == TagType.SINGLE) {
        result = SINGLE_TAG;
      } 
      return result;
    }
    public State next(String str) {
      return INVALID_END;
    }
  },
  OPEN_TAG {
    public State next(Tag tag) {
      return TEXT_VALUE;
    }
    public State next(String str) {
      return INVALID_END;
    }
  },
  SINGLE_TAG {
    public State next(Tag tag) {
      return TEXT_VALUE;
    }
    public State next(String str) {
      return INVALID_END;
    }
  },
  TEXT_VALUE {
    public State next(Tag tag) {
      return INVALID_END;
    }
    public State next(String str) {
      State result = CLOSE_TAG;
      return result;
    }
  },
  CLOSE_TAG {
    public State next(Tag tag) {
      State result = VALID_END;
      if (tag.getType() == TagType.OPEN) {
        result = OPEN_TAG;
      } else if (tag.getType() == TagType.SINGLE) {
        result = SINGLE_TAG;
      } else if (tag.getType() == TagType.CLOSE) {
        result = CLOSE_TAG;
      } 
      return result;
    }
    public State next(String str) {
      return INVALID_END;
    }
  },
  VALID_END {
    public State next(Tag tag) {
      return INVALID_END;
    }
    public State next(String str) {
      return INVALID_END;
    }
  },
  INVALID_END {
    public State next(Tag tag) {
      return INVALID_END;
    }
    public State next(String str) {
      return INVALID_END;
    }
  }
}
