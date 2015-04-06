package ua.goit.alg.xmlparser;

import java.io.BufferedReader;

import java.io.Reader;


public class XMLParser {
	
		
	StateMachine avtomat = new StateMachine();
	
	public void onOpenTag(ParserData data){
		System.out.println(data.tag+data.attributeName+data.attributeValue);
	}
	
	public void onText(ParserData data){
		System.out.println(data.text);
	}
	
	public void onCloseTag(ParserData data){
		System.out.println('\n');
	}
	
	public void onEnd(ParserData data){
	//	in.close();
	}

}
