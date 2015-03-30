package ua.goit.alg.xmlparser.parser;

import java.util.HashMap;

public class ParserData {
  public String getTag() {
    return tag;
  }
  public void setTag(String tag) {
    this.tag = tag;
  }
  public HashMap<String, String> getAttributes() {
    return attributes;
  }
  public void setAttributes(HashMap<String, String> attributes) {
    this.attributes = attributes;
  }
  public String getText() {
    return text;
  }
  public void setText(String text) {
    this.text = text;
  }
  String tag;
  HashMap<String, String> attributes;
  String text;
}
