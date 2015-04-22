package ua.goit.xmlparsertdd;

import org.junit.Before;
import org.junit.Test;
import ua.goit.xmlparsertdd.elements.Element;
import ua.goit.xmlparsertdd.elements.TagElement;
import ua.goit.xmlparsertdd.elements.TextElement;
import ua.goit.xmlparsertdd.elements.TagElementType;
import ua.goit.xmlparsertdd.handlers.Handler;
import ua.goit.xmlparsertdd.parsers.Parser;
import ua.goit.xmlparsertdd.parsers.XMLParser;

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
  public void givenOpenTag_WhenParse_ThenNameOfTheTagEqualsNameOfTheInputTag() {
    String inputString = "<name>";

    handler = new Handler() {
      @Override
      public void handle(Element element) {
        myElement = element;
      }
    };
    builder.onOpenTag(handler);
    parser = builder.build();
    parser.parse(inputString);

    assertEquals("name", myElement.getName());
  }

  @Test
  public void givenOpenTag_WhenParse_ThenTypeOfTheTagEqualsOPEN() {
    String inputString = "<name>";

    handler = new Handler() {
      @Override
      public void handle(Element element) {
        myElement = element;
      }
    };
    builder.onOpenTag(handler);
    parser = builder.build();
    parser.parse(inputString);
    TagElementType actual = myElement.getType();
    TagElementType expected = TagElementType.OPEN;

    assertEquals(expected, actual);
  }

  @Test
  public void givenCloseTag_WhenParse_ThenNameOfTheTagEqualsNameOfTheInputTag() {
    String inputString = "<name></name>";

    handler = new Handler() {
      @Override
      public void handle(Element element) {
        myElement = element;
      }
    };
    builder.onCloseTag(handler);
    parser = builder.build();
    parser.parse(inputString);

    assertEquals("name", myElement.getName());
  }

  @Test
  public void givenCloseTag_WhenHandleSetsTypeOfTag_ThenTypeOfTheTagEqualsCLOSE() {

    String inputString = "<name></name>";

    handler = new Handler() {
      @Override
      public void handle(Element element) {
        myElement = element;
      }
    };
    builder.onCloseTag(handler);
    parser = builder.build();
    parser.parse(inputString);
    TagElementType actual = myElement.getType();
    TagElementType expected = TagElementType.CLOSE;

    assertEquals(expected, actual);
  }

  @Test
  public void givenHeader_WhenParse_ThenTypeOfTheTagEqualsHEADER() {
    String inputString = "<? xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\" ?>";

    handler = new Handler() {
      @Override
      public void handle(Element element) {
        myElement = element;
      }
    };
    builder.onStart(handler);
    parser = builder.build();
    parser.parse(inputString);
    TagElementType actual = myElement.getType();
    TagElementType expected = TagElementType.HEADER;

    assertEquals(expected, actual);
  }

  @Test
  public void givenHeader_WhenParse_ThenCompareExpectedAndActualTagElements() {
    String inputString = "<? xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\" ?>";

    TagElement expectedElement = new TagElement();
    expectedElement.setName("xml");
    Map<String, String> params = new HashMap<>();
    params.put("version", "1.0");
    params.put("encoding", "UTF-8");
    params.put("standalone", "no");
    expectedElement.setParams(params);
    expectedElement.setType(TagElementType.HEADER);

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

    assertEquals(expectedElement, actualElement);
  }

  @Test
  public void givenValidTagWithTextValue_WhenParseWholeTag_ThenOnTextValueInvoked() {
    String inputString = "<? xml ?><tagname>TextValue</tagname>";

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

  @Test
  public void givenTagWithAttributes_WhenParseWholeTag_ThenOnOpenTagInvokedAndCheckAttributes() {
    String inputString = "<? xml ?><tagname param = \"param value\">TextValue</tagname>";

    handler = new Handler() {
      @Override
      public void handle(Element element) {
        myElement = element;
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


  @Test
  public void givenTagWithSingleTagElement_WhenParseWholeTag_ThenOnSingleTagInvokedAndCheckName() {
    String inputString = "<? xml ?><tagname param = \"param 'value'\"/>";

    handler = new Handler() {
      @Override
      public void handle(Element element) {
        myElement = element;
      }
    };
    builder.onSingleTag(handler);
    parser = builder.build();
    parser.parse(inputString);

    assertEquals("tagname", myElement.getName());
  }

  @Test
  public void givenErrorSingleTag_WhenParse_ThenOnErrorTagInvoked() {
    String inputString = "<? xml ?><tagname param = \"param 'value'\"/6>";

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

    assertEquals("XML Syntax Error", actual);
  }
  
  @Test
  public void givenCommentInsideTextValue() {
    String inputString = "<? xml ?><tagname>Text<!--comment_text-->Value</tagname>";

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

  @Test
  public void checkOnValidEndOfString() {
    String inputString = "<? xml ?><tagname>Text<!--comment_text-->Value</tagname>";

    handler = new Handler() {
      @Override
      public void handle(Element element) {
        myElement = element;
      }
    };
    builder.onEnd(handler);
    parser = builder.build();
    parser.parse(inputString);
    TextElement expected = new TextElement("Parsing success");

    assertEquals(expected, myElement);
  }
}
