package ua.goit.xmlparsertdd;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class XMLParserTest {
  @Test
  public void parseXML() {
    final TagElement myTagElement = new TagElement();
    Handler handler = new Handler() {
      @Override
      public void handle(TagElement tag) {
        myTagElement.setName(tag.getName());
      }
    };
    XMLParser.Builder builder= XMLParser.Builder.newParserBuilder();
    Parser parser = builder.build();
    builder.onOpenTag(handler);
    parser.parse("<handle>");
    assertEquals("handle", myTagElement.getName());
  }
}