package ua.goit.xmlparser;

import java.util.HashMap;
import java.util.Map;

public class TagParser {

  //This method need to finalize (доработать)
  public Tag parse(String tag) {
    TagType type = TagType.OPEN;
    String name = "tagname";
    Map<String , String > params = new HashMap<String, String>();
    params.put("param", "value");

    return new Tag(type, name, params);
  }
}
