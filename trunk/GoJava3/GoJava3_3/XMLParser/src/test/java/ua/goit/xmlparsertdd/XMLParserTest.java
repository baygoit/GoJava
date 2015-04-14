package ua.goit.xmlparsertdd;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class XMLParserTest {
  TagElement myTagElement;
  Handler handler;
  XMLParser.Builder builder;
  Parser parser;

  @Before
  public void crateVariables() {
    myTagElement =  new TagElement();
    builder = XMLParser.Builder.newParserBuilder();
  }

  @Test
  public void givenOpenTag_WhenHandleSetsNameOfTag_ThenNameOfTheTagEqualsNameOfTheInputTag() {

    // given
    String inputString = "<name>";

    // when
    handler = new Handler() {
      @Override
      public void handle(TagElement tagElement) {
        myTagElement.setName(tagElement.getName());
      }
    };
    builder.onOpenTag(handler);
    parser = builder.build();
    parser.parse(inputString);

    // then
    assertEquals("name", myTagElement.getName());
  }

  @Test
  public void givenOpenTag_WhenHandleSetsTypeOfTag_ThenTypeOfTheTagEqualsOPEN() {

    // given
    String inputString = "<name>";

    // when
    handler = new Handler() {
      @Override
      public void handle(TagElement tagElement) {
        myTagElement.setType(tagElement.getType());
      }
    };
    builder.onOpenTag(handler);
    parser = builder.build();
    parser.parse(inputString);
    TagElementType actual = myTagElement.getType();
    TagElementType expected = TagElementType.OPEN;

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
      public void handle(TagElement tagElement) {
        myTagElement.setName(tagElement.getName());
      }
    };
    builder.onCloseTag(handler);
    parser = builder.build();
    parser.parse(inputString);

    // then
    assertEquals("name", myTagElement.getName());
  }

  @Test
  public void givenCloseTag_WhenHandleSetsTypeOfTag_ThenTypeOfTheTagEqualsCLOSE() {

    // given
    String inputString = "</name>";

    // when
    handler = new Handler() {
      @Override
      public void handle(TagElement tagElement) {
        myTagElement.setType(tagElement.getType());
      }
    };
    builder.onCloseTag(handler);
    parser = builder.build();
    parser.parse(inputString);
    TagElementType actual = myTagElement.getType();
    TagElementType expected = TagElementType.CLOSE;

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
      public void handle(TagElement tagElement) {
        myTagElement.setType(tagElement.getType());
      }
    };
    builder.onStart(handler);
    parser = builder.build();
    parser.parse(inputString);
    TagElementType actual = myTagElement.getType();
    TagElementType expected = TagElementType.HEADER;

    // then
    assertEquals(expected, actual);
  }

  @Test
  public void givenHeader_WhenParseTagElement_ThenCompareExpectedAndActualTagElements() {

    // given
    String inputString = "<? xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\" ?>";

    Map<String, String> params = new HashMap<String, String>() {{
      put("version", "1.0");
      put("encoding", "UTF-8");
      put("standalone", "no");
    }};

    TagElement expectedTagElement = new TagElement();
    expectedTagElement.setName("xml");
    expectedTagElement.setType(TagElementType.HEADER);
    expectedTagElement.setParams(params);

    // when
    handler = new Handler() {
      @Override
      public void handle(TagElement tagElement) {
        myTagElement = tagElement;
      }
    };
    builder.onStart(handler);
    parser = builder.build();
    parser.parse(inputString);
    TagElement actualTagElement = myTagElement;
    // then
    assertEquals(expectedTagElement, actualTagElement);
  }

  @Test
  public void givenValidTagWithTextValue_WhenParseWholeTag_ThenOnTextValueInvoked() {
    //given
    String inputString = "<? xml ?><tagname>TextValue</tagname>";

    //when
    handler = new Handler() {
      @Override
      public void handle(TagElement tagElement) {
        myTagElement = tagElement;
      }
    };
    builder.onTextValue(handler);
    parser = builder.build();
    parser.parse(inputString);
    String expected = "TextValue";
    String actual = myTagElement.getTextValue();
    assertEquals(expected,actual);
  }

  @Test
  public void givenTagWithAttributes_WhenParseWholeTag_ThenOnOpenTagInvokedAndCheckAttributes() {
    //given
    String inputString = "<? xml ?><tagname param = \"param value\">TextValue</tagname>";

    //when
    handler = new Handler() {
      @Override
      public void handle(TagElement tagElement) {
        myTagElement = tagElement;
      }
    };
    builder.onOpenTag(handler);
    parser = builder.build();
    parser.parse(inputString);
    String expected = "param value";
    Map<String, String> params = myTagElement.getParams();
    String actual = params.get("param");
    assertEquals(expected,actual);
  }

  @Test
  public void givenTagWithSingleTagElement_WhenParseWholeTag_ThenOnSingleTagInvokedAndCheckName() {
    //given
    String inputString = "<? xml ?><tagname param = \"param 'value'\"/>";

    //when
    handler = new Handler() {
      @Override
      public void handle(TagElement tagElement) {
        myTagElement = tagElement;
      }
    };
    builder.onSingleTag(handler);
    parser = builder.build();
    parser.parse(inputString);
    assertEquals("tagname", myTagElement.getName());
  }
}
