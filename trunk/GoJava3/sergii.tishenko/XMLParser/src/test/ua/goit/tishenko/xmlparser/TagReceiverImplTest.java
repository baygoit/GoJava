/**
 * 
 */
package ua.goit.tishenko.xmlparser;

import static org.junit.Assert.fail;

import java.io.StringReader;

import org.junit.Test;
 
public class TagReceiverImplTest {

  @Test
  public void runSyntaxStateMachine() throws XMLFormatException, XMLNestingException {
    String  testString = " < ?xml version=\"1.0\" \n encoding=\"UTF-8\"?> <abc   par1=\"par_value1\" par2=\'par_value2\'><bbbb par3='val3'/>bla1<!-- comment -->bla2</abc>";
    TagReceiverImpl tagReceiverImpl =new TagReceiverImpl();
    SyntaxStateMachine synMachine = new SyntaxStateMachine();
    synMachine.setTagReceiver(tagReceiverImpl);
    SyntaxState state = synMachine.run(new StringReader(testString));
  }

  
  @Test (expected = XMLNestingException.class)
  public void Error_on_DoubleHeader() throws XMLFormatException, XMLNestingException {
    String  testString = " < ?xml version=\"1.0\" \n encoding=\"UTF-8\"?> <aaa par1=\"par_value1\" par2=\'par_value2\'> < ?xml version=\"1.0\" \n encoding=\"UTF-8\"?><bbbb par3='val3'/>bla1<!-- comment -->bla2</aaa>";
    TagReceiverImpl tagReceiverImpl =new TagReceiverImpl();
    SyntaxStateMachine synMachine = new SyntaxStateMachine();
    synMachine.setTagReceiver(tagReceiverImpl);
    SyntaxState state = synMachine.run(new StringReader(testString));
  }
  
 @Test (expected = XMLNestingException.class)
  public void Error_on_WrongCloseTag() throws XMLFormatException, XMLNestingException {
    String  testString = " < ?xml version=\"1.0\" \n encoding=\"UTF-8\"?> <aaa par1=\"par_value1\" par2=\'par_value2\'> <aaa><bb></aaa></bb>";
    TagReceiverImpl tagReceiverImpl =new TagReceiverImpl();
    SyntaxStateMachine synMachine = new SyntaxStateMachine();
    synMachine.setTagReceiver(tagReceiverImpl);
    SyntaxState state = synMachine.run(new StringReader(testString));
  }
  
@Test (expected = XMLNestingException.class)
  public void Error_on_HeaderTagAfterRoot() throws XMLFormatException, XMLNestingException {
    String  testString = "<bb>< ?xml version=\"1.0\" \n encoding=\"UTF-8\"?> <aaa par1=\"par_value1\" par2=\'par_value2\'> <aaa></aaa></bb>";
    TagReceiverImpl tagReceiverImpl =new TagReceiverImpl();
    SyntaxStateMachine synMachine = new SyntaxStateMachine();
    synMachine.setTagReceiver(tagReceiverImpl);
    SyntaxState state = synMachine.run(new StringReader(testString));
  }
  
@Test (expected = XMLNestingException.class)
  public void Error_on_HeaderTagAftgerSingleRoot() throws XMLFormatException, XMLNestingException {
    String  testString = "<bb/> < ?xml version=\"1.0\" \n encoding=\"UTF-8\"?> ";
    TagReceiverImpl tagReceiverImpl =new TagReceiverImpl();
    SyntaxStateMachine synMachine = new SyntaxStateMachine();
    synMachine.setTagReceiver(tagReceiverImpl);
    SyntaxState state = synMachine.run(new StringReader(testString));
  }
 
}
