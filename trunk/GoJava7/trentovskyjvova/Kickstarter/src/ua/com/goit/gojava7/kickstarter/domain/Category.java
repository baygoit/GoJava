package ua.com.goit.gojava7.kickstarter.domain;

public class Category {
	private int id;
	private String name;

	public Category() {

	}

	public String getName() {
		return name;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

}
