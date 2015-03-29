package ua.goit.xmlparser;

import java.util.HashMap;
import java.util.Map;

public class TagParser {

  public Tag parse(String tag) {
    TagType type;
    char firstChar = tag.charAt(0);
    char lastChar = tag.charAt(tag.length() - 1);
    if ('?' == firstChar) {
      type = TagType.HEADER;
    } else if ('/' == firstChar) {
      type = TagType.CLOSE;
    } else if ('/' == lastChar) {
      type = TagType.SINGLE;
    } else {
      type = TagType.OPEN;
    }

    String[] partsOfTag = tag.split(" ");
    String name = partsOfTag[0];

    Map<String , String > params = new HashMap<String, String>();
    for (int i = 1; i < partsOfTag.length; i++) {
      String[] partsOfParam = partsOfTag[i].split("=");
      String value = partsOfParam[1].substring(1, partsOfParam[1].length() - 1);
      params.put(partsOfParam[0], value);
    }

    return new Tag(type, name, params);
  }
}
