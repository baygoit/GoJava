package ua.goit.xmlparser;

import java.util.HashMap;
import java.util.Map;

public class TagParser {
  private TagType type;
  private String name;
  private Map<String, String> params;


  public Tag parse(String tag) {
    char firstChar = tag.charAt(0);
    char lastChar = tag.charAt(tag.length() - 1);

    if ('?' == firstChar) {
      type = TagType.HEADER;
      return new Tag(tag, type);
    } else if ('/' == firstChar) {
      type = TagType.CLOSE;
      name = tag.substring(1);
      return new Tag(type, name);
    } else if ('/' == lastChar) {
      type = TagType.SINGLE;
      tag = tag.substring(0, tag.length() - 1);
      params = parseParams(tag);
      return new Tag(type, name, params);
    } else {
      type = TagType.OPEN;
      params = parseParams(tag);
      return new Tag(type, name, params);
    }
  }

  public Map<String, String> parseParams(String tag) {
    String[] partsOfTag = tag.split(" ");
    name = partsOfTag[0];
    Map<String , String > params = new HashMap<String, String>();

    for (int i = 1; i < partsOfTag.length; i++) {
      String[] partsOfParam = partsOfTag[i].split("=");
      if (partsOfParam.length == 2) {
        String value = partsOfParam[1].substring(1, partsOfParam[1].length() - 1);
        params.put(partsOfParam[0], value);
      } else {
        throw new IllegalArgumentException();
      }
    }

    return params;
  }
}
