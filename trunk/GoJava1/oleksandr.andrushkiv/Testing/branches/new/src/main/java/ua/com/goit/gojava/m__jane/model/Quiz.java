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

import ua.com.goit.gojava.m__jane.utils.IDAdapter;

@XmlAccessorType(XmlAccessType.FIELD)
public class Quiz {
	
	@XmlID
	@XmlAttribute
	@XmlJavaTypeAdapter(IDAdapter.class)	
	private Integer id;

	@XmlAttribute
	private String name;
	
	@XmlIDREF
	@XmlElement(name = "questionCategory")
	@XmlElementWrapper(name = "questionCategories")
	private List<Category> categoryList;
	
	//params for counting whole set questions for UserQuiz
	//e.g. amount, maybe latter single class for this needs
	private Integer amountQuestions;
		
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

	public List<Category> getCategoryList() {
		return categoryList;
	}

	public void setCategoryList(List<Category> categoryList) {
		this.categoryList = categoryList;
	}

	public Integer getAmountQuestions() {
		return amountQuestions;
	}

	public void setAmountQuestions(Integer amountQuestions) {
		this.amountQuestions = amountQuestions;
	}

	@Override
	public String toString() {
		return "Quiz [id=" + id + ", name=" + name + "]";
	}
	
	
}
