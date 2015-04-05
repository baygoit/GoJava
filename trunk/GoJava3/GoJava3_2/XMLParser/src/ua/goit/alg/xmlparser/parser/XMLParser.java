package ua.goit.alg.xmlparser.parser;


import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import ua.goit.alg.xmlparser.input.StreamReader;
import ua.goit.alg.xmlparser.statemashines.StateMashineTag;

public class XMLParser implements Parser{

  private Handler openTagHandler;
  private Handler closeTagHandler;
  private Handler textValueHandler;
  private Handler startHandler;
  private Handler endHandler;
  private Handler errHandler;

  public static class Builder {

    private Handler openTagHandler;
    private Handler closeTagHandler;
    private Handler textValueHandler;
    private Handler startHandler;
    private Handler endHandler;
    private Handler errHandler;

    public Builder setOpenTagHandler(Handler openTagHandler) {
      this.openTagHandler = openTagHandler;
      return this;
    }
    public Builder setCloseTagHandler(Handler closeTagHandler) {
      this.closeTagHandler = closeTagHandler;
      return this;
    }
    public Builder setTextValueHandler(Handler textValueHandler) {
      this.textValueHandler = textValueHandler;
      return this;
    }
    public Builder setStartHandler(Handler startHandler) {
      this.startHandler = startHandler;
      return this;
    }
    public Builder setEndHandler(Handler endHandler) {
      this.endHandler = endHandler;
      return this;
    }
    public Builder setErrHandler(Handler errHandler) {
      this.errHandler = errHandler;
      return this;
    }

    public XMLParser build(){
      return new XMLParser(this);
    }
  }

  public XMLParser(){
  }
  
  public XMLParser(Builder builder){
    openTagHandler = builder.openTagHandler;
    closeTagHandler = builder.closeTagHandler;
    textValueHandler = builder.textValueHandler;
    startHandler = builder.startHandler;
    endHandler = builder.endHandler;
    errHandler = builder.errHandler;
  }

  private StateMashineTag tag = new StateMashineTag(this);

  public String parse(String string) throws IOException {
    StreamReader stream = new StreamReader(string);
    return parseInputStream(stream);
  }

  public String parse(File file) throws IOException {
    StreamReader stream = new StreamReader(file);
    return parseInputStream(stream);
  }

  @Override
  public String parse(InputStream inputStream) throws IOException {
    StreamReader stream = new StreamReader(inputStream);
    return parseInputStream(stream);
  }

  private String parseInputStream(StreamReader stream) throws IOException {  
    int symbol;
    do{
      symbol = stream.read();
      tag.next((char)symbol);
    } while (symbol !=-1);
    return "";//result.toString();
  }

  public void onOpenTag(ParserData parserData){
    if(openTagHandler != null){
      openTagHandler.handle(parserData);
    }
    parserData.setTag("");
  }

  public void onCloseTag(ParserData parserData){
    if(closeTagHandler != null){
      closeTagHandler.handle(parserData);
    }
    parserData.setTag("");
  }

  public void onTextValue(ParserData parserData){
    if(textValueHandler != null){
      textValueHandler.handle(parserData);
    }
    parserData.setText("");
  }

  public void onStart(ParserData parserData){
    if(startHandler != null) {
      startHandler.handle(parserData);
    }
    parserData.setTag("");
  }

  public void onEnd(ParserData parserData){
    if(endHandler != null){
      endHandler.handle(parserData);
    }
  }

  public void onError(ParserData parserData){
    if(errHandler != null){
      errHandler.handle(parserData);
    }
  }

  public void onOpenTag(Handler handler){
    openTagHandler = handler;
  }

  public void onCloseTag(Handler handler){
    closeTagHandler = handler;
  }

  public void onTextValue(Handler handler){
    textValueHandler = handler;
  }

  public void onStart(Handler handler){
    startHandler = handler;
  }

  public void onEnd(Handler handler){
    endHandler = handler;
  }

  public void onError(Handler handler){
    errHandler = handler;
  }
}