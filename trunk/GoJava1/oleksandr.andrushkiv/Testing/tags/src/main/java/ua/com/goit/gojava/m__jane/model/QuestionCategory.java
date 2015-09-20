package ua.com.goit.gojava.m__jane.model;

public class QuestionCategory {
	private int id;
	
	private String name;

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


}
