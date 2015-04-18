package ua.goit.xmlparsertdd;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class LongXMLStringTest {
  Element myElement;
  Handler handler;
  Map<String, List> actual;
  Map<String, List> expected;

  XMLParser.Builder builder;
  Parser parser;

  @Before
  public void crateVariables() {
    builder = XMLParser.Builder.newParserBuilder();
  }

  @Test
  public void fullTest() {
    String inputString =
            "<? xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\" ?>" +
            "<tagname>Text<!--comment_text-->Value</tagname>" +
            "<tagname2>Text Value</tagname2>";
    handler = new Handler() {
      @Override
      public void handle(Element element) {
        myElement = element;
      }
    };
    builder.onStart(new Handler() {
      @Override
      public void handle(Element element) {
        String event = "onStart";
        List<Element> list = actual.get(event);
        if (list == null) {
          list = new ArrayList<Element>();
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
          list = new ArrayList<Element>();
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
          list = new ArrayList<Element>();
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
          list = new ArrayList<Element>();
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
          list = new ArrayList<Element>();
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
          list = new ArrayList<Element>();
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
          list = new ArrayList<Element>();
        }
        list.add(element);
        actual.put(event, list);
      }
    });

    parser = builder.build();
    parser.parse(inputString);

    assertEquals("tagname1", myElement.getName());
  }
}
