package ua.goit.xmlparsertdd;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class XMLParserTest {
  Element myElement;
  Handler handler;
  XMLParser.Builder builder;
  Parser parser;

  @Before
  public void crateVariables() {
    builder = XMLParser.Builder.newParserBuilder();
  }

  @Test
  public void givenOpenTag_WhenParse_ThenValueOfTheTagEqualsValueOfTheInputTag() {

    // given
    String inputString = "<name>";

    // when
    handler = new Handler() {
      @Override
      public void handle(Element element) {
        myElement = element;
      }
    };
    builder.onOpenTag(handler);
    parser = builder.build();
    parser.parse(inputString);

    // then
    assertEquals("name", myElement.getValue());
  }

/*  @Test
  public void givenOpenTag_WhenHandleSetsTypeOfTag_ThenTypeOfTheTagEqualsOPEN() {

    // given
    String inputString = "<name>";

    // when
    myElement =  new TagElement();
    handler = new Handler() {
      @Override
      public void handle(Element tagElement) {
        myElement.setType(tagElement.getType());
      }
    };
    builder.onOpenTag(handler);
    parser = builder.build();
    parser.parse(inputString);
    TagElementType actual = myElement.getType();
    TagElementType expected = TagElementType.OPEN;

    // then
    assertEquals(expected, actual);
  }*/

  @Test
  public void givenCloseTag_WhenParse_ThenValueOfTheTagEqualsValueOfTheInputTag() {

    // given
    String inputString = "<name></name>";

    // when
    handler = new Handler() {
      @Override
      public void handle(Element element) {
        myElement = element;
      }
    };
    builder.onCloseTag(handler);
    parser = builder.build();
    parser.parse(inputString);

    // then
    assertEquals("name", myElement.getValue());
  }

/*  @Test
  public void givenCloseTag_WhenHandleSetsTypeOfTag_ThenTypeOfTheTagEqualsCLOSE() {

    // given
    String inputString = "</name>";

    // when
    myElement =  new TagElement();
    handler = new Handler() {
      @Override
      public void handle(Element tagElement) {
        myElement.setType(tagElement.getType());
      }
    };
    builder.onCloseTag(handler);
    parser = builder.build();
    parser.parse(inputString);
    TagElementType actual = myElement.getType();
    TagElementType expected = TagElementType.CLOSE;

    // then
    assertEquals(expected, actual);
  }*/

/*
  @Test
  public void givenHeader_WhenHandleSetsTypeOfTag_ThenTypeOfTheTagEqualsHEADER() {

    // given
    String inputString = "<? xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\" ?>";

    // when
    myElement =  new TagElement();
    handler = new Handler() {
      @Override
      public void handle(Element tagElement) {
        myElement.setType(tagElement.getType());
      }
    };
    builder.onStart(handler);
    parser = builder.build();
    parser.parse(inputString);
    TagElementType actual = myElement.getType();
    TagElementType expected = TagElementType.HEADER;

    // then
    assertEquals(expected, actual);
  }
*/

  @Test
  public void givenHeader_WhenParseTagElement_ThenCompareExpectedAndActualTagElements() {

    // given
    String inputString = "<? xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\" ?>";

    TagElement expectedElement = new TagElement();
    expectedElement.setName("xml");
    Map<String, String> params = new HashMap<>();

    params.put("version", "1.0");
    params.put("encoding", "UTF-8");
    params.put("standalone", "no");
    expectedElement.setParams(params);
    expectedElement.setType(TagElementType.HEADER);
    // when
    handler = new Handler() {
      @Override
      public void handle(Element element) {
        myElement = element;
      }
    };
    builder.onStart(handler);
    parser = builder.build();
    parser.parse(inputString);
    Element actualElement = myElement;

    // then
    assertEquals(expectedElement, actualElement);
  }

  @Test
  public void givenValidTagWithTextValue_WhenParseWholeTag_ThenOnTextValueInvoked() {
    //given
    String inputString = "<? xml ?><tagname>TextValue</tagname>";

    //when
    handler = new Handler() {
      @Override
      public void handle(Element element) {
        myElement = element;
      }
    };
    builder.onTextValue(handler);
    parser = builder.build();
    parser.parse(inputString);
    String expected = "TextValue";
    String actual = myElement.getValue();
    assertEquals(expected,actual);
  }

/*
  @Test
  public void givenTagWithAttributes_WhenParseWholeTag_ThenOnOpenTagInvokedAndCheckAttributes() {
    //given
    String inputString = "<? xml ?><tagname param = \"param value\">TextValue</tagname>";

    //when
    handler = new Handler() {
      @Override
      public void handle(TagElement tagElement) {
        myElement = tagElement;
      }
    };
    builder.onOpenTag(handler);
    parser = builder.build();
    parser.parse(inputString);
    String expected = "param value";
    Map<String, String> params = myElement.getParams();
    String actual = params.get("param");
    assertEquals(expected,actual);
  }
*/


  @Test
  public void givenTagWithSingleTagElement_WhenParseWholeTag_ThenOnSingleTagInvokedAndCheckValue() {
    //given
    String inputString = "<? xml ?><tagname param = \"param 'value'\"/>";

    //when
    handler = new Handler() {
      @Override
      public void handle(Element element) {
        myElement = element;
      }
    };
    builder.onSingleTag(handler);
    parser = builder.build();
    parser.parse(inputString);
    assertEquals("tagname param=\"param 'value'\"", myElement.getValue());
  }

  @Test
  public void givenErrorSingleTag_WhenParse_ThenOnErrorTagInvoked() {
    //given
    String inputString = "<? xml ?><tagname param = \"param 'value'\"/6>";

    //when
    handler = new Handler() {
      @Override
      public void handle(Element element) {
        myElement = element;
      }
    };
    builder.onError(handler);
    parser = builder.build();
    parser.parse(inputString);
    String actual = myElement.getValue();
    assertEquals("XMLSyntaxException caught", actual);
  }
  
  @Test
  public void givenCommentInsideTextValue() {
    //given
    String inputString = "<? xml ?><tagname>Text<!--comment_text-->Value</tagname>";

    //when
    handler = new Handler() {
      @Override
      public void handle(Element element) {
        myElement = element;
      }
    };
    builder.onTextValue(handler);
    parser = builder.build();
    parser.parse(inputString);
    String expected = "TextValue";
    String actual = myElement.getValue();
    assertEquals(expected,actual);
 
  }
}
