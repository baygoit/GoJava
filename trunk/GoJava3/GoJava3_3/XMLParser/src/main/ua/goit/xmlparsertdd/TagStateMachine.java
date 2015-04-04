package ua.goit.xmlparsertdd;

public class TagStateMachine {
  TagState tagState = TagState.INIT;
  static TagParser parser = new TagParser();

  public void next(char c) {
    tagState = tagState.next(c, parser);
  }

  public static TagState handleOpenBracket(char c, TagState result) {
    if (c == '<') {
      result = TagState.OPEN;
    }
    return result;
  }

  public static TagState handleSpace(char c, TagState result) {
    if (c == ' ') {
      if (result == TagState.OPEN) {
        return result;
      }
    }
    return result;
  }

  public static TagState handleFirstLetterForName(char c, TagState result) {
    if (CharUtil.isNameStartChar(c)) {
      result = TagState.NAME2;
      parser.buildName(c);
    }
    return  result;
  }

  public static TagState handleLetterForName(char c, TagState result) {
    if (CharUtil.isNameChar(c)) {
      result = TagState.NAME2;
      parser.buildName(c);
    }
    return result;
  }

  public static TagState handleCloseBracket(char c, TagState result) {
    if (c == '>') {
      result = TagState.VALID_END;
    }
    return result;
  }

  public Tag getResult() {
    Tag result = null;
    if (tagState == TagState.VALID_END) {
      result = parser.getTag();
    }
    return result;
  }
}
