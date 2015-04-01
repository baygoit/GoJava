package main.ua.goit.xmlparser;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class XMLElementsReader extends InputStreamReader{
  
  public XMLElementsReader(InputStream in){
    super(in);
    
  }
  char prevChar =(char)-1;

  
  public String getElement() throws IOException {
    
    StringBuilder result = new StringBuilder();
 
    char actualChar = prevChar;
    boolean readNext= true;
    
    actualChar = (char) super.read();
    while(super.ready() && (actualChar =='\n' || actualChar ==' ' )){
      actualChar = (char) super.read();
    }
    
    if(actualChar =='<'){
      prevChar = actualChar;
    }else{
      result.append(prevChar);
    }
      
   
    result.append(actualChar);
    
    while(super.ready() && readNext ){
      actualChar = (char) super.read();
      if(actualChar == '\n'){
        continue;
      }
      
      result.append(actualChar);
      if(actualChar =='<' ||actualChar =='>'  ){
        readNext = false;
      }
    }
    prevChar = actualChar;
    return result.toString();
    
  
  }

}
