package ua.goit.xmlparsertdd;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class SimpleTest {
  Tag myTag;
  Handler handler;
  XMLParser.Builder builder;
  Parser parser;

  @Before
  public void crateVariables() {
    myTag =  new Tag();
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
    //builder.onOpenTag(handler);
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
  
  @Test
  public void givenHeader_WhenHandleSetsTypeOfTag_ThenTypeOfTheTagEqualsHEADER() {

    // given
    String inputString = "<? xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\" ?>";

    // when
    handler = new Handler() {
      @Override
      public void handle(Tag tag) {
        myTag.setType(tag.getType());
      }
    };
    builder.onStart(handler);
    parser.parse(inputString);
    TagType actual = myTag.getType();
    TagType expected = TagType.HEADER;

    // then
    assertEquals(expected, actual);
  }
  
  @Test
  public void givenHeader_WhenHandleSetsNameOfTag_ThenNameOfTheTagEqualsNameOfTheInputTag() {

    // given
    String inputString = "<? xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\" ?>";
    
    Map<String, String> params = new HashMap<String, String>() {{
      put("version", "1.0");
      put("encoding", "UTF-8");
      put("standalone", "no");
    }};
    
    Tag expectedTag = new Tag();
    expectedTag.setName("xml");
    expectedTag.setType(TagType.HEADER);
    expectedTag.setParams(params);    
    
    // when
    handler = new Handler() {
      @Override
      public void handle(Tag tag) {
        myTag = tag;
      }
    };
    builder.onHeader(handler);
    parser.parse(inputString);
    Tag actualTag = myTag;
    // then
    assertEquals(expectedTag, actualTag);
  }

  @Test
  public void givenValidTagWithTextValue_WhenParseWholeTag_ThenOnTextValueInvoked() {
    //given
    String inputString = "<? xml ?><tagname>TextValue</tagname>";
    Set<Tag> myTags = new HashSet<Tag>();

    //when
    parser = builder.build();
    handler = new Handler() {
      @Override
      public void handle(Tag tag) {
        myTags.
        myTag = tag;
      }
    };
  }
}
