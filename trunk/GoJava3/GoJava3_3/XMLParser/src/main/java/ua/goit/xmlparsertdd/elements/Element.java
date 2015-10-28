package ua.goit.xmlparsertdd.elements;

import java.util.Map;

public abstract class Element {
  public String getValue() {
    throw new UnsupportedOperationException("Method getValue is unsupported");
  }

  public String getName() {
    throw new UnsupportedOperationException("Method getName is unsupported");
  }

  public TagElementType getType() {
    throw new UnsupportedOperationException("Method getType is unsupported");
  }

  public Map<String, String> getParams() {
    throw new UnsupportedOperationException("Method getParams is unsupported");
  }
}
