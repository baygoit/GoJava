package ua.goit.alg.xmlparser.parser;

import java.io.File;

import ua.goit.alg.xmlparser.input.InputStream;
public class XMLParser {
  
  private StringBuilder result = new StringBuilder("");
  private InputStream stream = new InputStream();
  private ParserData parserData = null;
  
  public void update(ParserData parserData){
    this.parserData = parserData;
  }
  
  public String parse(String string) {
    stream.parse(string);
    return "tag";
  }
  
  public String parse(File file) {
    stream.parse(file);
    return "tag";
  }

  public void onOpenTag(Handler handler){
    handler.onOpenTag(parserData);
    
  }
  public void onCloseTag(Handler handler){
    handler.onCloseTag(parserData);
  }
  public void onTextValue(Handler handler){
    handler.onTextValue(parserData);
  }
  
  public void onStart(Handler handler){
    handler.onStart(parserData);
  }
  public void onEnd(Handler handler){
    handler.onEnd(parserData);
  }
  public void onError(Handler handler){
    handler.onError(parserData);
  }
}
