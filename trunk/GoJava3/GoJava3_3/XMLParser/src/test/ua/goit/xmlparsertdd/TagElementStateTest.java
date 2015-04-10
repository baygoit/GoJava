package ua.goit.xmlparsertdd;

import org.junit.Test;

import static org.junit.Assert.assertSame;


public class TagElementStateTest {
  @Test
  public void givenInitState_WhenFirstCharIsBracket_ThenStateShouldBeOpen() {
    TagState state = TagState.INIT;
    TagState actual = state.next('<', TagElement.Builder.newBuilder(), new TagStateMachine());
    assertSame(TagState.OPEN, actual);
  }

  @Test
  public void givenInitState_WhenFirstCharIsBracket_ThenTagTypeShouldBeOpen() {
    TagState state = TagState.INIT;
    TagElement.Builder builder = TagElement.Builder.newBuilder();
    state.next('<', builder, new TagStateMachine());
    TagElementType actualType = builder.getType();
    assertSame(TagElementType.OPEN, actualType);
  }

  @Test
  public void givenOpenState_WhenFirstCharIsSpace_ThenStateShouldBeOpen() {
    TagState state = TagState.OPEN;
    TagStateMachine machine = new TagStateMachine();
    machine.currentState = TagState.OPEN;
    TagState actual = state.next(' ', TagElement.Builder.newBuilder(), machine);
    assertSame(TagState.OPEN, actual);
  }

  @Test
  public void givenOpenState_WhenFirstCharInTagNameIsDigit_ThenShouldBeInvalidEndState() {
    TagState state = TagState.OPEN;
    TagState actual = state.next('1', TagElement.Builder.newBuilder(), new TagStateMachine());
    assertSame(TagState.INVALID_END, actual);
  }
}
