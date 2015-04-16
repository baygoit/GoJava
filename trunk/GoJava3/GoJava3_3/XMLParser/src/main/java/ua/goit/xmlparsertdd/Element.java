package ua.goit.xmlparsertdd;

import java.util.Map;

public abstract class Element {
  String getValue() {
    throw  new UnsupportedOperationException("Method getValue is unsupported");
  }

  String getName() {
    throw  new UnsupportedOperationException("Method getValue is unsupported");
  }

  TagElementType getType() {
    throw  new UnsupportedOperationException("Method getValue is unsupported");
  }

  Map<String, String> getParams() {
    throw  new UnsupportedOperationException("Method getValue is unsupported");
  }
}
