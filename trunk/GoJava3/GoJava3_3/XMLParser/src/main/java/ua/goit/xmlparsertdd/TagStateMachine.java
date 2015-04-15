package ua.goit.xmlparsertdd;

public class TagStateMachine {
  TagState currentState = TagState.INIT;
  private TagElement.Builder tagBuilder = TagElement.Builder.newBuilder();
  private TextElement.Builder textBuilder = TextElement.Builder.newBuilder();
  private ErrorElement.Builder errorBuilder = ErrorElement.Builder.newBuilder();

  public void next(char c, XMLParser parser) throws XMLSyntaxException {
    TagState previousState = currentState;
    currentState = currentState.next(c, tagBuilder);
    if (currentState == TagState.VALID_TAG_END) {
      createTagElement(parser);
    } else if (currentState == TagState.TEXT_VALUE) {
      textBuilder.buildTextValue(c);
    } else if (previousState != currentState) {
      if (previousState == TagState.TEXT_VALUE) {
        parser.sendEventToHandler(Event.TEXT_VALUE, textBuilder.build());
        textBuilder.resetTextValue();
      }
    } else if (currentState == TagState.INVALID_TAG_END) {
      String textError = "XMLSyntaxException caught";
      errorBuilder.setErrorMessage(textError);
      parser.sendEventToHandler(Event.INVALID_END, errorBuilder.build());
      throw new XMLSyntaxException();
    }
  }

  private void createTagElement(XMLParser parser) {
    TagElement result = tagBuilder.build();
    tagBuilder = TagElement.Builder.newBuilder();
    setEvent(parser, result);
  }

  public void setEvent(XMLParser parser, TagElement result) {
    if (result.getType() == TagElementType.OPEN) {
      parser.sendEventToHandler(Event.OPEN_TAG, result);
    } else if (result.getType() == TagElementType.CLOSE) {
      parser.sendEventToHandler(Event.CLOSE_TAG, result);
    } else if (result.getType() == TagElementType.HEADER) {
      parser.sendEventToHandler(Event.START, result);
    } else if (result.getType() == TagElementType.SINGLE) {
      parser.sendEventToHandler(Event.SINGLE_TAG, result);
    }
  }
}
