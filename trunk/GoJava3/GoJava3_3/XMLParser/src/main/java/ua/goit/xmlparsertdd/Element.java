package ua.goit.xmlparsertdd;

import java.util.Map;

public abstract class Element {
  String getValue() {
    return null;
  }

  String getName() {
    return null;
  }

  TagElementType getType() {
    return null;
  }

  Map<String, String> getParams() {
    return null;
  }
}
