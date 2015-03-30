package ua.goit.xmlparser;

import java.util.HashMap;
import java.util.Map;

public class Tag {
  private String tag;
  private TagType type;
  private String name;
  private Map<String, String> params = new HashMap<String, String>();

  public Tag() {
  }

  public Tag(TagType type, String name) {
    this.type = type;
    this.name = name;
  }

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

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Tag tag1 = (Tag) o;

    if (tag != null ? !tag.equals(tag1.tag) : tag1.tag != null) return false;
    if (getType() != tag1.getType()) return false;
    if (getName() != null ? !getName().equals(tag1.getName()) : tag1.getName() != null)
      return false;
    return !(getParams() != null ? !getParams().equals(tag1.getParams()) : tag1.getParams() != null);

  }

  @Override
  public int hashCode() {
    int result = tag != null ? tag.hashCode() : 0;
    result = 31 * result + (getType() != null ? getType().hashCode() : 0);
    result = 31 * result + (getName() != null ? getName().hashCode() : 0);
    result = 31 * result + (getParams() != null ? getParams().hashCode() : 0);
    return result;
  }
}
