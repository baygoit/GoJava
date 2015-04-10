package ua.goit.tishenko.xmlparser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.HashSet;
import java.util.Set;

public class SyntaxStateMachine {
  
  
  static Set<SyntaxState> meaninigStates = new HashSet<>();
  SyntaxState state = SyntaxState.INIT;
  TagReceiver tagReceiver = null;
  TagBuilder tagBuilder= new TagBuilder();

  
 
  static {
    meaninigStates.add(SyntaxState.COMMENT_BODY);
    meaninigStates.add(SyntaxState.HEADER_TAG_NAME);
    meaninigStates.add(SyntaxState.HEADER_PARAM_NAME);
    meaninigStates.add(SyntaxState.HEADER_PARAM_QUOTE_VALUE);
    meaninigStates.add(SyntaxState.HEADER_PARAM_SINGLEQUOTE_VALUE);
    meaninigStates.add(SyntaxState.TEXT_VALUE);
    meaninigStates.add(SyntaxState.TAG_NAME);
    meaninigStates.add(SyntaxState.PARAM_NAME);
    meaninigStates.add(SyntaxState.PARAM_QUOTE_VALUE);
    meaninigStates.add(SyntaxState.PARAM_SINGLEQUOTE_VALUE);
    meaninigStates.add(SyntaxState.CLOSE_TAG_NAME);
  }

  SyntaxState run(Reader reader) throws XMLFormatException, XMLNestingException {
    int intFromStrem = 0;
    BufferedReader buffReader = new BufferedReader(reader);
    long pos = 0;
    
    try {
      intFromStrem = buffReader.read();
    while (intFromStrem != -1){
      pos++;
      nextChar((char)intFromStrem);
      intFromStrem = buffReader.read();
    } ;
    
    } catch (IOException e) {
      e.printStackTrace();
      throw new RuntimeException();
      
    } catch (XMLFormatException e) {
      throw new XMLFormatException("Syntax error on pos " + pos + " (char = '" + (char)intFromStrem + "')");
    } 
    return state;
  }
  
  void nextChar(char nextChar) throws XMLFormatException, XMLNestingException {
    SyntaxState prevState = state;
     
    state = state.next(nextChar);
    
    if(state == SyntaxState.INVALID_END){
      throw new XMLFormatException(); 
    }
    
    if (meaninigStates.contains(state)) {
      tagBuilder.addCharToCurrent(nextChar);

    }else if(state == SyntaxState.HEADER_TAG){
      tagBuilder.setTagType(TagType.HEADER); 
    }else if (state == SyntaxState.CLOSE_TAG) {
      tagBuilder.setTagType(TagType.CLOSE);
    }else if (state == SyntaxState.SINGLE_TAG) {
      tagBuilder.setTagType(TagType.SINGLE);
    } 
      

    if (prevState != state) {
      
      
      if (prevState == SyntaxState.HEADER_TAG_NAME)
      {
        tagBuilder.makeName();
      } else if (prevState == SyntaxState.TAG_NAME ||prevState == SyntaxState.CLOSE_TAG_NAME)
      {
        if(tagBuilder.getTagType() != TagType.CLOSE){
          tagBuilder.setTagType(TagType.OPEN);
        }
        tagBuilder.makeName();
      }else if (prevState == SyntaxState.HEADER_PARAM_NAME
          || prevState == SyntaxState.PARAM_NAME) {
        tagBuilder.makeParamName();
        } else if (prevState == SyntaxState.HEADER_PARAM_SINGLEQUOTE_VALUE
          || prevState == SyntaxState.HEADER_PARAM_QUOTE_VALUE
          || prevState == SyntaxState.PARAM_QUOTE_VALUE
          || prevState == SyntaxState.PARAM_SINGLEQUOTE_VALUE) {
          tagBuilder.makeParamValue();
      } else if (prevState == SyntaxState.TEXT_VALUE) 
      {
        tagBuilder.makeName();
        tagBuilder.setTagType(TagType.TEXT_VALUE);
        genegateNewTag();
      }
    
      if (prevState == SyntaxState.COMMENT_END && state == SyntaxState.TEXT_VALUE) {
          
          tagBuilder.setTagType(TagType.COMMENT);
          tagBuilder.makeName();
          genegateNewTag();
          
      }
      
      if (state == SyntaxState.ANGLE_BRACKET_CLOSED) {
        genegateNewTag();
      }
    }

  }

  void setTagReceiver(TagReceiver tagReceiver) {
    this.tagReceiver = tagReceiver;
  } 
  
  Tag genegateNewTag() throws XMLNestingException{
    Tag newTag = tagBuilder.makeTag();
    if(tagReceiver != null){
      tagReceiver.nextTag(newTag);
    }
    return newTag;
  }
  
  SyntaxState getState() {
    return state;
  }

}
