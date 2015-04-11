package test;

import main.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class XmlTagParse {

  private Tag tagActual = new Tag("tag");
  private Tag tagExpect;
  private XmlParser parser = new XmlParserImpl();

  @Test
  public void isHandleResiveTag() {
    parser.onOpenTag(new Handler() {
      @Override
      public void handle(Tag tag) {
        tagExpect = tag;
      }
    });

    parser.handle(State.ON_OPEN_TAG, tagActual);
    assertEquals(tagActual, tagExpect);
  }
}
