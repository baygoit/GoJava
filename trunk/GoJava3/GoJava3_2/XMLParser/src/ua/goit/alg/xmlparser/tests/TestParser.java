package ua.goit.alg.xmlparser.tests;

import org.junit.Assert;
import org.junit.Test;

import ua.goit.alg.xmlparser.parser.XMLParser;

public class TestParser {

  @Test
  public void testSimple(){
    XMLParser parser = new XMLParser();
    String result = parser.parse("<tag></tag>");
    String expectedResult = "tag";
    Assert.assertEquals(expectedResult, result);
 
  }
}
  
