package ua.goit.xmlparsertdd;

public class TagStateMachine {
  TagState tagState = TagState.INIT;
  private TagElement.Builder builder = TagElement.Builder.newBuilder();

  public void next(char c, XMLParser parser) {
    tagState = tagState.next(c, builder, this);
    if (tagState == TagState.VALID_TAG_END) {
      setEvent(parser);
    }
  }

  public void setEvent(XMLParser parser) {
    if (builder.getType() == TagElementType.OPEN) {
      parser.sendEventToHandler(Event.OPEN_TAG);
    } else if (builder.getType() == TagElementType.CLOSE) {
      parser.sendEventToHandler(Event.CLOSE_TAG);
    } else if (builder.getType() == TagElementType.HEADER) {
      parser.sendEventToHandler(Event.START);
    }
    
  }

  public TagElement getResult() {
    TagElement result = null;
    if (tagState == TagState.VALID_TAG_END) {
      result = builder.build();
      builder = TagElement.Builder.newBuilder();
    }
    return result;
  }
}
