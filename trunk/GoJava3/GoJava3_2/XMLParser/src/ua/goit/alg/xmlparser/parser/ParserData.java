package ua.goit.alg.xmlparser.parser;

import java.util.HashMap;

public class ParserData {

  String tag = "";
  HashMap<String, String> attributes = new HashMap<String, String>();
  String text = "";
  String attributeName = "";
  String attributeValue = "";

  public String getTag() {
    return tag;
  }

  public void setTag(String tag) {
    this.tag = tag;
  }

  public HashMap<String, String> getAttributes() {
    return attributes;
  }

  public void addAttribute(String key, String value) {
    this.attributes.put(key, value);
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public void clear() {
    setTag("");
    setText("");
    attributes.clear();
  }
}
