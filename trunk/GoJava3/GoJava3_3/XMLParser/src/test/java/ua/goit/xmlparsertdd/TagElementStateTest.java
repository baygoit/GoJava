package ua.goit.xmlparsertdd;

import org.junit.Test;
import ua.goit.xmlparsertdd.elements.TagElement;
import ua.goit.xmlparsertdd.statemachine.TagState;

import static org.junit.Assert.assertEquals;


public class TagElementStateTest {
  @Test
  public void givenInitState_WhenFirstCharIsBracket_ThenStateShouldBeOpen() {
    TagState state = TagState.INIT;
    TagState actual = state.next('<', TagElement.Builder.newBuilder());
    assertEquals(TagState.OPEN, actual);
  }

  @Test
  public void givenOpenState_WhenFirstCharIsSpace_ThenStateShouldBeOpen() {
    TagState state = TagState.OPEN;
    TagState actual = state.next(' ', TagElement.Builder.newBuilder());
    assertEquals(TagState.OPEN, actual);
  }

  @Test
  public void givenOpenState_WhenFirstCharInTagNameIsDigit_ThenShouldBeInvalidEndState() {
    TagState state = TagState.OPEN;
    TagState actual = state.next('1', TagElement.Builder.newBuilder());
    assertEquals(TagState.INVALID_TAG_END, actual);
  }
}
