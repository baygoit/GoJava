package ua.goit.xmlparsertdd;

public class TagStateMachine {
  TagState currentState = TagState.INIT;
  private TagElement.Builder builder = TagElement.Builder.newBuilder();

  public void next(char c, XMLParser parser) {
    TagState previousState = currentState;
    currentState = currentState.next(c, builder, this);
    if (currentState == TagState.VALID_TAG_END) {
      TagElement result = builder.build();
      builder = TagElement.Builder.newBuilder();
      setEvent(parser, result);
    } else if (currentState == TagState.TEXT_VALUE) {
      builder.buildTextValue(c);
    } else if (previousState != currentState) {
      if (previousState == TagState.TEXT_VALUE) {
        TagElement result = builder.build();
        builder = TagElement.Builder.newBuilder();
        setEvent(parser, result);
      }
    }
  }

  public void setEvent(XMLParser parser, TagElement result) {
    if (result.getType() == TagElementType.OPEN) {
      parser.sendEventToHandler(Event.OPEN_TAG, result);
    } else if (result.getType() == TagElementType.CLOSE) {
      parser.sendEventToHandler(Event.CLOSE_TAG, result);
    } else if (result.getType() == TagElementType.HEADER) {
      parser.sendEventToHandler(Event.START, result);
    } else if (result.getType() == TagElementType.TEXT_VALUE) {
      parser.sendEventToHandler(Event.TEXT_VALUE, result);
    }
    
  }
}
