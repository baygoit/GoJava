package ua.goit.xmlparser;

public enum State {
  START {
    
  }, 
  HEADER_TAG {
    
  }, 
  OPEN_TAG {
    
  }, 
  SINGLE_TAG {
    
  }, 
  TEXT_VALUE {
    
  }, 
  CLOSE_TAG {
    
  }, 
  VALID_END {
    
  }, 
  INVALID_END {
    
    public State next(char c, ParserData data) {
      return INVALID_END;
    }
  }
}
