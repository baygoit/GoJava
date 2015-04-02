package main.ua.goit.xmlparsertdd;

public class TagStateMachine {
  TagState tagState = TagState.OPEN;
  public TagParser tagParser = new TagParser();

  public void next(char c) {
    TagState.OPEN.next(c);
  }
}
