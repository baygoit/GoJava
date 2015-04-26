package ua.goit.xmlparsertdd;

import org.junit.Before;
import org.junit.Test;
import ua.goit.xmlparsertdd.elements.Element;
import ua.goit.xmlparsertdd.elements.TextElement;
import ua.goit.xmlparsertdd.handlers.Handler;
import ua.goit.xmlparsertdd.parsers.Parser;
import ua.goit.xmlparsertdd.parsers.XMLParser;

import static org.junit.Assert.assertEquals;

public class ValidEndTest {
  Element myElement;
  Handler handler;
  XMLParser.Builder builder;
  Parser parser;

  @Before
  public void crateVariables() {
    builder = XMLParser.Builder.newParserBuilder();
  }

  @Test
  public void checkOnValidEndOfString() {
    String inputString = "<project xmlns=\"http://maven.apache.org/POM/4.0.0\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"\n" +
        "         xsi:schemaLocation=\"http://maven.apache.org/POM/4.0.0 http://maven.apache.org/maven-v4_0_0.xsd\">\n" +
        "    <modelVersion>4.0.0</modelVersion>\n" +
        "    <groupId>goit</groupId>\n" +
        "    <artifactId>xmlparser</artifactId>\n" +
        "    <packaging>jar</packaging>\n" +
        "    <version>0.0.1-SNAPSHOT</version>\n" +
        "    <name>XMLParser</name>\n" +
        "    <dependencies>\n" +
        "        <dependency>\n" +
        "            <groupId>junit</groupId>\n" +
        "            <artifactId>junit</artifactId>\n" +
        "            <version>4.11</version>\n" +
        "            <scope>test</scope>\n" +
        "        </dependency>\n" +
        "    </dependencies>\n" +
        "    <build>\n" +
        "        <finalName>XMLParser</finalName>\n" +
        "        <plugins>\n" +
        "            <plugin>\n" +
        "                <groupId>org.apache.maven.plugins</groupId>\n" +
        "                <artifactId>maven-compiler-plugin</artifactId>\n" +
        "                <version>2.3.2</version>\n" +
        "                <configuration>\n" +
        "                    <source>1.7</source>\n" +
        "                    <target>1.7<!--Some comments--></target>\n" +
        "                </configuration>\n" +
        "            </plugin>\n" +
        "        </plugins>\n" +
        "    </build>\n" +
        "</project>";

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
