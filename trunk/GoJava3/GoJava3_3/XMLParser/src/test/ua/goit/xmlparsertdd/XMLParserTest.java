package ua.goit.xmlparsertdd;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class XMLParserTest {
  @Test
  public void parseXML() {
    final Tag myTag = new Tag();
    Handler handler = new Handler() {
      @Override
      public void handle(Tag tag) {
        myTag.setName(tag.getName());
      }
    };
    XMLParser parser = new XMLParser(handler);
    parser.onOpenTag(handler);
    parser.parse("<handle>");
    assertEquals("handle", myTag.getName());
  }
}