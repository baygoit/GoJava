package ua.goit.xmlparsertdd;

import org.junit.Test;

import static org.junit.Assert.assertSame;


public class TagStateTest {
  //Test first char for tag name
  @Test
  public void testOpenState() {
    TagState state = TagState.OPEN;
    TagState actual = state.next('1');
    assertSame(TagState.INVALID_END, actual);
  }

  @Test
  public void testSetType() {
    TagStateMachine tsm = new TagStateMachine();
    TagParser tagParser = tsm.tagParser;
    tagParser.setType(TagType.CLOSE);
    assertSame(TagType.CLOSE, tsm.tagParser.getType());
  }
}
