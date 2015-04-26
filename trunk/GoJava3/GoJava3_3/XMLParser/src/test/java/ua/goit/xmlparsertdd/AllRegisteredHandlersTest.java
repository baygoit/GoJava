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

import static org.junit.Assert.assertTrue;

public class AllRegisteredHandlersTest {
  Map<String, List<Element>> actual;
  Map<String, List<Element>> expected;
  List<Element> headers;
  List<Element> openTags;
  List<Element> singleTags;
  List<Element> closeTags;
  List<Element> textValues;
  List<Element> validEndMessages;
  List<Element> errors;
  XMLParser.Builder builder;
  Parser parser;

  @Before
  public void fillExpectedMap() {
    builder = XMLParser.Builder.newParserBuilder();
    actual = new HashMap<>();
    expected = new HashMap<>();
    headers = new ArrayList<>();
    openTags = new ArrayList<>();
    singleTags = new ArrayList<>();
    closeTags = new ArrayList<>();
    textValues = new ArrayList<>();
    validEndMessages = new ArrayList<>();
    errors = new ArrayList<>();

    final TagElement tagElement1 = new TagElement();
    tagElement1.setType(TagElementType.HEADER);
    tagElement1.setName("xml");
    tagElement1.setParams(new HashMap<String, String>() {{
      put("version", "1.0");
      put("encoding", "UTF-8");
    }});
    headers.add(tagElement1);
    expected.put("onStart", headers);

    final TagElement tagElement2 = new TagElement();
    tagElement2.setType(TagElementType.OPEN);
    tagElement2.setName("log4j:configuration");
    Map<String, String> params2 = new HashMap<>();
    params2.put("debug", "true");
    params2.put("xmlns:log4j", "http://jakarta.apache.org/log4j/");
    tagElement2.setParams(params2);
    openTags.add(tagElement2);
    expected.put("onOpenTag", openTags);

    final TagElement tagElement3 = new TagElement();
    tagElement3.setType(TagElementType.OPEN);
    tagElement3.setName("appender");
    Map<String, String> params3 = new HashMap<>();
    params3.put("name", "console");
    params3.put("class", "org.apache.log4j.ConsoleAppender");
    tagElement3.setParams(params3);
    openTags.add(tagElement3);
    expected.put("onOpenTag", openTags);

    final TagElement tagElement4 = new TagElement();
    tagElement4.setType(TagElementType.OPEN);
    tagElement4.setName("layout");
    Map<String, String> params4 = new HashMap<>();
    params4.put("class", "org.apache.log4j.PatternLayout");
    tagElement4.setParams(params4);
    openTags.add(tagElement4);
    expected.put("onOpenTag", openTags);

    final TagElement tagElement5 = new TagElement();
    tagElement5.setType(TagElementType.SINGLE);
    tagElement5.setName("param");
    Map<String, String> params5 = new HashMap<>();
    params5.put("name", "ConversionPattern");
    params5.put("value", "%d{yyyy-MM-dd HH:mm:ss} %-5p %c{1}:%L - %m%n");
    tagElement5.setParams(params5);
    singleTags.add(tagElement5);
    expected.put("onSingleTag", singleTags);

    final TagElement tagElement6 = new TagElement();
    tagElement6.setType(TagElementType.CLOSE);
    tagElement6.setName("layout");
    closeTags.add(tagElement6);
    expected.put("onCloseTag", closeTags);

    final TagElement tagElement7 = new TagElement();
    tagElement7.setType(TagElementType.CLOSE);
    tagElement7.setName("appender");
    closeTags.add(tagElement7);
    expected.put("onCloseTag", closeTags);

    final TagElement tagElement8 = new TagElement();
    tagElement8.setType(TagElementType.OPEN);
    tagElement8.setName("root");
    openTags.add(tagElement8);
    expected.put("onOpenTag", openTags);

    final TagElement tagElement9 = new TagElement();
    tagElement9.setType(TagElementType.SINGLE);
    tagElement9.setName("level");
    Map<String, String> params9 = new HashMap<>();
    params9.put("value", "DEBUG");
    tagElement9.setParams(params9);
    singleTags.add(tagElement9);
    expected.put("onSingleTag", singleTags);

    final TagElement tagElement10 = new TagElement();
    tagElement10.setType(TagElementType.SINGLE);
    tagElement10.setName("appender-ref");
    Map<String, String> params10 = new HashMap<>();
    params10.put("ref", "console");
    tagElement10.setParams(params10);
    singleTags.add(tagElement10);
    expected.put("onSingleTag", singleTags);

    final TagElement tagElement11 = new TagElement();
    tagElement11.setType(TagElementType.OPEN);
    tagElement11.setName("a");
    openTags.add(tagElement11);
    expected.put("onOpenTag", openTags);

    final TextElement textElement1 = new TextElement(" Some text");
    textValues.add(textElement1);
    expected.put("onTextValue", textValues);

    final TagElement tagElement12 = new TagElement();
    tagElement12.setType(TagElementType.CLOSE);
    tagElement12.setName("a");
    closeTags.add(tagElement12);
    expected.put("onCloseTag", closeTags);

    final TagElement tagElement13 = new TagElement();
    tagElement13.setType(TagElementType.CLOSE);
    tagElement13.setName("root");
    closeTags.add(tagElement13);
    expected.put("onCloseTag", closeTags);

    final TagElement tagElement14 = new TagElement();
    tagElement14.setType(TagElementType.CLOSE);
    tagElement14.setName("log4j:configuration");
    closeTags.add(tagElement14);
    expected.put("onCloseTag", closeTags);

    final TextElement textElement2 = new TextElement("Parsing success");
    validEndMessages.add(textElement2);
    expected.put("onEnd", validEndMessages);
  }

  @Test
  public void givenXml_WhenParse_AllHandlersReceiveExpectedElementsExceptOnError() {
    String inputString =
        "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>" +
            "<log4j:configuration debug=\"true\"" +
                    "xmlns:log4j='http://jakarta.apache.org/log4j/'>" +
                "<appender name=\"console\" class=\"org.apache.log4j.ConsoleAppender\">" +
                    "<layout class=\"org.apache.log4j.PatternLayout\">" +
                        "<param name=\"ConversionPattern\"" +
                                "value=\"%d{yyyy-MM-dd HH:mm:ss} %-5p %c{1}:%L - %m%n\" />" +
                    "</layout>" +
                "</appender>" +
                "<root>" +
                    "<level value=\"DEBUG\" />" +
                    "<appender-ref ref=\"console\" />" +
                    "<!--Comment -->" +
                    "<a> Some text</a>" +
                "</root>" +
            "</log4j:configuration>";

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

    assertTrue(expected.equals(actual));
  }
}
