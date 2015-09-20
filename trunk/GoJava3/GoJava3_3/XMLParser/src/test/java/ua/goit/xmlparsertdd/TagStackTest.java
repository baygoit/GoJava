package ua.goit.xmlparsertdd;

import org.junit.Test;
import ua.goit.xmlparsertdd.statemachine.TagState;
import ua.goit.xmlparsertdd.exceptions.XMLNestingException;
import ua.goit.xmlparsertdd.parsers.XMLParser;
import ua.goit.xmlparsertdd.statemachine.TagStateMachine;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import static org.junit.Assert.assertEquals;


public class TagStackTest {
  
  TagState runMachine(String testString) throws XMLNestingException {
    XMLParser.Builder builder = XMLParser.Builder.newParserBuilder();
    XMLParser parser = builder.build();
    TagStateMachine machine = new TagStateMachine();
    TagState currentState = TagState.INIT;
    char c;
    try (InputStreamReader inputStreamReader = new InputStreamReader(new ByteArrayInputStream(testString.getBytes()))) {
        while (inputStreamReader.ready()) {
        c = (char) inputStreamReader.read();
        currentState = machine.next(c, parser);
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
    return currentState;
  }
  
  @Test (expected = XMLNestingException.class)
  public void Error_on_Header_Tag_Header() throws XMLNestingException, IOException {
    String  testString = " < ?xml version=\"1.0\" \n encoding=\"UTF-8\"?> <aaa par1=\"par_value1\" par2=\'par_value2\'> < ?xml version=\"1.0\" \n encoding=\"UTF-8\"?><bbbb par3='val3'/>bla1<!-- comment -->bla2</aaa>";
    runMachine(testString);
  }
  
  @Test (expected = XMLNestingException.class)
  public void Error_on_DoubleHeader_Tags() throws XMLNestingException, IOException {
    String  testString = " < ?xml version=\"1.0\" \n encoding=\"UTF-8\"?> < ?xml version=\"1.0\" \n encoding=\"UTF-8\"?><bbbb par3='val3'/>bla1<!-- comment -->bla2</aaa>";
    runMachine(testString);
  }
  @Test   (expected = XMLNestingException.class)
  public void Error_on_DoubleHeader() throws XMLNestingException, IOException {
    String  testString = " < ?xml version=\"1.0\" \n encoding=\"UTF-8\"?> < ?xml version=\"1.0\" \n encoding=\"UTF-8\"?>";
    
    TagState state = runMachine(testString);
    
    assertEquals(state,TagState.INVALID_TAG_END);
  }
  
  @Test (expected = XMLNestingException.class)
  public void Error_on_WrongCloseTag() throws  XMLNestingException {
    String  testString = " < ?xml version=\"1.0\" \n encoding=\"UTF-8\"?> <aaa par1=\"par_value1\" par2=\'par_value2\'> <aaa><bb></aaa></bb>";
    runMachine(testString);
  }
  
  @Test (expected = XMLNestingException.class)
  public void Error_on_HeaderTagAfterRoot() throws XMLNestingException, IOException {
    String  testString = "<bb>< ?xml version=\"1.0\" \n encoding=\"UTF-8\"?> <aaa par1=\"par_value1\" par2=\'par_value2\'> <bb></aaa></bb>";
    runMachine(testString);
  }
  
  @Test (expected = XMLNestingException.class)
  public void Error_on_HeaderTagAfterSingleRoot() throws XMLNestingException {
    String  testString = "<bb/> < ?xml version=\"1.0\" \n encoding=\"UTF-8\"?> ";
    runMachine(testString);
  }
}
