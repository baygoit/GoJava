package ua.goit.alg.xmlparser.parser;

import java.util.HashMap;

import javax.xml.parsers.SAXParser;
import javax.xml.transform.sax.SAXSource;

public class ParserData {
  String tag;
  HashMap<String, String> attributes;
  String text;
  Object e = new Object();
}
