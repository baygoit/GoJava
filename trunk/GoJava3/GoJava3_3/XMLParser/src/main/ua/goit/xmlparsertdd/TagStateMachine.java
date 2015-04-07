package ua.goit.xmlparsertdd;

public class TagStateMachine {
  TagState tagState = TagState.INIT;
  private Tag.Builder builder = Tag.Builder.newBuilder();

  public void next(char c, XMLParser parser) {
    tagState = tagState.next(c, builder, this);
    if (tagState == TagState.VALID_TAG_END) {
      setEvent(parser);
    }
  }

  public TagState handleOpenBracket(char c, TagState result) {
    if (c == '<') {
      result = TagState.OPEN;
    }
    return result;
  }

  public TagState handleSpace(char c, TagState result) {
    if (c == ' ') {
      if (tagState == TagState.OPEN) {
        result = TagState.OPEN;
      }
    }
    return result;
  }

  public TagState handleFirstLetterForName(char c, TagState result) {
    if (CharUtil.isNameStartChar(c)) {
      result = TagState.NAME_FOR_TAG;
      builder.buildName(c);
    }
    return  result;
  }

  public TagState handleLetterForName(char c, TagState result) {
    if (CharUtil.isNameChar(c)) {
      result = TagState.NAME_FOR_TAG;
      builder.buildName(c);
    }
    return result;
  }

  public TagState handleCloseBracket(char c, TagState result) {
    if (c == '>') {
      result = TagState.VALID_TAG_END;
    }
    return result;
  }

  public void setEvent(XMLParser parser) {
    if (builder.getType() == TagType.OPEN) {
      parser.setEvent(Event.OPEN_TAG);
    }
  }

  public Tag getResult() {
    Tag result = null;
    if (tagState == TagState.VALID_TAG_END) {
      result = builder.build();
      builder = Tag.Builder.newBuilder();
    }
    return result;
  }
}
