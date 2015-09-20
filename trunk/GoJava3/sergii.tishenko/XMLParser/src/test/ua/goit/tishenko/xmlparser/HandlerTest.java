package ua.goit.tishenko.xmlparser;

import static org.junit.Assert.*;

import org.junit.Test;

public class HandlerTest {
  
  boolean methodRunned(){
    System.out.println("running");
    return true;
  }
  
  @Test
  public void runUnsettedHandler() {
    EventHandler eventHandler = new EventHandler();
    final Boolean runned = false;
    final StringBuilder strRes= new StringBuilder();
    eventHandler.sendEvent(Event.START, "");
  }
  
  
  @Test
  public void callHander_WithString() {
    EventHandler eventHandler = new EventHandler();
    final Boolean runned = false;
    final StringBuilder strRes= new StringBuilder();
    
    eventHandler.addHandler(Event.START, new Handler(){

      @Override
      public void handle(Tag tag) {
        strRes.append("Run");
      } 
 
      public void handle(String string) {
        strRes.append("Run");
        
      }}); 
    eventHandler.sendEvent(Event.START, "");
    assertFalse("str res = "+ strRes.toString(), strRes.toString().equals(""));
 
  }
  @Test
  public void callHander_WithTag() {
    EventHandler eventHandler = new EventHandler();
    final Boolean runned = false;
    final StringBuilder strRes= new StringBuilder();
    
    eventHandler.addHandler(Event.CLOSE_TAG, new Handler(){

      @Override
      public void handle(Tag tag) {
        strRes.append("Run");
      }
 
      public void handle(String string) {
        strRes.append("Run");
        
      }}); 
    Tag tag = new Tag(TagType.CLOSE, "aaa");
    eventHandler.sendEvent(Event.CLOSE_TAG, tag);

    assertFalse("str res = "+ strRes.toString(), strRes.toString().equals(""));
 
  }
}
