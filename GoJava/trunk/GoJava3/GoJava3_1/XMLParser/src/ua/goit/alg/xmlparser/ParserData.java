package ua.goit.alg.xmlparser;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;


public class ParserData {
	
	
	String tag;
	String attributeName;
	String attributeValue;
	
	HashMap<String, String> attribData = new HashMap<String, String>() ;
	String text;
	
public void setTag(String tag){
	this.tag = tag;
}
public String getTag(){
	return tag;
}
public void setAttributeName(String attributeName){
	this.attributeName = attributeName;
}
public String getAttributeName(){
	return attributeName;
}
public void setAttributeValue(String attributeValue){
	this.attributeValue = attributeValue;
}
public String getAttributeValue(){
	return attributeValue;
}
public void setText(String text){
	this.text = text;
	}
public String getText(){
	return text;
}
public void setAttributes(String attributeName, String attributeValue){
	attribData.put(attributeName, attributeValue);
}
public String getAttributes (){
	return attribData.get(attributeName);
}
}

