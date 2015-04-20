package ua.goit.xmlparsertdd;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LongXMLStringTest {
  Map<String, List<Element>> actual;
  Map<String, List<Element>> expected;
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

    for (int i = 0; i < actual.size(); i++) {
      System.out.println(actual.get(i).toString());
    }
  }
}
