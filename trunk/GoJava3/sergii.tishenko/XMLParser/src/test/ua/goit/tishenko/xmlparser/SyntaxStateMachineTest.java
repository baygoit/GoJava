package ua.goit.tishenko.xmlparser;

import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class SyntaxStateMachineTest {

@Test
public void HeaderSyntaxTegStates() throws IOException{

  String testString = " < ?xml version=\"1.0\" \n encoding='UTF-8'?>";
  Set<SyntaxState> expectedStates = new HashSet<>();
  Set<SyntaxState> actualStates = new HashSet<>();
  
  SyntaxStateMachine syntaxStateMachine = new SyntaxStateMachine();
  BufferedReader buffReader = new BufferedReader(new StringReader(testString ));
  
  expectedStates.add(SyntaxState.ANGLE_BRACKET_OPENED);
  expectedStates.add(SyntaxState.HEADER_TAG);
  expectedStates.add(SyntaxState.HEADER_TAG_NAME);
  expectedStates.add(SyntaxState.HEADER_TAG_CLOSED);
  expectedStates.add(SyntaxState.HEADER_PARAM_NAME);
  expectedStates.add(SyntaxState.HEADER_PARAM_EQUAL);
  expectedStates.add(SyntaxState.HEADER_PARAM_SINGLEQUOTE_VALUE);
  
  int intFromStrem = buffReader.read(); 

  while (intFromStrem != -1){
    try {
      syntaxStateMachine.nextChar((char)intFromStrem);
    } catch (XMLFormatException e) {
      e.printStackTrace();
      throw new RuntimeException();
    } catch (XMLNestingException e) {
      e.printStackTrace();
      throw new RuntimeException();
    }
    intFromStrem = buffReader.read();
    SyntaxState  synState  = syntaxStateMachine.getState();
    actualStates.add(synState);
  } ;
  expectedStates.removeAll(actualStates);
  
  assertTrue("No states for:" + expectedStates.toString(), expectedStates.isEmpty()); 
  
}

@Test (expected = RuntimeException.class)
public void HeaderSyntaxTegStatesError() throws IOException{

  String testString = " < ?xml <version=\"1.0\" \n encoding='UTF-8'?>";
  Set<SyntaxState> expectedStates = new HashSet<>();
  Set<SyntaxState> actualStates = new HashSet<>();
  
  SyntaxStateMachine syntaxStateMachine = new SyntaxStateMachine();
  BufferedReader buffReader = new BufferedReader(new StringReader(testString ));
  
  expectedStates.add(SyntaxState.ANGLE_BRACKET_OPENED);
  expectedStates.add(SyntaxState.HEADER_TAG);
  expectedStates.add(SyntaxState.HEADER_TAG_NAME);
  expectedStates.add(SyntaxState.HEADER_TAG_CLOSED);
  expectedStates.add(SyntaxState.HEADER_PARAM_NAME);
  expectedStates.add(SyntaxState.HEADER_PARAM_EQUAL);
  expectedStates.add(SyntaxState.HEADER_PARAM_SINGLEQUOTE_VALUE);
  
  int intFromStrem = buffReader.read(); 

  while (intFromStrem != -1){

   try {
    syntaxStateMachine.nextChar((char)intFromStrem);
  } catch (XMLFormatException e) {
 
    e.printStackTrace();
    throw new RuntimeException();
  } catch (XMLNestingException e) {
    e.printStackTrace();
    throw new RuntimeException();
  }
   intFromStrem = buffReader.read();
    SyntaxState  synState  = syntaxStateMachine.getState();
    actualStates.add(synState);
  } ;
  expectedStates.removeAll(actualStates);
  
  assertTrue("No states for:" + expectedStates.toString(), expectedStates.isEmpty()); 
  
}


@Test
public void SyntaxTegStates_Header_OPEN_TEXT_CLOSE() throws IOException{

  String  testString = " < ?xml version=\"1.0\" \n encoding=\"UTF-8\"?> <aaa param1 = 'val1<' param2 = \"val2>\" ><bbb par1='val1'/>blablabla</aaa > ";
  Set<SyntaxState> expectedStates = new HashSet<>();
  Set<SyntaxState> actualStates = new HashSet<>();

  Set<SyntaxState> expectedStatesCopy = null;
  Set<SyntaxState> actualStatesCopy   = null;
  
  SyntaxStateMachine syntaxStateMachine = new SyntaxStateMachine();
  BufferedReader buffReader = new BufferedReader(new StringReader(testString ));
  
  expectedStates.add(SyntaxState.INIT);
  expectedStates.add(SyntaxState.ANGLE_BRACKET_OPENED);
  expectedStates.add(SyntaxState.HEADER_TAG);
  expectedStates.add(SyntaxState.HEADER_TAG_NAME);
  expectedStates.add(SyntaxState.END_HEADER_TAG_NAME);
  expectedStates.add(SyntaxState.HEADER_PARAM_NAME);
  expectedStates.add(SyntaxState.HEADER_PARAM_EQUAL);
  expectedStates.add(SyntaxState.HEADER_PARAM_NAME);
  expectedStates.add(SyntaxState.HEADER_PARAM_QUOTE_VALUE);
  expectedStates.add(SyntaxState.HEADER_TAG_CLOSED);
  expectedStates.add(SyntaxState.ANGLE_BRACKET_CLOSED);
  
  expectedStates.add(SyntaxState.TAG_NAME);
  expectedStates.add(SyntaxState.PARAM_NAME);
  expectedStates.add(SyntaxState.PARAM_EQUAL);
  expectedStates.add(SyntaxState.PARAM_NAME);
  expectedStates.add(SyntaxState.PARAM_QUOTE_VALUE);
  expectedStates.add(SyntaxState.PARAM_SINGLEQUOTE_VALUE);
  expectedStates.add(SyntaxState.END_TAG_NAME);
  expectedStates.add(SyntaxState.TEXT_VALUE);
  expectedStates.add(SyntaxState.CLOSE_TAG_NAME);
  expectedStates.add(SyntaxState.CLOSE_TAG);
  expectedStates.add(SyntaxState.END_PARAM_SINGLEQUOTE_VALUE);
  expectedStates.add(SyntaxState.END_PARAM_NAME);
  expectedStates.add(SyntaxState.END_PARAM_QUOTE_VALUE);
  expectedStates.add(SyntaxState.END_HEADER_PARAM_QUOTE_VALUE);
  
  expectedStates.add(SyntaxState.SINGLE_TAG);
  
  int intFromStrem = buffReader.read(); 

  while (intFromStrem != -1){
    try {
      syntaxStateMachine.nextChar((char)intFromStrem);
    } catch (XMLFormatException e) {
      e.printStackTrace();
      throw new RuntimeException();
    } catch (XMLNestingException e) {
      e.printStackTrace();
      throw new RuntimeException();
    }
    intFromStrem = buffReader.read();
    SyntaxState  synState  = syntaxStateMachine.getState();
    actualStates.add(synState);
  } ;
 
  expectedStatesCopy = new HashSet<SyntaxState>(expectedStates);
  actualStatesCopy   = new HashSet<SyntaxState>(actualStates);
      
  expectedStatesCopy.removeAll(actualStates);
  actualStatesCopy.removeAll(expectedStates);
  
  
//  actualStates.removeAll(expectedStates);
//  System.out.println(actualStates);
//  
//  expectedStates.removeAll(actualStates);
//  System.out.println(expectedStates);
  
  assertTrue("Expected states:" + expectedStatesCopy.toString(), expectedStatesCopy.isEmpty()); 
  assertTrue("Unexpected states:" + actualStatesCopy.toString(), actualStatesCopy.isEmpty()); 
}

@Test
public void SyntaxTegStates_Header_OPEN_TEXT_CLOSE_COMMENT() throws IOException{

  String  testString = " < ?xml version=\"1.0\" \n encoding=\"UTF-8\"?> <aaa param1 = 'val1<' param2 = \"val2>\" ><bbb par1='val1'/>blablabla</aaa > <!-- bla-bla-bla---> ";
  Set<SyntaxState> expectedStates = new HashSet<>();
  Set<SyntaxState> actualStates = new HashSet<>();

  Set<SyntaxState> expectedStatesCopy = null;
  Set<SyntaxState> actualStatesCopy   = null;
  
  SyntaxStateMachine syntaxStateMachine = new SyntaxStateMachine();
  BufferedReader buffReader = new BufferedReader(new StringReader(testString ));
  
  expectedStates.add(SyntaxState.INIT);
  expectedStates.add(SyntaxState.ANGLE_BRACKET_OPENED);
  expectedStates.add(SyntaxState.HEADER_TAG);
  expectedStates.add(SyntaxState.HEADER_TAG_NAME);
  expectedStates.add(SyntaxState.END_HEADER_TAG_NAME);
  expectedStates.add(SyntaxState.HEADER_PARAM_NAME);
  expectedStates.add(SyntaxState.HEADER_PARAM_EQUAL);
  expectedStates.add(SyntaxState.HEADER_PARAM_NAME);
  expectedStates.add(SyntaxState.HEADER_PARAM_QUOTE_VALUE);
  expectedStates.add(SyntaxState.HEADER_TAG_CLOSED);
  expectedStates.add(SyntaxState.ANGLE_BRACKET_CLOSED);
  
  expectedStates.add(SyntaxState.TAG_NAME);
  expectedStates.add(SyntaxState.PARAM_NAME);
  expectedStates.add(SyntaxState.PARAM_EQUAL);
  expectedStates.add(SyntaxState.PARAM_NAME);
  expectedStates.add(SyntaxState.PARAM_QUOTE_VALUE);
  expectedStates.add(SyntaxState.PARAM_SINGLEQUOTE_VALUE);
  expectedStates.add(SyntaxState.END_TAG_NAME);
  expectedStates.add(SyntaxState.TEXT_VALUE);
  expectedStates.add(SyntaxState.CLOSE_TAG_NAME);
  expectedStates.add(SyntaxState.CLOSE_TAG);
  expectedStates.add(SyntaxState.END_PARAM_SINGLEQUOTE_VALUE);
  expectedStates.add(SyntaxState.END_PARAM_NAME);
  
  expectedStates.add(SyntaxState.SINGLE_TAG);
  
  expectedStates.add(SyntaxState.COMMENT_START);
  expectedStates.add(SyntaxState.COMMENT_END);
  expectedStates.add(SyntaxState.COMMENT_BODY);
  expectedStates.add(SyntaxState.OPEN_COMMENT_DASH);
  expectedStates.add(SyntaxState.CLOSE_COMMENT_DASH);
  expectedStates.add(SyntaxState.END_PARAM_QUOTE_VALUE);
  expectedStates.add(SyntaxState.END_HEADER_PARAM_QUOTE_VALUE);
  
  int intFromStrem = buffReader.read(); 

  while (intFromStrem != -1){
    try {
      syntaxStateMachine.nextChar((char)intFromStrem);
    } catch (XMLFormatException e) {
      e.printStackTrace();
      throw new RuntimeException();
      
    } catch (XMLNestingException e) {
      e.printStackTrace();
      throw new RuntimeException();
    }
    intFromStrem = buffReader.read();
    SyntaxState  synState  = syntaxStateMachine.getState();
    actualStates.add(synState);
  } ;
 
  expectedStatesCopy = new HashSet<SyntaxState>(expectedStates);
  actualStatesCopy   = new HashSet<SyntaxState>(actualStates);
      
  expectedStatesCopy.removeAll(actualStates);
  actualStatesCopy.removeAll(expectedStates);
  
  assertTrue("Expected states:" + expectedStatesCopy.toString(), expectedStatesCopy.isEmpty()); 
  assertTrue("Unexpected states:" + actualStatesCopy.toString(), actualStatesCopy.isEmpty()); 
}

}
