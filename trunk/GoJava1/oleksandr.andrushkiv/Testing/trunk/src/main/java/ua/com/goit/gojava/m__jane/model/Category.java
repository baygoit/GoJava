package ua.com.goit.gojava.m__jane.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlIDREF;

import ua.com.goit.gojava.m__jane.model.question.MultipleQuestion;
import ua.com.goit.gojava.m__jane.model.question.SimpleQuestion;
import ua.com.goit.gojava.m__jane.model.question.Question;

@XmlAccessorType(XmlAccessType.FIELD)
public class Category {
	
	@XmlAttribute
	private Integer id;
	@XmlID
	@XmlAttribute
	private String name;
	
	@XmlIDREF
	//@XmlElements(value = {@XmlElement(name = "questionMu", type=MultipleQuestion.class), @XmlElement(name = "questionSi", type=SimpleQuestion.class)})	
	@XmlElements(value = {@XmlElement(name = "questionMu", type=MultipleQuestion.class)})
	//@XmlElements(value = {@XmlElement(name = "questionSi", type=SimpleQuestion.class)})
	@XmlElementWrapper(name = "questions")
	private List<Question> questionList;

	public Category() {
	}
	
	public Category(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public List<Question> getQuestionList() {
		return questionList;
	}

	public void setQuestionList(List<Question> questionList) {
		this.questionList = questionList;
	}

	@Override
	public String toString() {
		
		return new StringBuilder()
				.append("QuestionCategory [id=").append(id)
				.append(", name=").append(name)
				.append(", questionList=").append(questionList)
				.append("]")
				.toString();
		
	}

	
	
}
