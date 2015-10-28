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
import static org.junit.Assert.assertTrue;

public class InvalidEndTest {
  Element myElement;
  XMLParser.Builder builder;
  Parser parser;

  @Before
  public void crateVariables() {
    builder = XMLParser.Builder.newParserBuilder();
  }

  @Test
  public void givenXmlWithTwoRootTags_WhenParsing_ThenOnErrorHandlerReceivesMessage() {
    String inputString =
            "<? xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\" ?>" +
            "<tagname>Text<!--comment_text-->Value</tagname>" +
            "<tagname2>Text Value</tagname2>";

    builder.onError(new Handler() {
      @Override
      public void handle(Element element) {
        myElement = element;
      }
    });

    parser = builder.build();
    parser.parse(inputString);
    TextElement expected = new TextElement("Incorrect XML code");

    assertEquals(expected, myElement);
  }

  @Test
  public void givenXmlWithUnclosedTag_WhenParsing_ThenOnErrorHandlerReceivesMessage() {
    String inputString =
        "<web-app>\n" +
            "  <display-name>Kickstarter edu project</display-name>\n" +
            "  \n" +
            "  <servlet>\n" +
            "    <servlet-name>ProjectServlet</servlet-name>\n" +
            "    <servlet-class>ua.goit.java3_3.kickstarter.servlet.ProjectServlet</servlet-class>\n" +
            "  </servlet>\n" +
            "  \n" +
            "  <servlet-mapping>\n" +
            "    <servlet-name>ProjectServlet</servlet-name>\n" +
            "    <url-pattern>/project/*</url-pattern>\n" +
            "  </servlet-mapping>";

    builder.onError(new Handler() {
      @Override
      public void handle(Element element) {
        myElement = element;
      }
    });

    parser = builder.build();
    parser.parse(inputString);
    TextElement expected = new TextElement("Some tags aren't closed");

    assertEquals(expected, myElement);
  }
}
