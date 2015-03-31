package ua.goit.alg.xmlparser.parser;


import java.io.File;
import java.io.IOException;
import ua.goit.alg.xmlparser.input.InputStream;
import ua.goit.alg.xmlparser.statemashines.StateMashineTag;

public class XMLParser {
  
  private StringBuilder result = new StringBuilder("");
  
  //private ParserData parserData = null;
  
  private StateMashineTag tag = new StateMashineTag(this);
  
  public void update(ParserData parserData){
    //this.parserData = parserData;
  }
  
  public String parse(String string) throws IOException {
    InputStream stream = new InputStream(string);
    return parseInputStream(stream);
  }
    
  public String parse(File file) throws IOException {
    InputStream stream = new InputStream(file);
      return parseInputStream(stream);

  }

  public String parseInputStream(InputStream stream) throws IOException {  
   
    int symbol;
    do{
      symbol = stream.read();
      tag.next((char)symbol);
    } while (symbol !=-1);
    return result.toString();
}
  
  public void onOpenTag(ParserData parserData){
    //parserData2.onOpenTag(parserData);
    result.append("<").append(parserData.getTag()).append(">");
    parserData.clear();
  }
  public void onCloseTag(ParserData parserData){
    //handler.onCloseTag(parserData);
    result.append("</").append(parserData.getTag()).append(">");
    parserData.clear();
  }
  public void onTextValue(ParserData parserData){
    //handler.onTextValue(parserData);
    result.append("").append(parserData.getText()).append("");
    parserData.clear();
  }
  
  public void onStart(ParserData parserData){
    //handler.onStart(parserData);
    result.append("<").append(parserData.getTag()).append(">");
    parserData.clear();
  }
  public void onEnd(ParserData parserData){
    //handler.onEnd(parserData);
  }
  public void onError(ParserData parserData){
    //handler.onError(parserData);
  }
}
