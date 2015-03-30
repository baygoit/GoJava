package ua.goit.alg.xmlparser.parser;

import java.io.File;

import ua.goit.alg.xmlparser.input.InputStream;
import ua.goit.alg.xmlparser.statemashines.StateMashineTag;
public class XMLParser {
  
  private InputStream stream = new InputStream();
  private ParserData parserData = null;
  private StateMashineTag tag = new StateMashineTag(this);
  public void update(ParserData parserData){
    this.parserData = parserData;
  }
  
  public String parse(String string) {
    for(char c: stream.parse(string)){
      tag.next(c);
    }
    return "tag";
  }
  
  public String parse(File file) {
    for(char c: stream.parse(file)){
      tag.next(c);
    }
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
