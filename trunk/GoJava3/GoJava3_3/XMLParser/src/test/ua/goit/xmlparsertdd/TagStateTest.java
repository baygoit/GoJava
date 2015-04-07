package ua.goit.xmlparsertdd;

import org.junit.Test;

import static org.junit.Assert.assertSame;


public class TagStateTest {
  @Test
  public void givenInitState_WhenFirstCharIsBracket_ThenStateShouldBeOpen() {
    TagState state = TagState.INIT;
    TagState actual = state.next('<', Tag.Builder.newBuilder(), new TagStateMachine());
    assertSame(TagState.OPEN, actual);
  }

  @Test
  public void givenInitState_WhenFirstCharIsBracket_ThenTagTypeShouldBeOpen() {
    TagState state = TagState.INIT;
    Tag.Builder builder = Tag.Builder.newBuilder();
    state.next('<', builder, new TagStateMachine());
    TagType actualType = builder.getType();
    assertSame(TagType.OPEN, actualType);
  }

  @Test
  public void givenOpenState_WhenFirstCharIsSpace_ThenStateShouldBeOpen() {
    TagState state = TagState.OPEN;
    TagStateMachine machine = new TagStateMachine();
    machine.tagState = TagState.OPEN;
    TagState actual = state.next(' ', Tag.Builder.newBuilder(), machine);
    assertSame(TagState.OPEN, actual);
  }

  @Test
  public void givenOpenState_WhenFirstCharInTagNameIsDigit_ThenShouldBeInvalidEndState() {
    TagState state = TagState.OPEN;
    TagState actual = state.next('1', Tag.Builder.newBuilder(), new TagStateMachine());
    assertSame(TagState.INVALID_END, actual);
  }
}
