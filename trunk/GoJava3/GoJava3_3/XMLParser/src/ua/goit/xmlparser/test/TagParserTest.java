package ua.goit.xmlparser.test;

import org.junit.Test;
import ua.goit.xmlparser.Tag;
import ua.goit.xmlparser.TagParser;
import ua.goit.xmlparser.TagType;

import java.util.Map;

import static org.junit.Assert.assertEquals;

public class TagParserTest {

  @Test
  public void parseNameTest() {
    String openTag = "tagname param=\"value\"";
    TagParser tagParser = new TagParser();
    Tag tag = tagParser.parse(openTag);
    assertEquals("tagname", tag.getName());
  }

  @Test
  public void parseTypeTest() {
    String openTag = "tagname param=\"value\"";
    TagParser tagParser = new TagParser();
    Tag tag = tagParser.parse(openTag);
    assertEquals(TagType.OPEN, tag.getType());
  }

  @Test
  public void parseParamTest1() {
    String openTag = "tagname param=\"value\"";
    TagParser tagParser = new TagParser();
    Tag tag = tagParser.parse(openTag);
    Map<String, String> map = tag.getParams();
    assertEquals("value", map.get("param"));
  }

  @Test
  public void parseParamTest2() {
    String openTag = "tagname param=\"value\"";
    TagParser tagParser = new TagParser();
    Tag tag = tagParser.parse(openTag);
    Map<String, String> map = tag.getParams();
    assertEquals(1, map.size());
  }
}
