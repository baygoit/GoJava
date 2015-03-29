package ua.goit.xmlparser;

import java.util.HashMap;
import java.util.Map;

public class Tag {
  private TagType type;
  private String name;
  private Map<String, String> params = new HashMap<String, String>();

  public Tag(TagType type, String name, Map<String, String> params) {
    this.type = type;
    this.name = name;
    this.params = params;
  }

  public String add(String param, String value) {
    return params.put(param, value);
  }

  public String remove(String param) {
    return params.remove(param);
  }

  public TagType getType() {
    return type;
  }

  public void setType(TagType type) {
    this.type = type;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Map<String, String> getParams() {
    return params;
  }

  public void setParams(Map<String, String> params) {
    this.params = params;
  }
}
