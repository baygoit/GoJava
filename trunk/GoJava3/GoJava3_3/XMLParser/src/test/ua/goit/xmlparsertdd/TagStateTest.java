package ua.goit.xmlparsertdd;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;


public class TagStateTest {
  @Test
  public void givenInitState_WhenFirstCharIsBracket_ThenStateShouldBeOpen() {
    TagState state = TagState.INIT;
    TagState actual = state.next('<', new TagParser());
    assertSame(TagState.OPEN, actual);
  }

  @Test
  public void givenInitState_WhenFirstCharIsBracket_ThenTagTypeShouldBeOpen() {
    TagState state = TagState.INIT;
    TagParser parser = new TagParser();
    state.next('<', parser);
    TagType actualType = parser.getType();
    assertSame(TagType.OPEN, actualType);
  }

  @Test
  public void givenOpenState_WhenFirstCharIsSpace_ThenStateShouldBeOpen() {
    TagState state = TagState.OPEN;
    TagStateMachine.tagState = TagState.OPEN;
    TagState actual = state.next(' ', new TagParser());
    assertSame(TagState.OPEN, actual);
  }

  @Test
  public void givenOpenState_WhenFirstCharInTagNameIsDigit_ThenShouldBeInvalidEndState() {
    TagState state = TagState.OPEN;
    TagState actual = state.next('1', new TagParser());
    assertSame(TagState.INVALID_END, actual);
  }

  @Test
  public void parseOpenTagWithName() {
    TagStateMachine machine = new TagStateMachine();
    char[] charsForName = {'<', 'n', 'a', 'm', 'e', '>'};
    for (char c : charsForName) {
      machine.next(c);
    }
    Tag tag = machine.getResult();
    assertEquals("name", tag.getName());
  }
}
