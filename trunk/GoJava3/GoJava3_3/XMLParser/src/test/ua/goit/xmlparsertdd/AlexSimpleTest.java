package ua.goit.xmlparsertdd;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

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
  public void givenOpenTag_WhenHandleSetsNameOfTag_ThenNameOfTheTagEqualsNameOfTheInputTag() {

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

  @Test
  public void givenOpenTag_WhenHandleSetsTypeOfTag_ThenTypeOfTheTagEqualsOPEN() {

    // given
    String inputString = "<name>";

    // when
    handler = new Handler() {
      @Override
      public void handle(Tag tag) {
        myTag.setType(tag.getType());
      }
    };
    builder.onOpenTag(handler);
    parser.parse(inputString);
    TagType actual = myTag.getType();
    TagType expected = TagType.OPEN;

    // then
    assertEquals(expected, actual);
  }

  @Test
  public void givenCloseTag_WhenHandleSetsNameOfTag_ThenNameOfTheTagEqualsNameOfTheInputTag() {

    // given
    String inputString = "</name>";

    // when
    handler = new Handler() {
      @Override
      public void handle(Tag tag) {
        myTag.setName(tag.getName());
      }
    };
    builder.onCloseTag(handler);
    parser.parse(inputString);
    String actual = myTag.getName();
    String expected = "name";

    // then
    assertEquals(expected, actual);
  }

  @Test
  public void givenCloseTag_WhenHandleSetsTypeOfTag_ThenTypeOfTheTagEqualsCLOSE() {

    // given
    String inputString = "</name>";

    // when
    handler = new Handler() {
      @Override
      public void handle(Tag tag) {
        myTag.setType(tag.getType());
      }
    };
    builder.onCloseTag(handler);
    parser.parse(inputString);
    TagType actual = myTag.getType();
    TagType expected = TagType.CLOSE;

    // then
    assertEquals(expected, actual);
  }
  
  
  
  
  
  
}
