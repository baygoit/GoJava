package ua.com.goit.gojava.m__jane.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

@XmlAccessorType(XmlAccessType.FIELD)
public class QuestionCategory {
	
	@XmlAttribute
	private int id;
	@XmlAttribute
	private String name;
	
	@XmlElement(name = "question")
	@XmlElementWrapper(name = "questions")
	private List<Question> Questions;
	
	private Profile profile;

	public QuestionCategory() {
	}
	
	public QuestionCategory(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Question> getQuestions() {
		return Questions;
	}

	public void setQuestions(List<Question> questions) {
		Questions = questions;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	@Override
	public String toString() {
		return "QuestionCategory [id=" + id + ", name=" + name;
	}

	
}
