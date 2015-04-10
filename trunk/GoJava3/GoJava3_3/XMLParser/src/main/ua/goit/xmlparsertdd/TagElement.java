package ua.goit.xmlparsertdd;


import java.util.HashMap;
import java.util.Map;

public class TagElement {
  private TagElementType type;
  private String name;
  private Map<String, String> params = new HashMap<String, String>();

  public Element1() {
  }

  private Element1(TagElementType type, String name, Map<String, String> params) {
    this.type = type;
    this.name = name;
    this.params = params;
  }

  public void setName(String name) {
    this.name = name;
  }
  
  public void setType(TagElementType type) {
    this.type = type;
  }
  
  public TagElementType getType() {
    return type;
  }

  public String getName() {
    return name;
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

    Element1 element1 = (Element1) o;

        if (getType() != element1.getType()) return false;
    if (getName() != null ? !getName().equals(element1.getName()) : element1.getName() != null)
      return false;
    return !(getParams() != null ? !getParams().equals(element1.getParams()) : element1.getParams() != null);

  }

  @Override
  public int hashCode() {
    int result = getType() != null ? getType().hashCode() : 0;
    result = 31 * result + (getName() != null ? getName().hashCode() : 0);
    result = 31 * result + (getParams() != null ? getParams().hashCode() : 0);
    return result;
  }

  static class Builder {
    private TagElementType type;
    private StringBuilder name = new StringBuilder();
    private Map<String, String> params = new HashMap<String, String>();
    private StringBuilder paramName = new StringBuilder();
    private StringBuilder paramValue = new StringBuilder();

    static Builder newBuilder() {
      return new Builder();
    }

    public TagElementType getType() {
      return type;
    }

    public void setType(TagElementType type) {
      this.type = type;
    }

    public String getName() {
      return name.toString();
    }

    public void buildName(char c) {
      name.append(c);
    }
    
    public void buildParamName(char c) {
      paramName.append(c);
    }
    
    public void buildParamValue(char c) {
      paramValue.append(c);
    }
    
    public void addParams() {
      params.put(paramName.toString(), paramValue.toString());
      paramName = new StringBuilder();
      paramValue = new StringBuilder();
    }

    public Element1 build() {
      return new Element1(type, name.toString(), params);
    }
  }

}
