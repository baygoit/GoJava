package ua.goit.alg.parser;

import java.util.HashMap;

public class Tag {

    String tagName = "";
    String attributeName = "";
    String attributeValue=" = \"";
    HashMap<String, String> attribData = new HashMap<String, String>() ;
    String text = "";

    public void setTag(String tagName) {
	this.tagName = tagName;
    }

    public String getTag() {
	return tagName;
    }

    public void setAttributeName(String attributeName) {
	this.attributeName = attributeName;
    }

    public String getAttributeName() {
	return attributeName;
    }

    public void setAttributeValue(String attributeValue) {
	this.attributeValue = attributeValue;
    }

    public String getAttributeValue() {
	return attributeValue;
    }

    public void setText(String text) {
	this.text = text;
    }

    public String getText() {
	return text;
    }

    public void setAttributes(String attributeName, String attributeValue) {
	attribData.put(attributeName, attributeValue);
    }

    public String getAttributes () {
	return attribData.get(attributeName);
    }
    
    public void clearAll() {
	tagName = "";
    	attributeName = "";
     	attributeValue = "";
        text = "";
    	attribData.clear();
    }
}

