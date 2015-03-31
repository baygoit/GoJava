package ua.goit.alg.xmlparser.parser;


import java.io.File;
import java.io.IOException;
import ua.goit.alg.xmlparser.input.StreamReader;
import ua.goit.alg.xmlparser.statemashines.StateMashineTag;

public class XMLParser {
  
  private StringBuilder result = new StringBuilder("");
  
  private Handler openTagHandler = null;
  private Handler closeTagHandler = null;
  private Handler textValueHandler = null;
  private Handler startHandler = null;
  private Handler endHandler = null;
  private Handler errHandler = null;
  
  private StateMashineTag tag = new StateMashineTag(this);
  
  public String parse(String string) throws IOException {
    StreamReader stream = new StreamReader(string);
    return parseInputStream(stream);
  }
    
  public String parse(File file) throws IOException {
    StreamReader stream = new StreamReader(file);
      return parseInputStream(stream);

  }

  private String parseInputStream(StreamReader stream) throws IOException {  
    int symbol;
    do{
      symbol = stream.read();
      tag.next((char)symbol);
    } while (symbol !=-1);
    return result.toString();
}
  
  public void onOpenTag(ParserData parserData){
    if(openTagHandler != null){
    openTagHandler.onOpenTag(parserData);
    }
    result.append("<").append(parserData.getTag()).append(">");
    parserData.setTag("");
  }

  public void onCloseTag(ParserData parserData){
    if(closeTagHandler != null){
    closeTagHandler.onCloseTag(parserData);
    }
    result.append("</").append(parserData.getTag()).append(">");
    parserData.setTag("");
  }

  public void onTextValue(ParserData parserData){
    if(textValueHandler != null){
    textValueHandler.onTextValue(parserData);
    }
    result.append("").append(parserData.getText()).append("");
    parserData.setText("");
  }
  
  public void onStart(ParserData parserData){
    if(startHandler != null) {
    startHandler.onStart(parserData);
    }
    result.append("<").append(parserData.getTag()).append(">");
    parserData.setTag("");
  }

  public void onEnd(ParserData parserData){
    if(endHandler != null){
    endHandler.onEnd(parserData);
    }
  }

  public void onError(ParserData parserData){
    if(errHandler != null){
    errHandler.onError(parserData);
    }
  }
  
  //Overload methods for callback
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
