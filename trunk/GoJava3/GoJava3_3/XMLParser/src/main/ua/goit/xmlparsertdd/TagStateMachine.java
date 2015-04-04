package ua.goit.xmlparsertdd;

public class TagStateMachine {
  TagState tagState = TagState.INIT;
  TagParser parser = new TagParser();

  public void next(char c) {
    tagState.next(c, parser);
  }

  public static TagState handleOpenBracket(char c, TagState result) {
    if (c == '<') {
      result = TagState.OPEN;
    }
    return result;
  }

  public static TagState handleOpenSpace(char c, TagState result) {
    if (c == ' ') {
      result = TagState.OPEN;
    }
    return result;
  }
}
