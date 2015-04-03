package ua.goit.xmlparsertdd;

public enum TagState {
  OPEN {
    @Override
    public TagState next(char c) {
      TagState result = INVALID_END;
      return result;
    }
  },

  INVALID_END {
    @Override
    public TagState next(char c) {
      return INVALID_END;
    }
  };

  public abstract TagState next(char c);
}
