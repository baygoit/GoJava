package ua.goit.xmlparser;

public enum State {
  START {
    public State next(String str) {
      return INVALID_END;
    }
  }, 
  HEADER_TAG {
    public State next(String str) {
      return INVALID_END;
    }
  }, 
  OPEN_TAG {
    public State next(String str) {
      return INVALID_END;
    }
  }, 
  SINGLE_TAG {
    public State next(String str) {
      return INVALID_END;
    }
  }, 
  TEXT_VALUE {
    public State next(String str) {
      return INVALID_END;
    }
  }, 
  CLOSE_TAG {
    public State next(String str) {
      return INVALID_END;
    }
  }, 
  VALID_END {
    public State next(String str) {
      return INVALID_END;
    }
  }, 
  INVALID_END {
    public State next(String str) {
      return INVALID_END;
    }
  }
}
