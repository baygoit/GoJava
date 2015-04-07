package ua.goit.xmlparsertdd;

public class TagStateMachine {
  static TagState tagState = TagState.INIT;
  static TagBuilder builder = new TagBuilder();

  public void next(char c) {
    tagState = tagState.next(c, builder);
    if (tagState == TagState.VALID_TAG_END) {
      setEvent();
    }
  }

  public static TagState handleOpenBracket(char c, TagState result) {
    if (c == '<') {
      result = TagState.OPEN;
    }
    return result;
  }

  public static TagState handleSpace(char c, TagState result) {
    if (c == ' ') {
      if (tagState == TagState.OPEN) {
        result = TagState.OPEN;
      }
    }
    return result;
  }

  public static TagState handleFirstLetterForName(char c, TagState result) {
    if (CharUtil.isNameStartChar(c)) {
      result = TagState.NAME_FOR_TAG;
      builder.buildName(c);
    }
    return  result;
  }

  public static TagState handleLetterForName(char c, TagState result) {
    if (CharUtil.isNameChar(c)) {
      result = TagState.NAME_FOR_TAG;
      builder.buildName(c);
    }
    return result;
  }

  public static TagState handleCloseBracket(char c, TagState result) {
    if (c == '>') {
      result = TagState.VALID_TAG_END;
    }
    return result;
  }

  public static void setEvent() {
    if (builder.getType() == TagType.OPEN) {
      XMLParser.setEvent(Event.OPEN_TAG);
    }
  }

  public Tag getResult() {
    Tag result = null;
    if (tagState == TagState.VALID_TAG_END) {
      result = builder.getTag();
      builder = new TagBuilder();
    }
    return result;
  }
}
