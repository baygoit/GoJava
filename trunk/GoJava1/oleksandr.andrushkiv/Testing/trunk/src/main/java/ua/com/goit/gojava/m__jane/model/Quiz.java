package ua.com.goit.gojava.m__jane.model;

import java.util.List;

public class Quiz {

	private Integer id;
	private String name;
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
	
}
