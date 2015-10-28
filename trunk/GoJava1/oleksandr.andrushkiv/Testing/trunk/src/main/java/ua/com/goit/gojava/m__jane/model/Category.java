package ua.com.goit.gojava.m__jane.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlIDREF;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import ua.com.goit.gojava.m__jane.model.question.Question;
import ua.com.goit.gojava.m__jane.utils.IDAdapter;

@XmlAccessorType(XmlAccessType.FIELD)
public class Category {
	
	@XmlID
	@XmlAttribute
	@XmlJavaTypeAdapter(IDAdapter.class)
	private Integer id;
	
	@XmlAttribute
	private String name;
	
	@XmlIDREF
	@XmlElement(name = "question")
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
				//.append(", questionList=").append(questionList)
				.append("]")
				.toString();
		
	}

	
	
}
