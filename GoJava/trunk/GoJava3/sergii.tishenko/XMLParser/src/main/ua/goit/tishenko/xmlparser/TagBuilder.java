package ua.goit.tishenko.xmlparser;

import java.util.HashMap;
import java.util.Map;

public class TagBuilder {

  String name = "";
  String param = "";
  String param_value = "";
  
  TagType tagType;
  
  
  Map<String, String> params = new HashMap<String, String>();
  
  StringBuilder current = new StringBuilder();
  StringBuilder comment = new StringBuilder();

 
 void reset() {
    tagType = null;
    name = "";
    param = "";
    param_value = "";
    params = new HashMap<String, String>();
    current = new StringBuilder();
  }

 void addCharToCurrent(char symb) {
    current.append(symb);
  }

 void makeName() {
    
    name = current.toString().trim();
    current = new StringBuilder();
    
  }

 void makeParamName() {
    param = current.toString().trim();
    current = new StringBuilder();
  }

 void makeParamValue() {
    param_value = current.substring(1);
    params.put(param, param_value);
    current = new StringBuilder();
    
  }
 void setTagType(TagType tt) {
    tagType = tt;
  }
  
 Tag makeTag() {
    if(tagType == TagType.COMMENT)
    {
      name= name.substring(1, name.length() - 1).trim();
    }
    
    Tag result = new Tag(tagType, name, params);
    reset();
    return result;
  }
  
 TagType getTagType() {
    return tagType;
  } 
  
}
