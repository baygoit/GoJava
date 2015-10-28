package ua.goit.alg.parser;

import java.io.IOException;

import org.junit.Test;

public class XMLParserTest {

    @Test

    public void parserTest() throws IOException {
	XmlParser parser = new XmlParserImpl();

	parser.onOpenTag(new Handler() {

	    public void handle(Tag tag) {
		System.out.println("<"+tag.getTag()+" "+tag.getAttributeName()+" =\""+tag.getAttributeValue()+">");
	    }
	});
	parser.onTextValue(new Handler() {

	    public void handle(Tag tag) {
		System.out.println(tag.getText());
	    }
	});

	parser.onCloseTag(new Handler() {

	    public void handle(Tag tag) {
		System.out.println("</"+tag.getTag()+">");
	    }
	});

	//parser.parse("<?xml version=\"1.0\"><form></form>");
	parser.parse("<?><note w=\"fff\">text</note> ");
    }


}


