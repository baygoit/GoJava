package ua.com.goit.gojava.m__jane.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlElements;

import ua.com.goit.gojava.m__jane.model.question.ClosedQuestion;
import ua.com.goit.gojava.m__jane.model.question.OpenQuestion;
import ua.com.goit.gojava.m__jane.model.question.Question;

@XmlAccessorType(XmlAccessType.FIELD)
public class QuestionCategory {
	
	@XmlAttribute
	private int id;
	@XmlAttribute
	private String name;
	
	@XmlElements(value = {@XmlElement(name = "question", type=OpenQuestion.class),@XmlElement(name = "question", type=ClosedQuestion.class)})	
	@XmlElementWrapper(name = "questions")
	private List<Question> QuestionList;

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

	public List<Question> getQuestionList() {
		return QuestionList;
	}

	public void setQuestionList(List<Question> questionList) {
		QuestionList = questionList;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	@Override
	public String toString() {
		
		return new StringBuilder()
				.append("QuestionCategory [id=").append(id)
				.append(", name=").append(name)
				.append(", QuestionList=").append(QuestionList)
				.append(", profile=").append(profile).append("]")
				.toString();
		
	}

	
	
}
