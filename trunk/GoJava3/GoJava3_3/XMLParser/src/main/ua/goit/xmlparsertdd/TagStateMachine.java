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

  public void setEvent(XMLParser parser) {
    if (builder.getType() == TagType.OPEN) {
      parser.sendEventToHandler(Event.OPEN_TAG);
    } else if (builder.getType() == TagType.CLOSE){
      parser.sendEventToHandler(Event.CLOSE_TAG);
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
