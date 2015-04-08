package ua.goit.xmlparsertdd;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AlexSimpleTest {
  final Tag myTag = new Tag();
  Handler handler;
  XMLParser.Builder builder;
  Parser parser;

  @Before
  public void crateVariables() {
    builder = XMLParser.Builder.newParserBuilder();
    parser = builder.build();
  }

  @Test
  public void givenOpenTag_WhenHandleSetsNameOfTheTag_ThenNameOfTheTagEqualsNameOfTheInputTag() {

    // given
    String inputString = "<name>";

    // when
    handler = new Handler() {
      @Override
      public void handle(Tag tag) {
        myTag.setName(tag.getName());
      }
    };
    builder.onOpenTag(handler);
    parser.parse(inputString);
    String actual = myTag.getName();
    String expected = "name";

    // then
    assertEquals(expected, actual);
  }

}
