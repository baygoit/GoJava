package ua.goit.alg.xmlparser.parser;

public interface Handler {
  public void onCloseTag(ParserData parserData);
  public void onTextValue(ParserData parserData);
  public void onStart(ParserData parserData);
  public void onEnd(ParserData parserData);
  public void onError(ParserData parserData);
  public void onOpenTag(ParserData parserData);

}
