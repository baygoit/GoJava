package ua.com.goit.gojava.m__jane.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;


@XmlAccessorType(XmlAccessType.FIELD)
public class OpenQuestion extends Question {

	//private Anwer anwer;

	@Override
	public String toString() {
		return "OpenQuestion [getContent()=" + getContent() + "]";
	}
	
	
}
