package ua.goit.tishenko.xmlparser;

import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

import static org.junit.Assert.*;

public class TagGenerationTest {

  @Test
  public void GenerationTag_HEADER_OPEN_CLOSE_SINGLE_COMMENT() {
    String  testString = " < ?xml version=\"1.0\" \n encoding=\"UTF-8\"?> <aaa par1=\"par_value1\" par2=\'par_value2\'><bbbb par3='val3'/>bla1<!-- comment -->bla2</aaa>";
    SyntaxStateMachine syntaxStateMachine = new SyntaxStateMachine();
    BufferedReader buffReader = new BufferedReader(new StringReader(testString ));
    
    final Set<Tag> actualTags = new HashSet<>();
    final Set<Tag> expectedTags   = new HashSet<>();
    Set<Tag> actualTagsCopy = new HashSet<>();
    Set<Tag> expectedTagsCopy = new HashSet<>();
    
    syntaxStateMachine.setTagReceiver(new TagReceiver(){
      @Override
      public void nextTag(Tag tag) {
        actualTags.add(tag);
 
      }
    });
    
    int intFromStrem;
    try {
      intFromStrem = buffReader.read();

    while (intFromStrem != -1){
      syntaxStateMachine.nextChar((char)intFromStrem);
      intFromStrem = buffReader.read();
    } ;
    
    } catch (IOException e) {
      e.printStackTrace();
    } catch (XMLFormatException e) {
      e.printStackTrace();
      throw new RuntimeException(); 
    } catch (XMLNestingException e) {
      e.printStackTrace();
      throw new RuntimeException();
    } 

    Map<String, String> expectedTagParams1 = new HashMap<String, String>();
    expectedTagParams1.put("version", "1.0");
    expectedTagParams1.put("encoding", "UTF-8");
    
    Tag expectedTag1 = new Tag(TagType.HEADER, "xml", expectedTagParams1 );
    expectedTags.add(expectedTag1);

    
    Map<String, String> expectedTagParams2 = new HashMap<String, String>();
    expectedTagParams2.put("par1", "par_value1");
    expectedTagParams2.put("par2", "par_value2");
    
    Tag expectedTag2 = new Tag(TagType.OPEN, "aaa", expectedTagParams2 );
    expectedTags.add(expectedTag2);

    Tag expectedTag3 = new Tag(TagType.CLOSE, "aaa");
    expectedTags.add(expectedTag3);
    
    Map<String, String> expectedTagParams4 = new HashMap<String, String>();
    expectedTagParams4.put("par3", "val3");
    
    Tag expectedTag4 = new Tag(TagType.SINGLE, "bbbb",expectedTagParams4 );
    expectedTags.add(expectedTag4);
    
    Tag expectedTag5 = new Tag(TagType.COMMENT, "comment" );
    expectedTags.add(expectedTag5);
    
    Tag expectedTag6 = new Tag(TagType.TEXT_VALUE, "bla1");
    expectedTags.add(expectedTag6);
   
    Tag expectedTag7 = new Tag(TagType.TEXT_VALUE, "bla2");
    expectedTags.add(expectedTag7);
   
 
    
    
    expectedTags.add(expectedTag1);
    
    expectedTagsCopy = new HashSet<>(expectedTags);
    actualTagsCopy = new HashSet<>(actualTags);
    
    expectedTagsCopy.removeAll(actualTags);
    actualTagsCopy.removeAll(expectedTags);
    
    
    assertTrue("Expected states:" + expectedTagsCopy.toString(), expectedTagsCopy.isEmpty()); 
    assertTrue("Unexpected states:" + actualTagsCopy.toString(), actualTagsCopy.isEmpty()); 

  
  }


  @Test
  public void GenerationTag_HEADER() {
    String testString = " < ?xml version=\"1.0\" \n encoding='UTF-8'?>";
    SyntaxStateMachine syntaxStateMachine = new SyntaxStateMachine();
    BufferedReader buffReader = new BufferedReader(new StringReader(testString ));
    
    final Set<Tag> actualTags = new HashSet<>();
    final Set<Tag> expectedTags   = new HashSet<>();
    Set<Tag> actualTagsCopy = new HashSet<>();
    Set<Tag> expectedTagsCopy = new HashSet<>();
    
    syntaxStateMachine.setTagReceiver(new TagReceiver(){
      @Override
      public void nextTag(Tag tag) {
        actualTags.add(tag);
 
      }
    });
    
    int intFromStrem; 
    try {
      intFromStrem = buffReader.read();

    while (intFromStrem != -1){
      syntaxStateMachine.nextChar((char)intFromStrem);
      intFromStrem = buffReader.read();
    } ;
    
    } catch (IOException e) {
      e.printStackTrace();
    } catch (XMLFormatException e) {
      e.printStackTrace();
      throw new RuntimeException();
    } catch (XMLNestingException e) {
      e.printStackTrace();
      throw new RuntimeException();
    } 

    Map<String, String> expectedTag1Params = new HashMap<String, String>();
    expectedTag1Params.put("version", "1.0");
    expectedTag1Params.put("encoding", "UTF-8");
    
    Tag expectedTag1 = new Tag(TagType.HEADER, "xml", expectedTag1Params );
    expectedTags.add(expectedTag1);
    
    expectedTagsCopy = new HashSet<>(expectedTags);
    actualTagsCopy = new HashSet<>(actualTags);
    
    expectedTagsCopy.removeAll(actualTags);
    actualTagsCopy.removeAll(expectedTags);
    
 
   assertTrue("Expected tags:" + expectedTagsCopy.toString(), expectedTagsCopy.isEmpty()); 
   assertTrue("Unexpected tagss:" + actualTagsCopy.toString(), actualTagsCopy.isEmpty()); 

  
  }
  @Test
  public void runTest() throws XMLFormatException, XMLNestingException {
    String  testString = " < ?xml version=\"1.0\" \n encoding=\"UTF-8\"?> <aaa par1=\"par_value1\" par2=\'par_value2\'><bbbb par3='val3'/>bla1<!-- comment -->bla2</aaa>";
    SyntaxStateMachine syntaxStateMachine = new SyntaxStateMachine();
    SyntaxState state; 
    state = syntaxStateMachine.run(new StringReader(testString ));
    assertEquals(state, SyntaxState.ANGLE_BRACKET_CLOSED);
    
  }
  
  @Test (expected = XMLFormatException.class)
  public void runTest_SyntaxError() throws XMLFormatException, XMLNestingException {
    String  testString = " < ?xml version=\"1.0\" \n < encoding=\"UTF-8\"?> <aaa par1=\"par_value1\" par2=\'par_value2\'><bbbb par3='val3'/>bla1<!-- comment -->bla2</aaa>";
    SyntaxStateMachine syntaxStateMachine = new SyntaxStateMachine();
    SyntaxState state; 
    state = syntaxStateMachine.run(new StringReader(testString ));
    assertEquals(state, SyntaxState.ANGLE_BRACKET_CLOSED);
    
  }
}
