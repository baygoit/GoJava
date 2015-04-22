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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class LongXMLStringTest {
  Map<String, List<Element>> actual = new HashMap<>();
  Map<String, List<Element>> expected = new HashMap<>();
  XMLParser.Builder builder;
  Parser parser;

  @Before
  public void crateVariables() {
    builder = XMLParser.Builder.newParserBuilder();
  }

  @Before
  public void fillExpectedMap() {
    final TagElement tagElement1 = new TagElement();
    tagElement1.setType(TagElementType.HEADER);
    tagElement1.setName("xml");
    tagElement1.setParams(new HashMap<String, String>() {{
      put("version", "1.0");
      put("encoding", "UTF-8");
      put("standalone", "no");
    }});
    expected.put("onStart", new ArrayList<Element>() {{
      add(tagElement1);
    }});

    final TagElement tagElement2 = new TagElement();
    tagElement2.setType(TagElementType.OPEN);
    tagElement2.setName("tagname");
    expected.put("onOpenTag", new ArrayList<Element>() {{
      add(tagElement2);
    }});

    final TextElement textElement1 = new TextElement("TextValue");
    expected.put("onTextValue", new ArrayList<Element>() {{
      add(textElement1);
    }});

    final TagElement tagElement3 = new TagElement();
    tagElement3.setType(TagElementType.CLOSE);
    tagElement3.setName("tagname");
    expected.put("onCloseTag", new ArrayList<Element>(){{
      add(tagElement3);
    }});

    final TextElement textElement2 = new TextElement("Incorrect XML code");
    expected.put("onError", new ArrayList<Element>(){{
      add(textElement2);
    }});
  }

  @Test
  public void fullTest() {
    String inputString =
            "<? xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\" ?>" +
            "<tagname>Text<!--comment_text-->Value</tagname>" +
            "<tagname2>Text Value</tagname2>";

    builder.onStart(new Handler() {
      @Override
      public void handle(Element element) {
        String event = "onStart";
        List<Element> list = actual.get(event);
        if (list == null) {
          list = new ArrayList<>();
        }
        list.add(element);
        actual.put(event, list);
      }
    });
    builder.onEnd(new Handler() {
      @Override
      public void handle(Element element) {
        String event = "onEnd";
        List<Element> list = actual.get(event);
        if (list == null) {
          list = new ArrayList<>();
        }
        list.add(element);
        actual.put(event, list);
      }
    });
    builder.onOpenTag(new Handler() {
      @Override
      public void handle(Element element) {
        String event = "onOpenTag";
        List<Element> list = actual.get(event);
        if (list == null) {
          list = new ArrayList<>();
        }
        list.add(element);
        actual.put(event, list);
      }
    });
    builder.onCloseTag(new Handler() {
      @Override
      public void handle(Element element) {
        String event = "onCloseTag";
        List<Element> list = actual.get(event);
        if (list == null) {
          list = new ArrayList<>();
        }
        list.add(element);
        actual.put(event, list);
      }
    });
    builder.onSingleTag(new Handler() {
      @Override
      public void handle(Element element) {
        String event = "onSingleTag";
        List<Element> list = actual.get(event);
        if (list == null) {
          list = new ArrayList<>();
        }
        list.add(element);
        actual.put(event, list);
      }
    });
    builder.onError(new Handler() {
      @Override
      public void handle(Element element) {
        String event = "onError";
        List<Element> list = actual.get(event);
        if (list == null) {
          list = new ArrayList<>();
        }
        list.add(element);
        actual.put(event, list);
      }
    });
    builder.onTextValue(new Handler() {
      @Override
      public void handle(Element element) {
        String event = "onTextValue";
        List<Element> list = actual.get(event);
        if (list == null) {
          list = new ArrayList<>();
        }
        list.add(element);
        actual.put(event, list);
      }
    });

    parser = builder.build();
    parser.parse(inputString);

    assertEquals(expected.toString(), actual.toString());
  }
}
