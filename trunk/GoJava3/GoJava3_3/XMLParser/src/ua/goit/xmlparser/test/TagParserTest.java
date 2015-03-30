package ua.goit.xmlparser.test;

import org.junit.Test;
import ua.goit.xmlparser.Tag;
import ua.goit.xmlparser.TagParser;
import ua.goit.xmlparser.TagType;

import java.util.HashMap;
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
    String openTag = "tagname param1=\"value1\" param2=\"value2\"";
    TagParser tagParser = new TagParser();
    Tag tag = tagParser.parse(openTag);
    Map<String, String> map = tag.getParams();
    assertEquals(2, map.size());
  }

  @Test
  public void parseParamsTest() {
    String tag = "tagname param1=\"value1\" param2=\"value2\"";
    TagParser tagParser = new TagParser();
    Map<String, String> expected = new HashMap<String, String>();
    expected.put("param1", "value1");
    expected.put("param2", "value2");
    Map<String, String> actual = tagParser.parseParams(tag);
    assertEquals(expected, actual);
  }

  @Test
  public void parseHeaderTest() {
    String header = "? xml encoding=\"utf-8\"?";
    Tag expected = new Tag(header, TagType.HEADER);
    TagParser tagParser = new TagParser();
    Tag actual = tagParser.parse(header);
    assertEquals(expected, actual);
  }

  @Test
  public void parseCloseTest() {
    String close = "/tagname";
    Tag expected = new Tag(TagType.CLOSE, "tagname");
    TagParser tagParser = new TagParser();
    Tag actual = tagParser.parse(close);
    assertEquals(expected, actual);
  }

  @Test
  public void parseSingleTest() {
    String single = "tagname param1=\"value1\"/";
    TagParser tagParser = new TagParser();
    String name = "tagname";
    Map<String, String> params = new HashMap<String, String>();
    params.put("param1", "value1");
    Tag expected = new Tag(TagType.SINGLE, name, params);
    Tag actual = tagParser.parse(single);
    assertEquals(expected, actual);
  }

  @Test
  public void parseOpenTest() {
    String open = "tagname param1=\"value1\"";
    TagParser tagParser = new TagParser();
    String name = "tagname";
    Map<String, String> params = new HashMap<String, String>();
    params.put("param1", "value1");
    Tag expected = new Tag(TagType.OPEN, name, params);
    Tag actual = tagParser.parse(open);
    assertEquals(expected, actual);
  }
  
  @Test (expected=IllegalArgumentException.class)
  public void parseParamExceptionTest() {
    String openTag = "tagname param1= param2=\"value2\"";
    TagParser tagParser = new TagParser();
    Tag tag = tagParser.parse(openTag);
    Map<String, String> map = tag.getParams();
    assertEquals(2, map.size());
  }
  
  @Test (expected=IllegalArgumentException.class)
  public void parseParamExceptionTest2() {
    String openTag = "tagname param1 param2=\"value2\"";
    TagParser tagParser = new TagParser();
    Tag tag = tagParser.parse(openTag);
    Map<String, String> map = tag.getParams();
    assertEquals(2, map.size());
  }
  
  @Test (expected=IllegalArgumentException.class)
  public void parseParamExceptionTest3() {
    String openTag = "tagname param2==\"value2\"";
    TagParser tagParser = new TagParser();
    Tag tag = tagParser.parse(openTag);
    Map<String, String> map = tag.getParams();
    assertEquals(2, map.size());
  }
 
  
  @Test
  public void parseParamDoubleSpaceTest() {
    String openTag = "tagname   param1=\"value1\" param2=\"value2\"";
    TagParser tagParser = new TagParser();
    Tag tag = tagParser.parse(openTag);
    Map<String, String> map = tag.getParams();
    assertEquals(2, map.size());
  }

  @Test
  public void parseExtraSpacesTest() {
    String singleTag = " tagname   param1=\"value1\" param2=\"value2\" /";
    TagParser tagParser = new TagParser();
    Tag tag = tagParser.parse(singleTag);
    Map<String, String> map = tag.getParams();
    assertEquals(2, map.size());
  }

}
